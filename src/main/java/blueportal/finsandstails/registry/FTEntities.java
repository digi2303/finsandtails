package blueportal.finsandstails.registry;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.common.entities.*;
import blueportal.finsandstails.common.entities.item.TealArrowfishArrowEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class FTEntities {
    public static EntityType<WeeEntity> WEE;
    public static EntityType<BandedRedbackShrimpEntity> BANDED_REDBACK_SHRIMP;
    public static EntityType<TealArrowfishEntity> TEAL_ARROWFISH;
    public static EntityType<SwampMuckerEntity> SWAMP_MUCKER;
    public static EntityType<FlatbackSuckerEntity> FLATBACK_SUCKER;
    public static EntityType<HighFinnedBlueEntity> HIGH_FINNED_BLUE;
    public static EntityType<MudhorseEntity> MUDHORSE;
    public static EntityType<OrnateBugfishEntity> ORNATE_BUGFISH;
    public static EntityType<PhantomNudibranchEntity> PHANTOM_NUDIBRANCH;
    public static EntityType<PenglilEntity> PENGLIL;
    public static EntityType<SpindlyGemCrabEntity> SPINDLY_GEM_CRAB;
    public static EntityType<FlatbackLeafSnailEntity> FLATBACK_LEAF_SNAIL;
    public static EntityType<RedBullCrabEntity> RED_BULL_CRAB;
    public static EntityType<WhiteBullCrabEntity> WHITE_BULL_CRAB;
    public static EntityType<WeeWeeEntity> WEE_WEE;
    public static EntityType<VibraWeeEntity> VIBRA_WEE;
    public static EntityType<RiverPebbleSnailEntity> RIVER_PEBBLE_SNAIL;
    public static EntityType<SiderolWhiskeredSnailEntity> SIDEROL_WHISKERED_SNAIL;
    public static EntityType<GoldenRiverRayEntity> GOLDEN_RIVER_RAY;
    public static EntityType<NightLightSquidEntity> NIGHT_LIGHT_SQUID;
    public static EntityType<RubberBellyGliderEntity> RUBBER_BELLY_GLIDER;
    public static EntityType<TealArrowfishArrowEntity> TEAL_ARROWFISH_ARROW;
    public static EntityType<GopjetEntity> GOPJET;
    public static EntityType<PapaWeeEntity> PAPA_WEE;
    public static EntityType<WherbleEntity> WHERBLE;
    public static EntityType<WanderingSailorEntity> WANDERING_SAILOR;
    public static EntityType<CrownedHorateeEntity> CROWNED_HORATEE;

    public static void register() {
        WEE = create("wee", EntityType.Builder.of(WeeEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.2f));
        BANDED_REDBACK_SHRIMP = create("banded_redback_shrimp", EntityType.Builder.of(BandedRedbackShrimpEntity::new, MobCategory.WATER_AMBIENT).sized( 0.5f, 0.3f));
        TEAL_ARROWFISH = create("teal_arrowfish", EntityType.Builder.of(TealArrowfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.2f).eyeHeight(0.05f));
        SWAMP_MUCKER = create("swamp_mucker", EntityType.Builder.of(SwampMuckerEntity::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.2f));
        FLATBACK_SUCKER = create("flatback_sucker", EntityType.Builder.of(FlatbackSuckerEntity::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.2f));
        HIGH_FINNED_BLUE = create("high_finned_blue", EntityType.Builder.of(HighFinnedBlueEntity::new, MobCategory.WATER_AMBIENT).sized(0.2f, 0.5f));
        MUDHORSE = create("mudhorse", EntityType.Builder.of(MudhorseEntity::new, MobCategory.CREATURE).sized(0.9f, 1.6f).eyeHeight(1.4f));
        ORNATE_BUGFISH = create("ornate_bugfish", EntityType.Builder.of(OrnateBugfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.7f, 1f));
        PHANTOM_NUDIBRANCH = create("phantom_nudibranch", EntityType.Builder.of(PhantomNudibranchEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.3f));
        PENGLIL = create("penglil", EntityType.Builder.of(PenglilEntity::new, MobCategory.WATER_CREATURE).sized( 0.5f, 0.5f));
        SPINDLY_GEM_CRAB = create("spindly_gem_crab", EntityType.Builder.of(SpindlyGemCrabEntity::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.3f));
        FLATBACK_LEAF_SNAIL = create("flatback_leaf_snail", EntityType.Builder.of(FlatbackLeafSnailEntity::new, MobCategory.CREATURE).sized(0.6f, 0.3f).eyeHeight(0.25f));
        RED_BULL_CRAB = create("red_bull_crab", EntityType.Builder.of(RedBullCrabEntity::new, MobCategory.WATER_CREATURE).sized(0.5f, 0.3f));
        WHITE_BULL_CRAB = create("white_bull_crab", EntityType.Builder.of(WhiteBullCrabEntity::new, MobCategory.WATER_CREATURE).sized(0.5f, 0.3f));
        WEE_WEE = create("wee_wee", EntityType.Builder.of(WeeWeeEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.3f));
        VIBRA_WEE = create("vibra_wee", EntityType.Builder.of(VibraWeeEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.4f));
        RIVER_PEBBLE_SNAIL = create("river_pebble_snail", EntityType.Builder.of(RiverPebbleSnailEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.3f).eyeHeight(0.25f));
        SIDEROL_WHISKERED_SNAIL = create("siderol_whiskered_snail", EntityType.Builder.of(SiderolWhiskeredSnailEntity::new, MobCategory.CREATURE).sized(0.3f, 0.4f).eyeHeight(0.4f));
        GOLDEN_RIVER_RAY = create("golden_river_ray", EntityType.Builder.of(GoldenRiverRayEntity::new, MobCategory.WATER_CREATURE).sized(0.7f, 0.3f));
        NIGHT_LIGHT_SQUID = create("night_light_squid", EntityType.Builder.of(NightLightSquidEntity::new, MobCategory.WATER_CREATURE).sized(0.4f, 0.3f).eyeHeight(0.15f));
        RUBBER_BELLY_GLIDER = create("rubber_belly_glider", EntityType.Builder.of(RubberBellyGliderEntity::new, MobCategory.WATER_CREATURE).sized(0.7f, 0.285f).eyeHeight(0.15f));
        TEAL_ARROWFISH_ARROW = create("teal_arrowfish_arrow", EntityType.Builder.<TealArrowfishArrowEntity>of(TealArrowfishArrowEntity::new, MobCategory.MISC).sized(0.5F, 0.5F));
        GOPJET = create("gopjet", EntityType.Builder.of(GopjetEntity::new, MobCategory.WATER_CREATURE).sized(0.7f, 0.5f));
        PAPA_WEE = create("papa_wee", EntityType.Builder.of(PapaWeeEntity::new, MobCategory.WATER_CREATURE).sized(0.5f, 0.5f));
        WHERBLE = create("wherble", EntityType.Builder.of(WherbleEntity::new, MobCategory.CREATURE).sized(0.8f, 0.8f).eyeHeight(0.4f));
        WANDERING_SAILOR = create("wandering_sailor", EntityType.Builder.of(WanderingSailorEntity::new, MobCategory.CREATURE).sized(0.6f, 1.65f).eyeHeight(1.2f));
        CROWNED_HORATEE = create("crowned_horatee", EntityType.Builder.of(CrownedHorateeEntity::new, MobCategory.CREATURE).sized(0.8f, 0.6f));
    }

    private static <T extends Entity> EntityType<T> create(String name, EntityType.Builder<T> builder) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, FinsAndTails.id(name));
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }
}
