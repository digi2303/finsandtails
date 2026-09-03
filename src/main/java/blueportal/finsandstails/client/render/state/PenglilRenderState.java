package blueportal.finsandstails.client.render.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;

public class PenglilRenderState extends LivingEntityRenderState {
    public int variant;
    public String penglilName = "";
    public boolean mainArmRight = true;
    public final ItemStackRenderState carriedItem = new ItemStackRenderState();
}
