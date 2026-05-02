package com.tyanns.asterola.tool;

import com.tyanns.asterola.Asterola;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_MULTIPLIED_BASE;

public class RoseGoldenPickaxeItem extends Item {
    private static final Identifier ROSE_GOLDEN_PICKAXE_MOVEMENT_SPEED_ID = Identifier.fromNamespaceAndPath(Asterola.MOD_ID, "rose_golden_pickaxe_movement_speed");

    private static final AttributeModifier movement_speedModifier = new AttributeModifier(
            ROSE_GOLDEN_PICKAXE_MOVEMENT_SPEED_ID,
            0.025F,
            ADD_MULTIPLIED_BASE);

    private static final AttributeModifier attack_damageModifier = new AttributeModifier(
            BASE_ATTACK_DAMAGE_ID,
            3.0F,
            AttributeModifier.Operation.ADD_VALUE);

    private static final AttributeModifier attack_speedModifier = new AttributeModifier(
            BASE_ATTACK_SPEED_ID,
            -2.8F,
            AttributeModifier.Operation.ADD_VALUE);

    private static final ItemAttributeModifiers itemAttributeModifier = ItemAttributeModifiers.builder()
            .add(Attributes.MOVEMENT_SPEED, movement_speedModifier, EquipmentSlotGroup.HAND)
            .add(Attributes.ATTACK_DAMAGE, attack_damageModifier, EquipmentSlotGroup.MAINHAND)
            .add(Attributes.ATTACK_SPEED, attack_speedModifier, EquipmentSlotGroup.MAINHAND)
            .build();

    public RoseGoldenPickaxeItem(Properties properties) {
        super(properties.pickaxe(ModToolMaterials.ROSE_GOLD, 1.0F, -2.8F)
                .attributes(itemAttributeModifier));
    }
}
