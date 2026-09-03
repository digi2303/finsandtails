
package blueportal.finsandstails.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.OrnateBugfishModel;
import blueportal.finsandstails.common.entities.OrnateBugfishEntity;
import blueportal.finsandstails.client.FTModelLayers;

public class OrnateBugfishRenderer extends MobRenderer<OrnateBugfishEntity, OrnateBugfishModel<OrnateBugfishEntity>> {
    private static final Identifier ORNATE_BUGFISH_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/ornate_bugfish/ornate_bugfish.png");

    public OrnateBugfishRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new OrnateBugfishModel<>(ctx.bakeLayer(FTModelLayers.ORNATE_BUGFISH)), 0.3f);
    }

    @Override
    public Identifier getTextureLocation(OrnateBugfishEntity entity) {
        return ORNATE_BUGFISH_LOCATION;
    }
}
