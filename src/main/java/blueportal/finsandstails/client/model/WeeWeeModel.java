package blueportal.finsandstails.client.model;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.render.state.WeeWeeRenderState;
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

public class WeeWeeModel extends EntityModel<WeeWeeRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(FinsAndTails.id("wee_wee"), "main");

    private final ModelPart root;
    private final ModelPart tailFin;
    private final ModelPart dorsalFin;
    private final ModelPart leftPectoralFin;
    private final ModelPart rightPectoralFin;

    public WeeWeeModel(ModelPart modelPart) {
        super(modelPart, RenderTypes::entityTranslucent);
        this.root = modelPart.getChild("root");
        this.tailFin = this.root.getChild("tailFin");
        this.dorsalFin = this.root.getChild("dorsalFin");
        this.leftPectoralFin = this.root.getChild("leftPectoralFin");
        this.rightPectoralFin = this.root.getChild("rightPectoralFin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, -0.5F, -1.5F, 1F, 1F, 3F).mirror(false), PartPose.offset(0F, 23.5F, 0F));
        root.addOrReplaceChild("tailFin", CubeListBuilder.create().texOffs(0, -1).mirror().addBox(0F, -1F, 0F, 0F, 2F, 1F).mirror(false), PartPose.offset(0F, 0F, 1.5F));
        root.addOrReplaceChild("dorsalFin", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(0F, -1.5F, 0F, 0F, 1F, 1F).mirror(false), PartPose.offset(0F, 0.5F, 0F));
        root.addOrReplaceChild("leftPectoralFin", CubeListBuilder.create().texOffs(5, 1).mirror().addBox(0F, -0.5F, 0F, 0F, 1F, 1F).mirror(false), PartPose.offsetAndRotation(0.5F, 0.5F, -0.5F, 0F, 0.3927F, 0F));
        root.addOrReplaceChild("rightPectoralFin", CubeListBuilder.create().texOffs(5, 1).mirror().addBox(0F, -0.5F, 0F, 0F, 1F, 1F).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.5F, -0.5F, 0F, -0.3927F, 0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(WeeWeeRenderState state) {
        super.setupAnim(state);
        float animTime = state.ageInTicks / 20.0F;

        if (state.moving) {
            this.root.yRot = (-(Mth.cos(((animTime - 0F) * 720F) * Mth.DEG_TO_RAD) * 7F)) * Mth.DEG_TO_RAD;
            this.tailFin.yRot = (-(Mth.cos(((animTime - 0.14F) * 720F) * Mth.DEG_TO_RAD) * 7F)) * Mth.DEG_TO_RAD;
            this.dorsalFin.yRot = (-(Mth.cos(((animTime - 0.14F) * 720F) * Mth.DEG_TO_RAD) * 8F)) * Mth.DEG_TO_RAD;
            this.leftPectoralFin.yRot = (-(Mth.cos(((animTime - 0.14F) * 720F) * Mth.DEG_TO_RAD) * 3F)) * Mth.DEG_TO_RAD;
            this.rightPectoralFin.yRot = (-(Mth.cos(((animTime - 0.14F) * 720F) * Mth.DEG_TO_RAD) * 3F)) * Mth.DEG_TO_RAD;
        } else {
            this.root.xRot = (Mth.sin(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * 1F) * Mth.DEG_TO_RAD;
            this.root.y += -(Mth.cos(((animTime - 0F) * 360F) * Mth.DEG_TO_RAD) * 0.1F);
            this.tailFin.xRot = (Mth.sin(((animTime - 0.2F) * 360F) * Mth.DEG_TO_RAD) * 4F) * Mth.DEG_TO_RAD;
            this.dorsalFin.xRot = (Mth.sin(((animTime - 0.2F) * 360F) * Mth.DEG_TO_RAD) * 4F) * Mth.DEG_TO_RAD;
            this.leftPectoralFin.xRot = (Mth.cos(((animTime - 0.2F) * 360F) * Mth.DEG_TO_RAD) * 4F) * Mth.DEG_TO_RAD;
            this.rightPectoralFin.xRot = (Mth.cos(((animTime - 0.2F) * 360F) * Mth.DEG_TO_RAD) * 4F) * Mth.DEG_TO_RAD;
        }

        if (!state.isInWater) {
            this.root.zRot = 1.5708F;
        }
    }
}
