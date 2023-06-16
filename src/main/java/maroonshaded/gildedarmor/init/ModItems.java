package maroonshaded.gildedarmor.init;

import maroonshaded.gildedarmor.item.GildedArmorItem;
import maroonshaded.gildedarmor.item.GildedEnderiteHelmetItem;
import maroonshaded.gildedarmor.item.ModArmorMaterial;
import maroonshaded.gildedarmor.item.ModSmithingTemplateItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ModItems
{
    public static final Map<String, Item> ITEMS = new HashMap<>(8);

    public static final Item GILDING_UPGRADE_SMITHING_TEMPLATE = addItem("gilding_upgrade_smithing_template", ModSmithingTemplateItem.createGildingUpgradeTemplate());

    public static final Item GILDED_NETHERITE_HELMET = addItem("gilded_netherite_helmet", new GildedArmorItem(ModArmorMaterial.GILDED_NETHERITE, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));
    public static final Item GILDED_NETHERITE_CHESTPLATE = addItem("gilded_netherite_chestplate", new GildedArmorItem(ModArmorMaterial.GILDED_NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));
    public static final Item GILDED_NETHERITE_LEGGINGS = addItem("gilded_netherite_leggings", new GildedArmorItem(ModArmorMaterial.GILDED_NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()));
    public static final Item GILDED_NETHERITE_BOOTS = addItem("gilded_netherite_boots", new GildedArmorItem(ModArmorMaterial.GILDED_NETHERITE, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()));

    // For the Enderite mod
    public static final Item GILDED_ENDERITE_HELMET = addItem("gilded_enderite_helmet", new GildedEnderiteHelmetItem(new Item.Settings().fireproof()));
    public static final Item GILDED_ENDERITE_CHESTPLATE = addItem("gilded_enderite_chestplate", new GildedArmorItem(ModArmorMaterial.GILDED_ENDERITE, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));
    public static final Item GILDED_ENDERITE_LEGGINGS = addItem("gilded_enderite_leggings", new GildedArmorItem(ModArmorMaterial.GILDED_ENDERITE, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));
    public static final Item GILDED_ENDERITE_BOOTS = addItem("gilded_enderite_boots", new GildedArmorItem(ModArmorMaterial.GILDED_ENDERITE, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()));

    protected static Item addItem(String id, Item item)
    {
        ITEMS.put(id, item);
        return item;
    }
}
