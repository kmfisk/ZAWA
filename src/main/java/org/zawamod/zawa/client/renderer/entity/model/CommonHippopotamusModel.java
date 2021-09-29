package org.zawamod.zawa.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import org.zawamod.zawa.entity.CommonHippopotamusEntity;

/**
 * Nile Hippopotamus - Bolcko
 * Created using Tabula 7.1.0
 */
public class CommonHippopotamusModel extends SegmentedModel<CommonHippopotamusEntity> {
    public ModelRenderer Body;
    public ModelRenderer Chest;
    public ModelRenderer Hips;
    public ModelRenderer Thigh3;
    public ModelRenderer Thigh4;
    public ModelRenderer Neck;
    public ModelRenderer Thigh1;
    public ModelRenderer Thigh2;
    public ModelRenderer Head;
    public ModelRenderer cheeks;
    public ModelRenderer snout;
    public ModelRenderer Jaw;
    public ModelRenderer Ear1;
    public ModelRenderer Ear2;
    public ModelRenderer nose;
    public ModelRenderer tooth5;
    public ModelRenderer tooth6;
    public ModelRenderer tooth7;
    public ModelRenderer tooth8;
    public ModelRenderer tooth9;
    public ModelRenderer tooth10;
    public ModelRenderer tooth2;
    public ModelRenderer tooth1;
    public ModelRenderer tooth3;
    public ModelRenderer tooth4;
    public ModelRenderer JawTip;
    public ModelRenderer Leg1;
    public ModelRenderer Foot1;
    public ModelRenderer Leg2;
    public ModelRenderer Foot2;
    public ModelRenderer Tail1;
    public ModelRenderer Tail2;
    public ModelRenderer UpperLeg3;
    public ModelRenderer Leg3;
    public ModelRenderer Foot3;
    public ModelRenderer UpperLeg4;
    public ModelRenderer Leg4;
    public ModelRenderer Foot4;
    private Iterable<ModelRenderer> parts;

    @Override
    public Iterable<ModelRenderer> parts() {
        if (parts == null)
            parts = ImmutableList.of(Body);
        
        return parts;
    }

