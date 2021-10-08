package org.zawamod.zawa.entity.stats;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.HashSet;
import java.util.Set;

public class Enrichment {
    private final Set<Item> items;
    private final Set<Block> blocks;
    private final Set<EntityType<?>> entities;

    public Enrichment(Set<Item> items, Set<Block> blocks, Set<EntityType<?>> entities) {
        this.items = items;
        this.blocks = blocks;
        this.entities = entities;
    }

    public static Enrichment deserialize(JsonObject element) {
        Set<Item> items = new HashSet<>();
        Set<Block> blocks = new HashSet<>();
        Set<EntityType<?>> entities = new HashSet<>();
        deserializeTo(items, ForgeRegistries.ITEMS, element, "items", "item");
        deserializeTo(blocks, ForgeRegistries.BLOCKS, element, "blocks", "block");
        deserializeTo(entities, ForgeRegistries.ENTITIES, element, "entities", "entity type");
        return new Enrichment(items, blocks, entities);
    }

    private static <T extends IForgeRegistryEntry<T>> void deserializeTo(Set<T> set, IForgeRegistry<T> registry, JsonObject parent, String elementName, String objectType) {
        JsonArray array = JSONUtils.getAsJsonArray(parent, elementName);
        for (int i = 0; i < array.size(); ++i) {
            JsonElement element = array.get(i);
            ResourceLocation id = new ResourceLocation(JSONUtils.convertToString(element, elementName + "[" + i + "]"));
            if (!registry.containsKey(id)) throw new JsonSyntaxException("Unknown " + objectType + ": " + id);
            set.add(registry.getValue(id));
        }
    }
}
