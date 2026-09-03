package blueportal.finsandstails.client.render;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.HighFinnedBlueModel;
import blueportal.finsandstails.client.render.state.HighFinnedBlueRenderState;
import blueportal.finsandstails.common.entities.HighFinnedBlueEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class HighFinnedBlueRenderer extends MobRenderer<HighFinnedBlueEntity, HighFinnedBlueRenderState, HighFinnedBlueModel> {
    private static final Identifier TEXTURE = FinsAndTails.id("textures/entity/high_finned_blue.png");

    public HighFinnedBlueRenderer(EntityRendererProvider.Context context) {
        super(context, new HighFinnedBlueModel(context.bakeLayer(HighFinnedBlueModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public HighFinnedBlueRenderState createRenderState() {
        return new HighFinnedBlueRenderState();
    }

    @Override
    public void extractRenderState(HighFinnedBlueEntity entity, HighFinnedBlueRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.moving = entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D;
    }

    @Override
    public Identifier getTextureLocation(HighFinnedBlueRenderState state) {
        return TEXTURE;
    }
}
