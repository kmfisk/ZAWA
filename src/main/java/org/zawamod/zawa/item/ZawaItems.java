package org.zawamod.zawa.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.zawamod.zawa.Zawa;

public class ZawaItems {
    public static final DeferredRegister<Item> REGISTRAR = DeferredRegister.create(ForgeRegistries.ITEMS, Zawa.MOD_ID);
    public static final RegistryObject<Item> HERBIVORE_KIBBLE = REGISTRAR.register("herbivore_kibble", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CARNIVORE_KIBBLE = REGISTRAR.register("carnivore_kibble", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OMNIVORE_KIBBLE = REGISTRAR.register("omnivore_kibble", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PISCIVORE_KIBBLE = REGISTRAR.register("piscivore_kibble", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INSECTIVORE_KIBBLE = REGISTRAR.register("insectivore_kibble", () -> new Item(new Item.Properties()));
    public static final RegistryObject<MotorBoatItem> MOTOR_BOAT = REGISTRAR.register("motor_boat", MotorBoatItem::new);
}
