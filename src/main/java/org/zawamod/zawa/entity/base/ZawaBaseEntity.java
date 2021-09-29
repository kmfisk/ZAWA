package org.zawamod.zawa.entity.base;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public abstract class ZawaBaseEntity extends TameableEntity {
    public static final DataParameter<Integer> VARIANT = EntityDataManager.defineId(ZawaBaseEntity.class, DataSerializers.INT);
    public static final DataParameter<Boolean> GENDER = EntityDataManager.defineId(ZawaBaseEntity.class, DataSerializers.BOOLEAN);

    public ZawaBaseEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
        this.entityData.define(GENDER, false);
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        spawnDataIn = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
        this.setMale(random.nextBoolean());
        this.setVariant(random.nextInt(this.maxVariants()));
        return spawnDataIn;
    }

    public abstract int maxVariants();

    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    public void setVariant(int variant) {
        this.entityData.set(VARIANT, variant);
    }

    public Gender getGender() {
        return this.entityData.get(GENDER) ? Gender.MALE : Gender.FEMALE;
    }

    public void setGender(Gender gender) {
        setMale(gender == Gender.MALE);
    }

    public void setMale(boolean isMale) {
        this.entityData.set(GENDER, isMale);
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.getVariant());
        compound.putBoolean("Gender", this.getGender().toBool());
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        this.setVariant(compound.getInt("Variant"));
        this.setMale(compound.getBoolean("Gender"));
    }

    @Override
    public boolean canMate(AnimalEntity otherAnimal) {
        if (!this.isTame()) return false;
        else if (!(otherAnimal instanceof ZawaBaseEntity)) return false;
        else {
            ZawaBaseEntity zawaBaseEntity = (ZawaBaseEntity) otherAnimal;
            if (zawaBaseEntity.getGender() == this.getGender()) return false;
            return zawaBaseEntity.isTame() && super.canMate(otherAnimal);
        }
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (this.level.isClientSide) {
            boolean flag = this.isOwnedBy(player) || this.isTame() || isFood(stack) && !this.isTame();
            return flag ? ActionResultType.CONSUME : ActionResultType.PASS;

        } else {
            if (!this.isTame() && isFood(stack)) {
                if (!player.abilities.instabuild)
                    stack.shrink(1);
                if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.tame(player);
                    this.navigation.stop();
                    this.setTarget(null);
                    this.level.broadcastEntityEvent(this, (byte) 7);
                } else
                    this.level.broadcastEntityEvent(this, (byte) 6);

                return ActionResultType.SUCCESS;
            }

            return super.mobInteract(player, hand);
        }
    }

    public enum Gender {
        FEMALE,
        MALE;

        public boolean toBool() {
            return this == MALE;
        }
    }
}
