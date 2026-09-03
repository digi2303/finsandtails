package blueportal.finsandstails.client.model;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.render.state.VibraWeeRenderState;
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

public class VibraWeeModel extends EntityModel<VibraWeeRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(FinsAndTails.id("vibra_wee"), "main");

    private final ModelPart body;
    private final ModelPart belly;
    private final ModelPart leftPelvicFin;
    private final ModelPart rightPelvicFin;
    private final ModelPart tailFin;
    private final ModelPart leftPectoralFin;
    private final ModelPart dorsalFin;
    private final ModelPart rightPectoralFin;

    public VibraWeeModel(ModelPart modelPart) {
        super(modelPart, RenderTypes::entityCutout);
        this.body = modelPart.getChild("body");
        this.belly = this.body.getChild("belly");
        this.leftPelvicFin = this.belly.getChild("leftPelvicFin");
        this.rightPelvicFin = this.belly.getChild("rightPelvicFin");
        this.tailFin = this.body.getChild("tailFin");
        this.leftPectoralFin = this.body.getChild("leftPectoralFin");
        this.dorsalFin = this.body.getChild("dorsalFin");
        this.rightPectoralFin = this.body.getChild("rightPectoralFin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1F, -1F, -2.5F, 2F, 2F, 5F).mirror(false), PartPose.offset(0F, 22.5F, 0F));
        PartDefinition belly = body.addOrReplaceChild("belly", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-0.5F, 0F, -1.5F, 1F, 2F, 4F).mirror(false), PartPose.offset(0F, 1F, -0.5F));
        PartDefinition leftPelvicFin = belly.addOrReplaceChild("leftPelvicFin", CubeListBuilder.create().texOffs(8, 1).mirror().addBox(0F, 0F, -0.5F, 2F, 0F, 1F).mirror(false), PartPose.offsetAndRotation(0.5F, 2F, 1F, 0F, 0F, 0.96F));
        PartDefinition rightPelvicFin = belly.addOrReplaceChild("rightPelvicFin", CubeListBuilder.create().texOffs(8, 1).mirror().addBox(-2F, 0F, -0.5F, 2F, 0F, 1F).mirror(false), PartPose.offsetAndRotation(-0.5F, 2F, 1F, 0F, 0F, -0.96F));
        PartDefinition tailFin = body.addOrReplaceChild("tailFin", CubeListBuilder.create().texOffs(9, 0).mirror().addBox(0F, -1.5F, 0F, 0F, 3F, 2F).mirror(false), PartPose.offset(0F, -0.5F, 2F));
        PartDefinition leftPectoralFin = body.addOrReplaceChild("leftPectoralFin", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0F, -0.5F, 0F, 0F, 1F, 1F).mirror(false), PartPose.offsetAndRotation(1F, 1F, -0.5F, 0F, 0.64F, 0F));
        PartDefinition dorsalFin = body.addOrReplaceChild("dorsalFin", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(0F, -2F, -1F, 0F, 2F, 2F).mirror(false), PartPose.offset(0F, -1F, 0.5F));
        PartDefinition rightPectoralFin = body.addOrReplaceChild("rightPectoralFin", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0F, -0.5F, 0F, 0F, 1F, 1F).mirror(false), PartPose.offsetAndRotation(-1F, 1F, -0.5F, 0F, -0.64F, 0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(VibraWeeRenderState state) {
        super.setupAnim(state);
        float animTime = state.ageInTicks / 20.0F;

        if (state.moving) {
            this.leftPelvicFin.zRot = (-(45F + (Mth.sin(((animTime - 0.25F) * 720F) * Mth.DEG_TO_RAD) * 5F))) * Mth.DEG_TO_RAD;
            this.rightPelvicFin.zRot = (-((-45F) + (Mth.sin(((animTime - 0.25F) * 720F) * Mth.DEG_TO_RAD) * (-5F)))) * Mth.DEG_TO_RAD;
            this.tailFin.yRot = (-(Mth.sin(((animTime - 0.3F) * 360F) * Mth.DEG_TO_RAD) * 16F)) * Mth.DEG_TO_RAD;
            this.leftPectoralFin.xRot = (Mth.cos(((animTime - 0F) * 720F) * Mth.DEG_TO_RAD) * 2F) * Mth.DEG_TO_RAD;
            this.leftPectoralFin.yRot = (-((-12.5F) + (Mth.sin(((animTime - 0F) * 720F) * Mth.DEG_TO_RAD) * (-10F)))) * Mth.DEG_TO_RAD;
            this.rightPectoralFin.xRot = (Mth.cos(((animTime - 0F) * 720F) * Mth.DEG_TO_RAD) * 2F) * Mth.DEG_TO_RAD;
            this.rightPectoralFin.yRot = (-(12.5F + (Mth.sin(((animTime - 0F) * 720F) * Mth.DEG_TO_RAD) * 10F))) * Mth.DEG_TO_RAD;
        } else {
            this.leftPelvicFin.zRot = (-(40F + (Mth.cos(((animTime - 0.3F) * 180F) * Mth.DEG_TO_RAD) * (-4F)))) * Mth.DEG_TO_RAD;
            this.rightPelvicFin.zRot = (-((-40F) + (Mth.cos(((animTime - 0.3F) * 180F) * Mth.DEG_TO_RAD) * 4F))) * Mth.DEG_TO_RAD;
            this.tailFin.xRot = (Mth.cos(((animTime - 0.2F) * 180F) * Mth.DEG_TO_RAD) * (-5F)) * Mth.DEG_TO_RAD;
            this.leftPectoralFin.xRot = (-7.5F) * Mth.DEG_TO_RAD;
            this.leftPectoralFin.yRot = (-((-15F) + (Mth.sin(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * (-5F)))) * Mth.DEG_TO_RAD;
            this.rightPectoralFin.xRot = (-7.5F) * Mth.DEG_TO_RAD;
            this.rightPectoralFin.yRot = (-(15F + (Mth.sin(((animTime - 0F) * 180F) * Mth.DEG_TO_RAD) * 5F))) * Mth.DEG_TO_RAD;
        }

        if (!state.isInWater) {
            this.body.zRot = 1.5708F;
        }
    }
}
