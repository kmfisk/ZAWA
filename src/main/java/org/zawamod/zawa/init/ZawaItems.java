package org.zawamod.zawa.init;

import net.minecraft.item.BlockItem;
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

    // Block Items
    public static final RegistryObject<Item> ROPE_FENCE = REGISTER.register("rope_fence", () -> new BlockItem(ZawaBlocks.ROPE_FENCE.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> ELEPHANT_PLUSH = REGISTER.register("elephant_plush", () -> new BlockItem(ZawaBlocks.ELEPHANT_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> FLAMINGO_PLUSH = REGISTER.register("flamingo_plush", () -> new BlockItem(ZawaBlocks.FLAMINGO_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> GIRAFFE_PLUSH = REGISTER.register("giraffe_plush", () -> new BlockItem(ZawaBlocks.GIRAFFE_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> GORILLA_PLUSH = REGISTER.register("gorilla_plush", () -> new BlockItem(ZawaBlocks.GORILLA_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> GRIZZLY_PLUSH = REGISTER.register("grizzly_plush", () -> new BlockItem(ZawaBlocks.GRIZZLY_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> KANGAROO_PLUSH = REGISTER.register("kangaroo_plush", () -> new BlockItem(ZawaBlocks.KANGAROO_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> KOALA_PLUSH = REGISTER.register("koala_plush", () -> new BlockItem(ZawaBlocks.KOALA_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> LION_PLUSH = REGISTER.register("lion_plush", () -> new BlockItem(ZawaBlocks.LION_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> MACAW_PLUSH = REGISTER.register("macaw_plush", () -> new BlockItem(ZawaBlocks.MACAW_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> MANDRILL_PLUSH = REGISTER.register("mandrill_plush", () -> new BlockItem(ZawaBlocks.MANDRILL_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> MONKEY_PLUSH = REGISTER.register("monkey_plush", () -> new BlockItem(ZawaBlocks.MONKEY_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> MOOSE_PLUSH = REGISTER.register("moose_plush", () -> new BlockItem(ZawaBlocks.MOOSE_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> OKAPI_PLUSH = REGISTER.register("okapi_plush", () -> new BlockItem(ZawaBlocks.OKAPI_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> PANDA_PLUSH = REGISTER.register("panda_plush", () -> new BlockItem(ZawaBlocks.PANDA_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> PENGUIN_PLUSH = REGISTER.register("penguin_plush", () -> new BlockItem(ZawaBlocks.PENGUIN_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> RED_PANDA_PLUSH = REGISTER.register("red_panda_plush", () -> new BlockItem(ZawaBlocks.RED_PANDA_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> RHINO_PLUSH = REGISTER.register("rhino_plush", () -> new BlockItem(ZawaBlocks.RHINO_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> TIGER_PLUSH = REGISTER.register("tiger_plush", () -> new BlockItem(ZawaBlocks.TIGER_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
    public static final RegistryObject<Item> ZEBRA_PLUSH = REGISTER.register("zebra_plush", () -> new BlockItem(ZawaBlocks.ZEBRA_PLUSH.get(), new Item.Properties().group(Zawa.GROUP)));
}
