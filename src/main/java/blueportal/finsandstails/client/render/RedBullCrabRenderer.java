package blueportal.finsandstails.client.render;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.RedBullCrabModel;
import blueportal.finsandstails.client.render.state.RedBullCrabRenderState;
import blueportal.finsandstails.common.entities.RedBullCrabEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class RedBullCrabRenderer extends MobRenderer<RedBullCrabEntity, RedBullCrabRenderState, RedBullCrabModel> {
    private static final Identifier TEXTURE = FinsAndTails.id("textures/entity/red_bull_crab.png");

    public RedBullCrabRenderer(EntityRendererProvider.Context context) {
        super(context, new RedBullCrabModel(context.bakeLayer(RedBullCrabModel.LAYER_LOCATION)), 0.2F);
    }

    @Override
    public RedBullCrabRenderState createRenderState() {
        return new RedBullCrabRenderState();
    }

    @Override
    public void extractRenderState(RedBullCrabEntity entity, RedBullCrabRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.moving = entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D;
    }

    @Override
    public Identifier getTextureLocation(RedBullCrabRenderState state) {
        return TEXTURE;
    }
}
