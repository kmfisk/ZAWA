package org.zawamod.zawa.block;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.zawamod.zawa.Zawa;
import org.zawamod.zawa.item.ZawaItems;

import java.util.function.Supplier;

public class ZawaBlocks {
    public static final DeferredRegister<Block> REGISTRAR = DeferredRegister.create(ForgeRegistries.BLOCKS, Zawa.MOD_ID);
    public static final RegistryObject<Block> EAGLE_PLUSH = register("eagle_plush", PlushBlock::new);
    public static final RegistryObject<Block> ELEPHANT_PLUSH = register("elephant_plush", PlushBlock::new);
    public static final RegistryObject<Block> FLAMINGO_PLUSH = register("flamingo_plush", PlushBlock::new);
    public static final RegistryObject<Block> GIRAFFE_PLUSH = register("giraffe_plush", PlushBlock::new);
    public static final RegistryObject<Block> GORILLA_PLUSH = register("gorilla_plush", PlushBlock::new);
    public static final RegistryObject<Block> GRIZZLY_PLUSH = register("grizzly_plush", PlushBlock::new);
    public static final RegistryObject<Block> KANGAROO_PLUSH = register("kangaroo_plush", PlushBlock::new);
    public static final RegistryObject<Block> KOALA_PLUSH = register("koala_plush", PlushBlock::new);
    public static final RegistryObject<Block> LION_PLUSH = register("lion_plush", PlushBlock::new);
    public static final RegistryObject<Block> BLUE_MACAW_PLUSH = register("blue_macaw_plush", PlushBlock::new);
    public static final RegistryObject<Block> RED_MACAW_PLUSH = register("red_macaw_plush", PlushBlock::new);
    public static final RegistryObject<Block> MANDRILL_PLUSH = register("mandrill_plush", PlushBlock::new);
    public static final RegistryObject<Block> MONKEY_PLUSH = register("monkey_plush", PlushBlock::new);
    public static final RegistryObject<Block> MOOSE_PLUSH = register("moose_plush", PlushBlock::new);
    public static final RegistryObject<Block> OCTOPUS_PLUSH = register("octopus_plush", PlushBlock::new);
    public static final RegistryObject<Block> OKAPI_PLUSH = register("okapi_plush", PlushBlock::new);
    public static final RegistryObject<Block> ORCA_PLUSH = register("orca_plush", PlushBlock::new);
    public static final RegistryObject<Block> PANDA_PLUSH = register("panda_plush", PlushBlock::new);
    public static final RegistryObject<Block> PINK_PANDA_PLUSH = register("pink_panda_plush", PlushBlock::new);
    public static final RegistryObject<Block> PENGUIN_PLUSH = register("penguin_plush", PlushBlock::new);
    public static final RegistryObject<Block> PLATYPUS_PLUSH = register("platypus_plush", PlushBlock::new);
    public static final RegistryObject<Block> RED_PANDA_PLUSH = register("red_panda_plush", PlushBlock::new);
    public static final RegistryObject<Block> RHINO_PLUSH = register("rhino_plush", PlushBlock::new);
    public static final RegistryObject<Block> TIGER_PLUSH = register("tiger_plush", PlushBlock::new);
    public static final RegistryObject<Block> TURTLE_PLUSH = register("turtle_plush", PlushBlock::new);
    public static final RegistryObject<Block> ZEBRA_PLUSH = register("zebra_plush", PlushBlock::new);
    public static final RegistryObject<Block> RAINBOW_ZEBRA_PLUSH = register("rainbow_zebra_plush", PlushBlock::new);

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> registryObject = REGISTRAR.register(name, block);
        ZawaItems.REGISTRAR.register(name, () -> new BlockItem(registryObject.get(), new Item.Properties().tab(Zawa.GROUP)));
        return registryObject;
    }
}
