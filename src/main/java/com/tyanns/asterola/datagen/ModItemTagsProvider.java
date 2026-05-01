package com.tyanns.asterola.datagen;

import com.tyanns.asterola.item.ModItems;
import com.tyanns.asterola.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {

    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.ROSE_GOLD_INGOT);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.ROSE_GOLDEN_SWORD);

        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.ROSE_GOLDEN_SHOVEL);

        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.ROSE_GOLDEN_PICKAXE);

        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.ROSE_GOLDEN_AXE);

        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.ROSE_GOLDEN_HOE);

        valueLookupBuilder(ItemTags.SPEARS)
                .add(ModItems.ROSE_GOLDEN_SPEAR);

        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.ROSE_GOLDEN_HELMET);

        valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.ROSE_GOLDEN_CHESTPLATE);

        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.ROSE_GOLDEN_LEGGINGS);

        valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.ROSE_GOLDEN_BOOTS);

        valueLookupBuilder(ModItemTags.ROSE_GOLD_TOOL_MATERIALS)
                .add(ModItems.ROSE_GOLD_INGOT);

        valueLookupBuilder(ModItemTags.REPAIRS_ROSE_GOLD_ARMOR)
                .add(ModItems.ROSE_GOLD_INGOT);
    }
}
