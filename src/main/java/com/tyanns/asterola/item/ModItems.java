package com.tyanns.asterola.item;

import com.tyanns.asterola.Asterola;
import com.tyanns.asterola.food.ModConsumables;
import com.tyanns.asterola.food.ModFoods;
import com.tyanns.asterola.sound.ModJukeboxSongs;
import com.tyanns.asterola.tool.ModToolMaterials;
import com.tyanns.asterola.trim.ModTrimMaterials;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;

import java.util.function.Function;

public class ModItems {

    public static final Item ROSE_GOLD_INGOT = registerItem("rose_gold_ingot", new Item.Properties().trimMaterial(ModTrimMaterials.ROSE_GOLD));
    public static final Item ROSE_GOLDEN_APPLE = registerItem("rose_golden_apple", new Item.Properties().food(ModFoods.ROSE_GOLDEN_APPLE, ModConsumables.ROSE_GOLDEN_APPLE));
    public static final Item ROSE_GOLDEN_SWORD = registerItem("rose_golden_sword", new Item.Properties().sword(ModToolMaterials.ROSE_GOLD, 4.0F, -2.2F));
    public static final Item ROSE_GOLDEN_SHOVEL = registerItem("rose_golden_shovel", p -> new ShovelItem(ModToolMaterials.ROSE_GOLD, 1.5F, -3.0F, p));
    public static final Item ROSE_GOLDEN_PICKAXE = registerItem("rose_golden_pickaxe", (new Item.Properties()).pickaxe(ModToolMaterials.ROSE_GOLD, 1.0F, -2.8F));
    public static final Item ROSE_GOLDEN_AXE = registerItem("rose_golden_axe",p -> new AxeItem(ModToolMaterials.ROSE_GOLD, 7.0F, -2.9F, p));
    public static final Item ROSE_GOLDEN_HOE = registerItem("rose_golden_hoe", p -> new HoeItem(ModToolMaterials.ROSE_GOLD, 0.0F, -1.5F, p));
    public static final Item MUSIC_DISC_YOU_ARE_BEAUTIFUL_VOMIT_VERSION = registerItem("music_disc_you_are_beautiful_vomit_version", (new Item.Properties()).stacksTo(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ModJukeboxSongs.YOU_ARE_BEAUTIFUL_VOMIT_VERSION));

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

    }
}
