package blueportal.finsandstails.registry;

import blueportal.finsandstails.impl.platform.CommonAbstraction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import java.util.List;

public class FTSpawns {
    public record Entry(CommonAbstraction.BiomeSelector selector, MobCategory category, EntityType<?> type, int weight, int minCount, int maxCount) {
    }

    public static List<Entry> all() {
        return List.of(
                new Entry(keys(Biomes.WARM_OCEAN), MobCategory.WATER_AMBIENT, FTEntities.BANDED_REDBACK_SHRIMP, 6, 3, 3),
                new Entry(keys(Biomes.WARM_OCEAN), MobCategory.CREATURE, FTEntities.CROWNED_HORATEE, 4, 2, 4),
                new Entry(CommonAbstraction.BiomeSelector.of(BiomeTags.IS_FOREST), MobCategory.CREATURE, FTEntities.FLATBACK_LEAF_SNAIL, 6, 1, 2),
                new Entry(CommonAbstraction.BiomeSelector.of(BiomeTags.IS_RIVER), MobCategory.WATER_CREATURE, FTEntities.GOLDEN_RIVER_RAY, 2, 1, 1),
                new Entry(keys(Biomes.DEEP_OCEAN, Biomes.OCEAN), MobCategory.WATER_CREATURE, FTEntities.GOPJET, 1, 2, 3),
                new Entry(keys(Biomes.DEEP_OCEAN, Biomes.OCEAN), MobCategory.WATER_AMBIENT, FTEntities.HIGH_FINNED_BLUE, 2, 6, 12),
                new Entry(keys(Biomes.SWAMP, Biomes.MANGROVE_SWAMP), MobCategory.CREATURE, FTEntities.MUDHORSE, 10, 2, 3),
                new Entry(keys(Biomes.DEEP_FROZEN_OCEAN, Biomes.FROZEN_OCEAN), MobCategory.WATER_CREATURE, FTEntities.NIGHT_LIGHT_SQUID, 4, 4, 6),
                new Entry(keys(Biomes.WARM_OCEAN), MobCategory.WATER_AMBIENT, FTEntities.ORNATE_BUGFISH, 1, 5, 5),
                new Entry(CommonAbstraction.BiomeSelector.of(BiomeTags.IS_BEACH), MobCategory.WATER_CREATURE, FTEntities.PENGLIL, 2, 3, 5),
                new Entry(keys(Biomes.DEEP_COLD_OCEAN, Biomes.COLD_OCEAN), MobCategory.WATER_AMBIENT, FTEntities.PHANTOM_NUDIBRANCH, 3, 1, 1),
                new Entry(keys(Biomes.DEEP_LUKEWARM_OCEAN, Biomes.LUKEWARM_OCEAN), MobCategory.WATER_CREATURE, FTEntities.RED_BULL_CRAB, 2, 1, 1),
                new Entry(CommonAbstraction.BiomeSelector.of(BiomeTags.IS_RIVER), MobCategory.WATER_AMBIENT, FTEntities.RIVER_PEBBLE_SNAIL, 200, 1, 1),
                new Entry(keys(Biomes.WARM_OCEAN, Biomes.BEACH), MobCategory.WATER_CREATURE, FTEntities.RUBBER_BELLY_GLIDER, 3, 1, 2),
                new Entry(CommonAbstraction.BiomeSelector.of(BiomeTags.IS_HILL), MobCategory.CREATURE, FTEntities.SIDEROL_WHISKERED_SNAIL, 50, 1, 2),
                new Entry(keys(Biomes.WARM_OCEAN), MobCategory.WATER_AMBIENT, FTEntities.SPINDLY_GEM_CRAB, 7, 1, 3),
                new Entry(keys(Biomes.SWAMP, Biomes.MANGROVE_SWAMP), MobCategory.WATER_AMBIENT, FTEntities.SWAMP_MUCKER, 1, 2, 4),
                new Entry(keys(Biomes.COLD_OCEAN, Biomes.DEEP_COLD_OCEAN), MobCategory.WATER_AMBIENT, FTEntities.TEAL_ARROWFISH, 4, 1, 1),
                new Entry(CommonAbstraction.BiomeSelector.of(BiomeTags.IS_JUNGLE), MobCategory.WATER_AMBIENT, FTEntities.VIBRA_WEE, 5, 2, 5),
                new Entry(keys(Biomes.DEEP_COLD_OCEAN, Biomes.COLD_OCEAN, Biomes.BAMBOO_JUNGLE, Biomes.JUNGLE, Biomes.SPARSE_JUNGLE, Biomes.MANGROVE_SWAMP, Biomes.SWAMP), MobCategory.WATER_AMBIENT, FTEntities.WEE, 6, 4, 8),
                new Entry(CommonAbstraction.BiomeSelector.of(BiomeTags.IS_RIVER), MobCategory.WATER_AMBIENT, FTEntities.WEE_WEE, 2, 2, 6),
                new Entry(CommonAbstraction.BiomeSelector.of(FTTags.WHERBLE_SPAWNS), MobCategory.CREATURE, FTEntities.WHERBLE, 1, 2, 4),
                new Entry(keys(Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN), MobCategory.WATER_CREATURE, FTEntities.WHITE_BULL_CRAB, 2, 2, 4)
        );
    }

    public static void register() {
        for (Entry entry : all()) {
            CommonAbstraction.INSTANCE.addSpawn(entry.selector(), entry.category(), entry.type(), entry.weight(), entry.minCount(), entry.maxCount());
        }
    }

    @SafeVarargs
    private static CommonAbstraction.BiomeSelector keys(ResourceKey<Biome>... keys) {
        return CommonAbstraction.BiomeSelector.of(keys);
    }
}
