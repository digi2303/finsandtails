package blueportal.finsandstails.mixin.server;

import blueportal.finsandstails.common.FTEvents;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mob.class)
public abstract class MobMixin {
    @Shadow
    protected GoalSelector goalSelector;

    @Shadow
    protected GoalSelector targetSelector;

    @Inject(method = "registerGoals", at = @At("TAIL"))
    private void FT$registerGoals(CallbackInfo ci) {
        FTEvents.addWherbleGoals((Mob) (Object) this, this.goalSelector, this.targetSelector);
    }
}
