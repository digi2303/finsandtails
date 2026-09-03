
package blueportal.finsandstails.client.render;

import blueportal.finsandstails.client.render.state.WherbleRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.WherbleModel;
import blueportal.finsandstails.common.entities.WherbleEntity;
import blueportal.finsandstails.client.FTModelLayers;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.SubmitNodeCollector;
import com.mojang.blaze3d.vertex.PoseStack;

public class WherbleRenderer extends MobRenderer<WherbleEntity, WherbleRenderState, WherbleModel> {
    private final WherbleModel adultModel = this.getModel();
    private final WherbleModel babyModel;

    public WherbleRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new WherbleModel(ctx.bakeLayer(FTModelLayers.WHERBLE)), 0.3F);
        this.babyModel = new WherbleModel(ctx.bakeLayer(FTModelLayers.WHERBLING));
    }

    @Override
    public void submit(WherbleRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState cameraRenderState) {
        this.model = state.isBaby ? this.babyModel : this.adultModel;
        super.submit(state, poseStack, collector, cameraRenderState);
    }

    @Override
    public WherbleRenderState createRenderState() {
        return new WherbleRenderState();
    }

    @Override
    public void extractRenderState(WherbleEntity entity, WherbleRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.variant = entity.getVariant();
        state.projectile = entity.isProjectile();
    }

    @Override
    public Identifier getTextureLocation(WherbleRenderState state) {
        if (state.isBaby) return Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/wherble/wherbling.png");
        return Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/wherble/wherble_"+ (state.variant + 1) +".png");
    }
}
