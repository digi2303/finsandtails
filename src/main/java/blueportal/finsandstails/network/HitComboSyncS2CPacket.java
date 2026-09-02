package blueportal.finsandstails.network;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.ClientHitComboData;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record HitComboSyncS2CPacket(int hitCombo) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<HitComboSyncS2CPacket> TYPE = new CustomPacketPayload.Type<>(FinsAndTails.id("hit_combo_sync"));

    public static final StreamCodec<RegistryFriendlyByteBuf, HitComboSyncS2CPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, HitComboSyncS2CPacket::hitCombo,
            HitComboSyncS2CPacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(HitComboSyncS2CPacket packet) {
        ClientHitComboData.set(packet.hitCombo());
    }
}
