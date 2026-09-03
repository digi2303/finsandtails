package blueportal.finsandstails.mixin.server;

import blueportal.finsandstails.common.FTEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "getExperienceReward", at = @At("RETURN"), cancellable = true)
    private void FT$getExperienceReward(ServerLevel level, Entity killer, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(FTEvents.crabsFavorExperience(level, killer, cir.getReturnValue()));
    }
}
