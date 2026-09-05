package blueportal.finsandstails.common.entities;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.npc.villager.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import blueportal.finsandstails.registry.FTItems;
import blueportal.finsandstails.registry.FTSounds;

import org.jetbrains.annotations.Nullable;
import java.util.Optional;
import java.util.Set;

public class WanderingSailorEntity extends AbstractVillager implements Merchant {
    private static Int2ObjectMap<ItemsForItemsTrade[]> trades;

    private static Int2ObjectMap<ItemsForItemsTrade[]> trades() {
        if (trades == null) {
            trades = toIntMap(ImmutableMap.of(
                    1, new ItemsForItemsTrade[]{new ItemsForItemsTrade(new ItemStack(FTItems.SPINDLY_EMERALD), new ItemStack(FTItems.BANDED_REDBACK_SHRIMP_BUCKET), 3, 3, 30), new ItemsForItemsTrade(new ItemStack(FTItems.SPINDLY_RUBY, 4), new ItemStack(FTItems.GOPJET_JET), 3, 3, 30), new ItemsForItemsTrade(new ItemStack(FTItems.SPINDLY_AMBER, 4), new ItemStack(FTItems.FWIN, 1), 3, 3, 30), new ItemsForItemsTrade(new ItemStack(FTItems.SPINDLY_EMERALD, 2), new ItemStack(FTItems.WHITE_BULL_CRAB_CLAW, 2), 3, 3, 30)},
                    2, new ItemsForItemsTrade[]{new ItemsForItemsTrade(new ItemStack(FTItems.SPINDLY_SAPPHIRE), new ItemStack(FTItems.NIGHT_LIGHT_SQUID_TENTACLE, 5), 3, 3, 30), new ItemsForItemsTrade(new ItemStack(FTItems.SPINDLY_PEARL), new ItemStack(FTItems.PAPA_WEE_BUCKET), 3, 3, 30)}));
        }

        return trades;
    }

    public WanderingSailorEntity(EntityType<? extends AbstractVillager> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.75F));
        this.goalSelector.addGoal(2, new TradeWithPlayerGoal(this));
        this.goalSelector.addGoal(2, new LookAtTradingPlayerGoal(this));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Mob.class, 8.0F));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.2F);
    }

    @Override
    public int getAmbientSoundInterval() {
        return 480;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public InteractionResult mobInteract(Player p_230254_1_, InteractionHand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
        if (/*itemstack.getItem() != FTItems.WANDERING_SAILOR_SPAWN_EGG && */this.isAlive() && !this.isTrading() && !this.isBaby()) {
            if (p_230254_2_ == InteractionHand.MAIN_HAND) {
                p_230254_1_.awardStat(Stats.TALKED_TO_VILLAGER);
            }

            if (this.getOffers().isEmpty()) {
                return InteractionResult.SUCCESS;
            } else {
                if (!this.level().isClientSide()) {
                    this.setTradingPlayer(p_230254_1_);
                    this.openTradingScreen(p_230254_1_, this.getDisplayName(), 0);
                }

                return InteractionResult.SUCCESS;
            }
        } else {
            return super.mobInteract(p_230254_1_, p_230254_2_);
        }
    }

    @Override
    protected void updateTrades(ServerLevel level) {
        ItemsForItemsTrade[] trade1 = trades().get(1);
        ItemsForItemsTrade[] trade2 = trades().get(2);
        if (trade1 != null && trade2 != null) {
            MerchantOffers offers = this.getOffers();
            this.addOffersFromListings(offers, trade1, 2);
            int i = this.random.nextInt(trade2.length);
            ItemsForItemsTrade villagertrades$itrade = trade2[i];
            MerchantOffer merchantoffer = villagertrades$itrade.getOffer(this, this.random);
            if (merchantoffer != null) {
                offers.add(merchantoffer);
            }
        }
    }

    @Override
    protected void rewardTradeXp(MerchantOffer offer) {
        if (offer.shouldRewardExp()) {
            int i = 3 + this.random.nextInt(4);
            this.level().addFreshEntity(new ExperienceOrb(this.level(), this.getX(), this.getY() + 0.5D, this.getZ(), i));
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.isTrading() ? FTSounds.WANDERING_SAILOR_TRADE : FTSounds.WANDERING_SAILOR_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return FTSounds.WANDERING_SAILOR_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return FTSounds.WANDERING_SAILOR_DEATH;
    }

    @Override
    protected SoundEvent getTradeUpdatedSound(boolean p_213721_1_) {
        return p_213721_1_ ? FTSounds.WANDERING_SAILOR_YES : FTSounds.WANDERING_SAILOR_NO;
    }

    @Override
    public SoundEvent getNotifyTradeSound() {
        return FTSounds.WANDERING_SAILOR_YES;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
        return null;
    }

    private void addOffersFromListings(MerchantOffers offers, ItemsForItemsTrade[] listings, int count) {
        Set<Integer> set = Sets.newHashSet();
        if (listings.length > count) {
            while (set.size() < count) {
                set.add(this.random.nextInt(listings.length));
            }
        } else {
            for (int i = 0; i < listings.length; ++i) {
                set.add(i);
            }
        }

        for (Integer integer : set) {
            MerchantOffer merchantoffer = listings[integer].getOffer(this, this.random);
            if (merchantoffer != null) {
                offers.add(merchantoffer);
            }
        }
    }

    private static Int2ObjectMap<ItemsForItemsTrade[]> toIntMap(ImmutableMap<Integer, ItemsForItemsTrade[]> p_221238_0_) {
        return new Int2ObjectOpenHashMap<>(p_221238_0_);
    }

    private static class ItemsForItemsTrade {
        private final ItemStack buying1, buying2, selling;
        private final int maxUses, xp;
        private final float priceMultiplier;
        public ItemsForItemsTrade(ItemStack buying1, ItemStack buying2, ItemStack selling, int maxUses, int xp, float priceMultiplier) {
            this.buying1 = buying1;
            this.buying2 = buying2;
            this.selling = selling;
            this.maxUses = maxUses;
            this.xp = xp;
            this.priceMultiplier = priceMultiplier;
        }

        private static ItemCost cost(ItemStack stack) {
            return new ItemCost(stack.getItem(), stack.getCount());
        }

        public ItemsForItemsTrade(ItemStack buying1, ItemStack selling, int maxUses, int xp, float priceMultiplier) {
            this(buying1, ItemStack.EMPTY, selling, maxUses, xp, priceMultiplier);
        }

        @Nullable
        public MerchantOffer getOffer(Entity trader, RandomSource rand) {
            rand.nextInt(5);
            return new MerchantOffer(cost(buying1), buying2.isEmpty() ? Optional.empty() : Optional.of(cost(buying2)), selling, maxUses, xp, priceMultiplier);
        }
    }
}
