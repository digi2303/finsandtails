package blueportal.finsandstails.common;

import blueportal.finsandstails.common.entities.ai.base.IHydrate;
import blueportal.finsandstails.network.FTMessages;
import blueportal.finsandstails.network.HitComboSyncS2CPacket;
import blueportal.finsandstails.registry.FTEnchantments;
import blueportal.finsandstails.registry.FTTags;
import blueportal.finsandstails.common.entities.PenglilEntity;
import blueportal.finsandstails.common.entities.WanderingSailorEntity;
import blueportal.finsandstails.common.entities.WherbleEntity;
import blueportal.finsandstails.common.entities.item.TealArrowfishArrowEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.entity.animal.fox.Fox;
import net.minecraft.world.entity.animal.wolf.Wolf;
import net.minecraft.world.entity.npc.villager.AbstractVillager;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.phys.AABB;

public class FTEvents {

    public static void bumpHitCombo(ServerPlayer player, Entity target) {
        FinsPlayerData data = (FinsPlayerData) player;
        int combo = data.finsandtails$getHitCombo();

        if (combo < 4) {
            data.finsandtails$setHitCombo(combo + 1);
        } else if (combo == 4) {
            data.finsandtails$setHitCombo(0);

            target.setDeltaMovement(target.getDeltaMovement().add(0.0D, 0.65D, 0.0D));
            target.playSound(SoundEvents.PLAYER_LEVELUP);

            for (int i = 0; i < 20; i++) {
                if (target.level() instanceof ServerLevel level) {
                    level.sendParticles(ParticleTypes.CRIT, target.getRandomX(1.0D), target.getRandomY(), target.getRandomZ(1.0D), 1, 0.0D, 0.0D, 0.0D, 0.0D);
                }
            }
        }

        FTMessages.sendToPlayer(new HitComboSyncS2CPacket(data.finsandtails$getHitCombo()), player);
    }

    public static void onArrowfishHit(Projectile projectile, HitResult result) {
        if (result instanceof EntityHitResult hitResult && hitResult.getEntity() instanceof LivingEntity target && projectile instanceof TealArrowfishArrowEntity fishArrow) {
            Entity owner = fishArrow.getOwner();

            if (owner instanceof Player player) {
                TargetingConditions conditions = TargetingConditions.forNonCombat();
                List<PenglilEntity> penglils = player.level().getEntities(EntityTypeTest.forClass(PenglilEntity.class), player.getBoundingBox().inflate(32.0D),
                        candidate -> !(player.level() instanceof ServerLevel serverLevel) || conditions.test(serverLevel, player, candidate));

                for (PenglilEntity penglil : penglils) {
                    if (penglil.isTame() && penglil.getOwnerReference() != null && !penglil.getOwnerReference().getUUID().equals(target.getUUID())) {
                        if (target instanceof TamableAnimal tamable) {
                            boolean flag = tamable.isTame() && tamable.getOwnerReference() != null && !tamable.getOwnerReference().getUUID().equals(owner.getUUID());

                            if (flag) {
                                penglil.setTarget(target);
                            } else {
                                return;
                            }
                        } else {
                            penglil.setTarget(target);
                        }
                    }
                }
            }
        }
    }

    public static void addWherbleGoals(Mob mob, GoalSelector goalSelector, GoalSelector targetSelector) {
        if (mob instanceof Wolf || mob instanceof Fox) {
            targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(mob, WherbleEntity.class, true));
        }
        if (mob instanceof AbstractVillager) {
            goalSelector.addGoal(0, new LookAtPlayerGoal(mob, WanderingSailorEntity.class, 6.0F));
        }
    }

    public static void onPlayerAttack(Player player, Entity target) {
        ItemStack mainhandItem = player.getMainHandItem();

        if (mainhandItem.is(FTTags.CLAW_GAUNTLETS) && player instanceof ServerPlayer serverPlayer) {
            bumpHitCombo(serverPlayer, target);
        }
    }

    public static InteractionResult onPlayerInteractEntity(Player player, InteractionHand hand, Entity target) {
        ItemStack offhandItem = player.getItemInHand(InteractionHand.OFF_HAND);

        if (offhandItem.is(FTTags.CLAW_GAUNTLETS)) {
            player.swing(InteractionHand.OFF_HAND);

            if (player instanceof ServerPlayer serverPlayer && target.hurtServer(serverPlayer.level(), player.level().damageSources().playerAttack(player), (float) player.getAttributeValue(Attributes.ATTACK_DAMAGE))) {
                offhandItem.hurtAndBreak(1, player, EquipmentSlot.OFFHAND);
                bumpHitCombo(serverPlayer, target);

                var uppercutting = FTEnchantments.get(serverPlayer.level().registryAccess(), FTEnchantments.UPPERCUTTING);
                if (EnchantmentHelper.getItemEnchantmentLevel(uppercutting, offhandItem) > 0) {
                    target.setDeltaMovement(target.getDeltaMovement().add(0.0D, 0.3D, 0.0D));
                }
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    public static void onPlayerDismountPenglil(Player player, InteractionHand hand, BlockPos pos, Direction dir) {
        if (player.isSecondaryUseActive() && player.getItemInHand(hand).isEmpty() && player.hasPassenger(e -> e instanceof PenglilEntity)) {
            PenglilEntity penglil = (PenglilEntity) player.getFirstPassenger();
            penglil.stopRiding();
            penglil.snapTo(pos.relative(dir), player.getYRot(), player.getXRot());
            player.swing(hand);
        }
    }

    public static void onSplashPotionHit(Projectile projectile, ItemStack stack) {
        PotionContents contents = stack.get(DataComponents.POTION_CONTENTS);

        if (contents != null && contents.is(Potions.WATER) && !contents.customEffects().iterator().hasNext()) {
            applyWater(projectile);
        }
    }

    private static void applyWater(Projectile projectile) {
        AABB aabb = projectile.getBoundingBox().inflate(4.0D, 2.0D, 4.0D);

        for (LivingEntity livingEntity : projectile.level().getEntitiesOfClass(LivingEntity.class, aabb)) {
            if (livingEntity instanceof IHydrate hydrate) {
                hydrate.rehydrate();
            }
        }
    }

    public static int crabsFavorExperience(ServerLevel level, Entity killer, int experience) {
        if (killer instanceof LivingEntity attacker) {
            ItemStack heldItem = attacker.getMainHandItem();
            ItemStack heldItemOffhand = attacker.getOffhandItem();
            var crabsFavor = FTEnchantments.get(level.registryAccess(), FTEnchantments.CRABS_FAVOR);
            int mainLevel = EnchantmentHelper.getItemEnchantmentLevel(crabsFavor, heldItem);
            int offLevel = EnchantmentHelper.getItemEnchantmentLevel(crabsFavor, heldItemOffhand);

            if (mainLevel > 0 && offLevel > 0) {
                return experience * mainLevel + level.getRandom().nextInt(3);
            }
        }

        return experience;
    }
}
