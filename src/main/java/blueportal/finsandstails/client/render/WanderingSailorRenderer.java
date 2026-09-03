
package blueportal.finsandstails.client.render;

import blueportal.finsandstails.client.render.state.WanderingSailorRenderState;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.FTModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import blueportal.finsandstails.client.model.WanderingSailorModel;
import blueportal.finsandstails.common.entities.WanderingSailorEntity;

public class WanderingSailorRenderer extends MobRenderer<WanderingSailorEntity, WanderingSailorRenderState, WanderingSailorModel> {
    private static final Identifier WANDERING_SAILOR_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/entity/wandering_sailor/wandering_sailor.png");

    public WanderingSailorRenderer(EntityRendererProvider.Context context) {
        super(context, new WanderingSailorModel(context.bakeLayer(FTModelLayers.WANDERING_SAILOR)), 0.45F);
    }

    @Override
    public WanderingSailorRenderState createRenderState() {
        return new WanderingSailorRenderState();
    }

    @Override
    public void extractRenderState(WanderingSailorEntity entity, WanderingSailorRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
    }

    @Override
    public Identifier getTextureLocation(WanderingSailorRenderState state) {
        return WANDERING_SAILOR_LOCATION;
    }
}