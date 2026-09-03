package blueportal.finsandstails.mixin.server;

import blueportal.finsandstails.common.FTEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownSplashPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ThrownSplashPotion.class)
public class ThrownSplashPotionMixin {

    @Inject(method = "onHitAsPotion", at = @At("TAIL"))
    private void FT$onHitAsPotion(ServerLevel level, ItemStack stack, HitResult result, CallbackInfo ci) {
        FTEvents.onSplashPotionHit((Projectile) (Object) this, stack);
    }
}
