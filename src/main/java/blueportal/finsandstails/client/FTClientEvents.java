package blueportal.finsandstails.client;

import blueportal.finsandstails.impl.platform.ClientAbstraction;
import blueportal.finsandstails.network.FTMessages;
import blueportal.finsandstails.network.TriggerFlyingPacket;
import blueportal.finsandstails.registry.FTItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.EquipmentSlot;

public class FTClientEvents {
    private static boolean wasJumping;

    public static void register() {
        ClientAbstraction.INSTANCE.onClientTick(FTClientEvents::clientTick);
    }

    private static void clientTick() {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;

        if (player != null && (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == FTItems.GOPJET_JETPACK || player.getItemBySlot(EquipmentSlot.CHEST).getItem() == FTItems.ARMORED_GOPJET_JETPACK)) {
            boolean jumping = minecraft.options.keyJump.isDown();

            if (jumping != wasJumping) {
                FTMessages.sendToServer(new TriggerFlyingPacket(jumping));
            }

            wasJumping = jumping;
        }
    }
}
