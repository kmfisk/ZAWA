package org.zawamod.zawa;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zawamod.zawa.block.ZawaBlocks;
import org.zawamod.zawa.entity.ZawaEntities;
import org.zawamod.zawa.item.ZawaItems;
import org.zawamod.zawa.resources.EntityTypeDataManager;

@Mod(Zawa.MOD_ID)
public class Zawa {
    public static final String MOD_ID = "zawa";
    public static final EntityTypeDataManager DATA_MANAGER = new EntityTypeDataManager();
    private static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup GROUP = new ItemGroup(MOD_ID + ".tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ZawaBlocks.ELEPHANT_PLUSH.get());
        }
    };

    public Zawa() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.addListener(this::registerDatapackListeners);
        bus.addListener(this::setup);
        bus.addListener(this::setupClient);

        ZawaEntities.REGISTRAR.register(bus);
        ZawaItems.REGISTRAR.register(bus);
        ZawaBlocks.REGISTRAR.register(bus);
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
