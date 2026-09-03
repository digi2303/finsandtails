package blueportal.finsandstails.common.items;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import blueportal.finsandstails.registry.FTTags;

import java.util.function.Consumer;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

public class SpindlyGemCharmItem extends Item {
    public static final ArmorMaterial MATERIAL = FinsArmorMaterial.create("gem_crab_amulet", 1, new int[]{1, 2, 3, 1}, 3, SoundEvents.ARMOR_EQUIP_CHAIN, 0.0F, FTTags.REPAIRS_SPINDLY_CHARM);

    public SpindlyGemCharmItem(Properties properties) {
        super(properties.durability(2).rarity(Rarity.RARE).humanoidArmor(MATERIAL, ArmorType.CHESTPLATE));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> components, TooltipFlag flag) {
        super.appendHoverText(stack, context, display, components, flag);
        if (Minecraft.getInstance().hasShiftDown()) {
            components.accept(Component.translatable(stack.getItem().getDescriptionId() + ".desc").withStyle(ChatFormatting.DARK_AQUA));
            components.accept(Component.translatable(stack.getItem().getDescriptionId() + ".desc.2").withStyle(ChatFormatting.DARK_AQUA));
            components.accept(Component.translatable(stack.getItem().getDescriptionId() + ".desc.3").withStyle(ChatFormatting.DARK_AQUA));
        } else {
            components.accept(Component.translatable("finsandtails.info").withStyle(ChatFormatting.DARK_GRAY));
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel world, Entity entity, EquipmentSlot slot) {
        super.inventoryTick(stack, world, entity, slot);
        if (slot != EquipmentSlot.CHEST || !(entity instanceof Player player)) {
            return;
        }

        if (player.isAlive() && isUsable(stack) && player.getHealth() <= 8.0F) {
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0, false, false, true));
            player.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 600, 0, false, false, true));
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 1200, 0, false, false, true));
            player.addEffect(new MobEffectInstance(MobEffects.SPEED, 1200, 0, false, false, true));
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 0, false, false, true));
            stack.hurtAndBreak(1, player, EquipmentSlot.CHEST);
        }
    }

    public static boolean isUsable(ItemStack stack) {
        return !stack.isDamaged();
    }

}