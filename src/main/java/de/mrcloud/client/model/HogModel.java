package de.mrcloud.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import de.mrcloud.entities.HogEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class HogModel<T extends HogEntity> extends EntityModel<T> {

    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer bone2;
    private final ModelRenderer bone;
    private final ModelRenderer legBackLeft;
    private final ModelRenderer legBackRight;
    private final ModelRenderer legFrontLeft;
    private final ModelRenderer legFrontRight;

    public HogModel() {
        textureWidth = 64;
        textureHeight = 32;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 11.0F, 2.0F);
        body.setTextureOffset(28, 8).addBox(-5.0F, -10.0F, -7.0F, 10.0F, 16.0F, 8.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 12.0F, -7.0F);
        setRotationAngle(head, 0.0F, -0.0436F, 0.0F);
        head.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        head.setTextureOffset(16, 16).addBox(-2.0F, 0.0F, -9.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(9.7335F, 3.7876F, 6.0F);
        head.addChild(bone2);
        setRotationAngle(bone2, 0.0F, 0.0F, -0.6545F);
        bone2.setTextureOffset(21, 26).addBox(-7.6402F, -10.7876F, -14.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(bone);
        setRotationAngle(bone, 0.0F, 0.0F, 0.6545F);
        bone.setTextureOffset(21, 26).addBox(1.3F, -1.7F, -8.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        legBackLeft = new ModelRenderer(this);
        legBackLeft.setRotationPoint(3.0F, 18.0F, 7.0F);
        legBackLeft.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        legBackRight = new ModelRenderer(this);
        legBackRight.setRotationPoint(-3.0F, 18.0F, 7.0F);
        setRotationAngle(legBackRight, 0.0436F, 0.0F, 0.0F);
        legBackRight.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        legFrontLeft = new ModelRenderer(this);
        legFrontLeft.setRotationPoint(3.0F, 18.0F, -4.0F);
        legFrontLeft.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        legFrontRight = new ModelRenderer(this);
        legFrontRight.setRotationPoint(-2.0F, 18.0F, -5.0F);
        legFrontRight.setTextureOffset(0, 16).addBox(-3.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        legBackLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        legBackRight.render(matrixStack, buffer, packedLight, packedOverlay);
        legFrontLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        legFrontRight.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }



}
