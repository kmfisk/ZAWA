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
import org.zawamod.zawa.entity.base.BaseSemiAquaticEntity;
import org.zawamod.zawa.item.ZawaItems;

import javax.annotation.Nullable;

public class CommonHippopotamusEntity extends BaseSemiAquaticEntity {
    public CommonHippopotamusEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute registerHippoAttributes() {
        return LivingEntity.registerAttributes().createMutableAttribute(Attributes.FOLLOW_RANGE, 16).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.10F).createMutableAttribute(Attributes.MAX_HEALTH, 80.0F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 14.0F);
    }

    @Override
    public int maxVariants() {
        return 3;
    }

    @Override
    public Weight weightClass() {
        return Weight.GIANT;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == ZawaItems.HERBIVORE_KIBBLE.get();
    }

    @Nullable
    @Override
    public AgeableEntity func_241840_a(ServerWorld world, AgeableEntity entity) {
        CommonHippopotamusEntity hippoBaby = ZawaEntities.COMMON_HIPPOPOTAMUS.get().create(world);
        if (entity instanceof CommonHippopotamusEntity && hippoBaby != null) {
            CommonHippopotamusEntity parent = (CommonHippopotamusEntity) entity;
            if (rand.nextInt(4) == 0) {
                hippoBaby.setVariant(rand.nextInt(this.maxVariants()));
            } else {
                hippoBaby.setVariant(rand.nextBoolean() ? getVariant() : parent.getVariant());
            }
            hippoBaby.setMale(rand.nextBoolean());
        }
        return hippoBaby;
    }
}
