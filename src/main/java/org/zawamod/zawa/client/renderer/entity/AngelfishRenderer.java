package org.zawamod.zawa.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import org.zawamod.zawa.client.renderer.entity.model.AngelfishModel;
import org.zawamod.zawa.entity.AngelfishEntity;

public class AngelfishRenderer extends MobRenderer<AngelfishEntity, AngelfishModel> { //todo
    public AngelfishRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new AngelfishModel(), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(AngelfishEntity p_110775_1_) {
        return null;
    }
}
