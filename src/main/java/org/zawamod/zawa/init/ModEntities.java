package org.zawamod.zawa.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.zawamod.zawa.ZawaMod;
import org.zawamod.zawa.client.renderer.entity.KoalaRenderer;
import org.zawamod.zawa.entity.KoalaEntity;
import org.zawamod.zawa.item.CustomSpawnEggItem;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, ZawaMod.MOD_ID);
    public static final EntityType<KoalaEntity> KOALA = register("koala", KoalaEntity::new, EntityClassification.CREATURE, 0.7F, 0.7F);

    private static <T extends Entity> EntityType<T> register(String name, EntityType.IFactory<T> factory, EntityClassification classification, float width, float height) {
        final Item.Properties properties = new Item.Properties().group(ItemGroup.MISC);
        EntityType<T> entityType = EntityType.Builder.create(factory, classification).size(width, height).build(name);
        REGISTER.register(name, () -> entityType);
        ModItems.REGISTER.register(name + "_spawn_egg", () -> new CustomSpawnEggItem(entityType, properties));
        return entityType;
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(KOALA, KoalaRenderer::new);
    }
}
