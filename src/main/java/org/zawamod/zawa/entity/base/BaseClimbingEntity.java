package org.zawamod.zawa.entity.base;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;

public abstract class BaseClimbingEntity extends ZawaBaseEntity {
    public BaseClimbingEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
    }
}
