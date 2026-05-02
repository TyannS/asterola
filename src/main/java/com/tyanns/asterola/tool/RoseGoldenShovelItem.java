package com.tyanns.asterola.tool;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.tyanns.asterola.Asterola;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Map;

import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_MULTIPLIED_BASE;

public class RoseGoldenShovelItem extends Item {
    private static final Identifier ROSE_GOLDEN_SHOVEL_MOVEMENT_SPEED_ID =
            Identifier.fromNamespaceAndPath(Asterola.MOD_ID, "rose_golden_shovel_movement_speed");

    private static final AttributeModifier movement_speedModifier = new AttributeModifier(
            ROSE_GOLDEN_SHOVEL_MOVEMENT_SPEED_ID,
            0.025F,
            ADD_MULTIPLIED_BASE);

    private static final AttributeModifier attack_damageModifier = new AttributeModifier(
            BASE_ATTACK_DAMAGE_ID,
            3.5F,
            AttributeModifier.Operation.ADD_VALUE);

    private static final AttributeModifier attack_speedModifier = new AttributeModifier(
            BASE_ATTACK_SPEED_ID,
            -3.0F,
            AttributeModifier.Operation.ADD_VALUE);

    private static final ItemAttributeModifiers itemAttributeModifier = ItemAttributeModifiers.builder()
            .add(Attributes.MOVEMENT_SPEED, movement_speedModifier, EquipmentSlotGroup.MAINHAND)
            .add(Attributes.ATTACK_DAMAGE, attack_damageModifier, EquipmentSlotGroup.MAINHAND)
            .add(Attributes.ATTACK_SPEED, attack_speedModifier, EquipmentSlotGroup.MAINHAND)
            .build();

    public RoseGoldenShovelItem(Properties properties) {
        super(properties.shovel(ModToolMaterials.ROSE_GOLD, 1.5F, -3.0F)
                .attributes(itemAttributeModifier));
    }

    protected static final Map<Block, BlockState> FLATTENABLES = Maps.<Block, BlockState>newHashMap(
            new ImmutableMap.Builder()
                    .put(Blocks.GRASS_BLOCK, Blocks.DIRT_PATH.defaultBlockState())
                    .put(Blocks.DIRT, Blocks.DIRT_PATH.defaultBlockState())
                    .put(Blocks.PODZOL, Blocks.DIRT_PATH.defaultBlockState())
                    .put(Blocks.COARSE_DIRT, Blocks.DIRT_PATH.defaultBlockState())
                    .put(Blocks.MYCELIUM, Blocks.DIRT_PATH.defaultBlockState())
                    .put(Blocks.ROOTED_DIRT, Blocks.DIRT_PATH.defaultBlockState())
                    .build()
    );

    @Override
    public InteractionResult useOn(final UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState blockState = level.getBlockState(pos);
        if (context.getClickedFace() == Direction.DOWN) {
            return InteractionResult.PASS;
        } else {
            Player player = context.getPlayer();
            BlockState newState = (BlockState) FLATTENABLES.get(blockState.getBlock());
            BlockState updatedState = null;
            if (newState != null && level.getBlockState(pos.above()).isAir()) {
                level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                updatedState = newState;
            } else if (blockState.getBlock() instanceof CampfireBlock && (Boolean) blockState.getValue(CampfireBlock.LIT)) {
                if (!level.isClientSide()) {
                    level.levelEvent(null, 1009, pos, 0);
                }

                CampfireBlock.dowse(context.getPlayer(), level, pos, blockState);
                updatedState = blockState.setValue(CampfireBlock.LIT, false);
            }

            if (updatedState != null) {
                if (!level.isClientSide()) {
                    level.setBlock(pos, updatedState, 11);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, updatedState));
                    if (player != null) {
                        context.getItemInHand().hurtAndBreak(1, player, context.getHand().asEquipmentSlot());
                    }
                }

                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.PASS;
            }
        }
    }
}
