package com.tyanns.asterola.item;

import com.tyanns.asterola.Asterola;
import com.tyanns.asterola.armor.*;
import com.tyanns.asterola.food.ModConsumables;
import com.tyanns.asterola.food.ModFoods;
import com.tyanns.asterola.sound.ModJukeboxSongs;
import com.tyanns.asterola.tool.*;
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
    public static final Item ROSE_GOLDEN_SWORD = registerItem("rose_golden_sword", RoseGoldenSwordItem::new);
    public static final Item ROSE_GOLDEN_SHOVEL = registerItem("rose_golden_shovel", RoseGoldenShovelItem::new);
    public static final Item ROSE_GOLDEN_PICKAXE = registerItem("rose_golden_pickaxe", RoseGoldenPickaxeItem::new);
    public static final Item ROSE_GOLDEN_AXE = registerItem("rose_golden_axe", RoseGoldenAxeItem::new);
    public static final Item ROSE_GOLDEN_HOE = registerItem("rose_golden_hoe", RoseGoldenHoeItem::new);
    public static final Item ROSE_GOLDEN_SPEAR = registerItem("rose_golden_spear", RoseGoldenSpearItem::new);
    public static final Item ROSE_GOLDEN_HELMET = registerItem("rose_golden_helmet", RoseGoldenHelmetItem::new);
    public static final Item ROSE_GOLDEN_CHESTPLATE = registerItem("rose_golden_chestplate", RoseGoldenChestplateItem::new);
    public static final Item ROSE_GOLDEN_LEGGINGS = registerItem("rose_golden_leggings", RoseGoldenLeggingsItem::new);
    public static final Item ROSE_GOLDEN_BOOTS = registerItem("rose_golden_boots", RoseGoldenBootsItem::new);
    public static final Item MUSIC_DISC_YOU_ARE_BEAUTIFUL_VOMIT_VERSION = registerItem("music_disc_you_are_beautiful_vomit_version", (new Item.Properties()).stacksTo(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ModJukeboxSongs.YOU_ARE_BEAUTIFUL_VOMIT_VERSION));
    public static final Item ASTER_COIN = registerItem("aster_coin");

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
