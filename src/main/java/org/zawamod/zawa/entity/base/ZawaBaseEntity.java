package org.zawamod.zawa.entity.base;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public abstract class ZawaBaseEntity extends TameableEntity {
    public static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(ZawaBaseEntity.class, DataSerializers.VARINT);
    public static final DataParameter<Boolean> GENDER = EntityDataManager.createKey(ZawaBaseEntity.class, DataSerializers.BOOLEAN);

    public ZawaBaseEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(VARIANT, 0);
        this.dataManager.register(GENDER, false);
    }

    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
        this.setGender(rand.nextBoolean());
        this.setVariant(rand.nextInt(this.maxVariants()));
        return spawnDataIn;
    }

    public abstract int maxVariants();

    public int getVariant() {
        return this.dataManager.get(VARIANT);
    }

    public void setVariant(int variant) {
        this.dataManager.set(VARIANT, variant);
    }

    public boolean getGender() {
        return this.dataManager.get(GENDER);
    }

    /**
     * @param gender, true = male, false = female
     */
    public void setGender(boolean gender) {
        this.dataManager.set(GENDER, gender);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("Variant", this.getVariant());
        compound.putBoolean("Gender", this.getGender());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setVariant(compound.getInt("Variant"));
        this.setGender(compound.getBoolean("Gender"));
    }

    @Override
    public boolean canMateWith(AnimalEntity otherAnimal) {
        if (!this.isTamed()) return false;
        else if (!(otherAnimal instanceof ZawaBaseEntity)) return false;
        else {
            ZawaBaseEntity zawaBaseEntity = (ZawaBaseEntity) otherAnimal;
            if (zawaBaseEntity.getGender() == this.getGender()) return false;
            return zawaBaseEntity.isTamed() && super.canMateWith(otherAnimal);
        }
    }
}
