package blueportal.finsandstails.impl.platform;

import dev.yumi.mc.core.api.YumiMods;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Util;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface CommonAbstraction {
    boolean IS_FABRIC = YumiMods.get().isModLoaded("fabricloader") && !YumiMods.get().isModLoaded("connector");

    CommonAbstraction INSTANCE = Util.make(() -> {
        try {
            return (CommonAbstraction) Class.forName(
                    "blueportal.finsandstails.impl.platform." +
                            (CommonAbstraction.IS_FABRIC ? "fabric.FabricCommonAbstraction" : "neo.NeoCommonAbstraction")).getField("INSTANCE").get(null);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    });

    boolean isClient();

    void registerAttributes(Consumer<AttributeRegistry> consumer);

    <T extends Mob> void registerSpawnPlacement(EntityType<T> type, SpawnPlacementType placementType, Heightmap.Types heightmap, SpawnPlacements.SpawnPredicate<T> predicate);

    void addSpawn(BiomeSelector selector, MobCategory category, EntityType<?> type, int weight, int minCount, int maxCount);

    void onServerAboutToStart(Consumer<MinecraftServer> consumer);

    void injectLoot(ResourceKey<LootTable> target, ResourceKey<LootTable> injected);

    <T extends CustomPacketPayload> void registerServerbound(CustomPacketPayload.Type<T> type, StreamCodec<? super RegistryFriendlyByteBuf, T> codec, BiConsumer<T, ServerPlayer> handler);

    <T extends CustomPacketPayload> void registerClientbound(CustomPacketPayload.Type<T> type, StreamCodec<? super RegistryFriendlyByteBuf, T> codec, Consumer<T> handler);

    void sendToPlayer(ServerPlayer player, CustomPacketPayload payload);

    void sendToServer(CustomPacketPayload payload);

    interface AttributeRegistry {
        void register(EntityType<? extends LivingEntity> type, AttributeSupplier.Builder builder);
    }

    record BiomeSelector(TagKey<Biome> tag, List<ResourceKey<Biome>> keys) {
        public static BiomeSelector of(TagKey<Biome> tag) {
            return new BiomeSelector(tag, List.of());
        }

        @SafeVarargs
        public static BiomeSelector of(ResourceKey<Biome>... keys) {
            return new BiomeSelector(null, List.of(keys));
        }
    }
}
