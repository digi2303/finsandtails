package blueportal.finsandstails.client.screen;

import blueportal.finsandstails.common.container.MudhorsePouchContainer;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class MudhorsePouchScreen extends AbstractContainerScreen<MudhorsePouchContainer> {
   private static final Identifier CONTAINER_LOCATION = Identifier.parse("textures/gui/container/dispenser.png");

   public MudhorsePouchScreen(MudhorsePouchContainer p_98685_, Inventory p_98686_, Component p_98687_) {
      super(p_98685_, p_98686_, p_98687_);
   }

   protected void init() {
      super.init();
      this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
   }

   @Override
   public void extractBackground(GuiGraphicsExtractor extractor, int pMouseX, int pMouseY, float pPartialTick) {
      int i = (this.width - this.imageWidth) / 2;
      int j = (this.height - this.imageHeight) / 2;
      extractor.blit(RenderPipelines.GUI_TEXTURED, CONTAINER_LOCATION, i, j, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
   }
}
