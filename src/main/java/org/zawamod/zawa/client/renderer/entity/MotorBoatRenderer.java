package org.zawamod.zawa.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import org.zawamod.zawa.Zawa;
import org.zawamod.zawa.entity.item.MotorBoatEntity;

public class MotorBoatRenderer extends EntityRenderer<MotorBoatEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Zawa.MOD_ID, "textures/entity/motor_boat.png");

    public MotorBoatRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    public ResourceLocation getTextureLocation(MotorBoatEntity entity) {
        return null;
    }
}
