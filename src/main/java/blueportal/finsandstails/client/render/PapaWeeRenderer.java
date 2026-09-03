package blueportal.finsandstails.client.render;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.PapaWeeModel;
import blueportal.finsandstails.client.render.state.PapaWeeRenderState;
import blueportal.finsandstails.common.entities.PapaWeeEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class PapaWeeRenderer extends MobRenderer<PapaWeeEntity, PapaWeeRenderState, PapaWeeModel> {
    private static final Identifier TEXTURE = FinsAndTails.id("textures/entity/papa_wee.png");

    public PapaWeeRenderer(EntityRendererProvider.Context context) {
        super(context, new PapaWeeModel(context.bakeLayer(PapaWeeModel.LAYER_LOCATION)), 0.25F);
    }

    @Override
    public PapaWeeRenderState createRenderState() {
        return new PapaWeeRenderState();
    }

    @Override
    public void extractRenderState(PapaWeeEntity entity, PapaWeeRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.moving = entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D;
    }

    @Override
    public Identifier getTextureLocation(PapaWeeRenderState state) {
        return TEXTURE;
    }
}
