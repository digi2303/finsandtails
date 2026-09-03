package blueportal.finsandstails.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class CrabGauntletItem extends Item {
    public CrabGauntletItem(ToolMaterial tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(builderIn.attributes(createAttributes(tier, attackDamageIn, attackSpeedIn)));
    }

    private static ItemAttributeModifiers createAttributes(ToolMaterial tier, int attackDamageIn, float attackSpeedIn) {
        float attackDamage = (float) attackDamageIn + tier.attackDamageBonus();
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, attackDamage, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, attackSpeedIn, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.HAND)
                .build();
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            return !state.is(BlockTags.LEAVES) && state.canBeReplaced() && state.is(BlockTags.SWORD_EFFICIENT) ? 1.0F : 1.5F;
        }
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (state.getDestroySpeed(worldIn, pos) != 0.0F) {
            stack.hurtAndBreak(2, entityLiving, EquipmentSlot.MAINHAND);
        }

        return true;
    }
}
