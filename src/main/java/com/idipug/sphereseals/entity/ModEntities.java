package com.idipug.sphereseals.entity;

import com.idipug.sphereseals.SphereSeals;
import com.idipug.sphereseals.entity.custom.SphereSealEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<SphereSealEntity> SPHERE_SEAL = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(SphereSeals.MOD_ID, "sphere-seal"),
            EntityType.Builder.create(SphereSealEntity::new, SpawnGroup.CREATURE)
                    .dimensions( 0.7f, 0.7f).build());

    public static void registerModEntities() {
        SphereSeals.LOGGER.info("Registering Mod Entities for " + SphereSeals.MOD_ID);
    }
}
