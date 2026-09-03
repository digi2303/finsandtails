package blueportal.finsandstails.client.model;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.render.state.WhiteBullCrabRenderState;
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

public class WhiteBullCrabModel extends EntityModel<WhiteBullCrabRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(FinsAndTails.id("white_bull_crab"), "main");

    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart rightclaw;
    private final ModelPart leftclaw;
    private final ModelPart righthorn;
    private final ModelPart lefthorn;
    private final ModelPart rightEye;
    private final ModelPart leftEye;
    private final ModelPart rightleg1;
    private final ModelPart rightleg2;
    private final ModelPart rightleg3;
    private final ModelPart leftleg1;
    private final ModelPart leftleg2;
    private final ModelPart leftleg3;

    public WhiteBullCrabModel(ModelPart modelPart) {
        super(modelPart, RenderTypes::entityCutoutCull);
        this.root = modelPart.getChild("root");
        this.body = this.root.getChild("body");
        this.rightclaw = this.body.getChild("rightclaw");
        this.leftclaw = this.body.getChild("leftclaw");
        this.righthorn = this.body.getChild("righthorn");
        this.lefthorn = this.body.getChild("lefthorn");
        this.rightEye = this.body.getChild("right_eye");
        this.leftEye = this.body.getChild("left_eye");
        this.rightleg1 = this.root.getChild("rightleg1");
        this.rightleg2 = this.root.getChild("rightleg2");
        this.rightleg3 = this.root.getChild("rightleg3");
        this.leftleg1 = this.root.getChild("leftleg1");
        this.leftleg2 = this.root.getChild("leftleg2");
        this.leftleg3 = this.root.getChild("leftleg3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0F, 24F, 0F));
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3F, -4F, -3F, 6F, 4F, 6F).mirror(false), PartPose.offset(0F, -1.5F, 0F));
        PartDefinition rightclaw = body.addOrReplaceChild("rightclaw", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(-2F, -3F, -4F, 3F, 4F, 4F).mirror(false), PartPose.offsetAndRotation(-3F, -0.5F, -2F, 0F, 0.1745F, 0F));
        PartDefinition leftclaw = body.addOrReplaceChild("leftclaw", CubeListBuilder.create().texOffs(0, 10).addBox(-1F, -3F, -4F, 3F, 4F, 4F), PartPose.offsetAndRotation(3F, -0.5F, -2F, 0F, -0.1745F, 0F));
        PartDefinition righthorn = body.addOrReplaceChild("righthorn", CubeListBuilder.create().texOffs(14, 10).mirror().addBox(-0.5F, -1F, -3F, 1F, 1F, 3F).mirror(false), PartPose.offsetAndRotation(-1.5F, -3.5F, -1.5F, -0.3927F, 0.3927F, 0F));
        PartDefinition lefthorn = body.addOrReplaceChild("lefthorn", CubeListBuilder.create().texOffs(14, 10).mirror().addBox(-0.5F, -1F, -3F, 1F, 1F, 3F).mirror(false), PartPose.offsetAndRotation(1.5F, -3.5F, -1.5F, -0.3927F, -0.3927F, 0F));
        PartDefinition rightEye = body.addOrReplaceChild("right_eye", CubeListBuilder.create().texOffs(2, 3).mirror().addBox(-0.5F, -3F, 0F, 1F, 3F, 0F).mirror(false), PartPose.offsetAndRotation(1F, -0.5F, -3F, 0.3927F, 0F, 0F));
        PartDefinition leftEye = body.addOrReplaceChild("left_eye", CubeListBuilder.create().texOffs(2, 3).mirror().addBox(-0.5F, -3F, 0F, 1F, 3F, 0F).mirror(false), PartPose.offsetAndRotation(-1F, -0.5F, -3F, 0.3927F, 0F, 0F));
        PartDefinition rightleg1 = root.addOrReplaceChild("rightleg1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2F, 0F, -0.5F, 2F, 0F, 1F).mirror(false), PartPose.offsetAndRotation(-2F, -1.5F, -1.5F, 0F, 0F, -0.8727F));
        PartDefinition rightleg2 = root.addOrReplaceChild("rightleg2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2F, 0F, -0.5F, 2F, 0F, 1F).mirror(false), PartPose.offsetAndRotation(-2F, -1.5F, 0F, 0F, 0F, -0.8727F));
        PartDefinition rightleg3 = root.addOrReplaceChild("rightleg3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2F, 0F, -0.5F, 2F, 0F, 1F).mirror(false), PartPose.offsetAndRotation(-2F, -1.5F, 1.5F, 0F, 0F, -0.8727F));
        PartDefinition leftleg1 = root.addOrReplaceChild("leftleg1", CubeListBuilder.create().texOffs(0, 0).addBox(0F, 0F, -0.5F, 2F, 0F, 1F), PartPose.offsetAndRotation(2F, -1.5F, -1.5F, 0F, 0F, 0.8727F));
        PartDefinition leftleg2 = root.addOrReplaceChild("leftleg2", CubeListBuilder.create().texOffs(0, 0).addBox(0F, 0F, -0.5F, 2F, 0F, 1F), PartPose.offsetAndRotation(2F, -1.5F, 0F, 0F, 0F, 0.8727F));
        PartDefinition leftleg3 = root.addOrReplaceChild("leftleg3", CubeListBuilder.create().texOffs(0, 0).addBox(0F, 0F, -0.5F, 2F, 0F, 1F), PartPose.offsetAndRotation(2F, -1.5F, 1.5F, 0F, 0F, 0.8727F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(WhiteBullCrabRenderState state) {
        super.setupAnim(state);
        float animTime = state.ageInTicks / 20.0F;

        if (state.moving) {
            this.root.yRot = (-(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * 3F)) * Mth.DEG_TO_RAD;
            this.rightclaw.yRot = (-(Mth.cos(((animTime - 0.35F) * 360F) * Mth.DEG_TO_RAD) * 3F)) * Mth.DEG_TO_RAD;
            this.rightclaw.y += -(Mth.sin(((animTime - 0F) * 720F) * Mth.DEG_TO_RAD) * 0.08F);
            this.leftclaw.yRot = (-(Mth.cos(((animTime - 0.35F) * 360F) * Mth.DEG_TO_RAD) * 3F)) * Mth.DEG_TO_RAD;
            this.leftclaw.y += -(Mth.sin(((animTime - 0F) * 720F) * Mth.DEG_TO_RAD) * 0.08F);
            float t0 = animTime % 1F;
            this.rightleg1.yRot = (FTKeyframes.keyframe(t0, new float[]{0.5F, 0.75F, 1F}, new float[]{-(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * 6F), -(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * 6F), -(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * 6F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.rightleg1.zRot = (FTKeyframes.keyframe(t0, new float[]{0.5F, 0.75F, 1F}, new float[]{-(0F), -(-7.5F), -(0F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t1 = animTime % 1F;
            this.rightleg1.y += FTKeyframes.keyframe(t1, new float[]{0.5F, 0.75F, 1F}, new float[]{-(0F), -(0.15F), -(0F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            float t2 = animTime % 1F;
            this.rightleg2.yRot = (FTKeyframes.keyframe(t2, new float[]{0F, 0.25F, 0.5F}, new float[]{-(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * (-6F)), -(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * (-6F)), -(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * (-6F))}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.rightleg2.zRot = (FTKeyframes.keyframe(t2, new float[]{0F, 0.25F, 0.5F}, new float[]{-(0F), -(-7.5F), -(0F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t3 = animTime % 1F;
            this.rightleg2.y += FTKeyframes.keyframe(t3, new float[]{0F, 0.25F, 0.5F}, new float[]{-(0F), -(0.15F), -(0F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            float t4 = animTime % 1F;
            this.leftleg1.yRot = (FTKeyframes.keyframe(t4, new float[]{0F, 0.25F, 0.5F}, new float[]{-(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * 6F), -(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * 6F), -(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * 6F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.leftleg1.zRot = (FTKeyframes.keyframe(t4, new float[]{0F, 0.25F, 0.5F}, new float[]{-(0F), -(7.5F), -(0F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t5 = animTime % 1F;
            this.leftleg1.y += FTKeyframes.keyframe(t5, new float[]{0F, 0.25F, 0.5F}, new float[]{-(0F), -(0.15F), -(0F)}, new Easing[]{Easing.LINEAR, Easing.EASE_IN_OUT_SINE, Easing.EASE_IN_OUT_QUAD});
            float t6 = animTime % 1F;
            this.leftleg2.yRot = (FTKeyframes.keyframe(t6, new float[]{0F, 0.5F, 0.75F, 1F}, new float[]{-(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * (-6F)), -(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * (-6F)), -(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * (-6F)), -(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * (-6F))}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.leftleg2.zRot = (FTKeyframes.keyframe(t6, new float[]{0F, 0.5F, 0.75F, 1F}, new float[]{-(0F), -(0F), -(7.5F), -(0F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t7 = animTime % 1F;
            this.leftleg2.y += FTKeyframes.keyframe(t7, new float[]{0.5F, 0.75F, 1F}, new float[]{-(0F), -(0.15F), -(0F)}, new Easing[]{Easing.LINEAR, Easing.EASE_IN_OUT_SINE, Easing.LINEAR});
            float t8 = animTime % 1F;
            this.rightleg3.yRot = (FTKeyframes.keyframe(t8, new float[]{0.5F, 0.75F, 1F}, new float[]{-(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * 6F), -(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * 6F), -(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * 6F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.rightleg3.zRot = (FTKeyframes.keyframe(t8, new float[]{0.5F, 0.75F, 1F}, new float[]{-(0F), -(-7.5F), -(0F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t9 = animTime % 1F;
            this.rightleg3.y += FTKeyframes.keyframe(t9, new float[]{0.5F, 0.75F, 1F}, new float[]{-(0F), -(0.15F), -(0F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            float t10 = animTime % 1F;
            this.leftleg3.yRot = (FTKeyframes.keyframe(t10, new float[]{0F, 0.25F, 0.5F}, new float[]{-(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * 6F), -(0F + (Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * 6F)), -(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * 6F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            this.leftleg3.zRot = (FTKeyframes.keyframe(t10, new float[]{0F, 0.25F, 0.5F}, new float[]{-(0F), -(7.5F), -(0F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t11 = animTime % 1F;
            this.leftleg3.y += FTKeyframes.keyframe(t11, new float[]{0F, 0.25F, 0.5F}, new float[]{-(0F), -(0.15F), -(0F)}, new Easing[]{Easing.LINEAR, Easing.EASE_IN_OUT_SINE, Easing.EASE_IN_OUT_QUAD});
            this.rightEye.xRot = (Mth.cos(((animTime - 0.15F) * 360F) * Mth.DEG_TO_RAD) * 3F) * Mth.DEG_TO_RAD;
            this.leftEye.xRot = (Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * 3F) * Mth.DEG_TO_RAD;
            this.body.zRot = (-(Mth.cos(((animTime - 0.25F) * 360F) * Mth.DEG_TO_RAD) * 1F)) * Mth.DEG_TO_RAD;
        } else {
            this.body.y += -(Mth.cos(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * 0.1F);
            this.rightclaw.xRot = (Mth.sin(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * 3F) * Mth.DEG_TO_RAD;
            this.rightclaw.y += -(Mth.sin(((animTime + 0.3F) * 180F) * Mth.DEG_TO_RAD) * 0.2F);
            this.leftclaw.xRot = (Mth.sin(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * 3F) * Mth.DEG_TO_RAD;
            this.leftclaw.y += -(Mth.sin(((animTime + 0.3F) * 180F) * Mth.DEG_TO_RAD) * 0.2F);
            this.rightEye.xRot = (Mth.sin(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * 3F) * Mth.DEG_TO_RAD;
            this.leftEye.xRot = (Mth.sin(((animTime - 0.14F) * 180F) * Mth.DEG_TO_RAD) * 3F) * Mth.DEG_TO_RAD;
        }
    }
}
