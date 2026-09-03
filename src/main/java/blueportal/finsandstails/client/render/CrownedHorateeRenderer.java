package blueportal.finsandstails.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.CrownedHorateeModel;
import blueportal.finsandstails.client.render.state.CrownedHorateeRenderState;
import blueportal.finsandstails.common.entities.CrownedHorateeEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class CrownedHorateeRenderer extends MobRenderer<CrownedHorateeEntity, CrownedHorateeRenderState, CrownedHorateeModel> {
    private static final Identifier TEXTURE = FinsAndTails.id("textures/entity/crowned_horatee.png");

    public CrownedHorateeRenderer(EntityRendererProvider.Context context) {
        super(context, new CrownedHorateeModel(context.bakeLayer(CrownedHorateeModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public CrownedHorateeRenderState createRenderState() {
        return new CrownedHorateeRenderState();
    }

    @Override
    public void extractRenderState(CrownedHorateeEntity entity, CrownedHorateeRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.moving = entity.walkAnimation.speed() > 0.01F;
        state.onGround = entity.onGround();
        state.bubbleCharge = entity.isBubbleCharge();
    }

    @Override
    protected void scale(CrownedHorateeRenderState state, PoseStack poseStack) {
        super.scale(state, poseStack);
        if (state.isBaby) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        }
    }

    @Override
    public Identifier getTextureLocation(CrownedHorateeRenderState state) {
        return TEXTURE;
    }
}
