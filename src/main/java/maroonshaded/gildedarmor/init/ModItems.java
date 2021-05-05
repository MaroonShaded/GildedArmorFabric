package maroonshaded.gildedarmor.init;

import maroonshaded.gildedarmor.item.GildedArmorItem;
import maroonshaded.gildedarmor.item.ModArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ModItems
{
    public static final Item GILDED_NETHERITE_HELMET = new GildedArmorItem(ModArmorMaterial.GILDED_NETHERITE, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT).fireproof());
    public static final Item GILDED_NETHERITE_CHESTPLATE = new GildedArmorItem(ModArmorMaterial.GILDED_NETHERITE, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT).fireproof());
    public static final Item GILDED_NETHERITE_LEGGINGS = new GildedArmorItem(ModArmorMaterial.GILDED_NETHERITE, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT).fireproof());
    public static final Item GILDED_NETHERITE_BOOTS = new GildedArmorItem(ModArmorMaterial.GILDED_NETHERITE, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT).fireproof());

    // For the Enderite mod
    public static final Item GILDED_ENDERITE_HELMET = new GildedArmorItem(ModArmorMaterial.GILDED_ENDERITE, EquipmentSlot.HEAD,new Item.Settings().group(ItemGroup.COMBAT).fireproof());
    public static final Item GILDED_ENDERITE_CHESTPLATE = new GildedArmorItem(ModArmorMaterial.GILDED_ENDERITE, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT).fireproof());
    public static final Item GILDED_ENDERITE_LEGGINGS = new GildedArmorItem(ModArmorMaterial.GILDED_ENDERITE, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT).fireproof());
    public static final Item GILDED_ENDERITE_BOOTS = new GildedArmorItem(ModArmorMaterial.GILDED_ENDERITE, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT).fireproof());
}
