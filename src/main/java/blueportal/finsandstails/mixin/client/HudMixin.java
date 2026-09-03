package blueportal.finsandstails.mixin.client;

import blueportal.finsandstails.client.FTHudRenderer;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//? if >=26.2 {
/*import net.minecraft.client.gui.Hud;
*///?} else {
import net.minecraft.client.gui.Gui;
//?}

//? if >=26.2 {
/*@Mixin(Hud.class)
*///?} else {
@Mixin(Gui.class)
//?}
public abstract class HudMixin {
    @Inject(method = "extractHearts", at = @At("HEAD"), cancellable = true)
    private void FT$extractHearts(GuiGraphicsExtractor extractor, Player player, int x, int y, int rowHeight, int regen, float healthMax, int health, int displayHealth, int absorption, boolean highlight, CallbackInfo ci) {
        if (FTHudRenderer.shouldReplaceHearts(player)) {
            FTHudRenderer.extractHearts(extractor, player, x, y, rowHeight, regen, healthMax, health, absorption, highlight);
            ci.cancel();
        }
    }

    @Inject(method = "extractRenderState", at = @At("TAIL"))
    private void FT$extractRenderState(GuiGraphicsExtractor extractor, DeltaTracker deltaTracker, CallbackInfo ci) {
        FTHudRenderer.extractGauntletOverlay(extractor);
    }
}
