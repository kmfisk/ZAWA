package org.zawamod.zawa.util;

import net.minecraft.entity.Entity;

public class ZawaUtilities {
    public static boolean isMoving(Entity entity) {
        return entity.getMotion().getX() != 0D && entity.getMotion().getZ() != 0D;
    }
}
