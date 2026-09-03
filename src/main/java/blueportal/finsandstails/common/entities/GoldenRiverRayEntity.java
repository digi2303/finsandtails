package blueportal.finsandstails.common.entities;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.fish.AbstractFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import blueportal.finsandstails.common.entities.ai.control.FTSmoothSwimmingMoveControl;
import blueportal.finsandstails.registry.FTItems;

import org.jetbrains.annotations.Nullable;
//? if >=26.2 {
/*import net.minecraft.world.entity.Bucketable;
*///?} else {
import net.minecraft.world.entity.animal.Bucketable;
//?}

public class GoldenRiverRayEntity extends AbstractFish {
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(GoldenRiverRayEntity.class, EntityDataSerializers.INT);

    public GoldenRiverRayEntity(EntityType<? extends GoldenRiverRayEntity> type, Level world) {
        super(type, world);
        this.moveControl = new FTSmoothSwimmingMoveControl(this, 85, 10, 1.0F, 0.5F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 50);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.85D));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, RiverPebbleSnailEntity.class, false, (entity, level) -> entity.isInWater()));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6).add(Attributes.ATTACK_DAMAGE, 1);
    }

    public void playerTouch(Player entityIn) {
        if (entityIn instanceof ServerPlayer player && player.hurtOrSimulate(this.level().damageSources().mobAttack(this), 1) && player.getArmorCoverPercentage() <= 0.0D) {
            ((ServerPlayer)entityIn).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.PUFFER_FISH_STING, 0.0F));
            entityIn.addEffect(new MobEffectInstance(MobEffects.POISON, 120, 0));
        }
    }

    @Override
    public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
        Entity attacker = source.getDirectEntity();
        if (attacker instanceof LivingEntity) {
            ((LivingEntity) attacker).addEffect(new MobEffectInstance(MobEffects.POISON, 200, 0));
            attacker.hurtOrSimulate(this.level().damageSources().mobAttack(this), 1);
        }
        return super.hurtServer(level, source, amount);
    }

    @Override
    public void loadFromBucketTag(CompoundTag p_148708_) {
        Bucketable.loadDefaultDataFromBucketTag(this, p_148708_);
        if (p_148708_.contains("Variant")) {
            this.setVariant(p_148708_.getIntOr("Variant", 0));
        }
    }

    public void saveToBucketTag(ItemStack bucket) {
        CompoundTag compoundnbt = new CompoundTag();
        compoundnbt.putInt("Variant", this.getVariant());
        if (this.hasCustomName()) {
            bucket.set(DataComponents.CUSTOM_NAME, this.getCustomName());
        }

        bucket.set(DataComponents.BUCKET_ENTITY_DATA, CustomData.of(compoundnbt));
    }

    @Override
    public void travel(Vec3 p_27490_) {
        if (isInWater() && getTarget() != null && getTarget().isAlive()) {
            PathNavigation nav = getNavigation();

            Path path = nav.createPath(getTarget(), 1);

            nav.moveTo(path, 5.0D);
        }
        super.travel(p_27490_);
    }

    @Override
    public void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT, 0);
    }

    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    private void setVariant(int variant) {
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

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, EntitySpawnReason reason, @Nullable SpawnGroupData spawnDataIn) {
        spawnDataIn = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn);
        if (reason != EntitySpawnReason.BUCKET) {
            setVariant(random.nextInt(3));
        }
        return spawnDataIn;
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(FTItems.GOLDEN_RIVER_RAY_BUCKET);
    }

    public SoundEvent getAmbientSound() {
        return SoundEvents.COD_AMBIENT;
    }

    public SoundEvent getDeathSound() {
        return SoundEvents.COD_DEATH;
    }

    public SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.COD_HURT;
    }

    public SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(FTItems.GOLDEN_RIVER_RAY_SPAWN_EGG);
    }
}
