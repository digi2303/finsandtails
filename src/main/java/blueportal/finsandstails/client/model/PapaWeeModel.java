package blueportal.finsandstails.client.model;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.render.state.PapaWeeRenderState;
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

public class PapaWeeModel extends EntityModel<PapaWeeRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(FinsAndTails.id("papa_wee"), "main");

    private final ModelPart body;
    private final ModelPart lips;
    private final ModelPart tail;
    private final ModelPart caudalFin;
    private final ModelPart secondaryDorsalFin;
    private final ModelPart dorsalFin;
    private final ModelPart analFin;
    private final ModelPart rightPectoralFin;
    private final ModelPart leftPectoralFin;

    public PapaWeeModel(ModelPart modelPart) {
        super(modelPart, RenderTypes::entityCutoutCull);
        this.body = modelPart.getChild("body");
        this.lips = this.body.getChild("lips");
        this.tail = this.body.getChild("tail");
        this.caudalFin = this.tail.getChild("caudal_fin");
        this.secondaryDorsalFin = this.body.getChild("secondary_dorsal_fin");
        this.dorsalFin = this.body.getChild("dorsal_fin");
        this.analFin = this.body.getChild("anal_fin");
        this.rightPectoralFin = this.body.getChild("right_pectoral_fin");
        this.leftPectoralFin = this.body.getChild("left_pectoral_fin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.5F, -3.5F, -4.5F, 7F, 7F, 9F).mirror(false), PartPose.offset(0F, 20.5F, 0F));
        PartDefinition lips = body.addOrReplaceChild("lips", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-4F, 0F, -1F, 8F, 1F, 5F).mirror(false), PartPose.offset(0F, 0.5F, -4.5F));
        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(16, 24).mirror().addBox(-1.5F, -1.5F, 0F, 3F, 3F, 4F).mirror(false), PartPose.offset(0F, -1F, 4.5F));
        PartDefinition caudalFin = tail.addOrReplaceChild("caudal_fin", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(0F, -4.5F, 0F, 0F, 9F, 5F).mirror(false), PartPose.offset(0F, -1F, 2F));
        PartDefinition secondaryDorsalFin = body.addOrReplaceChild("secondary_dorsal_fin", CubeListBuilder.create().texOffs(0, 2).mirror().addBox(0F, -2F, -2F, 0F, 2F, 4F).mirror(false), PartPose.offset(0F, -2.5F, 3.5F));
        PartDefinition dorsalFin = body.addOrReplaceChild("dorsal_fin", CubeListBuilder.create().texOffs(0, -2).mirror().addBox(0F, -3F, -2F, 0F, 3F, 4F).mirror(false), PartPose.offset(0F, -3.5F, -1.5F));
        PartDefinition analFin = body.addOrReplaceChild("anal_fin", CubeListBuilder.create().texOffs(5, -2).mirror().addBox(0F, 0F, 0F, 0F, 2F, 2F).mirror(false), PartPose.offset(0F, 2.5F, 3.5F));
        PartDefinition rightPectoralFin = body.addOrReplaceChild("right_pectoral_fin", CubeListBuilder.create().texOffs(0, -2).addBox(0F, 0F, -1F, 0F, 2F, 2F), PartPose.offset(-3F, 3.5F, -0.5F));
        PartDefinition leftPectoralFin = body.addOrReplaceChild("left_pectoral_fin", CubeListBuilder.create().texOffs(0, -2).mirror().addBox(0F, 0F, -1F, 0F, 2F, 2F).mirror(false), PartPose.offset(3F, 3.5F, -0.5F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(PapaWeeRenderState state) {
        super.setupAnim(state);
        float animTime = state.ageInTicks / 20.0F;

        if (state.moving) {
            this.lips.xRot = (2F + (Mth.sin(((animTime - 0.3F) * 180F) * Mth.DEG_TO_RAD) * 1F)) * Mth.DEG_TO_RAD;
            this.tail.yRot = (-(Mth.sin(((animTime - 0.25F) * 360F) * Mth.DEG_TO_RAD) * 7F)) * Mth.DEG_TO_RAD;
            this.caudalFin.yRot = (-(Mth.sin(((animTime - 0.4F) * 360F) * Mth.DEG_TO_RAD) * 9F)) * Mth.DEG_TO_RAD;
            this.secondaryDorsalFin.zRot = (-(Mth.sin(((animTime - 0.32F) * 360F) * Mth.DEG_TO_RAD) * 8F)) * Mth.DEG_TO_RAD;
            this.dorsalFin.zRot = (-(Mth.sin(((animTime - 0.25F) * 360F) * Mth.DEG_TO_RAD) * 8F)) * Mth.DEG_TO_RAD;
            this.analFin.zRot = (-(Mth.sin(((animTime - 0.37F) * 360F) * Mth.DEG_TO_RAD) * (-8F))) * Mth.DEG_TO_RAD;
            this.rightPectoralFin.xRot = (Mth.sin(((animTime - 0F) * 720F) * Mth.DEG_TO_RAD) * 12F) * Mth.DEG_TO_RAD;
            this.rightPectoralFin.zRot = (-((-42.5F) + (Mth.cos(((animTime - 0F) * 720F) * Mth.DEG_TO_RAD) * 25F))) * Mth.DEG_TO_RAD;
            this.leftPectoralFin.xRot = (Mth.sin(((animTime - 0F) * 720F) * Mth.DEG_TO_RAD) * 12F) * Mth.DEG_TO_RAD;
            this.leftPectoralFin.zRot = (-(42.5F + (Mth.cos(((animTime - 0F) * 720F) * Mth.DEG_TO_RAD) * (-25F)))) * Mth.DEG_TO_RAD;
            this.body.xRot = (Mth.cos(((animTime - 0.2F) * 180F) * Mth.DEG_TO_RAD) * (-2F)) * Mth.DEG_TO_RAD;
            this.body.yRot = (-(Mth.sin(((animTime - 0.15F) * 360F) * Mth.DEG_TO_RAD) * 5F)) * Mth.DEG_TO_RAD;
            this.body.y += -(Mth.sin(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * 0.2F);
        } else {
            this.lips.xRot = (2.5F + (Mth.cos(((animTime - 0F) * 120F) * Mth.DEG_TO_RAD) * 1F)) * Mth.DEG_TO_RAD;
            this.tail.xRot = (Mth.cos(((animTime - 0.2F) * 120F) * Mth.DEG_TO_RAD) * (-3F)) * Mth.DEG_TO_RAD;
            this.caudalFin.xRot = (Mth.cos(((animTime - 0.3F) * 120F) * Mth.DEG_TO_RAD) * (-4F)) * Mth.DEG_TO_RAD;
            this.rightPectoralFin.zRot = (-((-60F) + (Mth.cos(((animTime - 0.15F) * 960F) * Mth.DEG_TO_RAD) * 14F))) * Mth.DEG_TO_RAD;
            this.leftPectoralFin.zRot = (-(60F + (Mth.cos(((animTime - 0.15F) * 960F) * Mth.DEG_TO_RAD) * (-14F)))) * Mth.DEG_TO_RAD;
            this.body.xRot = (Mth.cos(((animTime - 0.2F) * 120F) * Mth.DEG_TO_RAD) * (-3F)) * Mth.DEG_TO_RAD;
            this.body.y += -(Mth.sin(((animTime - 0F) * 120F) * Mth.DEG_TO_RAD) * 0.25F);
        }
    }
}
