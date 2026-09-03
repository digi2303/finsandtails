package blueportal.finsandstails.client;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.common.items.FinsBucketItem;
import blueportal.finsandstails.common.items.FinsPotItem;
import blueportal.finsandstails.common.items.SpindlyGemCharmItem;
import blueportal.finsandstails.registry.FTItems;

public class FTItemProperties {

    public static void setupItemProperties() {
        registerBroken(FTItems.GEM_CRAB_AMULET);
        for (RegistryObject<Item> item : FTItems.ITEMS.getEntries()) {
            if (item.get() instanceof FinsBucketItem || item.get() instanceof FinsPotItem) {
                registerVariant(item.get());
            }
        }
    }

    private static void registerVariant(Item item) {
        ItemProperties.register(item, Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "variant"), (stack, world, player, i) -> stack.has(DataComponents.CUSTOM_DATA) ? stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getIntOr("Variant", 0) : 0);
    }

    private static void registerBroken(Item item) {
        ItemProperties.register(item, Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "broken"), (stack, world, player, i) -> SpindlyGemCharmItem.isUsable(stack) ? 0.0F : 1.0F);
    }
}
