package blueportal.finsandstails.common.container;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;

public class MudhorsePouchInventory extends SimpleContainer {
    private boolean isDirty;

    public MudhorsePouchInventory() {
        super(9);
    }

    public boolean isDirty() {
        return isDirty;
    }

    @Override
    public void setChanged() {
        super.setChanged();
        isDirty = true;
    }

    public void read(ItemStack stack) {
        stack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).copyInto(this.getItems());
        isDirty = false;
    }

    public void write(ItemStack stack) {
        stack.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(this.getItems()));
        isDirty = false;
    }
}
