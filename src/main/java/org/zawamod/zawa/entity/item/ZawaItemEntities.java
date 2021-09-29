package org.zawamod.zawa.entity.item;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.zawamod.zawa.Zawa;
import org.zawamod.zawa.client.renderer.entity.MotorBoatRenderer;
import org.zawamod.zawa.entity.ZawaEntities;

public class ZawaItemEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRAR = DeferredRegister.create(ForgeRegistries.ENTITIES, Zawa.MOD_ID);

    public static final RegistryObject<EntityType<MotorBoatEntity>> MOTOR_BOAT = new ZawaEntities.Builder<MotorBoatEntity>(MotorBoatEntity::new, EntityClassification.MISC)
            .size(1.375F, 0.5625F)
            .renderer(() -> MotorBoatRenderer::new)
            .additional(builder -> builder.setTrackingRange(10))
            .build(REGISTRAR, "motor_boat");
}
