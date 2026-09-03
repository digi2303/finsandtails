package blueportal.finsandstails.mixin.client;

import blueportal.finsandstails.client.FinsRenderState;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(AvatarRenderState.class)
public abstract class AvatarRenderStateMixin implements FinsRenderState {
    @Unique
    private boolean finsandtails$finsFlying;

    @Override
    public boolean finsandtails$isFinsFlying() {
        return this.finsandtails$finsFlying;
    }

    @Override
    public void finsandtails$setFinsFlying(boolean flying) {
        this.finsandtails$finsFlying = flying;
    }
}
