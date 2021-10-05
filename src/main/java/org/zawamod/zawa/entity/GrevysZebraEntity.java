package org.zawamod.zawa.entity;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.zawamod.zawa.entity.base.BaseHerdingEntity;

import javax.annotation.Nullable;

public class GrevysZebraEntity extends BaseHerdingEntity {
    public GrevysZebraEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute registerZebraAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.2F).add(Attributes.MAX_HEALTH, 42.0F).add(Attributes.ATTACK_DAMAGE, 6.0F);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity entity) {
        GrevysZebraEntity zebraBaby = ZawaEntities.GREVYS_ZEBRA.get().create(world);
        if (entity instanceof GrevysZebraEntity && zebraBaby != null) {
            GrevysZebraEntity parent = (GrevysZebraEntity) entity;
            if (random.nextInt(4) == 0) {
                zebraBaby.setVariant(random.nextInt(this.maxVariants()));
            } else {
                zebraBaby.setVariant(random.nextBoolean() ? getVariant() : parent.getVariant());
            }
            zebraBaby.setMale(random.nextBoolean());
        }
        return zebraBaby;
    }
}
