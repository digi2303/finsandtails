package blueportal.finsandstails.mixin.client;

import blueportal.finsandstails.client.FinsRenderState;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import net.minecraft.world.item.ItemStack;

@Mixin(AvatarRenderState.class)
public abstract class AvatarRenderStateMixin implements FinsRenderState {
    @Unique
    private boolean finsandtails$finsFlying;

    @Unique
    private ItemStack finsandtails$chestItem = ItemStack.EMPTY;

    @Unique
    private ItemStack finsandtails$feetItem = ItemStack.EMPTY;

    @Override
    public boolean finsandtails$isFinsFlying() {
        return this.finsandtails$finsFlying;
    }

    @Override
    public void finsandtails$setFinsFlying(boolean flying) {
        this.finsandtails$finsFlying = flying;
    }

    @Override
    public ItemStack finsandtails$getChestItem() {
        return this.finsandtails$chestItem;
    }

    @Override
    public void finsandtails$setChestItem(ItemStack stack) {
        this.finsandtails$chestItem = stack;
    }

    @Override
    public ItemStack finsandtails$getFeetItem() {
        return this.finsandtails$feetItem;
    }

    @Override
    public void finsandtails$setFeetItem(ItemStack stack) {
        this.finsandtails$feetItem = stack;
    }
}
