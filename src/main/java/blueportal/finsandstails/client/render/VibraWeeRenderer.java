package blueportal.finsandstails.client.render;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.VibraWeeModel;
import blueportal.finsandstails.client.render.state.VibraWeeRenderState;
import blueportal.finsandstails.common.entities.VibraWeeEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

public class VibraWeeRenderer extends MobRenderer<VibraWeeEntity, VibraWeeRenderState, VibraWeeModel> {
    private static final Identifier[] TEXTURES = new Identifier[] {
            FinsAndTails.id("textures/entity/vibra_wee/vibra_wee_1.png"),
            FinsAndTails.id("textures/entity/vibra_wee/vibra_wee_2.png"),
            FinsAndTails.id("textures/entity/vibra_wee/vibra_wee_3.png"),
            FinsAndTails.id("textures/entity/vibra_wee/vibra_wee_4.png"),
            FinsAndTails.id("textures/entity/vibra_wee/vibra_wee_5.png"),
            FinsAndTails.id("textures/entity/vibra_wee/vibra_wee_6.png"),
            FinsAndTails.id("textures/entity/vibra_wee/vibra_wee_7.png"),
            FinsAndTails.id("textures/entity/vibra_wee/vibra_wee_8.png"),
            FinsAndTails.id("textures/entity/vibra_wee/vibra_wee_9.png"),
            FinsAndTails.id("textures/entity/vibra_wee/vibra_wee_10.png"),
            FinsAndTails.id("textures/entity/vibra_wee/vibra_wee_11.png"),
            FinsAndTails.id("textures/entity/vibra_wee/vibra_wee_12.png"),
            FinsAndTails.id("textures/entity/vibra_wee/vibra_wee_13.png"),
            FinsAndTails.id("textures/entity/vibra_wee/vibra_wee_14.png"),
            FinsAndTails.id("textures/entity/vibra_wee/vibra_wee_15.png")
    };

    public VibraWeeRenderer(EntityRendererProvider.Context context) {
        super(context, new VibraWeeModel(context.bakeLayer(VibraWeeModel.LAYER_LOCATION)), 0.2F);
    }

    @Override
    public VibraWeeRenderState createRenderState() {
        return new VibraWeeRenderState();
    }

    @Override
    public void extractRenderState(VibraWeeEntity entity, VibraWeeRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.moving = entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D;
        state.variant = entity.getVariant();
    }

    @Override
    public Identifier getTextureLocation(VibraWeeRenderState state) {
        return TEXTURES[Mth.clamp(state.variant, 0, TEXTURES.length - 1)];
    }
}
