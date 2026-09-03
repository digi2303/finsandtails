package blueportal.finsandstails.common;

import blueportal.finsandstails.FTConfig;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.impl.platform.CommonAbstraction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;

public class FTLootModifications {
    public static void register() {
        if (FTConfig.instance.finsFishingLoot) {
            CommonAbstraction.INSTANCE.injectLoot(BuiltInLootTables.FISHING_FISH, injected("fishing"), 10, 1);
        }
        CommonAbstraction.INSTANCE.injectLoot(BuiltInLootTables.FISHERMAN_GIFT, injected("fisherman_gift"), 15, 1);
    }

    private static ResourceKey<LootTable> injected(String name) {
        return ResourceKey.create(Registries.LOOT_TABLE, FinsAndTails.id("inject/" + name));
    }
}
