package blueportal.finsandstails.client.render;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.FTModelLayers;
import blueportal.finsandstails.client.model.TealArrowfishModel;
import blueportal.finsandstails.client.render.state.TealArrowfishArrowRenderState;
import blueportal.finsandstails.common.entities.item.TealArrowfishArrowEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

public class TealArrowfishArrowRenderer extends EntityRenderer<TealArrowfishArrowEntity, TealArrowfishArrowRenderState> {
    private static final Identifier TEAL_ARROWFISH_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/teal_arrowfish/teal_arrowfish.png");
    private final TealArrowfishModel model;

    public TealArrowfishArrowRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
        this.model = new TealArrowfishModel(ctx.bakeLayer(FTModelLayers.TEAL_ARROWFISH_ARROW));
    }

    @Override
    public TealArrowfishArrowRenderState createRenderState() {
        return new TealArrowfishArrowRenderState();
    }

    @Override
    public void extractRenderState(TealArrowfishArrowEntity entity, TealArrowfishArrowRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.yRot = entity.getYRot(partialTicks);
        state.xRot = entity.getXRot(partialTicks);
        state.shake = (float) entity.shakeTime - partialTicks;
    }

    public Identifier getTextureLocation(TealArrowfishArrowRenderState state) {
        return TEAL_ARROWFISH_LOCATION;
    }

    @Override
    public void submit(TealArrowfishArrowRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(state.yRot - 180.0F));
        poseStack.mulPose(Axis.XP.rotationDegrees(state.xRot));
        poseStack.mulPose(Axis.ZP.rotationDegrees(-180.0F));
        poseStack.translate(0.0, -1.45f, 0.3);
        if (state.shake > 0.0F) {
            float f10 = -Mth.sin(state.shake * 3.0F) * state.shake;
            poseStack.mulPose(Axis.XP.rotationDegrees(f10));
        }

        collector.submitModel(this.model, state, poseStack, this.model.renderType(this.getTextureLocation(state)), state.lightCoords, OverlayTexture.NO_OVERLAY, -1, null);

        poseStack.scale(0.05625F, 0.05625F, 0.05625F);

        poseStack.popPose();
        super.submit(state, poseStack, collector, cameraRenderState);
    }
}
