
package blueportal.finsandstails.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.GoldenRiverRayModel;
import blueportal.finsandstails.common.entities.GoldenRiverRayEntity;
import blueportal.finsandstails.client.FTModelLayers;
public class GoldenRiverRayRenderer extends MobRenderer<GoldenRiverRayEntity, GoldenRiverRayModel<GoldenRiverRayEntity>> {
    private static final Identifier GOLDEN_RIVER_RAY_LOCATION_0 = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/golden_river_ray/golden_river_ray_0.png");
    private static final Identifier GOLDEN_RIVER_RAY_LOCATION_1 = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/golden_river_ray/golden_river_ray_1.png");
    private static final Identifier GOLDEN_RIVER_RAY_LOCATION_2 = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/golden_river_ray/golden_river_ray_2.png");

    public GoldenRiverRayRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new GoldenRiverRayModel<>(ctx.bakeLayer(FTModelLayers.GOLDEN_RIVER_RAY)), 0.3f);
    }

    @Override
    public Identifier getTextureLocation(GoldenRiverRayEntity entity) {

        return switch (entity.getVariant()) {
            case 1 -> GOLDEN_RIVER_RAY_LOCATION_1;
            case 2 -> GOLDEN_RIVER_RAY_LOCATION_2;
            default -> GOLDEN_RIVER_RAY_LOCATION_0;
        };
    }

}
