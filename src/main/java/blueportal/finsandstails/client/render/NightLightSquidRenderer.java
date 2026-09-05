package blueportal.finsandstails.client.render;

import blueportal.finsandstails.client.render.state.NightLightSquidRenderState;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.NightLightSquidModel;
import blueportal.finsandstails.common.entities.NightLightSquidEntity;
import blueportal.finsandstails.client.FTModelLayers;
import com.google.common.collect.Maps;
import net.minecraft.util.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

import java.util.Map;
import net.minecraft.client.renderer.entity.layers.LivingEntityEmissiveLayer;
import net.minecraft.client.renderer.rendertype.RenderTypes;

public class NightLightSquidRenderer extends MobRenderer<NightLightSquidEntity, NightLightSquidRenderState, NightLightSquidModel> {
    public static final Map<Integer, Identifier> NIGHT_LIGHT_SQUID_LOCATIONS = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(0, Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/entity/night_light_squid/night_light_squid_1.png"));
        hashMap.put(1, Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/entity/night_light_squid/night_light_squid_2.png"));
        hashMap.put(2, Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/entity/night_light_squid/night_light_squid_3.png"));
        hashMap.put(3, Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/entity/night_light_squid/night_light_squid_4.png"));
    });
    private static final Identifier NIGHT_LIGHT_SQUID_GLOW_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID,"textures/entity/night_light_squid/night_light_squid_glow.png");

    public NightLightSquidRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new NightLightSquidModel(ctx.bakeLayer(FTModelLayers.NIGHT_LIGHT_SQUID)), 0.25f);
        addLayer(new LivingEntityEmissiveLayer<>(this, (p_234792_) -> NIGHT_LIGHT_SQUID_GLOW_LOCATION, (p_234793_, p_234794_) -> {
            return Math.max(0.0F, Mth.cos(p_234794_ * 0.1F));
        }, this.getModel(), RenderTypes::entityTranslucentEmissive, false));
    }

    @Override
    public NightLightSquidRenderState createRenderState() {
        return new NightLightSquidRenderState();
    }

    @Override
    public void extractRenderState(NightLightSquidEntity entity, NightLightSquidRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.variant = entity.getVariant();
    }

    @Override
    public Identifier getTextureLocation(NightLightSquidRenderState state) {
        return NIGHT_LIGHT_SQUID_LOCATIONS.getOrDefault(state.variant, NIGHT_LIGHT_SQUID_LOCATIONS.get(0));
    }
}
