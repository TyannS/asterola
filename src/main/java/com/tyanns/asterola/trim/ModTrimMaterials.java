package com.tyanns.asterola.trim;

import com.tyanns.asterola.Asterola;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

public class ModTrimMaterials {
    public static final ResourceKey<TrimMaterial> ROSE_GOLD = registryKey("rose_gold");

    public static void bootstrap(final BootstrapContext<TrimMaterial> context) {
        register(context, ROSE_GOLD, Style.EMPTY.withColor(0xFFC0D9), MaterialAssetGroup.create("rose_gold"));
    }

    private static void register(
            final BootstrapContext<TrimMaterial> context, final ResourceKey<TrimMaterial> registryKey, final Style hoverTextStyle, final MaterialAssetGroup assets
    ) {
        Component description = Component.translatable(Util.makeDescriptionId("trim_material", registryKey.identifier())).withStyle(hoverTextStyle);
        context.register(registryKey, new TrimMaterial(assets, description));
    }

    private static ResourceKey<TrimMaterial> registryKey(final String id) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(Asterola.MOD_ID, id));
    }
}
