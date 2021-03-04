package org.zawamod.zawa.entity.base;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;

public abstract class BaseLandEntity extends ZawaBaseEntity {
    public BaseLandEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
    }
}
