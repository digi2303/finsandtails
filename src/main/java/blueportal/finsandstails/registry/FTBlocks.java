package blueportal.finsandstails.registry;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.common.blocks.ChainedTentacleBlock;
import blueportal.finsandstails.common.blocks.CrabCruncherBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class FTBlocks {
    public static Block SPINDLY_AMBER_BLOCK;
    public static Block SPINDLY_EMERALD_BLOCK;
    public static Block SPINDLY_PEARL_BLOCK;
    public static Block SPINDLY_RUBY_BLOCK;
    public static Block SPINDLY_SAPPHIRE_BLOCK;
    public static Block SPINDLY_GEM_BLOCK;

    public static Block CRAB_CRUNCHER;

    public static Block CHAINED_TENTACLE;

    public static Block FLATBACK_SHELL_BRICKS;
    public static Block FLATBACK_SHELL_BRICK_STAIRS;
    public static Block FLATBACK_SHELL_BRICK_SLAB;
    public static Block CHISELED_FLATBACK_SHELL_BRICKS;
    public static Block FLATBACK_SHELL_BLOCK;
    public static Block FLATBACK_SHELL_STAIRS;
    public static Block FLATBACK_SHELL_SLAB;

    public static Block PEBBLE_SHELL_BRICKS;
    public static Block PEBBLE_SHELL_BRICK_STAIRS;
    public static Block PEBBLE_SHELL_BRICK_SLAB;
    public static Block CHISELED_PEBBLE_SHELL_BRICKS;
    public static Block PEBBLE_SHELL_PILLAR;

    public static Block SIDEROL_SHELL_BRICKS;
    public static Block SIDEROL_SHELL_BRICK_STAIRS;
    public static Block SIDEROL_SHELL_BRICK_SLAB;
    public static Block CHISELED_SIDEROL_SHELL_BRICKS;
    public static Block MIXED_FLATBACK_SHELL_BRICKS;
    public static Block MIXED_FLATBACK_SHELL_BRICK_STAIRS;
    public static Block MIXED_FLATBACK_SHELL_BRICK_SLAB;
    public static Block MIXED_PEBBLE_SHELL_BRICKS;
    public static Block MIXED_PEBBLE_SHELL_BRICK_STAIRS;
    public static Block MIXED_PEBBLE_SHELL_BRICK_SLAB;

    public static void register() {
        SPINDLY_AMBER_BLOCK = register("spindly_amber_block", Block::new, gemProperties());
        SPINDLY_EMERALD_BLOCK = register("spindly_emerald_block", Block::new, gemProperties());
        SPINDLY_PEARL_BLOCK = register("spindly_pearl_block", Block::new, gemProperties());
        SPINDLY_RUBY_BLOCK = register("spindly_ruby_block", Block::new, gemProperties());
        SPINDLY_SAPPHIRE_BLOCK = register("spindly_sapphire_block", Block::new, gemProperties());
        SPINDLY_GEM_BLOCK = register("spindly_gem_block", Block::new, gemProperties());

        CRAB_CRUNCHER = register("crab_cruncher", CrabCruncherBlock::new, BlockBehaviour.Properties.of().strength(5.0f).sound(SoundType.STONE));

        CHAINED_TENTACLE = register("chained_tentacle", ChainedTentacleBlock::new, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.CHAIN).noOcclusion());

        FLATBACK_SHELL_BRICKS = register("flatback_shell_bricks", Block::new, shellProperties());
        FLATBACK_SHELL_BRICK_STAIRS = registerStairs("flatback_shell_brick_stairs", FLATBACK_SHELL_BRICKS);
        FLATBACK_SHELL_BRICK_SLAB = register("flatback_shell_brick_slab", SlabBlock::new, shellProperties());
        CHISELED_FLATBACK_SHELL_BRICKS = register("chiseled_flatback_shell_bricks", Block::new, shellProperties());
        FLATBACK_SHELL_BLOCK = register("flatback_shell_block", Block::new, shellProperties());
        FLATBACK_SHELL_STAIRS = registerStairs("flatback_shell_stairs", FLATBACK_SHELL_BLOCK);
        FLATBACK_SHELL_SLAB = register("flatback_shell_slab", SlabBlock::new, shellProperties());

        PEBBLE_SHELL_BRICKS = register("pebble_shell_bricks", Block::new, shellProperties());
        PEBBLE_SHELL_BRICK_STAIRS = registerStairs("pebble_shell_brick_stairs", PEBBLE_SHELL_BRICKS);
        PEBBLE_SHELL_BRICK_SLAB = register("pebble_shell_brick_slab", SlabBlock::new, shellProperties());
        CHISELED_PEBBLE_SHELL_BRICKS = register("chiseled_pebble_shell_bricks", Block::new, shellProperties());
        PEBBLE_SHELL_PILLAR = register("pebble_shell_pillar", RotatedPillarBlock::new, shellProperties());

        SIDEROL_SHELL_BRICKS = register("siderol_shell_bricks", Block::new, shellProperties());
        SIDEROL_SHELL_BRICK_STAIRS = registerStairs("siderol_shell_brick_stairs", SIDEROL_SHELL_BRICKS);
        SIDEROL_SHELL_BRICK_SLAB = register("siderol_shell_brick_slab", SlabBlock::new, shellProperties());
        CHISELED_SIDEROL_SHELL_BRICKS = register("chiseled_siderol_shell_bricks", Block::new, shellProperties());
        MIXED_FLATBACK_SHELL_BRICKS = register("mixed_flatback_shell_bricks", Block::new, shellProperties());
        MIXED_FLATBACK_SHELL_BRICK_STAIRS = registerStairs("mixed_flatback_shell_brick_stairs", MIXED_FLATBACK_SHELL_BRICKS);
        MIXED_FLATBACK_SHELL_BRICK_SLAB = register("mixed_flatback_shell_brick_slab", SlabBlock::new, shellProperties());
        MIXED_PEBBLE_SHELL_BRICKS = register("mixed_pebble_shell_bricks", Block::new, shellProperties());
        MIXED_PEBBLE_SHELL_BRICK_STAIRS = registerStairs("mixed_pebble_shell_brick_stairs", MIXED_PEBBLE_SHELL_BRICKS);
        MIXED_PEBBLE_SHELL_BRICK_SLAB = register("mixed_pebble_shell_brick_slab", SlabBlock::new, shellProperties());
    }

    private static BlockBehaviour.Properties gemProperties() {
        return BlockBehaviour.Properties.of().strength(5.0F, 6.0F).sound(SoundType.METAL);
    }

    private static BlockBehaviour.Properties shellProperties() {
        return BlockBehaviour.Properties.of().strength(1.5f, 6.0F).sound(SoundType.BONE_BLOCK);
    }

    private static Block registerStairs(String name, Block base) {
        return register(name, properties -> new StairBlock(base.defaultBlockState(), properties), shellProperties());
    }

    private static <T extends Block> T register(String name, Function<BlockBehaviour.Properties, T> factory, BlockBehaviour.Properties properties) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, FinsAndTails.id(name));
        return Registry.register(BuiltInRegistries.BLOCK, key, factory.apply(properties.setId(key)));
    }
}
