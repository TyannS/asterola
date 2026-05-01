package com.tyanns.asterola.datagen;

import com.tyanns.asterola.block.ModBlocks;
import com.tyanns.asterola.item.ModItems;
import com.tyanns.asterola.trim.ModTrimMaterials;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.color.item.Dye;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.client.renderer.item.properties.select.TrimMaterialProperty;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.client.data.models.ItemModelGenerators.*;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricPackOutput output) {
        super(output);
    }

    private static final List<ItemModelGenerators.TrimMaterialData> CUSTOM_TRIM_MATERIAL_MODELS = Util.make(new ArrayList<>(), list -> {
        list.addAll(ItemModelGenerators.TRIM_MATERIAL_MODELS);
        list.add(new ItemModelGenerators.TrimMaterialData(MaterialAssetGroup.create("rose_gold"), ModTrimMaterials.ROSE_GOLD));
    });

    public final void generateCustomTrimmableItem(
            ItemModelGenerators itemModelGenerators, final Item armor, final ResourceKey<EquipmentAsset> equipmentAssetId, final Identifier slotTrimPrefix, final boolean hasDyedLayer
    ) {
        Identifier modelLocation = ModelLocationUtils.getModelLocation(armor);
        Material itemTexture = TextureMapping.getItemTexture(armor);
        Material overlayTexture = TextureMapping.getItemTexture(armor, "_overlay");
        List<SelectItemModel.SwitchCase<ResourceKey<TrimMaterial>>> cases = new ArrayList<>(CUSTOM_TRIM_MATERIAL_MODELS.size());

        for (ItemModelGenerators.TrimMaterialData material : CUSTOM_TRIM_MATERIAL_MODELS) {
            Identifier trimModelLocation = modelLocation.withSuffix("_" + material.assets().base().suffix() + "_trim");
            Material trimOverlayTexture = new Material(slotTrimPrefix.withSuffix("_" + material.assets().assetId(equipmentAssetId).suffix()));
            ItemModel.Unbaked trimModel;
            if (hasDyedLayer) {
                itemModelGenerators.generateLayeredItem(trimModelLocation, itemTexture, overlayTexture, trimOverlayTexture);
                trimModel = ItemModelUtils.tintedModel(trimModelLocation, new Dye(-6265536));
            } else {
                itemModelGenerators.generateLayeredItem(trimModelLocation, itemTexture, trimOverlayTexture);
                trimModel = ItemModelUtils.plainModel(trimModelLocation);
            }

            cases.add(ItemModelUtils.when(material.materialKey(), trimModel));
        }

        ItemModel.Unbaked untrimmedModel;
        if (hasDyedLayer) {
            ModelTemplates.TWO_LAYERED_ITEM.create(modelLocation, TextureMapping.layered(itemTexture, overlayTexture), itemModelGenerators.modelOutput);
            untrimmedModel = ItemModelUtils.tintedModel(modelLocation, new Dye(-6265536));
        } else {
            ModelTemplates.FLAT_ITEM.create(modelLocation, TextureMapping.layer0(itemTexture), itemModelGenerators.modelOutput);
            untrimmedModel = ItemModelUtils.plainModel(modelLocation);
        }

        itemModelGenerators.itemModelOutput.accept(armor, ItemModelUtils.select(new TrimMaterialProperty(), untrimmedModel, cases));
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.ROSE_GOLD_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.ROSE_GOLD_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ROSE_GOLDEN_APPLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ROSE_GOLDEN_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ROSE_GOLDEN_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ROSE_GOLDEN_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ROSE_GOLDEN_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ROSE_GOLDEN_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(ModItems.ROSE_GOLDEN_SPEAR);
        itemModelGenerators.generateFlatItem(ModItems.ROSE_GOLDEN_HELMET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ROSE_GOLDEN_CHESTPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ROSE_GOLDEN_LEGGINGS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ROSE_GOLDEN_BOOTS, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MUSIC_DISC_YOU_ARE_BEAUTIFUL_VOMIT_VERSION, ModelTemplates.MUSIC_DISC);

        this.generateCustomTrimmableItem(itemModelGenerators, Items.TURTLE_HELMET, EquipmentAssets.TURTLE_SCUTE, TRIM_PREFIX_HELMET, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.LEATHER_HELMET, EquipmentAssets.LEATHER, TRIM_PREFIX_HELMET, true);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.LEATHER_CHESTPLATE, EquipmentAssets.LEATHER, TRIM_PREFIX_CHESTPLATE, true);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.LEATHER_LEGGINGS, EquipmentAssets.LEATHER, TRIM_PREFIX_LEGGINGS, true);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.LEATHER_BOOTS, EquipmentAssets.LEATHER, TRIM_PREFIX_BOOTS, true);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.COPPER_HELMET, EquipmentAssets.COPPER, TRIM_PREFIX_HELMET, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.COPPER_CHESTPLATE, EquipmentAssets.COPPER, TRIM_PREFIX_CHESTPLATE, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.COPPER_LEGGINGS, EquipmentAssets.COPPER, TRIM_PREFIX_LEGGINGS, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.COPPER_BOOTS, EquipmentAssets.COPPER, TRIM_PREFIX_BOOTS, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.CHAINMAIL_HELMET, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_HELMET, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.CHAINMAIL_CHESTPLATE, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_CHESTPLATE, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.CHAINMAIL_LEGGINGS, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_LEGGINGS, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.CHAINMAIL_BOOTS, EquipmentAssets.CHAINMAIL, TRIM_PREFIX_BOOTS, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.IRON_HELMET, EquipmentAssets.IRON, TRIM_PREFIX_HELMET, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.IRON_CHESTPLATE, EquipmentAssets.IRON, TRIM_PREFIX_CHESTPLATE, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.IRON_LEGGINGS, EquipmentAssets.IRON, TRIM_PREFIX_LEGGINGS, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.IRON_BOOTS, EquipmentAssets.IRON, TRIM_PREFIX_BOOTS, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.DIAMOND_HELMET, EquipmentAssets.DIAMOND, TRIM_PREFIX_HELMET, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.DIAMOND_CHESTPLATE, EquipmentAssets.DIAMOND, TRIM_PREFIX_CHESTPLATE, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.DIAMOND_LEGGINGS, EquipmentAssets.DIAMOND, TRIM_PREFIX_LEGGINGS, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.DIAMOND_BOOTS, EquipmentAssets.DIAMOND, TRIM_PREFIX_BOOTS, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.GOLDEN_HELMET, EquipmentAssets.GOLD, TRIM_PREFIX_HELMET, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.GOLDEN_CHESTPLATE, EquipmentAssets.GOLD, TRIM_PREFIX_CHESTPLATE, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.GOLDEN_LEGGINGS, EquipmentAssets.GOLD, TRIM_PREFIX_LEGGINGS, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.GOLDEN_BOOTS, EquipmentAssets.GOLD, TRIM_PREFIX_BOOTS, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.NETHERITE_HELMET, EquipmentAssets.NETHERITE, TRIM_PREFIX_HELMET, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.NETHERITE_CHESTPLATE, EquipmentAssets.NETHERITE, TRIM_PREFIX_CHESTPLATE, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.NETHERITE_LEGGINGS, EquipmentAssets.NETHERITE, TRIM_PREFIX_LEGGINGS, false);
        this.generateCustomTrimmableItem(itemModelGenerators, Items.NETHERITE_BOOTS, EquipmentAssets.NETHERITE, TRIM_PREFIX_BOOTS, false);
    }
}
