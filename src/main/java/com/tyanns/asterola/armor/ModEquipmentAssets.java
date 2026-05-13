package com.tyanns.asterola.armor;

import com.tyanns.asterola.Asterola;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public interface ModEquipmentAssets {
    ResourceKey<EquipmentAsset> ROSE_GOLD = createId("rose_gold");

    static ResourceKey<EquipmentAsset> createId(final String name) {
        return ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Asterola.MOD_ID, name));
    }
}
