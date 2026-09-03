package blueportal.finsandstails.mixin.server;

import blueportal.finsandstails.common.FTEvents;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Projectile.class)
public class ProjectileMixin {
    @Inject(method = "onHit", at = @At("TAIL"))
    private void FT$onHit(HitResult result, CallbackInfo ci) {
        FTEvents.onArrowfishHit((Projectile) (Object) this, result);
    }
}
