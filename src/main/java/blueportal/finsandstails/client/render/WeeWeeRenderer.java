package blueportal.finsandstails.client.render;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.WeeWeeModel;
import blueportal.finsandstails.client.render.state.WeeWeeRenderState;
import blueportal.finsandstails.common.entities.WeeWeeEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class WeeWeeRenderer extends MobRenderer<WeeWeeEntity, WeeWeeRenderState, WeeWeeModel> {
    private static final Identifier WEE_WEE_LOCATION = FinsAndTails.id("textures/entity/wee_wee.png");

    public WeeWeeRenderer(EntityRendererProvider.Context context) {
        super(context, new WeeWeeModel(context.bakeLayer(WeeWeeModel.LAYER_LOCATION)), 0.1F);
    }

    @Override
    public WeeWeeRenderState createRenderState() {
        return new WeeWeeRenderState();
    }

    @Override
    public void extractRenderState(WeeWeeEntity entity, WeeWeeRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.moving = entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D;
    }

    @Override
    public Identifier getTextureLocation(WeeWeeRenderState state) {
        return WEE_WEE_LOCATION;
    }
}
