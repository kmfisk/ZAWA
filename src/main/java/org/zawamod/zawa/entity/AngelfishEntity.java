package org.zawamod.zawa.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import org.zawamod.zawa.entity.base.ZawaAmbientFishEntity;
import org.zawamod.zawa.item.ZawaItems;

public class AngelfishEntity extends ZawaAmbientFishEntity {
    public AngelfishEntity(EntityType<? extends ZawaAmbientFishEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute registerAngelfishAttributes() {
        return createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 4.0F);
    }

    @Override
    protected ItemStack getBucketItemStack() {
        return new ItemStack(ZawaItems.ANGELFISH_BUCKET.get());
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }
}
