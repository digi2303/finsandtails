package blueportal.finsandstails.impl.platform.fabric;

import blueportal.finsandstails.impl.platform.ClientAbstraction;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public record FabricClientAbstraction() implements ClientAbstraction {
    public static final ClientAbstraction INSTANCE = new FabricClientAbstraction();

    @Override
    public void onClientTick(Runnable handler) {
        ClientTickEvents.END_CLIENT_TICK.register(client -> handler.run());
    }

    @Override
    public <T extends Entity> void registerEntityRenderer(EntityType<? extends T> type, EntityRendererProvider<T> provider) {
        EntityRendererRegistry.register(type, provider);
    }

    @Override
    public void registerEntityModelLayer(ModelLayerLocation location, Supplier<LayerDefinition> supplier) {
        ModelLayerRegistry.registerModelLayer(location, supplier::get);
    }

    @Override
    public <M extends AbstractContainerMenu, U extends net.minecraft.client.gui.screens.Screen & net.minecraft.client.gui.screens.inventory.MenuAccess<M>> void registerScreen(MenuType<M> type, ScreenFactory<M, U> factory) {
        MenuScreens.register(type, factory::create);
    }
}
