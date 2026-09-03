package blueportal.finsandstails.client.screen;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.common.container.CrabCruncherContainer;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.ItemCombinerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class CrabCruncherScreen extends ItemCombinerScreen<CrabCruncherContainer> {
    private static final Identifier CRUNCHER_GUI = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/gui/crab_cruncher.png");

    public CrabCruncherScreen(CrabCruncherContainer screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn, CRUNCHER_GUI);
        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 175;
        this.imageHeight = 165;
        this.titleLabelX = 49;
    }

    @Override
    protected void extractErrorIcon(GuiGraphicsExtractor extractor, int p_266822_, int p_267045_) {
    }
}
