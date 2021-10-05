package org.zawamod.zawa.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.zawamod.zawa.entity.AngelfishEntity;
import org.zawamod.zawa.entity.GrevysZebraEntity;

@OnlyIn(Dist.CLIENT)
public class AngelfishModel extends SegmentedModel<AngelfishEntity> {
    public ModelRenderer Body;
    public ModelRenderer Head;
    public ModelRenderer Tail;
    public ModelRenderer BackFin;
    public ModelRenderer AnalFin;
    public ModelRenderer UnderFinLeft;
    public ModelRenderer UnderFinRight;
    public ModelRenderer PectoralFinLeft;
    public ModelRenderer PectoralFinRight;
    public ModelRenderer Face;
    public ModelRenderer ChestUnder;
    public ModelRenderer TailFinTop;
    public ModelRenderer TailFinBottom;
    private Iterable<ModelRenderer> parts;

    public AngelfishModel() {
        this.texWidth = 64;
        this.texHeight = 32;
        this.UnderFinLeft = new ModelRenderer(this, 27, 11);
        this.UnderFinLeft.setPos(0.0F, 4.0F, -3.0F);
        this.UnderFinLeft.addBox(0.0F, 0.0F, 0.0F, 0, 4, 3, 0.0F);
        this.setRotateAngle(UnderFinLeft, 0.5009094953223726F, 0.27314402793711257F, 0.0F);
        this.UnderFinRight = new ModelRenderer(this, 27, 11);
        this.UnderFinRight.mirror = true;
        this.UnderFinRight.setPos(0.0F, 4.0F, -3.0F);
        this.UnderFinRight.addBox(0.0F, 0.0F, 0.0F, 0, 4, 3, 0.0F);
        this.setRotateAngle(UnderFinRight, 0.5009094953223726F, -0.27314402793711257F, 0.0F);
        this.ChestUnder = new ModelRenderer(this, 0, 6);
        this.ChestUnder.setPos(0.0F, 6.0F, -1.7F);
        this.ChestUnder.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(ChestUnder, 1.0927506446736497F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 1, 1);
        this.Body.setPos(0.0F, 18.0F, 0.0F);
        this.Body.addBox(-2.0F, -4.0F, -5.0F, 4, 8, 9, 0.0F);
        this.Head = new ModelRenderer(this, 0, 18);
        this.Head.setPos(0.0F, -3.0F, -5.0F);
        this.Head.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 2, 0.0F);
        this.Tail = new ModelRenderer(this, 18, 0);
        this.Tail.setPos(0.0F, 0.0F, 4.0F);
        this.Tail.addBox(-1.0F, -2.0F, 0.0F, 2, 4, 3, 0.0F);
        this.PectoralFinLeft = new ModelRenderer(this, 12, 16);
        this.PectoralFinLeft.setPos(2.0F, 1.0F, -5.0F);
        this.PectoralFinLeft.addBox(0.0F, -1.0F, 0.0F, 0, 2, 2, 0.0F);
        this.setRotateAngle(PectoralFinLeft, 0.0F, 0.5009094953223726F, 0.0F);
        this.TailFinBottom = new ModelRenderer(this, 27, 8);
        this.TailFinBottom.setPos(0.0F, 0.0F, 0.0F);
        this.TailFinBottom.addBox(0.0F, -1.5F, 0.0F, 0, 3, 3, 0.0F);
        this.setRotateAngle(TailFinBottom, -0.9318312876397725F, 0.0F, 0.0F);
        this.TailFinTop = new ModelRenderer(this, 27, 5);
        this.TailFinTop.setPos(0.0F, 0.0F, 2.0F);
        this.TailFinTop.addBox(0.0F, -1.5F, 0.0F, 0, 3, 3, 0.0F);
        this.setRotateAngle(TailFinTop, 0.5009094953223726F, 0.0F, 0.0F);
        this.BackFin = new ModelRenderer(this, 28, -13);
        this.BackFin.setPos(0.0F, -3.5F, -4.0F);
        this.BackFin.addBox(0.0F, -2.0F, 0.0F, 0, 4, 13, 0.0F);
        this.Face = new ModelRenderer(this, 0, 0);
        this.Face.setPos(0.0F, 1.4F, -2.0F);
        this.Face.addBox(-1.5F, 0.0F, -2.0F, 3, 4, 2, 0.0F);
        this.setRotateAngle(Face, 0.4550073359949217F, 0.0F, 0.0F);
        this.PectoralFinRight = new ModelRenderer(this, 12, 16);
        this.PectoralFinRight.mirror = true;
        this.PectoralFinRight.setPos(-2.0F, 1.0F, -5.0F);
        this.PectoralFinRight.addBox(0.0F, -1.0F, 0.0F, 0, 2, 2, 0.0F);
        this.setRotateAngle(PectoralFinRight, 0.0F, -0.5009094953223726F, 0.0F);
        this.AnalFin = new ModelRenderer(this, 28, -9);
        this.AnalFin.setPos(0.0F, 1.0F, -4.0F);
        this.AnalFin.addBox(0.0F, 0.0F, 0.0F, 0, 4, 13, 0.0F);
        this.Body.addChild(this.UnderFinLeft);
        this.Body.addChild(this.UnderFinRight);
        this.Head.addChild(this.ChestUnder);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.PectoralFinLeft);
        this.TailFinTop.addChild(this.TailFinBottom);
        this.Tail.addChild(this.TailFinTop);
        this.Body.addChild(this.BackFin);
        this.Head.addChild(this.Face);
        this.Body.addChild(this.PectoralFinRight);
        this.Body.addChild(this.AnalFin);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        if (parts == null)
            parts = ImmutableList.of(Body);
        return parts;
    }

    @Override
    public void setupAnim(AngelfishEntity angelfishEntity, float v, float v1, float v2, float v3, float v4) {

    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
