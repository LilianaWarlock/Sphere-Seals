package com.idipug.sphereseals.sounds;

import com.idipug.sphereseals.SphereSeals;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent SPHERE_SEAL_DEATH = registerSoundEvent("sphere_seal_death");
    public static final SoundEvent SPHERE_SEAL_CLAP = registerSoundEvent("sphere_seal_clap");
    public static final SoundEvent SPHERE_SEAL_HURT = registerSoundEvent("sphere_seal_hurt");
    public static final SoundEvent SPHERE_SEAL_IDLE = registerSoundEvent("sphere_seal_idle");
    public static final SoundEvent SPHERE_SEAL_PET = registerSoundEvent("sphere_seal_pet");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id= Identifier.of(SphereSeals.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        SphereSeals.LOGGER.info("Registering Mod Sounds for " + SphereSeals.MOD_ID);
    }
}
