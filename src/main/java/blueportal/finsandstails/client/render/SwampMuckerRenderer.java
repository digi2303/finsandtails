
package blueportal.finsandstails.client.render;

import blueportal.finsandstails.client.render.state.SwampMuckerRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.SwampMuckerModel;
import blueportal.finsandstails.common.entities.SwampMuckerEntity;
import blueportal.finsandstails.client.FTModelLayers;

public class SwampMuckerRenderer extends MobRenderer<SwampMuckerEntity, SwampMuckerRenderState, SwampMuckerModel> {
    private static final Identifier SWAMP_MUCKER_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/swamp_mucker/swamp_mucker.png");

    public SwampMuckerRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new SwampMuckerModel(ctx.bakeLayer(FTModelLayers.SWAMP_MUCKER)), 0.4F);
    }

    @Override
    public SwampMuckerRenderState createRenderState() {
        return new SwampMuckerRenderState();
    }

    @Override
    public void extractRenderState(SwampMuckerEntity entity, SwampMuckerRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
    }

    @Override
    public Identifier getTextureLocation(SwampMuckerRenderState state) {
        return SWAMP_MUCKER_LOCATION;
    }
}
