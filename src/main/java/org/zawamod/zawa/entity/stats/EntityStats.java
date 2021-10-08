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
    private final Enrichment enrichment;
    private final EntitySizeCategory size;
    private final int variantCount;

    public EntityStats(Object2IntMap<Item> diet, Item kibble, RangedInteger litterSize, Enrichment enrichment, EntitySizeCategory size, int variantCount) {
        this.diet = diet;
        this.kibble = kibble;
        this.litterSize = litterSize;
        this.enrichment = enrichment;
        this.size = size;
        this.variantCount = variantCount;
    }

    public boolean isFood(Item stack) {
        return this.diet.containsKey(stack.getItem());
    }

    public Item getKibble() {
        return this.kibble;
    }

    public RangedInteger getLitterSize() {
        return this.litterSize;
    }

    public int getVariantCount() {
        return this.variantCount;
    }
}
