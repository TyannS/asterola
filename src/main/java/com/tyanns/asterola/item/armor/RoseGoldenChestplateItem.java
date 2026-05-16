package com.tyanns.asterola.item.armor;

import com.tyanns.asterola.Asterola;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Consumer;

import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_MULTIPLIED_BASE;
import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_VALUE;

public class RoseGoldenChestplateItem extends Item {
    private static final Identifier ROSE_GOLDEN_CHESTPLATE_MOVEMENT_SPEED_ID = Identifier.fromNamespaceAndPath(Asterola.MOD_ID, "rose_golden_chestplate_movement_speed");
    private static final Identifier BASE_CHESTPLATE_ARMOR_ID = Identifier.withDefaultNamespace("armor.chestplate");

    private static final AttributeModifier movement_speedModifier = new AttributeModifier(
            ROSE_GOLDEN_CHESTPLATE_MOVEMENT_SPEED_ID,
            0.04F,
            ADD_MULTIPLIED_BASE);

    private static final AttributeModifier armorModifier = new AttributeModifier(
            BASE_CHESTPLATE_ARMOR_ID,
            6.0F,
            ADD_VALUE);

    private static final ItemAttributeModifiers itemAttributeModifier = ItemAttributeModifiers.builder()
            .add(Attributes.ARMOR, armorModifier, EquipmentSlotGroup.CHEST)
            .add(Attributes.MOVEMENT_SPEED, movement_speedModifier, EquipmentSlotGroup.CHEST)
            .build();

    public RoseGoldenChestplateItem(final Properties properties) {
        super(properties.humanoidArmor(ModArmorMaterials.ROSE_GOLD, ArmorType.CHESTPLATE)
                .attributes(itemAttributeModifier));
    }

    @Override
    public void appendHoverText(final ItemStack itemStack, final Item.TooltipContext context, final TooltipDisplay display, final Consumer<Component> builder, final TooltipFlag tooltipFlag) {
        if (Minecraft.getInstance().hasShiftDown()) {
            builder.accept(Component.translatable("armortip.asterola.rose_gold_armortip.shift"));
        } else {
            builder.accept(Component.translatable("armortip.asterola.rose_gold_armortip"));
        }
    }
}
