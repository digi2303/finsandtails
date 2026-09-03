package blueportal.finsandstails.common.items;

import blueportal.finsandstails.common.container.MudhorsePouchContainer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MudhorsePouchItem extends Item {
    public MudhorsePouchItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public InteractionResult use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!world.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            player.openMenu(new SimpleMenuProvider((windowId, inventory, owner) -> new MudhorsePouchContainer(windowId, inventory), stack.getHoverName()));
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean canFitInsideContainerItems() {
        return false;
    }
}
