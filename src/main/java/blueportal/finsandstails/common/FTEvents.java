package blueportal.finsandstails.common;

import blueportal.finsandstails.common.entities.ai.base.IHydrate;
import blueportal.finsandstails.network.FTMessages;
import blueportal.finsandstails.network.HitComboSyncS2CPacket;
import blueportal.finsandstails.registry.FTEnchantments;
import blueportal.finsandstails.registry.FTTags;
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

    public static void onPlayerAttack(Player player, Entity target) {
        ItemStack mainhandItem = player.getMainHandItem();

        if (mainhandItem.is(FTTags.CLAW_GAUNTLETS) && player instanceof ServerPlayer serverPlayer) {
            bumpHitCombo(serverPlayer, target);
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
