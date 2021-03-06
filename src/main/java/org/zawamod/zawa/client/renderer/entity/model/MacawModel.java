package org.zawamod.zawa.client.renderer.entity.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Macaw - fisk
 * Created using Tabula 7.1.0
 */
@OnlyIn(Dist.CLIENT)
public class MacawModel {
    public ModelRenderer Body;
    public ModelRenderer Neck;
    public ModelRenderer WingFoldedLeft;
    public ModelRenderer WingFoldedRight;
    public ModelRenderer Tail1;
    public ModelRenderer ThighLeft;
    public ModelRenderer ThighRight;
    public ModelRenderer Head;
    public ModelRenderer Forehead;
    public ModelRenderer Beak;
    public ModelRenderer BeakTip;
    public ModelRenderer Mouth;
    public ModelRenderer WingTip1LA;
    public ModelRenderer WingTip2LA;
    public ModelRenderer WingTip3LA;
    public ModelRenderer WingTip4LA;
    public ModelRenderer WingTip5LA;
    public ModelRenderer WingTip6LA;
    public ModelRenderer WingTip7LA;
    public ModelRenderer WingTip8LA;
    public ModelRenderer WingTip1RA;
    public ModelRenderer WingTip2RA;
    public ModelRenderer WingTip3RA;
    public ModelRenderer WingTip4RA;
    public ModelRenderer WingTip5RA;
    public ModelRenderer WingTip6RA;
    public ModelRenderer WingTip7RA;
    public ModelRenderer WingTip8RA;
    public ModelRenderer Tail2;
    public ModelRenderer TailCenter;
    public ModelRenderer Tail1Left;
    public ModelRenderer Tail1Right;
    public ModelRenderer Tail2Left;
    public ModelRenderer Tail3Left;
    public ModelRenderer Tail2Right;
    public ModelRenderer Tail3Right;
    public ModelRenderer LegLeft;
    public ModelRenderer FootLeft;
    public ModelRenderer Toe1L;
    public ModelRenderer Toe2L;
    public ModelRenderer Toe3L;
    public ModelRenderer LegRight;
    public ModelRenderer FootRight;
    public ModelRenderer Toe1R;
    public ModelRenderer Toe2R;
    public ModelRenderer Toe3R;

