package org.zawamod.zawa.entity.item;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import org.zawamod.zawa.client.renderer.entity.MotorBoatRenderer;
import org.zawamod.zawa.entity.ZawaEntities;

public class ZawaItemEntities {
    public static final RegistryObject<EntityType<MotorBoatEntity>> MOTOR_BOAT = new ZawaEntities.Builder<MotorBoatEntity>(MotorBoatEntity::new, EntityClassification.MISC)
            .renderer(() -> MotorBoatRenderer::new)
            .build("motor_boat");
}
