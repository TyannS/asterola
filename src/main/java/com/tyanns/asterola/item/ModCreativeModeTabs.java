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
            .icon(()->new ItemStack(ModItems.ROSE_GOLD_INGOT))
            .title(Component.translatable("itemgroup.asterola"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.ROSE_GOLD_INGOT);
                output.accept(ModBlocks.ROSE_GOLD_BLOCK);
                output.accept(ModItems.ROSE_GOLDEN_APPLE);
            }).build();

    public static void register(){
        Asterola.LOGGER.info("Registering Custom Creative Mode Tab for " + Asterola.MOD_ID);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ASTEROLA_TAB, ASTEROLA);
    }
}
