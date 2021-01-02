package org.zawamod.zawa.init;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.zawamod.zawa.Zawa;
import org.zawamod.zawa.block.PlushBlock;

public class ZawaBlocks {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Zawa.MOD_ID);
    public static final RegistryObject<Block> ELEPHANT_PLUSH = REGISTER.register("elephant_plush", PlushBlock::new);
    public static final RegistryObject<Block> FLAMINGO_PLUSH = REGISTER.register("flamingo_plush", PlushBlock::new);
    public static final RegistryObject<Block> GIRAFFE_PLUSH = REGISTER.register("giraffe_plush", PlushBlock::new);
    public static final RegistryObject<Block> GORILLA_PLUSH = REGISTER.register("gorilla_plush", PlushBlock::new);
    public static final RegistryObject<Block> GRIZZLY_PLUSH = REGISTER.register("grizzly_plush", PlushBlock::new);
    public static final RegistryObject<Block> KANGAROO_PLUSH = REGISTER.register("kangaroo_plush", PlushBlock::new);
    public static final RegistryObject<Block> KOALA_PLUSH = REGISTER.register("koala_plush", PlushBlock::new);
    public static final RegistryObject<Block> LION_PLUSH = REGISTER.register("lion_plush", PlushBlock::new);
    public static final RegistryObject<Block> MACAW_PLUSH = REGISTER.register("macaw_plush", PlushBlock::new);
    public static final RegistryObject<Block> MANDRILL_PLUSH = REGISTER.register("mandrill_plush", PlushBlock::new);
    public static final RegistryObject<Block> MONKEY_PLUSH = REGISTER.register("monkey_plush", PlushBlock::new);
    public static final RegistryObject<Block> MOOSE_PLUSH = REGISTER.register("moose_plush", PlushBlock::new);
    public static final RegistryObject<Block> OKAPI_PLUSH = REGISTER.register("okapi_plush", PlushBlock::new);
    public static final RegistryObject<Block> PANDA_PLUSH = REGISTER.register("panda_plush", PlushBlock::new);
    public static final RegistryObject<Block> PENGUIN_PLUSH = REGISTER.register("penguin_plush", PlushBlock::new);
    public static final RegistryObject<Block> RED_PANDA_PLUSH = REGISTER.register("red_panda_plush", PlushBlock::new);
    public static final RegistryObject<Block> RHINO_PLUSH = REGISTER.register("rhino_plush", PlushBlock::new);
    public static final RegistryObject<Block> TIGER_PLUSH = REGISTER.register("tiger_plush", PlushBlock::new);
    public static final RegistryObject<Block> ZEBRA_PLUSH = REGISTER.register("zebra_plush", PlushBlock::new);
}
