package blueportal.finsandstails.impl.platform.neo;

import blueportal.finsandstails.impl.platform.CommonAbstraction;
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
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public record NeoCommonAbstraction(List<Consumer<IEventBus>> lateActions) implements CommonAbstraction {
    public static IEventBus EVENT_BUS = null;
    public static final NeoCommonAbstraction INSTANCE = new NeoCommonAbstraction(new ArrayList<>());

    @Override
    public boolean isClient() {
        return FMLEnvironment.getDist().isClient();
    }

    @Override
    public void registerAttributes(Consumer<AttributeRegistry> consumer) {
        addLateAction(bus -> bus.addListener(EntityAttributeCreationEvent.class, event ->
                consumer.accept((type, builder) -> event.put(type, builder.build()))));
    }

    @Override
    public <T extends Mob> void registerSpawnPlacement(EntityType<T> type, SpawnPlacementType placementType, Heightmap.Types heightmap, SpawnPlacements.SpawnPredicate<T> predicate) {
        addLateAction(bus -> bus.addListener(RegisterSpawnPlacementsEvent.class, event ->
                event.register(type, placementType, heightmap, predicate, RegisterSpawnPlacementsEvent.Operation.OR)));
    }

    @Override
    public void addSpawn(BiomeSelector selector, MobCategory category, EntityType<?> type, int weight, int minCount, int maxCount) {
        throw new UnsupportedOperationException("NeoForge has no runtime biome spawn hook; spawns are applied from generated neoforge:add_spawns biome modifiers");
    }

    @Override
    public void onServerAboutToStart(Consumer<MinecraftServer> consumer) {
        NeoForge.EVENT_BUS.addListener(ServerAboutToStartEvent.class, event -> consumer.accept(event.getServer()));
    }

    @Override
    public void injectLoot(ResourceKey<LootTable> target, ResourceKey<LootTable> injected) {
        throw new UnsupportedOperationException("NeoForge loot injection is applied from generated global loot modifiers");
    }

    @Override
    public <T extends CustomPacketPayload> void registerServerbound(CustomPacketPayload.Type<T> type, StreamCodec<? super RegistryFriendlyByteBuf, T> codec, BiConsumer<T, ServerPlayer> handler) {
        addLateAction(bus -> bus.addListener(RegisterPayloadHandlersEvent.class, event -> {
            PayloadRegistrar registrar = event.registrar("1");
            registrar.playToServer(type, codec, (payload, context) -> context.enqueueWork(() -> handler.accept(payload, (ServerPlayer) context.player())));
        }));
    }

    @Override
    public <T extends CustomPacketPayload> void registerClientbound(CustomPacketPayload.Type<T> type, StreamCodec<? super RegistryFriendlyByteBuf, T> codec, Consumer<T> handler) {
        addLateAction(bus -> bus.addListener(RegisterPayloadHandlersEvent.class, event -> {
            PayloadRegistrar registrar = event.registrar("1");
            registrar.playToClient(type, codec, (payload, context) -> context.enqueueWork(() -> handler.accept(payload)));
        }));
    }

    @Override
    public void sendToPlayer(ServerPlayer player, CustomPacketPayload payload) {
        PacketDistributor.sendToPlayer(player, payload);
    }

    @Override
    public void sendToServer(CustomPacketPayload payload) {
        NeoClientNetworking.sendToServer(payload);
    }

    public void addLateAction(Consumer<IEventBus> consumer) {
        if (EVENT_BUS != null) {
            consumer.accept(EVENT_BUS);
        } else {
            this.lateActions.add(consumer);
        }
    }
}
