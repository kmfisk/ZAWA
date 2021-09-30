package org.zawamod.zawa.resources;

import com.google.gson.*;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.client.resources.JsonReloadListener;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResourceManager;
import net.minecraft.tags.ITag;
import net.minecraft.tags.TagCollectionManager;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class EntityDietManager extends JsonReloadListener {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    public static final EntityDietManager INSTANCE = new EntityDietManager();

    private final Map<ResourceLocation, Object2IntMap<Item>> diets = new HashMap<>();

    public EntityDietManager() {
        super(GSON, "diets");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> map, IResourceManager resourceManager, IProfiler profiler) {
        diets.clear();
        for (Map.Entry<ResourceLocation, JsonElement> entry : map.entrySet()) {
            try {
                JsonObject json = JSONUtils.convertToJsonObject(entry.getValue(), "top element");
                Object2IntMap<Item> items = new Object2IntOpenHashMap<>();
                for (Map.Entry<String, JsonElement> element : json.entrySet()) {
                    if (element.getKey().startsWith("#")) {
                        ResourceLocation id = new ResourceLocation(element.getKey().substring(1));
                        ITag<Item> tag = TagCollectionManager.getInstance().getItems().getTag(id);
                        if (tag == null) {
                            throw new JsonSyntaxException("Unknown tag: " + id);
                        }
                        int amount = JSONUtils.convertToInt(element.getValue(), element.getKey());
                        for (Item item : tag.getValues()) {
                            items.put(item, amount);
                        }
                    } else {
                        ResourceLocation id = new ResourceLocation(element.getKey());
                        Item item = ForgeRegistries.ITEMS.getValue(id);
                        if (item == null || item == Items.AIR) {
                            throw new JsonSyntaxException("Unknown item: " + id);
                        }
                        items.put(item, JSONUtils.convertToInt(element.getValue(), element.getKey()));
                    }
                }
                diets.put(entry.getKey(), items);
            } catch (Exception exception) {
                LOGGER.error("Failed to load diet '" + entry.getKey() + "'", exception);
            }
        }
    }

    public Object2IntMap<Item> getDiet(ResourceLocation id) {
        return diets.get(id);
    }
}
