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

public class FwingedBootsModel<T extends HumanoidRenderState> extends HumanoidModel<T> {

	public FwingedBootsModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(deformation, 0.0F);
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.getChild("head");
		PartDefinition body = partdefinition.getChild("body");
		PartDefinition rightArm = partdefinition.getChild("right_arm");
		PartDefinition leftArm = partdefinition.getChild("left_arm");
		PartDefinition rightLeg = partdefinition.getChild("right_leg");
		PartDefinition armorRightBoot = rightLeg.addOrReplaceChild("armorRightBoot", CubeListBuilder.create().texOffs(0, 118).addBox(2F, 6F, -2F, 4F, 6F, 4F, new CubeDeformation(0.06F)).texOffs(0, 104).addBox(5.25F, 10F, -7.75F, 1F, 2F, 6F, new CubeDeformation(0.06F)).texOffs(0, 104).addBox(1.75F, 10F, -7.75F, 1F, 2F, 6F, new CubeDeformation(0.06F)).texOffs(3, 104).addBox(2F, 11F, -6.75F, 4F, 0F, 5F).texOffs(16, 117).addBox(2F, 5F, -2F, 4F, 3F, 4F, new CubeDeformation(0.1F)), PartPose.offset(0F, 0F, 0F));
		PartDefinition leftLeg = partdefinition.getChild("left_leg");
		PartDefinition armorLeftBoot = leftLeg.addOrReplaceChild("armorLeftBoot", CubeListBuilder.create().texOffs(0, 118).mirror().addBox(-6F, 6F, -2F, 4F, 6F, 4F, new CubeDeformation(0.06F)).mirror(false).texOffs(0, 104).mirror().addBox(-6.25F, 10F, -7.75F, 1F, 2F, 6F, new CubeDeformation(0.06F)).mirror(false).texOffs(0, 104).mirror().addBox(-2.75F, 10F, -7.75F, 1F, 2F, 6F, new CubeDeformation(0.06F)).mirror(false).texOffs(3, 104).mirror().addBox(-6F, 11F, -6.75F, 4F, 0F, 5F).mirror(false).texOffs(16, 117).mirror().addBox(-6F, 5F, -2F, 4F, 3F, 4F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(0F, 0F, 0F));

		return LayerDefinition.create(meshdefinition, 64, 128);
	}
}
