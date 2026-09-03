package blueportal.finsandstails.impl.platform.neo;

import blueportal.finsandstails.impl.platform.ClientAbstraction;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.NeoForge;

import java.util.function.Supplier;

public record NeoClientAbstraction() implements ClientAbstraction {
    public static final ClientAbstraction INSTANCE = new NeoClientAbstraction();

    @Override
    public void onClientTick(Runnable handler) {
        NeoForge.EVENT_BUS.addListener(ClientTickEvent.Post.class, event -> handler.run());
    }

    @Override
    public <T extends Entity> void registerEntityRenderer(EntityType<? extends T> type, EntityRendererProvider<T> provider) {
        NeoCommonAbstraction.INSTANCE.addLateAction(bus -> bus.addListener(EntityRenderersEvent.RegisterRenderers.class, event -> event.registerEntityRenderer(type, provider)));
    }

    @Override
    public void registerEntityModelLayer(ModelLayerLocation location, Supplier<LayerDefinition> supplier) {
        NeoCommonAbstraction.INSTANCE.addLateAction(bus -> bus.addListener(EntityRenderersEvent.RegisterLayerDefinitions.class, event -> event.registerLayerDefinition(location, supplier)));
    }

    @Override
    public <M extends AbstractContainerMenu, U extends net.minecraft.client.gui.screens.Screen & net.minecraft.client.gui.screens.inventory.MenuAccess<M>> void registerScreen(MenuType<M> type, ScreenFactory<M, U> factory) {
        NeoCommonAbstraction.INSTANCE.addLateAction(bus -> bus.addListener(RegisterMenuScreensEvent.class, event -> event.register(type, factory::create)));
    }
}
