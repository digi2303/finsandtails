package blueportal.finsandstails.common.items;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.registry.FTEnchantments;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class FwingedBootsItem extends Item {
    public static final ArmorMaterial MATERIAL = FinsArmorMaterial.create("fwinged", 3, new int[]{1, 2, 3, 1}, 3, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, net.minecraft.tags.ItemTags.REPAIRS_LEATHER_ARMOR);
    public static final ItemAttributeModifiers MODIFIERS = ItemAttributeModifiers.builder()
            .add(Attributes.WATER_MOVEMENT_EFFICIENCY, new AttributeModifier(FinsAndTails.id("swim_modifier"), 1.0D, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.FEET)
            .add(Attributes.MOVEMENT_SPEED, new AttributeModifier(FinsAndTails.id("movement_modifier"), -0.15D, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.FEET)
            .build();

    public FwingedBootsItem(Properties properties) {
        super(properties.humanoidArmor(MATERIAL, ArmorType.BOOTS).attributes(MODIFIERS));
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel worldIn, Entity entity, EquipmentSlot slot) {
        super.inventoryTick(stack, worldIn, entity, slot);
        if (slot != EquipmentSlot.FEET || !(entity instanceof Player player)) {
            return;
        }

        int j = EnchantmentHelper.getItemEnchantmentLevel(FTEnchantments.get(worldIn.registryAccess(), FTEnchantments.FLUKED_EDGE), stack);

        if (j > 0) {
            if (worldIn.getBlockState(player.blockPosition().below()).is(Blocks.WATER) && worldIn.getBlockState(player.blockPosition()).isAir() && player.getDeltaMovement().y > 0.25) {
                float f7 = player.getYRot();
                float f = player.getXRot();
                float f1 = -Mth.sin(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
                float f2 = -Mth.sin(f * ((float)Math.PI / 180F));
                float f3 = Mth.cos(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
                float f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
                float f5 = 3.0F * ((1.0F + (float)j) / 4.0F);
                f1 = f1 * (f5 / f4);
                f2 = f2 * (f5 / f4);
                f3 = f3 * (f5 / f4);
                if (j > 1) player.push((double) f1 / 3.5, (double) f2 / 2, (double) f3 / 3.5);
                else player.push((double) f1 / 1.5, (double) f2 / 2, (double) f3 / 1.5);
                player.startAutoSpinAttack(1, 0.0F, stack);

                if (player.onGround()) {
                    player.move(MoverType.SELF, new Vec3(0.0D, 1.1999999F, 0.0D));
                }
            }
        }
    }
}
