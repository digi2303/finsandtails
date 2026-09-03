package blueportal.finsandstails.registry;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.common.items.*;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.TypedEntityData;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;

import java.util.function.Function;

public class FTItems {
    public static final java.util.List<Item> REGISTERED = new java.util.ArrayList<>();

    public static Item WEE_SPAWN_EGG;
    public static Item WEE_BUCKET;
    public static Item WEE;
    public static Item WEE_WEE_SPAWN_EGG;
    public static Item WEE_WEE_BUCKET;
    public static Item WEE_WEE;
    public static Item VIBRA_WEE_SPAWN_EGG;
    public static Item VIBRA_WEE_BUCKET;
    public static Item PAPA_WEE_SPAWN_EGG;
    public static Item PAPA_WEE_BUCKET;
    public static Item PAPA_WEE;
    public static Item COOKED_PAPA_WEE;
    public static Item WEE_DELIGHT;
    public static Item TEAL_ARROWFISH_SPAWN_EGG;
    public static Item TEAL_ARROWFISH_BUCKET;
    public static Item TEAL_ARROWFISH;
    public static Item HIGH_FINNED_BLUE_SPAWN_EGG;
    public static Item HIGH_FINNED_BLUE_BUCKET;
    public static Item HIGH_FINNED_BLUE;
    public static Item GOLDEN_RIVER_RAY_SPAWN_EGG;
    public static Item GOLDEN_RIVER_RAY_BUCKET;
    public static Item RAW_GOLDEN_RIVER_RAY_WING;
    public static Item GOLDEN_RIVER_RAY_WING_FILLET;
    public static Item SWAMP_MUCKER_SPAWN_EGG;
    public static Item SWAMP_MUCKER_BUCKET;
    public static Item SWAMP_MUCKER;
    public static Item FWIN;
    public static Item FWINGED_BOOTS;
    public static Item FLATBACK_SUCKER_SPAWN_EGG;
    public static Item FLATBACK_SUCKER_BUCKET;
    public static Item FLATBACK_SUCKER;
    public static Item MUDHORSE_SPAWN_EGG;
    public static Item MUDHORSE_SCALE;
    public static Item MUDHORSE_POUCH;
    public static Item SWAMP_DIDGERIDOO;
    public static Item CROWNED_HORATEE_SPAWN_EGG;
    public static Item BABY_HORATEE_BUCKET;
    public static Item HORATEE_HIDE;
    public static Item ARMORED_GOPJET_JETPACK;
    public static Item ORNATE_BUGFISH_SPAWN_EGG;
    public static Item ORNATE_BUGFISH_BUCKET;
    public static Item BUGFISH_MANDIBLES;
    public static Item BUGMEAT;
    public static Item COOKED_BUGMEAT;
    public static Item BANNER_PATTERN_MANDIBLES;
    public static Item GOPJET_SPAWN_EGG;
    public static Item GOPJET_BUCKET;
    public static Item GOPJET_JET;
    public static Item GOPJET_JETPACK;
    public static Item BANDED_REDBACK_SHRIMP_SPAWN_EGG;
    public static Item BANDED_REDBACK_SHRIMP_BUCKET;
    public static Item BANDED_REDBACK_SRHIMP;
    public static Item COOKED_BANDED_REDBACK_SHRIMP;
    public static Item RED_BULL_CRAB_SPAWN_EGG;
    public static Item RED_BULL_CRAB_BUCKET;
    public static Item RED_BULL_CRAB_CLAW;
    public static Item RED_CLAW_GAUNTLET;
    public static Item WHITE_BULL_CRAB_SPAWN_EGG;
    public static Item WHITE_BULL_CRAB_BUCKET;
    public static Item WHITE_BULL_CRAB_CLAW;
    public static Item WHITE_CLAW_GAUNTLET;
    public static Item COOKED_BULL_CRAB_CLAW;
    public static Item SEAFOOD_SOUP;
    public static Item SPINDLY_GEM_CRAB_SPAWN_EGG;
    public static Item SPINDLY_GEM_CRAB_BUCKET;
    public static Item AMBER_SPINDLY_GEM_CRAB;
    public static Item EMERALD_SPINDLY_GEM_CRAB;
    public static Item PEARL_SPINDLY_GEM_CRAB;
    public static Item RUBY_SPINDLY_GEM_CRAB;
    public static Item SAPPHIRE_SPINDLY_GEM_CRAB;
    public static Item SPINDLY_AMBER;
    public static Item SPINDLY_EMERALD;
    public static Item SPINDLY_PEARL;
    public static Item SPINDLY_RUBY;
    public static Item SPINDLY_SAPPHIRE;
    public static Item SPINDLY_GEM;
    public static Item EMPTY_CHARM;
    public static Item SPINDLY_AMBER_CHARM;
    public static Item SPINDLY_EMERALD_CHARM;
    public static Item SPINDLY_PEARL_CHARM;
    public static Item SPINDLY_RUBY_CHARM;
    public static Item SPINDLY_SAPPHIRE_CHARM;
    public static Item GEM_CRAB_AMULET;
    public static Item SPINDLY_AMBER_BLOCK;
    public static Item SPINDLY_EMERALD_BLOCK;
    public static Item SPINDLY_PEARL_BLOCK;
    public static Item SPINDLY_RUBY_BLOCK;
    public static Item SPINDLY_SAPPHIRE_BLOCK;
    public static Item SPINDLY_GEM_BLOCK;
    public static Item CRAB_SANDWICH;
    public static Item REEF_COCKTAIL;
    public static Item CRAB_CRUNCHER;
    public static Item PENGLIL_SPAWN_EGG;
    public static Item PENGLIL_BUCKET;
    public static Item RUBBER_BELLY_GLIDER_SPAWN_EGG;
    public static Item WHERBLE_SPAWN_EGG;
    public static Item WHERBLING;
    public static Item WHERBLE_FIN;
    public static Item COOKED_WHERBLE_FIN;
    public static Item STUFFED_WHERBLE_FIN;
    public static Item MUSIC_DISC_WARBLE;
    public static Item MUSIC_DISC_WARBLE_FRAGMENT;
    public static Item PHANTOM_NUDIBRANCH_SPAWN_EGG;
    public static Item PHANTOM_NUDIBRANCH_BUCKET;
    public static Item NIGHT_LIGHT_SQUID_SPAWN_EGG;
    public static Item NIGHT_LIGHT_SQUID_BUCKET;
    public static Item NIGHT_LIGHT_SQUID_TENTACLE;
    public static Item CHAINED_TENTACLE;
    public static Item LUMINOUS_CALAMARI;
    public static Item COOKED_LUMINOUS_CALAMARI;
    public static Item FLATBACK_LEAF_SNAIL_SPAWN_EGG;
    public static Item FLATBACK_LEAF_SNAIL_POT;
    public static Item FLATBACK_SHELL;
    public static Item FLATBACK_SHELL_BRICKS;
    public static Item FLATBACK_SHELL_BRICK_STAIRS;
    public static Item FLATBACK_SHELL_BRICK_SLAB;
    public static Item CHISELED_FLATBACK_SHELL_BRICKS;
    public static Item FLATBACK_SHELL_BLOCK;
    public static Item FLATBACK_SHELL_STAIRS;
    public static Item FLATBACK_SHELL_SLAB;
    public static Item RIVER_PEBBLE_SNAIL_SPAWN_EGG;
    public static Item RIVER_PEBBLE_SNAIL_POT;
    public static Item PEBBLE_SHELL;
    public static Item PEBBLE_SHELL_BRICKS;
    public static Item PEBBLE_SHELL_BRICK_STAIRS;
    public static Item PEBBLE_SHELL_BRICK_SLAB;
    public static Item CHISELED_PEBBLE_SHELL_BRICKS;
    public static Item PEBBLE_SHELL_PILLAR;
    public static Item SIDEROL_WHISKERED_SNAIL_SPAWN_EGG;
    public static Item SIDEROL_WHISKERED_SNAIL_POT;
    public static Item SIDEROL_SHELL;
    public static Item SIDEROL_SHELL_BRICKS;
    public static Item SIDEROL_SHELL_BRICK_STAIRS;
    public static Item SIDEROL_SHELL_BRICK_SLAB;
    public static Item CHISELED_SIDEROL_SHELL_BRICKS;
    public static Item MIXED_FLATBACK_SHELL_BRICKS;
    public static Item MIXED_FLATBACK_SHELL_BRICK_STAIRS;
    public static Item MIXED_FLATBACK_SHELL_BRICK_SLAB;
    public static Item MIXED_PEBBLE_SHELL_BRICKS;
    public static Item MIXED_PEBBLE_SHELL_BRICK_STAIRS;
    public static Item MIXED_PEBBLE_SHELL_BRICK_SLAB;
    public static Item BANNER_PATTERN_SHELL;
    public static Item MUSIC_DISC_CRASHING_TIDES;

