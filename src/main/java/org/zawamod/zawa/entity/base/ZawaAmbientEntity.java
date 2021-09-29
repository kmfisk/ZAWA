package org.zawamod.zawa.entity.base;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class ZawaAmbientEntity extends CreatureEntity {
    public ZawaAmbientEntity(EntityType<? extends CreatureEntity> type, World world) {
        super(type, world);
    }
}
