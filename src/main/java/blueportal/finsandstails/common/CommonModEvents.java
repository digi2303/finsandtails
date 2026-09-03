package blueportal.finsandstails.common;

import blueportal.finsandstails.common.entities.WherbleEntity;
import blueportal.finsandstails.impl.platform.CommonAbstraction;
import blueportal.finsandstails.registry.FTEntities;
import blueportal.finsandstails.registry.FTItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.ProjectileDispenseBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.block.DispenserBlock;

import java.util.UUID;

public class CommonModEvents {

    public static void register() {
        CommonAbstraction.INSTANCE.registerPotionBrewing((registrar) ->
                registrar.addPotionRecipe(Potions.AWKWARD, FTItems.NIGHT_LIGHT_SQUID_TENTACLE, Potions.NIGHT_VISION));

        DispenserBlock.registerBehavior(FTItems.WHERBLING, new DefaultDispenseItemBehavior() {
            @Override
            protected ItemStack execute(BlockSource source, ItemStack stack) {
                ServerLevel level = source.level();
                BlockPos pos = source.pos();
                Direction direction = source.state().getValue(DispenserBlock.FACING);

                WherbleEntity wherble = new WherbleEntity(FTEntities.WHERBLE, level);
                UUID id = wherble.getUUID();
                wherble.deserializeNBT(stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getCompoundOrEmpty("WherbleData"));
                wherble.setUUID(id);
                wherble.snapTo(pos.getX(), pos.getY(), pos.getZ(), 0.0F, 0.0F);
                wherble.setProjectile(true);
                wherble.shoot(direction.getStepX(), ((float)direction.getStepY() + 0.1F), direction.getStepZ(), 3.0F, 0.0F);

                if (!wherble.isBaby()) {
                    wherble.setBaby(true);
                    wherble.setAge(-24000);
                }
                level.addFreshEntity(wherble);
                return ItemStack.EMPTY;
            }
        });

        DispenserBlock.registerBehavior(FTItems.TEAL_ARROWFISH, new ProjectileDispenseBehavior(FTItems.TEAL_ARROWFISH));
    }
}
