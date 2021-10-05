package org.zawamod.zawa.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.zawamod.zawa.Zawa;
import org.zawamod.zawa.client.renderer.entity.model.AngelfishModel;
import org.zawamod.zawa.entity.AngelfishEntity;

@OnlyIn(Dist.CLIENT)
public class AngelfishRenderer extends MobRenderer<AngelfishEntity, AngelfishModel> {
    public static final ResourceLocation[] TEXTURES = new ResourceLocation[]{
            new ResourceLocation(Zawa.MOD_ID, "textures/entity/angelfish/angelfish_1.png"),
            new ResourceLocation(Zawa.MOD_ID, "textures/entity/angelfish/angelfish_2.png"),
            new ResourceLocation(Zawa.MOD_ID, "textures/entity/angelfish/angelfish_3.png"),
            new ResourceLocation(Zawa.MOD_ID, "textures/entity/angelfish/angelfish_4.png"),
            new ResourceLocation(Zawa.MOD_ID, "textures/entity/angelfish/angelfish_5.png"),
            new ResourceLocation(Zawa.MOD_ID, "textures/entity/angelfish/angelfish_6.png"),
            new ResourceLocation(Zawa.MOD_ID, "textures/entity/angelfish/angelfish_7.png"),
            new ResourceLocation(Zawa.MOD_ID, "textures/entity/angelfish/angelfish_8.png")
    };

    public AngelfishRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new AngelfishModel(), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(AngelfishEntity entity) {
        return TEXTURES[entity.getVariant()];
    }

    @Override
    protected void setupRotations(AngelfishEntity entity, MatrixStack stack, float p_225621_3_, float p_225621_4_, float p_225621_5_) {
        super.setupRotations(entity, stack, p_225621_3_, p_225621_4_, p_225621_5_);
        float f = 4.3F * MathHelper.sin(0.6F * p_225621_3_);
        stack.mulPose(Vector3f.YP.rotationDegrees(f));
        if (!entity.isInWater()) {
            stack.translate(0.1F, 0.1F, -0.1F);
            stack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
        }
    }
}
