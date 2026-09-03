
package blueportal.finsandstails.client.render;

import blueportal.finsandstails.client.render.state.OrnateBugfishRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.OrnateBugfishModel;
import blueportal.finsandstails.common.entities.OrnateBugfishEntity;
import blueportal.finsandstails.client.FTModelLayers;

public class OrnateBugfishRenderer extends MobRenderer<OrnateBugfishEntity, OrnateBugfishRenderState, OrnateBugfishModel> {
    private static final Identifier ORNATE_BUGFISH_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/ornate_bugfish/ornate_bugfish.png");

    public OrnateBugfishRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new OrnateBugfishModel(ctx.bakeLayer(FTModelLayers.ORNATE_BUGFISH)), 0.3f);
    }

    @Override
    public OrnateBugfishRenderState createRenderState() {
        return new OrnateBugfishRenderState();
    }

    @Override
    public void extractRenderState(OrnateBugfishEntity entity, OrnateBugfishRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
    }

    @Override
    public Identifier getTextureLocation(OrnateBugfishRenderState state) {
        return ORNATE_BUGFISH_LOCATION;
    }
}
