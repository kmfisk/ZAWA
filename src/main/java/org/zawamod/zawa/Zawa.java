package org.zawamod.zawa;

import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zawamod.zawa.init.ZawaEntities;
import org.zawamod.zawa.init.ZawaItems;
import org.zawamod.zawa.resources.EntityTypeDataManager;

@Mod(Zawa.MOD_ID)
public class Zawa {
    public static final String MOD_ID = "zawa";
    public static final EntityTypeDataManager DATA_MANAGER = new EntityTypeDataManager();
    private static final Logger LOGGER = LogManager.getLogger();

    public Zawa() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::registerDatapackListeners);
        bus.addListener(this::setup);
        bus.addListener(this::setupClient);

        ZawaEntities.REGISTER.register(bus);
        ZawaItems.REGISTER.register(bus);
    }

    private void registerDatapackListeners(AddReloadListenerEvent event) {
        event.addListener(DATA_MANAGER);
    }

    private void setup(final FMLCommonSetupEvent event) {
        ZawaEntities.registerAttributes();
    }

    private void setupClient(final FMLClientSetupEvent event) {
        ZawaEntities.registerRenderers();
    }
}
