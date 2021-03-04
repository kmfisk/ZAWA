package org.zawamod.zawa.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import org.zawamod.zawa.entity.GrevysZebraEntity;

/**
 * GrevysZebra - fisk
 * Created using Tabula 7.1.0
 */
public class GrevysZebraModel extends SegmentedModel<GrevysZebraEntity> {
    public ModelRenderer Chest;
    public ModelRenderer shape60;
    public ModelRenderer Body;
    public ModelRenderer Neck;
    public ModelRenderer ArmBaseLeft;
    public ModelRenderer ArmBaseRight;
    public ModelRenderer Hips;
    public ModelRenderer ThighLeft;
    public ModelRenderer Tail1;
    public ModelRenderer ThighRight;
    public ModelRenderer UpperLegLeft;
    public ModelRenderer LowerLegLeft;
    public ModelRenderer FootLeft;
    public ModelRenderer Tail2;
    public ModelRenderer TailTuft;
    public ModelRenderer UpperLegRight;
    public ModelRenderer LowerLegRight;
    public ModelRenderer FootRight;
    public ModelRenderer Head;
    public ModelRenderer NeckLower;
    public ModelRenderer ManeFront;
    public ModelRenderer Snout;
    public ModelRenderer EarLeft;
    public ModelRenderer EarRight;
    public ModelRenderer TopSnout;
    public ModelRenderer Muzzle;
    public ModelRenderer Mouth;
    public ModelRenderer ManeMid;
    public ModelRenderer ArmLeft;
    public ModelRenderer ForearmLeft;
    public ModelRenderer HandLeft;
    public ModelRenderer ArmRight;
    public ModelRenderer ForearmRight;
    public ModelRenderer HandRight;
    private Iterable<ModelRenderer> parts;

    @Override
    public Iterable<ModelRenderer> getParts() {
        if (parts == null) {
            parts = ImmutableList.of(Chest);
        }
        return parts;
    }

