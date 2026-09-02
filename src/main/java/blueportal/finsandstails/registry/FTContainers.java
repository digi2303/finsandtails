package blueportal.finsandstails.registry;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.common.container.CrabCruncherContainer;
import blueportal.finsandstails.common.container.MudhorsePouchContainer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

public class FTContainers {
    public static MenuType<MudhorsePouchContainer> MUDHORSE_POUCH;
    public static MenuType<CrabCruncherContainer> CRAB_CRUNCHER;

    public static void register() {
        MUDHORSE_POUCH = register("mudhorse_pouch", MudhorsePouchContainer::new);
        CRAB_CRUNCHER = register("crab_cruncher", CrabCruncherContainer::new);
    }

    private static <T extends net.minecraft.world.inventory.AbstractContainerMenu> MenuType<T> register(String name, MenuType.MenuSupplier<T> supplier) {
        return Registry.register(BuiltInRegistries.MENU, FinsAndTails.id(name), new MenuType<>(supplier, FeatureFlags.VANILLA_SET));
    }
}
