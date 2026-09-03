package blueportal.finsandstails.client.model;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.animation.FTKeyframes;
import blueportal.finsandstails.client.animation.FTKeyframes.Easing;
import blueportal.finsandstails.client.render.state.CrownedHorateeRenderState;
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

public class CrownedHorateeModel extends EntityModel<CrownedHorateeRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(FinsAndTails.id("crowned_horatee"), "main");

    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart dorsalFin;
    private final ModelPart head;
    private final ModelPart snout;
    private final ModelPart crownRight;
    private final ModelPart rightHeadFins;
    private final ModelPart leftHeadFins;
    private final ModelPart crownLeft;
    private final ModelPart tail;
    private final ModelPart tailTip;
    private final ModelPart tailFin;
    private final ModelPart leftFin;
    private final ModelPart rightFin;

    public CrownedHorateeModel(ModelPart modelPart) {
        super(modelPart, RenderTypes::entityCutout);
        this.root = modelPart.getChild("root");
        this.body = this.root.getChild("body");
        this.dorsalFin = this.body.getChild("dorsalFin");
        this.head = this.root.getChild("head");
        this.snout = this.head.getChild("snout");
        this.crownRight = this.head.getChild("crownRight");
        this.rightHeadFins = this.head.getChild("rightHeadFins");
        this.leftHeadFins = this.head.getChild("leftHeadFins");
        this.crownLeft = this.head.getChild("crownLeft");
        this.tail = this.root.getChild("tail");
        this.tailTip = this.tail.getChild("tailTip");
        this.tailFin = this.tailTip.getChild("tailFin");
        this.leftFin = this.root.getChild("leftFin");
        this.rightFin = this.root.getChild("rightFin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, -3F, -6F, 5F, 6F, 12F).mirror(false), PartPose.offset(0F, 16F, 0F));
        PartDefinition dorsalFin = body.addOrReplaceChild("dorsalFin", CubeListBuilder.create().texOffs(42, 13).mirror().addBox(0F, -4F, -4.5F, 0F, 4F, 9F).mirror(false), PartPose.offset(0F, -3F, 2.5F));
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(-3F, -3F, -6F, 6F, 6F, 6F).mirror(false), PartPose.offset(0F, 15F, -6F));
        PartDefinition snout = head.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1F, -1F, -5F, 2F, 2F, 5F).mirror(false), PartPose.offset(0F, 2F, -6F));
        PartDefinition crownRight = head.addOrReplaceChild("crownRight", CubeListBuilder.create().texOffs(42, 9).addBox(0F, -6F, -3.5F, 0F, 6F, 7F), PartPose.offsetAndRotation(-0.5F, 0F, -4.5F, 0F, 0F, 0.3927F));
        PartDefinition rightHeadFins = head.addOrReplaceChild("rightHeadFins", CubeListBuilder.create().texOffs(0, 2).mirror().addBox(0F, -3F, 0F, 0F, 6F, 4F).mirror(false), PartPose.offsetAndRotation(3.01F, 1F, -3F, 0F, 0.0873F, 0F));
        PartDefinition leftHeadFins = head.addOrReplaceChild("leftHeadFins", CubeListBuilder.create().texOffs(0, 2).mirror().addBox(0F, -3F, 0F, 0F, 6F, 4F).mirror(false), PartPose.offsetAndRotation(-3.01F, 1F, -3F, 0F, -0.0873F, 0F));
        PartDefinition crownLeft = head.addOrReplaceChild("crownLeft", CubeListBuilder.create().texOffs(42, 9).mirror().addBox(0F, -6F, -3.5F, 0F, 6F, 7F).mirror(false), PartPose.offsetAndRotation(0.5F, 0F, -4.5F, 0F, 0F, -0.3927F));
        PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(39, 5).mirror().addBox(-2F, -2F, 0F, 4F, 4F, 7F).mirror(false), PartPose.offset(0F, 16F, 6F));
        PartDefinition tailTip = tail.addOrReplaceChild("tailTip", CubeListBuilder.create().texOffs(6, 18).mirror().addBox(-1.5F, -1.5F, 0F, 3F, 3F, 8F).mirror(false), PartPose.offset(0F, 0.5F, 7F));
        PartDefinition tailFin = tailTip.addOrReplaceChild("tailFin", CubeListBuilder.create().texOffs(42, 19).mirror().addBox(0F, -3.5F, -1F, 0F, 5F, 7F).mirror(false), PartPose.offset(0F, 0F, 8F));
        PartDefinition leftFin = root.addOrReplaceChild("leftFin", CubeListBuilder.create().texOffs(30, 14).addBox(-1F, 0F, -2F, 2F, 9F, 4F), PartPose.offset(2.5F, 15F, -2F));
        PartDefinition rightFin = root.addOrReplaceChild("rightFin", CubeListBuilder.create().texOffs(30, 14).mirror().addBox(-1F, 0F, -2F, 2F, 9F, 4F).mirror(false), PartPose.offset(-2.5F, 15F, -2F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(CrownedHorateeRenderState state) {
        super.setupAnim(state);
        float baseTime = state.ageInTicks / 20.0F;

        if (state.moving && state.isInWater && state.onGround) {
            float animTime = baseTime;
            this.tail.xRot = ((-90F) + (Mth.sin((animTime * 180F) * Mth.DEG_TO_RAD) * 24F)) * Mth.DEG_TO_RAD;
            float t0 = animTime % 2F;
            this.tail.y += FTKeyframes.keyframe(t0, new float[]{0.5F, 1F, 1.5F, 2F}, new float[]{-(0F), -(2F), -(0F), -(0F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            this.tailTip.xRot = (90F + (Mth.sin((animTime * 180F) * Mth.DEG_TO_RAD) * (-24F))) * Mth.DEG_TO_RAD;
            this.leftFin.xRot = (Mth.cos((animTime * 180F) * Mth.DEG_TO_RAD) * (-12F)) * Mth.DEG_TO_RAD;
            float t1 = animTime % 2F;
            this.leftFin.y += FTKeyframes.keyframe(t1, new float[]{0F, 0.5F, 1F, 1.38F, 1.76F, 2F}, new float[]{-(0F), -(0F), -(0F), -(1F), -(1F), -(0F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            this.leftFin.z += FTKeyframes.keyframe(t1, new float[]{0F, 0.5F, 1F, 1.38F, 1.76F, 2F}, new float[]{-1F, 0F, 0F, -0.5F, -1F, -1F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            this.rightFin.xRot = (Mth.cos((animTime * 180F) * Mth.DEG_TO_RAD) * 12F) * Mth.DEG_TO_RAD;
            float t2 = animTime % 2F;
            this.rightFin.y += FTKeyframes.keyframe(t2, new float[]{0F, 0.38F, 0.76F, 1F, 1.5F}, new float[]{-(0F), -(1F), -(1F), -(0F), -(0F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            this.rightFin.z += FTKeyframes.keyframe(t2, new float[]{0F, 0.38F, 0.76F, 1F, 1.5F}, new float[]{0F, -0.5F, -1F, -1F, 0F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            this.body.xRot = (Mth.cos(((animTime + 0.1F) * 360F) * Mth.DEG_TO_RAD) * (-2F)) * Mth.DEG_TO_RAD;
            this.head.xRot = (Mth.cos(((animTime - 0.25F) * 360F) * Mth.DEG_TO_RAD) * 2.4F) * Mth.DEG_TO_RAD;
            this.head.zRot = (-(-(Mth.cos(((animTime - 0.2F) * 180F) * Mth.DEG_TO_RAD) * 3F))) * Mth.DEG_TO_RAD;
            this.crownRight.zRot = (-(-(Mth.cos(((animTime + 0.25F) * 180F) * Mth.DEG_TO_RAD) * (-10F)))) * Mth.DEG_TO_RAD;
            this.rightHeadFins.yRot = (-((-7.5F) + (Mth.sin((animTime * 180F) * Mth.DEG_TO_RAD) * 10F))) * Mth.DEG_TO_RAD;
            this.leftHeadFins.yRot = (-(7.5F + (Mth.sin((animTime * 180F) * Mth.DEG_TO_RAD) * (-10F)))) * Mth.DEG_TO_RAD;
            this.crownLeft.zRot = (-(-(Mth.cos(((animTime + 0.25F) * 180F) * Mth.DEG_TO_RAD) * (-10F)))) * Mth.DEG_TO_RAD;
            this.dorsalFin.zRot = (-(Mth.cos(((animTime - 0.5F) * 180F) * Mth.DEG_TO_RAD) * (-10F))) * Mth.DEG_TO_RAD;
            this.tailFin.xRot = (45F + (Mth.sin(((animTime - 0.25F) * 180F) * Mth.DEG_TO_RAD) * (-20F))) * Mth.DEG_TO_RAD;
        } else if (state.moving && state.isInWater) {
            float animTime = baseTime;
            this.body.yRot = (-(Mth.cos((animTime * 360F) * Mth.DEG_TO_RAD) * (-5F))) * Mth.DEG_TO_RAD;
            this.tail.yRot = (-(Mth.cos(((animTime - 0.25F) * 360F) * Mth.DEG_TO_RAD) * (-15F))) * Mth.DEG_TO_RAD;
            this.tailTip.yRot = (-(Mth.cos(((animTime - 0.5F) * 360F) * Mth.DEG_TO_RAD) * (-15F))) * Mth.DEG_TO_RAD;
            this.tailFin.yRot = (-(Mth.cos(((animTime - 0.5F) * 360F) * Mth.DEG_TO_RAD) * (-15F))) * Mth.DEG_TO_RAD;
            this.leftFin.xRot = (Mth.cos(((animTime + 0.25F) * 360F) * Mth.DEG_TO_RAD) * (-20F)) * Mth.DEG_TO_RAD;
            this.leftFin.yRot = (-(Mth.cos(((animTime + 0.25F) * 360F) * Mth.DEG_TO_RAD) * (-30F))) * Mth.DEG_TO_RAD;
            this.leftFin.zRot = (-((Mth.cos((animTime * 360F) * Mth.DEG_TO_RAD) * (-30F)) + 30F)) * Mth.DEG_TO_RAD;
            this.head.yRot = (-(Mth.cos(((animTime * 360F) - 10F) * Mth.DEG_TO_RAD) * 10F)) * Mth.DEG_TO_RAD;
            this.rightFin.xRot = (Mth.cos(((animTime + 0.25F) * 360F) * Mth.DEG_TO_RAD) * (-20F)) * Mth.DEG_TO_RAD;
            this.rightFin.yRot = (-(Mth.cos(((animTime + 0.25F) * 360F) * Mth.DEG_TO_RAD) * 30F)) * Mth.DEG_TO_RAD;
            this.rightFin.zRot = (-((Mth.cos((animTime * 360F) * Mth.DEG_TO_RAD) * 30F) - 30F)) * Mth.DEG_TO_RAD;
        } else if (state.moving) {
            float animTime = baseTime;
            float t3 = animTime % 2F;
            this.root.xRot = (FTKeyframes.keyframe(t3, new float[]{0F, 0.22F, 0.58F, 0.92F, 1.22F, 1.58F, 1.92F}, new float[]{0F, 0F, -10F, 0F, 0F, -10F, 0F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t4 = animTime % 2F;
            this.root.y += FTKeyframes.keyframe(t4, new float[]{0F, 0.14F, 0.5F, 0.84F, 1.14F, 1.5F, 1.84F}, new float[]{-(-5F), -(-5F), -(-4F), -(-5F), -(-5F), -(-4F), -(-5F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            float t5 = animTime % 2F;
            this.head.xRot = (FTKeyframes.keyframe(t5, new float[]{0.24F, 0.6F, 0.94F, 1.24F, 1.6F, 1.94F}, new float[]{0F, 10F, 0F, 0F, 10F, 0F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t6 = animTime % 2F;
            this.tail.xRot = (FTKeyframes.keyframe(t6, new float[]{0.24F, 0.6F, 0.94F, 1.24F, 1.6F, 1.94F}, new float[]{-5F, 5F, -5F, -5F, 5F, -5F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t7 = animTime % 2F;
            this.leftFin.xRot = (FTKeyframes.keyframe(t7, new float[]{0F, 1F, 1.5F, 2F}, new float[]{Mth.cos((animTime * 180F) * Mth.DEG_TO_RAD) * 50F, Mth.cos((animTime * 180F) * Mth.DEG_TO_RAD) * 50F, Mth.cos((animTime * 180F) * Mth.DEG_TO_RAD) * 50F, Mth.cos((animTime * 180F) * Mth.DEG_TO_RAD) * 50F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.leftFin.zRot = (FTKeyframes.keyframe(t7, new float[]{0F, 1F, 1.5F, 2F}, new float[]{-(67.5F), -(67.5F), -(52.5F), -(67.5F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t8 = animTime % 2F;
            this.rightFin.xRot = (FTKeyframes.keyframe(t8, new float[]{0F, 0.5F, 1F}, new float[]{Mth.cos((animTime * 180F) * Mth.DEG_TO_RAD) * (-50F), Mth.cos((animTime * 180F) * Mth.DEG_TO_RAD) * (-50F), Mth.cos((animTime * 180F) * Mth.DEG_TO_RAD) * (-50F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.rightFin.zRot = (FTKeyframes.keyframe(t8, new float[]{0F, 0.5F, 1F}, new float[]{-(-67.5F), -(-52.5F), -(-67.5F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
        } else if (state.isInWater) {
            float animTime = baseTime;
            float t9 = animTime % 4F;
            this.head.xRot = (FTKeyframes.keyframe(t9, new float[]{0F, 2F, 4F}, new float[]{0F, 5F, 0F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t10 = animTime % 4F;
            this.tail.yRot = (FTKeyframes.keyframe(t10, new float[]{0F, 1F, 2.02F, 3F, 4F}, new float[]{-(0F), -(10F), -(0F), -(-10F), -(0F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t11 = animTime % 4F;
            this.tailTip.yRot = (FTKeyframes.keyframe(t11, new float[]{0F, 0.5F, 1.5F, 2.5F, 3.5F, 4F}, new float[]{-(-7.07F), -(0F), -(10F), -(0F), -(-10F), -(-7.07F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t12 = animTime % 4F;
            this.tailFin.yRot = (FTKeyframes.keyframe(t12, new float[]{0F, 1F, 2F, 3.02F, 4F}, new float[]{-(-10F), -(0F), -(10F), -(0F), -(-10F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.leftFin.zRot = (-((Mth.cos((animTime * 180F) * Mth.DEG_TO_RAD) * 5F) + 5F)) * Mth.DEG_TO_RAD;
            this.rightFin.zRot = (-((Mth.cos((animTime * 180F) * Mth.DEG_TO_RAD) * (-5F)) - 5F)) * Mth.DEG_TO_RAD;
        } else {
            float animTime = baseTime;
            this.root.y += -(-5F);
            float t13 = animTime % 2F;
            this.head.xRot = (FTKeyframes.keyframe(t13, new float[]{0F, 1F, 2F}, new float[]{0F, 5F, 0F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t14 = animTime % 2F;
            this.head.y += FTKeyframes.keyframe(t14, new float[]{0F, 1F, 2F}, new float[]{-(0F), -(-0.25F), -(0F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            this.tail.xRot = (-5F) * Mth.DEG_TO_RAD;
            float t15 = animTime % 2F;
            this.tailFin.xRot = (FTKeyframes.keyframe(t15, new float[]{0F, 1F, 2F}, new float[]{0F, -5F, 0F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.leftFin.zRot = (-(65F)) * Mth.DEG_TO_RAD;
            this.rightFin.zRot = (-(-65F)) * Mth.DEG_TO_RAD;
        }

        if (state.bubbleCharge) {
            float animTime = baseTime;
            this.head.xRot = (Mth.cos(((animTime - 0.3F) * 480F) * Mth.DEG_TO_RAD) * 6F) * Mth.DEG_TO_RAD;
            this.snout.xScale = 1F + (Mth.cos((animTime * 960F) * Mth.DEG_TO_RAD) * 0.08F);
            this.snout.yScale = 1F + (Mth.cos((animTime * 960F) * Mth.DEG_TO_RAD) * 0.08F);
            this.snout.zScale = 1F + (Mth.cos((animTime * 960F) * Mth.DEG_TO_RAD) * 0.08F);
            this.rightHeadFins.yRot = (-((-7.5F) + (Mth.sin((animTime * 480F) * Mth.DEG_TO_RAD) * 10F))) * Mth.DEG_TO_RAD;
            this.leftHeadFins.yRot = (-(7.5F + (Mth.sin((animTime * 480F) * Mth.DEG_TO_RAD) * (-10F)))) * Mth.DEG_TO_RAD;
        }
    }
}
