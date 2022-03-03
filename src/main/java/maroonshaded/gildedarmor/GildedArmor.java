package maroonshaded.gildedarmor;

import maroonshaded.gildedarmor.init.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GildedArmor implements ModInitializer
{
    public static final String MODID = "gildedarmor";

    public static final TagKey<Item> PIGLIN_SAFE_ARMOR = TagKey.of(Registry.ITEM_KEY, new Identifier(MODID, "piglin_safe_armor"));
    public static final TagKey<Item> ENDERITE_INGOT = TagKey.of(Registry.ITEM_KEY, new Identifier(MODID, "enderite_ingot"));

    @Override
    public void onInitialize()
    {
        registerItem("gilded_netherite_helmet", ModItems.GILDED_NETHERITE_HELMET);
        registerItem("gilded_netherite_chestplate", ModItems.GILDED_NETHERITE_CHESTPLATE);
        registerItem("gilded_netherite_leggings", ModItems.GILDED_NETHERITE_LEGGINGS);
        registerItem("gilded_netherite_boots", ModItems.GILDED_NETHERITE_BOOTS);
        
        // For the Enderite mod
        registerItem("gilded_enderite_helmet", ModItems.GILDED_ENDERITE_HELMET);
        registerItem("gilded_enderite_chestplate", ModItems.GILDED_ENDERITE_CHESTPLATE);
        registerItem("gilded_enderite_leggings", ModItems.GILDED_ENDERITE_LEGGINGS);
        registerItem("gilded_enderite_boots", ModItems.GILDED_ENDERITE_BOOTS);
    }

    private void registerItem(String id, Item item)
    {
        Registry.register(Registry.ITEM, new Identifier(MODID, id), item);
    }
}
