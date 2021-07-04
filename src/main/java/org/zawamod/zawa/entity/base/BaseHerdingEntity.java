package org.zawamod.zawa.entity.base;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public abstract class BaseHerdingEntity extends BaseLandEntity {
    private BaseHerdingEntity groupLeader;
    private int groupSize = 1;

    public BaseHerdingEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new GroupPanicGoal(this, 2.0D));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, PlayerEntity.class, 12.0F, 1.6D, 1.4D, EntityPredicates.NOT_SPECTATING::test));
        this.goalSelector.addGoal(6, new FollowHerdGoal(this));
    }

    public int getMaxSpawnedInChunk() {
        return this.getMaxGroupSize();
    }

    public int getMaxGroupSize() {
        return super.getMaxSpawnedInChunk();
    }

    public boolean hasGroupLeader() {
        return this.groupLeader != null && this.groupLeader.isAlive();
    }

    public BaseHerdingEntity setGroupLeader(BaseHerdingEntity groupLeaderIn) {
        this.groupLeader = groupLeaderIn;
        groupLeaderIn.increaseGroupSize();
        return groupLeaderIn;
    }

    public void leaveGroup() {
        this.groupLeader.decreaseGroupSize();
        this.groupLeader = null;
    }

    private void increaseGroupSize() {
        ++this.groupSize;
    }

    private void decreaseGroupSize() {
        --this.groupSize;
    }

    public boolean canGroupGrow() {
        return this.isGroupLeader() && this.groupSize < this.getMaxGroupSize();
    }

    public void tick() {
        super.tick();
        if (this.isGroupLeader() && this.world.rand.nextInt(200) == 1) {
            List<BaseHerdingEntity> list = this.world.getEntitiesWithinAABB(this.getClass(), this.getBoundingBox().grow(8.0D, 8.0D, 8.0D));
            if (list.size() <= 1)
                this.groupSize = 1;
        }
    }

    public boolean isGroupLeader() {
        return this.groupSize > 1;
    }

    public boolean inRangeOfGroupLeader() {
        return this.getDistanceSq(this.groupLeader) <= 121.0D;
    }

    public void moveToGroupLeader() {
        if (this.hasGroupLeader()) {
            Path path = this.getNavigator().getPathToEntity(this.groupLeader, 6);
            if (path != null) this.getNavigator().setPath(path, 1.0D);
        }
    }

    public void setAllGroupLeader(Stream<BaseHerdingEntity> herdingEntity) {
        herdingEntity.limit((this.getMaxGroupSize() - this.groupSize)).filter((entity) -> entity != this).forEach((entity) -> entity.setGroupLeader(this));
    }

    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
        if (spawnDataIn == null)
            spawnDataIn = new BaseHerdingEntity.GroupData(this);
        else
            this.setGroupLeader(((BaseHerdingEntity.GroupData) spawnDataIn).groupLeader);

        return spawnDataIn;
    }

    public static class GroupData implements ILivingEntityData {
        public final BaseHerdingEntity groupLeader;

        public GroupData(BaseHerdingEntity groupLeader) {
            this.groupLeader = groupLeader;
        }
    }

    static class FollowHerdGoal extends Goal {
        private final BaseHerdingEntity taskOwner;
        private int navigateTimer;
        private int cooldown;

        public FollowHerdGoal(BaseHerdingEntity taskOwner) {
            this.taskOwner = taskOwner;
            this.cooldown = this.getNewCooldown(taskOwner);
        }

        protected int getNewCooldown(BaseHerdingEntity taskOwnerIn) {
            return 200 + taskOwnerIn.getRNG().nextInt(200) % 20;
        }

        @Override
        public boolean shouldExecute() {
            if (this.taskOwner.isGroupLeader())
                return false;
            else if (this.taskOwner.hasGroupLeader())
                return true;
            else if (this.cooldown > 0) {
                --this.cooldown;
                return false;
            } else {
                this.cooldown = this.getNewCooldown(this.taskOwner);
                Predicate<BaseHerdingEntity> predicate = (herdingEntity) -> herdingEntity.canGroupGrow() || !herdingEntity.hasGroupLeader();
                List<BaseHerdingEntity> list = this.taskOwner.world.getEntitiesWithinAABB(this.taskOwner.getClass(), this.taskOwner.getBoundingBox().grow(8.0D, 8.0D, 8.0D), predicate);
                BaseHerdingEntity baseHerdingEntity = list.stream().filter(BaseHerdingEntity::canGroupGrow).findAny().orElse(this.taskOwner);
                baseHerdingEntity.setAllGroupLeader(list.stream().filter((herdingEntity) -> !herdingEntity.hasGroupLeader()));
                return this.taskOwner.hasGroupLeader();
            }
        }

        @Override
        public boolean shouldContinueExecuting() {
            return this.taskOwner.hasGroupLeader() && this.taskOwner.inRangeOfGroupLeader();
        }

        @Override
        public void startExecuting() {
            this.navigateTimer = 0;
        }

        @Override
        public void resetTask() {
            this.taskOwner.leaveGroup();
        }

        @Override
        public void tick() {
            if (--this.navigateTimer <= 0) {
                this.navigateTimer = 10;
                this.taskOwner.moveToGroupLeader();
            }
        }
    }

    static class GroupPanicGoal extends PanicGoal {
        public GroupPanicGoal(CreatureEntity creature, double speedIn) {
            super(creature, speedIn);
        }

        @Override
        public void startExecuting() {
            super.startExecuting();
            alertOthers();
        }

        @Override
        protected boolean findRandomPosition() {
            Vector3d vector3d = RandomPositionGenerator.findRandomTarget(this.creature, 10, 4);
            if (vector3d == null)
                return false;
            else {
                this.randPosX = vector3d.x;
                this.randPosY = vector3d.y;
                this.randPosZ = vector3d.z;
                return true;
            }
        }

        protected void alertOthers() {
            AxisAlignedBB axisalignedbb = AxisAlignedBB.fromVector(this.creature.getPositionVec()).grow(10.0D, 10.0D, 10.0D);
            List<MobEntity> list = this.creature.world.getLoadedEntitiesWithinAABB(this.creature.getClass(), axisalignedbb);
            Iterator iterator = list.iterator();

            while (true) {
                MobEntity mobentity;
                if (!iterator.hasNext())
                    return;

                mobentity = (MobEntity) iterator.next();

                mobentity.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ, this.speed);
            }
        }
    }
}
