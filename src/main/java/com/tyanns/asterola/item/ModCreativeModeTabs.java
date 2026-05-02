package com.tyanns.asterola.item;

import com.tyanns.asterola.Asterola;
import com.tyanns.asterola.block.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {
    public static final ResourceKey<CreativeModeTab> ASTEROLA_TAB = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Asterola.MOD_ID, "asterola")
    );

    public static final CreativeModeTab ASTEROLA = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.ROSE_GOLD_INGOT))
            .title(Component.translatable("itemgroup.asterola"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.ROSE_GOLD_INGOT);
                output.accept(ModBlocks.ROSE_GOLD_BLOCK);
                output.accept(ModItems.ROSE_GOLDEN_APPLE);
                output.accept(ModItems.ROSE_GOLDEN_SWORD);
                output.accept(ModItems.ROSE_GOLDEN_SHOVEL);
                output.accept(ModItems.ROSE_GOLDEN_PICKAXE);
                output.accept(ModItems.ROSE_GOLDEN_AXE);
                output.accept(ModItems.ROSE_GOLDEN_HOE);
                output.accept(ModItems.ROSE_GOLDEN_SPEAR);
                output.accept(ModItems.ROSE_GOLDEN_HELMET);
                output.accept(ModItems.ROSE_GOLDEN_CHESTPLATE);
                output.accept(ModItems.ROSE_GOLDEN_LEGGINGS);
                output.accept(ModItems.ROSE_GOLDEN_BOOTS);
                output.accept(ModItems.MUSIC_DISC_YOU_ARE_BEAUTIFUL_VOMIT_VERSION);
                output.accept(ModItems.ASTER_COIN);
            }).build();

    public static void register() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ASTEROLA_TAB, ASTEROLA);
    }
}
