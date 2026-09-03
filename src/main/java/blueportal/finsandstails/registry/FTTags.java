package blueportal.finsandstails.registry;

import blueportal.finsandstails.FinsAndTails;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;

public class FTTags {
    public static final TagKey<Item> CLAW_GAUNTLETS = itemTag("claw_gauntlets");
    public static final TagKey<Item> FISH_BUCKETS = itemTag("fish_buckets");
    public static final TagKey<Item> WEES = itemTag("wees");
    public static final TagKey<Item> MUDHORSE_POUCH_BLACKLIST = itemTag("mudhorse_pouch_blacklist");
    public static final TagKey<Item> SPINDLY_GEM_CRABS = itemTag("spindly_gem_crabs");
    public static final TagKey<Item> GOPJET = itemTag("gopjet");
    public static final TagKey<Item> REPAIRS_GOPJET_JETPACK = itemTag("repairs_gopjet_jetpack");
    public static final TagKey<Item> REPAIRS_ARMORED_GOPJET_JETPACK = itemTag("repairs_armored_gopjet_jetpack");
    public static final TagKey<Item> REPAIRS_SPINDLY_CHARM = itemTag("repairs_spindly_charm");

    public static final TagKey<BannerPattern> PATTERN_ITEM_MANDIBLES = patternTag("pattern_item/mandibles");
    public static final TagKey<BannerPattern> PATTERN_ITEM_SHELL = patternTag("pattern_item/shell");

    public static final TagKey<EntityType<?>> PREDATORS_HIGH_FINNED_BLUE = entityTag("predators/high_finned_blue");

    public static final TagKey<Block> GRAVELS = conventionBlockTag("gravels");

    public static final TagKey<Biome> MUCK_WEE_SPAWNS = biomeTag("muck_wee_spawns");
    public static final TagKey<Biome> WHERBLE_SPAWNS = biomeTag("wherble_spawns");

    private static TagKey<BannerPattern> patternTag(String path) {
        return TagKey.create(Registries.BANNER_PATTERN, FinsAndTails.id(path));
    }

    private static TagKey<Block> conventionBlockTag(String path) {
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("c", path));
    }

    private static TagKey<Biome> biomeTag(String path) {
        return TagKey.create(Registries.BIOME, FinsAndTails.id(path));
    }

    private static TagKey<Item> itemTag(String path) {
        return TagKey.create(Registries.ITEM, FinsAndTails.id(path));
    }

    private static TagKey<EntityType<?>> entityTag(String path) {
        return TagKey.create(Registries.ENTITY_TYPE, FinsAndTails.id(path));
    }
}
