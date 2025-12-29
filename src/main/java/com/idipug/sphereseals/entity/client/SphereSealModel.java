package com.idipug.sphereseals.entity.client;

import com.idipug.sphereseals.SphereSeals;
import com.idipug.sphereseals.entity.custom.SphereSealEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class SphereSealModel<T extends SphereSealEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer SPHERE_SEAL = new EntityModelLayer(Identifier.of(SphereSeals.MOD_ID, "spheal"), "main");
    private final ModelPart root;
    private final ModelPart spheal;

        public SphereSealModel(ModelPart root) {
            this.root = root;
            this.spheal = root.getChild("spheal");
        }
        public static TexturedModelData getTexturedModelData() {
            ModelData modelData = new ModelData();
            ModelPartData modelPartData = modelData.getRoot();
            ModelPartData spheal = modelPartData.addChild("spheal", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

            ModelPartData tailwhack = spheal.addChild("tailwhack", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -0.5F, 4.4063F));

            ModelPartData lefttailpiece = tailwhack.addChild("lefttailpiece", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 0.5F, -0.4063F));

            ModelPartData cube_r1 = lefttailpiece.addChild("cube_r1", ModelPartBuilder.create().uv(14, 16).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

            ModelPartData middletailpiece = tailwhack.addChild("middletailpiece", ModelPartBuilder.create().uv(14, 20).cuboid(0.0F, -0.999F, -1.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 0.5F, 0.5937F));

            ModelPartData righttailpiece = tailwhack.addChild("righttailpiece", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 0.5F, -0.4063F));

            ModelPartData cube_r2 = righttailpiece.addChild("cube_r2", ModelPartBuilder.create().uv(0, 23).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.4363F, 0.0F));

            ModelPartData flipperight = spheal.addChild("flipperight", ModelPartBuilder.create(), ModelTransform.pivot(-4.0F, -0.5F, -1.5F));

            ModelPartData cube_r3 = flipperight.addChild("cube_r3", ModelPartBuilder.create().uv(24, 16).cuboid(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 0.0F, -0.0873F, 0.0F));

            ModelPartData earballleft = spheal.addChild("earballleft", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, -8.0F, -2.5F));

            ModelPartData cube_r4 = earballleft.addChild("cube_r4", ModelPartBuilder.create().uv(24, 20).cuboid(-1.0F, -0.3F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0873F));

            ModelPartData earballright = spheal.addChild("earballright", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, -8.0F, -2.5F));

            ModelPartData cube_r5 = earballright.addChild("cube_r5", ModelPartBuilder.create().uv(20, 24).cuboid(-1.0F, -0.3F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -0.0436F));

            ModelPartData flipperleft = spheal.addChild("flipperleft", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, -0.5F, -1.5F));

            ModelPartData cube_r6 = flipperleft.addChild("cube_r6", ModelPartBuilder.create().uv(10, 24).cuboid(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, 0.0F, 0.0F, 0.0873F, 0.0F));

            ModelPartData snout = spheal.addChild("snout", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -4.0F, -4.0F));

            ModelPartData cube_r7 = snout.addChild("cube_r7", ModelPartBuilder.create().uv(24, 22).cuboid(0.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, 0.5F, -0.5F, 0.0F, -1.5708F, 0.0F));

            ModelPartData cube_r8 = snout.addChild("cube_r8", ModelPartBuilder.create().uv(20, 26).cuboid(0.5F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 1.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

            ModelPartData sniffer = snout.addChild("sniffer", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -0.5F, 0.0F));

            ModelPartData cube_r9 = sniffer.addChild("cube_r9", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.5F, 0.0F, 0.0F, -1.5708F, 0.0F));
            return TexturedModelData.of(modelData, 64, 64);
        }

        @Override
        public void setAngles(SphereSealEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
            this.getPart().traverse().forEach(ModelPart::resetTransform);

            if (entity.clapAnimationState.isRunning()) {
                this.updateAnimation(
                        entity.clapAnimationState,
                        SphereSealAnimations.clap_clap,
                        ageInTicks,
                        1.0f
                );
            }

            else if (entity.petAnimationState.isRunning()) {
                this.updateAnimation(entity.petAnimationState,
                        SphereSealAnimations.pet_pet,
                        ageInTicks,
                        1.0f);
            }

           else if (entity.rollAnimationState.isRunning()) {
                this.updateAnimation(
                        entity.rollAnimationState,
                        SphereSealAnimations.roll,
                        ageInTicks,
                        1.0f
                );
            }

            else if (entity.waddleAnimationState.isRunning()) {
                this.updateAnimation(
                        entity.waddleAnimationState,
                        SphereSealAnimations.waddle,
                        ageInTicks,
                        1.0f
                );
            }

            else {
                this.updateAnimation(
                        entity.idleAnimationState,
                        SphereSealAnimations.idle,
                        ageInTicks,
                        1.0f
                );
            }
        }


        @Override
        public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
            spheal.render(matrices, vertexConsumer, light, overlay, color);
        }

        @Override
        public ModelPart getPart() {
            return root;
        }
}