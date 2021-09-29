package org.zawamod.zawa.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import org.zawamod.zawa.Zawa;
import org.zawamod.zawa.client.renderer.entity.model.GrevysZebraModel;
import org.zawamod.zawa.entity.GrevysZebraEntity;

public class GrevysZebraRenderer extends MobRenderer<GrevysZebraEntity, GrevysZebraModel> {
    public static final ResourceLocation[] TEXTURES = new ResourceLocation[]{
            new ResourceLocation(Zawa.MOD_ID, "textures/entity/grevys_zebra/grevys_zebra_1.png"),
            new ResourceLocation(Zawa.MOD_ID, "textures/entity/grevys_zebra/grevys_zebra_2.png"),
            new ResourceLocation(Zawa.MOD_ID, "textures/entity/grevys_zebra/grevys_zebra_3.png")
    };
    public static final ResourceLocation BLINK = new ResourceLocation(Zawa.MOD_ID, "textures/entity/grevys_zebra/grevys_zebra_blink.png");
    public static final ResourceLocation BABY_TEXTURE = new ResourceLocation(Zawa.MOD_ID, "textures/entity/grevys_zebra/grevys_zebra_baby.png");
    public static final ResourceLocation BABY_BLINK = new ResourceLocation(Zawa.MOD_ID, "textures/entity/grevys_zebra/grevys_zebra_blink_baby.png");
    private final GrevysZebraModel adultModel;
    private final GrevysZebraModel babyModel;

    public GrevysZebraRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new GrevysZebraModel.Adult(), 1.0F);
        adultModel = model;
        babyModel = new GrevysZebraModel.Child();
    }

    @Override
    public void render(GrevysZebraEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        model = entityIn.isBaby() ? babyModel : adultModel;
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    protected void scale(GrevysZebraEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        super.scale(entitylivingbaseIn, matrixStackIn, partialTickTime);
        if (entitylivingbaseIn.isBaby())
            matrixStackIn.translate(0, 0, 0);
    }

    @Override
    public ResourceLocation getTextureLocation(GrevysZebraEntity entity) {
        if (entity.isBaby()) return BABY_TEXTURE;
        return TEXTURES[entity.getVariant()];
    }
}
