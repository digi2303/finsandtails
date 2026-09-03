package blueportal.finsandstails.client.render;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.SpindlyGemCrabModel;
import blueportal.finsandstails.client.render.state.SpindlyGemCrabRenderState;
import blueportal.finsandstails.common.entities.SpindlyGemCrabEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

public class SpindlyGemCrabRenderer extends MobRenderer<SpindlyGemCrabEntity, SpindlyGemCrabRenderState, SpindlyGemCrabModel> {
    private static final Identifier[] TEXTURES = new Identifier[] {
            FinsAndTails.id("textures/entity/spindly_gem_crab/emerald.png"),
            FinsAndTails.id("textures/entity/spindly_gem_crab/pearl.png"),
            FinsAndTails.id("textures/entity/spindly_gem_crab/sapphire.png"),
            FinsAndTails.id("textures/entity/spindly_gem_crab/ruby.png"),
            FinsAndTails.id("textures/entity/spindly_gem_crab/amber.png")
    };

    public SpindlyGemCrabRenderer(EntityRendererProvider.Context context) {
        super(context, new SpindlyGemCrabModel(context.bakeLayer(SpindlyGemCrabModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public SpindlyGemCrabRenderState createRenderState() {
        return new SpindlyGemCrabRenderState();
    }

    @Override
    public void extractRenderState(SpindlyGemCrabEntity entity, SpindlyGemCrabRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.moving = entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D;
        state.variant = entity.getVariant();
    }

    @Override
    public Identifier getTextureLocation(SpindlyGemCrabRenderState state) {
        return TEXTURES[Mth.clamp(state.variant, 0, TEXTURES.length - 1)];
    }
}
