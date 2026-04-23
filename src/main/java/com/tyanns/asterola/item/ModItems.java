package com.tyanns.asterola.item;

import com.tyanns.asterola.Asterola;
import com.tyanns.asterola.trim.ModTrimMaterials;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.trim.TrimMaterials;

import java.util.function.Function;

public class ModItems {

    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot", new Item.Properties().trimMaterial(ModTrimMaterials.ROSE_GOLD));

    private static Item registerItem(final String name, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Asterola.MOD_ID, name));
        Item item = (Item) itemFactory.apply(properties.setId(key));
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    private static Item registerItem(final String name, final Function<Item.Properties, Item> itemFactory) {
        return registerItem(name, itemFactory, new Item.Properties());
    }

    private static Item registerItem(final String name) {
        return registerItem(name, Item::new, new Item.Properties());
    }

    private static Item registerItem(final String name, final Item.Properties properties) {
        return registerItem(name, Item::new, properties);
    }

    public static void register() {
        Asterola.LOGGER.info("Registering Mod Items for " + Asterola.MOD_ID);
    }
}
