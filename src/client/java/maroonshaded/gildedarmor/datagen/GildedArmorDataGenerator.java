package maroonshaded.gildedarmor.datagen;

import maroonshaded.gildedarmor.GildedArmor;
import maroonshaded.gildedarmor.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

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
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator)
        {
            // No blocks
        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator)
        {
            itemModelGenerator.register(ModItems.GILDING_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);

            // Pay attention to replace with netherite_darker when applicable
            for (Item item : GildedArmor.ITEMS.values())
                if (item instanceof ArmorItem armorItem)
                    itemModelGenerator.registerArmor(armorItem);
        }
    }
}
