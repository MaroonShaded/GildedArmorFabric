package maroonshaded.gildedarmor.init;

import maroonshaded.gildedarmor.GildedArmor;
import maroonshaded.gildedarmor.item.ModArmorMaterials;
import maroonshaded.gildedarmor.item.ModSmithingTemplateItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems
{
    public static final Item GILDING_UPGRADE_SMITHING_TEMPLATE = register("gilding_upgrade_smithing_template", ModSmithingTemplateItem::createGildingUpgrade, new Item.Settings().rarity(Rarity.UNCOMMON));

    public static final Item GILDED_NETHERITE_HELMET = register("gilded_netherite_helmet", settings -> new ArmorItem(ModArmorMaterials.GILDED_NETHERITE, EquipmentType.HELMET, settings), new Item.Settings().fireproof());
    public static final Item GILDED_NETHERITE_CHESTPLATE = register("gilded_netherite_chestplate", settings -> new ArmorItem(ModArmorMaterials.GILDED_NETHERITE, EquipmentType.CHESTPLATE, settings), new Item.Settings().fireproof());
    public static final Item GILDED_NETHERITE_LEGGINGS = register("gilded_netherite_leggings", settings -> new ArmorItem(ModArmorMaterials.GILDED_NETHERITE, EquipmentType.LEGGINGS, settings), new Item.Settings().fireproof());
    public static final Item GILDED_NETHERITE_BOOTS = register("gilded_netherite_boots", settings -> new ArmorItem(ModArmorMaterials.GILDED_NETHERITE, EquipmentType.BOOTS, settings), new Item.Settings().fireproof());

    // For the Enderite mod
    public static final Item GILDED_ENDERITE_HELMET = register("gilded_enderite_helmet", settings -> new ArmorItem(ModArmorMaterials.GILDED_ENDERITE, EquipmentType.HELMET, settings), new Item.Settings().fireproof());
    public static final Item GILDED_ENDERITE_CHESTPLATE = register("gilded_enderite_chestplate", settings -> new ArmorItem(ModArmorMaterials.GILDED_ENDERITE, EquipmentType.CHESTPLATE, settings), new Item.Settings().fireproof());
    public static final Item GILDED_ENDERITE_LEGGINGS = register("gilded_enderite_leggings", settings -> new ArmorItem(ModArmorMaterials.GILDED_ENDERITE, EquipmentType.LEGGINGS, settings), new Item.Settings().fireproof());
    public static final Item GILDED_ENDERITE_BOOTS = register("gilded_enderite_boots", settings -> new ArmorItem(ModArmorMaterials.GILDED_ENDERITE, EquipmentType.BOOTS, settings), new Item.Settings().fireproof());

    private static Item register(String id, Function<Item.Settings, Item> factory, Item.Settings settings)
    {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, GildedArmor.identifier(id));
        Item item = factory.apply(settings.registryKey(itemKey));
        return Registry.register(Registries.ITEM, itemKey, item);
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
