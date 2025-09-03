package maroonshaded.gildedarmor;

import maroonshaded.gildedarmor.init.ModItems;
import maroonshaded.gildedarmor.item.ModArmorMaterials;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class GildedArmor implements ModInitializer
{
    public static final String MODID = "gildedarmor";
    public static final String ENDERITE_MOD_MODID = "enderitemod";

    public static final Map<String, Item> ITEMS = new HashMap<>(9);

    public static final RegistryKey<ItemGroup> ENDERITE_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(ENDERITE_MOD_MODID, "enderite_group"));

    public static final TagKey<Item> GILDED_ARMOR = TagKey.of(RegistryKeys.ITEM, identifier("gilded_armor"));
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
