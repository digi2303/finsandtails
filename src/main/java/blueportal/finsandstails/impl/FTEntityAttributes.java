package blueportal.finsandstails.impl;

import blueportal.finsandstails.common.entities.*;
import blueportal.finsandstails.impl.platform.CommonAbstraction;
import blueportal.finsandstails.registry.FTEntities;
import net.minecraft.world.entity.animal.fish.AbstractFish;

public class FTEntityAttributes {
    public static void register() {
        CommonAbstraction.INSTANCE.registerAttributes(registry -> {
            registry.register(FTEntities.BANDED_REDBACK_SHRIMP, BandedRedbackShrimpEntity.createAttributes());
            registry.register(FTEntities.WEE, WeeEntity.createAttributes());
            registry.register(FTEntities.FLATBACK_SUCKER, FlatbackSuckerEntity.createAttributes());
            registry.register(FTEntities.HIGH_FINNED_BLUE, HighFinnedBlueEntity.createAttributes());
            registry.register(FTEntities.MUDHORSE, MudhorseEntity.createAttributes());
            registry.register(FTEntities.ORNATE_BUGFISH, OrnateBugfishEntity.createAttributes());
            registry.register(FTEntities.PENGLIL, PenglilEntity.createAttributes());
            registry.register(FTEntities.PHANTOM_NUDIBRANCH, PhantomNudibranchEntity.createAttributes());
            registry.register(FTEntities.SPINDLY_GEM_CRAB, SpindlyGemCrabEntity.createAttributes());
            registry.register(FTEntities.SWAMP_MUCKER, SwampMuckerEntity.createAttributes());
            registry.register(FTEntities.TEAL_ARROWFISH, TealArrowfishEntity.createAttributes());
            registry.register(FTEntities.FLATBACK_LEAF_SNAIL, FlatbackLeafSnailEntity.createAttributes());
            registry.register(FTEntities.RUBBER_BELLY_GLIDER, RubberBellyGliderEntity.registerRBGAttributes());
            registry.register(FTEntities.RED_BULL_CRAB, RedBullCrabEntity.createAttributes());
            registry.register(FTEntities.WHITE_BULL_CRAB, WhiteBullCrabEntity.createAttributes());
            registry.register(FTEntities.WEE_WEE, WeeWeeEntity.createAttributes());
            registry.register(FTEntities.VIBRA_WEE, AbstractFish.createAttributes());
            registry.register(FTEntities.GOPJET, GopjetEntity.createAttributes());
            registry.register(FTEntities.RIVER_PEBBLE_SNAIL, RiverPebbleSnailEntity.createAttributes());
            registry.register(FTEntities.SIDEROL_WHISKERED_SNAIL, SiderolWhiskeredSnailEntity.createAttributes());
            registry.register(FTEntities.GOLDEN_RIVER_RAY, GoldenRiverRayEntity.createAttributes());
            registry.register(FTEntities.NIGHT_LIGHT_SQUID, NightLightSquidEntity.createAttributes());
            registry.register(FTEntities.PAPA_WEE, PapaWeeEntity.createAttributes());
            registry.register(FTEntities.WHERBLE, WherbleEntity.createAttributes());
            registry.register(FTEntities.WANDERING_SAILOR, WanderingSailorEntity.createAttributes());
            registry.register(FTEntities.CROWNED_HORATEE, CrownedHorateeEntity.createAttributes());
        });
    }
}
