package maroonshaded.gildedarmor.datagen;

import maroonshaded.gildedarmor.GildedArmor;
import maroonshaded.gildedarmor.init.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class GildedArmorDataGenerator implements DataGeneratorEntrypoint
{
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator)
    {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModelProvider::new);
    }

    static class ModelProvider extends FabricModelProvider
    {
        public ModelProvider(FabricDataOutput output)
        {
            super(output);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator generator)
        {
            // No blocks
        }

        @Override
        public void generateItemModels(ItemModelGenerator generator)
        {
            generator.register(ModItems.GILDING_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);

            // Pay attention to replace with the _darker variants when applicable
            generator.registerArmor(ModItems.GILDED_NETHERITE_HELMET, GildedArmor.GILDED_NETHERITE_ARMOR_MATERIAL_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
            generator.registerArmor(ModItems.GILDED_NETHERITE_CHESTPLATE, GildedArmor.GILDED_NETHERITE_ARMOR_MATERIAL_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
            generator.registerArmor(ModItems.GILDED_NETHERITE_LEGGINGS, GildedArmor.GILDED_NETHERITE_ARMOR_MATERIAL_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
            generator.registerArmor(ModItems.GILDED_NETHERITE_BOOTS, GildedArmor.GILDED_NETHERITE_ARMOR_MATERIAL_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
            generator.registerArmor(ModItems.GILDED_ENDERITE_HELMET, GildedArmor.GILDED_ENDERITE_ARMOR_MATERIAL_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
            generator.registerArmor(ModItems.GILDED_ENDERITE_CHESTPLATE, GildedArmor.GILDED_ENDERITE_ARMOR_MATERIAL_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
            generator.registerArmor(ModItems.GILDED_ENDERITE_LEGGINGS, GildedArmor.GILDED_ENDERITE_ARMOR_MATERIAL_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
            generator.registerArmor(ModItems.GILDED_ENDERITE_BOOTS, GildedArmor.GILDED_ENDERITE_ARMOR_MATERIAL_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
        }
    }
}
