package blueportal.finsandstails.common.container.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import blueportal.finsandstails.registry.FTBlocks;
import blueportal.finsandstails.registry.FTItems;

public class CrabCruncherSlot extends Slot {
    public CrabCruncherSlot(Container inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return  stack.getItem() == FTItems.AMBER_SPINDLY_GEM_CRAB
                || stack.getItem() == FTItems.RUBY_SPINDLY_GEM_CRAB
                || stack.getItem() == FTItems.EMERALD_SPINDLY_GEM_CRAB
                || stack.getItem() == FTItems.SAPPHIRE_SPINDLY_GEM_CRAB
                || stack.getItem() == FTItems.PEARL_SPINDLY_GEM_CRAB
                || stack.getItem() == FTBlocks.SPINDLY_GEM_BLOCK.asItem()
                || stack.getItem() == FTItems.EMPTY_CHARM
                || stack.getItem() == FTItems.SPINDLY_AMBER
                || stack.getItem() == FTItems.SPINDLY_EMERALD
                || stack.getItem() == FTItems.SPINDLY_PEARL
                || stack.getItem() == FTItems.SPINDLY_SAPPHIRE
                || stack.getItem() == FTItems.SPINDLY_RUBY
                || stack.getItem() == Items.BOOK;
    }
}
