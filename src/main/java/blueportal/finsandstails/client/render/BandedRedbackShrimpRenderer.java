
package blueportal.finsandstails.client.render;

import blueportal.finsandstails.client.render.state.BandedRedbackShrimpRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.BandedRedbackShrimpModel;
import blueportal.finsandstails.common.entities.BandedRedbackShrimpEntity;
import blueportal.finsandstails.client.FTModelLayers;
public class BandedRedbackShrimpRenderer extends MobRenderer<BandedRedbackShrimpEntity, BandedRedbackShrimpRenderState, BandedRedbackShrimpModel> {
    private static final Identifier BANDED_REDBACK_SHRIMP_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/banded_redback_shrimp/banded_redback_shrimp.png");

    public BandedRedbackShrimpRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new BandedRedbackShrimpModel(ctx.bakeLayer(FTModelLayers.BANDED_REDBACK_SHRIMP)), 0.3f);
    }

    @Override
    public BandedRedbackShrimpRenderState createRenderState() {
        return new BandedRedbackShrimpRenderState();
    }

    @Override
    public void extractRenderState(BandedRedbackShrimpEntity entity, BandedRedbackShrimpRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
    }

    @Override
    public Identifier getTextureLocation(BandedRedbackShrimpRenderState state) {
        return BANDED_REDBACK_SHRIMP_LOCATION;
    }
}
