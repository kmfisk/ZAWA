package org.zawamod.zawa.entity;

import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.IInventoryChangedListener;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.zawamod.zawa.entity.base.BaseHerdingEntity;

import javax.annotation.Nullable;

public class GrevysZebraEntity extends BaseHerdingEntity implements IInventoryChangedListener, IJumpingMount, IEquipable {
    private static final DataParameter<Byte> DATA_ID_FLAGS = EntityDataManager.defineId(AbstractHorseEntity.class, DataSerializers.BYTE);
    private int eatingCounter;
    private int mouthCounter;
    public int tailCounter;
    public int sprintCounter;
    protected boolean isJumping;
    protected Inventory inventory;
    protected float playerJumpPendingScale;
    private float eatAnim;
    private float eatAnimO;
    private float mouthAnim;
    private float mouthAnimO;
    protected int gallopSoundCounter;

    public GrevysZebraEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
        this.maxUpStep = 1.0F;
        this.createInventory();
    }

    public static AttributeModifierMap.MutableAttribute registerZebraAttributes() {
        return createMobAttributes().add(Attributes.JUMP_STRENGTH).add(Attributes.MOVEMENT_SPEED, 0.225F).add(Attributes.MAX_HEALTH, 42.0F).add(Attributes.ATTACK_DAMAGE, 6.0F);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_FLAGS, (byte) 0);
    }

    @Override
    protected void customServerAiStep() {
        if (this.getMoveControl().hasWanted())
            this.setSprinting(this.getMoveControl().getSpeedModifier() == 1.33D);
        else
            this.setSprinting(false);

        super.customServerAiStep();
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity entity) {
        GrevysZebraEntity zebraBaby = ZawaEntities.GREVYS_ZEBRA.get().create(world);
        if (entity instanceof GrevysZebraEntity && zebraBaby != null) {
            GrevysZebraEntity parent = (GrevysZebraEntity) entity;
            if (random.nextInt(4) == 0)
                zebraBaby.setVariant(random.nextInt(this.maxVariants()));
            else
                zebraBaby.setVariant(random.nextBoolean() ? getVariant() : parent.getVariant());
            zebraBaby.setMale(random.nextBoolean());
        }
        return zebraBaby;
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!this.isBaby())
            if (this.isVehicle())
                return super.mobInteract(player, hand);

        if (!itemstack.isEmpty()) {
            ActionResultType actionresulttype = itemstack.interactLivingEntity(player, this, hand);
            if (actionresulttype.consumesAction())
                return actionresulttype;
        }

        if (this.isBaby())
            return super.mobInteract(player, hand);
        else {
            this.doPlayerRide(player);
            return ActionResultType.sidedSuccess(this.level.isClientSide);
        }
    }

    protected boolean getFlag(int i) {
        return (this.entityData.get(DATA_ID_FLAGS) & i) != 0;
    }

    protected void setFlag(int i, boolean b) {
        byte b0 = this.entityData.get(DATA_ID_FLAGS);
        if (b)
            this.entityData.set(DATA_ID_FLAGS, (byte) (b0 | i));
        else
            this.entityData.set(DATA_ID_FLAGS, (byte) (b0 & ~i));
    }

    public boolean isJumping() {
        return this.isJumping;
    }

    public void setIsJumping(boolean isJumping) {
        this.isJumping = isJumping;
    }

    public boolean isEating() {
        return this.getFlag(16);
    }

    @Override
    public boolean isSaddleable() {
        return this.isAlive() && !this.isBaby() && this.isTame();
    }

    @Override
    public void equipSaddle(@Nullable SoundCategory soundCategory) {
        this.inventory.setItem(0, new ItemStack(Items.SADDLE));
        if (soundCategory != null)
            this.level.playSound(null, this, SoundEvents.HORSE_SADDLE, soundCategory, 0.5F, 1.0F);
    }

    @Override
    public boolean isSaddled() {
        return this.getFlag(4);
    }

    @Override
    public boolean isPushable() {
        return !this.isVehicle();
    }

    protected int getInventorySize() {
        return 2;
    }

    protected void createInventory() {
        Inventory inventory = this.inventory;
        this.inventory = new Inventory(this.getInventorySize());
        if (inventory != null) {
            inventory.removeListener(this);
            int i = Math.min(inventory.getContainerSize(), this.inventory.getContainerSize());

            for (int j = 0; j < i; ++j) {
                ItemStack itemstack = inventory.getItem(j);
                if (!itemstack.isEmpty())
                    this.inventory.setItem(j, itemstack.copy());
            }
        }

        this.inventory.addListener(this);
        this.updateContainerEquipment();
        this.itemHandler = net.minecraftforge.common.util.LazyOptional.of(() -> new net.minecraftforge.items.wrapper.InvWrapper(this.inventory));
    }

    protected void updateContainerEquipment() {
        if (!this.level.isClientSide)
            this.setFlag(4, !this.inventory.getItem(0).isEmpty());
    }

    @Override
    public void containerChanged(IInventory iInventory) {
        boolean flag = this.isSaddled();
        this.updateContainerEquipment();
        if (this.tickCount > 20 && !flag && this.isSaddled())
            this.playSound(SoundEvents.HORSE_SADDLE, 0.5F, 1.0F);
    }

    protected void doPlayerRide(PlayerEntity player) {
        this.setEating(false);
        if (!this.level.isClientSide) {
            player.yRot = this.yRot;
            player.xRot = this.xRot;
            player.startRiding(this);
        }
    }

    @Override
    protected boolean isImmobile() {
        return super.isImmobile() && this.isVehicle() && this.isSaddled() || this.isEating();
    }

    private void moveTail() {
        this.tailCounter = 1;
    }

    @Override
    protected void dropEquipment() {
        super.dropEquipment();
        if (this.inventory != null) {
            for (int i = 0; i < this.inventory.getContainerSize(); ++i) {
                ItemStack itemstack = this.inventory.getItem(i);
                if (!itemstack.isEmpty() && !EnchantmentHelper.hasVanishingCurse(itemstack))
                    this.spawnAtLocation(itemstack);
            }
        }
    }

    @Override
    public void aiStep() {
        if (this.random.nextInt(200) == 0)
            this.moveTail();

        super.aiStep();

        if (!this.level.isClientSide && this.isAlive()) {
            if (this.canEatGrass()) {
                if (!this.isEating() && !this.isVehicle() && this.random.nextInt(300) == 0 && this.level.getBlockState(this.blockPosition().below()).is(Blocks.GRASS_BLOCK))
                    this.setEating(true);

                if (this.isEating() && ++this.eatingCounter > 50) {
                    this.eatingCounter = 0;
                    this.setEating(false);
                }
            }
        }
    }

    public boolean canEatGrass() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.mouthCounter > 0 && ++this.mouthCounter > 30) {
            this.mouthCounter = 0;
            this.setFlag(64, false);
        }

        if (this.tailCounter > 0 && ++this.tailCounter > 8)
            this.tailCounter = 0;

        if (this.sprintCounter > 0) {
            ++this.sprintCounter;
            if (this.sprintCounter > 300)
                this.sprintCounter = 0;
        }

        this.eatAnimO = this.eatAnim;
        if (this.isEating()) {
            this.eatAnim += (1.0F - this.eatAnim) * 0.4F + 0.05F;
            if (this.eatAnim > 1.0F)
                this.eatAnim = 1.0F;
        } else {
            this.eatAnim += (0.0F - this.eatAnim) * 0.4F - 0.05F;
            if (this.eatAnim < 0.0F)
                this.eatAnim = 0.0F;
        }

        this.mouthAnimO = this.mouthAnim;
        if (this.getFlag(64)) {
            this.mouthAnim += (1.0F - this.mouthAnim) * 0.7F + 0.05F;
            if (this.mouthAnim > 1.0F)
                this.mouthAnim = 1.0F;
        } else {
            this.mouthAnim += (0.0F - this.mouthAnim) * 0.7F - 0.05F;
            if (this.mouthAnim < 0.0F)
                this.mouthAnim = 0.0F;
        }
    }

    public void setEating(boolean eating) {
        this.setFlag(16, eating);
    }

    @Override
    public void travel(Vector3d parVector3d) {
        if (this.isAlive()) {
            if (this.isVehicle() && this.canBeControlledByRider() && this.isSaddled()) {
                LivingEntity livingentity = (LivingEntity) this.getControllingPassenger();
                this.yRot = livingentity.yRot;
                this.yRotO = this.yRot;
                this.xRot = livingentity.xRot * 0.5F;
                this.setRot(this.yRot, this.xRot);
                this.yBodyRot = this.yRot;
                this.yHeadRot = this.yBodyRot;
                float f = livingentity.xxa * 0.5F;
                float f1 = livingentity.zza;
                if (f1 <= 0.0F) {
                    f1 *= 0.25F;
                    this.gallopSoundCounter = 0;
                }

                if (this.onGround && this.playerJumpPendingScale == 0.0F) {
                    f = 0.0F;
                    f1 = 0.0F;
                }

                if (this.playerJumpPendingScale > 0.0F && !this.isJumping() && this.onGround) {
                    double d0 = this.getAttributeValue(Attributes.JUMP_STRENGTH) * (double) this.playerJumpPendingScale * (double) this.getBlockJumpFactor();
                    double d1;
                    if (this.hasEffect(Effects.JUMP))
                        d1 = d0 + (double) ((float) (this.getEffect(Effects.JUMP).getAmplifier() + 1) * 0.1F);
                    else
                        d1 = d0;

                    Vector3d vector3d = this.getDeltaMovement();
                    this.setDeltaMovement(vector3d.x, d1, vector3d.z);
                    this.setIsJumping(true);
                    this.hasImpulse = true;
                    net.minecraftforge.common.ForgeHooks.onLivingJump(this);
                    if (f1 > 0.0F) {
                        float f2 = MathHelper.sin(this.yRot * ((float) Math.PI / 180F));
                        float f3 = MathHelper.cos(this.yRot * ((float) Math.PI / 180F));
                        this.setDeltaMovement(this.getDeltaMovement().add((double) (-0.4F * f2 * this.playerJumpPendingScale), 0.0D, (double) (0.4F * f3 * this.playerJumpPendingScale)));
                    }

                    this.playerJumpPendingScale = 0.0F;
                }

                this.flyingSpeed = this.getSpeed() * 0.1F;
                if (this.isControlledByLocalInstance()) {
                    this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    super.travel(new Vector3d(f, parVector3d.y, f1));
                } else if (livingentity instanceof PlayerEntity)
                    this.setDeltaMovement(Vector3d.ZERO);

                if (this.onGround) {
                    this.playerJumpPendingScale = 0.0F;
                    this.setIsJumping(false);
                }

                this.calculateEntityAnimation(this, false);
            } else {
                this.flyingSpeed = 0.02F;
                super.travel(parVector3d);
            }
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        if (!this.inventory.getItem(0).isEmpty())
            compound.put("SaddleItem", this.inventory.getItem(0).save(new CompoundNBT()));
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("SaddleItem", 10)) {
            ItemStack itemstack = ItemStack.of(compound.getCompound("SaddleItem"));
            if (itemstack.getItem() == Items.SADDLE)
                this.inventory.setItem(0, itemstack);
        }
        this.updateContainerEquipment();
    }

    @Override
    public boolean canBeControlledByRider() {
        return this.getControllingPassenger() instanceof LivingEntity;
    }

    protected void playJumpSound() {
        this.playSound(SoundEvents.HORSE_JUMP, 0.4F, 1.0F);
    }

    @OnlyIn(Dist.CLIENT)
    public float getEatAnim(float p_110258_1_) {
        return MathHelper.lerp(p_110258_1_, this.eatAnimO, this.eatAnim);
    }

    @OnlyIn(Dist.CLIENT)
    public float getMouthAnim(float p_110201_1_) {
        return MathHelper.lerp(p_110201_1_, this.mouthAnimO, this.mouthAnim);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void onPlayerJump(int i) {
        if (this.isSaddled()) {
            if (i < 0)
                i = 0;

            if (i >= 90)
                this.playerJumpPendingScale = 1.0F;
            else
                this.playerJumpPendingScale = 0.4F + 0.4F * (float) i / 90.0F;
        }
    }

    @Override
    public boolean canJump() {
        return this.isSaddled();
    }

    @Override
    public void handleStartJump(int i) {
        this.playJumpSound();
    }

    @Override
    public void handleStopJump() {
    }

    @Override
    public void positionRider(Entity rider) { // todo
        super.positionRider(rider);
        if (rider instanceof MobEntity) {
            MobEntity mobentity = (MobEntity) rider;
            this.yBodyRot = mobentity.yBodyRot;
        }
    }

    @Override
    public boolean onClimbable() {
        return false;
    }

    @Override
    public boolean setSlot(int i, ItemStack stack) {
        int j = i - 400;
        if (j >= 0 && j < 2 && j < this.inventory.getContainerSize()) {
            if (j == 0 && stack.getItem() != Items.SADDLE) {
                return false;
            } else if (j != 1) {
                this.inventory.setItem(j, stack);
                this.updateContainerEquipment();
                return true;
            } else
                return false;
        } else {
            int k = i - 500 + 2;
            if (k >= 2 && k < this.inventory.getContainerSize()) {
                this.inventory.setItem(k, stack);
                return true;
            } else
                return false;
        }
    }

    @Nullable
    @Override
    public Entity getControllingPassenger() {
        return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
    }

    @Nullable
    private Vector3d getDismountLocationInDirection(Vector3d parVector3d, LivingEntity livingEntity) {
        double d0 = this.getX() + parVector3d.x;
        double d1 = this.getBoundingBox().minY;
        double d2 = this.getZ() + parVector3d.z;
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for (Pose pose : livingEntity.getDismountPoses()) {
            blockpos$mutable.set(d0, d1, d2);
            double d3 = this.getBoundingBox().maxY + 0.75D;

            while (true) {
                double d4 = this.level.getBlockFloorHeight(blockpos$mutable);
                if ((double) blockpos$mutable.getY() + d4 > d3)
                    break;

                if (TransportationHelper.isBlockFloorValid(d4)) {
                    AxisAlignedBB axisalignedbb = livingEntity.getLocalBoundsForPose(pose);
                    Vector3d vector3d = new Vector3d(d0, (double) blockpos$mutable.getY() + d4, d2);
                    if (TransportationHelper.canDismountTo(this.level, livingEntity, axisalignedbb.move(vector3d))) {
                        livingEntity.setPose(pose);
                        return vector3d;
                    }
                }

                blockpos$mutable.move(Direction.UP);
                if (!((double) blockpos$mutable.getY() < d3))
                    break;
            }
        }

        return null;
    }

    @Override
    public Vector3d getDismountLocationForPassenger(LivingEntity livingEntity) {
        Vector3d vector3d = getCollisionHorizontalEscapeVector(this.getBbWidth(), livingEntity.getBbWidth(), this.yRot + (livingEntity.getMainArm() == HandSide.RIGHT ? 90.0F : -90.0F));
        Vector3d vector3d1 = this.getDismountLocationInDirection(vector3d, livingEntity);
        if (vector3d1 != null)
            return vector3d1;
        else {
            Vector3d vector3d2 = getCollisionHorizontalEscapeVector(this.getBbWidth(), livingEntity.getBbWidth(), this.yRot + (livingEntity.getMainArm() == HandSide.LEFT ? 90.0F : -90.0F));
            Vector3d vector3d3 = this.getDismountLocationInDirection(vector3d2, livingEntity);
            return vector3d3 != null ? vector3d3 : this.position();
        }
    }

    private net.minecraftforge.common.util.LazyOptional<?> itemHandler = null;

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
        if (this.isAlive() && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && itemHandler != null)
            return itemHandler.cast();
        return super.getCapability(capability, facing);
    }

    @Override
    protected void invalidateCaps() {
        super.invalidateCaps();
        if (itemHandler != null) {
            LazyOptional<?> oldHandler = itemHandler;
            itemHandler = null;
            oldHandler.invalidate();
        }
    }
}
