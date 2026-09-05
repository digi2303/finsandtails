package blueportal.finsandstails.client.model;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.render.state.RiverPebbleSnailRenderState;
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

public class RiverPebbleSnailModel extends EntityModel<RiverPebbleSnailRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(FinsAndTails.id("river_pebble_snail"), "main");

    private final ModelPart root;
    private final ModelPart shell;
    private final ModelPart sparkle;
    private final ModelPart rotate;
    private final ModelPart body;
    private final ModelPart stalks;
    private final ModelPart mouth;

    public RiverPebbleSnailModel(ModelPart modelPart) {
        super(modelPart, RenderTypes::entityTranslucent);
        this.root = modelPart.getChild("root");
        this.shell = this.root.getChild("shell");
        this.sparkle = this.shell.getChild("sparkle");
        this.rotate = this.sparkle.getChild("rotate");
        this.body = this.root.getChild("body");
        this.stalks = this.body.getChild("stalks");
        this.mouth = this.body.getChild("mouth");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0F, 22F, 0F));
        PartDefinition shell = root.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(1, 0).mirror().addBox(-2F, -3F, 0F, 4F, 4F, 5F).mirror(false), PartPose.offsetAndRotation(0F, 1F, 0F, 0.2618F, 0F, 0F));
        PartDefinition sparkle = shell.addOrReplaceChild("sparkle", CubeListBuilder.create(), PartPose.offsetAndRotation(-2F, -3F, 0F, -1.0472F, 0.6109F, 0.0873F));
        PartDefinition rotate = sparkle.addOrReplaceChild("rotate", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, -1.5F, 0F, 3F, 3F, 0F).mirror(false), PartPose.offset(0F, 0F, 0F));
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 9).mirror().addBox(-1.5F, 0F, -2.5F, 3F, 2F, 5F).mirror(false), PartPose.offset(0F, 0F, 0F));
        PartDefinition stalks = body.addOrReplaceChild("stalks", CubeListBuilder.create().texOffs(11, 11).mirror().addBox(1F, -2F, -1F, 0F, 2F, 1F).mirror(false).texOffs(11, 11).mirror().addBox(-1F, -2F, -1F, 0F, 2F, 1F).mirror(false), PartPose.offsetAndRotation(0F, 0F, -1.5F, 0.5F, 0F, 0F));
        PartDefinition mouth = body.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(11, 9).mirror().addBox(1F, -0.5F, -1F, 0F, 1F, 1F).mirror(false).texOffs(11, 9).mirror().addBox(-1F, -0.5F, -1F, 0F, 1F, 1F).mirror(false), PartPose.offset(0F, 1.5F, -2.5F));

        return LayerDefinition.create(meshdefinition, 20, 16);
    }

    @Override
    public void setupAnim(RiverPebbleSnailRenderState state) {
        super.setupAnim(state);
        float animTime = state.ageInTicks / 20.0F;

        this.sparkle.visible = state.variant == 5 && state.shimmer;

        if (state.variant == 5 && state.shimmer) {
            float t800 = animTime % 1.5F;
            this.rotate.zRot = (FTKeyframes.keyframe(t800, new float[]{0F, 0.75F}, new float[]{-(0F), -(360F)}, new Easing[]{Easing.LINEAR, Easing.LINEAR})) * Mth.DEG_TO_RAD;
            float t801 = animTime % 1.5F;
            this.rotate.xScale = FTKeyframes.keyframe(t801, new float[]{0F, 0.375F, 0.75F}, new float[]{0F, 1.5F, 0F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            this.rotate.yScale = FTKeyframes.keyframe(t801, new float[]{0F, 0.375F, 0.75F}, new float[]{0F, 1.5F, 0F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            this.rotate.zScale = FTKeyframes.keyframe(t801, new float[]{0F, 0.375F, 0.75F}, new float[]{0F, 1.5F, 0F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
        }

        if (state.moving) {
            this.root.z += Mth.cos((animTime * 360F) * Mth.DEG_TO_RAD) * 0.09F;
            this.shell.xRot = (Mth.sin((animTime * 360F) * Mth.DEG_TO_RAD) * 2F) * Mth.DEG_TO_RAD;
            this.stalks.xRot = (Mth.cos((animTime * 360F) * Mth.DEG_TO_RAD) * 2F) * Mth.DEG_TO_RAD;
            float t0 = animTime % 2F;
            this.body.xScale = FTKeyframes.keyframe(t0, new float[]{0F, 0.25F, 0.5F, 0.75F, 1F, 1.25F, 1.5F, 1.75F, 2F}, new float[]{1F, 0.9F, 1.05F, 1.025F, 1F, 0.9F, 1.05F, 1.025F, 1F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.EASE_IN_OUT_QUAD, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.EASE_IN_OUT_QUAD, Easing.LINEAR});
            this.body.zScale = FTKeyframes.keyframe(t0, new float[]{0F, 0.25F, 0.5F, 0.75F, 1F, 1.25F, 1.5F, 1.75F, 2F}, new float[]{1F, 1.075F, 0.95F, 0.975F, 1F, 1.075F, 0.95F, 0.975F, 1F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.EASE_IN_OUT_QUAD, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.EASE_IN_OUT_QUAD, Easing.LINEAR});
        } else {
            this.shell.xRot = (Mth.sin((animTime * 360F) * Mth.DEG_TO_RAD) * 1F) * Mth.DEG_TO_RAD;
            this.stalks.xRot = (Mth.cos((animTime * 360F) * Mth.DEG_TO_RAD) * 1F) * Mth.DEG_TO_RAD;
        }
    }
}
