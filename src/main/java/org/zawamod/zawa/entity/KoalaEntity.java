package org.zawamod.zawa.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.zawamod.zawa.entity.base.ZawaBaseEntity;
import org.zawamod.zawa.init.ModEntities;
import org.zawamod.zawa.init.ModItems;

import javax.annotation.Nullable;

public class KoalaEntity extends ZawaBaseEntity {
    public KoalaEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute registerKoalaAttributes() {
        return LivingEntity.registerAttributes().createMutableAttribute(Attributes.FOLLOW_RANGE, 16).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.10F).createMutableAttribute(Attributes.MAX_HEALTH, 10.0F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0F);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }

    @Override
    public int maxVariants() {
        return 3;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == ModItems.HERBIVORE_KIBBLE.get();
    }

    @Nullable
    @Override
    public KoalaEntity func_241840_a(ServerWorld world, AgeableEntity entity) {
        KoalaEntity koalaBaby = ModEntities.KOALA.create(world);
        if (entity instanceof KoalaEntity && koalaBaby != null) {
            KoalaEntity parent2 = (KoalaEntity) entity;
            if (rand.nextInt(4) != 0)
                koalaBaby.setVariant(rand.nextBoolean() ? this.getVariant() : parent2.getVariant());
            else
                koalaBaby.setVariant(rand.nextInt(this.maxVariants()));
            koalaBaby.setGender(rand.nextBoolean());
        }
        return koalaBaby;
    }
}
