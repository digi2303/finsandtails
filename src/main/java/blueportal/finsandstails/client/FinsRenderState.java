package blueportal.finsandstails.client;

import net.minecraft.world.item.ItemStack;

public interface FinsRenderState {
    boolean finsandtails$isFinsFlying();

    void finsandtails$setFinsFlying(boolean flying);

    ItemStack finsandtails$getChestItem();

    void finsandtails$setChestItem(ItemStack stack);

    ItemStack finsandtails$getFeetItem();

    void finsandtails$setFeetItem(ItemStack stack);
}
