package blueportal.finsandstails.client.render;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.FlatbackLeafSnailModel;
import blueportal.finsandstails.client.render.state.FlatbackLeafSnailRenderState;
import blueportal.finsandstails.common.entities.FlatbackLeafSnailEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class FlatbackLeafSnailRenderer extends MobRenderer<FlatbackLeafSnailEntity, FlatbackLeafSnailRenderState, FlatbackLeafSnailModel> {
    private static final Identifier TEXTURE = FinsAndTails.id("textures/entity/flatback_leaf_snail.png");

    public FlatbackLeafSnailRenderer(EntityRendererProvider.Context context) {
        super(context, new FlatbackLeafSnailModel(context.bakeLayer(FlatbackLeafSnailModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public FlatbackLeafSnailRenderState createRenderState() {
        return new FlatbackLeafSnailRenderState();
    }

    @Override
    public void extractRenderState(FlatbackLeafSnailEntity entity, FlatbackLeafSnailRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.moving = entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D;
    }

    @Override
    protected void scale(FlatbackLeafSnailRenderState state, PoseStack poseStack) {
        super.scale(state, poseStack);
        if (state.isBaby) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        }
    }

    @Override
    public Identifier getTextureLocation(FlatbackLeafSnailRenderState state) {
        return TEXTURE;
    }
}
