package blueportal.finsandstails.client.render;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.SiderolWhiskeredSnailModel;
import blueportal.finsandstails.client.render.state.SiderolWhiskeredSnailRenderState;
import blueportal.finsandstails.common.entities.SiderolWhiskeredSnailEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class SiderolWhiskeredSnailRenderer extends MobRenderer<SiderolWhiskeredSnailEntity, SiderolWhiskeredSnailRenderState, SiderolWhiskeredSnailModel> {
    private static final Identifier TEXTURE = FinsAndTails.id("textures/entity/siderol_whiskered_snail.png");

    public SiderolWhiskeredSnailRenderer(EntityRendererProvider.Context context) {
        super(context, new SiderolWhiskeredSnailModel(context.bakeLayer(SiderolWhiskeredSnailModel.LAYER_LOCATION)), 0.2F);
    }

    @Override
    public SiderolWhiskeredSnailRenderState createRenderState() {
        return new SiderolWhiskeredSnailRenderState();
    }

    @Override
    public void extractRenderState(SiderolWhiskeredSnailEntity entity, SiderolWhiskeredSnailRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.moving = entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D;
    }

    @Override
    public Identifier getTextureLocation(SiderolWhiskeredSnailRenderState state) {
        return TEXTURE;
    }
}
