package blueportal.finsandstails.common.items;

import blueportal.finsandstails.common.entities.MudhorseEntity;
import blueportal.finsandstails.registry.FTEntities;
import blueportal.finsandstails.registry.FTSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class SwampDidgeridooItem extends Item {
    public SwampDidgeridooItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        List<MudhorseEntity> mudhorses = world.getEntities(FTEntities.MUDHORSE, player.getBoundingBox().inflate(8), entity -> entity.getCommander() == null);
        if (mudhorses.isEmpty()) {
            player.playSound(SoundEvents.VILLAGER_NO, 0.4f, 1);
            addParticleEffect(ParticleTypes.SMOKE, world, player.getX() - 0.5, player.getY() + 1, player.getZ() - 0.5);
            return InteractionResult.PASS;
        }

        for (MudhorseEntity mudhorseEntity : mudhorses) {
            mudhorseEntity.setCommander(player);
            addParticleEffect(ParticleTypes.HAPPY_VILLAGER, world, mudhorseEntity.getX() - 0.5, mudhorseEntity.getY() + 1.4, mudhorseEntity.getZ() - 0.5);
        }
        player.playSound(FTSounds.DIDGERIDOO_PLAY, 0.4f, 1);
        player.getCooldowns().addCooldown(stack, 600);
        stack.hurtAndBreak(1, player, hand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> components, TooltipFlag flag) {
        super.appendHoverText(stack, context, display, components, flag);
        if (Minecraft.getInstance().hasShiftDown()) {
            components.accept(Component.translatable(stack.getItem().getDescriptionId() + ".desc").withStyle(ChatFormatting.DARK_AQUA));
            components.accept(Component.translatable(stack.getItem().getDescriptionId() + ".desc.2").withStyle(ChatFormatting.DARK_AQUA));
        } else {
            components.accept(Component.translatable("finsandtails.info").withStyle(ChatFormatting.DARK_GRAY));
        }
    }

    private void addParticleEffect(SimpleParticleType particleData, Level world, double x, double y, double z) {
        Random random = new Random();
        for(int i = 0; i < 10; ++i) {
            double d2 = random.nextGaussian() * 0.02D;
            double d3 = random.nextGaussian() * 0.02D;
            double d4 = random.nextGaussian() * 0.02D;
            double d6 = x + random.nextDouble();
            double d7 = y + random.nextDouble() * 0.5;
            double d8 = z + random.nextDouble();
            world.addParticle(particleData, d6, d7, d8, d2, d3, d4);
        }
    }
}
