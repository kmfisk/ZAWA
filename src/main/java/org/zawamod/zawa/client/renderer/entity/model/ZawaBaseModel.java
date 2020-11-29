package org.zawamod.zawa.client.renderer.entity.model;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.entity.Entity;
import org.zawamod.zawa.util.ZawaUtilities;

public abstract class ZawaBaseModel<E extends Entity> extends SegmentedModel<E> {
    public ZawaBaseModel() {
    }

    @Override
    public void setRotationAngles(E entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        setMovingAnimations(entity, limbSwing, limbSwingAmount);
        if (!ZawaUtilities.isMoving(entity)) {
            limbSwing = (float)entity.ticksExisted;
            limbSwingAmount = 0.3F;
            setIdleAnimations(entity, limbSwing, limbSwingAmount);
        }
    }

    public abstract void setMovingAnimations(E entity, float limbSwing, float limbSwingAmount);

    public abstract void setIdleAnimations(E entity, float limbSwing, float limbSwingAmount);

    public abstract void setSleepAnimations(E entity, float limbSwing, float limbSwingAmount);
}
