package maroonshaded.gildedarmor.init;

import maroonshaded.gildedarmor.GildedArmor;
import maroonshaded.gildedarmor.item.GildedEnderiteHelmetItem;
import maroonshaded.gildedarmor.item.ModArmorMaterials;
import maroonshaded.gildedarmor.item.ModSmithingTemplateItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems
{

    public static final Item GILDING_UPGRADE_SMITHING_TEMPLATE = register("gilding_upgrade_smithing_template", ModSmithingTemplateItem.createGildingUpgradeTemplate());

    public static final int GILDED_NETHERITE_DURABILITY_MULTIPLIER = 37;
    public static final Item GILDED_NETHERITE_HELMET = register("gilded_netherite_helmet", new ArmorItem(ModArmorMaterials.GILDED_NETHERITE, ArmorItem.Type.HELMET, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(GILDED_NETHERITE_DURABILITY_MULTIPLIER))));
    public static final Item GILDED_NETHERITE_CHESTPLATE = register("gilded_netherite_chestplate", new ArmorItem(ModArmorMaterials.GILDED_NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(GILDED_NETHERITE_DURABILITY_MULTIPLIER))));
    public static final Item GILDED_NETHERITE_LEGGINGS = register("gilded_netherite_leggings", new ArmorItem(ModArmorMaterials.GILDED_NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(GILDED_NETHERITE_DURABILITY_MULTIPLIER))));
    public static final Item GILDED_NETHERITE_BOOTS = register("gilded_netherite_boots", new ArmorItem(ModArmorMaterials.GILDED_NETHERITE, ArmorItem.Type.BOOTS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(GILDED_NETHERITE_DURABILITY_MULTIPLIER))));

    // For the Enderite mod
    public static final int GILDED_ENDERITE_DURABILITY_MULTIPLIER = 72;
    public static final Item GILDED_ENDERITE_HELMET = register("gilded_enderite_helmet", new GildedEnderiteHelmetItem(new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(GILDED_ENDERITE_DURABILITY_MULTIPLIER))));
    public static final Item GILDED_ENDERITE_CHESTPLATE = register("gilded_enderite_chestplate", new ArmorItem(ModArmorMaterials.GILDED_ENDERITE, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(GILDED_ENDERITE_DURABILITY_MULTIPLIER))));
    public static final Item GILDED_ENDERITE_LEGGINGS = register("gilded_enderite_leggings", new ArmorItem(ModArmorMaterials.GILDED_ENDERITE, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(GILDED_ENDERITE_DURABILITY_MULTIPLIER))));
    public static final Item GILDED_ENDERITE_BOOTS = register("gilded_enderite_boots", new ArmorItem(ModArmorMaterials.GILDED_ENDERITE, ArmorItem.Type.BOOTS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(GILDED_ENDERITE_DURABILITY_MULTIPLIER))));

    private static Item register(String id, Item item)
    {
        GildedArmor.ITEMS.put(id, item);
        return Registry.register(Registries.ITEM, GildedArmor.identifier(id), item);
    }

    public static void initialize()
    {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->
                entries.addAfter(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.GILDING_UPGRADE_SMITHING_TEMPLATE)
        );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries ->
                entries.addAfter(Items.NETHERITE_BOOTS,
                        ModItems.GILDED_NETHERITE_HELMET,
                        ModItems.GILDED_NETHERITE_CHESTPLATE,
                        ModItems.GILDED_NETHERITE_LEGGINGS,
                        ModItems.GILDED_NETHERITE_BOOTS
                )
        );
        ItemGroupEvents.modifyEntriesEvent(GildedArmor.ENDERITE_GROUP).register(entries ->
                entries.addAfter(Registries.ITEM.get(Identifier.of(GildedArmor.ENDERITE_MOD_MODID, "enderite_boots")),
                        ModItems.GILDED_ENDERITE_HELMET,
                        ModItems.GILDED_ENDERITE_CHESTPLATE,
                        ModItems.GILDED_ENDERITE_LEGGINGS,
                        ModItems.GILDED_ENDERITE_BOOTS
                )
        );
    }
}
