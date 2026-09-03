package blueportal.finsandstails.impl.platform.fabric;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.impl.platform.CommonAbstraction;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public record FabricCommonAbstraction() implements CommonAbstraction {
    public static final CommonAbstraction INSTANCE = new FabricCommonAbstraction();

    @Override
    public boolean isClient() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
    }

    @Override
    public void registerAttributes(Consumer<AttributeRegistry> consumer) {
        consumer.accept(FabricDefaultAttributeRegistry::register);
    }

    @Override
    public <T extends Mob> void registerSpawnPlacement(EntityType<T> type, SpawnPlacementType placementType, Heightmap.Types heightmap, SpawnPlacements.SpawnPredicate<T> predicate) {
        SpawnPlacements.register(type, placementType, heightmap, predicate);
    }

    @Override
    public void addSpawn(BiomeSelector selector, MobCategory category, EntityType<?> type, int weight, int minCount, int maxCount) {
        Predicate<net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext> where = selector.tag() != null
                ? BiomeSelectors.tag(selector.tag())
                : BiomeSelectors.includeByKey(selector.keys());
        BiomeModifications.create(FinsAndTails.id(type.builtInRegistryHolder().key().identifier().getPath() + "_spawns")).add(
                ModificationPhase.ADDITIONS,
                where,
                context -> context.getMobSpawnSettings().addSpawn(category, new MobSpawnSettings.SpawnerData(type, minCount, maxCount), weight)
        );
    }

    @Override
    public void onServerAboutToStart(Consumer<MinecraftServer> consumer) {
        ServerLifecycleEvents.SERVER_STARTING.register(consumer::accept);
    }

    @Override
    public void injectLoot(ResourceKey<LootTable> target, ResourceKey<LootTable> injected, int weight, int quality) {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (key == target) {
                tableBuilder.withPool(LootPool.lootPool().add(NestedLootTable.lootTableReference(injected).setWeight(weight).setQuality(quality)));
            }
        });
    }

    @Override
    public <T extends CustomPacketPayload> void registerServerbound(CustomPacketPayload.Type<T> type, StreamCodec<? super RegistryFriendlyByteBuf, T> codec, BiConsumer<T, ServerPlayer> handler) {
        PayloadTypeRegistry.serverboundPlay().register(type, codec);
        ServerPlayNetworking.registerGlobalReceiver(type, (payload, context) -> context.server().execute(() -> handler.accept(payload, context.player())));
    }

    @Override
    public <T extends CustomPacketPayload> void registerClientbound(CustomPacketPayload.Type<T> type, StreamCodec<? super RegistryFriendlyByteBuf, T> codec, Consumer<T> handler) {
        PayloadTypeRegistry.clientboundPlay().register(type, codec);
        if (isClient()) {
            FabricClientNetworking.registerClientbound(type, handler);
        }
    }

    @Override
    public void sendToPlayer(ServerPlayer player, CustomPacketPayload payload) {
        ServerPlayNetworking.send(player, payload);
    }

    @Override
    public void sendToServer(CustomPacketPayload payload) {
        FabricClientNetworking.sendToServer(payload);
    }
}
