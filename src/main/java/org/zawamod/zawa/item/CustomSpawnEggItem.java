package org.zawamod.zawa.item;

import net.minecraft.entity.EntityType;
import net.minecraft.item.SpawnEggItem;

public class CustomSpawnEggItem extends SpawnEggItem {
    public CustomSpawnEggItem(EntityType<?> typeIn, Properties builder) {
        super(typeIn, 0x0, 0x0, builder);
    }

    @Override
    public int getColor(int tintIndex) {
        return 0xFFFFFF;
    }
}
