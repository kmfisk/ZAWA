package org.zawamod.zawa.item;

import net.minecraft.fluid.Fluids;
import net.minecraft.item.FishBucketItem;
import net.minecraft.item.Item;
import net.minecraft.util.Util;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.zawamod.zawa.Zawa;
import org.zawamod.zawa.entity.ZawaEntities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZawaItems {
    public static final DeferredRegister<Item> REGISTRAR = DeferredRegister.create(ForgeRegistries.ITEMS, Zawa.MOD_ID);

    public static final RegistryObject<Item> MOTOR_BOAT = REGISTRAR.register("motor_boat", MotorBoatItem::new);

    // Kibbles
    public static final RegistryObject<Item> CARNIVORE_KIBBLE = REGISTRAR.register("carnivore_kibble", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> HERBIVORE_KIBBLE = REGISTRAR.register("herbivore_kibble", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> INSECTIVORE_KIBBLE = REGISTRAR.register("insectivore_kibble", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> OMNIVORE_KIBBLE = REGISTRAR.register("omnivore_kibble", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> PISCIVORE_KIBBLE = REGISTRAR.register("piscivore_kibble", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> SHELLFISH_KIBBLE = REGISTRAR.register("shellfish_kibble", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));

    // Ambient critters
    public static final List<RegistryObject<Item>> BUTTERFLIES = Util.make(new ArrayList<>(), list -> {
        for (String butterfly : new String[]{
                "black_swallowtail", "blue_morpho", "cabbage_white", "checkered_white",
                "cloudless_sulphur", "eastern_tiger_swallowtail", "green_hairstreak",
                "monarch", "red_admiral", "tawny_emperor", "zebra_swallowtail"
        })
            list.add(REGISTRAR.register(butterfly + "_butterfly", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP))));

    });

    public static final List<RegistryObject<Item>> FISH = Util.make(new ArrayList<>(), list -> {
        for (String fish : new String[]{
                "angelfish", "cichlid", "clownfish", "corydoras", "dottyback", "gramma"
        })
            list.add(REGISTRAR.register(fish, () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP))));
    });

    public static final List<RegistryObject<Item>> PRAYING_MANTISES = Util.make(new ArrayList<>(), list -> {
        for (String prayingMantis : new String[]{
                "african", "chinese", "devils_flower", "european", "ghost", "orchid"
        })
            list.add(REGISTRAR.register(prayingMantis + "_praying_mantis", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP))));
    });

    public static final List<RegistryObject<Item>> SCORPIONS = Util.make(new ArrayList<>(), list -> {
        for (String scorpion : new String[]{
                "arizona_bark", "asian_forest", "common_yellow", "emperor",
                "giant_hairy_desert", "northern", "red_claw"
        })
            list.add(REGISTRAR.register(scorpion + "_scorpion", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP))));

    });

    public static final List<RegistryObject<Item>> TARANTULAS = Util.make(new ArrayList<>(), list -> {
        for (String tarantula : new String[]{
                "antilles_pinktoe", "brazilian_black", "chilean_rosehair", "cobalt_blue", "goliath_birdeater",
                "green_bottle_blue", "king_baboon", "mexican_red_knee", "western_desert"
        })
            list.add(REGISTRAR.register(tarantula + "_tarantula", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP))));
    });

    public static final RegistryObject<Item> ANGELFISH_BUCKET = REGISTRAR.register("angelfish_bucket", () -> new FishBucketItem(ZawaEntities.ANGELFISH, () -> Fluids.WATER, new Item.Properties().stacksTo(1).tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> BROWN_RAT = REGISTRAR.register("brown_rat", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> CRAB = REGISTRAR.register("crab", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> CRAWFISH = REGISTRAR.register("crawfish", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> GOLD_FISH = REGISTRAR.register("gold_fish", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> HONEY_BEE = REGISTRAR.register("honey_bee", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> LEAFCUTTER_ANT = REGISTRAR.register("leafcutter_ant", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));

    // Foods
    public static final RegistryObject<Item> CLAM = REGISTRAR.register("clam", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> COOKED_CRAB = REGISTRAR.register("cooked_crab", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> COOKED_CRAWFISH = REGISTRAR.register("cooked_crawfish", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> COOKED_RAT = REGISTRAR.register("cooked_rat", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> COOKED_LARGE_MEAT = REGISTRAR.register("cooked_large_meat", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> COOKED_MEDIUM_MEAT = REGISTRAR.register("cooked_medium_meat", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> COOKED_SMALL_MEAT = REGISTRAR.register("cooked_small_meat", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> EARTH_WORM = REGISTRAR.register("earth_worm", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> EUCALYPTUS = REGISTRAR.register("eucalyptus", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> MEALWORMS = REGISTRAR.register("mealworms", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> MUSSELS = REGISTRAR.register("mussels", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> SHRIMP = REGISTRAR.register("shrimp", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> SHED_SKIN = REGISTRAR.register("shed_skin", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> TOXIN_SAC = REGISTRAR.register("toxin_sac", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> TERMITES = REGISTRAR.register("termites", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> LARGE_MEAT = REGISTRAR.register("large_meat", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> MEDIUM_MEAT = REGISTRAR.register("medium_meat", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
    public static final RegistryObject<Item> SMALL_MEAT = REGISTRAR.register("small_meat", () -> new Item(new Item.Properties().tab(Zawa.ITEMS_GROUP)));
}