    /*public MacawModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.WingTip1LA = new ModelRenderer(this, 45, 0);
        this.WingTip1LA.setRotationPoint(4.8F, 1.2F, -0.2F);
        this.WingTip1LA.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(WingTip1LA, 0.0F, 0.0F, 0.6373942428283291F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 18.7F, 0.0F);
        this.Body.addBox(-2.5F, -3.5F, -2.5F, 5, 7, 5, 0.0F);
        this.setRotateAngle(Body, 0.9105382707654417F, 0.0F, 0.0F);
        this.Mouth = new ModelRenderer(this, 12, 17);
        this.Mouth.setRotationPoint(0.0F, 2.5F, -0.2F);
        this.Mouth.addBox(-0.5F, 0.0F, -1.5F, 1, 1, 2, 0.0F);
        this.WingTip8LA = new ModelRenderer(this, 45, 0);
        this.WingTip8LA.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WingTip8LA.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(WingTip8LA, 0.0F, 0.0F, -0.091106186954104F);
        this.WingTip6RA = new ModelRenderer(this, 45, 0);
        this.WingTip6RA.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WingTip6RA.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(WingTip6RA, 0.0F, 0.0F, -0.045553093477052F);
        this.WingTip8RA = new ModelRenderer(this, 45, 0);
        this.WingTip8RA.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WingTip8RA.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(WingTip8RA, 0.0F, 0.0F, -0.091106186954104F);
        this.Toe1L = new ModelRenderer(this, 32, 15);
        this.Toe1L.setRotationPoint(0.0F, 0.2F, 0.2F);
        this.Toe1L.addBox(-0.5F, -0.5F, -1.5F, 1, 1, 2, 0.0F);
        this.setRotateAngle(Toe1L, -0.091106186954104F, -0.36425021489121656F, 0.045553093477052F);
        this.WingFoldedLeft = new ModelRenderer(this, 46, 18);
        this.WingFoldedLeft.setRotationPoint(2.2F, -3.0F, 2.3F);
        this.WingFoldedLeft.addBox(0.0F, 0.0F, 0.0F, 5, 6, 1, 0.0F);
        this.setRotateAngle(WingFoldedLeft, 0.0F, 1.5707963267948966F, 0.0F);
        this.WingFoldedRight = new ModelRenderer(this, 46, 18);
        this.WingFoldedRight.setRotationPoint(-2.2F, -3.0F, 2.3F);
        this.WingFoldedRight.addBox(0.0F, 0.0F, -1.0F, 5, 6, 1, 0.0F);
        this.setRotateAngle(WingFoldedRight, 0.0F, 1.5707963267948966F, 0.0F);
        this.WingTip7RA = new ModelRenderer(this, 45, 0);
        this.WingTip7RA.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WingTip7RA.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(WingTip7RA, 0.0F, 0.0F, -0.091106186954104F);
        this.WingTip7LA = new ModelRenderer(this, 45, 0);
        this.WingTip7LA.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WingTip7LA.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(WingTip7LA, 0.0F, 0.0F, -0.091106186954104F);
        this.WingTip1RA = new ModelRenderer(this, 45, 0);
        this.WingTip1RA.setRotationPoint(5.0F, 1.2F, -0.8F);
        this.WingTip1RA.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(WingTip1RA, 0.0F, 0.0F, 0.6373942428283291F);
        this.LegRight = new ModelRenderer(this, 20, 14);
        this.LegRight.mirror = true;
        this.LegRight.setRotationPoint(-1.0F, 1.2F, 0.2F);
        this.LegRight.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(LegRight, -0.9105382707654417F, 0.0F, 0.0F);
        this.FootRight = new ModelRenderer(this, 32, 15);
        this.FootRight.mirror = true;
        this.FootRight.setRotationPoint(0.0F, 1.6F, 0.0F);
        this.FootRight.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(FootRight, 0.7285004297824331F, -0.18203784098300857F, 0.0F);
        this.WingTip2LA = new ModelRenderer(this, 45, 0);
        this.WingTip2LA.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WingTip2LA.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(WingTip2LA, 0.0F, 0.0F, -0.136659280431156F);
        this.WingTip5LA = new ModelRenderer(this, 45, 0);
        this.WingTip5LA.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WingTip5LA.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(WingTip5LA, 0.0F, 0.0F, -0.045553093477052F);
        this.WingTip3LA = new ModelRenderer(this, 45, 0);
        this.WingTip3LA.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WingTip3LA.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(WingTip3LA, 0.0F, 0.0F, -0.091106186954104F);
        this.Tail3Left = new ModelRenderer(this, 40, 0);
        this.Tail3Left.setRotationPoint(0.2F, 0.0F, -0.1F);
        this.Tail3Left.addBox(0.0F, 0.0F, -0.5F, 1, 7, 1, 0.0F);
        this.TailCenter = new ModelRenderer(this, 34, 0);
        this.TailCenter.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.TailCenter.addBox(-1.0F, 0.0F, -0.5F, 2, 11, 1, 0.0F);
        this.setRotateAngle(TailCenter, 0.091106186954104F, 0.0F, 0.0F);
        this.Tail1Left = new ModelRenderer(this, 40, 0);
        this.Tail1Left.setRotationPoint(0.4F, -4.2F, -0.1F);
        this.Tail1Left.addBox(0.0F, 0.0F, -0.5F, 1, 12, 1, 0.0F);
        this.WingTip3RA = new ModelRenderer(this, 45, 0);
        this.WingTip3RA.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WingTip3RA.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(WingTip3RA, 0.0F, 0.0F, -0.091106186954104F);
        this.Tail1Right = new ModelRenderer(this, 40, 0);
        this.Tail1Right.setRotationPoint(-0.4F, -4.2F, -0.1F);
        this.Tail1Right.addBox(-1.0F, 0.0F, -0.5F, 1, 12, 1, 0.0F);
        this.Toe2L = new ModelRenderer(this, 32, 15);
        this.Toe2L.setRotationPoint(-0.2F, 0.1F, 0.2F);
        this.Toe2L.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 2, 0.0F);
        this.setRotateAngle(Toe2L, -0.27314402793711257F, -0.6373942428283291F, 0.0F);
        this.Beak = new ModelRenderer(this, 12, 12);
        this.Beak.setRotationPoint(0.0F, -2.2F, -1.3F);
        this.Beak.addBox(-1.0F, 0.0F, -2.0F, 2, 3, 2, 0.0F);
        this.WingTip6LA = new ModelRenderer(this, 45, 0);
        this.WingTip6LA.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WingTip6LA.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(WingTip6LA, 0.0F, 0.0F, -0.045553093477052F);
        this.LegLeft = new ModelRenderer(this, 20, 14);
        this.LegLeft.setRotationPoint(1.0F, 1.2F, 0.2F);
        this.LegLeft.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(LegLeft, -0.9105382707654417F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 18);
        this.Head.setRotationPoint(0.0F, -1.3F, -1.1F);
        this.Head.addBox(-2.0F, -2.5F, -2.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(Head, -0.045553093477052F, 0.0F, 0.0F);
        this.Forehead = new ModelRenderer(this, 0, 26);
        this.Forehead.setRotationPoint(0.0F, -2.8F, 1.5F);
        this.Forehead.addBox(-1.5F, 0.0F, -4.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(Forehead, -0.045553093477052F, 0.0F, 0.0F);
        this.Toe1R = new ModelRenderer(this, 32, 15);
        this.Toe1R.mirror = true;
        this.Toe1R.setRotationPoint(0.0F, 0.2F, 0.2F);
        this.Toe1R.addBox(-0.5F, -0.5F, -1.5F, 1, 1, 2, 0.0F);
        this.setRotateAngle(Toe1R, -0.091106186954104F, 0.36425021489121656F, -0.045553093477052F);
        this.Toe3R = new ModelRenderer(this, 33, 16);
        this.Toe3R.mirror = true;
        this.Toe3R.setRotationPoint(0.0F, 0.3F, 0.2F);
        this.Toe3R.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(Toe3R, -0.045553093477052F, -0.045553093477052F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 20, 0);
        this.Tail1.setRotationPoint(0.0F, 3.5F, 0.2F);
        this.Tail1.addBox(-2.0F, -1.0F, -1.5F, 4, 4, 3, 0.0F);
        this.setRotateAngle(Tail1, 0.27314402793711257F, 0.0F, 0.0F);
        this.Toe2R = new ModelRenderer(this, 32, 15);
        this.Toe2R.mirror = true;
        this.Toe2R.setRotationPoint(-0.2F, 0.1F, 0.2F);
        this.Toe2R.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 2, 0.0F);
        this.setRotateAngle(Toe2R, -0.27314402793711257F, 0.6373942428283291F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 12);
        this.Neck.setRotationPoint(0.0F, -3.0F, 1.0F);
        this.Neck.addBox(-1.5F, -1.0F, -2.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(Neck, -0.7285004297824331F, 0.0F, 0.0F);
        this.WingTip4RA = new ModelRenderer(this, 45, 0);
        this.WingTip4RA.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WingTip4RA.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(WingTip4RA, 0.0F, 0.0F, -0.091106186954104F);
        this.Tail2 = new ModelRenderer(this, 20, 7);
        this.Tail2.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.Tail2.addBox(-1.5F, -1.0F, -1.0F, 3, 4, 2, 0.0F);
        this.setRotateAngle(Tail2, 0.091106186954104F, 0.0F, 0.0F);
        this.ThighRight = new ModelRenderer(this, 24, 14);
        this.ThighRight.mirror = true;
        this.ThighRight.setRotationPoint(-0.7F, 1.2F, -2.0F);
        this.ThighRight.addBox(-2.0F, -0.6F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(ThighRight, -0.5918411493512771F, 0.0F, 0.0F);
        this.WingTip5RA = new ModelRenderer(this, 45, 0);
        this.WingTip5RA.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WingTip5RA.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(WingTip5RA, 0.0F, 0.0F, -0.045553093477052F);
        this.Tail3Right = new ModelRenderer(this, 40, 0);
        this.Tail3Right.mirror = true;
        this.Tail3Right.setRotationPoint(-0.2F, 0.0F, -0.1F);
        this.Tail3Right.addBox(-1.0F, 0.0F, -0.5F, 1, 7, 1, 0.0F);
        this.ThighLeft = new ModelRenderer(this, 24, 14);
        this.ThighLeft.setRotationPoint(0.7F, 1.2F, -2.0F);
        this.ThighLeft.addBox(0.0F, -0.6F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(ThighLeft, -0.5918411493512771F, 0.0F, 0.0F);
        this.BeakTip = new ModelRenderer(this, 16, 20);
        this.BeakTip.setRotationPoint(0.0F, 0.5F, -2.6F);
        this.BeakTip.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(BeakTip, -0.091106186954104F, 0.0F, 0.0F);
        this.Toe3L = new ModelRenderer(this, 33, 16);
        this.Toe3L.setRotationPoint(0.0F, 0.3F, 0.2F);
        this.Toe3L.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(Toe3L, -0.045553093477052F, 0.045553093477052F, 0.0F);
        this.WingTip4LA = new ModelRenderer(this, 45, 0);
        this.WingTip4LA.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WingTip4LA.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(WingTip4LA, 0.0F, 0.0F, -0.091106186954104F);
        this.WingTip2RA = new ModelRenderer(this, 45, 0);
        this.WingTip2RA.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WingTip2RA.addBox(-1.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F);
        this.setRotateAngle(WingTip2RA, 0.0F, 0.0F, -0.136659280431156F);
        this.FootLeft = new ModelRenderer(this, 32, 15);
        this.FootLeft.setRotationPoint(0.0F, 1.6F, 0.0F);
        this.FootLeft.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(FootLeft, 0.7285004297824331F, 0.18203784098300857F, 0.0F);
        this.Tail2Right = new ModelRenderer(this, 40, 0);
        this.Tail2Right.mirror = true;
        this.Tail2Right.setRotationPoint(-0.3F, 0.0F, -0.1F);
        this.Tail2Right.addBox(-1.0F, 0.0F, -0.5F, 1, 10, 1, 0.0F);
        this.Tail2Left = new ModelRenderer(this, 40, 0);
        this.Tail2Left.setRotationPoint(0.3F, 0.0F, -0.1F);
        this.Tail2Left.addBox(0.0F, 0.0F, -0.5F, 1, 10, 1, 0.0F);
        this.WingFoldedLeft.addChild(this.WingTip1LA);
        this.Beak.addChild(this.Mouth);
        this.WingTip7LA.addChild(this.WingTip8LA);
        this.WingTip5RA.addChild(this.WingTip6RA);
        this.WingTip7RA.addChild(this.WingTip8RA);
        this.FootLeft.addChild(this.Toe1L);
        this.Body.addChild(this.WingFoldedLeft);
        this.Body.addChild(this.WingFoldedRight);
        this.WingTip6RA.addChild(this.WingTip7RA);
        this.WingTip6LA.addChild(this.WingTip7LA);
        this.WingFoldedRight.addChild(this.WingTip1RA);
        this.ThighRight.addChild(this.LegRight);
        this.LegRight.addChild(this.FootRight);
        this.WingTip1LA.addChild(this.WingTip2LA);
        this.WingTip4LA.addChild(this.WingTip5LA);
        this.WingTip2LA.addChild(this.WingTip3LA);
        this.Tail2Left.addChild(this.Tail3Left);
        this.Tail2.addChild(this.TailCenter);
        this.TailCenter.addChild(this.Tail1Left);
        this.WingTip2RA.addChild(this.WingTip3RA);
        this.TailCenter.addChild(this.Tail1Right);
        this.FootLeft.addChild(this.Toe2L);
        this.Head.addChild(this.Beak);
        this.WingTip5LA.addChild(this.WingTip6LA);
        this.ThighLeft.addChild(this.LegLeft);
        this.Neck.addChild(this.Head);
        this.Head.addChild(this.Forehead);
        this.FootRight.addChild(this.Toe1R);
        this.FootRight.addChild(this.Toe3R);
        this.Body.addChild(this.Tail1);
        this.FootRight.addChild(this.Toe2R);
        this.Body.addChild(this.Neck);
        this.WingTip3RA.addChild(this.WingTip4RA);
        this.Tail1.addChild(this.Tail2);
        this.Body.addChild(this.ThighRight);
        this.WingTip4RA.addChild(this.WingTip5RA);
        this.Tail2Right.addChild(this.Tail3Right);
        this.Body.addChild(this.ThighLeft);
        this.Beak.addChild(this.BeakTip);
        this.FootLeft.addChild(this.Toe3L);
        this.WingTip3LA.addChild(this.WingTip4LA);
        this.WingTip1RA.addChild(this.WingTip2RA);
        this.LegLeft.addChild(this.FootLeft);
        this.Tail1Right.addChild(this.Tail2Right);
        this.Tail1Left.addChild(this.Tail2Left);
    }*/

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
