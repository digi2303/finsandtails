package blueportal.finsandstails.client.render;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.RiverPebbleSnailModel;
import blueportal.finsandstails.client.render.state.RiverPebbleSnailRenderState;
import blueportal.finsandstails.common.entities.RiverPebbleSnailEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

public class RiverPebbleSnailRenderer extends MobRenderer<RiverPebbleSnailEntity, RiverPebbleSnailRenderState, RiverPebbleSnailModel> {
    private static final Identifier[] TEXTURES = new Identifier[] {
            FinsAndTails.id("textures/entity/river_pebble_snail/river_pebble_snail_1.png"),
            FinsAndTails.id("textures/entity/river_pebble_snail/river_pebble_snail_2.png"),
            FinsAndTails.id("textures/entity/river_pebble_snail/river_pebble_snail_3.png"),
            FinsAndTails.id("textures/entity/river_pebble_snail/river_pebble_snail_4.png"),
            FinsAndTails.id("textures/entity/river_pebble_snail/river_pebble_snail_5.png"),
            FinsAndTails.id("textures/entity/river_pebble_snail/river_pebble_snail_6.png")
    };

    public RiverPebbleSnailRenderer(EntityRendererProvider.Context context) {
        super(context, new RiverPebbleSnailModel(context.bakeLayer(RiverPebbleSnailModel.LAYER_LOCATION)), 0.2F);
    }

    @Override
    public RiverPebbleSnailRenderState createRenderState() {
        return new RiverPebbleSnailRenderState();
    }

    @Override
    public void extractRenderState(RiverPebbleSnailEntity entity, RiverPebbleSnailRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.moving = entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D;
        state.variant = entity.getVariant();
        state.shimmer = entity.getShimmer();
    }

    @Override
    protected void scale(RiverPebbleSnailRenderState state, PoseStack poseStack) {
        super.scale(state, poseStack);
        if (state.isBaby) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        }
    }

    @Override
    public Identifier getTextureLocation(RiverPebbleSnailRenderState state) {
        return TEXTURES[Mth.clamp(state.variant, 0, TEXTURES.length - 1)];
    }
}
