package blueportal.finsandstails.common.entities.ai.base;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.fish.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;

import org.jetbrains.annotations.Nullable;
import java.util.Optional;
import java.util.UUID;

public abstract class AgeableWaterAnimal extends WaterAnimal {
    private static final EntityDataAccessor<Boolean> DATA_BABY_ID = SynchedEntityData.defineId(AgeableWaterAnimal.class, EntityDataSerializers.BOOLEAN);
    private static final Ingredient FOOD_ITEMS = Ingredient.of();
    public static final int BABY_START_AGE = -24000;
    protected int age;
    protected int forcedAge;
    protected int forcedAgeTimer;

    protected AgeableWaterAnimal(EntityType<? extends AgeableWaterAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.02F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, EntitySpawnReason pReason, @Nullable SpawnGroupData pSpawnData) {
        if (pSpawnData == null) {
            pSpawnData = new AgeableMob.AgeableMobGroupData(true);
        }

        AgeableMob.AgeableMobGroupData ageablemob$ageablemobgroupdata = (AgeableMob.AgeableMobGroupData) pSpawnData;
        if (ageablemob$ageablemobgroupdata.isShouldSpawnBaby() && ageablemob$ageablemobgroupdata.getGroupSize() > 0 && pLevel.getRandom().nextFloat() <= ageablemob$ageablemobgroupdata.getBabySpawnChance()) {
            this.setAge(BABY_START_AGE);
        }

        ageablemob$ageablemobgroupdata.increaseGroupSizeByOne();
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData);
    }

    @Nullable
    public abstract AgeableWaterAnimal getBreedOffspring(ServerLevel pLevel, AgeableWaterAnimal pOtherParent);

    public int getAge() {
        if (this.level().isClientSide()) {
            return this.entityData.get(DATA_BABY_ID) ? -1 : 1;
        } else {
            return this.age;
        }
    }

    public void ageUp(int pAmount, boolean pForced) {
        int i = this.getAge();
        i += pAmount * 20;
        if (i > 0) {
            i = 0;
        }

        int j = 0;
        this.setAge(i);
        if (pForced) {
            this.forcedAge += j;
            if (this.forcedAgeTimer == 0) {
                this.forcedAgeTimer = 40;
            }
        }

        if (this.getAge() == 0) {
            this.setAge(this.forcedAge);
        }
    }

    public void ageUp(int pAmount) {
        this.ageUp(pAmount, false);
    }

    public void setAge(int pAge) {
        int i = this.getAge();
        this.age = pAge;
        if (i < 0 && pAge >= 0 || i >= 0 && pAge < 0) {
            this.entityData.set(DATA_BABY_ID, pAge < 0);
            this.ageBoundaryReached();
        }
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
        if (DATA_BABY_ID.equals(pKey)) {
            this.refreshDimensions();
        }

        super.onSyncedDataUpdated(pKey);
    }

    protected void ageBoundaryReached() {
        if (!this.isBaby() && this.isPassenger()) {
            Entity entity = this.getVehicle();
            if (entity instanceof Boat) {
                Boat boat = (Boat) entity;
                if (!boat.hasEnoughSpaceFor(this)) {
                    this.stopRiding();
                }
            }
        }
    }

    public boolean isBaby() {
        return this.getAge() < 0;
    }

    public void setBaby(boolean pBaby) {
        this.setAge(pBaby ? BABY_START_AGE : 0);
    }

    public static int getSpeedUpSecondsWhenFeeding(int pTicksUntilAdult) {
        return (int) ((float) (pTicksUntilAdult / 20) * 0.1F);
    }

    public static class AgeableFishGroupData implements SpawnGroupData {
        private int groupSize;
        private final boolean shouldSpawnBaby;
        private final float babySpawnChance;

        private AgeableFishGroupData(boolean pShouldSpawnBaby, float pBabySpawnChance) {
            this.shouldSpawnBaby = pShouldSpawnBaby;
            this.babySpawnChance = pBabySpawnChance;
        }

        public AgeableFishGroupData(boolean pShouldSpawnBaby) {
            this(pShouldSpawnBaby, 0.05F);
        }

        public AgeableFishGroupData(float pBabySpawnChance) {
            this(true, pBabySpawnChance);
        }

        public int getGroupSize() {
            return this.groupSize;
        }

        public void increaseGroupSizeByOne() {
            ++this.groupSize;
        }

        public boolean isShouldSpawnBaby() {
            return this.shouldSpawnBaby;
        }

        public float getBabySpawnChance() {
            return this.babySpawnChance;
        }
    }

    //animal

    protected static final int PARENT_AGE_AFTER_BREEDING = 6000;
    private int inLove;
    @Nullable
    private UUID loveCause;

    protected void customServerAiStep(ServerLevel pLevel) {
        if (this.getAge() != 0) {
            this.inLove = 0;
        }

        super.customServerAiStep(pLevel);
    }

    @Override
    public boolean hurtServer(ServerLevel pLevel, DamageSource pSource, float pAmount) {
        if (this.isInvulnerableTo(pLevel, pSource)) {
            return false;
        } else {
            this.inLove = 0;
            return super.hurtServer(pLevel, pSource, pAmount);
        }
    }

    public int getExperienceReward() {
        return 1 + this.level().getRandom().nextInt(3);
    }

    protected void usePlayerItem(Player pPlayer, InteractionHand pHand, ItemStack pStack) {
        if (!pPlayer.getAbilities().instabuild) {
            pStack.shrink(1);
        }
    }

    public boolean canFallInLove() {
        return this.inLove <= 0;
    }

    public void setInLove(@Nullable Player pPlayer) {
        this.inLove = 600;
        if (pPlayer != null) {
            this.loveCause = pPlayer.getUUID();
        }

        this.level().broadcastEntityEvent(this, (byte) 18);
    }

    public void setInLoveTime(int pInLove) {
        this.inLove = pInLove;
    }

    public int getInLoveTime() {
        return this.inLove;
    }

    @Nullable
    public ServerPlayer getLoveCause() {
        if (this.loveCause == null) {
            return null;
        } else {
            Player player = this.level().getPlayerByUUID(this.loveCause);
            return player instanceof ServerPlayer ? (ServerPlayer) player : null;
        }
    }

    public boolean isInLove() {
        return this.inLove > 0;
    }

    public void resetLove() {
        this.inLove = 0;
    }

    public boolean canMate(AgeableWaterAnimal pOtherAnimal) {
        if (pOtherAnimal == this) {
            return false;
        } else if (pOtherAnimal.getClass() != this.getClass()) {
            return false;
        } else {
            return this.isInLove() && pOtherAnimal.isInLove();
        }
    }

