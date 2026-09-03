package blueportal.finsandstails.client.render;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.FlatbackSuckerModel;
import blueportal.finsandstails.client.render.state.FlatbackSuckerRenderState;
import blueportal.finsandstails.common.entities.FlatbackSuckerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class FlatbackSuckerRenderer extends MobRenderer<FlatbackSuckerEntity, FlatbackSuckerRenderState, FlatbackSuckerModel> {
    private static final Identifier TEXTURE = FinsAndTails.id("textures/entity/flatback_sucker.png");

    public FlatbackSuckerRenderer(EntityRendererProvider.Context context) {
        super(context, new FlatbackSuckerModel(context.bakeLayer(FlatbackSuckerModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public FlatbackSuckerRenderState createRenderState() {
        return new FlatbackSuckerRenderState();
    }

    @Override
    public void extractRenderState(FlatbackSuckerEntity entity, FlatbackSuckerRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.moving = entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D;
    }

    @Override
    public Identifier getTextureLocation(FlatbackSuckerRenderState state) {
        return TEXTURE;
    }
}
