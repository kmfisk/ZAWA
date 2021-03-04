package org.zawamod.zawa.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import org.zawamod.zawa.Zawa;
import org.zawamod.zawa.client.renderer.entity.model.CommonHippopotamusModel;
import org.zawamod.zawa.entity.CommonHippopotamusEntity;

public class CommonHippopotamusRenderer extends MobRenderer<CommonHippopotamusEntity, CommonHippopotamusModel> {
    public static final ResourceLocation[] TEXTURES = new ResourceLocation[]{
            new ResourceLocation(Zawa.MOD_ID, "textures/entity/common_hippopotamus/common_hippopotamus_1.png"),
            new ResourceLocation(Zawa.MOD_ID, "textures/entity/common_hippopotamus/common_hippopotamus_2.png"),
            new ResourceLocation(Zawa.MOD_ID, "textures/entity/common_hippopotamus/common_hippopotamus_3.png")
    };
    public static final ResourceLocation BLINK = new ResourceLocation(Zawa.MOD_ID, "textures/entity/common_hippopotamus/common_hippopotamus_blink.png");
    public static final ResourceLocation BABY_TEXTURE = new ResourceLocation(Zawa.MOD_ID, "textures/entity/common_hippopotamus/common_hippopotamus_baby.png");
    public static final ResourceLocation BABY_BLINK = new ResourceLocation(Zawa.MOD_ID, "textures/entity/common_hippopotamus/common_hippopotamus_blink_baby.png");
    private final CommonHippopotamusModel adultModel;
    private final CommonHippopotamusModel babyModel;

    public CommonHippopotamusRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CommonHippopotamusModel.Adult(), 1.0F);
        adultModel = entityModel;
        babyModel = new CommonHippopotamusModel.Child();
    }

    @Override
    public void render(CommonHippopotamusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        entityModel = entityIn.isChild() ? babyModel : adultModel;
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    protected void preRenderCallback(CommonHippopotamusEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
        if (entitylivingbaseIn.isChild())
            matrixStackIn.translate(0, 0, 0);
    }

    @Override
    public ResourceLocation getEntityTexture(CommonHippopotamusEntity entity) {
        if (entity.isChild()) return BABY_TEXTURE;
        return TEXTURES[entity.getVariant()];
    }
}
