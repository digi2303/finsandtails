package blueportal.finsandstails.client.model;

import blueportal.finsandstails.client.render.state.MudhorseRenderState;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import blueportal.finsandstails.client.animation.MudhorseAnimation;

@SuppressWarnings("FieldCanBeLocal, unused")
public class MudhorseModel extends EntityModel<MudhorseRenderState> {
    private final ModelPart all;
    private final ModelPart body;
    private final ModelPart torsoFins;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart eyes;
    private final ModelPart mouth;
    private final ModelPart leftFin;
    private final ModelPart rightFin;
    private final ModelPart pouch;
    private final ModelPart tail;
    private final ModelPart tailTip;
    private final ModelPart rightArm;
    private final ModelPart leftArm;

    private final KeyframeAnimation walkAnimation;
    private final KeyframeAnimation babyTransformAnimation;

    public MudhorseModel(ModelPart modelPart) {
        super(modelPart);

        this.all = this.root().getChild("all");

        this.body = this.all.getChild("body");
        this.tail = this.all.getChild("tail");
        this.rightArm = this.all.getChild("rightArm");
        this.leftArm = this.all.getChild("leftArm");

        this.torsoFins = this.body.getChild("torsoFins");
        this.neck = this.body.getChild("neck");
        this.pouch = this.body.getChild("pouch");

        this.head = this.neck.getChild("head");

        this.eyes = this.head.getChild("eyes");
        this.mouth = this.head.getChild("mouth");
        this.leftFin = this.head.getChild("leftFin");
        this.rightFin = this.head.getChild("rightFin");

        this.tailTip = this.tail.getChild("tailTip");

        this.walkAnimation = MudhorseAnimation.WALK.bake(modelPart);
        this.babyTransformAnimation = MudhorseAnimation.BABY_TRANSFORM.bake(modelPart);
    }

    @Override
    public void setupAnim(MudhorseRenderState state) {
        super.setupAnim(state);
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;
        float netHeadYaw = state.yRot;
        float headPitch = state.xRot;
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.head.xRot = headPitch * 0.017453292F;
        this.head.yRot = netHeadYaw * 0.017453292F;

        this.walkAnimation.applyWalk(limbSwing, limbSwingAmount, 3.0F, 100.0F);
        if (state.isBaby) this.babyTransformAnimation.applyStatic();
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition body = all.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -6.0F, -16.0F, 8.0F, 12.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.0F, 7.0F));
        PartDefinition torsoFins = body.addOrReplaceChild("torsoFins", CubeListBuilder.create().texOffs(0, 44).addBox(0.0F, -3.0F, -5.5F, 0.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -4.5F));
        PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(44, 42).addBox(-3.0F, -9.0F, -4.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -16.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 0).addBox(-3.0F, -7.0F, -5.0F, 6.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -2.0F));
        PartDefinition eyes = head.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(35, 60).addBox(-3.0F, -3.5F, -3.5F, 6.0F, 7.0F, 9.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, -3.5F, -1.5F));
        PartDefinition mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(56, 8).addBox(-1.5F, -1.5F, -8.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -5.0F));
        PartDefinition leftFin = head.addOrReplaceChild("leftFin", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -4.5F, 0.0F, 7.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -3.5F, 2.0F, 0.0F, -0.7854F, 0.0F));
        PartDefinition rightFin = head.addOrReplaceChild("rightFin", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-7.0F, -4.5F, 0.0F, 7.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -3.5F, 2.0F, 0.0F, 0.7854F, 0.0F));
        PartDefinition pouch = body.addOrReplaceChild("pouch", CubeListBuilder.create().texOffs(24, 30).addBox(-4.0F, 0.0F, -4.5F, 8.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, -2.5F));
        PartDefinition tail = all.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -3.0F, -2.0F, 6.0F, 19.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 8.0F));
        PartDefinition tailTip = tail.addOrReplaceChild("tailTip", CubeListBuilder.create().texOffs(49, 22).addBox(-3.0F, -4.0F, 0.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 58).addBox(-3.0F, -9.0F, 2.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 4.0F));
        PartDefinition rightArm = all.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(24, 42).mirror().addBox(-2.0F, 0.0F, -3.0F, 4.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -18.0F, -5.0F));
        PartDefinition leftArm = all.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(24, 42).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -18.0F, -5.0F));

        return LayerDefinition.create(meshdefinition, 80, 80);
    }
}
