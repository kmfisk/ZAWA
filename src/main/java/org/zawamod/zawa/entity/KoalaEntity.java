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
import org.zawamod.zawa.entity.base.BaseClimbingEntity;
import org.zawamod.zawa.item.ZawaItems;

import javax.annotation.Nullable;

public class KoalaEntity extends BaseClimbingEntity {
    public KoalaEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute registerKoalaAttributes() {
        return LivingEntity.registerAttributes().createMutableAttribute(Attributes.FOLLOW_RANGE, 16).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.10F).createMutableAttribute(Attributes.MAX_HEALTH, 10.0F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0F);
    }

    @Override
    public int maxVariants() {
        return 3;
    }

    @Override
    public Weight weightClass() {
        return Weight.SMALL;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == ZawaItems.HERBIVORE_KIBBLE.get();
    }

    @Nullable
    @Override
    public KoalaEntity func_241840_a(ServerWorld world, AgeableEntity entity) {
        KoalaEntity koalaBaby = ZawaEntities.KOALA.get().create(world);
        if (entity instanceof KoalaEntity && koalaBaby != null) {
            KoalaEntity parent = (KoalaEntity) entity;
            if (rand.nextInt(4) == 0) {
                koalaBaby.setVariant(rand.nextInt(this.maxVariants()));
            } else {
                koalaBaby.setVariant(rand.nextBoolean() ? getVariant() : parent.getVariant());
            }
            koalaBaby.setMale(rand.nextBoolean());
        }
        return koalaBaby;
    }
}
