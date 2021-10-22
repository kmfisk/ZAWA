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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.RangedInteger;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.zawamod.zawa.resources.EntityStatsManager;

import javax.annotation.Nullable;
import java.util.Optional;

public abstract class ZawaBaseEntity extends TameableEntity {
    public static final DataParameter<Integer> VARIANT = EntityDataManager.defineId(ZawaBaseEntity.class, DataSerializers.INT);
    public static final DataParameter<Boolean> GENDER = EntityDataManager.defineId(ZawaBaseEntity.class, DataSerializers.BOOLEAN);
    public static final DataParameter<ItemStack> FAVORITE_FOOD = EntityDataManager.defineId(ZawaBaseEntity.class, DataSerializers.ITEM_STACK);

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
        this.entityData.define(FAVORITE_FOOD, ItemStack.EMPTY);
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        spawnDataIn = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
        this.setMale(random.nextBoolean());
        this.setVariant(random.nextInt(this.maxVariants()));
        Optional<Item> dietItem = EntityStatsManager.INSTANCE.getStats(this).getDietItems().stream().findAny();
        this.setFavoriteFood(dietItem.map(Item::getDefaultInstance).orElse(ItemStack.EMPTY));
        return spawnDataIn;
    }

    public final int maxVariants() {
        return EntityStatsManager.INSTANCE.getStats(this).getVariantCount();
    }

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

    public ItemStack getFavoriteFood() {
        return this.entityData.get(FAVORITE_FOOD);
    }

    public void setFavoriteFood(ItemStack itemStack) {
        this.entityData.set(FAVORITE_FOOD, itemStack);
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.getVariant());
        compound.putBoolean("Gender", this.getGender().toBool());
        compound.put("FavoriteFood", this.getFavoriteFood().save(new CompoundNBT()));
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        this.setVariant(compound.getInt("Variant"));
        this.setMale(compound.getBoolean("Gender"));
        CompoundNBT favoriteFoodNBT = compound.getCompound("FavoriteFood");
        if (favoriteFoodNBT != null && !favoriteFoodNBT.isEmpty()) {
            ItemStack itemstack = ItemStack.of(favoriteFoodNBT);
            if (itemstack.isEmpty())
                LOGGER.warn("Unable to load FavoriteFood item from: {}", favoriteFoodNBT);
            this.setFavoriteFood(itemstack);
        }
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
    public void spawnChildFromBreeding(ServerWorld world, AnimalEntity entity) {
        RangedInteger litterSize = EntityStatsManager.INSTANCE.getStats(this).getLitterSize();
        for (int i = 0; i < litterSize.randomValue(random) + 1; i++)
            super.spawnChildFromBreeding(world, entity);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return EntityStatsManager.INSTANCE.getStats(this).isFood(stack.getItem());
    }

    public boolean isKibble(ItemStack stack) {
        return stack.getItem() == EntityStatsManager.INSTANCE.getStats(this).getKibble();
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (this.level.isClientSide) {
            boolean flag = isKibble(stack) || isFood(stack);
            return flag ? ActionResultType.SUCCESS : ActionResultType.PASS;

        } else {
            if (this.isTame() && this.isOwnedBy(player)) {
                if (isFood(stack) && this.getHealth() < this.getMaxHealth()) {
                    this.usePlayerItem(player, stack);
                    this.heal(1); //todo
                    return ActionResultType.CONSUME;

                } else if (isKibble(stack) && this.getAge() == 0 && this.canFallInLove()) {
                    this.usePlayerItem(player, stack);
                    this.setInLove(player);
                    return ActionResultType.CONSUME;
                }

            } else if (isKibble(stack)) {
                this.usePlayerItem(player, stack);
                if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.tame(player);
                    this.level.broadcastEntityEvent(this, (byte) 7);
                } else
                    this.level.broadcastEntityEvent(this, (byte) 6);

                return ActionResultType.CONSUME;
            }

            return ActionResultType.PASS;
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
