package blueportal.finsandstails.registry;

import blueportal.finsandstails.FinsAndTails;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class FTCreativeModeTabs {
    public static final ResourceKey<CreativeModeTab> FINS_AND_TAILS_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, FinsAndTails.id("fins_and_tails"));

    public static CreativeModeTab FINS_AND_TAILS;

    public static void register() {
        FINS_AND_TAILS = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, FINS_AND_TAILS_KEY, CreativeModeTab.builder()
                .icon(FTItems.WEE::getDefaultInstance)
                .title(Component.translatable("itemGroup.finsandtails"))
                .displayItems((parameters, output) -> FTItems.REGISTERED.forEach(output::accept))
                .build());
    }
}
