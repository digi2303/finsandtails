package blueportal.finsandstails.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.RubberBellyGliderModel;
import blueportal.finsandstails.client.render.state.RubberBellyGliderRenderState;
import blueportal.finsandstails.common.entities.RubberBellyGliderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class RubberBellyGliderRenderer extends MobRenderer<RubberBellyGliderEntity, RubberBellyGliderRenderState, RubberBellyGliderModel> {
    private static final Identifier TEXTURE = FinsAndTails.id("textures/entity/rubber_belly_glider.png");

    public RubberBellyGliderRenderer(EntityRendererProvider.Context context) {
        super(context, new RubberBellyGliderModel(context.bakeLayer(RubberBellyGliderModel.LAYER_LOCATION)), 0.4F);
    }

    @Override
    public RubberBellyGliderRenderState createRenderState() {
        return new RubberBellyGliderRenderState();
    }

    @Override
    public void extractRenderState(RubberBellyGliderEntity entity, RubberBellyGliderRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.moving = entity.walkAnimation.speed() > 0.01F;
        state.puffed = entity.isPuffed();
    }

    @Override
    protected void scale(RubberBellyGliderRenderState state, PoseStack poseStack) {
        super.scale(state, poseStack);
        if (state.puffed) {
            poseStack.translate(0.0F, -0.25F, 0.0F);
        }
        if (state.isBaby) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        }
    }

    @Override
    public Identifier getTextureLocation(RubberBellyGliderRenderState state) {
        return TEXTURE;
    }
}
