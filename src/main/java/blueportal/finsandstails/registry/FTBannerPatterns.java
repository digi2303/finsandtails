package blueportal.finsandstails.registry;

import blueportal.finsandstails.FinsAndTails;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public class FTBannerPatterns {
    public static final ResourceKey<BannerPattern> MANDIBLES = createKey("mandibles");
    public static final ResourceKey<BannerPattern> SHELL = createKey("shell");

    private static ResourceKey<BannerPattern> createKey(String name) {
        return ResourceKey.create(Registries.BANNER_PATTERN, FinsAndTails.id(name));
    }
}
