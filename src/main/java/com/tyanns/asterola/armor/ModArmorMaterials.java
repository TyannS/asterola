package com.tyanns.asterola.armor;

import com.google.common.collect.Maps;
import com.tyanns.asterola.Asterola;
import com.tyanns.asterola.tag.ModItemTags;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public interface ModArmorMaterials {
    ArmorMaterial ROSE_GOLD = new ArmorMaterial(
            13, makeDefense(2, 5, 6, 2, 5), 28, SoundEvents.ARMOR_EQUIP_GOLD, 0.0F, 0.0F, ModItemTags.REPAIRS_ROSE_GOLD_ARMOR, ModEquipmentAssets.ROSE_GOLD
    );

    static Map<ArmorType, Integer> makeDefense(final int boots, final int legs, final int chest, final int helm, final int body) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body));
    }
}
