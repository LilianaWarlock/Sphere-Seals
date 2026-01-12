package com.idipug.sphereseals.entity.client;

import com.idipug.sphereseals.SphereSeals;
import com.idipug.sphereseals.entity.custom.SphereSealEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class SphereSealModel extends EntityModel<SphereSealRenderState> {
    public static final EntityModelLayer SPHERE_SEAL = new EntityModelLayer(Identifier.of(SphereSeals.MOD_ID, "spheal"), "main");
    private final ModelPart root;
    private final ModelPart spheal;

    private final Animation idle;
    private final Animation waddle;
    private final Animation roll_over;
    private final Animation pet_pet;
    private final Animation roll;
    private final Animation clap_clap;

        public SphereSealModel(ModelPart root) {
            super(root);
            this.root = root;
            this.spheal = root.getChild("spheal");

            this.idle = SphereSealAnimations.idle.createAnimation(root);
            this.waddle = SphereSealAnimations.waddle.createAnimation(root);
            this.roll_over = SphereSealAnimations.roll_over.createAnimation(root);
            this.pet_pet = SphereSealAnimations.pet_pet.createAnimation(root);
            this.roll = SphereSealAnimations.roll.createAnimation(root);
            this.clap_clap = SphereSealAnimations.clap_clap.createAnimation(root);
        }
        public static TexturedModelData getTexturedModelData() {
            ModelData modelData = new ModelData();
            ModelPartData modelPartData = modelData.getRoot();
            ModelPartData spheal = modelPartData.addChild("spheal", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));

            ModelPartData tailwhack = spheal.addChild("tailwhack", ModelPartBuilder.create(), ModelTransform.of(0.0F, -0.5F, 4.4063F, 0.0F, 0.0F, 0.0F));

            ModelPartData lefttailpiece = tailwhack.addChild("lefttailpiece", ModelPartBuilder.create(), ModelTransform.of(1.0F, 0.5F, -0.4063F, 0.0F, 0.0F, 0.0F));

            ModelPartData cube_r1 = lefttailpiece.addChild("cube_r1", ModelPartBuilder.create().uv(14, 16).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

            ModelPartData middletailpiece = tailwhack.addChild("middletailpiece", ModelPartBuilder.create().uv(14, 20).cuboid(0.0F, -0.999F, -1.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.5F, 0.5937F, 0.0F, 0.0F, 0.0F));

            ModelPartData righttailpiece = tailwhack.addChild("righttailpiece", ModelPartBuilder.create(), ModelTransform.of(-1.0F, 0.5F, -0.4063F, 0.0F, 0.0F, 0.0F));

            ModelPartData cube_r2 = righttailpiece.addChild("cube_r2", ModelPartBuilder.create().uv(0, 23).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.4363F, 0.0F));

            ModelPartData flipperight = spheal.addChild("flipperight", ModelPartBuilder.create(), ModelTransform.of(-4.0F, -0.5F, -1.5F, 0.0F, 0.0F, 0.0F));

            ModelPartData cube_r3 = flipperight.addChild("cube_r3", ModelPartBuilder.create().uv(24, 16).cuboid(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 0.0F, -0.0873F, 0.0F));

            ModelPartData earballleft = spheal.addChild("earballleft", ModelPartBuilder.create(), ModelTransform.of(2.0F, -8.0F, -2.5F, 0.0F, 0.0F, 0.0F));

            ModelPartData cube_r4 = earballleft.addChild("cube_r4", ModelPartBuilder.create().uv(24, 20).cuboid(-1.0F, -0.3F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0873F));

            ModelPartData earballright = spheal.addChild("earballright", ModelPartBuilder.create(), ModelTransform.of(-2.0F, -8.0F, -2.5F, 0.0F, 0.0F, 0.0F));

            ModelPartData cube_r5 = earballright.addChild("cube_r5", ModelPartBuilder.create().uv(20, 24).cuboid(-1.0F, -0.3F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -0.0436F));

            ModelPartData flipperleft = spheal.addChild("flipperleft", ModelPartBuilder.create(), ModelTransform.of(4.0F, -0.5F, -1.5F, 0.0F, 0.0F, 0.0F));

            ModelPartData cube_r6 = flipperleft.addChild("cube_r6", ModelPartBuilder.create().uv(10, 24).cuboid(-1.0F, -0.5F, -1.5F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, 0.0F, 0.0F, 0.0873F, 0.0F));

            ModelPartData snout = spheal.addChild("snout", ModelPartBuilder.create(), ModelTransform.of(0.0F, -4.0F, -4.0F, 0.0F, 0.0F, 0.0F));

            ModelPartData cube_r7 = snout.addChild("cube_r7", ModelPartBuilder.create().uv(24, 22).cuboid(0.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, 0.5F, -0.5F, 0.0F, -1.5708F, 0.0F));

            ModelPartData cube_r8 = snout.addChild("cube_r8", ModelPartBuilder.create().uv(20, 26).cuboid(0.5F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 1.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

            ModelPartData sniffer = snout.addChild("sniffer", ModelPartBuilder.create(), ModelTransform.of(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F));

            ModelPartData cube_r9 = sniffer.addChild("cube_r9", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.5F, 0.0F, 0.0F, -1.5708F, 0.0F));
            return TexturedModelData.of(modelData, 64, 64);
        }

        @Override
        public void setAngles(SphereSealRenderState state) {
            super.setAngles(state);

            if (state.clapAnimationState.isRunning()) {
                this.clap_clap.apply(
                        state.clapAnimationState,
                        state.age,
                        1.0f
                );
            }
            else if (state.petAnimationState.isRunning()) {
                this.pet_pet.apply(
                        state.petAnimationState,
                        state.age,
                        1.0f
                );
            }
            else if (state.rollAnimationState.isRunning()) {
                this.roll.apply(
                        state.rollAnimationState,
                        state.age,
                        1.0f
                );
            }
            else if (state.waddleAnimationState.isRunning()) {
                this.waddle.apply(
                        state.waddleAnimationState,
                        state.age,
                        1.0f
                );
            }
            else {
                this.idle.apply(
                        state.idleAnimationState,
                        state.age,
                        1.0f
                );
            }
        }
}