    @Override
    public void setupAnim(CommonHippopotamusEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Neck.xRot = headPitch * ((float) Math.PI / 180F) / 2F + 0.08F;
        this.Head.xRot = headPitch * ((float) Math.PI / 180F) / 4F + 0.17F;
        this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F) / 2F;
        this.Head.yRot = netHeadYaw * ((float) Math.PI / 180F) / 2F;
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    public static class Adult extends CommonHippopotamusModel {
        public Adult() {
            this.tooth1 = new ModelRenderer(this, 14, 0);
            this.tooth1.setPos(2.0F, 0.2F, -5.0F);
            this.tooth1.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
            this.setRotateAngle(tooth1, 0.0F, 0.0F, 0.17453292519943295F);
            this.UpperLeg4 = new ModelRenderer(this, 37, 77);
            this.UpperLeg4.setPos(0.0F, 7.0F, -3.5F);
            this.UpperLeg4.addBox(-3.0F, 0.0F, 0.0F, 6, 4, 5, 0.0F);
            this.setRotateAngle(UpperLeg4, 0.6981317007977318F, 0.0F, 0.0F);
            this.Foot2 = new ModelRenderer(this, 15, 75);
            this.Foot2.mirror = true;
            this.Foot2.setPos(0.0F, 3.6F, 2.5F);
            this.Foot2.addBox(-3.0F, -1.0F, -3.0F, 6, 3, 5, 0.0F);
            this.setRotateAngle(Foot2, -0.03490658503988659F, 0.0F, 0.03490658503988659F);
            this.Thigh4 = new ModelRenderer(this, 0, 33);
            this.Thigh4.setPos(4.0F, 1.0F, 10.0F);
            this.Thigh4.addBox(-3.5F, -2.0F, -4.0F, 7, 9, 8, 0.0F);
            this.setRotateAngle(Thigh4, 0.17453292519943295F, 0.0F, 0.04363323129985824F);
            this.Thigh3 = new ModelRenderer(this, 0, 33);
            this.Thigh3.mirror = true;
            this.Thigh3.setPos(-4.0F, 1.0F, 10.0F);
            this.Thigh3.addBox(-3.5F, -2.0F, -4.0F, 7, 9, 8, 0.0F);
            this.setRotateAngle(Thigh3, 0.17453292519943295F, 0.0F, -0.04363323129985824F);
            this.cheeks = new ModelRenderer(this, 87, 53);
            this.cheeks.setPos(0.0F, 3.0F, 0.0F);
            this.cheeks.addBox(-6.5F, -2.5F, -5.0F, 13, 5, 5, 0.0F);
            this.nose = new ModelRenderer(this, 62, 59);
            this.nose.setPos(0.0F, 1.0F, -4.0F);
            this.nose.addBox(-5.0F, -6.0F, -4.0F, 10, 6, 4, 0.0F);
            this.tooth8 = new ModelRenderer(this, 4, 0);
            this.tooth8.setPos(2.5F, 0.5F, -4.5F);
            this.tooth8.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
            this.Foot3 = new ModelRenderer(this, 15, 75);
            this.Foot3.mirror = true;
            this.Foot3.setPos(0.0F, 6.3F, -2.6F);
            this.Foot3.addBox(-2.8F, -1.0F, -3.0F, 6, 3, 5, 0.0F);
            this.setRotateAngle(Foot3, 0.17453292519943295F, 0.0F, 0.04363323129985824F);
            this.Thigh1 = new ModelRenderer(this, 98, 14);
            this.Thigh1.setPos(4.3F, 2.5F, -2.5F);
            this.Thigh1.addBox(-3.0F, 0.0F, -3.0F, 6, 8, 6, 0.0F);
            this.setRotateAngle(Thigh1, 0.10471975511965977F, 0.0F, 0.04363323129985824F);
            this.Leg2 = new ModelRenderer(this, 0, 67);
            this.Leg2.mirror = true;
            this.Leg2.setPos(0.0F, 8.0F, -2.5F);
            this.Leg2.addBox(-2.5F, -0.7F, 0.0F, 5, 5, 5, 0.0F);
            this.tooth3 = new ModelRenderer(this, 14, 0);
            this.tooth3.setPos(-0.7F, 1.0F, -3.0F);
            this.tooth3.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
            this.setRotateAngle(tooth3, 0.7853981633974483F, 0.0F, -0.03490658503988659F);
            this.UpperLeg3 = new ModelRenderer(this, 37, 77);
            this.UpperLeg3.mirror = true;
            this.UpperLeg3.setPos(0.0F, 7.0F, -3.5F);
            this.UpperLeg3.addBox(-3.0F, 0.0F, 0.0F, 6, 4, 5, 0.0F);
            this.setRotateAngle(UpperLeg3, 0.6981317007977318F, 0.0F, 0.0F);
            this.Thigh2 = new ModelRenderer(this, 98, 14);
            this.Thigh2.mirror = true;
            this.Thigh2.setPos(-4.3F, 2.5F, -2.5F);
            this.Thigh2.addBox(-3.0F, 0.0F, -3.0F, 6, 8, 6, 0.0F);
            this.setRotateAngle(Thigh2, 0.10471975511965977F, 0.0F, -0.04363323129985824F);
            this.snout = new ModelRenderer(this, 36, 54);
            this.snout.setPos(0.0F, 0.5F, -6.4F);
            this.snout.addBox(-4.5F, -5.0F, -4.0F, 9, 6, 4, 0.0F);
            this.setRotateAngle(snout, 0.08726646259971647F, 0.0F, 0.0F);
            this.tooth5 = new ModelRenderer(this, 4, 0);
            this.tooth5.setPos(-2.3F, 1.0F, -6.5F);
            this.tooth5.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
            this.tooth6 = new ModelRenderer(this, 4, 0);
            this.tooth6.setPos(2.3F, 1.0F, -6.5F);
            this.tooth6.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
            this.Foot1 = new ModelRenderer(this, 15, 75);
            this.Foot1.setPos(0.0F, 3.6F, 2.5F);
            this.Foot1.addBox(-3.0F, -1.0F, -3.0F, 6, 3, 5, 0.0F);
            this.setRotateAngle(Foot1, -0.03490658503988659F, 0.0F, -0.03490658503988659F);
            this.Leg3 = new ModelRenderer(this, 0, 78);
            this.Leg3.setPos(0.0F, 4.0F, 5.0F);
            this.Leg3.addBox(-2.5F, 0.0F, -5.0F, 5, 7, 5, 0.0F);
            this.setRotateAngle(Leg3, -1.0471975511965976F, 0.0F, 0.0F);
            this.Neck = new ModelRenderer(this, 60, 42);
            this.Neck.setPos(0.0F, -0.2F, -6.0F);
            this.Neck.addBox(-6.0F, -5.5F, -3.0F, 12, 12, 4, 0.0F);
            this.setRotateAngle(Neck, 0.08726646259971647F, 0.0F, 0.0F);
            this.Hips = new ModelRenderer(this, 64, 20);
            this.Hips.setPos(0.0F, 0.0F, 10.0F);
            this.Hips.addBox(-6.5F, -7.0F, -2.0F, 13, 14, 8, 0.0F);
            this.setRotateAngle(Hips, -0.08726646259971647F, 0.0F, 0.0F);
            this.Ear2 = new ModelRenderer(this, 6, 0);
            this.Ear2.setPos(-4.0F, -3.5F, -1.5F);
            this.Ear2.addBox(-0.5F, -3.0F, -1.0F, 1, 2, 2, 0.0F);
            this.setRotateAngle(Ear2, 0.3490658503988659F, 3.141592653589793F, -0.5235987755982988F);
            this.tooth9 = new ModelRenderer(this, 4, 0);
            this.tooth9.setPos(-2.0F, 0.5F, -2.5F);
            this.tooth9.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
            this.tooth10 = new ModelRenderer(this, 4, 0);
            this.tooth10.setPos(2.0F, 0.5F, -2.5F);
            this.tooth10.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
            this.Leg1 = new ModelRenderer(this, 0, 67);
            this.Leg1.setPos(0.0F, 8.0F, -2.5F);
            this.Leg1.addBox(-2.5F, -0.5F, 0.0F, 5, 5, 5, 0.0F);
            this.Leg4 = new ModelRenderer(this, 0, 78);
            this.Leg4.setPos(0.0F, 4.0F, 5.0F);
            this.Leg4.addBox(-2.5F, 0.0F, -5.0F, 5, 7, 5, 0.0F);
            this.setRotateAngle(Leg4, -1.0471975511965976F, 0.0F, 0.0F);
            this.Body = new ModelRenderer(this, 0, 0);
            this.Body.setPos(0.0F, 9.5F, 0.0F);
            this.Body.addBox(-7.0F, -7.5F, -8.0F, 14, 15, 18, 0.0F);
            this.Chest = new ModelRenderer(this, 64, 0);
            this.Chest.setPos(0.0F, -1.0F, -8.0F);
            this.Chest.addBox(-6.5F, -6.0F, -6.0F, 13, 13, 7, 0.0F);
            this.setRotateAngle(Chest, -0.08726646259971647F, 0.0F, 0.0F);
            this.tooth7 = new ModelRenderer(this, 4, 0);
            this.tooth7.setPos(-2.5F, 0.5F, -4.5F);
            this.tooth7.addBox(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
            this.Tail1 = new ModelRenderer(this, 0, 5);
            this.Tail1.setPos(0.0F, -5.0F, 5.7F);
            this.Tail1.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 2, 0.0F);
            this.setRotateAngle(Tail1, 0.17453292519943295F, 0.0F, 0.0F);
            this.Jaw = new ModelRenderer(this, 46, 0);
            this.Jaw.setPos(0.0F, 1.5F, -7.0F);
            this.Jaw.addBox(-4.0F, 0.0F, -3.5F, 8, 3, 4, 0.0F);
            this.JawTip = new ModelRenderer(this, 90, 63);
            this.JawTip.setPos(0.0F, 0.0F, -4.5F);
            this.JawTip.addBox(-4.5F, 0.0F, -2.0F, 9, 3, 3, 0.0F);
            this.tooth4 = new ModelRenderer(this, 14, 0);
            this.tooth4.setPos(0.7F, 1.0F, -3.0F);
            this.tooth4.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
            this.setRotateAngle(tooth4, 0.7853981633974483F, 0.0F, 0.03490658503988659F);
            this.Head = new ModelRenderer(this, 0, 50);
            this.Head.setPos(0.0F, -0.2F, -2.0F);
            this.Head.addBox(-5.5F, -5.0F, -7.0F, 11, 10, 7, 0.0F);
            this.setRotateAngle(Head, 0.17453292519943295F, 0.0F, 0.0F);
            this.Foot4 = new ModelRenderer(this, 15, 75);
            this.Foot4.setPos(0.0F, 6.3F, -2.6F);
            this.Foot4.addBox(-3.0F, -1.0F, -3.0F, 6, 3, 5, 0.0F);
            this.setRotateAngle(Foot4, 0.17453292519943295F, 0.0F, -0.04363323129985824F);
            this.Ear1 = new ModelRenderer(this, 0, 0);
            this.Ear1.setPos(4.0F, -3.5F, -1.5F);
            this.Ear1.addBox(-0.5F, -3.0F, -1.0F, 1, 2, 2, 0.0F);
            this.setRotateAngle(Ear1, -0.3490658503988659F, -0.0F, 0.5235987755982988F);
            this.tooth2 = new ModelRenderer(this, 14, 0);
            this.tooth2.setPos(-2.0F, 0.2F, -5.0F);
            this.tooth2.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
            this.setRotateAngle(tooth2, 0.0F, 0.0F, -0.17453292519943295F);
            this.Tail2 = new ModelRenderer(this, 10, 5);
            this.Tail2.setPos(0.0F, 4.0F, 0.5F);
            this.Tail2.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
            this.setRotateAngle(Tail2, -0.17453292519943295F, 0.0F, 0.0F);
            this.Jaw.addChild(this.tooth1);
            this.Thigh4.addChild(this.UpperLeg4);
            this.Leg2.addChild(this.Foot2);
            this.Body.addChild(this.Thigh4);
            this.Body.addChild(this.Thigh3);
            this.Head.addChild(this.cheeks);
            this.snout.addChild(this.nose);
            this.snout.addChild(this.tooth8);
            this.Leg3.addChild(this.Foot3);
            this.Chest.addChild(this.Thigh1);
            this.Thigh2.addChild(this.Leg2);
            this.Jaw.addChild(this.tooth3);
            this.Thigh3.addChild(this.UpperLeg3);
            this.Chest.addChild(this.Thigh2);
            this.Head.addChild(this.snout);
            this.snout.addChild(this.tooth5);
            this.snout.addChild(this.tooth6);
            this.Leg1.addChild(this.Foot1);
            this.UpperLeg3.addChild(this.Leg3);
            this.Chest.addChild(this.Neck);
            this.Body.addChild(this.Hips);
            this.Head.addChild(this.Ear2);
            this.snout.addChild(this.tooth9);
            this.snout.addChild(this.tooth10);
            this.Thigh1.addChild(this.Leg1);
            this.UpperLeg4.addChild(this.Leg4);
            this.Body.addChild(this.Chest);
            this.snout.addChild(this.tooth7);
            this.Hips.addChild(this.Tail1);
            this.Head.addChild(this.Jaw);
            this.Jaw.addChild(this.JawTip);
            this.Jaw.addChild(this.tooth4);
            this.Neck.addChild(this.Head);
            this.Leg4.addChild(this.Foot4);
            this.Head.addChild(this.Ear1);
            this.Jaw.addChild(this.tooth2);
            this.Tail1.addChild(this.Tail2);
        }

        @Override
        public void setupAnim(CommonHippopotamusEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            float speed = 8.0f;
            float degree = 2.0f;

            if (entity.isInWater()) {
                limbSwing = (float) entity.tickCount;
                limbSwingAmount = 0.3F;
                speed = 2.0F;
            }
        }
    }

