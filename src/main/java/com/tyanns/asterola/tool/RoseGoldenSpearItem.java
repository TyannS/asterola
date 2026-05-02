package com.tyanns.asterola.tool;

import com.tyanns.asterola.Asterola;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_MULTIPLIED_BASE;

public class RoseGoldenSpearItem extends Item {
    private static final Identifier ROSE_GOLDEN_SPEAR_MOVEMENT_SPEED_ID =
            Identifier.fromNamespaceAndPath(Asterola.MOD_ID, "rose_golden_spear_movement_speed");

    private static final AttributeModifier movement_speedModifier = new AttributeModifier(
            ROSE_GOLDEN_SPEAR_MOVEMENT_SPEED_ID,
            0.025F,
            ADD_MULTIPLIED_BASE);

    private static final AttributeModifier attack_damageModifier = new AttributeModifier(
            BASE_ATTACK_DAMAGE_ID,
            2.0F,
            AttributeModifier.Operation.ADD_VALUE);

    private static final AttributeModifier attack_speedModifier = new AttributeModifier(
            BASE_ATTACK_SPEED_ID,
            -2.82F,
            AttributeModifier.Operation.ADD_VALUE);

    private static final ItemAttributeModifiers itemAttributeModifier = ItemAttributeModifiers.builder()
            .add(Attributes.MOVEMENT_SPEED, movement_speedModifier, EquipmentSlotGroup.MAINHAND)
            .add(Attributes.ATTACK_DAMAGE, attack_damageModifier, EquipmentSlotGroup.MAINHAND)
            .add(Attributes.ATTACK_SPEED, attack_speedModifier, EquipmentSlotGroup.MAINHAND)
            .build();

    public RoseGoldenSpearItem(Properties properties) {
        super(properties.spear(ModToolMaterials.ROSE_GOLD,
                        0.85F,
                        0.95F,
                        0.6F,
                        4.0F,
                        11.0F,
                        8.5F,
                        5.1F,
                        13.75F,
                        4.6F)
                .attributes(itemAttributeModifier));
    }
}