    @Override
    public void setRotationAngles(GrevysZebraEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Neck.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F) / 2F;
        this.Head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F) / 2F;
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public static class Adult extends GrevysZebraModel {
        public Adult() {
            this.textureWidth = 96;
            this.textureHeight = 128;
            this.Snout = new ModelRenderer(this, 0, 99);
            this.Snout.setRotationPoint(0.0F, 1.9F, -3.0F);
            this.Snout.addBox(-2.5F, -4.0F, -5.0F, 5, 7, 6, 0.0F);
            this.setRotateAngle(Snout, 0.18203784098300857F, 0.0F, 0.0F);
            this.Hips = new ModelRenderer(this, 0, 57);
            this.Hips.setRotationPoint(0.0F, 0.0F, 16.0F);
            this.Hips.addBox(-7.0F, 0.0F, 0.0F, 14, 16, 9, 0.0F);
            this.setRotateAngle(Hips, -0.18203784098300857F, 0.0F, 0.0F);
            this.Mouth = new ModelRenderer(this, 0, 121);
            this.Mouth.setRotationPoint(0.0F, 5.1F, -0.5F);
            this.Mouth.addBox(-2.0F, 0.0F, -3.0F, 4, 2, 3, 0.0F);
            this.setRotateAngle(Mouth, -0.18203784098300857F, 0.0F, 0.0F);
            this.TopSnout = new ModelRenderer(this, 0, 112);
            this.TopSnout.setRotationPoint(0.0F, -3.7F, -5.6F);
            this.TopSnout.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 7, 0.0F);
            this.setRotateAngle(TopSnout, 0.31869712141416456F, 0.0F, 0.0F);
            this.NeckLower = new ModelRenderer(this, 30, 82);
            this.NeckLower.setRotationPoint(0.0F, -11.3F, -4.6F);
            this.NeckLower.addBox(-2.5F, 0.0F, 0.0F, 5, 14, 6, 0.0F);
            this.setRotateAngle(NeckLower, -0.36425021489121656F, 0.0F, 0.0F);
            this.Neck = new ModelRenderer(this, 46, 68);
            this.Neck.setRotationPoint(0.0F, -3.3F, -1.3F);
            this.Neck.addBox(-3.0F, -11.3F, -3.0F, 6, 14, 6, 0.0F);
            this.setRotateAngle(Neck, 1.3203415791337103F, 0.0F, 0.0F);
            this.ForearmRight = new ModelRenderer(this, 20, 116);
            this.ForearmRight.mirror = true;
            this.ForearmRight.setRotationPoint(0.0F, 4.6F, -4.5F);
            this.ForearmRight.addBox(-1.5F, 0.0F, 0.0F, 3, 7, 4, 0.0F);
            this.setRotateAngle(ForearmRight, -0.045553093477052F, 0.0F, 0.0F);
            this.ArmBaseRight = new ModelRenderer(this, 22, 102);
            this.ArmBaseRight.mirror = true;
            this.ArmBaseRight.setRotationPoint(-3.7F, 4.9F, 1.6F);
            this.ArmBaseRight.addBox(-2.5F, 0.0F, -3.5F, 5, 7, 7, 0.0F);
            this.setRotateAngle(ArmBaseRight, 0.36425021489121656F, 0.0F, 0.0F);
            this.UpperLegRight = new ModelRenderer(this, 74, 0);
            this.UpperLegRight.mirror = true;
            this.UpperLegRight.setRotationPoint(0.3F, 13.0F, -3.0F);
            this.UpperLegRight.addBox(-2.5F, 0.0F, 0.0F, 5, 6, 5, 0.0F);
            this.setRotateAngle(UpperLegRight, 0.36425021489121656F, 0.0F, 0.0F);
            this.shape60 = new ModelRenderer(this, 0, 0);
            this.shape60.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.shape60.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
            this.Tail2 = new ModelRenderer(this, 58, 30);
            this.Tail2.setRotationPoint(0.0F, 6.9F, -1.0F);
            this.Tail2.addBox(-1.0F, 0.0F, -1.0F, 2, 11, 2, 0.0F);
            this.setRotateAngle(Tail2, -0.091106186954104F, 0.0F, 0.0F);
            this.Tail1 = new ModelRenderer(this, 66, 30);
            this.Tail1.setRotationPoint(0.0F, 2.0F, 9.0F);
            this.Tail1.addBox(-1.0F, 0.0F, -2.0F, 2, 7, 2, 0.0F);
            this.setRotateAngle(Tail1, 0.31869712141416456F, 0.0F, 0.0F);
            this.EarRight = new ModelRenderer(this, 0, 25);
            this.EarRight.mirror = true;
            this.EarRight.setRotationPoint(-3.5F, -4.0F, 1.3F);
            this.EarRight.addBox(-2.0F, -4.0F, 0.0F, 4, 6, 1, 0.0F);
            this.setRotateAngle(EarRight, 0.0F, 0.5462880558742251F, -0.4553564018453205F);
            this.ForearmLeft = new ModelRenderer(this, 20, 116);
            this.ForearmLeft.setRotationPoint(0.0F, 4.6F, -4.5F);
            this.ForearmLeft.addBox(-1.5F, 0.0F, 0.0F, 3, 7, 4, 0.0F);
            this.setRotateAngle(ForearmLeft, -0.045553093477052F, 0.0F, 0.0F);
            this.ArmBaseLeft = new ModelRenderer(this, 22, 102);
            this.ArmBaseLeft.setRotationPoint(3.7F, 4.9F, 1.6F);
            this.ArmBaseLeft.addBox(-2.5F, 0.0F, -3.5F, 5, 7, 7, 0.0F);
            this.setRotateAngle(ArmBaseLeft, 0.36425021489121656F, 0.0F, 0.0F);
            this.ManeFront = new ModelRenderer(this, 56, 21);
            this.ManeFront.setRotationPoint(0.0F, -14.0F, 2.3F);
            this.ManeFront.addBox(-1.0F, 0.0F, -4.0F, 2, 4, 5, 0.0F);
            this.setRotateAngle(ManeFront, 0.8651597102135892F, 0.0F, 0.0F);
            this.EarLeft = new ModelRenderer(this, 0, 25);
            this.EarLeft.setRotationPoint(3.5F, -4.0F, 1.3F);
            this.EarLeft.addBox(-2.0F, -4.0F, 0.0F, 4, 6, 1, 0.0F);
            this.setRotateAngle(EarLeft, 0.0F, -0.5462880558742251F, 0.4553564018453205F);
            this.Muzzle = new ModelRenderer(this, 52, 88);
            this.Muzzle.setRotationPoint(0.0F, -4.2F, -4.5F);
            this.Muzzle.addBox(-3.0F, 0.0F, -4.0F, 6, 5, 4, 0.0F);
            this.setRotateAngle(Muzzle, 0.22759093446006054F, 0.0F, 0.0F);
            this.ManeMid = new ModelRenderer(this, 42, 21);
            this.ManeMid.setRotationPoint(0.0F, 4.0F, 1.0F);
            this.ManeMid.addBox(-1.0F, 0.0F, -5.0F, 2, 14, 5, 0.0F);
            this.setRotateAngle(ManeMid, -0.8651597102135892F, 0.0F, 0.0F);
            this.ArmRight = new ModelRenderer(this, 46, 102);
            this.ArmRight.mirror = true;
            this.ArmRight.setRotationPoint(0.0F, 7.0F, 2.5F);
            this.ArmRight.addBox(-2.0F, 0.0F, -5.0F, 4, 5, 5, 0.0F);
            this.setRotateAngle(ArmRight, -0.045553093477052F, 0.0F, 0.0F);
            this.FootLeft = new ModelRenderer(this, 34, 116);
            this.FootLeft.setRotationPoint(0.0F, 7.0F, -2.9F);
            this.FootLeft.addBox(-2.0F, 0.0F, -2.0F, 4, 3, 4, 0.0F);
            this.Body = new ModelRenderer(this, 0, 25);
            this.Body.setRotationPoint(0.0F, -6.0F, 2.7F);
            this.Body.addBox(-6.5F, 0.0F, 0.0F, 13, 16, 16, 0.0F);
            this.setRotateAngle(Body, 0.27314402793711257F, 0.0F, 0.0F);
            this.HandLeft = new ModelRenderer(this, 34, 116);
            this.HandLeft.setRotationPoint(0.0F, 5.7F, 0.5F);
            this.HandLeft.addBox(-2.0F, 0.0F, -2.0F, 4, 3, 4, 0.0F);
            this.setRotateAngle(HandLeft, -0.045553093477052F, 0.0F, 0.0F);
            this.LowerLegRight = new ModelRenderer(this, 74, 11);
            this.LowerLegRight.mirror = true;
            this.LowerLegRight.setRotationPoint(0.0F, 6.0F, 4.5F);
            this.LowerLegRight.addBox(-1.5F, 0.0F, -4.0F, 3, 8, 4, 0.0F);
            this.setRotateAngle(LowerLegRight, -0.31869712141416456F, 0.0F, 0.0F);
            this.ThighLeft = new ModelRenderer(this, 44, 0);
            this.ThighLeft.setRotationPoint(4.0F, 3.9F, 5.6F);
            this.ThighLeft.addBox(-3.5F, 0.0F, -4.5F, 7, 13, 8, 0.0F);
            this.setRotateAngle(ThighLeft, 0.091106186954104F, 0.0F, 0.0F);
            this.Head = new ModelRenderer(this, 0, 82);
            this.Head.setRotationPoint(0.0F, -10.6F, -1.3F);
            this.Head.addBox(-4.0F, -4.5F, -3.5F, 8, 10, 7, 0.0F);
            this.setRotateAngle(Head, -0.9105382707654417F, 0.0F, 0.0F);
            this.LowerLegLeft = new ModelRenderer(this, 74, 11);
            this.LowerLegLeft.setRotationPoint(0.0F, 6.0F, 4.5F);
            this.LowerLegLeft.addBox(-1.5F, 0.0F, -4.0F, 3, 8, 4, 0.0F);
            this.setRotateAngle(LowerLegLeft, -0.31869712141416456F, 0.0F, 0.0F);
            this.TailTuft = new ModelRenderer(this, 58, 43);
            this.TailTuft.setRotationPoint(0.0F, 3.0F, 0.0F);
            this.TailTuft.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
            this.setRotateAngle(TailTuft, 0.02356194490192345F, 0.0F, 0.0F);
            this.HandRight = new ModelRenderer(this, 34, 116);
            this.HandRight.mirror = true;
            this.HandRight.setRotationPoint(0.0F, 5.7F, 0.5F);
            this.HandRight.addBox(-2.0F, 0.0F, -2.0F, 4, 3, 4, 0.0F);
            this.setRotateAngle(HandRight, -0.045553093477052F, 0.0F, 0.0F);
            this.UpperLegLeft = new ModelRenderer(this, 74, 0);
            this.UpperLegLeft.setRotationPoint(0.3F, 13.0F, -3.0F);
            this.UpperLegLeft.addBox(-2.5F, 0.0F, 0.0F, 5, 6, 5, 0.0F);
            this.setRotateAngle(UpperLegLeft, 0.36425021489121656F, 0.0F, 0.0F);
            this.Chest = new ModelRenderer(this, 0, 0);
            this.Chest.setRotationPoint(0.0F, -1.5F, -4.0F);
            this.Chest.addBox(-6.0F, -6.0F, -3.0F, 12, 15, 10, 0.0F);
            this.setRotateAngle(Chest, -0.22759093446006054F, 0.0F, 0.0F);
            this.ThighRight = new ModelRenderer(this, 44, 0);
            this.ThighRight.mirror = true;
            this.ThighRight.setRotationPoint(-4.0F, 3.9F, 5.6F);
            this.ThighRight.addBox(-3.5F, 0.0F, -4.5F, 7, 13, 8, 0.0F);
            this.setRotateAngle(ThighRight, 0.091106186954104F, 0.0F, 0.0F);
            this.FootRight = new ModelRenderer(this, 34, 116);
            this.FootRight.mirror = true;
            this.FootRight.setRotationPoint(0.0F, 7.0F, -2.9F);
            this.FootRight.addBox(-2.0F, 0.0F, -2.0F, 4, 3, 4, 0.0F);
            this.ArmLeft = new ModelRenderer(this, 46, 102);
            this.ArmLeft.setRotationPoint(0.0F, 7.0F, 2.5F);
            this.ArmLeft.addBox(-2.0F, 0.0F, -5.0F, 4, 5, 5, 0.0F);
            this.setRotateAngle(ArmLeft, -0.045553093477052F, 0.0F, 0.0F);
            this.Head.addChild(this.Snout);
            this.Body.addChild(this.Hips);
            this.Muzzle.addChild(this.Mouth);
            this.Snout.addChild(this.TopSnout);
            this.Neck.addChild(this.NeckLower);
            this.Chest.addChild(this.Neck);
            this.ArmRight.addChild(this.ForearmRight);
            this.Chest.addChild(this.ArmBaseRight);
            this.ThighRight.addChild(this.UpperLegRight);
            this.Tail1.addChild(this.Tail2);
            this.Hips.addChild(this.Tail1);
            this.Head.addChild(this.EarRight);
            this.ArmLeft.addChild(this.ForearmLeft);
            this.Chest.addChild(this.ArmBaseLeft);
            this.Neck.addChild(this.ManeFront);
            this.Head.addChild(this.EarLeft);
            this.Snout.addChild(this.Muzzle);
            this.ManeFront.addChild(this.ManeMid);
            this.ArmBaseRight.addChild(this.ArmRight);
            this.LowerLegLeft.addChild(this.FootLeft);
            this.Chest.addChild(this.Body);
            this.ForearmLeft.addChild(this.HandLeft);
            this.UpperLegRight.addChild(this.LowerLegRight);
            this.Hips.addChild(this.ThighLeft);
            this.Neck.addChild(this.Head);
            this.UpperLegLeft.addChild(this.LowerLegLeft);
            this.Tail2.addChild(this.TailTuft);
            this.ForearmRight.addChild(this.HandRight);
            this.ThighLeft.addChild(this.UpperLegLeft);
            this.Hips.addChild(this.ThighRight);
            this.LowerLegRight.addChild(this.FootRight);
            this.ArmBaseLeft.addChild(this.ArmLeft);
        }

        @Override
        public void setRotationAngles(GrevysZebraEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            this.Neck.rotateAngleX = headPitch * ((float) Math.PI / 180F) / 2F + 1.32F;
            this.Head.rotateAngleX = headPitch * ((float) Math.PI / 180F) / 2F - 0.91F;
            if (limbSwingAmount <= 0.05F) {
                float speed = 2.0f;
                float degree = 2.0f;
                limbSwing = entity.ticksExisted;
                this.Neck.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.1F) * (degree * limbSwingAmount * -0.05f) + 1.5F;
                this.Head.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.1F + 1.0F) * (degree * limbSwingAmount * 0.075f) + -1.0F;
                this.Tail2.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.1F + 4.0F) * (degree * limbSwingAmount * -0.15f);
                this.Tail1.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.1F) * (degree * limbSwingAmount * 0.25f);
                this.Tail2.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.1F + 4.0F) * (degree * limbSwingAmount * 0.75f);
            }
            super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            float speed = 1.5f;
            float degree = 1.0f;

            if (entity.isInWater()) {
                limbSwing = (float) entity.ticksExisted;
                limbSwingAmount = 0.3F;
                speed = 2.0F;
            }
            this.ArmBaseLeft.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * (degree * limbSwingAmount * 2.5f) + 0.25F;
            this.ArmLeft.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F + 1.0F) * (degree * limbSwingAmount * 1.5f) + -0.2F;
            this.ForearmLeft.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F + 4.0F) * (degree * limbSwingAmount * 2.0f) + 0.15F;
            this.HandLeft.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F + 3.0F) * (degree * limbSwingAmount * -2.0f) + 0.4F;
            this.ArmBaseRight.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F + 1.0F) * (degree * limbSwingAmount * 2.5f) + 0.25F;
            this.ArmRight.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F + 2.0F) * (degree * limbSwingAmount * 1.5f) + -0.2F;
            this.ForearmRight.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F + 5.0F) * (degree * limbSwingAmount * 2.0f) + 0.15F;
            this.HandRight.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F + 4.0F) * (degree * limbSwingAmount * -2.0f) + 0.4F;
            this.ThighLeft.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F + 1.0F) * (degree * limbSwingAmount * -1.5f);
            this.UpperLegLeft.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * (degree * limbSwingAmount * -1.5f) + 0.4F;
            this.LowerLegLeft.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F + 3.0F) * (degree * limbSwingAmount * -1.0f) + -0.5F;
            this.FootLeft.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * (degree * limbSwingAmount * -2.0f) + 0.4F;
            this.ThighRight.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * (degree * limbSwingAmount * -1.5f);
            this.UpperLegRight.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F + -1.0F) * (degree * limbSwingAmount * -1.5f) + 0.4F;
            this.LowerLegRight.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F + 2.0F) * (degree * limbSwingAmount * -1.0f) + -0.5F;
            this.FootRight.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F + -1.0F) * (degree * limbSwingAmount * -2.0f) + 0.4F;
            this.Chest.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * (degree * limbSwingAmount * -0.15f) + -0.23F;
            this.Body.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F + 1.0F) * (degree * limbSwingAmount * 0.1f) + 0.25F;
            this.Hips.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * (degree * limbSwingAmount * -0.15f) + -0.2F;
            this.Neck.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F + 2.5F) * (degree * limbSwingAmount * -0.2f) + 1.37F;
            this.Head.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * (degree * limbSwingAmount * -0.1f) + -0.9F;
            this.Tail1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F + 1.5F) * (degree * limbSwingAmount * -1.5f) + 0.5F;
            this.Tail2.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F + 6.0F) * (degree * limbSwingAmount * -1.0f);
            this.Tail1.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.4F + 2.0F) * (degree * limbSwingAmount * 0.3f);
        }
    }

    public static class Child extends GrevysZebraModel {
        public Child() {
            this.textureWidth = 64;
            this.textureHeight = 64;
            this.FootLeft = new ModelRenderer(this, 39, 38);
            this.FootLeft.setRotationPoint(0.0F, 5.5F, -2.0F);
            this.FootLeft.addBox(-1.5F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
            this.Hips = new ModelRenderer(this, 0, 31);
            this.Hips.setRotationPoint(0.0F, -0.2F, 7.0F);
            this.Hips.addBox(-4.0F, 0.0F, 0.0F, 8, 9, 5, 0.0F);
            this.setRotateAngle(Hips, -0.045553093477052F, 0.0F, 0.0F);
            this.UpperLegLeft = new ModelRenderer(this, 40, 19);
            this.UpperLegLeft.setRotationPoint(0.0F, 7.0F, -2.0F);
            this.UpperLegLeft.addBox(-1.5F, 0.0F, 0.0F, 3, 6, 4, 0.0F);
            this.setRotateAngle(UpperLegLeft, 0.31869712141416456F, 0.0F, 0.0F);
            this.Neck = new ModelRenderer(this, 0, 45);
            this.Neck.setRotationPoint(0.0F, -2.8F, -1.5F);
            this.Neck.addBox(-2.0F, -2.5F, -7.0F, 4, 5, 8, 0.0F);
            this.setRotateAngle(Neck, -0.5009094953223726F, 0.0F, 0.0F);
            this.Snout = new ModelRenderer(this, 16, 45);
            this.Snout.setRotationPoint(0.0F, -0.7F, -3.0F);
            this.Snout.addBox(-2.0F, 0.0F, -3.5F, 4, 4, 4, 0.0F);
            this.setRotateAngle(Snout, 0.136659280431156F, 0.0F, 0.0F);
            this.ArmRight = new ModelRenderer(this, 30, 19);
            this.ArmRight.mirror = true;
            this.ArmRight.setRotationPoint(0.0F, 4.0F, 1.5F);
            this.ArmRight.addBox(-1.0F, 0.0F, -3.0F, 2, 5, 3, 0.0F);
            this.setRotateAngle(ArmRight, -0.091106186954104F, 0.0F, 0.0F);
            this.TopSnout = new ModelRenderer(this, 0, 58);
            this.TopSnout.setRotationPoint(0.0F, 0.0F, -2.5F);
            this.TopSnout.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 4, 0.0F);
            this.setRotateAngle(TopSnout, 0.31869712141416456F, 0.0F, 0.0F);
            this.FootRight = new ModelRenderer(this, 39, 38);
            this.FootRight.mirror = true;
            this.FootRight.setRotationPoint(0.0F, 5.5F, -2.0F);
            this.FootRight.addBox(-1.5F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
            this.Chest = new ModelRenderer(this, 0, 0);
            this.Chest.setRotationPoint(0.0F, 5.8F, -6.3F);
            this.Chest.addBox(-4.0F, -4.5F, -2.5F, 8, 9, 5, 0.0F);
            this.setRotateAngle(Chest, -0.22759093446006054F, 0.0F, 0.0F);
            this.EarLeft = new ModelRenderer(this, 0, 45);
            this.EarLeft.setRotationPoint(1.8F, -3.0F, 0.5F);
            this.EarLeft.addBox(-1.5F, -3.0F, 0.0F, 3, 4, 1, 0.0F);
            this.setRotateAngle(EarLeft, 0.22759093446006054F, -0.5009094953223726F, 0.40980330836826856F);
            this.NeckLower = new ModelRenderer(this, 42, 47);
            this.NeckLower.setRotationPoint(0.0F, 3.0F, -5.0F);
            this.NeckLower.addBox(-1.5F, -3.0F, 0.0F, 3, 3, 7, 0.0F);
            this.setRotateAngle(NeckLower, -0.27314402793711257F, 0.0F, 0.0F);
            this.EarRight = new ModelRenderer(this, 0, 45);
            this.EarRight.mirror = true;
            this.EarRight.setRotationPoint(-1.8F, -3.0F, 0.5F);
            this.EarRight.addBox(-1.5F, -3.0F, 0.0F, 3, 4, 1, 0.0F);
            this.setRotateAngle(EarRight, 0.22759093446006054F, 0.5009094953223726F, -0.40980330836826856F);
            this.ForearmRight = new ModelRenderer(this, 30, 27);
            this.ForearmRight.mirror = true;
            this.ForearmRight.setRotationPoint(0.0F, 4.5F, -3.0F);
            this.ForearmRight.addBox(-1.0F, 0.0F, 0.0F, 2, 5, 3, 0.0F);
            this.setRotateAngle(ForearmRight, -0.091106186954104F, 0.0F, 0.0F);
            this.Tail1 = new ModelRenderer(this, 55, 19);
            this.Tail1.setRotationPoint(0.0F, 0.5F, 5.0F);
            this.Tail1.addBox(-1.0F, 0.0F, -2.0F, 2, 6, 2, 0.0F);
            this.setRotateAngle(Tail1, 0.27314402793711257F, 0.0F, 0.0F);
            this.ForearmLeft = new ModelRenderer(this, 30, 27);
            this.ForearmLeft.setRotationPoint(0.0F, 4.5F, -3.0F);
            this.ForearmLeft.addBox(-1.0F, 0.0F, 0.0F, 2, 5, 3, 0.0F);
            this.setRotateAngle(ForearmLeft, -0.091106186954104F, 0.0F, 0.0F);
            this.ManeMid = new ModelRenderer(this, 26, 0);
            this.ManeMid.setRotationPoint(0.0F, -4.0F, -6.0F);
            this.ManeMid.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 8, 0.0F);
            this.ArmBaseRight = new ModelRenderer(this, 26, 11);
            this.ArmBaseRight.mirror = true;
            this.ArmBaseRight.setRotationPoint(-2.3F, 3.1F, 0.7F);
            this.ArmBaseRight.addBox(-1.5F, 0.0F, -2.0F, 3, 4, 4, 0.0F);
            this.setRotateAngle(ArmBaseRight, 0.36425021489121656F, 0.0F, 0.0F);
            this.LowerLegRight = new ModelRenderer(this, 40, 29);
            this.LowerLegRight.mirror = true;
            this.LowerLegRight.setRotationPoint(0.0F, 6.0F, 3.5F);
            this.LowerLegRight.addBox(-1.0F, 0.0F, -3.0F, 2, 6, 3, 0.0F);
            this.setRotateAngle(LowerLegRight, -0.31869712141416456F, 0.0F, 0.0F);
            this.TailTuft = new ModelRenderer(this, 52, 0);
            this.TailTuft.setRotationPoint(0.0F, 2.0F, -1.0F);
            this.TailTuft.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
            this.ThighLeft = new ModelRenderer(this, 40, 7);
            this.ThighLeft.setRotationPoint(2.5F, 3.0F, 2.6F);
            this.ThighLeft.addBox(-2.0F, 0.0F, -2.5F, 4, 7, 5, 0.0F);
            this.setRotateAngle(ThighLeft, 0.045553093477052F, 0.0F, 0.0F);
            this.ThighRight = new ModelRenderer(this, 40, 7);
            this.ThighRight.mirror = true;
            this.ThighRight.setRotationPoint(-2.5F, 3.0F, 2.6F);
            this.ThighRight.addBox(-2.0F, 0.0F, -2.5F, 4, 7, 5, 0.0F);
            this.setRotateAngle(ThighRight, 0.045553093477052F, 0.0F, 0.0F);
            this.ManeFront = new ModelRenderer(this, 36, 0);
            this.ManeFront.setRotationPoint(0.0F, -3.9F, 3.5F);
            this.ManeFront.addBox(-0.5F, 0.0F, -4.0F, 1, 3, 4, 0.0F);
            this.Tail2 = new ModelRenderer(this, 55, 27);
            this.Tail2.setRotationPoint(0.0F, 6.0F, 0.0F);
            this.Tail2.addBox(-1.0F, 0.0F, -2.0F, 2, 7, 2, 0.0F);
            this.setRotateAngle(Tail2, -0.22759093446006054F, 0.0F, 0.0F);
            this.ArmLeft = new ModelRenderer(this, 30, 19);
            this.ArmLeft.setRotationPoint(0.0F, 4.0F, 1.5F);
            this.ArmLeft.addBox(-1.0F, 0.0F, -3.0F, 2, 5, 3, 0.0F);
            this.setRotateAngle(ArmLeft, -0.091106186954104F, 0.0F, 0.0F);
            this.LowerLegLeft = new ModelRenderer(this, 40, 29);
            this.LowerLegLeft.setRotationPoint(0.0F, 6.0F, 3.5F);
            this.LowerLegLeft.addBox(-1.0F, 0.0F, -3.0F, 2, 6, 3, 0.0F);
            this.setRotateAngle(LowerLegLeft, -0.31869712141416456F, 0.0F, 0.0F);
            this.ArmBaseLeft = new ModelRenderer(this, 26, 11);
            this.ArmBaseLeft.setRotationPoint(2.3F, 3.1F, 0.7F);
            this.ArmBaseLeft.addBox(-1.5F, 0.0F, -2.0F, 3, 4, 4, 0.0F);
            this.setRotateAngle(ArmBaseLeft, 0.36425021489121656F, 0.0F, 0.0F);
            this.HandRight = new ModelRenderer(this, 26, 35);
            this.HandRight.mirror = true;
            this.HandRight.setRotationPoint(0.0F, 4.6F, 1.4F);
            this.HandRight.addBox(-1.5F, 0.0F, -2.0F, 3, 2, 3, 0.0F);
            this.setRotateAngle(HandRight, 0.045553093477052F, 0.0F, 0.0F);
            this.HandLeft = new ModelRenderer(this, 26, 35);
            this.HandLeft.setRotationPoint(0.0F, 4.6F, 1.4F);
            this.HandLeft.addBox(-1.5F, 0.0F, -2.0F, 3, 2, 3, 0.0F);
            this.setRotateAngle(HandLeft, 0.045553093477052F, 0.0F, 0.0F);
            this.Body = new ModelRenderer(this, 0, 14);
            this.Body.setRotationPoint(0.0F, -4.3F, 1.4F);
            this.Body.addBox(-3.5F, -0.2F, -1.0F, 7, 9, 8, 0.0F);
            this.setRotateAngle(Body, 0.22759093446006054F, 0.0F, 0.0F);
            this.UpperLegRight = new ModelRenderer(this, 40, 19);
            this.UpperLegRight.mirror = true;
            this.UpperLegRight.setRotationPoint(0.0F, 7.0F, -2.0F);
            this.UpperLegRight.addBox(-1.5F, 0.0F, 0.0F, 3, 6, 4, 0.0F);
            this.setRotateAngle(UpperLegRight, 0.31869712141416456F, 0.0F, 0.0F);
            this.Head = new ModelRenderer(this, 27, 52);
            this.Head.setRotationPoint(0.0F, 1.2F, -5.8F);
            this.Head.addBox(-2.5F, -3.5F, -2.5F, 5, 7, 5, 0.0F);
            this.setRotateAngle(Head, 0.7740535232594852F, 0.0F, 0.0F);
            this.LowerLegLeft.addChild(this.FootLeft);
            this.Body.addChild(this.Hips);
            this.ThighLeft.addChild(this.UpperLegLeft);
            this.Chest.addChild(this.Neck);
            this.Head.addChild(this.Snout);
            this.ArmBaseRight.addChild(this.ArmRight);
            this.Snout.addChild(this.TopSnout);
            this.LowerLegRight.addChild(this.FootRight);
            this.Head.addChild(this.EarLeft);
            this.Neck.addChild(this.NeckLower);
            this.Head.addChild(this.EarRight);
            this.ArmRight.addChild(this.ForearmRight);
            this.Hips.addChild(this.Tail1);
            this.ArmLeft.addChild(this.ForearmLeft);
            this.Neck.addChild(this.ManeMid);
            this.Chest.addChild(this.ArmBaseRight);
            this.UpperLegRight.addChild(this.LowerLegRight);
            this.Tail2.addChild(this.TailTuft);
            this.Hips.addChild(this.ThighLeft);
            this.Hips.addChild(this.ThighRight);
            this.Head.addChild(this.ManeFront);
            this.Tail1.addChild(this.Tail2);
            this.ArmBaseLeft.addChild(this.ArmLeft);
            this.UpperLegLeft.addChild(this.LowerLegLeft);
            this.Chest.addChild(this.ArmBaseLeft);
            this.ForearmRight.addChild(this.HandRight);
            this.ForearmLeft.addChild(this.HandLeft);
            this.Chest.addChild(this.Body);
            this.ThighRight.addChild(this.UpperLegRight);
            this.Neck.addChild(this.Head);
        }

        @Override
        public void setRotationAngles(GrevysZebraEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            this.Neck.rotateAngleX = headPitch * ((float) Math.PI / 180F) / 2F - 0.5F;
            this.Head.rotateAngleX = headPitch * ((float) Math.PI / 180F) / 2F + 0.77F;
            super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            float speed = 8.0f;
            float degree = 2.0f;

            if (entity.isInWater()) {
                limbSwing = (float) entity.ticksExisted;
                limbSwingAmount = 0.3F;
                speed = 2.0F;
            }
        }
    }
}
