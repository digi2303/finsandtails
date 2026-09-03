package blueportal.finsandstails.client.render;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.WhiteBullCrabModel;
import blueportal.finsandstails.client.render.state.WhiteBullCrabRenderState;
import blueportal.finsandstails.common.entities.WhiteBullCrabEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class WhiteBullCrabRenderer extends MobRenderer<WhiteBullCrabEntity, WhiteBullCrabRenderState, WhiteBullCrabModel> {
    private static final Identifier TEXTURE = FinsAndTails.id("textures/entity/white_bull_crab.png");

    public WhiteBullCrabRenderer(EntityRendererProvider.Context context) {
        super(context, new WhiteBullCrabModel(context.bakeLayer(WhiteBullCrabModel.LAYER_LOCATION)), 0.2F);
    }

    @Override
    public WhiteBullCrabRenderState createRenderState() {
        return new WhiteBullCrabRenderState();
    }

    @Override
    public void extractRenderState(WhiteBullCrabEntity entity, WhiteBullCrabRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.moving = entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D;
    }

    @Override
    public Identifier getTextureLocation(WhiteBullCrabRenderState state) {
        return TEXTURE;
    }
}
