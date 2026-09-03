package blueportal.finsandstails.common.entities;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.FollowFlockLeaderGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.animal.fish.AbstractSchoolingFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import blueportal.finsandstails.registry.FTItems;

import org.jetbrains.annotations.Nullable;
//? if >=26.2 {
/*import net.minecraft.world.entity.Bucketable;
*///?} else {
import net.minecraft.world.entity.animal.Bucketable;
//?}

public class NightLightSquidEntity extends AbstractSchoolingFish {
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(NightLightSquidEntity.class, EntityDataSerializers.INT);
    public float prevSquidPitch;
    public float squidRotation;

    public NightLightSquidEntity(EntityType<? extends NightLightSquidEntity> type, Level worldIn) {
        super(type, worldIn);
        this.moveControl = new SmoothSwimmingMoveControl(this, 90, 10, 0.02F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }

    @Override
    public int getMaxHeadXRot() {
        return 90;
    }

    public void registerGoals() {
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(1, new FollowFlockLeaderGoal(this));
        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 1.0D, 1));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D);
    }

    @Override
    public int getMaxSchoolSize() {
        return 8;
    }

    public SoundEvent getAmbientSound() {
        return SoundEvents.SQUID_AMBIENT;
    }

    public SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.SQUID_HURT;
    }

    public SoundEvent getDeathSound() {
        return SoundEvents.SQUID_DEATH;
    }

    public float getSoundVolume() {
        return 0.4F;
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(FTItems.NIGHT_LIGHT_SQUID_BUCKET);
    }

    @Override
    public SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, EntitySpawnReason reason, @Nullable SpawnGroupData spawnDataIn) {
        if (reason != EntitySpawnReason.BUCKET) {
            setVariant(random.nextInt(4));
        }
        return spawnDataIn;
    }

    public void loadFromBucketTag(CompoundTag p_148708_) {
        Bucketable.loadDefaultDataFromBucketTag(this, p_148708_);
        if (p_148708_.contains("Variant")) {
            this.setVariant(p_148708_.getIntOr("Variant", 0));
        }
    }

    public void saveToBucketTag(ItemStack bucket) {
        CompoundTag compoundnbt = new CompoundTag();
        compoundnbt.putInt("Variant", this.getVariant());

        bucket.set(DataComponents.BUCKET_ENTITY_DATA, CustomData.of(compoundnbt));
    }

    @Override
    public void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT, 0);
    }

    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    public void setVariant(int variant) {
        this.entityData.set(VARIANT, variant);
    }

    @Override
    public void addAdditionalSaveData(ValueOutput compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", getVariant());
    }

    @Override
    public void readAdditionalSaveData(ValueInput compound) {
        super.readAdditionalSaveData(compound);
        setVariant(compound.getIntOr("Variant", 0));
    }

    public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
        if (super.hurtServer(level, source, amount) && this.getLastHurtByMob() != null) {
            this.squirtInk();
            return true;
        } else {
            return false;
        }
    }

    private Vec3 rotateVector(Vec3 p_207400_1_) {
        Vec3 vector3d = p_207400_1_.xRot(this.prevSquidPitch * ((float) Math.PI / 180F));
        return vector3d.yRot(-this.yBodyRotO * ((float) Math.PI / 180F));
    }

    private void squirtInk() {
        this.playSound(SoundEvents.SQUID_SQUIRT, this.getSoundVolume(), this.getVoicePitch());
        Vec3 vector3d = this.rotateVector(new Vec3(0.0D, -1.0D, 0.0D)).add(this.getX(), this.getY(), this.getZ());

        for (int i = 0; i < 30; ++i) {
            Vec3 vector3d1 = this.rotateVector(new Vec3((double) this.random.nextFloat() * 0.6D - 0.3D, -1.0D, (double) this.random.nextFloat() * 0.6D - 0.3D));
            Vec3 vector3d2 = vector3d1.scale(0.3D + (double) (this.random.nextFloat() * 2.0F));
            ((ServerLevel) this.level()).sendParticles(ParticleTypes.SQUID_INK, vector3d.x, vector3d.y + 0.5D, vector3d.z, 0, vector3d2.x, vector3d2.y, vector3d2.z, (double) 0.1F);
        }
    }

    public void travel(Vec3 travelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.01F, travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(travelVector);
        }

    }

    public void handleEntityEvent(byte id) {
        if (id == 19) {
            this.squidRotation = 0.0F;
        } else {
            super.handleEntityEvent(id);
        }
    }
}
