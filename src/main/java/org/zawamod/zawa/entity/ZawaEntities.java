package org.zawamod.zawa.entity;

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
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.thread.EffectiveSide;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.zawamod.zawa.Zawa;
import org.zawamod.zawa.client.renderer.entity.CommonHippopotamusRenderer;
import org.zawamod.zawa.client.renderer.entity.GrevysZebraRenderer;
import org.zawamod.zawa.client.renderer.entity.KoalaRenderer;
import org.zawamod.zawa.item.ZawaItems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ZawaEntities {
    private static final List<Tuple<RegistryObject<EntityType<? extends LivingEntity>>, Supplier<AttributeModifierMap.MutableAttribute>>> ATTRIBUTES = new ArrayList<>();
    private static final List<Tuple<RegistryObject<EntityType<?>>, Supplier<IRenderFactory<?>>>> RENDERERS = new ArrayList<>();
    private static final List<Tuple<RegistryObject<EntityType<?>>, List<SpawnInfo>>> SPAWNS = new ArrayList<>();
    public static final DeferredRegister<EntityType<?>> REGISTRAR = DeferredRegister.create(ForgeRegistries.ENTITIES, Zawa.MOD_ID);

    public static final RegistryObject<EntityType<KoalaEntity>> KOALA = new Builder<>(KoalaEntity::new, EntityClassification.CREATURE)
            .attributes(KoalaEntity::registerKoalaAttributes)
            .renderer(() -> KoalaRenderer::new)
            .size(0.7f, 0.7f)
            .build(REGISTRAR, "koala");

    public static final RegistryObject<EntityType<CommonHippopotamusEntity>> COMMON_HIPPOPOTAMUS = new Builder<>(CommonHippopotamusEntity::new, EntityClassification.CREATURE)
            .attributes(CommonHippopotamusEntity::registerHippoAttributes)
            .renderer(() -> CommonHippopotamusRenderer::new)
            .size(1.5F, 1.5F)
            .build(REGISTRAR, "common_hippopotamus");

    public static final RegistryObject<EntityType<GrevysZebraEntity>> GREVYS_ZEBRA = new Builder<>(GrevysZebraEntity::new, EntityClassification.CREATURE)
            .attributes(GrevysZebraEntity::registerZebraAttributes)
            .renderer(() -> GrevysZebraRenderer::new)
            .size(2.0F, 2.0F)
//            .spawn(new SpawnInfo(something, 3, 4, 10))
            .build(REGISTRAR, "grevys_zebra");

    public static void registerAttributes(BiConsumer<EntityType<? extends LivingEntity>, AttributeModifierMap.MutableAttribute> register) {
        for (Tuple<RegistryObject<EntityType<? extends LivingEntity>>, Supplier<AttributeModifierMap.MutableAttribute>> attribute : ATTRIBUTES) {
            register.accept(attribute.getA().get(), attribute.getB().get());
        }
        ATTRIBUTES.clear();
    }

    public static void registerRenderers() {
        for (Tuple<RegistryObject<EntityType<?>>, Supplier<IRenderFactory<?>>> renderer : RENDERERS) {
            RenderingRegistry.registerEntityRenderingHandler(renderer.getA().get(), cast(renderer.getB().get()));
        }
        RENDERERS.clear();
    }

    public static void addBiomeSpawns(MobSpawnInfoBuilder spawnBuilder, Biome.Climate climate, Biome.Category category, float depth, float scale, int treeCount) {
        for (Tuple<RegistryObject<EntityType<?>>, List<SpawnInfo>> spawn : SPAWNS) {
            EntityType<?> type = spawn.getA().get();
            for (SpawnInfo spawnInfo : spawn.getB()) {
                if (spawnInfo.predicate.invoke(climate, category, depth, scale, treeCount)) {
                    spawnBuilder.getSpawner(type.getCategory()).add(new MobSpawnInfo.Spawners(type, spawnInfo.weight, spawnInfo.groupMinimum, spawnInfo.groupMaximum));
                }
            }
        }
        SPAWNS.clear();
    }

    @SuppressWarnings("unchecked")
    private static <T, F> T cast(F from) {
        return (T) from;
    }

    public static class Builder<T extends Entity> {
        private final EntityType.IFactory<T> factory;
        private final EntityClassification category;
        private Supplier<AttributeModifierMap.MutableAttribute> attributes;
        private Supplier<IRenderFactory<? super T>> renderer;
        private float width, height;
        private final List<SpawnInfo> spawnInfos = new ArrayList<>();
        private Consumer<EntityType.Builder<T>> builderConsumer;

        public Builder(EntityType.IFactory<T> factory, EntityClassification category) {
            this.factory = factory;
            this.category = category;
        }

        public Builder<T> attributes(Supplier<AttributeModifierMap.MutableAttribute> attributes) {
            this.attributes = attributes;
            return this;
        }

        public Builder<T> renderer(Supplier<IRenderFactory<? super T>> renderer) {
            this.renderer = renderer;
            return this;
        }

        public Builder<T> size(float width, float height) {
            this.width = width;
            this.height = height;
            return this;
        }

        public Builder<T> spawn(SpawnInfo spawnInfo) {
            spawnInfos.add(spawnInfo);
            return this;
        }

        public Builder<T> additional(Consumer<EntityType.Builder<T>> consumer) {
            builderConsumer = consumer;
            return this;
        }

        public RegistryObject<EntityType<T>> build(DeferredRegister<EntityType<?>> registrar, String name) {
            final Item.Properties spawnEggBuilder = new Item.Properties().tab(Zawa.ENTITIES_GROUP);
            final EntityType.Builder<T> entityBuilder = EntityType.Builder.of(factory, category).sized(width, height);
            if (builderConsumer != null) builderConsumer.accept(entityBuilder);
            final EntityType<T> builtType = entityBuilder.build(Zawa.MOD_ID + "." + name);
            final RegistryObject<EntityType<T>> type = registrar.register(name, () -> builtType);
            if (attributes != null) {
                ATTRIBUTES.add(new Tuple<>(cast(type), attributes));
            }

            if (EffectiveSide.get().isClient() && renderer != null) {
                RENDERERS.add(new Tuple<>(cast(type), cast(renderer)));
            }

            if (!spawnInfos.isEmpty()) {
                SPAWNS.add(new Tuple<>(cast(type), spawnInfos));
            }

            ZawaItems.REGISTRAR.register(name + "_spawn_egg", () -> new SpawnEggItem(builtType, 0xFFFFFF, 0xFFFFFF, spawnEggBuilder));
            return type;
        }
    }

    public static class SpawnInfo {
        private final SpawnPredicate predicate;
        private final int groupMinimum, groupMaximum, weight;

        public SpawnInfo(SpawnPredicate predicate, int groupMinimum, int groupMaximum, int weight) {
            this.predicate = predicate;
            this.groupMinimum = groupMinimum;
            this.groupMaximum = groupMaximum;
            this.weight = weight;
        }
    }

    @FunctionalInterface
    public interface SpawnPredicate {
        boolean invoke(Biome.Climate climate, Biome.Category category, float depth, float scale, int treeCount);
    }
}
