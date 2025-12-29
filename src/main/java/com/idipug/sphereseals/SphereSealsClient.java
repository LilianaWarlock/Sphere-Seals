package com.idipug.sphereseals;

import com.idipug.sphereseals.entity.ModEntities;
import com.idipug.sphereseals.entity.client.SphereSealModel;
import com.idipug.sphereseals.entity.client.SphereSealRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class SphereSealsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(SphereSealModel.SPHERE_SEAL, SphereSealModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SPHERE_SEAL, SphereSealRenderer::new);
    }
}
