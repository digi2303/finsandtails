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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import java.util.function.Consumer;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import blueportal.finsandstails.common.entities.FlatbackLeafSnailEntity;
import blueportal.finsandstails.common.entities.RiverPebbleSnailEntity;
import blueportal.finsandstails.common.entities.SiderolWhiskeredSnailEntity;

import java.util.List;

public class FinsPotItem extends BucketItem {
    private final EntityType<?> entityType;
    private final Fluid fluid;
    private final boolean hasTooltip;

    public FinsPotItem(EntityType<?> entityType, Fluid fluid, Properties builder) {
        this(entityType, fluid, builder, true);
    }

    public FinsPotItem(EntityType<?> entityType, Fluid fluid, Properties builder, boolean hasTooltip) {
        super(fluid, builder);
        this.fluid = fluid;
        this.hasTooltip = hasTooltip;
        this.entityType = entityType;
    }

    @Override
    public InteractionResult use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        BlockHitResult result = getPlayerPOVHitResult(worldIn, playerIn, ClipContext.Fluid.NONE);
        if (result.getType() == BlockHitResult.Type.MISS) {
            return InteractionResult.PASS;
        } else if (result.getType() != BlockHitResult.Type.BLOCK) {
            return InteractionResult.PASS;
        } else {
            BlockPos blockpos = result.getBlockPos();
            Direction direction = result.getDirection();
            BlockPos blockpos1 = blockpos.relative(direction);
            if (worldIn.mayInteract(playerIn, blockpos) && playerIn.mayUseItemAt(blockpos1, direction, itemstack)) {
                BlockState blockstate = worldIn.getBlockState(blockpos);
                BlockPos blockpos2 = blockstate.getBlock() instanceof LiquidBlockContainer && ((LiquidBlockContainer) blockstate.getBlock()).canPlaceLiquid(playerIn, worldIn, blockpos, blockstate, fluid) ? blockpos : blockpos1;
                this.emptyContents(playerIn, worldIn, blockpos2, result);
                if (worldIn instanceof ServerLevel) this.placeEntity((ServerLevel)worldIn, itemstack, blockpos2);
                if (playerIn instanceof ServerPlayer) {
                    CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) playerIn, blockpos2, itemstack);
                }

                playerIn.awardStat(Stats.ITEM_USED.get(this));
                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.FAIL;
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, context, display, tooltip, flag);
        if (hasTooltip && stack.has(DataComponents.CUSTOM_DATA)) {
            tooltip.accept(Component.translatable(this.entityType.getDescriptionId() + "." + stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getIntOr("Variant", 0)).withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        }
    }

    private void placeEntity(ServerLevel worldIn, ItemStack stack, BlockPos pos) {
        this.entityType.spawn(worldIn, stack, null, pos, EntitySpawnReason.BUCKET, true, false);
    }

    private ItemStack getEmptyItem(ItemStack stack, Player player) {
        return !player.isCreative() ? new ItemStack(Items.FLOWER_POT) : stack;
    }
}
