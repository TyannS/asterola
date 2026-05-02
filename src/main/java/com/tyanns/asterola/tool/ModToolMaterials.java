package com.tyanns.asterola.tool;

import com.tyanns.asterola.tag.ModItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class ModToolMaterials {
    public static final ToolMaterial ROSE_GOLD = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            175,
            12.0F,
            2.0F,
            25,
            ModItemTags.ROSE_GOLD_TOOL_MATERIALS
    );
}
