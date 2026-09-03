package blueportal.finsandstails.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;

public class FTGlowLayer<S extends LivingEntityRenderState, M extends EntityModel<? super S>> extends RenderLayer<S, M> {
    private final FTGlowLayer.AlphaFunction<S> alphaFunction;
    private final Identifier glowLayer;

    public FTGlowLayer(RenderLayerParent<S, M> layer, Identifier glowOverlayResourceLocation, FTGlowLayer.AlphaFunction<S> p_234887_) {
        super(layer);
        this.glowLayer = glowOverlayResourceLocation;
        this.alphaFunction = p_234887_;
    }

    @Override
    public void submit(PoseStack p_234902_, SubmitNodeCollector p_234903_, int p_234904_, S p_234905_, float p_234906_, float p_234907_) {
        if (!p_234905_.isInvisible) {
            int alpha = Mth.clamp(Mth.floor(this.alphaFunction.apply(p_234905_) * 255.0F), 0, 255);
            p_234903_.submitModel(this.getParentModel(), p_234905_, p_234902_, RenderTypes.entityTranslucentEmissive(this.glowLayer), p_234904_, LivingEntityRenderer.getOverlayCoords(p_234905_, 0.0F), ARGB.color(alpha, 255, 255, 255), null);
        }
    }

    public interface AlphaFunction<S extends LivingEntityRenderState> {
        float apply(S p_234920_);
    }
}