    public static class Child extends CommonHippopotamusModel {
        public Child() {
            this.Foot1 = new ModelRenderer(this, 71, 31);
            this.Foot1.setPos(0.0F, 3.5F, 0.0F);
            this.Foot1.addBox(-2.0F, -1.0F, -2.0F, 4, 2, 3, 0.0F);
            this.setRotateAngle(Foot1, 0.02617993877991494F, 0.0F, -0.04363323129985824F);
            this.Tail2 = new ModelRenderer(this, 19, 57);
            this.Tail2.setPos(0.0F, 2.0F, 0.5F);
            this.Tail2.addBox(-0.5F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
            this.setRotateAngle(Tail2, -0.17453292519943295F, 0.0F, 0.0F);
            this.Thigh4 = new ModelRenderer(this, 3, 75);
            this.Thigh4.setPos(2.9F, 1.0F, 3.5F);
            this.Thigh4.addBox(-2.5F, -2.0F, -2.5F, 5, 6, 5, 0.0F);
            this.setRotateAngle(Thigh4, 0.17453292519943295F, 0.0F, 0.04363323129985824F);
            this.Head = new ModelRenderer(this, 38, 50);
            this.Head.setPos(0.0F, 0.2F, -1.5F);
            this.Head.addBox(-3.0F, -3.0F, -5.0F, 6, 6, 5, 0.0F);
            this.setRotateAngle(Head, 0.17453292519943295F, 0.0F, 0.0F);
            this.Jaw = new ModelRenderer(this, 48, 20);
            this.Jaw.setPos(0.0F, 1.0F, -4.5F);
            this.Jaw.addBox(-2.0F, -0.5F, -3.0F, 4, 2, 3, 0.0F);
            this.Leg4 = new ModelRenderer(this, 57, 80);
            this.Leg4.setPos(0.0F, 3.0F, 3.0F);
            this.Leg4.addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3, 0.0F);
            this.setRotateAngle(Leg4, -1.0471975511965976F, 0.0F, 0.0F);
            this.Ear2 = new ModelRenderer(this, 35, 24);
            this.Ear2.mirror = true;
            this.Ear2.setPos(-2.0F, -2.0F, -2.5F);
            this.Ear2.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
            this.setRotateAngle(Ear2, -0.3490658503988659F, 0.0F, -0.5235987755982988F);
            this.Chest = new ModelRenderer(this, 0, 24);
            this.Chest.setPos(0.0F, -0.5F, -5.0F);
            this.Chest.addBox(-4.5F, -3.5F, -3.0F, 9, 8, 4, 0.0F);
            this.setRotateAngle(Chest, -0.08726646259971647F, 0.0F, 0.0F);
            this.Leg2 = new ModelRenderer(this, 71, 18);
            this.Leg2.mirror = true;
            this.Leg2.setPos(0.0F, 4.0F, 0.0F);
            this.Leg2.addBox(-1.5F, -0.5F, -1.5F, 3, 4, 3, 0.0F);
            this.setRotateAngle(Leg2, -0.1308996938995747F, 0.0F, 0.0F);
            this.UpperLeg3 = new ModelRenderer(this, 34, 79);
            this.UpperLeg3.mirror = true;
            this.UpperLeg3.setPos(0.0F, 3.5F, -2.0F);
            this.UpperLeg3.addBox(-2.0F, 0.0F, 0.0F, 4, 3, 3, 0.0F);
            this.setRotateAngle(UpperLeg3, 0.6981317007977318F, 0.0F, 0.0F);
            this.Tail1 = new ModelRenderer(this, 4, 56);
            this.Tail1.setPos(0.0F, 2.0F, 2.7F);
            this.Tail1.addBox(-1.0F, 0.0F, -1.5F, 2, 2, 2, 0.0F);
            this.setRotateAngle(Tail1, 0.24434609527920614F, 0.0F, 0.0F);
            this.Foot3 = new ModelRenderer(this, 75, 80);
            this.Foot3.mirror = true;
            this.Foot3.setPos(0.0F, 4.0F, -1.4F);
            this.Foot3.addBox(-2.0F, -1.0F, -2.0F, 4, 2, 3, 0.0F);
            this.setRotateAngle(Foot3, 0.17453292519943295F, 0.0F, 0.04363323129985824F);
            this.nose = new ModelRenderer(this, 47, 30);
            this.nose.setPos(0.0F, 0.9F, -2.5F);
            this.nose.addBox(-3.0F, -4.0F, -2.0F, 6, 4, 2, 0.0F);
            this.Neck = new ModelRenderer(this, 0, 41);
            this.Neck.setPos(0.0F, -0.2F, -1.5F);
            this.Neck.addBox(-4.0F, -3.0F, -3.0F, 8, 7, 4, 0.0F);
            this.setRotateAngle(Neck, 0.08726646259971647F, 0.0F, 0.0F);
            this.Leg1 = new ModelRenderer(this, 71, 18);
            this.Leg1.setPos(0.0F, 4.0F, 0.0F);
            this.Leg1.addBox(-1.5F, -0.5F, -1.5F, 3, 4, 3, 0.0F);
            this.setRotateAngle(Leg1, -0.1308996938995747F, 0.0F, 0.0F);
            this.Hips = new ModelRenderer(this, 67, 44);
            this.Hips.setPos(0.0F, -4.0F, 4.5F);
            this.Hips.addBox(-4.5F, 0.0F, 0.0F, 9, 8, 3, 0.0F);
            this.setRotateAngle(Hips, -0.12217304763960307F, 0.0F, 0.0F);
            this.Foot2 = new ModelRenderer(this, 71, 31);
            this.Foot2.mirror = true;
            this.Foot2.setPos(0.0F, 3.5F, 0.0F);
            this.Foot2.addBox(-2.0F, -1.0F, -2.0F, 4, 2, 3, 0.0F);
            this.setRotateAngle(Foot2, 0.02617993877991494F, 0.0F, 0.04363323129985824F);
            this.UpperLeg4 = new ModelRenderer(this, 34, 79);
            this.UpperLeg4.setPos(0.0F, 3.5F, -2.0F);
            this.UpperLeg4.addBox(-2.0F, 0.0F, 0.0F, 4, 3, 3, 0.0F);
            this.setRotateAngle(UpperLeg4, 0.6981317007977318F, 0.0F, 0.0F);
            this.Thigh1 = new ModelRenderer(this, 71, 5);
            this.Thigh1.setPos(3.3F, 1.0F, -0.5F);
            this.Thigh1.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
            this.setRotateAngle(Thigh1, 0.17453292519943295F, 0.0F, 0.04363323129985824F);
            this.Leg3 = new ModelRenderer(this, 53, 80);
            this.Leg3.mirror = true;
            this.Leg3.setPos(0.0F, 3.0F, 3.0F);
            this.Leg3.addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3, 0.0F);
            this.setRotateAngle(Leg3, -1.0471975511965976F, 0.0F, 0.0F);
            this.Thigh3 = new ModelRenderer(this, 3, 75);
            this.Thigh3.mirror = true;
            this.Thigh3.setPos(-2.9F, 1.0F, 3.5F);
            this.Thigh3.addBox(-2.5F, -2.0F, -2.5F, 5, 6, 5, 0.0F);
            this.setRotateAngle(Thigh3, 0.17453292519943295F, 0.0F, -0.04363323129985824F);
            this.Thigh2 = new ModelRenderer(this, 71, 5);
            this.Thigh2.mirror = true;
            this.Thigh2.setPos(-3.3F, 1.0F, -0.5F);
            this.Thigh2.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
            this.setRotateAngle(Thigh2, 0.17453292519943295F, 0.0F, -0.04363323129985824F);
            this.snout = new ModelRenderer(this, 45, 39);
            this.snout.setPos(0.0F, 0.5F, -3.5F);
            this.snout.addBox(-2.5F, -3.0F, -3.0F, 5, 4, 3, 0.0F);
            this.setRotateAngle(snout, 0.08726646259971647F, 0.0F, 0.0F);
            this.Ear1 = new ModelRenderer(this, 35, 24);
            this.Ear1.setPos(2.0F, -2.0F, -2.5F);
            this.Ear1.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
            this.setRotateAngle(Ear1, -0.3490658503988659F, 0.0F, 0.5235987755982988F);
            this.Body = new ModelRenderer(this, 0, 0);
            this.Body.setPos(0.0F, 15.2F, 1.0F);
            this.Body.addBox(-5.0F, -4.5F, -6.0F, 10, 9, 11, 0.0F);
            this.Foot4 = new ModelRenderer(this, 75, 80);
            this.Foot4.setPos(0.0F, 4.0F, -1.4F);
            this.Foot4.addBox(-2.0F, -1.0F, -2.0F, 4, 2, 3, 0.0F);
            this.setRotateAngle(Foot4, 0.17453292519943295F, 0.0F, -0.04363323129985824F);
            this.Leg1.addChild(this.Foot1);
            this.Tail1.addChild(this.Tail2);
            this.Body.addChild(this.Thigh4);
            this.Neck.addChild(this.Head);
            this.Head.addChild(this.Jaw);
            this.UpperLeg4.addChild(this.Leg4);
            this.Head.addChild(this.Ear2);
            this.Body.addChild(this.Chest);
            this.Thigh2.addChild(this.Leg2);
            this.Thigh3.addChild(this.UpperLeg3);
            this.Hips.addChild(this.Tail1);
            this.Leg3.addChild(this.Foot3);
            this.snout.addChild(this.nose);
            this.Chest.addChild(this.Neck);
            this.Thigh1.addChild(this.Leg1);
            this.Body.addChild(this.Hips);
            this.Leg2.addChild(this.Foot2);
            this.Thigh4.addChild(this.UpperLeg4);
            this.Chest.addChild(this.Thigh1);
            this.UpperLeg3.addChild(this.Leg3);
            this.Body.addChild(this.Thigh3);
            this.Chest.addChild(this.Thigh2);
            this.Head.addChild(this.snout);
            this.Head.addChild(this.Ear1);
            this.Leg4.addChild(this.Foot4);
        }

        @Override
        public void setupAnim(CommonHippopotamusEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            float speed = 8.0f;
            float degree = 2.0f;

            if (entity.isInWater()) {
                limbSwing = (float) entity.tickCount;
                limbSwingAmount = 0.3F;
                speed = 2.0F;
            }
        }
    }
}
