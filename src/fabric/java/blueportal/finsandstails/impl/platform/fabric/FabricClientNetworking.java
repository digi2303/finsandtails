package blueportal.finsandstails.impl.platform.fabric;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
public class FabricClientNetworking {
    public static void sendToServer(CustomPacketPayload payload) {
        ClientPlayNetworking.send(payload);
    }

    public static <T extends CustomPacketPayload> void registerClientbound(CustomPacketPayload.Type<T> type, Consumer<T> handler) {
        ClientPlayNetworking.registerGlobalReceiver(type, (payload, context) -> context.client().execute(() -> handler.accept(payload)));
    }
}
