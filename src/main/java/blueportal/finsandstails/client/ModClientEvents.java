package blueportal.finsandstails.client;

import blueportal.finsandstails.client.model.*;
import blueportal.finsandstails.client.model.armor.FwingedBootsModel;
import blueportal.finsandstails.client.model.armor.GopjetpackModel;
import blueportal.finsandstails.client.model.armor.HorateeJetpackModel;
import blueportal.finsandstails.client.model.armor.SpindlyCharmModel;
import blueportal.finsandstails.client.model.armor.SpindlyGemModel;
import blueportal.finsandstails.client.render.*;
import blueportal.finsandstails.client.render.layer.FTArmorLayer;
import blueportal.finsandstails.client.screen.CrabCruncherScreen;
import blueportal.finsandstails.client.screen.MudhorsePouchScreen;
import blueportal.finsandstails.impl.platform.ClientAbstraction;
import blueportal.finsandstails.registry.*;
import net.minecraft.client.model.geom.builders.CubeDeformation;

public class ModClientEvents {
    public static void register() {
        registerEntityLayers();
        registerEntityRenders();
        setupClient();
    }

    private static void registerEntityLayers() {
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.BANDED_REDBACK_SHRIMP, BandedRedbackShrimpModel::createBodyLayer);
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.GOLDEN_RIVER_RAY, GoldenRiverRayModel::createBodyLayer);
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.MUDHORSE, MudhorseModel::createBodyLayer);
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.ORNATE_BUGFISH, OrnateBugfishModel::createBodyLayer);
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.PHANTOM_NUDIBRANCH, PhantomNudibranchModel::createBodyLayer);
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.SWAMP_MUCKER, SwampMuckerModel::createBodyLayer);
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.TEAL_ARROWFISH, TealArrowfishModel::createBodyLayer);
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.TEAL_ARROWFISH_ARROW, TealArrowfishArrowModel::createBodyLayer);
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.WHERBLE, WherbleModel::createBodyLayer);
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.WHERBLING, WherbleModel::createWherblingBodyLayer);
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.GOPJET, GopjetModel::createBodyLayer);
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.GOPJETPACK, () -> GopjetpackModel.createArmorLayer(new CubeDeformation(0.0F)));
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.WEE, WeeModel::createBodyLayer);
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.PENGLIL, PenglilModel::createBodyLayer);
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.NIGHT_LIGHT_SQUID, NightLightSquidModel::createBodyLayer);
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.WANDERING_SAILOR, WanderingSailorModel::createBodyLayer);
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.HORATEE_JETPACK, () -> HorateeJetpackModel.createArmorLayer(FTArmorLayer.armorDeformation()));
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.FWINGED_BOOTS, () -> FwingedBootsModel.createArmorLayer(FTArmorLayer.armorDeformation()));
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.SPINDLY_CHARM, () -> SpindlyCharmModel.createArmorLayer(FTArmorLayer.armorDeformation()));
        ClientAbstraction.INSTANCE.registerEntityModelLayer(FTModelLayers.SPINDLY_GEM, () -> SpindlyGemModel.createArmorLayer(FTArmorLayer.armorDeformation()));
    }

    private static void registerEntityRenders() {
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.BANDED_REDBACK_SHRIMP, BandedRedbackShrimpRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.GOLDEN_RIVER_RAY, GoldenRiverRayRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.MUDHORSE, MudhorseRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.ORNATE_BUGFISH, OrnateBugfishRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.PHANTOM_NUDIBRANCH, PhantomNudibranchRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.SWAMP_MUCKER, SwampMuckerRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.TEAL_ARROWFISH_ARROW, TealArrowfishArrowRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.TEAL_ARROWFISH, TealArrowfishRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.WHERBLE, WherbleRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.GOPJET, GopjetRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.WEE, WeeRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.PENGLIL, PenglilRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.NIGHT_LIGHT_SQUID, NightLightSquidRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.WANDERING_SAILOR, WanderingSailorRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.RED_BULL_CRAB, RedBullCrabRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.WHITE_BULL_CRAB, WhiteBullCrabRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.FLATBACK_LEAF_SNAIL, FlatbackLeafSnailRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.FLATBACK_SUCKER, FlatbackSuckerRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.HIGH_FINNED_BLUE, HighFinnedBlueRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.WEE_WEE, WeeWeeRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.PAPA_WEE, PapaWeeRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.RIVER_PEBBLE_SNAIL, RiverPebbleSnailRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.RUBBER_BELLY_GLIDER, RubberBellyGliderRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.SIDEROL_WHISKERED_SNAIL, SiderolWhiskeredSnailRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.VIBRA_WEE, VibraWeeRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.SPINDLY_GEM_CRAB, SpindlyGemCrabRenderer::new);
        ClientAbstraction.INSTANCE.registerEntityRenderer(FTEntities.CROWNED_HORATEE, CrownedHorateeRenderer::new);
    }

    private static void setupClient() {
        ClientAbstraction.INSTANCE.registerScreen(FTContainers.MUDHORSE_POUCH, MudhorsePouchScreen::new);
        ClientAbstraction.INSTANCE.registerScreen(FTContainers.CRAB_CRUNCHER, CrabCruncherScreen::new);
    }
}
