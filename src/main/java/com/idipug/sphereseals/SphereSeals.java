package com.idipug.sphereseals;

import com.idipug.sphereseals.entity.ModEntities;
import com.idipug.sphereseals.entity.custom.SphereSealEntity;
import com.idipug.sphereseals.item.ModItems;
import com.idipug.sphereseals.sounds.ModSounds;
import com.idipug.sphereseals.world.gen.MobEntitySpawns;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SphereSeals implements ModInitializer {
	public static final String MOD_ID = "sphereseals";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModEntities.registerModEntities();
		MobEntitySpawns.addSpawns();
		ModSounds.registerSounds();
		LOGGER.info("Hello Fabric world!");

		FabricDefaultAttributeRegistry.register(ModEntities.SPHERE_SEAL, SphereSealEntity.createAttributes());
	}
}