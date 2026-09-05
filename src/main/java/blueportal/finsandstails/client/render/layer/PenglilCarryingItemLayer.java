package blueportal.finsandstails.client.render.layer;

import blueportal.finsandstails.client.model.PenglilModel;
import blueportal.finsandstails.client.render.state.PenglilRenderState;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;

public class PenglilCarryingItemLayer extends RenderLayer<PenglilRenderState, PenglilModel> {
   public PenglilCarryingItemLayer(RenderLayerParent<PenglilRenderState, PenglilModel> p_234834_) {
      super(p_234834_);
   }

   @Override
   public void submit(PoseStack p_116897_, SubmitNodeCollector p_116898_, int p_116899_, PenglilRenderState p_116900_, float p_116901_, float p_116902_) {
      if (p_116900_.carriedItem.isEmpty()) {
         return;
      }

      p_116897_.pushPose();
      float f2 = Mth.abs(p_116900_.xRot) / 60.0F;
      if (p_116900_.xRot < 0.0F) {
         p_116897_.translate(0.0F, 1.0F - f2 * 0.5F, -1.0F + f2 * 0.5F);
      } else {
         p_116897_.translate(0.0F, 1.0F + f2 * 0.8F, -1.0F + f2 * 0.2F);
      }

      p_116900_.carriedItem.submit(p_116897_, p_116898_, p_116899_, OverlayTexture.NO_OVERLAY, p_116900_.outlineColor);
      p_116897_.popPose();
   }
}
