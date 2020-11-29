package org.zawamod.zawa;

import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zawamod.zawa.entity.KoalaEntity;
import org.zawamod.zawa.init.ModEntities;
import org.zawamod.zawa.init.ModItems;

@Mod(ZawaMod.MOD_ID)
public class ZawaMod {
    public static final String MOD_ID = "zawa";
    private static final Logger LOGGER = LogManager.getLogger();

    public ZawaMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(this::setupClient);

        ModEntities.REGISTER.register(bus);
        ModItems.REGISTER.register(bus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        GlobalEntityTypeAttributes.put(ModEntities.KOALA, KoalaEntity.registerKoalaAttributes().create());
    }

    private void setupClient(final FMLClientSetupEvent event) {
        ModEntities.registerRenderers();
    }
}
