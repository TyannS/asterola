package com.tyanns.asterola;

import com.tyanns.asterola.datagen.*;
import com.tyanns.asterola.trim.ModTrimMaterials;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class AsterolaDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockLootTablesProvider::new);
		pack.addProvider(ModBlockTagsProvider::new);
		pack.addProvider(ModEnUsLangProvider::new);
		pack.addProvider(ModItemTagsProvider::new);
		pack.addProvider(ModModelsProvider::new);
		pack.addProvider(ModRecipesProvider::new);
		pack.addProvider(ModRegistryDataProvider::new);
		pack.addProvider(ModZhCnLangProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap);
	}
}
