package com.idipug.sphereseals.entity.client;

import com.idipug.sphereseals.SphereSeals;
import com.idipug.sphereseals.entity.custom.SphereSealEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SphereSealRenderer
        extends MobEntityRenderer<SphereSealEntity, SphereSealRenderState, SphereSealModel> {

    private static final Identifier TEXTURE =
            Identifier.of(SphereSeals.MOD_ID, "textures/entity/sphere_seal.png");

    public SphereSealRenderer(EntityRendererFactory.Context context) {
        super(context,
                new SphereSealModel(context.getPart(SphereSealModel.SPHERE_SEAL)),
                0.35f);
    }

    @Override
    public Identifier getTexture(SphereSealRenderState state) {
        return TEXTURE;
    }

    @Override
    public void render(
            SphereSealRenderState state, MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState) {
        if (state.baby) {
            matrixStack.scale(0.8f, 0.8f, 0.8f);
        } else {
            matrixStack.scale(1.5f, 1.5f, 1.5f);
        }

        super.render(state, matrixStack, orderedRenderCommandQueue, cameraRenderState);
    }

    @Override
    public SphereSealRenderState createRenderState() {
        return new SphereSealRenderState();
    }

    @Override
    public void updateRenderState(
            SphereSealEntity entity,
            SphereSealRenderState state,
            float tickDelta
    ) {
        super.updateRenderState(entity, state, tickDelta);

        state.idleAnimationState.copyFrom(entity.idleAnimationState);
        state.clapAnimationState.copyFrom(entity.clapAnimationState);
        state.petAnimationState.copyFrom(entity.petAnimationState);
        state.rollAnimationState.copyFrom(entity.rollAnimationState);
        state.waddleAnimationState.copyFrom(entity.waddleAnimationState);
    }
}
