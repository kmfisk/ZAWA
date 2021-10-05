package org.zawamod.zawa.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.zawamod.zawa.entity.item.MotorBoatEntity;

@OnlyIn(Dist.CLIENT)
public class MotorBoatModel extends SegmentedModel<MotorBoatEntity> {
    public ModelRenderer boatSides3;
    public ModelRenderer boatSides2;
    public ModelRenderer boatSides1;
    public ModelRenderer noWater;
    public ModelRenderer boatSides5;
    public ModelRenderer boatSides4;
    public ModelRenderer MotorTop;
    public ModelRenderer Jet1;
    public ModelRenderer Jet2;
    private final ImmutableList<ModelRenderer> parts;

    public MotorBoatModel() {
        this.texWidth = 128;
        this.texHeight = 64;
        this.boatSides1 = new ModelRenderer(this, 0, 0);
        this.boatSides1.setPos(0.0F, 3.0F, 1.0F);
        this.boatSides1.addBox(-14.0F, -9.0F, -3.0F, 28, 16, 3, 0.0F);
        this.setRotateAngle(boatSides1, 1.5707963705062866F, 0.0F, 0.0F);
        this.boatSides4 = new ModelRenderer(this, 0, 39);
        this.boatSides4.mirror = true;
        this.boatSides4.setPos(0.0F, 3.0F, -9.0F);
        this.boatSides4.addBox(-14.0F, -7.0F, -1.0F, 28, 7, 2, 0.0F);
        this.setRotateAngle(boatSides4, 0.0F, 3.141592653589793F, 0.0F);
        this.Jet2 = new ModelRenderer(this, 65, 35);
        this.Jet2.setPos(0.0F, 1.0F, -1.0F);
        this.Jet2.addBox(-2.0F, 0.0F, -1.5F, 4, 6, 3, 0.0F);
        this.setRotateAngle(Jet2, 0.3490658503988659F, 0.0F, 0.0F);
        this.Jet1 = new ModelRenderer(this, 65, 20);
        this.Jet1.setPos(0.0F, 4.8F, 4.5F);
        this.Jet1.addBox(-3.5F, -4.0F, -2.5F, 7, 8, 5, 0.0F);
        this.boatSides3 = new ModelRenderer(this, 0, 29);
        this.boatSides3.setPos(15.0F, 3.0F, 0.0F);
        this.boatSides3.addBox(-8.0F, -7.0F, -1.0F, 16, 7, 2, 0.0F);
        this.setRotateAngle(boatSides3, 0.0F, 1.5707963267948966F, 0.0F);
        this.boatSides2 = new ModelRenderer(this, 0, 20);
        this.boatSides2.setPos(-15.0F, 3.0F, 4.0F);
        this.boatSides2.addBox(-13.0F, -7.0F, -1.0F, 18, 7, 2, 0.0F);
        this.setRotateAngle(boatSides2, 0.0F, 4.71238898038469F, 0.0F);
        this.boatSides5 = new ModelRenderer(this, 0, 39);
        this.boatSides5.setPos(0.0F, 3.0F, 9.0F);
        this.boatSides5.addBox(-14.0F, -7.0F, -1.0F, 28, 7, 2, 0.0F);
        this.noWater = new ModelRenderer(this, 0, 0);
        this.noWater.setPos(0.0F, -3.0F, 1.0F);
        this.noWater.addBox(-14.0F, -9.0F, -3.0F, 28, 16, 3, 0.0F);
        this.setRotateAngle(noWater, 1.5707963705062866F, 0.0F, 0.0F);
        this.MotorTop = new ModelRenderer(this, 64, 0);
        this.MotorTop.setPos(0.0F, -6.0F, 0.0F);
        this.MotorTop.addBox(-6.5F, -4.5F, 0.0F, 13, 9, 8, 0.0F);
        this.Jet1.addChild(this.Jet2);
        this.MotorTop.addChild(this.Jet1);
        this.boatSides3.addChild(this.MotorTop);
        parts = ImmutableList.of(boatSides1, boatSides2, boatSides3, boatSides4, boatSides5);
    }

    @Override
    public void setupAnim(MotorBoatEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public ImmutableList<ModelRenderer> parts() {
        return parts;
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
