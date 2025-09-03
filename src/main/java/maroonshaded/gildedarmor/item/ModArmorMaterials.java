package maroonshaded.gildedarmor.item;

import maroonshaded.gildedarmor.GildedArmor;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;

import java.util.Map;

public interface ModArmorMaterials
{
    ArmorMaterial GILDED_NETHERITE = copy(ArmorMaterials.NETHERITE, GildedArmor.GILDED_NETHERITE_ARMOR_MATERIAL_KEY);
    ArmorMaterial GILDED_ENDERITE = new ArmorMaterial(72, Map.of(
            EquipmentType.BOOTS, 4,
            EquipmentType.LEGGINGS, 7,
            EquipmentType.CHESTPLATE, 9,
            EquipmentType.HELMET, 4,
            EquipmentType.BODY, 12),
            17, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0f, 0.1f, GildedArmor.REPAIRS_ENDERITE_ARMOR,
            GildedArmor.GILDED_ENDERITE_ARMOR_MATERIAL_KEY
    );

    private static ArmorMaterial copy(ArmorMaterial from, RegistryKey<EquipmentAsset> assetId)
    {
        return new ArmorMaterial(from.durability(), from.defense(), from.enchantmentValue(), from.equipSound(), from.toughness(), from.knockbackResistance(), from.repairIngredient(), assetId);
    }

    static void initialize()
    {
        // Dummy static initializer
    }
}
