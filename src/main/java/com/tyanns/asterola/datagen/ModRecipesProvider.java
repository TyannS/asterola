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
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ROSE_GOLD_BLOCK)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .define('#', ModItems.ROSE_GOLD_INGOT)
                        .unlockedBy("has_rose_gold_ingot", has(ModItems.ROSE_GOLD_INGOT))
                        .save(recipeOutput);

                shapeless(RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT, 9)
                        .requires(ModBlocks.ROSE_GOLD_BLOCK)
                        .unlockedBy("has_rose_gold_block", has(ModBlocks.ROSE_GOLD_BLOCK))
                        .save(recipeOutput, "rose_gold_ingot_from_rose_gold_block");

                shapeless(RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT, 4)
                        .requires(Items.COPPER_INGOT)
                        .requires(Items.GOLD_INGOT, 3)
                        .unlockedBy("has_item_copper_ingot", has(Items.COPPER_INGOT))
                        .unlockedBy("has_item_gold_ingot", has(Items.GOLD_INGOT))
                        .save(recipeOutput);

                shaped(RecipeCategory.TOOLS, ModItems.ROSE_GOLDEN_SWORD)
                        .pattern("X")
                        .pattern("X")
                        .pattern("#")
                        .define('#', Items.STICK)
                        .define('X', ModItems.ROSE_GOLD_INGOT)
                        .unlockedBy("has_rose_gold_ingot", has(ModItems.ROSE_GOLD_INGOT))
                        .unlockedBy("has_stick", has(Items.STICK))
                        .save(recipeOutput);

                shaped(RecipeCategory.TOOLS, ModItems.ROSE_GOLDEN_SHOVEL)
                        .pattern("X")
                        .pattern("#")
                        .pattern("#")
                        .define('#', Items.STICK)
                        .define('X', ModItems.ROSE_GOLD_INGOT)
                        .unlockedBy("has_rose_gold_ingot", has(ModItems.ROSE_GOLD_INGOT))
                        .unlockedBy("has_stick", has(Items.STICK))
                        .save(recipeOutput);

                shaped(RecipeCategory.TOOLS, ModItems.ROSE_GOLDEN_PICKAXE)
                        .pattern("XXX")
                        .pattern(" # ")
                        .pattern(" # ")
                        .define('#', Items.STICK)
                        .define('X', ModItems.ROSE_GOLD_INGOT)
                        .unlockedBy("has_rose_gold_ingot", has(ModItems.ROSE_GOLD_INGOT))
                        .unlockedBy("has_stick", has(Items.STICK))
                        .save(recipeOutput);

                shaped(RecipeCategory.TOOLS, ModItems.ROSE_GOLDEN_AXE)
                        .pattern("XX")
                        .pattern("X#")
                        .pattern(" #")
                        .define('#', Items.STICK)
                        .define('X', ModItems.ROSE_GOLD_INGOT)
                        .unlockedBy("has_rose_gold_ingot", has(ModItems.ROSE_GOLD_INGOT))
                        .unlockedBy("has_stick", has(Items.STICK))
                        .save(recipeOutput);

                shaped(RecipeCategory.TOOLS, ModItems.ROSE_GOLDEN_HOE)
                        .pattern("XX")
                        .pattern(" #")
                        .pattern(" #")
                        .define('#', Items.STICK)
                        .define('X', ModItems.ROSE_GOLD_INGOT)
                        .unlockedBy("has_rose_gold_ingot", has(ModItems.ROSE_GOLD_INGOT))
                        .unlockedBy("has_stick", has(Items.STICK))
                        .save(recipeOutput);

                shaped(RecipeCategory.TOOLS, ModItems.ROSE_GOLDEN_SPEAR)
                        .pattern("  X")
                        .pattern(" # ")
                        .pattern("#  ")
                        .define('#', Items.STICK)
                        .define('X', ModItems.ROSE_GOLD_INGOT)
                        .unlockedBy("has_rose_gold_ingot", has(ModItems.ROSE_GOLD_INGOT))
                        .unlockedBy("has_stick", has(Items.STICK))
                        .save(recipeOutput);

                shaped(RecipeCategory.FOOD, ModItems.ROSE_GOLDEN_APPLE)
                        .pattern("###")
                        .pattern("#X#")
                        .pattern("###")
                        .define('#', ModItems.ROSE_GOLD_INGOT)
                        .define('X', Items.APPLE)
                        .unlockedBy("has_rose_gold_ingot", has(ModItems.ROSE_GOLD_INGOT))
                        .unlockedBy("has_apple", has(Items.APPLE))
                        .save(recipeOutput);
            }
        };
    }

    @Override
    public String getName() {
        return "Recipes";
    }
}
