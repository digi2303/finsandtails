package blueportal.finsandstails.client.model;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.render.state.FlatbackLeafSnailRenderState;
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

public class FlatbackLeafSnailModel extends EntityModel<FlatbackLeafSnailRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(FinsAndTails.id("flatback_leaf_snail"), "main");

    private final ModelPart root;
    private final ModelPart shell;
    private final ModelPart body;
    private final ModelPart eyes;
    private final ModelPart mandibles;

    public FlatbackLeafSnailModel(ModelPart modelPart) {
        super(modelPart, RenderTypes::entityTranslucent);
        this.root = modelPart.getChild("root");
        this.shell = this.root.getChild("shell");
        this.body = this.root.getChild("body");
        this.eyes = this.body.getChild("eyes");
        this.mandibles = this.body.getChild("mandibles");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0F, 21F, 3F));
        PartDefinition shell = root.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-9F, 0F, 0F, 9F, 3F, 9F).mirror(false), PartPose.offsetAndRotation(0F, -0.5F, -5F, 0.5236F, 0.7854F, 0.3927F));
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2F, 0F, -8F, 4F, 3F, 10F).mirror(false), PartPose.offset(0F, 0F, 0F));
        PartDefinition eyes = body.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(0, 4).mirror().addBox(-1.5F, -3F, -1F, 3F, 4F, 2F).mirror(false), PartPose.offsetAndRotation(0F, 0F, -7.5F, 0.7854F, 0F, -0.0175F));
        PartDefinition mandibles = body.addOrReplaceChild("mandibles", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1F, -0.5F, -2F, 2F, 1F, 2F).mirror(false), PartPose.offset(0F, 2.5F, -8F));

        return LayerDefinition.create(meshdefinition, 48, 32);
    }

    @Override
    public void setupAnim(FlatbackLeafSnailRenderState state) {
        super.setupAnim(state);
        float animTime = state.ageInTicks / 20.0F;

        if (state.moving) {
            float t0 = animTime % 2F;
            this.body.xScale = FTKeyframes.keyframe(t0, new float[]{0F, 0.375F, 0.625F, 1F, 1.375F, 1.625F, 2F}, new float[]{1F, 0.9F, 1.075F, 1F, 0.9F, 1.075F, 1F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            this.body.zScale = FTKeyframes.keyframe(t0, new float[]{0F, 0.375F, 0.625F, 1F, 1.375F, 1.625F, 2F}, new float[]{1F, 1.025F, 0.975F, 1F, 1.025F, 0.975F, 1F}, new Easing[]{Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR, Easing.LINEAR});
            this.shell.xRot = (Mth.sin((animTime * 360F) * Mth.DEG_TO_RAD) * 2F) * Mth.DEG_TO_RAD;
            this.shell.zRot = (-(Mth.cos((animTime * 360F) * Mth.DEG_TO_RAD) * (-2F))) * Mth.DEG_TO_RAD;
            this.eyes.xRot = (Mth.cos((animTime * 360F) * Mth.DEG_TO_RAD) * 2F) * Mth.DEG_TO_RAD;
            this.root.z += Mth.cos((animTime * 360F) * Mth.DEG_TO_RAD) * 0.09F;
        }
    }

}