    public static void register() {
        WEE_SPAWN_EGG = spawnEgg("wee_spawn_egg", FTEntities.WEE);
        WEE_BUCKET = register("wee_bucket", p -> new FinsBucketItem(FTEntities.WEE, Fluids.WATER, p), new Item.Properties().stacksTo(1));
        WEE = register("wee", new Item.Properties().food(food(2, 0.1F), fastEating()));

        WEE_WEE_SPAWN_EGG = spawnEgg("wee_wee_spawn_egg", FTEntities.WEE_WEE);
        WEE_WEE_BUCKET = mobBucket("wee_wee_bucket", FTEntities.WEE_WEE);
        WEE_WEE = register("wee_wee", WeeWeeItem::new, new Item.Properties().food(food(1, 0.1F), fastEating()));

        VIBRA_WEE_SPAWN_EGG = spawnEgg("vibra_wee_spawn_egg", FTEntities.VIBRA_WEE);
        VIBRA_WEE_BUCKET = register("vibra_wee_bucket", p -> new FinsBucketItem(FTEntities.VIBRA_WEE, Fluids.WATER, p), new Item.Properties().stacksTo(1));

        PAPA_WEE_SPAWN_EGG = spawnEgg("papa_wee_spawn_egg", FTEntities.PAPA_WEE);
        PAPA_WEE_BUCKET = register("papa_wee_bucket", p -> new FinsBucketItem(FTEntities.PAPA_WEE, Fluids.WATER, p), new Item.Properties().stacksTo(1));
        PAPA_WEE = register("papa_wee", new Item.Properties().food(food(3, 0.2F)));
        COOKED_PAPA_WEE = register("cooked_papa_wee", PapaWeeItem::new, new Item.Properties().food(food(7, 0.6f)));

        WEE_DELIGHT = register("wee_delight", new Item.Properties().food(food(8, 0.4f), fastEating()).stacksTo(1).usingConvertsTo(net.minecraft.world.item.Items.BOWL));

        TEAL_ARROWFISH_SPAWN_EGG = spawnEgg("teal_arrowfish_spawn_egg", FTEntities.TEAL_ARROWFISH);
        TEAL_ARROWFISH_BUCKET = mobBucket("teal_arrowfish_bucket", FTEntities.TEAL_ARROWFISH);
        TEAL_ARROWFISH = register("teal_arrowfish", TealArrowfishItem::new, new Item.Properties().food(food(2, 0.1F)));

        HIGH_FINNED_BLUE_SPAWN_EGG = spawnEgg("high_finned_blue_spawn_egg", FTEntities.HIGH_FINNED_BLUE);
        HIGH_FINNED_BLUE_BUCKET = mobBucket("high_finned_blue_bucket", FTEntities.HIGH_FINNED_BLUE);
        HIGH_FINNED_BLUE = register("high_finned_blue", AbstractDescriptionItem::new, new Item.Properties().food(food(2, 0.1F)));

        GOLDEN_RIVER_RAY_SPAWN_EGG = spawnEgg("golden_river_ray_spawn_egg", FTEntities.GOLDEN_RIVER_RAY);
        GOLDEN_RIVER_RAY_BUCKET = register("golden_river_ray_bucket", p -> new FinsBucketItem(FTEntities.GOLDEN_RIVER_RAY, Fluids.WATER, p), new Item.Properties().stacksTo(1));
        RAW_GOLDEN_RIVER_RAY_WING = register("raw_golden_river_ray_wing", new Item.Properties().food(food(3, 0.3F)));
        GOLDEN_RIVER_RAY_WING_FILLET = register("golden_river_ray_wing_fillet", new Item.Properties().food(food(8, 0.8F)));

        SWAMP_MUCKER_SPAWN_EGG = spawnEgg("swamp_mucker_spawn_egg", FTEntities.SWAMP_MUCKER);
        SWAMP_MUCKER_BUCKET = mobBucket("swamp_mucker_bucket", FTEntities.SWAMP_MUCKER);
        SWAMP_MUCKER = register("swamp_mucker", new Item.Properties().food(food(2, 0.1F)));
        FWIN = register("fwin", new Item.Properties());
        FWINGED_BOOTS = register("fwinged_boots", FwingedBootsItem::new, new Item.Properties());

        FLATBACK_SUCKER_SPAWN_EGG = spawnEgg("flatback_sucker_spawn_egg", FTEntities.FLATBACK_SUCKER);
        FLATBACK_SUCKER_BUCKET = mobBucket("flatback_sucker_bucket", FTEntities.FLATBACK_SUCKER);
        FLATBACK_SUCKER = register("flatback_sucker", new Item.Properties().food(food(2, 0.1F)));

        MUDHORSE_SPAWN_EGG = spawnEgg("mudhorse_spawn_egg", FTEntities.MUDHORSE);
        MUDHORSE_SCALE = register("mudhorse_scale", new Item.Properties());
        MUDHORSE_POUCH = register("mudhorse_pouch", MudhorsePouchItem::new, new Item.Properties());
        SWAMP_DIDGERIDOO = register("swamp_didgeridoo", SwampDidgeridooItem::new, new Item.Properties().stacksTo(1).durability(64));

        CROWNED_HORATEE_SPAWN_EGG = spawnEgg("crowned_horatee_spawn_egg", FTEntities.CROWNED_HORATEE);
        BABY_HORATEE_BUCKET = mobBucket("baby_horatee_bucket", FTEntities.CROWNED_HORATEE);
        HORATEE_HIDE = register("horatee_hide", new Item.Properties());
        ARMORED_GOPJET_JETPACK = register("armored_gopjet_jetpack", ArmoredGopjetJetpackItem::new, new Item.Properties());

        ORNATE_BUGFISH_SPAWN_EGG = spawnEgg("ornate_bugfish_spawn_egg", FTEntities.ORNATE_BUGFISH);
        ORNATE_BUGFISH_BUCKET = mobBucket("ornate_bugfish_bucket", FTEntities.ORNATE_BUGFISH);
        BUGFISH_MANDIBLES = register("bugfish_mandibles", ShearsItem::new, new Item.Properties().durability(232));
        BUGMEAT = register("bugmeat", new Item.Properties().food(food(3, 0.15F)));
        COOKED_BUGMEAT = register("cooked_bugmeat", new Item.Properties().food(food(8, 0.6F)));
        BANNER_PATTERN_MANDIBLES = bannerPattern("banner_pattern_mandibles", FTTags.PATTERN_ITEM_MANDIBLES);

        GOPJET_SPAWN_EGG = spawnEgg("gopjet_spawn_egg", FTEntities.GOPJET);
        GOPJET_BUCKET = register("gopjet_bucket", p -> new FinsBucketItem(FTEntities.GOPJET, Fluids.WATER, p), new Item.Properties().stacksTo(1));
        GOPJET_JET = register("gopjet_jet", new Item.Properties());
        GOPJET_JETPACK = register("gopjet_jetpack", GopjetpackItem::new, new Item.Properties());

        BANDED_REDBACK_SHRIMP_SPAWN_EGG = spawnEgg("banded_redback_shrimp_spawn_egg", FTEntities.BANDED_REDBACK_SHRIMP);
        BANDED_REDBACK_SHRIMP_BUCKET = mobBucket("banded_redback_shrimp_bucket", FTEntities.BANDED_REDBACK_SHRIMP);
        BANDED_REDBACK_SRHIMP = register("banded_redback_shrimp", new Item.Properties().food(food(2, 0.1F)));
        COOKED_BANDED_REDBACK_SHRIMP = register("cooked_banded_redback_shrimp", new Item.Properties().food(food(6, 0.65F)));

        RED_BULL_CRAB_SPAWN_EGG = spawnEgg("red_bull_crab_spawn_egg", FTEntities.RED_BULL_CRAB);
        RED_BULL_CRAB_BUCKET = register("red_bull_crab_bucket", p -> new FinsBucketItem(FTEntities.RED_BULL_CRAB, Fluids.WATER, p), new Item.Properties().stacksTo(1));
        RED_BULL_CRAB_CLAW = register("red_bull_crab_claw", new Item.Properties());
        RED_CLAW_GAUNTLET = register("red_claw_gauntlet", p -> new CrabGauntletItem(ToolMaterial.STONE, 3, -1.4F, p), new Item.Properties().durability(130));

        WHITE_BULL_CRAB_SPAWN_EGG = spawnEgg("white_bull_crab_spawn_egg", FTEntities.WHITE_BULL_CRAB);
        WHITE_BULL_CRAB_BUCKET = register("white_bull_crab_bucket", p -> new FinsBucketItem(FTEntities.WHITE_BULL_CRAB, Fluids.WATER, p), new Item.Properties().stacksTo(1));
        WHITE_BULL_CRAB_CLAW = register("white_bull_crab_claw", new Item.Properties());
        WHITE_CLAW_GAUNTLET = register("white_claw_gauntlet", p -> new CrabGauntletItem(ToolMaterial.STONE, 2, -0.6F, p), new Item.Properties().durability(200));

        COOKED_BULL_CRAB_CLAW = register("cooked_bull_crab_claw", new Item.Properties().food(food(6, 0.6f)));
        SEAFOOD_SOUP = register("seafood_soup", new Item.Properties().food(food(18, 0.8f)).stacksTo(1).usingConvertsTo(net.minecraft.world.item.Items.BOWL));

        SPINDLY_GEM_CRAB_SPAWN_EGG = spawnEgg("spindly_gem_crab_spawn_egg", FTEntities.SPINDLY_GEM_CRAB);
        SPINDLY_GEM_CRAB_BUCKET = register("spindly_gem_crab_bucket", p -> new FinsBucketItem(FTEntities.SPINDLY_GEM_CRAB, Fluids.WATER, p), new Item.Properties().stacksTo(1));

        AMBER_SPINDLY_GEM_CRAB = register("amber_spindly_gem_crab", new Item.Properties());
        EMERALD_SPINDLY_GEM_CRAB = register("emerald_spindly_gem_crab", new Item.Properties());
        PEARL_SPINDLY_GEM_CRAB = register("pearl_spindly_gem_crab", new Item.Properties());
        RUBY_SPINDLY_GEM_CRAB = register("ruby_spindly_gem_crab", new Item.Properties());
        SAPPHIRE_SPINDLY_GEM_CRAB = register("sapphire_spindly_gem_crab", new Item.Properties());

        SPINDLY_AMBER = register("spindly_amber", new Item.Properties());
        SPINDLY_EMERALD = register("spindly_emerald", new Item.Properties());
        SPINDLY_PEARL = register("spindly_pearl", new Item.Properties());
        SPINDLY_RUBY = register("spindly_ruby", new Item.Properties());
        SPINDLY_SAPPHIRE = register("spindly_sapphire", new Item.Properties());
        SPINDLY_GEM = register("spindly_gem", new Item.Properties());

        EMPTY_CHARM = register("empty_charm", new Item.Properties());
        SPINDLY_AMBER_CHARM = register("spindly_amber_charm", p -> new SpindlyCharmItem("amber", MobEffects.SPEED, p), new Item.Properties());
        SPINDLY_EMERALD_CHARM = register("spindly_emerald_charm", p -> new SpindlyCharmItem("emerald", MobEffects.STRENGTH, p), new Item.Properties());
        SPINDLY_PEARL_CHARM = register("spindly_pearl_charm", p -> new SpindlyCharmItem("pearl", MobEffects.REGENERATION, p), new Item.Properties());
        SPINDLY_RUBY_CHARM = register("spindly_ruby_charm", p -> new SpindlyCharmItem("ruby", MobEffects.FIRE_RESISTANCE, p), new Item.Properties());
        SPINDLY_SAPPHIRE_CHARM = register("spindly_sapphire_charm", p -> new SpindlyCharmItem("sapphire", MobEffects.WATER_BREATHING, p), new Item.Properties());
        GEM_CRAB_AMULET = register("gem_crab_amulet", SpindlyGemCharmItem::new, new Item.Properties());

        SPINDLY_AMBER_BLOCK = blockItem("spindly_amber_block", FTBlocks.SPINDLY_AMBER_BLOCK);
        SPINDLY_EMERALD_BLOCK = blockItem("spindly_emerald_block", FTBlocks.SPINDLY_EMERALD_BLOCK);
        SPINDLY_PEARL_BLOCK = blockItem("spindly_pearl_block", FTBlocks.SPINDLY_PEARL_BLOCK);
        SPINDLY_RUBY_BLOCK = blockItem("spindly_ruby_block", FTBlocks.SPINDLY_RUBY_BLOCK);
        SPINDLY_SAPPHIRE_BLOCK = blockItem("spindly_sapphire_block", FTBlocks.SPINDLY_SAPPHIRE_BLOCK);
        SPINDLY_GEM_BLOCK = blockItem("spindly_gem_block", FTBlocks.SPINDLY_GEM_BLOCK);

        CRAB_SANDWICH = register("crab_sandwich", new Item.Properties().food(food(17, 0.55f), effectFood(new MobEffectInstance(MobEffects.STRENGTH, 160), 1.0F)));
        REEF_COCKTAIL = register("reef_cocktail", new Item.Properties().food(food(6, 0.5f), Consumable.builder()
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.RESISTANCE, 100), 1.0F))
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200), 0.75F))
                .build()).stacksTo(1).usingConvertsTo(net.minecraft.world.item.Items.BOWL));
        CRAB_CRUNCHER = blockItem("crab_cruncher", FTBlocks.CRAB_CRUNCHER);

        PENGLIL_SPAWN_EGG = spawnEgg("penglil_spawn_egg", FTEntities.PENGLIL);
        PENGLIL_BUCKET = register("penglil_bucket", p -> new FinsBucketItem(FTEntities.PENGLIL, Fluids.EMPTY, p), new Item.Properties().stacksTo(1));

        RUBBER_BELLY_GLIDER_SPAWN_EGG = spawnEgg("rubber_belly_glider_spawn_egg", FTEntities.RUBBER_BELLY_GLIDER);

        WHERBLE_SPAWN_EGG = spawnEgg("wherble_spawn_egg", FTEntities.WHERBLE);
        WHERBLING = register("wherbling", WherblingItem::new, new Item.Properties().stacksTo(1));
        WHERBLE_FIN = register("wherble_fin", new Item.Properties().food(food(2, 0.2F), fastEating()));
        COOKED_WHERBLE_FIN = register("cooked_wherble_fin", new Item.Properties().food(food(6, 0.3F), fastEating()));
        STUFFED_WHERBLE_FIN = register("stuffed_wherble_fin", new Item.Properties().food(food(4, 0.4F), fastEating()));
        MUSIC_DISC_WARBLE = register("music_disc_warble", new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(FTJukeboxSongs.WARBLE));
        MUSIC_DISC_WARBLE_FRAGMENT = register("disc_fragment_warble", new Item.Properties());

        PHANTOM_NUDIBRANCH_SPAWN_EGG = spawnEgg("phantom_nudibranch_spawn_egg", FTEntities.PHANTOM_NUDIBRANCH);
        PHANTOM_NUDIBRANCH_BUCKET = mobBucket("phantom_nudibranch_bucket", FTEntities.PHANTOM_NUDIBRANCH);

        NIGHT_LIGHT_SQUID_SPAWN_EGG = spawnEgg("night_light_squid_spawn_egg", FTEntities.NIGHT_LIGHT_SQUID);
        NIGHT_LIGHT_SQUID_BUCKET = register("night_light_squid_bucket", p -> new FinsBucketItem(FTEntities.NIGHT_LIGHT_SQUID, Fluids.WATER, p), new Item.Properties().stacksTo(1));
        NIGHT_LIGHT_SQUID_TENTACLE = register("night_light_squid_tentacle", new Item.Properties());
        CHAINED_TENTACLE = blockItem("chained_tentacle", FTBlocks.CHAINED_TENTACLE);
        LUMINOUS_CALAMARI = register("luminous_calamari", new Item.Properties().food(food(2, 0.3f), effectFood(new MobEffectInstance(MobEffects.NIGHT_VISION, 250), 0.5f)));
        COOKED_LUMINOUS_CALAMARI = register("cooked_luminous_calamari", new Item.Properties().food(food(6, 0.5f), effectFood(new MobEffectInstance(MobEffects.NIGHT_VISION, 500), 1.0f)));

        FLATBACK_LEAF_SNAIL_SPAWN_EGG = spawnEgg("flatback_leaf_snail_spawn_egg", FTEntities.FLATBACK_LEAF_SNAIL);
        FLATBACK_LEAF_SNAIL_POT = register("flatback_leaf_snail_pot", p -> new FinsPotItem(FTEntities.FLATBACK_LEAF_SNAIL, Fluids.EMPTY, p), new Item.Properties().stacksTo(1));
        FLATBACK_SHELL = register("flatback_shell", new Item.Properties());

        FLATBACK_SHELL_BRICKS = blockItem("flatback_shell_bricks", FTBlocks.FLATBACK_SHELL_BRICKS);
        FLATBACK_SHELL_BRICK_STAIRS = blockItem("flatback_shell_brick_stairs", FTBlocks.FLATBACK_SHELL_BRICK_STAIRS);
        FLATBACK_SHELL_BRICK_SLAB = blockItem("flatback_shell_brick_slab", FTBlocks.FLATBACK_SHELL_BRICK_SLAB);
        CHISELED_FLATBACK_SHELL_BRICKS = blockItem("chiseled_flatback_shell_bricks", FTBlocks.CHISELED_FLATBACK_SHELL_BRICKS);
        FLATBACK_SHELL_BLOCK = blockItem("flatback_shell_block", FTBlocks.FLATBACK_SHELL_BLOCK);
        FLATBACK_SHELL_STAIRS = blockItem("flatback_shell_stairs", FTBlocks.FLATBACK_SHELL_STAIRS);
        FLATBACK_SHELL_SLAB = blockItem("flatback_shell_slab", FTBlocks.FLATBACK_SHELL_SLAB);

        RIVER_PEBBLE_SNAIL_SPAWN_EGG = spawnEgg("river_pebble_snail_spawn_egg", FTEntities.RIVER_PEBBLE_SNAIL);
        RIVER_PEBBLE_SNAIL_POT = register("river_pebble_snail_pot", p -> new FinsPotItem(FTEntities.RIVER_PEBBLE_SNAIL, Fluids.EMPTY, p), new Item.Properties().stacksTo(1));
        PEBBLE_SHELL = register("pebble_shell", new Item.Properties());

        PEBBLE_SHELL_BRICKS = blockItem("pebble_shell_bricks", FTBlocks.PEBBLE_SHELL_BRICKS);
        PEBBLE_SHELL_BRICK_STAIRS = blockItem("pebble_shell_brick_stairs", FTBlocks.PEBBLE_SHELL_BRICK_STAIRS);
        PEBBLE_SHELL_BRICK_SLAB = blockItem("pebble_shell_brick_slab", FTBlocks.PEBBLE_SHELL_BRICK_SLAB);
        CHISELED_PEBBLE_SHELL_BRICKS = blockItem("chiseled_pebble_shell_bricks", FTBlocks.CHISELED_PEBBLE_SHELL_BRICKS);
        PEBBLE_SHELL_PILLAR = blockItem("pebble_shell_pillar", FTBlocks.PEBBLE_SHELL_PILLAR);

        SIDEROL_WHISKERED_SNAIL_SPAWN_EGG = spawnEgg("siderol_whiskered_snail_spawn_egg", FTEntities.SIDEROL_WHISKERED_SNAIL);
        SIDEROL_WHISKERED_SNAIL_POT = register("siderol_whiskered_snail_pot", p -> new FinsPotItem(FTEntities.SIDEROL_WHISKERED_SNAIL, Fluids.EMPTY, p), new Item.Properties().stacksTo(1));
        SIDEROL_SHELL = register("siderol_shell", new Item.Properties());

        SIDEROL_SHELL_BRICKS = blockItem("siderol_shell_bricks", FTBlocks.SIDEROL_SHELL_BRICKS);
        SIDEROL_SHELL_BRICK_STAIRS = blockItem("siderol_shell_brick_stairs", FTBlocks.SIDEROL_SHELL_BRICK_STAIRS);
        SIDEROL_SHELL_BRICK_SLAB = blockItem("siderol_shell_brick_slab", FTBlocks.SIDEROL_SHELL_BRICK_SLAB);
        CHISELED_SIDEROL_SHELL_BRICKS = blockItem("chiseled_siderol_shell_bricks", FTBlocks.CHISELED_SIDEROL_SHELL_BRICKS);
        MIXED_FLATBACK_SHELL_BRICKS = blockItem("mixed_flatback_shell_bricks", FTBlocks.MIXED_FLATBACK_SHELL_BRICKS);
        MIXED_FLATBACK_SHELL_BRICK_STAIRS = blockItem("mixed_flatback_shell_brick_stairs", FTBlocks.MIXED_FLATBACK_SHELL_BRICK_STAIRS);
        MIXED_FLATBACK_SHELL_BRICK_SLAB = blockItem("mixed_flatback_shell_brick_slab", FTBlocks.MIXED_FLATBACK_SHELL_BRICK_SLAB);
        MIXED_PEBBLE_SHELL_BRICKS = blockItem("mixed_pebble_shell_bricks", FTBlocks.MIXED_PEBBLE_SHELL_BRICKS);
        MIXED_PEBBLE_SHELL_BRICK_STAIRS = blockItem("mixed_pebble_shell_brick_stairs", FTBlocks.MIXED_PEBBLE_SHELL_BRICK_STAIRS);
        MIXED_PEBBLE_SHELL_BRICK_SLAB = blockItem("mixed_pebble_shell_brick_slab", FTBlocks.MIXED_PEBBLE_SHELL_BRICK_SLAB);

        BANNER_PATTERN_SHELL = bannerPattern("banner_pattern_shell", FTTags.PATTERN_ITEM_SHELL);

        MUSIC_DISC_CRASHING_TIDES = register("music_disc_crashing_tides", new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(FTJukeboxSongs.CRASHING_TIDES));
    }

    private static FoodProperties food(int nutrition, float saturation) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation).build();
    }

    private static Consumable fastEating() {
        return Consumable.builder().consumeSeconds(0.8F).build();
    }

    private static Consumable effectFood(MobEffectInstance effect, float probability) {
        return Consumable.builder().onConsume(new ApplyStatusEffectsConsumeEffect(effect, probability)).build();
    }

    private static Item spawnEgg(String name, EntityType<?> type) {
        return register(name, SpawnEggItem::new, new Item.Properties().component(DataComponents.ENTITY_DATA, TypedEntityData.of(type, new CompoundTag())));
    }

    private static Item mobBucket(String name, EntityType<? extends net.minecraft.world.entity.Mob> type) {
        return register(name, p -> new MobBucketItem(type, Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, p), new Item.Properties().stacksTo(1));
    }

    private static Item bannerPattern(String name, net.minecraft.tags.TagKey<net.minecraft.world.level.block.entity.BannerPattern> pattern) {
        return register(name, new Item.Properties().stacksTo(1));
    }

    private static Item blockItem(String name, Block block) {
        return register(name, p -> new BlockItem(block, p), new Item.Properties());
    }

    private static Item register(String name, Item.Properties properties) {
        return register(name, Item::new, properties);
    }

    private static <T extends Item> T register(String name, Function<Item.Properties, T> factory, Item.Properties properties) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, FinsAndTails.id(name));
        T item = Registry.register(BuiltInRegistries.ITEM, key, factory.apply(properties.setId(key)));
        REGISTERED.add(item);
        return item;
    }
}
