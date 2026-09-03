package blueportal.finsandstails.client.model;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.render.state.SpindlyGemCrabRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import blueportal.finsandstails.client.animation.FTKeyframes;
import blueportal.finsandstails.client.animation.FTKeyframes.Easing;
import net.minecraft.util.Mth;

public class SpindlyGemCrabModel extends EntityModel<SpindlyGemCrabRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(FinsAndTails.id("spindly_gem_crab"), "main");

    private final ModelPart body;
    private final ModelPart tail;
    private final ModelPart antemnas;
    private final ModelPart leftLegMid;
    private final ModelPart rightLegMid;
    private final ModelPart leftLegFront;
    private final ModelPart rightLegFront;
    private final ModelPart leftLegBack;
    private final ModelPart rightLegBack;
    private final ModelPart rightPincher;
    private final ModelPart leftPincher;

    public SpindlyGemCrabModel(ModelPart modelPart) {
        super(modelPart, RenderTypes::entityTranslucent);
        this.body = modelPart.getChild("body");
        this.tail = this.body.getChild("tail");
        this.antemnas = this.body.getChild("antemnas");
        this.leftLegMid = this.body.getChild("left_leg_mid");
        this.rightLegMid = this.body.getChild("right_leg_mid");
        this.leftLegFront = this.body.getChild("left_leg_front");
        this.rightLegFront = this.body.getChild("right_leg_front");
        this.leftLegBack = this.body.getChild("left_leg_back");
        this.rightLegBack = this.body.getChild("right_leg_back");
        this.rightPincher = this.body.getChild("right_pincher");
        this.leftPincher = this.body.getChild("left_pincher");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(1, 0).mirror().addBox(-1.5F, -1.5F, -2.5F, 3F, 3F, 5F).mirror(false), PartPose.offset(0F, 21.6F, 0F));
        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(-2F, 0F, 0F, 4F, 1F, 4F).mirror(false), PartPose.offsetAndRotation(0F, -0.5F, 2.5F, -0.6981F, 0F, 0F));
        PartDefinition antemnas = body.addOrReplaceChild("antemnas", CubeListBuilder.create().texOffs(14, 6).mirror().addBox(-1F, -1.5F, -3F, 2F, 2F, 3F).mirror(false), PartPose.offset(0F, 0.5F, -2.5F));
        PartDefinition leftLegMid = body.addOrReplaceChild("left_leg_mid", CubeListBuilder.create().texOffs(26, 0).mirror().addBox(-2F, 0F, -0.5F, 2F, 1F, 1F).mirror(false), PartPose.offsetAndRotation(-1.5F, 1F, -1F, 0F, -0.7854F, -0.3491F));
        PartDefinition rightLegMid = body.addOrReplaceChild("right_leg_mid", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0F, 0F, -0.5F, 2F, 1F, 1F).mirror(false), PartPose.offsetAndRotation(1.5F, 1F, -1F, 0F, 0.7854F, 0.3491F));
        PartDefinition leftLegFront = body.addOrReplaceChild("left_leg_front", CubeListBuilder.create().texOffs(26, 0).mirror().addBox(-2F, 0F, -0.5F, 2F, 1F, 1F).mirror(false), PartPose.offsetAndRotation(-1.5F, 1F, 0F, 0F, 0F, -0.3491F));
        PartDefinition rightLegFront = body.addOrReplaceChild("right_leg_front", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0F, 0F, -0.5F, 2F, 1F, 1F).mirror(false), PartPose.offsetAndRotation(1.5F, 1F, 0F, 0F, 0F, 0.3491F));
        PartDefinition leftLegBack = body.addOrReplaceChild("left_leg_back", CubeListBuilder.create().texOffs(26, 0).mirror().addBox(-2F, 0F, -0.5F, 2F, 1F, 1F).mirror(false), PartPose.offsetAndRotation(-1.5F, 1F, 1F, 0F, 0.7854F, -0.3491F));
        PartDefinition rightLegBack = body.addOrReplaceChild("right_leg_back", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0F, 0F, -0.5F, 2F, 1F, 1F).mirror(false), PartPose.offsetAndRotation(1.5F, 1F, 1F, 0F, -0.7854F, 0.3491F));
        PartDefinition rightPincher = body.addOrReplaceChild("right_pincher", CubeListBuilder.create().texOffs(0, 8).mirror().addBox(-3F, 0F, -4F, 3F, 1F, 4F).mirror(false), PartPose.offsetAndRotation(1.5F, 0.5F, -2.5F, 0F, -0.7854F, 0F));
        PartDefinition leftPincher = body.addOrReplaceChild("left_pincher", CubeListBuilder.create().texOffs(18, 11).mirror().addBox(0F, 0F, -4F, 3F, 1F, 4F).mirror(false), PartPose.offsetAndRotation(-1.5F, 0.5F, -2.5F, 0F, 0.7854F, 0F));

        return LayerDefinition.create(meshdefinition, 32, 16);
    }

    @Override
    public void setupAnim(SpindlyGemCrabRenderState state) {
        super.setupAnim(state);
        float animTime = state.ageInTicks / 20.0F;

        if (state.moving) {
            this.tail.xRot = (15F + (Mth.sin(((animTime - 0.2F) * 180F) * Mth.DEG_TO_RAD) * 5F)) * Mth.DEG_TO_RAD;
            this.rightPincher.xRot = (10F) * Mth.DEG_TO_RAD;
            this.rightPincher.yRot = (-((-15F) + (Mth.sin(((animTime - 0F) * 90F) * Mth.DEG_TO_RAD) * (-5F)))) * Mth.DEG_TO_RAD;
            this.body.zRot = (-(Mth.sin(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * 1F)) * Mth.DEG_TO_RAD;
            float t0 = Math.min(animTime, 2F);
            this.leftLegMid.xRot = (FTKeyframes.keyframe(t0, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{46.908F, 2.7212F, -53.1225F, 0.53043F, 46.908F, 2.7212F, -53.1225F, 0.53043F, 46.908F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.leftLegMid.yRot = (FTKeyframes.keyframe(t0, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{-(3.40487F), -(-7.02985F), -(-11.3695F), -(4.68304F), -(3.40487F), -(-7.02985F), -(-11.3695F), -(4.68304F), -(3.40487F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.leftLegMid.zRot = (FTKeyframes.keyframe(t0, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{-(-19.7198F), -(-41.052F), -(-28.941F), -(-11.3559F), -(-19.7198F), -(-41.052F), -(-28.941F), -(-11.3559F), -(-19.7198F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.antemnas.xRot = ((-17.5F) + (Mth.sin(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * (-5F))) * Mth.DEG_TO_RAD;
            float t1 = Math.min(animTime, 2F);
            this.leftLegBack.xRot = (FTKeyframes.keyframe(t1, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{46.908F, 2.7212F, -53.1225F, 0.53043F, 46.908F, 2.7212F, -53.1225F, 0.53043F, 46.908F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.leftLegBack.yRot = (FTKeyframes.keyframe(t1, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{-(3.40487F), -(-7.02985F), -(-11.3695F), -(4.68304F), -(3.40487F), -(-7.02985F), -(-11.3695F), -(4.68304F), -(3.40487F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.leftLegBack.zRot = (FTKeyframes.keyframe(t1, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{-(-19.7198F), -(-41.052F), -(-28.941F), -(-11.3559F), -(-19.7198F), -(-41.052F), -(-28.941F), -(-11.3559F), -(-19.7198F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t2 = Math.min(animTime, 2F);
            this.leftLegFront.xRot = (FTKeyframes.keyframe(t2, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{46.908F, 2.7212F, -53.1225F, 0.53043F, 46.908F, 2.7212F, -53.1225F, 0.53043F, 46.908F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.leftLegFront.yRot = (FTKeyframes.keyframe(t2, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{-(3.40487F), -(-7.02985F), -(-11.3695F), -(4.68304F), -(3.40487F), -(-7.02985F), -(-11.3695F), -(4.68304F), -(3.40487F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.leftLegFront.zRot = (FTKeyframes.keyframe(t2, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{-(-19.7198F), -(-41.052F), -(-28.941F), -(-11.3559F), -(-19.7198F), -(-41.052F), -(-28.941F), -(-11.3559F), -(-19.7198F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.leftPincher.xRot = (10F) * Mth.DEG_TO_RAD;
            this.leftPincher.yRot = (-(15F + (Mth.sin(((animTime - 0F) * 90F) * Mth.DEG_TO_RAD) * 5F))) * Mth.DEG_TO_RAD;
            float t3 = Math.min(animTime, 2F);
            this.rightLegMid.xRot = (FTKeyframes.keyframe(t3, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{46.908F, 2.7212F, -53.1225F, 0.53043F, 46.908F, 2.7212F, -53.1225F, 0.53043F, 46.908F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.rightLegMid.yRot = (FTKeyframes.keyframe(t3, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{-(-3.40487F), -(7.02985F), -(11.3695F), -(-4.68304F), -(-3.40487F), -(7.02985F), -(11.3695F), -(-4.68304F), -(-3.40487F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.rightLegMid.zRot = (FTKeyframes.keyframe(t3, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{-(19.7198F), -(41.052F), -(28.941F), -(11.3559F), -(19.7198F), -(41.052F), -(28.941F), -(11.3559F), -(19.7198F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t4 = Math.min(animTime, 2F);
            this.rightLegFront.xRot = (FTKeyframes.keyframe(t4, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{46.908F, 2.7212F, -53.1225F, 0.53043F, 46.908F, 2.7212F, -53.1225F, 0.53043F, 46.908F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.rightLegFront.yRot = (FTKeyframes.keyframe(t4, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{-(-3.40487F), -(7.02985F), -(11.3695F), -(-4.68304F), -(-3.40487F), -(7.02985F), -(11.3695F), -(-4.68304F), -(-3.40487F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.rightLegFront.zRot = (FTKeyframes.keyframe(t4, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{-(19.7198F), -(41.052F), -(28.941F), -(11.3559F), -(19.7198F), -(41.052F), -(28.941F), -(11.3559F), -(19.7198F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t5 = Math.min(animTime, 2F);
            this.rightLegBack.xRot = (FTKeyframes.keyframe(t5, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{46.908F, 2.7212F, -53.1225F, 0.53043F, 46.908F, 2.7212F, -53.1225F, 0.53043F, 46.908F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.rightLegBack.yRot = (FTKeyframes.keyframe(t5, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{-(-3.40487F), -(7.02985F), -(11.3695F), -(-4.68304F), -(-3.40487F), -(7.02985F), -(11.3695F), -(-4.68304F), -(-3.40487F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.rightLegBack.zRot = (FTKeyframes.keyframe(t5, new float[]{0F, 0.24F, 0.52F, 0.76F, 1F, 1.24F, 1.52F, 1.76F, 2F}, new float[]{-(19.7198F), -(41.052F), -(28.941F), -(11.3559F), -(19.7198F), -(41.052F), -(28.941F), -(11.3559F), -(19.7198F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
        } else {
            this.tail.xRot = (Mth.sin(((animTime - 0F) * 90F) * Mth.DEG_TO_RAD) * 8F) * Mth.DEG_TO_RAD;
            this.antemnas.xRot = (Mth.sin(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * (-5F)) * Mth.DEG_TO_RAD;
            this.rightPincher.xRot = (10F) * Mth.DEG_TO_RAD;
            this.rightPincher.yRot = (-(Mth.sin(((animTime - 0F) * 90F) * Mth.DEG_TO_RAD) * (-5F))) * Mth.DEG_TO_RAD;
            this.leftPincher.xRot = (10F) * Mth.DEG_TO_RAD;
            this.leftPincher.yRot = (-(-(Mth.sin(((animTime - 0F) * 90F) * Mth.DEG_TO_RAD) * (-5F)))) * Mth.DEG_TO_RAD;
        }
    }

}
