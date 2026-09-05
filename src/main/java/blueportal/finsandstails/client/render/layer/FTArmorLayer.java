package blueportal.finsandstails.client.render.layer;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.FTModelLayers;
import blueportal.finsandstails.client.model.armor.FwingedBootsModel;
import blueportal.finsandstails.client.model.armor.GopjetpackModel;
import blueportal.finsandstails.client.model.armor.HorateeJetpackModel;
import blueportal.finsandstails.client.model.armor.SpindlyCharmModel;
import blueportal.finsandstails.client.model.armor.SpindlyGemModel;
import blueportal.finsandstails.common.items.ArmoredGopjetJetpackItem;
import blueportal.finsandstails.common.items.FwingedBootsItem;
import blueportal.finsandstails.common.items.GopjetpackItem;
import blueportal.finsandstails.common.items.SpindlyCharmItem;
import blueportal.finsandstails.common.items.SpindlyGemCharmItem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import blueportal.finsandstails.client.FinsRenderState;

public class FTArmorLayer extends RenderLayer<AvatarRenderState, PlayerModel> {
    private static final Identifier GOPJETPACK_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/models/armor/gopjet_jetpack_layer_1.png");
    private static final Identifier HORATEE_JETPACK_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/armor/horatee_jetpack.png");
    private static final Identifier FWINGED_BOOTS_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/armor/fwinged_boots.png");
    private static final Identifier GEM_CRAB_AMULET_LOCATION = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/armor/gem_crab_amulet.png");

    private final GopjetpackModel gopjetpack;
    private final HorateeJetpackModel<AvatarRenderState> horateeJetpack;
    private final FwingedBootsModel<AvatarRenderState> fwingedBoots;
    private final SpindlyCharmModel<AvatarRenderState> spindlyCharm;
    private final SpindlyGemModel<AvatarRenderState> spindlyGem;

    public FTArmorLayer(RenderLayerParent<AvatarRenderState, PlayerModel> parent, EntityModelSet models) {
        super(parent);
        this.gopjetpack = new GopjetpackModel(models.bakeLayer(FTModelLayers.GOPJETPACK));
        this.horateeJetpack = new HorateeJetpackModel<>(models.bakeLayer(FTModelLayers.HORATEE_JETPACK));
        this.fwingedBoots = new FwingedBootsModel<>(models.bakeLayer(FTModelLayers.FWINGED_BOOTS));
        this.spindlyCharm = new SpindlyCharmModel<>(models.bakeLayer(FTModelLayers.SPINDLY_CHARM));
        this.spindlyGem = new SpindlyGemModel<>(models.bakeLayer(FTModelLayers.SPINDLY_GEM));
    }

    public static CubeDeformation armorDeformation() {
        return new CubeDeformation(0.0F);
    }

    @Override
    public void submit(PoseStack poseStack, SubmitNodeCollector collector, int light, AvatarRenderState state, float p1, float p2) {
        if (state.isInvisible) {
            return;
        }

        this.submitPiece(poseStack, collector, light, state, ((FinsRenderState) state).finsandtails$getChestItem(), EquipmentSlot.CHEST);
        this.submitPiece(poseStack, collector, light, state, ((FinsRenderState) state).finsandtails$getFeetItem(), EquipmentSlot.FEET);
    }

    private void submitPiece(PoseStack poseStack, SubmitNodeCollector collector, int light, AvatarRenderState state, ItemStack stack, EquipmentSlot slot) {
        Item item = stack.getItem();
        HumanoidModel<AvatarRenderState> model;
        Identifier texture;

        if (item instanceof GopjetpackItem) {
            model = this.gopjetpack;
            texture = GOPJETPACK_LOCATION;
        } else if (item instanceof ArmoredGopjetJetpackItem) {
            model = this.horateeJetpack;
            texture = HORATEE_JETPACK_LOCATION;
        } else if (item instanceof FwingedBootsItem) {
            model = this.fwingedBoots;
            texture = FWINGED_BOOTS_LOCATION;
        } else if (item instanceof SpindlyCharmItem charm) {
            model = this.spindlyCharm;
            texture = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/armor/spindly_" + charm.getTypeName() + "_charm.png");
        } else if (item instanceof SpindlyGemCharmItem) {
            model = this.spindlyGem;
            texture = GEM_CRAB_AMULET_LOCATION;
        } else {
            return;
        }

        model.setupAnim(state);
        boolean feet = slot == EquipmentSlot.FEET;
        model.head.visible = false;
        model.hat.visible = false;
        model.body.visible = !feet;
        model.rightArm.visible = !feet;
        model.leftArm.visible = !feet;
        model.rightLeg.visible = feet;
        model.leftLeg.visible = feet;

        collector.submitModel(model, state, poseStack, RenderTypes.armorCutoutNoCull(texture), light, LivingEntityRenderer.getOverlayCoords(state, 0.0F), state.outlineColor, null);
    }
}
