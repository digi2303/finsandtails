package blueportal.finsandstails.client;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.registry.FTItems;
import blueportal.finsandstails.registry.FTTags;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class FTHudRenderer {
    private static final Identifier HEARTS_TEXTURE = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/gui/icons.png");
    private static final Identifier GAUNTLET_OVERLAY_TEXTURE = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/gui/overlay/gauntlet.png");
    private static final Identifier GAUNTLET_BG_TEXTURE = Identifier.fromNamespaceAndPath(FinsAndTails.MOD_ID, "textures/gui/overlay/gauntlet_bg.png");

    public static boolean shouldReplaceHearts(Player player) {
        return player != null
                && !player.getItemBySlot(EquipmentSlot.CHEST).isEmpty()
                && !player.isCreative()
                && !player.isSpectator()
                && CharmType.getCharm(player) != null;
    }

    public static void extractHearts(GuiGraphicsExtractor extractor, Player player, int x, int y, int rowHeight, int regen, float healthMax, int health, int absorption, boolean highlight) {
        CharmType charm = CharmType.getCharm(player);
        if (charm == null) {
            return;
        }

        int heartCount = Mth.ceil((double) healthMax / 2.0D);
        int absorptionHeartCount = Mth.ceil((double) absorption / 2.0D);

        for (int heart = heartCount + absorptionHeartCount - 1; heart >= 0; --heart) {
            int level = heart / 10;
            int index = heart % 10;
            int heartX = x + index * 8;
            int heartY = y - level * rowHeight;

            if (health + absorption <= 4) {
                heartY += player.getRandom().nextInt(2);
            }

            if (heart < heartCount && heart == regen) {
                heartY -= 2;
            }

            int halfHeartIndex = heart * 2;
            if (highlight && halfHeartIndex < absorption) {
                extractHeart(extractor, charm, heartX, heartY, true, halfHeartIndex + 1 == absorption);
            }

            if (halfHeartIndex < health) {
                extractHeart(extractor, charm, heartX, heartY, false, halfHeartIndex + 1 == health);
            }
        }
    }

    private static void extractHeart(GuiGraphicsExtractor extractor, CharmType type, int x, int y, boolean highlight, boolean halfHeart) {
        extractor.blit(RenderPipelines.GUI_TEXTURED, HEARTS_TEXTURE, x, y, (float) type.getX(halfHeart, highlight), 0.0F, 9, 9, 256, 256);
    }

    public static void extractGauntletOverlay(GuiGraphicsExtractor extractor) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || player.isSpectator()) {
            return;
        }

        ItemStack main = player.getItemInHand(InteractionHand.MAIN_HAND);
        ItemStack off = player.getItemInHand(InteractionHand.OFF_HAND);
        if (!main.is(FTTags.CLAW_GAUNTLETS) || !off.is(FTTags.CLAW_GAUNTLETS)) {
            return;
        }

        int x = minecraft.getWindow().getGuiScaledWidth() / 2 - 14;
        int y = minecraft.getWindow().getGuiScaledHeight() / 2 + 9;

        extractor.blit(RenderPipelines.GUI_TEXTURED, GAUNTLET_BG_TEXTURE, x, y, 0.0F, 0.0F, 27, 9, 256, 256);

        int hitCombo = ClientHitComboData.getHitCombo();
        switch (hitCombo) {
            case 1 -> extractor.blit(RenderPipelines.GUI_TEXTURED, GAUNTLET_OVERLAY_TEXTURE, x, y, 0.0F, 0.0F, 7, 7, 256, 256);
            case 2 -> extractor.blit(RenderPipelines.GUI_TEXTURED, GAUNTLET_OVERLAY_TEXTURE, x, y, 0.0F, 0.0F, 14, 7, 256, 256);
            case 3 -> extractor.blit(RenderPipelines.GUI_TEXTURED, GAUNTLET_OVERLAY_TEXTURE, x, y, 0.0F, 0.0F, 20, 7, 256, 256);
            case 4 -> extractor.blit(RenderPipelines.GUI_TEXTURED, GAUNTLET_OVERLAY_TEXTURE, x, y, 0.0F, 0.0F, 28, 7, 256, 256);
        }
    }

    public enum CharmType {
        RUBY,
        EMERALD,
        AMBER,
        PEARL,
        SAPPHIRE,
        GEM;

        public int getX(boolean halfHeart, boolean highlight) {
            if (halfHeart) return ordinal() * 18 + 9;
            return ordinal() * 18;
        }

        static CharmType getCharm(Player player) {
            ItemStack stack = player.getItemBySlot(EquipmentSlot.CHEST);

            if (stack.is(FTItems.SPINDLY_RUBY_CHARM)) return RUBY;
            else if (stack.is(FTItems.SPINDLY_EMERALD_CHARM)) return EMERALD;
            else if (stack.is(FTItems.SPINDLY_AMBER_CHARM)) return AMBER;
            else if (stack.is(FTItems.SPINDLY_PEARL_CHARM)) return PEARL;
            else if (stack.is(FTItems.SPINDLY_SAPPHIRE_CHARM)) return SAPPHIRE;
            else if (stack.is(FTItems.GEM_CRAB_AMULET)) return GEM;

            return null;
        }
    }
}
