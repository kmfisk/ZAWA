package org.zawamod.zawa.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.zawamod.zawa.Zawa;
import org.zawamod.zawa.item.ZawaItems;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ZawaBlocks {
    public static final DeferredRegister<Block> REGISTRAR = DeferredRegister.create(ForgeRegistries.BLOCKS, Zawa.MOD_ID);

    public static final Map<String, RegistryObject<Block>> PLUSHIES = new HashMap<>();

    public static final RegistryObject<Block> HAY_BROWSE = register("hay_browse", () -> new EnrichmentBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> LEAF_BROWSE = register("leaf_browse", () -> new EnrichmentBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> HEAT_LAMP = register("heat_lamp", () -> new EnrichmentBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> HEAT_ROCK = register("heat_rock", () -> new EnrichmentBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> PUZZLE_FEEDER = register("puzzle_feeder", () -> new EnrichmentBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> SCRATCHING_POST = register("scratching_post", () -> new EnrichmentBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> SHOW_PERCH = register("show_perch", () -> new EnrichmentBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> TIRE_SWING = register("tire_swing", () -> new EnrichmentBlock(AbstractBlock.Properties.of(Material.WOOD)));
    public static final RegistryObject<Block> TIRE_SWING_HORIZONTAL = register("tire_swing_horizontal", () -> new EnrichmentBlock(AbstractBlock.Properties.of(Material.WOOD)));

    static {
        String[] plushies = new String[]{"eagle", "elephant", "flamingo", "giraffe", "gorilla", "grizzly", "kangaroo",
                "koala", "lion", "blue_macaw", "red_macaw", "mandrill", "monkey", "moose", "octopus", "okapi", "orca",
                "panda", "pink_panda", "penguin", "platypus", "red_panda", "rhino", "tiger", "turtle", "zebra",
                "rainbow_zebra"};

        for (String plush : plushies) {
            PLUSHIES.put(plush, register(plush + "_plush", PlushBlock::new));
        }
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> registryObject = REGISTRAR.register(name, block);
        ZawaItems.REGISTRAR.register(name, () -> new BlockItem(registryObject.get(), new Item.Properties().tab(Zawa.ITEMS_GROUP)));
        return registryObject;
    }
}
