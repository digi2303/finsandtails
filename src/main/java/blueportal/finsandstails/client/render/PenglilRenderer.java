
package blueportal.finsandstails.client.render;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.culling.Frustum;
import blueportal.finsandstails.client.render.state.PenglilRenderState;

import blueportal.finsandstails.client.render.layer.PenglilCarryingItemLayer;
import com.google.common.collect.Maps;
import net.minecraft.util.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.client.model.PenglilModel;
import blueportal.finsandstails.common.entities.PenglilEntity;
import blueportal.finsandstails.client.FTModelLayers;

import java.util.Map;
public class PenglilRenderer extends MobRenderer<PenglilEntity, PenglilRenderState, PenglilModel> {
    public static final Map<Integer, Identifier> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(0, Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/entity/penglil/penglil_1.png"));
        hashMap.put(1, Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/entity/penglil/penglil_2.png"));
        hashMap.put(2, Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/entity/penglil/penglil_3.png"));
        hashMap.put(3, Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/entity/penglil/penglil_4.png"));
        hashMap.put(4, Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/entity/penglil/penglil_5.png"));
        hashMap.put(5, Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/entity/penglil/penglil_6.png"));
        hashMap.put(6, Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/entity/penglil/penglil_7.png"));
        hashMap.put(7, Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/entity/penglil/penglil_8.png"));
        hashMap.put(8, Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/entity/penglil/penglil_lord.png"));
        hashMap.put(9, Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/entity/penglil/penglil_pomegranits.png"));
        hashMap.put(10, Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/entity/penglil/penglil_sus.png"));
    });

    private final ItemModelResolver itemModelResolver;

    public PenglilRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new PenglilModel(ctx.bakeLayer(FTModelLayers.PENGLIL)), 0.2F);
        this.itemModelResolver = ctx.getItemModelResolver();
        addLayer(new PenglilCarryingItemLayer(this));
    }

    @Override
    public boolean shouldRender(PenglilEntity penglil, Frustum frustum, double x, double y, double z) {
        Minecraft mc = Minecraft.getInstance();

        if (penglil.isPassenger() && penglil.getVehicle() instanceof Player player) {
            if (player.is(mc.player) && mc.options.getCameraType().isFirstPerson()) {
                return false;
            }
        }

        return super.shouldRender(penglil, frustum, x, y, z);
    }

    @Override
    public PenglilRenderState createRenderState() {
        return new PenglilRenderState();
    }

    @Override
    public void extractRenderState(PenglilEntity entity, PenglilRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.variant = entity.getVariant();
        state.penglilName = entity.getName().getString();
        state.mainArmRight = entity.getMainArm() == HumanoidArm.RIGHT;
        ItemStack carried = state.mainArmRight ? entity.getMainHandItem() : entity.getOffhandItem();
        this.itemModelResolver.updateForLiving(state.carriedItem, carried, ItemDisplayContext.GROUND, entity);
    }

    @Override
    public Identifier getTextureLocation(PenglilRenderState state) {
        String s = state.penglilName;

        return switch (s) {
            case "Lord", "Lord Penglil", "Lord_Penglil" -> TEXTURES.get(8);
            case "Pomegranits" -> TEXTURES.get(9);
            case "Sus", "Amogus", "Impostor", "Among Us" -> TEXTURES.get(10);
            default -> TEXTURES.getOrDefault(state.variant, TEXTURES.get(0));
        };
    }
}
