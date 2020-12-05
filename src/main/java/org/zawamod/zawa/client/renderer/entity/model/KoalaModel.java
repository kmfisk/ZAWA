package org.zawamod.zawa.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import org.zawamod.zawa.entity.KoalaEntity;

public abstract class KoalaModel extends SegmentedModel<KoalaEntity> {
    public ModelRenderer body;
    public ModelRenderer belly;
    public ModelRenderer neck;
    public ModelRenderer arm1;
    public ModelRenderer arm2;
    public ModelRenderer booty;
    public ModelRenderer thight1;
    public ModelRenderer thight2;
    public ModelRenderer leg1;
    public ModelRenderer foot1;
    public ModelRenderer leg2;
    public ModelRenderer foot2;
    public ModelRenderer head;
    public ModelRenderer neckUnder;
    public ModelRenderer snout;
    public ModelRenderer ear1;
    public ModelRenderer ear2;
    public ModelRenderer nose;
    public ModelRenderer mouth;
    public ModelRenderer forearm1;
    public ModelRenderer hand1;
    public ModelRenderer toe1;
    public ModelRenderer forearm2;
    public ModelRenderer hand2;
    public ModelRenderer toe2;
    private Iterable<ModelRenderer> parts;

    @Override
    public Iterable<ModelRenderer> getParts() {
        if (parts == null) {
            parts = ImmutableList.of(body);
        }
        return parts;
    }

