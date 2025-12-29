package com.idipug.sphereseals.item;

import com.idipug.sphereseals.SphereSeals;
import com.idipug.sphereseals.entity.ModEntities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
public static final Item SPHERE_SEAL_SPAWN_EGG = registerItem("sphere_seal_spawn_egg",
        new SpawnEggItem(ModEntities.SPHERE_SEAL, 0x9CC0DF, 0xFFFFFF, new Item.Settings()));

private static Item registerItem(String name, Item item) {
    return Registry.register(Registries.ITEM, Identifier.of(SphereSeals.MOD_ID, name), item);
}

    public static void registerModItems() {
        SphereSeals.LOGGER.info("Registering Mod Items for " , SphereSeals.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(SPHERE_SEAL_SPAWN_EGG);
        });
    }
}
