package blueportal.finsandstails.impl.platform;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Util;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public interface ClientAbstraction {
    ClientAbstraction INSTANCE = Util.make(() -> {
        try {
            return (ClientAbstraction) Class.forName(
                    "blueportal.finsandstails.impl.platform." +
                            (CommonAbstraction.IS_FABRIC ? "fabric.FabricClientAbstraction" : "neo.NeoClientAbstraction")).getField("INSTANCE").get(null);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    });

    <T extends Entity> void registerEntityRenderer(EntityType<? extends T> type, EntityRendererProvider<T> provider);

    void registerEntityModelLayer(ModelLayerLocation location, Supplier<LayerDefinition> supplier);

    <M extends AbstractContainerMenu, U extends net.minecraft.client.gui.screens.Screen & net.minecraft.client.gui.screens.inventory.MenuAccess<M>> void registerScreen(MenuType<M> type, ScreenFactory<M, U> factory);

    interface ScreenFactory<M extends AbstractContainerMenu, U extends net.minecraft.client.gui.screens.Screen & net.minecraft.client.gui.screens.inventory.MenuAccess<M>> {
        U create(M menu, net.minecraft.world.entity.player.Inventory inventory, net.minecraft.network.chat.Component title);
    }
}
