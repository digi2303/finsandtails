
package blueportal.finsandstails.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.MudhorseModel;
import blueportal.finsandstails.common.entities.MudhorseEntity;
import blueportal.finsandstails.client.FTModelLayers;
public class MudhorseRenderer extends MobRenderer<MudhorseEntity, MudhorseModel<MudhorseEntity>> {
    private static final Identifier MUDHORSE_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/mudhorse/mudhorse.png");
    private static final Identifier MUDHORSE_POUCH_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/mudhorse/mudhorse_pouch.png");

    public MudhorseRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new MudhorseModel<>(ctx.bakeLayer(FTModelLayers.MUDHORSE)), 0.8F);
    }

    @Override
    public Identifier getTextureLocation(MudhorseEntity entity) {
        return MUDHORSE_LOCATION;
    }
}
