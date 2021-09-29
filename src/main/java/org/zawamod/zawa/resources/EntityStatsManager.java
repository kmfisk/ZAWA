package org.zawamod.zawa.resources;

import com.google.gson.*;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.resources.JsonReloadListener;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.RangedInteger;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zawamod.zawa.entity.stats.EntitySizeCategory;
import org.zawamod.zawa.entity.stats.EntityStats;

import java.util.*;

public class EntityStatsManager extends JsonReloadListener {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    public static final EntityStatsManager INSTANCE = new EntityStatsManager();

    private final Map<EntityType<?>, EntityStats> stats = new HashMap<>();

    public EntityStatsManager() {
        super(GSON, "entity_stats");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> map, IResourceManager resourceManager, IProfiler profiler) {
        stats.clear();
        for (Map.Entry<ResourceLocation, JsonElement> entry : map.entrySet()) {
            try {
                JsonObject json = JSONUtils.convertToJsonObject(entry.getValue(), "top element");
                if (json.size() == 0) {
                    continue; // Ignore empty objects to allow for datapacks to disable stuff
                }
                EntityType<?> type = ForgeRegistries.ENTITIES.getValue(entry.getKey());
                if (type == null) {
                    throw new JsonSyntaxException("Unknown entity: " + entry.getKey());
                }

                ResourceLocation dietId = new ResourceLocation(JSONUtils.getAsString(json, "diet"));
                Object2IntMap<Item> diet = EntityDietManager.INSTANCE.getDiet(dietId);
                if (diet == null) throw new JsonSyntaxException("Unknown diet: " + dietId);

                ResourceLocation kibbleId = new ResourceLocation(JSONUtils.getAsString(json, "kibble"));
                Item kibble = ForgeRegistries.ITEMS.getValue(kibbleId);
                if (kibble == null || kibble == Items.AIR) throw new JsonSyntaxException("Unknown item: " + kibbleId);

                JsonElement litterSizeElement = json.get("litter_size");
                RangedInteger litterSize;
                if (litterSizeElement == null) {
                    throw new JsonSyntaxException("Missing litter_size, expected to find a JsonObject or Int");
                } else if (litterSizeElement.isJsonPrimitive()) {
                    litterSize = new RangedInteger(litterSizeElement.getAsInt(), litterSizeElement.getAsInt());
                } else if (litterSizeElement.isJsonObject()) {
                    litterSize = new RangedInteger(
                            JSONUtils.getAsInt(litterSizeElement.getAsJsonObject(), "min"),
                            JSONUtils.getAsInt(litterSizeElement.getAsJsonObject(), "max")
                    );
                } else {
                    throw new JsonSyntaxException("Excepted litter_size to be a JsonObject or Int, was " + JSONUtils.getType(litterSizeElement));
                }

                Set<Item> enrichmentItems = new HashSet<>();
                JsonArray enrichmentItemsArray = JSONUtils.getAsJsonArray(json, "enrichment_items");
                for (int i = 0; i < enrichmentItemsArray.size(); ++i) {
                    ResourceLocation enrichmentItemId = new ResourceLocation(JSONUtils.convertToString(enrichmentItemsArray.get(i), "enrichment_items[" + i + "]"));
                    Item enrichmentItem = ForgeRegistries.ITEMS.getValue(enrichmentItemId);
                    if (enrichmentItem == null || enrichmentItem == Items.AIR) throw new JsonSyntaxException("Unknown item: " + enrichmentItemId);
                    enrichmentItems.add(enrichmentItem);
                }

                Set<Block> enrichmentBlocks = new HashSet<>();
                JsonArray enrichmentBlocksArray = JSONUtils.getAsJsonArray(json, "enrichment_blocks");
                for (int i = 0; i < enrichmentBlocksArray.size(); ++i) {
                    ResourceLocation enrichmentBlockId = new ResourceLocation(JSONUtils.convertToString(enrichmentBlocksArray.get(i), "enrichment_blocks[" + i + "]"));
                    Block enrichmentBlock = ForgeRegistries.BLOCKS.getValue(enrichmentBlockId);
                    if (enrichmentBlock == null || enrichmentBlock == Blocks.AIR) throw new JsonSyntaxException("Unknown block: " + enrichmentBlockId);
                    enrichmentBlocks.add(enrichmentBlock);
                }

                JsonElement sizeElement = json.get("size");
                EntitySizeCategory size;
                if (sizeElement == null) {
                    throw new JsonSyntaxException("Missing size, expected to find a String or Int");
                } else if (litterSizeElement.isJsonPrimitive()) {
                    if (litterSizeElement.getAsJsonPrimitive().isNumber()) {
                        size = EntitySizeCategory.VALUES[litterSizeElement.getAsInt()];
                    } else {
                        size = EntitySizeCategory.valueOf(litterSizeElement.getAsString().toUpperCase(Locale.ROOT));
                    }
                } else {
                    throw new JsonSyntaxException("Excepted size to be a String or Int, was " + JSONUtils.getType(sizeElement));
                }

                stats.put(type, new EntityStats(diet, kibble, litterSize, enrichmentItems, enrichmentBlocks, size, maxVariants));
            } catch (Exception exception) {
                LOGGER.error("Failed to load stats for entity '" + entry.getKey() + "'", exception);
            }
        }
    }

    public EntityStats getStats(Entity entity) {
        return stats.get(entity.getType());
    }
}
