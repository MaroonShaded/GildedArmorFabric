package maroonshaded.gildedarmor;

import maroonshaded.gildedarmor.init.ModItems;
import maroonshaded.gildedarmor.item.ModArmorMaterials;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class GildedArmor implements ModInitializer
{
    public static final String MODID = "gildedarmor";
    public static final String ENDERITE_MOD_MODID = "enderitemod";

    public static final RegistryKey<ItemGroup> ENDERITE_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(ENDERITE_MOD_MODID, "enderite_group"));

    public static final RegistryKey<EquipmentAsset> GILDED_NETHERITE_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, GildedArmor.identifier("gilded_netherite"));
    public static final RegistryKey<EquipmentAsset> GILDED_ENDERITE_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, GildedArmor.identifier("gilded_enderite"));

    public static final TagKey<Item> REPAIRS_ENDERITE_ARMOR = TagKey.of(RegistryKeys.ITEM, Identifier.of(ENDERITE_MOD_MODID, "repairs_enderite_armor"));

    @Override
    public void onInitialize()
    {
        ModArmorMaterials.initialize();
        ModItems.initialize();
    }

    public static Identifier identifier(String path)
    {
        return Identifier.of(MODID, path);
    }
}
