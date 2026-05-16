package com.tyanns.asterola.item.armor;

import com.tyanns.asterola.Asterola;
import com.tyanns.asterola.tag.ModItemTags;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorType;
import org.jspecify.annotations.Nullable;

import java.util.function.Consumer;

import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_MULTIPLIED_BASE;
import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_VALUE;

public class RoseGoldenHelmetItem extends Item {
    private static final Identifier ROSE_GOLDEN_HELMET_MOVEMENT_SPEED_ID = Identifier.fromNamespaceAndPath(Asterola.MOD_ID, "rose_golden_helmet_movement_speed");
    private static final Identifier BASE_HELMET_ARMOR_ID = Identifier.withDefaultNamespace("armor.helmet");

    private static final AttributeModifier movement_speedModifier = new AttributeModifier(
            ROSE_GOLDEN_HELMET_MOVEMENT_SPEED_ID,
            0.04F,
            ADD_MULTIPLIED_BASE);

    private static final AttributeModifier armorModifier = new AttributeModifier(
            BASE_HELMET_ARMOR_ID,
            2.0F,
            ADD_VALUE);

    private static final ItemAttributeModifiers itemAttributeModifier = ItemAttributeModifiers.builder()
            .add(Attributes.ARMOR, armorModifier, EquipmentSlotGroup.HEAD)
            .add(Attributes.MOVEMENT_SPEED, movement_speedModifier, EquipmentSlotGroup.HEAD)
            .build();

    public boolean hasFullArmor(Player player) {
        return player.getItemBySlot(EquipmentSlot.HEAD).is(ModItemTags.ROSE_GOLD_ARMOR)
                && player.getItemBySlot(EquipmentSlot.CHEST).is(ModItemTags.ROSE_GOLD_ARMOR)
                && player.getItemBySlot(EquipmentSlot.LEGS).is(ModItemTags.ROSE_GOLD_ARMOR)
                && player.getItemBySlot(EquipmentSlot.FEET).is(ModItemTags.ROSE_GOLD_ARMOR);
    }

    public RoseGoldenHelmetItem(Properties properties) {
        super(properties.humanoidArmor(ModArmorMaterials.ROSE_GOLD, ArmorType.HELMET)
                .attributes(itemAttributeModifier));
    }

    @Override
    public void inventoryTick(final ItemStack itemStack, final ServerLevel level, final Entity owner, @Nullable final EquipmentSlot slot) {
        if (!(owner instanceof Player player)) return;
        if (hasFullArmor(player))
            player.addEffect(new MobEffectInstance(MobEffects.SPEED, 1, 1));
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
