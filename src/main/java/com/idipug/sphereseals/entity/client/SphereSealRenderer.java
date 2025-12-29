package com.idipug.sphereseals.entity.client;

import com.idipug.sphereseals.SphereSeals;
import com.idipug.sphereseals.entity.custom.SphereSealEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SphereSealRenderer extends MobEntityRenderer<SphereSealEntity, SphereSealModel<SphereSealEntity>> {
    public SphereSealRenderer(EntityRendererFactory.Context context) {
        super(context, new SphereSealModel<>(context.getPart(SphereSealModel.SPHERE_SEAL)), 0.35f);
    }

    @Override
    public Identifier getTexture(SphereSealEntity entity) {
        return Identifier.of(SphereSeals.MOD_ID, "textures/entity/sphere_seal.png");
    }

    @Override
    public void render(SphereSealEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.8f, 0.8f, 0.8f);
        } else {
            matrixStack.scale(1.5f, 1.5f, 1.5f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
