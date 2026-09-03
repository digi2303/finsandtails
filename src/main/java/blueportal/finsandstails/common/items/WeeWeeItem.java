package blueportal.finsandstails.common.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class WeeWeeItem extends Item {
    public WeeWeeItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public int getUseDuration(ItemStack p_41454_, LivingEntity entity) {
        return 5;
    }
}
