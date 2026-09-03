package blueportal.finsandstails.common.items;

import blueportal.finsandstails.FinsAndTails;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class FinsArmorMaterial {
    public static ArmorMaterial create(String name, int durability, int[] defense, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, TagKey<Item> repairIngredient) {
        return new ArmorMaterial(
                durability,
                Map.of(
                        ArmorType.BOOTS, defense[0],
                        ArmorType.LEGGINGS, defense[1],
                        ArmorType.CHESTPLATE, defense[2],
                        ArmorType.HELMET, defense[3]
                ),
                enchantmentValue,
                equipSound,
                toughness,
                0.0F,
                repairIngredient,
                assetId(name)
        );
    }

    public static ResourceKey<EquipmentAsset> assetId(String name) {
        return ResourceKey.create(EquipmentAssets.ROOT_ID, FinsAndTails.id(name));
    }
}
