package blueportal.finsandstails.common.entities.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import blueportal.finsandstails.common.items.TealArrowfishItem;
import blueportal.finsandstails.registry.FTEntities;
import blueportal.finsandstails.registry.FTItems;

public class TealArrowfishArrowEntity extends AbstractArrow {
    private final TealArrowfishItem arrow;

    public TealArrowfishArrowEntity(EntityType<? extends AbstractArrow> type, Level worldIn) {
        super(type, worldIn);
        this.arrow = (TealArrowfishItem) FTItems.TEAL_ARROWFISH;
    }

    public TealArrowfishArrowEntity(Level worldIn, Item item) {
        super(FTEntities.TEAL_ARROWFISH_ARROW, worldIn);
        this.arrow = (TealArrowfishItem) item;
    }

    public TealArrowfishArrowEntity(Level worldIn, double x, double y, double z) {
        this(FTEntities.TEAL_ARROWFISH_ARROW, worldIn);
        setPos(x, y, z);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(arrow);
    }

    protected float getWaterInertia() {
        return 0.99F;
    }
}
