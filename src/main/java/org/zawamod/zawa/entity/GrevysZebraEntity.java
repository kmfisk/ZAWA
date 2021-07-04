package org.zawamod.zawa.entity;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.zawamod.zawa.entity.base.BaseHerdingEntity;
import org.zawamod.zawa.item.ZawaItems;

import javax.annotation.Nullable;

public class GrevysZebraEntity extends BaseHerdingEntity {
    public GrevysZebraEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute registerZebraAttributes() {
        return LivingEntity.registerAttributes().createMutableAttribute(Attributes.FOLLOW_RANGE, 16).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2F).createMutableAttribute(Attributes.MAX_HEALTH, 42.0F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 6.0F);
    }

    @Override
    public int maxVariants() {
        return 3;
    }

    @Override
    public Weight weightClass() {
        return Weight.LARGE;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == ZawaItems.HERBIVORE_KIBBLE.get();
    }

    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld world, AgeableEntity entity) {
        GrevysZebraEntity zebraBaby = ZawaEntities.GREVYS_ZEBRA.get().create(world);
        if (entity instanceof GrevysZebraEntity && zebraBaby != null) {
            GrevysZebraEntity parent = (GrevysZebraEntity) entity;
            if (rand.nextInt(4) == 0) {
                zebraBaby.setVariant(rand.nextInt(this.maxVariants()));
            } else {
                zebraBaby.setVariant(rand.nextBoolean() ? getVariant() : parent.getVariant());
            }
            zebraBaby.setMale(rand.nextBoolean());
        }
        return zebraBaby;
    }
}