    @Override
    public void setRotationAngles(KoalaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.neck.rotateAngleX = headPitch * ((float) Math.PI / 180F) / 2F - 0.13F;
        this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F) / 2F + 0.24F;
        this.neck.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F) / 2F;
        this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F) / 2F;
        if (limbSwingAmount <= 0.05f) {
            this.neck.rotateAngleX = MathHelper.cos((limbSwing * 0.1F) + (float) Math.PI) * (0.1F) * limbSwingAmount * 0.5F;
        }
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public static class Adult extends KoalaModel {
        public Adult() {
            this.textureWidth = 64;
            this.textureHeight = 48;
            this.arm2 = new ModelRenderer(this, 0, 25);
            this.arm2.mirror = true;
            this.arm2.setRotationPoint(-2.4F, 0.2F, 1.6F);
            this.arm2.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, 0.0F);
            this.setRotateAngle(arm2, 0.06981317007977318F, -0.0F, 0.0F);
            this.neckUnder = new ModelRenderer(this, 46, 20);
            this.neckUnder.setRotationPoint(0.0F, 3.2F, -3.3F);
            this.neckUnder.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 2, 0.0F);
            this.setRotateAngle(neckUnder, 1.2566370614359172F, 0.0F, 0.0F);
            this.body = new ModelRenderer(this, 22, 0);
            this.body.setRotationPoint(0.0F, 14.5F, -4.0F);
            this.body.addBox(-3.5F, -3.5F, 0.0F, 7, 8, 7, 0.0F);
            this.setRotateAngle(body, -0.03490658503988659F, -0.0F, 0.0F);
            this.leg1 = new ModelRenderer(this, 46, 27);
            this.leg1.setRotationPoint(0.0F, 5.7F, -1.5F);
            this.leg1.addBox(-1.5F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
            this.setRotateAngle(leg1, 0.13962634015954636F, -0.0F, 0.0F);
            this.foot1 = new ModelRenderer(this, 56, 25);
            this.foot1.setRotationPoint(0.0F, 3.52F, 1.0F);
            this.foot1.addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(foot1, -0.03490658503988659F, -0.0F, 0.0F);
            this.hand1 = new ModelRenderer(this, 24, 25);
            this.hand1.setRotationPoint(0.0F, 4.0F, -1.8F);
            this.hand1.addBox(-1.0F, -0.1F, -2.2F, 2, 1, 3, 0.0F);
            this.setRotateAngle(hand1, 0.06981317007977318F, -0.13962634015954636F, 0.0F);
            this.forearm2 = new ModelRenderer(this, 14, 25);
            this.forearm2.mirror = true;
            this.forearm2.setRotationPoint(0.02F, 4.5F, 1.6F);
            this.forearm2.addBox(-1.0F, 0.0F, -3.0F, 2, 4, 3, 0.0F);
            this.setRotateAngle(forearm2, -0.10471975511965977F, 0.0F, 0.0F);
            this.foot2 = new ModelRenderer(this, 56, 25);
            this.foot2.mirror = true;
            this.foot2.setRotationPoint(0.0F, 3.52F, 1.0F);
            this.foot2.addBox(-1.0F, -0.5F, -2.0F, 2, 1, 2, 0.0F);
            this.setRotateAngle(foot2, -0.03490658503988659F, -0.0F, 0.0F);
            this.nose = new ModelRenderer(this, 43, 0);
            this.nose.setRotationPoint(0.0F, 1.5F, -1.6F);
            this.nose.addBox(-1.0F, -3.0F, -1.0F, 2, 3, 1, 0.0F);
            this.setRotateAngle(nose, -0.19198621771937624F, -0.0F, 0.0F);
            this.thight1 = new ModelRenderer(this, 30, 25);
            this.thight1.setRotationPoint(3.0F, 2.9F, 3.3F);
            this.thight1.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
            this.setRotateAngle(thight1, 0.03490658503988659F, -0.0F, 0.0F);
            this.ear1 = new ModelRenderer(this, 50, 3);
            this.ear1.setRotationPoint(1.4F, -1.2F, -2.4F);
            this.ear1.addBox(0.0F, -2.0F, -0.5F, 4, 4, 1, 0.0F);
            this.setRotateAngle(ear1, 0.06981317007977318F, 0.03490658503988659F, -0.13962634015954636F);
            this.leg2 = new ModelRenderer(this, 46, 27);
            this.leg2.mirror = true;
            this.leg2.setRotationPoint(0.0F, 5.7F, -1.5F);
            this.leg2.addBox(-1.5F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
            this.setRotateAngle(leg2, 0.13962634015954636F, -0.0F, 0.0F);
            this.forearm1 = new ModelRenderer(this, 14, 25);
            this.forearm1.setRotationPoint(-0.02F, 4.5F, 1.6F);
            this.forearm1.addBox(-1.0F, 0.0F, -3.0F, 2, 4, 3, 0.0F);
            this.setRotateAngle(forearm1, -0.10471975511965977F, 0.0F, 0.0F);
            this.thight2 = new ModelRenderer(this, 30, 25);
            this.thight2.mirror = true;
            this.thight2.setRotationPoint(-3.0F, 2.9F, 3.3F);
            this.thight2.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
            this.setRotateAngle(thight2, 0.03490658503988659F, -0.0F, 0.0F);
            this.arm1 = new ModelRenderer(this, 0, 25);
            this.arm1.setRotationPoint(2.4F, 0.2F, 1.6F);
            this.arm1.addBox(-1.5F, 0.0F, -2.0F, 3, 5, 4, 0.0F);
            this.setRotateAngle(arm1, 0.06981317007977318F, -0.0F, 0.0F);
            this.toe1 = new ModelRenderer(this, 24, 29);
            this.toe1.setRotationPoint(0.2F, 0.42F, 0.0F);
            this.toe1.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
            this.setRotateAngle(toe1, 0.0F, 0.8377580409572781F, 0.0F);
            this.neck = new ModelRenderer(this, 46, 11);
            this.neck.setRotationPoint(0.0F, -0.7F, 0.1F);
            this.neck.addBox(-2.5F, -2.5F, -3.0F, 5, 5, 4, 0.0F);
            this.setRotateAngle(neck, -0.13962634015954636F, 0.0F, 0.0F);
            this.booty = new ModelRenderer(this, 28, 15);
            this.booty.setRotationPoint(0.0F, 0.3F, 5.2F);
            this.booty.addBox(-3.5F, 0.0F, 0.0F, 7, 7, 2, 0.0F);
            this.setRotateAngle(booty, -0.13962634015954636F, -0.0F, 0.0F);
            this.belly = new ModelRenderer(this, 0, 11);
            this.belly.setRotationPoint(0.0F, -3.5F, 7.0F);
            this.belly.addBox(-4.0F, 0.0F, 0.0F, 8, 8, 6, 0.0F);
            this.setRotateAngle(belly, -0.10471975511965977F, -0.0F, 0.0F);
            this.snout = new ModelRenderer(this, 17, 0);
            this.snout.setRotationPoint(0.0F, 1.1F, -4.5F);
            this.snout.addBox(-1.5F, -1.5F, -2.0F, 3, 3, 2, 0.0F);
            this.setRotateAngle(snout, 0.13962634015954636F, -0.0F, 0.0F);
            this.mouth = new ModelRenderer(this, 49, 0);
            this.mouth.setRotationPoint(0.0F, 1.4F, -0.8F);
            this.mouth.addBox(-1.0F, 0.0F, -1.1F, 2, 1, 2, 0.0F);
            this.setRotateAngle(mouth, -0.06981317007977318F, 0.0F, 0.0F);
            this.head = new ModelRenderer(this, 0, 0);
            this.head.setRotationPoint(0.0F, -0.5F, -1.5F);
            this.head.addBox(-3.0F, -2.5F, -5.0F, 6, 6, 5, 0.0F);
            this.setRotateAngle(head, 0.24434609527920614F, 0.0F, 0.0F);
            this.hand2 = new ModelRenderer(this, 24, 25);
            this.hand2.setRotationPoint(0.0F, 4.0F, -1.8F);
            this.hand2.addBox(-1.0F, -0.1F, -2.2F, 2, 1, 3, 0.0F);
            this.setRotateAngle(hand2, 0.06981317007977318F, 0.13962634015954636F, 0.0F);
            this.toe2 = new ModelRenderer(this, 24, 29);
            this.toe2.setRotationPoint(-0.2F, 0.42F, 0.0F);
            this.toe2.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
            this.setRotateAngle(toe2, 0.0F, -0.8377580409572781F, 0.0F);
            this.ear2 = new ModelRenderer(this, 50, 3);
            this.ear2.mirror = true;
            this.ear2.setRotationPoint(-1.4F, -1.2F, -2.4F);
            this.ear2.addBox(-4.0F, -2.0F, -0.5F, 4, 4, 1, 0.0F);
            this.setRotateAngle(ear2, 0.06981317007977318F, -0.03490658503988659F, 0.13962634015954636F);
            this.body.addChild(this.arm2);
            this.neck.addChild(this.neckUnder);
            this.thight1.addChild(this.leg1);
            this.leg1.addChild(this.foot1);
            this.forearm1.addChild(this.hand1);
            this.arm2.addChild(this.forearm2);
            this.leg2.addChild(this.foot2);
            this.snout.addChild(this.nose);
            this.belly.addChild(this.thight1);
            this.head.addChild(this.ear1);
            this.thight2.addChild(this.leg2);
            this.arm1.addChild(this.forearm1);
            this.belly.addChild(this.thight2);
            this.body.addChild(this.arm1);
            this.hand1.addChild(this.toe1);
            this.body.addChild(this.neck);
            this.belly.addChild(this.booty);
            this.body.addChild(this.belly);
            this.head.addChild(this.snout);
            this.snout.addChild(this.mouth);
            this.neck.addChild(this.head);
            this.forearm2.addChild(this.hand2);
            this.hand2.addChild(this.toe2);
            this.head.addChild(this.ear2);
        }

        @Override
        public void setRotationAngles(KoalaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            float speed = 8.0f;
            float degree = 2.0f;

            if (entity.isInWater()) {
                limbSwing = (float)entity.ticksExisted;
                limbSwingAmount = 0.3F;
                speed = 2.0F;
            }

            this.neck.rotateAngleX = MathHelper.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 0.05F) * limbSwingAmount * 0.5F + -0.14F;
            this.arm1.rotateAngleX = MathHelper.cos((limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * 0.9F) * limbSwingAmount * 0.5F + 0.06F;
            this.forearm1.rotateAngleX = MathHelper.cos(2.0F + (limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * 1.5F) * limbSwingAmount * 0.5F + -0.1F;
            this.hand1.rotateAngleX = MathHelper.cos(5.0F + (limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * -1.5F) * limbSwingAmount * 0.5F + 0.06F;
            this.arm2.rotateAngleX = MathHelper.cos((limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * -0.9F) * limbSwingAmount * 0.5F + 0.06F;
            this.forearm2.rotateAngleX = MathHelper.cos(2.0F + (limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * -1.5F) * limbSwingAmount * 0.5F + -0.1F;
            this.hand2.rotateAngleX = MathHelper.cos(5.0F + (limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * 1.5F) * limbSwingAmount * 0.5F + 0.06F;
            this.thight1.rotateAngleX = MathHelper.cos(2.0F + (limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * -1.5F) * limbSwingAmount * 0.5F + 0.1F;
            this.leg1.rotateAngleX = MathHelper.cos((limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * -1.3F) * limbSwingAmount * 0.5F + 0.05F;
            this.foot1.rotateAngleX = MathHelper.cos((limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * 2.0F) * limbSwingAmount * 0.5F;
            this.thight2.rotateAngleX = MathHelper.cos(2.0F + (limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * 1.5F) * limbSwingAmount * 0.5F + 0.1F;
            this.leg2.rotateAngleX = MathHelper.cos((limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * 0.0F) * limbSwingAmount * 0.5F + 0.05F;
            this.foot2.rotateAngleX = MathHelper.cos((limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * -2.0F) * limbSwingAmount * 0.5F;
            this.body.rotationPointY = MathHelper.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 0.01F) * limbSwingAmount * 0.5F + 14.5F;
        }
    }

    public static class Child extends KoalaModel {
        public Child() {
            this.textureWidth = 48;
            this.textureHeight = 24;
            this.leg1 = new ModelRenderer(this, 28, 19);
            this.leg1.setRotationPoint(-0.02F, 4.0F, -1.0F);
            this.leg1.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(leg1, 0.13962634015954636F, -0.0F, 0.0F);
            this.ear2 = new ModelRenderer(this, 36, 2);
            this.ear2.mirror = true;
            this.ear2.setRotationPoint(-0.9F, -1.2F, -1.7F);
            this.ear2.addBox(-2.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
            this.setRotateAngle(ear2, 0.06981317007977318F, -0.03490658503988659F, 0.13962634015954636F);
            this.nose = new ModelRenderer(this, 32, 0);
            this.nose.setRotationPoint(0.0F, 1.1F, -1.4F);
            this.nose.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 1, 0.0F);
            this.setRotateAngle(nose, -0.19198621771937624F, -0.0F, 0.0F);
            this.neckUnder = new ModelRenderer(this, 30, 14);
            this.neckUnder.setRotationPoint(0.0F, 2.2F, -2.0F);
            this.neckUnder.addBox(-1.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
            this.setRotateAngle(neckUnder, 1.3962634015954636F, 0.0F, 0.0F);
            this.head = new ModelRenderer(this, 0, 0);
            this.head.setRotationPoint(0.0F, -0.5F, -0.5F);
            this.head.addBox(-2.0F, -1.5F, -3.0F, 4, 4, 3, 0.0F);
            this.setRotateAngle(head, 0.24434609527920614F, 0.0F, 0.0F);
            this.neck = new ModelRenderer(this, 32, 9);
            this.neck.setRotationPoint(0.0F, -0.7F, 0.1F);
            this.neck.addBox(-1.5F, -1.5F, -1.0F, 3, 3, 2, 0.0F);
            this.setRotateAngle(neck, -0.13962634015954636F, 0.0F, 0.0F);
            this.foot2 = new ModelRenderer(this, 36, 17);
            this.foot2.mirror = true;
            this.foot2.setRotationPoint(0.02F, 1.62F, 1.5F);
            this.foot2.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
            this.setRotateAngle(foot2, -0.03490658503988659F, -0.0F, 0.0F);
            this.body = new ModelRenderer(this, 18, 0);
            this.body.setRotationPoint(0.0F, 19.2F, -3.0F);
            this.body.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 4, 0.0F);
            this.setRotateAngle(body, -0.03490658503988659F, -0.0F, 0.0F);
            this.snout = new ModelRenderer(this, 14, 0);
            this.snout.setRotationPoint(0.0F, 0.8F, -2.0F);
            this.snout.addBox(-1.0F, -1.0F, -2.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(snout, 0.13962634015954636F, -0.0F, 0.0F);
            this.arm2 = new ModelRenderer(this, 0, 16);
            this.arm2.mirror = true;
            this.arm2.setRotationPoint(-1.7F, 0.2F, 0.8F);
            this.arm2.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
            this.setRotateAngle(arm2, 0.06981317007977318F, -0.0F, 0.0F);
            this.hand2 = new ModelRenderer(this, 16, 16);
            this.hand2.setRotationPoint(0.02F, 1.8F, -1.3F);
            this.hand2.addBox(-0.5F, -0.1F, -1.4F, 1, 1, 2, 0.0F);
            this.setRotateAngle(hand2, 0.06981317007977318F, 0.13962634015954636F, 0.0F);
            this.toe2 = new ModelRenderer(this, 15, 19);
            this.toe2.setRotationPoint(-0.2F, 0.42F, -0.1F);
            this.toe2.addBox(-0.3F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
            this.setRotateAngle(toe2, 0.0F, -0.5585053606381855F, 0.0F);
            this.thight1 = new ModelRenderer(this, 22, 14);
            this.thight1.setRotationPoint(2.3F, 1.9F, 2.3F);
            this.thight1.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
            this.setRotateAngle(thight1, 0.03490658503988659F, -0.0F, 0.0F);
            this.toe1 = new ModelRenderer(this, 15, 19);
            this.toe1.setRotationPoint(0.2F, 0.42F, -0.1F);
            this.toe1.addBox(-0.7F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
            this.setRotateAngle(toe1, 0.0F, 0.5585053606381855F, 0.0F);
            this.thight2 = new ModelRenderer(this, 22, 14);
            this.thight2.mirror = true;
            this.thight2.setRotationPoint(-2.3F, 1.9F, 2.3F);
            this.thight2.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
            this.setRotateAngle(thight2, 0.03490658503988659F, -0.0F, 0.0F);
            this.booty = new ModelRenderer(this, 20, 9);
            this.booty.setRotationPoint(0.0F, 0.2F, 3.6F);
            this.booty.addBox(-2.5F, 0.0F, 0.0F, 5, 4, 1, 0.0F);
            this.setRotateAngle(booty, -0.13962634015954636F, -0.0F, 0.0F);
            this.foot1 = new ModelRenderer(this, 36, 17);
            this.foot1.setRotationPoint(-0.02F, 1.62F, 1.5F);
            this.foot1.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
            this.setRotateAngle(foot1, -0.03490658503988659F, -0.0F, 0.0F);
            this.belly = new ModelRenderer(this, 0, 7);
            this.belly.setRotationPoint(0.0F, -2.5F, 4.0F);
            this.belly.addBox(-3.0F, 0.0F, 0.0F, 6, 5, 4, 0.0F);
            this.setRotateAngle(belly, -0.10471975511965977F, -0.0F, 0.0F);
            this.arm1 = new ModelRenderer(this, 0, 16);
            this.arm1.setRotationPoint(1.7F, 0.2F, 0.8F);
            this.arm1.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
            this.setRotateAngle(arm1, 0.06981317007977318F, -0.0F, 0.0F);
            this.mouth = new ModelRenderer(this, 36, 0);
            this.mouth.setRotationPoint(0.0F, 0.9F, -0.9F);
            this.mouth.addBox(-0.5F, -0.4F, -1.0F, 1, 1, 1, 0.0F);
            this.setRotateAngle(mouth, -0.06981317007977318F, 0.0F, 0.0F);
            this.hand1 = new ModelRenderer(this, 16, 16);
            this.hand1.setRotationPoint(-0.02F, 1.8F, -1.3F);
            this.hand1.addBox(-0.5F, -0.1F, -1.4F, 1, 1, 2, 0.0F);
            this.setRotateAngle(hand1, 0.06981317007977318F, -0.13962634015954636F, 0.0F);
            this.ear1 = new ModelRenderer(this, 36, 2);
            this.ear1.setRotationPoint(0.9F, -1.2F, -1.7F);
            this.ear1.addBox(0.0F, -1.0F, -0.5F, 2, 2, 1, 0.0F);
            this.setRotateAngle(ear1, 0.06981317007977318F, 0.03490658503988659F, -0.13962634015954636F);
            this.forearm2 = new ModelRenderer(this, 8, 16);
            this.forearm2.mirror = true;
            this.forearm2.setRotationPoint(0.02F, 3.0F, 1.0F);
            this.forearm2.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(forearm2, -0.10471975511965977F, 0.0F, 0.0F);
            this.leg2 = new ModelRenderer(this, 28, 19);
            this.leg2.mirror = true;
            this.leg2.setRotationPoint(0.02F, 4.0F, -1.0F);
            this.leg2.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(leg2, 0.13962634015954636F, -0.0F, 0.0F);
            this.forearm1 = new ModelRenderer(this, 8, 16);
            this.forearm1.setRotationPoint(-0.02F, 3.0F, 1.0F);
            this.forearm1.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(forearm1, -0.10471975511965977F, 0.0F, 0.0F);
            this.thight1.addChild(this.leg1);
            this.head.addChild(this.ear2);
            this.snout.addChild(this.nose);
            this.neck.addChild(this.neckUnder);
            this.neck.addChild(this.head);
            this.body.addChild(this.neck);
            this.leg2.addChild(this.foot2);
            this.head.addChild(this.snout);
            this.body.addChild(this.arm2);
            this.forearm2.addChild(this.hand2);
            this.hand2.addChild(this.toe2);
            this.belly.addChild(this.thight1);
            this.hand1.addChild(this.toe1);
            this.belly.addChild(this.thight2);
            this.belly.addChild(this.booty);
            this.leg1.addChild(this.foot1);
            this.body.addChild(this.belly);
            this.body.addChild(this.arm1);
            this.snout.addChild(this.mouth);
            this.forearm1.addChild(this.hand1);
            this.head.addChild(this.ear1);
            this.arm2.addChild(this.forearm2);
            this.thight2.addChild(this.leg2);
            this.arm1.addChild(this.forearm1);
        }

        @Override
        public void setRotationAngles(KoalaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            float speed = 8.0f;
            float degree = 2.0f;

            if (entity.isInWater()) {
                limbSwing = (float)entity.ticksExisted;
                limbSwingAmount = 0.3F;
                speed = 2.0F;
            }

            this.neck.rotateAngleX = MathHelper.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 0.05F) * limbSwingAmount * 0.5F + -0.14F;
            this.arm1.rotateAngleX = MathHelper.cos((limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * 0.9F) * limbSwingAmount * 0.5F + 0.06F;
            this.forearm1.rotateAngleX = MathHelper.cos(2.0F + (limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * 1.0F) * limbSwingAmount * 0.5F + -0.2F;
            this.hand1.rotateAngleX = MathHelper.cos(5.0F + (limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * -1.5F) * limbSwingAmount * 0.5F + 0.06F;
            this.arm2.rotateAngleX = MathHelper.cos((limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * -0.9F) * limbSwingAmount * 0.5F + 0.06F;
            this.forearm2.rotateAngleX = MathHelper.cos(2.0F + (limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * -1.0F) * limbSwingAmount * 0.5F + -0.2F;
            this.hand2.rotateAngleX = MathHelper.cos(5.0F + (limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * 1.5F) * limbSwingAmount * 0.5F + 0.06F;
            this.thight1.rotateAngleX = MathHelper.cos(2.0F + (limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * -1.5F) * limbSwingAmount * 0.5F + 0.1F;
            this.leg1.rotateAngleX = MathHelper.cos((limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * -0.8F) * limbSwingAmount * 0.5F + 0.2F;
            this.thight2.rotateAngleX = MathHelper.cos(2.0F + (limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * 1.5F) * limbSwingAmount * 0.5F + 0.1F;
            this.leg2.rotateAngleX = MathHelper.cos((limbSwing * speed * 0.15F) + (float) Math.PI) * (degree * 0.8F) * limbSwingAmount * 0.5F + 0.2F;
            this.body.rotationPointY = MathHelper.cos((limbSwing * speed * 0.3F) + (float) Math.PI) * (degree * 0.01F) * limbSwingAmount * 0.5F + 19.2F;
        }
    }
}
