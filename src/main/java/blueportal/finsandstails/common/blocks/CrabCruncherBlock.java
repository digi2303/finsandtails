package blueportal.finsandstails.common.blocks;

import blueportal.finsandstails.registry.FTBlocks;
import blueportal.finsandstails.registry.FTItems;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Map;

public class CrabCruncherBlock extends Block {

    public CrabCruncherBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, net.minecraft.world.InteractionHand handIn, BlockHitResult hit) {
        Map<Item, Item> crabToGem = ImmutableMap.of(
                FTItems.AMBER_SPINDLY_GEM_CRAB, FTItems.SPINDLY_AMBER,
                FTItems.PEARL_SPINDLY_GEM_CRAB, FTItems.SPINDLY_PEARL,
                FTItems.SAPPHIRE_SPINDLY_GEM_CRAB, FTItems.SPINDLY_SAPPHIRE,
                FTItems.RUBY_SPINDLY_GEM_CRAB, FTItems.SPINDLY_RUBY,
                FTItems.EMERALD_SPINDLY_GEM_CRAB, FTItems.SPINDLY_EMERALD
        );

        if (crabToGem.containsKey(stack.getItem())) {
            ItemStack outputStack = new ItemStack(crabToGem.get(stack.getItem()), level.random.nextIntBetweenInclusive(3, 5));

            popResourceFromFace(level, pos, hit.getDirection(), outputStack);

            ExperienceOrb exp = new ExperienceOrb(level, pos.getX() + 0.5D, pos.getY() + 1.0D, pos.getZ() + 0.5D, level.random.nextIntBetweenInclusive(2, 4));

            level.addFreshEntity(exp);

            level.playLocalSound(pos, SoundEvents.SNIFFER_EGG_CRACK, SoundSource.BLOCKS, 1.0F, 1.0F, true);

            if (level instanceof ServerLevel server) {
                double d0 = 0.5D;
                double d1 = FTBlocks.CRAB_CRUNCHER.defaultBlockState().getShape(level, pos).max(Direction.Axis.Y);

                double d2 = 0.0D;
                double d3 = 0.0D;
                double d4 = 0.0D;
                double d6 = (double) pos.getX() + level.random.nextDouble() * d0 * 2.0D;
                double d7 = (double) pos.getY() + level.random.nextDouble() * d1;
                double d8 = (double) pos.getZ() + level.random.nextDouble() * d0 * 2.0D;
                server.sendParticles(new ItemParticleOption(ParticleTypes.ITEM, stack), d6, d7, d8, 100, d2, d3, d4, 0.1D);
            }

            stack.shrink(1);

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}
