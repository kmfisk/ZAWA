package org.zawamod.zawa.entity;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.zawamod.zawa.entity.base.ZawaBaseEntity;
import org.zawamod.zawa.item.ZawaItems;

import javax.annotation.Nullable;

public class CommonHippopotamusEntity extends ZawaBaseEntity {
    public CommonHippopotamusEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute registerHippoAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.10F).add(Attributes.MAX_HEALTH, 80.0F).add(Attributes.ATTACK_DAMAGE, 14.0F);
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
    public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity entity) {
        CommonHippopotamusEntity hippoBaby = ZawaEntities.COMMON_HIPPOPOTAMUS.get().create(world);
        if (entity instanceof CommonHippopotamusEntity && hippoBaby != null) {
            CommonHippopotamusEntity parent = (CommonHippopotamusEntity) entity;
            if (random.nextInt(4) == 0) {
                hippoBaby.setVariant(random.nextInt(this.maxVariants()));
            } else {
                hippoBaby.setVariant(random.nextBoolean() ? getVariant() : parent.getVariant());
            }
            hippoBaby.setMale(random.nextBoolean());
        }
        return hippoBaby;
    }
}
