package com.idipug.sphereseals.item;

import com.idipug.sphereseals.SphereSeals;
import com.idipug.sphereseals.entity.ModEntities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
public static final Item SPHERE_SEAL_SPAWN_EGG = registerItem("sphere_seal_spawn_egg",
        setting -> new  SpawnEggItem(ModEntities.SPHERE_SEAL, setting));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(SphereSeals.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SphereSeals.MOD_ID, name)))));
    }

    public static void registerModItems() {
        SphereSeals.LOGGER.info("Registering Mod Items for " , SphereSeals.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(SPHERE_SEAL_SPAWN_EGG);
        });
    }
}
