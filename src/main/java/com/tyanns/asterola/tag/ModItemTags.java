package com.tyanns.asterola.tag;

import com.tyanns.asterola.Asterola;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> ROSE_GOLD_TOOL_MATERIALS = bind("rose_gold_tool_materials");

    private static TagKey<Item> bind(final String name) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Asterola.MOD_ID, name));
    }
}
