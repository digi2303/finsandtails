package blueportal.finsandstails.common.items;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorType;
import blueportal.finsandstails.registry.FTTags;

import java.util.function.Consumer;

public class SpindlyCharmItem extends Item {
    private final String materialName;
    private final Holder<MobEffect> effect;

    public SpindlyCharmItem(String materialName, Holder<MobEffect> effect, Properties properties) {
        super(properties
                .humanoidArmor(FinsArmorMaterial.create("spindly_" + materialName + "_charm", 1, new int[]{1, 2, 3, 1}, 8, SoundEvents.ARMOR_EQUIP_CHAIN, 0.0F, FTTags.REPAIRS_SPINDLY_CHARM), ArmorType.CHESTPLATE)
                .durability(25)
                .rarity(Rarity.UNCOMMON));
        this.materialName = materialName;
        this.effect = effect;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> components, TooltipFlag flag) {
        super.appendHoverText(stack, context, display, components, flag);
        if (Minecraft.getInstance().hasShiftDown()) {
            components.accept(Component.translatable("item.finsandtails.spindly_charm.desc").withStyle(ChatFormatting.DARK_AQUA));
            components.accept(Component.translatable("item.finsandtails.spindly_charm.desc.2").withStyle(ChatFormatting.DARK_AQUA));
        } else {
            components.accept(Component.translatable("finsandtails.info").withStyle(ChatFormatting.DARK_GRAY));
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, EquipmentSlot slot) {
        super.inventoryTick(stack, level, entity, slot);
        if (slot != EquipmentSlot.CHEST || !(entity instanceof Player player)) {
            return;
        }

        if (player.isAlive() && player.getHealth() <= 8.0F && !player.getCooldowns().isOnCooldown(stack)) {
            player.addEffect(new MobEffectInstance(effect, 100, 0, false, false, true));
            stack.hurtAndBreak(1, player, EquipmentSlot.CHEST);
            player.getCooldowns().addCooldown(stack, 200);
        }
    }

    public String getTypeName() {
        return materialName;
    }
}
