package blueportal.finsandstails.impl;

import blueportal.finsandstails.common.entities.CrownedHorateeEntity;
import blueportal.finsandstails.common.entities.PenglilEntity;
import blueportal.finsandstails.common.entities.RedBullCrabEntity;
import blueportal.finsandstails.common.entities.WherbleEntity;
import blueportal.finsandstails.impl.platform.CommonAbstraction;
import blueportal.finsandstails.registry.FTEntities;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.fish.WaterAnimal;
import net.minecraft.world.level.levelgen.Heightmap;

public class FTSpawnPlacements {
    public static void register() {
        CommonAbstraction abstraction = CommonAbstraction.INSTANCE;

        abstraction.registerSpawnPlacement(FTEntities.WEE, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.BANDED_REDBACK_SHRIMP, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.SWAMP_MUCKER, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.TEAL_ARROWFISH, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.FLATBACK_SUCKER, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.HIGH_FINNED_BLUE, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.MUDHORSE, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.PHANTOM_NUDIBRANCH, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.ORNATE_BUGFISH, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.PENGLIL, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PenglilEntity::canPenglilSpawn);
        abstraction.registerSpawnPlacement(FTEntities.SPINDLY_GEM_CRAB, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.FLATBACK_LEAF_SNAIL, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.RED_BULL_CRAB, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, RedBullCrabEntity::canCrabSpawn);
        abstraction.registerSpawnPlacement(FTEntities.WHITE_BULL_CRAB, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, RedBullCrabEntity::canCrabSpawn);
        abstraction.registerSpawnPlacement(FTEntities.WEE_WEE, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.VIBRA_WEE, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.RIVER_PEBBLE_SNAIL, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.SIDEROL_WHISKERED_SNAIL, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.GOLDEN_RIVER_RAY, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.NIGHT_LIGHT_SQUID, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.GOPJET, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.PAPA_WEE, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.WHERBLE, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WherbleEntity::checkWherbleSpawnRules);
        abstraction.registerSpawnPlacement(FTEntities.CROWNED_HORATEE, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CrownedHorateeEntity::checkCrownedSpawnRules);
    }
}
