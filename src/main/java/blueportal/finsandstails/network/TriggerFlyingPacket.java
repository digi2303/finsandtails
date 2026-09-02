package blueportal.finsandstails.network;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.common.FinsPlayerData;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;

public record TriggerFlyingPacket(boolean flying) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<TriggerFlyingPacket> TYPE = new CustomPacketPayload.Type<>(FinsAndTails.id("trigger_flying"));

    public static final StreamCodec<RegistryFriendlyByteBuf, TriggerFlyingPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL, TriggerFlyingPacket::flying,
            TriggerFlyingPacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(TriggerFlyingPacket packet, ServerPlayer player) {
        ((FinsPlayerData) player).finsandtails$setFinsFlying(packet.flying());
    }
}
