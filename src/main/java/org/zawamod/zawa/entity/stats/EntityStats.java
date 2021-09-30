package org.zawamod.zawa.entity.stats;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.RangedInteger;

import java.util.Set;

public class EntityStats {
    private final Object2IntMap<Item> diet;
    private final Item kibble;
    private final RangedInteger litterSize;
    private final Set<Item> enrichmentItems;
    private final Set<Block> enrichmentBlocks;
    private final EntitySizeCategory size;
    private final int variantCount;

    public EntityStats(Object2IntMap<Item> diet, Item kibble, RangedInteger litterSize, Set<Item> enrichmentItems, Set<Block> enrichmentBlocks, EntitySizeCategory size, int variantCount) {
        this.diet = diet;
        this.kibble = kibble;
        this.litterSize = litterSize;
        this.enrichmentItems = enrichmentItems;
        this.enrichmentBlocks = enrichmentBlocks;
        this.size = size;
        this.variantCount = variantCount;
    }
}
