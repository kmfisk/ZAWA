package org.zawamod.zawa;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.zawamod.zawa.block.ZawaBlocks;
import org.zawamod.zawa.entity.ZawaEntities;
import org.zawamod.zawa.entity.item.ZawaItemEntities;
import org.zawamod.zawa.item.ZawaItems;
import org.zawamod.zawa.resources.EntityDietManager;
import org.zawamod.zawa.resources.EntityStatsManager;

@Mod(Zawa.MOD_ID)
public class Zawa {
    public static final String MOD_ID = "zawa";

    public static final ItemGroup GROUP = new ItemGroup(MOD_ID + ".tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ZawaBlocks.ELEPHANT_PLUSH.get());
        }
    };

    public Zawa() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.addListener(this::registerDatapackListeners);
        bus.addListener(this::registerAttributes);
        bus.addListener(this::setupClient);

        ZawaItemEntities.REGISTRAR.register(bus);
        ZawaEntities.REGISTRAR.register(bus);
        ZawaItems.REGISTRAR.register(bus);
        ZawaBlocks.REGISTRAR.register(bus);
    }

    private void registerDatapackListeners(AddReloadListenerEvent event) {
        event.addListener(EntityDietManager.INSTANCE);
        event.addListener(EntityStatsManager.INSTANCE);
    }

    private void registerAttributes(final EntityAttributeCreationEvent event) {
        ZawaEntities.registerAttributes((type, builder) -> event.put(type, builder.build()));
    }

    private void setupClient(final FMLClientSetupEvent event) {
        ZawaEntities.registerRenderers();
    }
}
