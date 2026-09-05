package blueportal.finsandstails.client.model.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;

public class HorateeJetpackModel<T extends HumanoidRenderState> extends HumanoidModel<T> {
	public HorateeJetpackModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(deformation, 0.0F);
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.clearRecursively();

		PartDefinition head = partdefinition.getChild("head");
		PartDefinition body = partdefinition.getChild("body");
		PartDefinition armorBody = body.addOrReplaceChild("armorBody", CubeListBuilder.create().texOffs(0, 103).mirror().addBox(-4F, 0F, 2F, 8F, 10F, 2F).mirror(false).texOffs(16, 115).mirror().addBox(-1F, 1F, 4F, 1F, 9F, 4F).mirror(false).texOffs(32, 112).mirror().addBox(-4F, 0F, -2F, 8F, 12F, 4F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0F, 0F, 0F));
		PartDefinition rightJet = armorBody.addOrReplaceChild("rightJet", CubeListBuilder.create().texOffs(0, 115).mirror().addBox(-2F, 0F, -2F, 4F, 9F, 4F).mirror(false), PartPose.offset(4F, 2F, 5F));
		PartDefinition leftJet = armorBody.addOrReplaceChild("leftJet", CubeListBuilder.create().texOffs(0, 115).mirror().addBox(-3F, 0F, -2F, 4F, 9F, 4F).mirror(false), PartPose.offset(-3F, 2F, 5F));
		PartDefinition rightArm = partdefinition.getChild("right_arm");
		PartDefinition armorRightArm = rightArm.addOrReplaceChild("armorRightArm", CubeListBuilder.create().texOffs(32, 95).addBox(1F, -2F, -2F, 4F, 12F, 4F, new CubeDeformation(0.5F)).texOffs(0, 99).mirror().addBox(0F, -5.5F, -3F, 5F, 3F, 1F).mirror(false), PartPose.offset(0F, 0F, 0F));
		PartDefinition leftArm = partdefinition.getChild("left_arm");
		PartDefinition armorLeftArm = leftArm.addOrReplaceChild("armorLeftArm", CubeListBuilder.create().texOffs(32, 95).mirror().addBox(-5F, -2F, -2F, 4F, 12F, 4F, new CubeDeformation(0.5F)).mirror(false).texOffs(0, 99).addBox(-5F, -5.5F, -3F, 5F, 3F, 1F), PartPose.offset(0F, 0F, 0F));
		PartDefinition rightLeg = partdefinition.getChild("right_leg");
		PartDefinition leftLeg = partdefinition.getChild("left_leg");

		return LayerDefinition.create(meshdefinition, 64, 128);
	}
}
