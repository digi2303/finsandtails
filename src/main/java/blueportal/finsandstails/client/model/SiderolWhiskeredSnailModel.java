package blueportal.finsandstails.client.model;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.render.state.SiderolWhiskeredSnailRenderState;
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

public class SiderolWhiskeredSnailModel extends EntityModel<SiderolWhiskeredSnailRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(FinsAndTails.id("siderol_whiskered_snail"), "main");

    private final ModelPart body;
    private final ModelPart neck;
    private final ModelPart stalks;
    private final ModelPart whiskerRight;
    private final ModelPart whiskerLeft;
    private final ModelPart shell;

    public SiderolWhiskeredSnailModel(ModelPart modelPart) {
        super(modelPart, RenderTypes::entityTranslucent);
        this.body = modelPart.getChild("body");
        this.neck = this.body.getChild("neck");
        this.stalks = this.neck.getChild("stalks");
        this.whiskerRight = this.neck.getChild("whiskerRight");
        this.whiskerLeft = this.neck.getChild("whiskerLeft");
        this.shell = this.body.getChild("shell");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 9).mirror().addBox(-1.5F, 0F, -2.5F, 3F, 2F, 7F).mirror(false), PartPose.offset(0F, 22F, 0F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-1F, -8F, -1F, 2F, 8F, 3F).mirror(false), PartPose.offsetAndRotation(0F, 2F, -2.5F, 0.18F, 0F, 0F));
        PartDefinition stalks = neck.addOrReplaceChild("stalks", CubeListBuilder.create().texOffs(13, 12).mirror().addBox(1F, -2F, 0F, 0F, 2F, 1F).mirror(false).texOffs(13, 12).mirror().addBox(-1F, -2F, 0F, 0F, 2F, 1F).mirror(false), PartPose.offset(0F, -8F, -0.5F));
        PartDefinition whiskerRight = neck.addOrReplaceChild("whiskerRight", CubeListBuilder.create().texOffs(0, 9).mirror().addBox(0F, 0F, -0.5F, 0F, 4F, 1F).mirror(false), PartPose.offsetAndRotation(-1F, -7F, -0.5F, 0F, 0F, 0.2618F));
        PartDefinition whiskerLeft = neck.addOrReplaceChild("whiskerLeft", CubeListBuilder.create().texOffs(0, 9).addBox(0F, 0F, -0.5F, 0F, 4F, 1F), PartPose.offsetAndRotation(1F, -7F, -0.5F, 0F, 0F, -0.2618F));
        PartDefinition shell = body.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2F, -5F, -2F, 4F, 5F, 4F).mirror(false), PartPose.offsetAndRotation(0F, 1F, 1F, -0.0873F, 0F, 0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(SiderolWhiskeredSnailRenderState state) {
        super.setupAnim(state);
        float animTime = state.ageInTicks / 20.0F;

        if (state.moving) {
            float t0 = animTime % 2F;
            this.body.xScale = FTKeyframes.keyframe(t0, new float[]{0F, 0.25F, 0.5F, 0.75F, 1F, 1.25F, 1.5F, 1.75F, 2F}, new float[]{1F, 0.9F, 1.05F, 1.025F, 1F, 0.9F, 1.05F, 1.025F, 1F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            this.body.zScale = FTKeyframes.keyframe(t0, new float[]{0F, 0.25F, 0.5F, 0.75F, 1F, 1.25F, 1.5F, 1.75F, 2F}, new float[]{1F, 1.075F, 0.95F, 0.975F, 1F, 1.075F, 0.95F, 0.975F, 1F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            this.neck.xRot = (Mth.sin((animTime * 360F) * Mth.DEG_TO_RAD) * 2F) * Mth.DEG_TO_RAD;
            this.neck.z += Mth.cos((animTime * 360F) * Mth.DEG_TO_RAD) * 0.25F;
            float t1 = animTime % 2F;
            this.neck.xScale = FTKeyframes.keyframe(t1, new float[]{0F, 0.25F, 0.5F, 0.75F, 1F, 1.25F, 1.5F, 1.75F, 2F}, new float[]{1F, 0.9F, 1.05F, 1.025F, 1F, 0.9F, 1.05F, 1.025F, 1F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            this.neck.zScale = FTKeyframes.keyframe(t1, new float[]{0F, 0.25F, 0.5F, 0.75F, 1F, 1.25F, 1.5F, 1.75F, 2F}, new float[]{1F, 1.075F, 0.95F, 0.975F, 1F, 1.075F, 0.95F, 0.975F, 1F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            this.stalks.xRot = (Mth.cos((animTime * 360F) * Mth.DEG_TO_RAD) * 2F) * Mth.DEG_TO_RAD;
            this.whiskerRight.xRot = (Mth.cos((animTime * 360F) * Mth.DEG_TO_RAD) * 10F) * Mth.DEG_TO_RAD;
            this.whiskerLeft.xRot = (Mth.cos((animTime * 360F) * Mth.DEG_TO_RAD) * 10F) * Mth.DEG_TO_RAD;
            this.shell.xRot = (Mth.sin((animTime * 360F) * Mth.DEG_TO_RAD) * 2.5F) * Mth.DEG_TO_RAD;
            this.shell.zRot = (-(Mth.cos((animTime * 360F) * Mth.DEG_TO_RAD) * 5F)) * Mth.DEG_TO_RAD;
        } else {
            this.stalks.xRot = (Mth.cos((animTime * 360F) * Mth.DEG_TO_RAD) * 1F) * Mth.DEG_TO_RAD;
            this.whiskerRight.xRot = (Mth.cos((animTime * 90F) * Mth.DEG_TO_RAD) * 10F) * Mth.DEG_TO_RAD;
            this.whiskerRight.zRot = (-(Mth.sin((animTime * 90F) * Mth.DEG_TO_RAD) * 10F)) * Mth.DEG_TO_RAD;
            this.whiskerLeft.xRot = (Mth.cos((animTime * 90F) * Mth.DEG_TO_RAD) * 10F) * Mth.DEG_TO_RAD;
            this.whiskerLeft.zRot = (-(Mth.sin((animTime * 90F) * Mth.DEG_TO_RAD) * (-10F))) * Mth.DEG_TO_RAD;
            this.shell.xRot = (Mth.sin((animTime * 90F) * Mth.DEG_TO_RAD) * 1F) * Mth.DEG_TO_RAD;
            this.shell.zRot = (-(Mth.cos((animTime * 90F) * Mth.DEG_TO_RAD) * 2F)) * Mth.DEG_TO_RAD;
        }
    }
}
