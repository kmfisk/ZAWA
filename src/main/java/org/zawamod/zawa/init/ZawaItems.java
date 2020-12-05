package org.zawamod.zawa.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.zawamod.zawa.Zawa;

public class ZawaItems {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Zawa.MOD_ID);
    public static final RegistryObject<Item> HERBIVORE_KIBBLE = REGISTER.register("herbivore_kibble", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CARNIVORE_KIBBLE = REGISTER.register("carnivore_kibble", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OMNIVORE_KIBBLE = REGISTER.register("omnivore_kibble", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PISCIVORE_KIBBLE = REGISTER.register("piscivore_kibble", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INSECTIVORE_KIBBLE = REGISTER.register("insectivore_kibble", () -> new Item(new Item.Properties()));
}
