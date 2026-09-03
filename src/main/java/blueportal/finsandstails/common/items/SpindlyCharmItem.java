package blueportal.finsandstails.common.items;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import blueportal.finsandstails.FinsAndTails;

import java.util.List;
import java.util.function.Consumer;

public class SpindlyCharmItem extends ArmorItem {
    private final String materialName;
    private final MobEffect effect;

    public SpindlyCharmItem(String materialName, MobEffect effect) {
        super(
                new FinsArmorMaterial(FinsAndTails.MOD_ID + ":spindly_" + materialName + "_charm", 1, new int[]{1, 2, 3, 1}, 8, SoundEvents.ARMOR_EQUIP_CHAIN, 0.0F, () -> Ingredient.EMPTY),
                Type.CHESTPLATE,
                new Properties().durability(25).rarity(Rarity.UNCOMMON)
        );
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
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (player.isAlive() && player.getHealth() <= 8.0F && !player.getCooldowns().isOnCooldown(this)) {
            player.addEffect(new MobEffectInstance(effect, 100, 0, false, false, true));
            stack.hurtAndBreak(1, player, e -> e.broadcastBreakEvent(EquipmentSlot.CHEST));
            player.getCooldowns().addCooldown(this, 200);
        }
    }

    public String getTypeName() {
        return materialName;
    }
}