//    public void spawnChildFromBreeding(ServerLevel pLevel, AgeableWaterAnimal pMate) {
//        AgeableWaterAnimal ageablemob = this.getBreedOffspring(pLevel, pMate);
//        BabyFishSpawnEvent event = new BabyFishSpawnEvent(this, pMate, ageablemob);
//        boolean cancelled = MinecraftForge.EVENT_BUS.post(event);
//        ageablemob = event.getChild();
//        if (cancelled) {
//            this.setAge(6000);
//            pMate.setAge(6000);
//            this.resetLove();
//            pMate.resetLove();
//        } else {
//            if (ageablemob != null) {
//                ageablemob.setBaby(true);
//                ageablemob.snapTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
//                this.finalizeSpawnChildFromBreeding(pLevel, pMate, ageablemob);
//                pLevel.addFreshEntityWithPassengers(ageablemob);
//            }
//
//        }
//    }

    public void spawnChildFromBreeding(ServerLevel pLevel, AgeableWaterAnimal pMate) {
        AgeableWaterAnimal ageablemob = this.getBreedOffspring(pLevel, pMate);

        if (ageablemob != null) {
            ageablemob.setAge(-12000);
            ageablemob.snapTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
            this.finalizeSpawnChildFromBreeding(pLevel, pMate, ageablemob);
            pLevel.addFreshEntityWithPassengers(ageablemob);
        }
    }

    public void finalizeSpawnChildFromBreeding(ServerLevel pLevel, AgeableWaterAnimal pAnimal, @Nullable AgeableWaterAnimal pBaby) {
        Optional.ofNullable(this.getLoveCause()).or(() -> {
            return Optional.ofNullable(pAnimal.getLoveCause());
        }).ifPresent((p_277486_) -> {
            p_277486_.awardStat(Stats.ANIMALS_BRED);
            //CriteriaTriggers.BRED_ANIMALS.trigger(p_277486_, this, pAnimal, pBaby);
        });
        this.setAge(6000);
        pAnimal.setAge(6000);
        this.resetLove();
        pAnimal.resetLove();
        pLevel.broadcastEntityEvent(this, (byte) 18);
        if (pLevel.getGameRules().get(GameRules.MOB_DROPS)) {
            pLevel.addFreshEntity(new ExperienceOrb(pLevel, this.getX(), this.getY(), this.getZ(), this.getRandom().nextInt(7) + 1));
        }
    }

    public void handleEntityEvent(byte pId) {
        if (pId == 18) {
            for (int i = 0; i < 7; ++i) {
                double d0 = this.random.nextGaussian() * 0.02D;
                double d1 = this.random.nextGaussian() * 0.02D;
                double d2 = this.random.nextGaussian() * 0.02D;
                this.level().addParticle(ParticleTypes.HEART, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d0, d1, d2);
            }
        } else {
            super.handleEntityEvent(pId);
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_BABY_ID, false);
    }

    @Override
    public void addAdditionalSaveData(ValueOutput pOutput) {
        super.addAdditionalSaveData(pOutput);
        pOutput.putInt("Age", this.getAge());
        pOutput.putInt("ForcedAge", this.forcedAge);

        pOutput.putInt("InLove", this.inLove);
        if (this.loveCause != null) {
            pOutput.store("LoveCause", UUIDUtil.CODEC, this.loveCause);
        }
    }

    @Override
    public void readAdditionalSaveData(ValueInput pInput) {
        super.readAdditionalSaveData(pInput);
        this.setAge(pInput.getIntOr("Age", 0));
        this.forcedAge = pInput.getIntOr("ForcedAge", 0);
        this.inLove = pInput.getIntOr("InLove", 0);
        this.loveCause = pInput.read("LoveCause", UUIDUtil.CODEC).orElse(null);
    }

    @Override
    protected PathNavigation createNavigation(Level pLevel) {
        return new WaterBoundPathNavigation(this, pLevel);
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (this.level().isClientSide()) {
            if (this.forcedAgeTimer > 0) {
                if (this.forcedAgeTimer % 4 == 0) {
                    this.level().addParticle(ParticleTypes.HAPPY_VILLAGER, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), 0.0D, 0.0D, 0.0D);
                }

                --this.forcedAgeTimer;
            }
        } else if (this.isAlive()) {
            int i = this.getAge();
            if (i < 0) {
                ++i;
                this.setAge(i);
            } else if (i > 0) {
                --i;
                this.setAge(i);
            }
        }

        if (this.getAge() != 0) {
            this.inLove = 0;
        }

        if (this.inLove > 0) {
            --this.inLove;
            if (this.inLove % 10 == 0) {
                double d0 = this.random.nextGaussian() * 0.02D;
                double d1 = this.random.nextGaussian() * 0.02D;
                double d2 = this.random.nextGaussian() * 0.02D;
                this.level().addParticle(ParticleTypes.HEART, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d0, d1, d2);
            }
        }
    }

    @Override
    public InteractionResult interact(Player pPlayer, InteractionHand pHand, Vec3 pVec) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);

        if (this.isFood(itemstack)) {
            int i = this.getAge();
            if (!this.level().isClientSide() && i == 0 && this.canFallInLove()) {
                this.usePlayerItem(pPlayer, pHand, itemstack);
                this.setInLove(pPlayer);
                return InteractionResult.SUCCESS;
            }

            if (this.isBaby()) {
                this.usePlayerItem(pPlayer, pHand, itemstack);
                this.ageUp(getSpeedUpSecondsWhenFeeding(-i), true);
                return InteractionResult.SUCCESS;
            }

            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            }
        }

        return super.interact(pPlayer, pHand, pVec);
    }

    public boolean isFood(ItemStack pStack) {
        return FOOD_ITEMS.test(pStack);
    }
}
