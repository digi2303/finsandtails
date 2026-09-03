package blueportal.finsandstails.mixin.server;

import blueportal.finsandstails.common.FTEvents;
import blueportal.finsandstails.common.FinsPlayerData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin implements FinsPlayerData {
    @Unique
    private int finsandtails$hitCombo;

    @Unique
    private boolean finsandtails$finsFlying;

    @Override
    public int finsandtails$getHitCombo() {
        return this.finsandtails$hitCombo;
    }

    @Override
    public void finsandtails$setHitCombo(int hitCombo) {
        this.finsandtails$hitCombo = hitCombo;
    }

    @Override
    public boolean finsandtails$isFinsFlying() {
        return this.finsandtails$finsFlying;
    }

    @Override
    public void finsandtails$setFinsFlying(boolean flying) {
        this.finsandtails$finsFlying = flying;
    }

    @Inject(method = "interactOn", at = @At("HEAD"), cancellable = true)
    private void FT$interactOn(Entity target, InteractionHand hand, Vec3 pos, CallbackInfoReturnable<InteractionResult> cir) {
        InteractionResult result = FTEvents.onPlayerInteractEntity((Player) (Object) this, hand, target);
        if (result != InteractionResult.PASS) {
            cir.setReturnValue(result);
        }
    }

    @Inject(method = "attack", at = @At("TAIL"))
    private void FT$attack(Entity target, CallbackInfo ci) {
        FTEvents.onPlayerAttack((Player) (Object) this, target);
    }

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    private void FT$addAdditionalSaveData(ValueOutput output, CallbackInfo ci) {
        output.putInt("playerHitCombo", this.finsandtails$hitCombo);
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void FT$readAdditionalSaveData(ValueInput input, CallbackInfo ci) {
        this.finsandtails$hitCombo = input.getIntOr("playerHitCombo", 0);
    }
}
