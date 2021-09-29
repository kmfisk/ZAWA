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

public abstract class BaseHerdingEntity extends ZawaBaseEntity {
    private BaseHerdingEntity groupLeader;
    private int groupSize = 1;

    public BaseHerdingEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new GroupPanicGoal(this, 2.0D));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, PlayerEntity.class, 12.0F, 1.6D, 1.4D, EntityPredicates.NO_SPECTATORS::test));
        this.goalSelector.addGoal(6, new FollowHerdGoal(this));
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return this.getMaxGroupSize();
    }

    public int getMaxGroupSize() {
        return super.getMaxSpawnClusterSize();
    }

    public boolean hasGroupLeader() {
        return this.groupLeader != null && this.groupLeader.isAlive();
    }

    public BaseHerdingEntity startFollowing(BaseHerdingEntity groupLeaderIn) {
        this.groupLeader = groupLeaderIn;
        groupLeaderIn.addFollower();
        return groupLeaderIn;
    }

    public void stopFollowing() {
        this.groupLeader.removeFollower();
        this.groupLeader = null;
    }

    private void addFollower() {
        ++this.groupSize;
    }

    private void removeFollower() {
        --this.groupSize;
    }

    public boolean canBeFollowed() {
        return this.hasFollowers() && this.groupSize < this.getMaxGroupSize();
    }

    public void tick() {
        super.tick();
        if (this.hasFollowers() && this.random.nextInt(200) == 1) {
            List<BaseHerdingEntity> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D));
            if (list.size() <= 1)
                this.groupSize = 1;
        }
    }

    public boolean hasFollowers() {
        return this.groupSize > 1;
    }

    public boolean inRangeOfLeader() {
        return this.distanceToSqr(this.groupLeader) <= 121.0D;
    }

    public void pathToLeader() {
        if (this.hasGroupLeader()) {
            Path path = this.getNavigation().createPath(this.groupLeader, 6);
            if (path != null) this.getNavigation().moveTo(path, 1.0D);
        }
    }

    public void addFollowers(Stream<BaseHerdingEntity> herdingEntity) {
        herdingEntity.limit((this.getMaxGroupSize() - this.groupSize)).filter((entity) -> entity != this).forEach((entity) -> entity.startFollowing(this));
    }

    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
        if (spawnDataIn == null)
            spawnDataIn = new BaseHerdingEntity.GroupData(this);
        else
            this.startFollowing(((BaseHerdingEntity.GroupData) spawnDataIn).groupLeader);

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
            this.cooldown = this.nextStartTick(taskOwner);
        }

        protected int nextStartTick(BaseHerdingEntity taskOwnerIn) {
            return 200 + taskOwnerIn.getRandom().nextInt(200) % 20;
        }

        @Override
        public boolean canUse() {
            if (this.taskOwner.hasFollowers())
                return false;
            else if (this.taskOwner.hasGroupLeader())
                return true;
            else if (this.cooldown > 0) {
                --this.cooldown;
                return false;
            } else {
                this.cooldown = this.nextStartTick(this.taskOwner);
                Predicate<BaseHerdingEntity> predicate = (herdingEntity) -> herdingEntity.canBeFollowed() || !herdingEntity.hasGroupLeader();
                List<BaseHerdingEntity> list = this.taskOwner.level.getEntitiesOfClass(this.taskOwner.getClass(), this.taskOwner.getBoundingBox().inflate(8.0D, 8.0D, 8.0D), predicate);
                BaseHerdingEntity baseHerdingEntity = list.stream().filter(BaseHerdingEntity::canBeFollowed).findAny().orElse(this.taskOwner);
                baseHerdingEntity.addFollowers(list.stream().filter((herdingEntity) -> !herdingEntity.hasGroupLeader()));
                return this.taskOwner.hasGroupLeader();
            }
        }

        @Override
        public boolean canContinueToUse() {
            return this.taskOwner.hasGroupLeader() && this.taskOwner.inRangeOfLeader();
        }

        @Override
        public void start() {
            this.navigateTimer = 0;
        }

        @Override
        public void stop() {
            this.taskOwner.stopFollowing();
        }

        @Override
        public void tick() {
            if (--this.navigateTimer <= 0) {
                this.navigateTimer = 10;
                this.taskOwner.pathToLeader();
            }
        }
    }

    static class GroupPanicGoal extends PanicGoal {
        public GroupPanicGoal(CreatureEntity creature, double speedIn) {
            super(creature, speedIn);
        }

        @Override
        public void start() {
            super.start();
            alertOthers();
        }

        @Override
        protected boolean findRandomPosition() {
            Vector3d vector3d = RandomPositionGenerator.getPos(this.mob, 10, 4);
            if (vector3d == null)
                return false;
            else {
                this.posX = vector3d.x;
                this.posY = vector3d.y;
                this.posZ = vector3d.z;
                return true;
            }
        }

        protected void alertOthers() {
            AxisAlignedBB axisalignedbb = AxisAlignedBB.unitCubeFromLowerCorner(this.mob.position()).inflate(10.0D, 10.0D, 10.0D);
            List<MobEntity> list = this.mob.level.getLoadedEntitiesOfClass(this.mob.getClass(), axisalignedbb);
            Iterator iterator = list.iterator();

            while (true) {
                MobEntity mobentity;
                if (!iterator.hasNext())
                    return;

                mobentity = (MobEntity) iterator.next();

                mobentity.getNavigation().moveTo(this.posX, this.posY, this.posZ, this.speedModifier);
            }
        }
    }
}
