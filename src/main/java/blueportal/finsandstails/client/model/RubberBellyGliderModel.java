package blueportal.finsandstails.client.model;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.render.state.RubberBellyGliderRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.util.Mth;

public class RubberBellyGliderModel extends EntityModel<RubberBellyGliderRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(FinsAndTails.id("rubber_belly_glider"), "main");

    private final ModelPart body;
    private final ModelPart leftWingFront;
    private final ModelPart leftHand;
    private final ModelPart rightHand;
    private final ModelPart leftWingBack;
    private final ModelPart tail;
    private final ModelPart tailFin;
    private final ModelPart horns;
    private final ModelPart rightWingBack;
    private final ModelPart throat;
    private final ModelPart rightWingFront;

    public RubberBellyGliderModel(ModelPart modelPart) {
        super(modelPart, RenderTypes::entityCutoutCull);
        this.body = modelPart.getChild("body");
        this.leftWingFront = this.body.getChild("leftWingFront");
        this.leftHand = this.body.getChild("leftHand");
        this.rightHand = this.body.getChild("rightHand");
        this.leftWingBack = this.body.getChild("leftWingBack");
        this.tail = this.body.getChild("tail");
        this.tailFin = this.tail.getChild("tailFin");
        this.horns = this.body.getChild("horns");
        this.rightWingBack = this.body.getChild("rightWingBack");
        this.throat = this.body.getChild("throat");
        this.rightWingFront = this.body.getChild("rightWingFront");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2F, -1.5F, -12F, 4F, 3F, 16F).mirror(false), PartPose.offset(0F, 22.5F, 4F));
        PartDefinition leftWingFront = body.addOrReplaceChild("leftWingFront", CubeListBuilder.create().texOffs(33, 34).mirror().addBox(-12F, 0F, -3.5F, 12F, 0F, 7F).mirror(false), PartPose.offset(-2F, -1F, -5.5F));
        PartDefinition leftHand = body.addOrReplaceChild("leftHand", CubeListBuilder.create().texOffs(37, 42).mirror().addBox(-6F, 0F, -1.5F, 6F, 0F, 3F).mirror(false), PartPose.offset(-2F, 0F, -4.5F));
        PartDefinition rightHand = body.addOrReplaceChild("rightHand", CubeListBuilder.create().texOffs(37, 42).addBox(0F, 0F, -2F, 6F, 0F, 3F), PartPose.offset(2F, 0F, -4F));
        PartDefinition leftWingBack = body.addOrReplaceChild("leftWingBack", CubeListBuilder.create().texOffs(-3, 13).addBox(-4F, 0F, -1F, 4F, 0F, 3F), PartPose.offset(-2F, 0F, 1F));
        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-1F, -1F, -1F, 2F, 2F, 14F).mirror(false), PartPose.offset(0F, 0F, 4F));
        PartDefinition tailFin = tail.addOrReplaceChild("tailFin", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0F, -6F, -1F, 0F, 10F, 16F).mirror(false), PartPose.offset(0F, 0F, 0F));
        PartDefinition horns = body.addOrReplaceChild("horns", CubeListBuilder.create().texOffs(0, 6).mirror().addBox(1.5F, -2F, -1F, 0F, 2F, 2F).mirror(false).texOffs(0, 6).mirror().addBox(-1.5F, -2F, -1F, 0F, 2F, 2F).mirror(false), PartPose.offset(0F, -1.5F, -10F));
        PartDefinition rightWingBack = body.addOrReplaceChild("rightWingBack", CubeListBuilder.create().texOffs(-3, 13).mirror().addBox(0F, 0F, -1F, 4F, 0F, 3F).mirror(false), PartPose.offset(2F, 0F, 1F));
        PartDefinition throat = body.addOrReplaceChild("throat", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-5F, 0.5F, -7F, 10F, 7F, 10F).mirror(false), PartPose.offset(0F, 0F, 0F));
        PartDefinition rightWingFront = body.addOrReplaceChild("rightWingFront", CubeListBuilder.create().texOffs(33, 34).addBox(0F, 0F, -3.5F, 12F, 0F, 7F), PartPose.offset(2F, -1F, -5.5F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(RubberBellyGliderRenderState state) {
        super.setupAnim(state);
        float baseTime = state.ageInTicks / 20.0F;

        if (state.moving && state.isInWater && state.puffed) {
            float animTime = baseTime;
            this.body.xRot = (Mth.cos(((animTime - 0.2F) * 180F) * Mth.DEG_TO_RAD) * (-2F)) * Mth.DEG_TO_RAD;
            this.body.yRot = (-(Mth.sin(((animTime - 0.15F) * 360F) * Mth.DEG_TO_RAD) * 5F)) * Mth.DEG_TO_RAD;
            this.body.y += -(0.5F + (Mth.sin(((animTime - 0F) * 90F) * Mth.DEG_TO_RAD) * 0.5F));
            this.leftWingFront.xRot = (9.92926F) * Mth.DEG_TO_RAD;
            this.leftWingFront.yRot = (-(-20.2935F)) * Mth.DEG_TO_RAD;
            this.leftWingFront.zRot = (-((-26.7814F) + (Mth.sin(((animTime - 0.35F) * 360F) * Mth.DEG_TO_RAD) * 12F))) * Mth.DEG_TO_RAD;
            this.leftWingBack.xRot = (4.11405F) * Mth.DEG_TO_RAD;
            this.leftWingBack.yRot = (-(-22.1399F)) * Mth.DEG_TO_RAD;
            this.leftWingBack.zRot = (-((-10.8052F) + (Mth.cos(((animTime - 0.35F) * 360F) * Mth.DEG_TO_RAD) * 12F))) * Mth.DEG_TO_RAD;
            this.tail.yRot = (-(Mth.sin(((animTime - 0.35F) * 360F) * Mth.DEG_TO_RAD) * 18F)) * Mth.DEG_TO_RAD;
            this.rightWingBack.xRot = (4.11405F) * Mth.DEG_TO_RAD;
            this.rightWingBack.yRot = (-(22.1399F)) * Mth.DEG_TO_RAD;
            this.rightWingBack.zRot = (-(10.8052F + (Mth.cos(((animTime - 0.35F) * 360F) * Mth.DEG_TO_RAD) * (-12F)))) * Mth.DEG_TO_RAD;
            this.rightWingFront.xRot = (9.00717F) * Mth.DEG_TO_RAD;
            this.rightWingFront.yRot = (-(20.7048F)) * Mth.DEG_TO_RAD;
            this.rightWingFront.zRot = (-(24.1487F + (Mth.sin(((animTime - 0.35F) * 360F) * Mth.DEG_TO_RAD) * (-12F)))) * Mth.DEG_TO_RAD;
            this.leftHand.xRot = (5.123F) * Mth.DEG_TO_RAD;
            this.leftHand.yRot = (-(-21.9386F)) * Mth.DEG_TO_RAD;
            this.leftHand.zRot = (-((-13.4937F) + (Mth.cos(((animTime - 0.35F) * 180F) * Mth.DEG_TO_RAD) * 18F))) * Mth.DEG_TO_RAD;
            this.rightHand.xRot = (5.123F) * Mth.DEG_TO_RAD;
            this.rightHand.yRot = (-(21.9386F)) * Mth.DEG_TO_RAD;
            this.rightHand.zRot = (-(13.4936F + (Mth.cos(((animTime - 0.35F) * 180F) * Mth.DEG_TO_RAD) * (-18F)))) * Mth.DEG_TO_RAD;
        } else if (state.moving && state.isInWater) {
            float animTime = baseTime;
            this.body.xRot = (Mth.cos(((animTime - 0.2F) * 180F) * Mth.DEG_TO_RAD) * (-2F)) * Mth.DEG_TO_RAD;
            this.body.yRot = (-(Mth.sin(((animTime - 0.15F) * 360F) * Mth.DEG_TO_RAD) * 5F)) * Mth.DEG_TO_RAD;
            this.body.y += -(0.5F + (Mth.sin(((animTime - 0F) * 90F) * Mth.DEG_TO_RAD) * 0.5F));
            this.leftWingFront.yRot = (-(-22.5F)) * Mth.DEG_TO_RAD;
            this.leftWingFront.zRot = (-(0F + (Mth.sin(((animTime - 0.35F) * 360F) * Mth.DEG_TO_RAD) * 12F))) * Mth.DEG_TO_RAD;
            this.leftWingBack.yRot = (-(-22.5F)) * Mth.DEG_TO_RAD;
            this.leftWingBack.zRot = (-(0F + (Mth.cos(((animTime - 0.35F) * 360F) * Mth.DEG_TO_RAD) * 12F))) * Mth.DEG_TO_RAD;
            this.tail.yRot = (-(Mth.sin(((animTime - 0.35F) * 360F) * Mth.DEG_TO_RAD) * 18F)) * Mth.DEG_TO_RAD;
            this.rightWingBack.yRot = (-(22.5F)) * Mth.DEG_TO_RAD;
            this.rightWingBack.zRot = (-(0F + (Mth.cos(((animTime - 0.35F) * 360F) * Mth.DEG_TO_RAD) * (-12F)))) * Mth.DEG_TO_RAD;
            this.throat.xScale = 0.2F;
            this.throat.yScale = 0.1F;
            this.rightWingFront.yRot = (-(22.5F)) * Mth.DEG_TO_RAD;
            this.rightWingFront.zRot = (-(0F + (Mth.sin(((animTime - 0.35F) * 360F) * Mth.DEG_TO_RAD) * (-12F)))) * Mth.DEG_TO_RAD;
            this.leftHand.xRot = (-9.00717F) * Mth.DEG_TO_RAD;
            this.leftHand.yRot = (-(-20.7048F)) * Mth.DEG_TO_RAD;
            this.leftHand.zRot = (-(24.1486F + (Mth.cos(((animTime - 0.35F) * 180F) * Mth.DEG_TO_RAD) * 18F))) * Mth.DEG_TO_RAD;
            this.rightHand.xRot = (-9.92926F) * Mth.DEG_TO_RAD;
            this.rightHand.yRot = (-(20.2935F)) * Mth.DEG_TO_RAD;
            this.rightHand.zRot = (-((-26.7813F) + (Mth.cos(((animTime - 0.35F) * 180F) * Mth.DEG_TO_RAD) * (-18F)))) * Mth.DEG_TO_RAD;
        } else if (state.isInWater && state.puffed) {
            float animTime = baseTime;
            this.body.xRot = (Mth.cos(((animTime - 0.2F) * 180F) * Mth.DEG_TO_RAD) * (-3F)) * Mth.DEG_TO_RAD;
            this.body.y += -(Mth.sin(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * 0.25F);
            this.leftWingFront.yRot = (-(-22.5F)) * Mth.DEG_TO_RAD;
            this.leftWingFront.zRot = (-((-10F) + (Mth.sin(((animTime - 0.35F) * 180F) * Mth.DEG_TO_RAD) * (-6F)))) * Mth.DEG_TO_RAD;
            this.leftWingBack.yRot = (-(-22.5F)) * Mth.DEG_TO_RAD;
            this.leftWingBack.zRot = (-(Mth.cos(((animTime - 0.35F) * 180F) * Mth.DEG_TO_RAD) * (-6F))) * Mth.DEG_TO_RAD;
            this.tail.xRot = (Mth.sin(((animTime - 0.25F) * 180F) * Mth.DEG_TO_RAD) * 6F) * Mth.DEG_TO_RAD;
            this.rightWingBack.yRot = (-(22.5F)) * Mth.DEG_TO_RAD;
            this.rightWingBack.zRot = (-(Mth.cos(((animTime - 0.35F) * 180F) * Mth.DEG_TO_RAD) * 6F)) * Mth.DEG_TO_RAD;
            this.rightWingFront.yRot = (-(22.5F)) * Mth.DEG_TO_RAD;
            this.rightWingFront.zRot = (-(10F + (Mth.sin(((animTime - 0.35F) * 180F) * Mth.DEG_TO_RAD) * 6F))) * Mth.DEG_TO_RAD;
            this.leftHand.zRot = (-((-3F) + (Mth.sin(((animTime - 0.35F) * 90F) * Mth.DEG_TO_RAD) * (-12F)))) * Mth.DEG_TO_RAD;
            this.rightHand.zRot = (-(3F + (Mth.sin(((animTime - 0.35F) * 90F) * Mth.DEG_TO_RAD) * 12F))) * Mth.DEG_TO_RAD;
        } else if (state.isInWater) {
            float animTime = baseTime;
            this.body.xRot = (Mth.cos(((animTime - 0.2F) * 180F) * Mth.DEG_TO_RAD) * (-3F)) * Mth.DEG_TO_RAD;
            this.body.y += -(Mth.sin(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * 0.25F);
            this.leftWingFront.yRot = (-(-22.5F)) * Mth.DEG_TO_RAD;
            this.leftWingFront.zRot = (-(Mth.sin(((animTime - 0.35F) * 180F) * Mth.DEG_TO_RAD) * (-6F))) * Mth.DEG_TO_RAD;
            this.leftWingBack.yRot = (-(-22.5F)) * Mth.DEG_TO_RAD;
            this.leftWingBack.zRot = (-(Mth.cos(((animTime - 0.35F) * 180F) * Mth.DEG_TO_RAD) * (-6F))) * Mth.DEG_TO_RAD;
            this.tail.xRot = (Mth.sin(((animTime - 0.25F) * 180F) * Mth.DEG_TO_RAD) * 6F) * Mth.DEG_TO_RAD;
            this.rightWingBack.yRot = (-(22.5F)) * Mth.DEG_TO_RAD;
            this.rightWingBack.zRot = (-(Mth.cos(((animTime - 0.35F) * 180F) * Mth.DEG_TO_RAD) * 6F)) * Mth.DEG_TO_RAD;
            this.throat.xScale = 0.2F;
            this.throat.yScale = 0.1F;
            this.rightWingFront.yRot = (-(22.5F)) * Mth.DEG_TO_RAD;
            this.rightWingFront.zRot = (-(Mth.sin(((animTime - 0.35F) * 180F) * Mth.DEG_TO_RAD) * 6F)) * Mth.DEG_TO_RAD;
            this.leftHand.zRot = (-(22.5F + (Mth.sin(((animTime - 0.35F) * 90F) * Mth.DEG_TO_RAD) * (-12F)))) * Mth.DEG_TO_RAD;
            this.rightHand.zRot = (-((-22.5F) + (Mth.sin(((animTime - 0.35F) * 90F) * Mth.DEG_TO_RAD) * 12F))) * Mth.DEG_TO_RAD;
        } else if (state.moving) {
            float animTime = baseTime * 1.45F;
            this.body.xRot = ((-2.5F) + (Mth.sin(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * (-2.5F))) * Mth.DEG_TO_RAD;
            this.body.yRot = (-(Mth.cos(((animTime - 0F) * 90F) * Mth.DEG_TO_RAD) * 5F)) * Mth.DEG_TO_RAD;
            this.leftWingFront.yRot = (-(-70F)) * Mth.DEG_TO_RAD;
            this.leftHand.yRot = (-(Mth.cos(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * (-20F))) * Mth.DEG_TO_RAD;
            this.leftHand.zRot = (-(10F + (Mth.sin(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * (-10F)))) * Mth.DEG_TO_RAD;
            this.rightHand.yRot = (-(Mth.cos(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * 20F)) * Mth.DEG_TO_RAD;
            this.rightHand.zRot = (-((-10F) + (Mth.sin(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * 10F))) * Mth.DEG_TO_RAD;
            this.leftWingBack.yRot = (-(Mth.cos(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * 20F)) * Mth.DEG_TO_RAD;
            this.leftWingBack.zRot = (-(10F + (Mth.sin(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * 10F))) * Mth.DEG_TO_RAD;
            this.tail.xRot = (12.5F) * Mth.DEG_TO_RAD;
            this.tail.yRot = (-(0F + (Mth.sin(((animTime - 0F) * 90F) * Mth.DEG_TO_RAD) * 10F))) * Mth.DEG_TO_RAD;
            this.rightWingBack.yRot = (-(Mth.cos(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * (-20F))) * Mth.DEG_TO_RAD;
            this.rightWingBack.zRot = (-((-10F) + (Mth.sin(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * (-10F)))) * Mth.DEG_TO_RAD;
            this.throat.xScale = 0.2F;
            this.throat.yScale = 0.1F;
            this.rightWingFront.yRot = (-(70F)) * Mth.DEG_TO_RAD;
        } else {
            float animTime = baseTime;
            this.leftWingFront.yRot = (-(-70F)) * Mth.DEG_TO_RAD;
            this.leftHand.zRot = (-(15F)) * Mth.DEG_TO_RAD;
            this.rightHand.zRot = (-(-15F)) * Mth.DEG_TO_RAD;
            this.leftWingBack.zRot = (-(22.5F)) * Mth.DEG_TO_RAD;
            this.tail.xRot = (-3.47875F) * Mth.DEG_TO_RAD;
            this.tail.yRot = (-(6.6485F + (Mth.sin(((animTime - 0F) * 90F) * Mth.DEG_TO_RAD) * 6F))) * Mth.DEG_TO_RAD;
            this.tail.zRot = (-(62.2979F)) * Mth.DEG_TO_RAD;
            this.rightWingBack.zRot = (-(-22.5F)) * Mth.DEG_TO_RAD;
            this.throat.xScale = 0.2F;
            this.throat.yScale = 0.1F;
            this.rightWingFront.yRot = (-(70F)) * Mth.DEG_TO_RAD;
        }
    }
}
