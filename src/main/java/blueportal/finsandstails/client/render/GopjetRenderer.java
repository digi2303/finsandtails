
package blueportal.finsandstails.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.GopjetModel;
import blueportal.finsandstails.common.entities.GopjetEntity;
import blueportal.finsandstails.client.FTModelLayers;

public class GopjetRenderer extends MobRenderer<GopjetEntity, GopjetModel<GopjetEntity>> {
    private static final Identifier GOPJET_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/gopjet/gopjet.png");
    private static final Identifier GOPJET_BOOSTING_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/gopjet/gopjet_boosting.png");

    public GopjetRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new GopjetModel<>(ctx.bakeLayer(FTModelLayers.GOPJET)), 0.4F);
    }

    @Override
    public Identifier getTextureLocation(GopjetEntity entity) {
        return entity.isBoosting() ? GOPJET_BOOSTING_LOCATION : GOPJET_LOCATION;
    }
}
