package blueportal.finsandstails.client.model;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.render.state.HighFinnedBlueRenderState;
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

public class HighFinnedBlueModel extends EntityModel<HighFinnedBlueRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(FinsAndTails.id("high_finned_blue"), "main");

    private final ModelPart body;
    private final ModelPart pectoralfinleft;
    private final ModelPart tail;
    private final ModelPart dorsalfin;
    private final ModelPart pectoralfinright;
    private final ModelPart analfin;

    public HighFinnedBlueModel(ModelPart modelPart) {
        super(modelPart, RenderTypes::entityCutout);
        this.body = modelPart.getChild("body");
        this.pectoralfinleft = this.body.getChild("pectoralfinleft");
        this.tail = this.body.getChild("tail");
        this.dorsalfin = this.body.getChild("dorsalfin");
        this.pectoralfinright = this.body.getChild("pectoralfinright");
        this.analfin = this.body.getChild("analfin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, -1.5F, -3F, 1F, 3F, 6F).mirror(false), PartPose.offset(0F, 22.5F, 0F));
        PartDefinition pectoralfinleft = body.addOrReplaceChild("pectoralfinleft", CubeListBuilder.create().texOffs(0, 8).mirror().addBox(0F, 0F, -0.5F, 0F, 3F, 2F).mirror(false), PartPose.offsetAndRotation(0.5F, 1.5F, -1.5F, 0F, 0F, -0.2618F));
        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(5, 6).mirror().addBox(0F, -1.5F, 0F, 0F, 3F, 4F).mirror(false), PartPose.offset(0F, 0F, 3F));
        PartDefinition dorsalfin = body.addOrReplaceChild("dorsalfin", CubeListBuilder.create().texOffs(15, -3).mirror().addBox(0F, -6F, -0.5F, 0F, 6F, 3F).mirror(false), PartPose.offset(0F, -1.5F, 1.5F));
        PartDefinition pectoralfinright = body.addOrReplaceChild("pectoralfinright", CubeListBuilder.create().texOffs(0, 8).addBox(0F, 0F, -0.5F, 0F, 3F, 2F), PartPose.offsetAndRotation(-0.5F, 1.5F, -1.5F, 0F, 0F, 0.2618F));
        PartDefinition analfin = body.addOrReplaceChild("analfin", CubeListBuilder.create().texOffs(15, 4).mirror().addBox(0F, 0F, -0.5F, 0F, 6F, 3F).mirror(false), PartPose.offset(0F, 1.5F, 1.5F));

        return LayerDefinition.create(meshdefinition, 54, 22);
    }

    @Override
    public void setupAnim(HighFinnedBlueRenderState state) {
        super.setupAnim(state);
        float animTime = state.ageInTicks / 20.0F;

        if (state.moving) {
            this.body.yRot = (-(Mth.cos((animTime * 480F) * Mth.DEG_TO_RAD) * 2.5F)) * Mth.DEG_TO_RAD;
            this.body.y += -(Mth.cos((animTime * 180F) * Mth.DEG_TO_RAD) * 0.5F);
            this.pectoralfinleft.zRot = (-(Mth.sin((animTime * 480F) * Mth.DEG_TO_RAD) * (-7.5F))) * Mth.DEG_TO_RAD;
            this.tail.yRot = (-(Mth.sin((animTime * 480F) * Mth.DEG_TO_RAD) * 7F)) * Mth.DEG_TO_RAD;
            this.dorsalfin.zRot = (-(Mth.cos((animTime * 480F) * Mth.DEG_TO_RAD) * (-15F))) * Mth.DEG_TO_RAD;
            this.pectoralfinright.zRot = (-(Mth.sin((animTime * 480F) * Mth.DEG_TO_RAD) * 7.5F)) * Mth.DEG_TO_RAD;
            this.analfin.zRot = (-(Mth.cos((animTime * 480F) * Mth.DEG_TO_RAD) * 15F)) * Mth.DEG_TO_RAD;
        } else {
            this.body.xRot = (Mth.cos((animTime * 90F) * Mth.DEG_TO_RAD) * 2.5F) * Mth.DEG_TO_RAD;
            this.body.y += -(Mth.sin((animTime * 180F) * Mth.DEG_TO_RAD) * 0.25F);
            this.pectoralfinleft.zRot = (-(Mth.sin((animTime * 360F) * Mth.DEG_TO_RAD) * 2.5F)) * Mth.DEG_TO_RAD;
            this.tail.xRot = (Mth.cos((animTime * 180F) * Mth.DEG_TO_RAD) * 3.5F) * Mth.DEG_TO_RAD;
            this.dorsalfin.zRot = (-(Mth.cos((animTime * 360F) * Mth.DEG_TO_RAD) * 5F)) * Mth.DEG_TO_RAD;
            this.pectoralfinright.zRot = (-(Mth.sin((animTime * 360F) * Mth.DEG_TO_RAD) * (-2.5F))) * Mth.DEG_TO_RAD;
            this.analfin.zRot = (-(Mth.cos((animTime * 360F) * Mth.DEG_TO_RAD) * (-5F))) * Mth.DEG_TO_RAD;
        }

        if (!state.isInWater) {
            this.body.zRot = 1.5708F;
        }
    }
}
