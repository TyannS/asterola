package com.tyanns.asterola.datagen;

import com.tyanns.asterola.block.ModBlocks;
import com.tyanns.asterola.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModEnUsLangProvider extends FabricLanguageProvider {
    public ModEnUsLangProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.ROSE_GOLD_INGOT, "Rose Gold Ingot");
        translationBuilder.add(ModItems.ROSE_GOLDEN_SWORD,"Rose Golden Sword");
        translationBuilder.add(ModItems.ROSE_GOLDEN_SHOVEL,"Rose Golden Shovel");
        translationBuilder.add(ModItems.ROSE_GOLDEN_PICKAXE,"Rose Golden Pickaxe");
        translationBuilder.add(ModItems.ROSE_GOLDEN_AXE,"Rose Golden Axe");
        translationBuilder.add(ModItems.ROSE_GOLDEN_HOE,"Rose Golden Hoe");
        translationBuilder.add(ModItems.ROSE_GOLDEN_APPLE, "Rose Golden Apple");

        translationBuilder.add(ModBlocks.ROSE_GOLD_BLOCK, "Rose Gold Block");

        translationBuilder.add("itemgroup.asterola", "Asterola");

        translationBuilder.add("trim_material.asterola.rose_gold", "Rose Gold Material");

        translationBuilder.add("item.asterola.music_disc_you_are_beautiful_vomit_version", "Music Disc");
        translationBuilder.add("item.asterola.music_disc_you_are_beautiful_vomit_version.decs", "Tiktok@justinjmooremusic - You Are Beautiful (Vomit Version)");

        translationBuilder.add("jukebox_song.asterola.you_are_beautiful_vomit_version", "Tiktok@justinjmooremusic - You Are Beautiful (Vomit Version)");
    }
}
