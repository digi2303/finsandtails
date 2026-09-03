package blueportal.finsandstails.client;

import com.google.common.reflect.Reflection;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.resources.Identifier;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.*;
import blueportal.finsandstails.client.model.armor.GopjetpackModel;
import blueportal.finsandstails.client.render.*;
import blueportal.finsandstails.client.screen.CrabCruncherScreen;
import blueportal.finsandstails.client.screen.MudhorsePouchScreen;
import blueportal.finsandstails.registry.*;

@Mod.EventBusSubscriber(modid = FinsAndTails.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(FTModelLayers.BANDED_REDBACK_SHRIMP, BandedRedbackShrimpModel::createBodyLayer);
        event.registerLayerDefinition(FTModelLayers.GOLDEN_RIVER_RAY, GoldenRiverRayModel::createBodyLayer);
        event.registerLayerDefinition(FTModelLayers.MUDHORSE, MudhorseModel::createBodyLayer);
        event.registerLayerDefinition(FTModelLayers.ORNATE_BUGFISH, OrnateBugfishModel::createBodyLayer);
        event.registerLayerDefinition(FTModelLayers.PHANTOM_NUDIBRANCH, PhantomNudibranchModel::createBodyLayer);
        event.registerLayerDefinition(FTModelLayers.SWAMP_MUCKER, SwampMuckerModel::createBodyLayer);
        event.registerLayerDefinition(FTModelLayers.TEAL_ARROWFISH, TealArrowfishModel::createBodyLayer);
        event.registerLayerDefinition(FTModelLayers.TEAL_ARROWFISH_ARROW, TealArrowfishArrowModel::createBodyLayer);
        event.registerLayerDefinition(FTModelLayers.WHERBLE, WherbleModel::createBodyLayer);
        event.registerLayerDefinition(FTModelLayers.WHERBLING, WherbleModel::createWherblingBodyLayer);
        event.registerLayerDefinition(FTModelLayers.GOPJET, GopjetModel::createBodyLayer);
        event.registerLayerDefinition(FTModelLayers.GOPJETPACK, () -> GopjetpackModel.createArmorLayer(new CubeDeformation(0.0F)));
        event.registerLayerDefinition(FTModelLayers.WEE, WeeModel::createBodyLayer);
        event.registerLayerDefinition(FTModelLayers.PENGLIL, PenglilModel::createBodyLayer);
        event.registerLayerDefinition(FTModelLayers.NIGHT_LIGHT_SQUID, NightLightSquidModel::createBodyLayer);
        event.registerLayerDefinition(FTModelLayers.WANDERING_SAILOR, WanderingSailorModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        Reflection.initialize(FTModelLayers.class);

        event.registerEntityRenderer(FTEntities.BANDED_REDBACK_SHRIMP, BandedRedbackShrimpRenderer::new);
        event.registerEntityRenderer(FTEntities.GOLDEN_RIVER_RAY, GoldenRiverRayRenderer::new);
        event.registerEntityRenderer(FTEntities.MUDHORSE, MudhorseRenderer::new);
        event.registerEntityRenderer(FTEntities.ORNATE_BUGFISH, OrnateBugfishRenderer::new);
        event.registerEntityRenderer(FTEntities.PHANTOM_NUDIBRANCH, PhantomNudibranchRenderer::new);
        event.registerEntityRenderer(FTEntities.SWAMP_MUCKER, SwampMuckerRenderer::new);
        event.registerEntityRenderer(FTEntities.TEAL_ARROWFISH_ARROW, TealArrowfishArrowRenderer::new);
        event.registerEntityRenderer(FTEntities.TEAL_ARROWFISH, TealArrowfishRenderer::new);
        event.registerEntityRenderer(FTEntities.WHERBLE, WherbleRenderer::new);
        event.registerEntityRenderer(FTEntities.GOPJET, GopjetRenderer::new);
        event.registerEntityRenderer(FTEntities.WEE, WeeRenderer::new);
        event.registerEntityRenderer(FTEntities.PENGLIL, PenglilRenderer::new);
        event.registerEntityRenderer(FTEntities.NIGHT_LIGHT_SQUID, NightLightSquidRenderer::new);
        event.registerEntityRenderer(FTEntities.WANDERING_SAILOR, WanderingSailorRenderer::new);

        event.registerEntityRenderer(FTEntities.RED_BULL_CRAB, RedBullCrabRenderer::new);
        event.registerEntityRenderer(FTEntities.WHITE_BULL_CRAB, WhiteBullCrabRenderer::new);
        event.registerEntityRenderer(FTEntities.FLATBACK_LEAF_SNAIL, FlatbackLeafSnailRenderer::new);
        event.registerEntityRenderer(FTEntities.FLATBACK_SUCKER, FlatbackSuckerRenderer::new);
        event.registerEntityRenderer(FTEntities.HIGH_FINNED_BLUE, HighFinnedBlueRenderer::new);
        event.registerEntityRenderer(FTEntities.WEE_WEE, WeeWeeRenderer::new);
        event.registerEntityRenderer(FTEntities.PAPA_WEE, PapaWeeRenderer::new);
        event.registerEntityRenderer(FTEntities.RIVER_PEBBLE_SNAIL, RiverPebbleSnailRenderer::new);
        event.registerEntityRenderer(FTEntities.RUBBER_BELLY_GLIDER, RubberBellyGliderRenderer::new);
        event.registerEntityRenderer(FTEntities.SIDEROL_WHISKERED_SNAIL, SiderolWhiskeredSnailRenderer::new);
        event.registerEntityRenderer(FTEntities.VIBRA_WEE, VibraWeeRenderer::new);
        event.registerEntityRenderer(FTEntities.SPINDLY_GEM_CRAB, SpindlyGemCrabRenderer::new);
        event.registerEntityRenderer(FTEntities.CROWNED_HORATEE, CrownedHorateeRenderer::new);
    }

    @SubscribeEvent
    public static void setupClient(FMLClientSetupEvent event) {
        MenuScreens.register(FTContainers.MUDHORSE_POUCH, MudhorsePouchScreen::new);
        MenuScreens.register(FTContainers.CRAB_CRUNCHER, CrabCruncherScreen::new);
        event.enqueueWork(FTItemProperties::setupItemProperties);
    }

}
