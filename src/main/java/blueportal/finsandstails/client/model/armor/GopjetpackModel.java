package blueportal.finsandstails.client.model.armor;

import blueportal.finsandstails.client.FinsRenderState;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.util.Mth;

public class GopjetpackModel extends HumanoidModel<AvatarRenderState> {
	private final ModelPart gopjetpack;
	private final ModelPart rightJet;
	private final ModelPart leftJet;

	public GopjetpackModel(ModelPart root) {
		super(root);
		this.gopjetpack = root.getChild("body").getChild("gopjetpack");
		this.rightJet = this.gopjetpack.getChild("rightJet");
		this.leftJet = this.gopjetpack.getChild("leftJet");
	}

	public static LayerDefinition createArmorLayer(CubeDeformation deformation) {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(deformation, 0.0F);
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.getChild("body");

		PartDefinition gopjetpack = body.addOrReplaceChild("gopjetpack", CubeListBuilder.create().texOffs(0, 103).addBox(-4.0F, 0.0F, 2.0F, 8.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition rightJet = gopjetpack.addOrReplaceChild("rightJet", CubeListBuilder.create().texOffs(0, 115).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 2.0F, 4.0F));
		PartDefinition leftJet = gopjetpack.addOrReplaceChild("leftJet", CubeListBuilder.create().texOffs(0, 115).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 2.0F, 4.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(AvatarRenderState state) {
		super.setupAnim(state);

		if (state instanceof FinsRenderState finsState && finsState.finsandtails$isFinsFlying()) {
			this.rightJet.yScale = Mth.cos(state.ageInTicks) * 0.5F * 0.25F + 1;
			this.leftJet.yScale = Mth.sin(state.ageInTicks) * 0.5F * 0.25F + 1;
		} else {
			this.rightJet.yScale = 1;
			this.leftJet.yScale = 1;
		}
	}
}
