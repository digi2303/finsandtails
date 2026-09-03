
package blueportal.finsandstails.client.render;

import blueportal.finsandstails.client.render.state.WherbleRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.WherbleModel;
import blueportal.finsandstails.common.entities.WherbleEntity;
import blueportal.finsandstails.client.FTModelLayers;

public class WherbleRenderer extends MobRenderer<WherbleEntity, WherbleRenderState, WherbleModel> {
    private final WherbleModel adultModel = this.getModel();
    private final WherbleModel babyModel;

    public WherbleRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new WherbleModel(ctx.bakeLayer(FTModelLayers.WHERBLE)), 0.3F);
        this.babyModel = new WherbleModel(ctx.bakeLayer(FTModelLayers.WHERBLING));
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
        this.model = state.isBaby ? this.babyModel : this.adultModel;
    }

    @Override
    public Identifier getTextureLocation(WherbleRenderState state) {
        if (state.isBaby) return Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/wherble/wherbling.png");
        return Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/wherble/wherble_"+ (state.variant + 1) +".png");
    }
}
