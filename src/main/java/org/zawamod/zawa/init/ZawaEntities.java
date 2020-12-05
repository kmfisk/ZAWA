package org.zawamod.zawa.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Tuple;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.thread.EffectiveSide;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.zawamod.zawa.Zawa;
import org.zawamod.zawa.client.renderer.entity.KoalaRenderer;
import org.zawamod.zawa.entity.KoalaEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ZawaEntities {
    private static final List<Tuple<RegistryObject<EntityType<? extends LivingEntity>>, AttributeModifierMap.MutableAttribute>> ATTRIBUTES = new ArrayList<>();
    private static final List<Tuple<RegistryObject<EntityType<?>>, Supplier<IRenderFactory<?>>>> RENDERERS = new ArrayList<>();
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, Zawa.MOD_ID);
    public static final RegistryObject<EntityType<KoalaEntity>> KOALA = new Builder<>(KoalaEntity::new, EntityClassification.CREATURE)
            .attributes(KoalaEntity.registerKoalaAttributes())
            .renderer(() -> KoalaRenderer::new)
            .size(0.7f, 0.7f)
            .build("koala");

    public static void registerAttributes() {
        for (Tuple<RegistryObject<EntityType<? extends LivingEntity>>, AttributeModifierMap.MutableAttribute> attribute : ATTRIBUTES) {
            GlobalEntityTypeAttributes.put(attribute.getA().get(), attribute.getB().create());
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderers() {
        for (Tuple<RegistryObject<EntityType<?>>, Supplier<IRenderFactory<?>>> renderer : RENDERERS) {
            RenderingRegistry.registerEntityRenderingHandler(renderer.getA().get(), cast(renderer.getB().get()));
        }
    }

    @SuppressWarnings("unchecked")
    private static <T, F> T cast(F from) {
        return (T) from;
    }

    private static class Builder<T extends Entity> {
        private final EntityType.IFactory<T> factory;
        private final EntityClassification category;
        private AttributeModifierMap.MutableAttribute attributes;
        private Supplier<IRenderFactory<? super T>> renderer;
        private float width, height;

        private Builder(EntityType.IFactory<T> factory, EntityClassification category) {
            this.factory = factory;
            this.category = category;
        }

        private Builder<T> attributes(AttributeModifierMap.MutableAttribute attributes) {
            this.attributes = attributes;
            return this;
        }

        private Builder<T> renderer(Supplier<IRenderFactory<? super T>> renderer) {
            this.renderer = renderer;
            return this;
        }

        private Builder<T> size(float width, float height) {
            this.width = width;
            this.height = height;
            return this;
        }

        private RegistryObject<EntityType<T>> build(String name) {
            final Item.Properties spawnEggBuilder = new Item.Properties().group(ItemGroup.MISC);
            RegistryObject<EntityType<T>> type = REGISTER.register(name, () -> EntityType.Builder.create(factory, category).size(width, height).build(Zawa.MOD_ID + "." + name));
            if (attributes != null) {
                ATTRIBUTES.add(new Tuple<>(cast(type), attributes));
            }

            if (EffectiveSide.get().isClient() && renderer != null) {
                RENDERERS.add(new Tuple<>(cast(type), cast(renderer)));
            }

            ZawaItems.REGISTER.register(name + "_spawn_egg", () -> new SpawnEggItem(type.get(), 0xFFFFFF, 0xFFFFFF, spawnEggBuilder));
            return type;
        }
    }
}
