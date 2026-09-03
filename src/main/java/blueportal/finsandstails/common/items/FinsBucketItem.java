package blueportal.finsandstails.common.items;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.core.component.DataComponents;
import net.minecraft.ChatFormatting;
//? if >=26.2 {
/*import net.minecraft.advancements.triggers.CriteriaTriggers;
*///?} else {
import net.minecraft.advancements.CriteriaTriggers;
//?}
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import java.util.function.Consumer;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;

public class FinsBucketItem extends MobBucketItem {
    private final EntityType<? extends Mob> entityType;
    private final boolean hasTooltip;

    public FinsBucketItem(EntityType<? extends Mob> entityType, Fluid fluid, Properties builder) {
        this(entityType, fluid, builder, false);
    }

    public FinsBucketItem(EntityType<? extends Mob> entityType, Fluid fluid, Properties builder, boolean hasTooltip) {
        super(entityType, fluid, SoundEvents.BUCKET_EMPTY_FISH, builder);
        this.hasTooltip = hasTooltip;
        this.entityType = entityType;
    }

    @Override
    public InteractionResult use(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (this.getContent() == Fluids.EMPTY) {
            //for penglil
            ItemStack itemstack = playerIn.getItemInHand(handIn);
            BlockHitResult result = getPlayerPOVHitResult(worldIn, playerIn, ClipContext.Fluid.NONE);
            if (result.getType() == BlockHitResult.Type.MISS) {
                return InteractionResult.PASS;
            } else if (result.getType() != BlockHitResult.Type.BLOCK) {
                return InteractionResult.PASS;
            }
            BlockPos blockpos = result.getBlockPos();
            Direction direction = result.getDirection();
            BlockPos blockpos1 = blockpos.relative(direction);
            this.checkExtraContent(playerIn, worldIn, itemstack, blockpos1);
            if (playerIn instanceof ServerPlayer) {
                CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)playerIn, blockpos1, itemstack);
            }
            playerIn.awardStat(Stats.ITEM_USED.get(this));
            return InteractionResult.SUCCESS;
        }
        return super.use(worldIn, playerIn, handIn);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, context, display, tooltip, flag);
        if (hasTooltip && stack.has(DataComponents.CUSTOM_DATA)) {
            tooltip.accept(Component.translatable(this.entityType.getDescriptionId() + "." + stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getIntOr("Variant", 0)).withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }
    }
}
