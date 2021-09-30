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
import org.zawamod.zawa.entity.base.ZawaBaseEntity;
import org.zawamod.zawa.item.ZawaItems;

import javax.annotation.Nullable;

public class KoalaEntity extends ZawaBaseEntity {
    public KoalaEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute registerKoalaAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.10F).add(Attributes.MAX_HEALTH, 10.0F).add(Attributes.ATTACK_DAMAGE, 1.0F);
    }

    @Override
    public int maxVariants() {
        return 3;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.getItem() == ZawaItems.HERBIVORE_KIBBLE.get();
    }

    @Nullable
    @Override
    public KoalaEntity getBreedOffspring(ServerWorld world, AgeableEntity entity) {
        KoalaEntity koalaBaby = ZawaEntities.KOALA.get().create(world);
        if (entity instanceof KoalaEntity && koalaBaby != null) {
            KoalaEntity parent = (KoalaEntity) entity;
            if (random.nextInt(4) == 0) {
                koalaBaby.setVariant(random.nextInt(this.maxVariants()));
            } else {
                koalaBaby.setVariant(random.nextBoolean() ? getVariant() : parent.getVariant());
            }
            koalaBaby.setMale(random.nextBoolean());
        }
        return koalaBaby;
    }
}
