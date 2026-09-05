package blueportal.finsandstails.mixin.client;

import blueportal.finsandstails.client.FinsRenderState;
import blueportal.finsandstails.client.render.layer.FTArmorLayer;
import blueportal.finsandstails.common.FinsPlayerData;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Avatar;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.world.entity.EquipmentSlot;

@Mixin(AvatarRenderer.class)
public abstract class AvatarRendererMixin<T extends Avatar> extends LivingEntityRenderer<T, AvatarRenderState, PlayerModel> {
    public AvatarRendererMixin(EntityRendererProvider.Context context, PlayerModel model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void FT$addLayers(EntityRendererProvider.Context context, boolean slim, CallbackInfo ci) {
        this.addLayer(new FTArmorLayer(this, context.getModelSet()));
    }

    @Inject(method = "extractRenderState(Lnet/minecraft/world/entity/Avatar;Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;F)V", at = @At("TAIL"))
    private void FT$extractRenderState(T entity, AvatarRenderState state, float partialTicks, CallbackInfo ci) {
        if (entity instanceof FinsPlayerData data) {
            ((FinsRenderState) state).finsandtails$setFinsFlying(data.finsandtails$isFinsFlying());
        }

        FinsRenderState finsState = (FinsRenderState) state;
        finsState.finsandtails$setChestItem(entity.getItemBySlot(EquipmentSlot.CHEST));
        finsState.finsandtails$setFeetItem(entity.getItemBySlot(EquipmentSlot.FEET));
    }
}
