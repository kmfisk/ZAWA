package org.zawamod.zawa.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import org.zawamod.zawa.Zawa;
import org.zawamod.zawa.client.renderer.entity.model.KoalaModel;
import org.zawamod.zawa.entity.KoalaEntity;

public class KoalaRenderer extends MobRenderer<KoalaEntity, KoalaModel> {
//    public static final List<Tuple<ResourceLocation, ResourceLocation>> TEXTURES = new ArrayList<>();
    public static final ResourceLocation[] TEXTURES = new ResourceLocation[] {
        new ResourceLocation(Zawa.MOD_ID, "textures/entity/koala/koala_1.png"),
        new ResourceLocation(Zawa.MOD_ID, "textures/entity/koala/koala_2.png"),
        new ResourceLocation(Zawa.MOD_ID, "textures/entity/koala/koala_3.png")
    };
    public static final ResourceLocation BLINK = new ResourceLocation(Zawa.MOD_ID, "textures/entity/koala/koala_blink.png");
    public static final ResourceLocation BABY_TEXTURE = new ResourceLocation(Zawa.MOD_ID, "textures/entity/koala/koala_baby.png");
    public static final ResourceLocation BABY_BLINK = new ResourceLocation(Zawa.MOD_ID, "textures/entity/koala/koala_blink_baby.png");
    private final KoalaModel adultModel;
    private final KoalaModel babyModel;

    public KoalaRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new KoalaModel.Adult(), 0.5F);
        adultModel = entityModel;
        babyModel = new KoalaModel.Child();
    }

    @Override
    public void render(KoalaEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        entityModel = entityIn.isChild() ? babyModel : adultModel;
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    protected void preRenderCallback(KoalaEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
        super.preRenderCallback(entity, matrixStackIn, partialTickTime);
        if (entity.isChild())
            matrixStackIn.translate(0, -0.05, 0);
    }

    @Override
    public ResourceLocation getEntityTexture(KoalaEntity entity) {
        if (entity.isChild()) return BABY_TEXTURE;
        return TEXTURES[entity.getVariant()];
    }

    /*static {
        for (int i = 1; i <= 3; ++i) {
            TEXTURES.add(
                    new Tuple<>(
                            new ResourceLocation(Zawa.MOD_ID, "textures/entity/koala/koala_" + i + ".png"),
                            new ResourceLocation(Zawa.MOD_ID, "textures/entity/koala/koala_blink_" + i + ".png")
                    )
            );
        }
    }*/
}
