package org.zawamod.zawa.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.zawamod.zawa.Zawa;
import org.zawamod.zawa.client.renderer.entity.model.MotorBoatModel;
import org.zawamod.zawa.entity.item.MotorBoatEntity;

@OnlyIn(Dist.CLIENT)
public class MotorBoatRenderer extends EntityRenderer<MotorBoatEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Zawa.MOD_ID, "textures/entity/motor_boat.png");
    protected final MotorBoatModel modelBoat = new MotorBoatModel();

    public MotorBoatRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
        this.shadowRadius = 0.8F;
    }

    @Override
    public void render(MotorBoatEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.0D, 0.375D, 0.0D);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0F));
        float f = (float)entityIn.getHurtTime() - partialTicks;
        float f1 = entityIn.getDamage() - partialTicks;
        if (f1 < 0.0F) {
            f1 = 0.0F;
        }

        if (f > 0.0F) {
            matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(MathHelper.sin(f) * f * f1 / 10.0F * (float)entityIn.getHurtDir()));
        }

        float f2 = entityIn.getBubbleAngle(partialTicks);
        if (!MathHelper.equal(f2, 0.0F)) {
            matrixStackIn.mulPose(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), entityIn.getBubbleAngle(partialTicks), true));
        }

        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90.0F));
        this.modelBoat.setupAnim(entityIn, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(this.modelBoat.renderType(this.getTextureLocation(entityIn)));
        this.modelBoat.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        if (!entityIn.isSwimming()) {
            IVertexBuilder ivertexbuilder1 = bufferIn.getBuffer(RenderType.waterMask());
            this.modelBoat.noWater.render(matrixStackIn, ivertexbuilder1, packedLightIn, OverlayTexture.NO_OVERLAY);
        }

        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
    @Override
    public ResourceLocation getTextureLocation(MotorBoatEntity entity) {
        return TEXTURE;
    }
}
