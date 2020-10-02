package maroonshaded.gildedarmor.init;

import maroonshaded.gildedarmor.item.ModArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ModItems
{
    public static final Item GILDED_NETHERITE_HELMET = new ArmorItem(ModArmorMaterial.GILDED_NETHERITE, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT).fireproof());
    public static final Item GILDED_NETHERITE_CHESTPLATE = new ArmorItem(ModArmorMaterial.GILDED_NETHERITE, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT).fireproof());
    public static final Item GILDED_NETHERITE_LEGGINGS = new ArmorItem(ModArmorMaterial.GILDED_NETHERITE, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT).fireproof());
    public static final Item GILDED_NETHERITE_BOOTS = new ArmorItem(ModArmorMaterial.GILDED_NETHERITE, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT).fireproof());
}
