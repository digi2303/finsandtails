package blueportal.finsandstails.network;

import blueportal.finsandstails.impl.platform.CommonAbstraction;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;

public class FTMessages {
    public static void register() {
        CommonAbstraction.INSTANCE.registerServerbound(TriggerFlyingPacket.TYPE, TriggerFlyingPacket.STREAM_CODEC, TriggerFlyingPacket::handle);
        CommonAbstraction.INSTANCE.registerClientbound(HitComboSyncS2CPacket.TYPE, HitComboSyncS2CPacket.STREAM_CODEC, HitComboSyncS2CPacket::handle);
    }

    public static void sendToPlayer(CustomPacketPayload message, ServerPlayer player) {
        CommonAbstraction.INSTANCE.sendToPlayer(player, message);
    }

    public static void sendToServer(CustomPacketPayload message) {
        CommonAbstraction.INSTANCE.sendToServer(message);
    }
}
