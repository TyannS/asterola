package com.tyanns.asterola.datagen;

import com.tyanns.asterola.block.ModBlocks;
import com.tyanns.asterola.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends FabricRecipeProvider {
    public ModRecipesProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROSE_GOLD_BLOCK);

                shapeless(RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT)
                        .requires(Items.COPPER_INGOT)
                        .requires(Items.GOLD_INGOT, 3)
                        .unlockedBy("has_item_copper_ingot", has(Items.COPPER_INGOT))
                        .unlockedBy("has_item_gold_ingot", has(Items.GOLD_INGOT))
                        .save(recipeOutput);
            }
        };
    }

    @Override
    public String getName() {
        return "recipe generator";
    }
}
