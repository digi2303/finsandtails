package blueportal.finsandstails.impl;

import blueportal.finsandstails.FTConfig;
import blueportal.finsandstails.common.FTLootModifications;
import blueportal.finsandstails.network.FTMessages;
import blueportal.finsandstails.registry.FTBlocks;
import blueportal.finsandstails.registry.FTContainers;
import blueportal.finsandstails.registry.FTCreativeModeTabs;
import blueportal.finsandstails.registry.FTEntities;
import blueportal.finsandstails.registry.FTItems;
import blueportal.finsandstails.registry.FTRecipes;
import blueportal.finsandstails.registry.FTSounds;
import blueportal.finsandstails.registry.FTSpawns;
import dev.yumi.mc.core.api.ModContainer;
import dev.yumi.mc.core.api.entrypoint.ModInitializer;

public class FinsAndTailsMain implements ModInitializer {
    @Override
    public void onInitialize(ModContainer modContainer) {
        FTConfig.load();
        FTSounds.register();
        FTEntities.register();
        FTBlocks.register();
        FTItems.register();
        FTContainers.register();
        FTRecipes.register();
        FTCreativeModeTabs.register();
        FTEntityAttributes.register();
        FTSpawnPlacements.register();
        FTSpawns.register();
        FTMessages.register();
        FTLootModifications.register();
    }
}
