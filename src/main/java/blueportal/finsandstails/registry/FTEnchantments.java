package blueportal.finsandstails.registry;

import blueportal.finsandstails.FinsAndTails;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

public class FTEnchantments {
    public static final ResourceKey<Enchantment> FLUKED_EDGE = createKey("fluked_edge");
    public static final ResourceKey<Enchantment> UPPERCUTTING = createKey("uppercutting");
    public static final ResourceKey<Enchantment> CRABS_FAVOR = createKey("crabs_favor");

    public static Holder<Enchantment> get(HolderLookup.Provider registries, ResourceKey<Enchantment> key) {
        return registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(key);
    }

    private static ResourceKey<Enchantment> createKey(String name) {
        return ResourceKey.create(Registries.ENCHANTMENT, FinsAndTails.id(name));
    }
}
