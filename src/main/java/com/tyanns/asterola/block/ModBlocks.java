package com.tyanns.asterola.block;

import com.tyanns.asterola.Asterola;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

public class ModBlocks {

    public static final Block ROSE_GOLD_BLOCK = register("rose_gold_block",
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PINK)
                    .instrument(NoteBlockInstrument.BELL)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 6.0F)
                    .sound(SoundType.METAL),
            true);

    public static Block register(final String name, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties, boolean shouldRegisterItem) {
        ResourceKey<Block> id = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Asterola.MOD_ID, name));
        Block block = (Block) factory.apply(properties.setId(id));

        if (shouldRegisterItem) {
            registerBlockItem(name, block);
        }

        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static Block register(final String name, final BlockBehaviour.Properties properties, boolean shouldRegisterItem) {
        return register(name, Block::new, properties, shouldRegisterItem);
    }

    private static void registerBlockItem(String name, Block block) {
        ResourceKey<Item> id = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Asterola.MOD_ID, name));
        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(id).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, id, blockItem);
    }

    public static void register() {
        Asterola.LOGGER.info("Registering Mod Blocks for " + Asterola.MOD_ID);
    }
}
