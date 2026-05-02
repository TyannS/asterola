package com.tyanns.asterola.tool;

import com.tyanns.asterola.Asterola;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_MULTIPLIED_BASE;

public class RoseGoldenSwordItem extends Item {
    private static final Identifier ROSE_GOLDEN_SWORD_MOVEMENT_SPEED_ID =
            Identifier.fromNamespaceAndPath(Asterola.MOD_ID, "rose_golden_sword_movement_speed");

    private static final AttributeModifier movement_speedModifier = new AttributeModifier(
            ROSE_GOLDEN_SWORD_MOVEMENT_SPEED_ID,
            0.025F,
            ADD_MULTIPLIED_BASE);

    private static final AttributeModifier attack_damageModifier = new AttributeModifier(
            BASE_ATTACK_DAMAGE_ID,
            5.0F,
            AttributeModifier.Operation.ADD_VALUE);

    private static final AttributeModifier attack_speedModifier = new AttributeModifier(
            BASE_ATTACK_SPEED_ID,
            -2.4F,
            AttributeModifier.Operation.ADD_VALUE);

    private static final ItemAttributeModifiers itemAttributeModifier = ItemAttributeModifiers.builder()
            .add(Attributes.MOVEMENT_SPEED, movement_speedModifier, EquipmentSlotGroup.MAINHAND)
            .add(Attributes.ATTACK_DAMAGE, attack_damageModifier, EquipmentSlotGroup.MAINHAND)
            .add(Attributes.ATTACK_SPEED, attack_speedModifier, EquipmentSlotGroup.MAINHAND)
            .build();

    public RoseGoldenSwordItem(Properties properties) {
        super(properties.sword(ModToolMaterials.ROSE_GOLD,3.0F,-2.4F)
                .attributes(itemAttributeModifier));
    }
}
