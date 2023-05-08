package maroonshaded.gildedarmor;

import maroonshaded.gildedarmor.init.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class GildedArmor implements ModInitializer
{
    public static final String MODID = "gildedarmor";
    public static final String ENDERITE_MOD_MODID = "enderitemod";

    public static final Identifier ENDERITE_GROUP = new Identifier(ENDERITE_MOD_MODID, "enderite_group");

    public static final TagKey<Item> PIGLIN_SAFE_ARMOR = TagKey.of(RegistryKeys.ITEM, new Identifier(MODID, "piglin_safe_armor"));
    public static final TagKey<Item> ENDERITE_INGOT = TagKey.of(RegistryKeys.ITEM, new Identifier(MODID, "enderite_ingot"));

    @Override
    public void onInitialize()
    {
        ModItems.ITEMS.forEach(this::registerItem);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries ->
                entries.addAfter(Items.NETHERITE_BOOTS,
                        ModItems.GILDED_NETHERITE_HELMET,
                        ModItems.GILDED_NETHERITE_CHESTPLATE,
                        ModItems.GILDED_NETHERITE_LEGGINGS,
                        ModItems.GILDED_NETHERITE_BOOTS,

                        ModItems.GILDED_ENDERITE_HELMET,
                        ModItems.GILDED_ENDERITE_CHESTPLATE,
                        ModItems.GILDED_ENDERITE_LEGGINGS,
                        ModItems.GILDED_ENDERITE_BOOTS
                )
        );
        ItemGroupEvents.modifyEntriesEvent(ENDERITE_GROUP).register(entries ->
                entries.addAfter(Registries.ITEM.get(new Identifier(ENDERITE_MOD_MODID, "enderite_boots")),
                        ModItems.GILDED_ENDERITE_HELMET,
                        ModItems.GILDED_ENDERITE_CHESTPLATE,
                        ModItems.GILDED_ENDERITE_LEGGINGS,
                        ModItems.GILDED_ENDERITE_BOOTS
                )
        );
    }

    private void registerItem(String id, Item item)
    {
        Registry.register(Registries.ITEM, new Identifier(MODID, id), item);
    }
}
