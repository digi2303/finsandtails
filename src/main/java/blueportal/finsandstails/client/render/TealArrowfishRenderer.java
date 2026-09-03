
package blueportal.finsandstails.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.TealArrowfishModel;
import blueportal.finsandstails.common.entities.TealArrowfishEntity;
import blueportal.finsandstails.client.FTModelLayers;

public class TealArrowfishRenderer extends MobRenderer<TealArrowfishEntity, TealArrowfishModel<TealArrowfishEntity>> {
    private static final Identifier TEAL_ARROWFISH_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/teal_arrowfish/teal_arrowfish.png");

    public TealArrowfishRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new TealArrowfishModel<>(ctx.bakeLayer(FTModelLayers.TEAL_ARROWFISH)), 0.3F);
    }

    @Override
    public Identifier getTextureLocation(TealArrowfishEntity entity) {
        return TEAL_ARROWFISH_LOCATION;
    }
}
