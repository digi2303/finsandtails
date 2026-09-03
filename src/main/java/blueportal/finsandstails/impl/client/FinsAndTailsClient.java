package blueportal.finsandstails.impl.client;

import blueportal.finsandstails.client.FTClientEvents;
import dev.yumi.mc.core.api.ModContainer;
import dev.yumi.mc.core.api.entrypoint.client.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class FinsAndTailsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(ModContainer modContainer) {
        FTClientEvents.register();
    }
}
