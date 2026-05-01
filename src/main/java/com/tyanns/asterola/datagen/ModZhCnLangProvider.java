package com.tyanns.asterola.datagen;

import com.tyanns.asterola.block.ModBlocks;
import com.tyanns.asterola.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModZhCnLangProvider extends FabricLanguageProvider {
    public ModZhCnLangProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, "zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.ROSE_GOLD_INGOT, "玫瑰金锭");
        translationBuilder.add(ModItems.ROSE_GOLDEN_SWORD,"玫瑰金剑");
        translationBuilder.add(ModItems.ROSE_GOLDEN_SHOVEL,"玫瑰金锹");
        translationBuilder.add(ModItems.ROSE_GOLDEN_PICKAXE,"玫瑰金镐");
        translationBuilder.add(ModItems.ROSE_GOLDEN_AXE,"玫瑰金斧");
        translationBuilder.add(ModItems.ROSE_GOLDEN_HOE,"玫瑰金锄");
        translationBuilder.add(ModItems.ROSE_GOLDEN_SPEAR,"玫瑰金矛");
        translationBuilder.add(ModItems.ROSE_GOLDEN_HELMET,"玫瑰金头盔");
        translationBuilder.add(ModItems.ROSE_GOLDEN_CHESTPLATE,"玫瑰金胸甲");
        translationBuilder.add(ModItems.ROSE_GOLDEN_LEGGINGS,"玫瑰金护腿");
        translationBuilder.add(ModItems.ROSE_GOLDEN_BOOTS,"玫瑰金靴子");
        translationBuilder.add(ModItems.ROSE_GOLDEN_APPLE, "玫瑰金苹果");

        translationBuilder.add(ModBlocks.ROSE_GOLD_BLOCK, "玫瑰金块");

        translationBuilder.add("itemgroup.asterola", "星界");

        translationBuilder.add("trim_material.asterola.rose_gold", "玫瑰金质");

        translationBuilder.add("item.asterola.music_disc_you_are_beautiful_vomit_version", "音乐唱片");
        translationBuilder.add("item.asterola.music_disc_you_are_beautiful_vomit_version.decs", "Tiktok@justinjmooremusic - You Are Beautiful（呕吐版）");

        translationBuilder.add("jukebox_song.asterola.you_are_beautiful_vomit_version", "Tiktok@justinjmooremusic - You Are Beautiful（呕吐版）");
    }
}
