package org.zawamod.zawa.resources;

import com.google.gson.Gson;
import net.minecraft.client.resources.ReloadListener;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResource;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class EntityTypeDataManager extends ReloadListener<Map<EntityType<?>, EntityTypeData>> {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = new Gson();
    private Map<EntityType<?>, EntityTypeData> dataMap;

    @Override
    protected Map<EntityType<?>, EntityTypeData> prepare(IResourceManager resourceManagerIn, IProfiler profilerIn) {
        Map<EntityType<?>, EntityTypeData> map = new HashMap<>();
        for (Map.Entry<RegistryKey<EntityType<?>>, EntityType<?>> entry : ForgeRegistries.ENTITIES.getEntries()) {
            ResourceLocation key = entry.getKey().getRegistryName();
            try (IResource resource = resourceManagerIn.getResource(new ResourceLocation(key.getNamespace(), "entity_data/" + key.getPath()));
                 InputStream stream = resource.getInputStream();
                 Reader reader = new InputStreamReader(stream)) {
                map.put(entry.getValue(), GSON.fromJson(reader, EntityTypeData.class));
            } catch (IOException ignored) {
            }
        }
        return map;
    }

    @Override
    protected void apply(Map<EntityType<?>, EntityTypeData> objectIn, IResourceManager resourceManagerIn, IProfiler profilerIn) {
        dataMap = objectIn;
    }

    public EntityTypeData getData(Entity entity) {
        return dataMap.get(entity.getType());
    }
}
