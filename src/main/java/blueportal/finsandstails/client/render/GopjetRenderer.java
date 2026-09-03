
package blueportal.finsandstails.client.render;

import blueportal.finsandstails.client.render.state.GopjetRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.GopjetModel;
import blueportal.finsandstails.common.entities.GopjetEntity;
import blueportal.finsandstails.client.FTModelLayers;

public class GopjetRenderer extends MobRenderer<GopjetEntity, GopjetRenderState, GopjetModel> {
    private static final Identifier GOPJET_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/gopjet/gopjet.png");
    private static final Identifier GOPJET_BOOSTING_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/gopjet/gopjet_boosting.png");

    public GopjetRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new GopjetModel(ctx.bakeLayer(FTModelLayers.GOPJET)), 0.4F);
    }

    @Override
    public GopjetRenderState createRenderState() {
        return new GopjetRenderState();
    }

    @Override
    public void extractRenderState(GopjetEntity entity, GopjetRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.boosting = state.boosting;
    }

    @Override
    public Identifier getTextureLocation(GopjetRenderState state) {
        return state.boosting ? GOPJET_BOOSTING_LOCATION : GOPJET_LOCATION;
    }
}
