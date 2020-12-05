package org.zawamod.zawa;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zawamod.zawa.init.ZawaEntities;
import org.zawamod.zawa.init.ZawaItems;

@Mod(Zawa.MOD_ID)
public class Zawa {
    public static final String MOD_ID = "zawa";
    private static final Logger LOGGER = LogManager.getLogger();

    public Zawa() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(this::setupClient);

        ZawaEntities.REGISTER.register(bus);
        ZawaItems.REGISTER.register(bus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        ZawaEntities.registerAttributes();
    }

    private void setupClient(final FMLClientSetupEvent event) {
        ZawaEntities.registerRenderers();
    }
}
