package blueportal.finsandstails.client.model;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.render.state.FlatbackSuckerRenderState;
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

public class FlatbackSuckerModel extends EntityModel<FlatbackSuckerRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(FinsAndTails.id("flatback_sucker"), "main");

    private final ModelPart root;
    private final ModelPart finBackLeft;
    private final ModelPart finFrontLeft;
    private final ModelPart whiskers;
    private final ModelPart tail;
    private final ModelPart tailFin;
    private final ModelPart finBackRight;
    private final ModelPart finFrontRight;

    public FlatbackSuckerModel(ModelPart modelPart) {
        super(modelPart, RenderTypes::entityCutoutCull);
        this.root = modelPart.getChild("root");
        this.finBackLeft = this.root.getChild("finBackLeft");
        this.finFrontLeft = this.root.getChild("finFrontLeft");
        this.whiskers = this.root.getChild("whiskers");
        this.tail = this.root.getChild("tail");
        this.tailFin = this.tail.getChild("tailFin");
        this.finBackRight = this.root.getChild("finBackRight");
        this.finFrontRight = this.root.getChild("finFrontRight");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2F, -1F, -4.5F, 4F, 2F, 9F).mirror(false), PartPose.offset(0F, 23F, 0F));
        PartDefinition finBackLeft = root.addOrReplaceChild("finBackLeft", CubeListBuilder.create().texOffs(0, 16).addBox(0F, -0.5F, -1F, 1F, 1F, 2F), PartPose.offset(2F, 0.5F, 3.5F));
        PartDefinition finFrontLeft = root.addOrReplaceChild("finFrontLeft", CubeListBuilder.create().texOffs(0, 11).addBox(0F, -0.5F, -2F, 2F, 1F, 4F), PartPose.offset(2F, 0.5F, -1.5F));
        PartDefinition whiskers = root.addOrReplaceChild("whiskers", CubeListBuilder.create().texOffs(16, 0).mirror().addBox(-3F, 0F, -1F, 6F, 0F, 1F).mirror(false), PartPose.offset(0F, 0F, -4.5F));
        PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-1F, -0.5F, 0F, 2F, 1F, 2F).mirror(false), PartPose.offset(0F, 0.5F, 4.5F));
        PartDefinition tailFin = tail.addOrReplaceChild("tailFin", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0F, -2.5F, 0F, 0F, 4F, 3F).mirror(false), PartPose.offset(0F, 0F, 2F));
        PartDefinition finBackRight = root.addOrReplaceChild("finBackRight", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1F, -0.5F, -1F, 1F, 1F, 2F).mirror(false), PartPose.offset(-2F, 0.5F, 3.5F));
        PartDefinition finFrontRight = root.addOrReplaceChild("finFrontRight", CubeListBuilder.create().texOffs(0, 11).mirror().addBox(-2F, -0.5F, -2F, 2F, 1F, 4F).mirror(false), PartPose.offset(-2F, 0.5F, -1.5F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(FlatbackSuckerRenderState state) {
        super.setupAnim(state);
        float animTime = state.ageInTicks / 20.0F;

        if (state.moving) {
            this.root.xRot = (Mth.cos(((animTime - 0F) * 1440F) * Mth.DEG_TO_RAD) * 0.4F) * Mth.DEG_TO_RAD;
            this.root.yRot = (-(Mth.sin(((animTime - 0F) * 720F) * Mth.DEG_TO_RAD) * 4F)) * Mth.DEG_TO_RAD;
            this.root.y += -(Mth.cos(((animTime - 0F) * 720F) * Mth.DEG_TO_RAD) * 0.2F);
            this.finBackLeft.yRot = (-(Mth.sin(((animTime - 0.1F) * 720F) * Mth.DEG_TO_RAD) * 1F)) * Mth.DEG_TO_RAD;
            this.finFrontLeft.yRot = (-(Mth.sin(((animTime - 0.1F) * 720F) * Mth.DEG_TO_RAD) * 1F)) * Mth.DEG_TO_RAD;
            this.tail.yRot = (-(Mth.sin(((animTime - 0.1F) * 720F) * Mth.DEG_TO_RAD) * 8F)) * Mth.DEG_TO_RAD;
            this.tailFin.yRot = (-(Mth.sin(((animTime - 0.2F) * 720F) * Mth.DEG_TO_RAD) * 11F)) * Mth.DEG_TO_RAD;
            this.finBackRight.yRot = (-(Mth.sin(((animTime - 0.1F) * 720F) * Mth.DEG_TO_RAD) * 1F)) * Mth.DEG_TO_RAD;
            this.finFrontRight.yRot = (-(Mth.sin(((animTime - 0.1F) * 720F) * Mth.DEG_TO_RAD) * 1F)) * Mth.DEG_TO_RAD;
        } else {
            this.whiskers.xRot = (Mth.sin(((animTime - 0F) * 720F) * Mth.DEG_TO_RAD) * 5F) * Mth.DEG_TO_RAD;
            this.tail.yRot = (-(Mth.sin(((animTime - 0F) * 90F) * Mth.DEG_TO_RAD) * 16F)) * Mth.DEG_TO_RAD;
            this.tailFin.yRot = (-(Mth.sin(((animTime - 0.1F) * 90F) * Mth.DEG_TO_RAD) * 16F)) * Mth.DEG_TO_RAD;
        }
    }
}
