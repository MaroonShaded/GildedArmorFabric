package maroonshaded.gildedarmor.item;

import maroonshaded.gildedarmor.GildedArmor;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMaterials
{
    public static final RegistryEntry<ArmorMaterial> GILDED_NETHERITE = registerCopy("gilded_netherite", ArmorMaterials.NETHERITE.value());
    public static final RegistryEntry<ArmorMaterial> GILDED_ENDERITE = registerCopyOr("gilded_enderite", Identifier.of(GildedArmor.ENDERITE_MOD_MODID, "enderite"),
            Map.of(ArmorItem.Type.BOOTS, 4, ArmorItem.Type.LEGGINGS, 7, ArmorItem.Type.CHESTPLATE, 9, ArmorItem.Type.HELMET, 4, ArmorItem.Type.BODY, 12),
            17, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.fromTag(GildedArmor.REPAIRS_ENDERITE_ARMOR), 4.0f, 0.1f);

    private static RegistryEntry<ArmorMaterial> register(String id, Map<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredient, float toughness, float knockbackResistance)
    {
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(GildedArmor.identifier(id)));
        ArmorMaterial material = new ArmorMaterial(defense, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance);
        return RegistryEntry.of(Registry.register(Registries.ARMOR_MATERIAL, GildedArmor.identifier(id), material));
    }

    private static RegistryEntry<ArmorMaterial> registerCopy(String id, ArmorMaterial from)
    {
        return register(id, from.defense(), from.enchantability(), from.equipSound(), from.repairIngredient(), from.toughness(), from.knockbackResistance());
    }

    private static RegistryEntry<ArmorMaterial> registerCopyOr(String id, Identifier fromId, Map<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredient, float toughness, float knockbackResistance)
    {
        return Registries.ARMOR_MATERIAL.getOrEmpty(fromId)
                .map(material -> registerCopy(id, material))
                .orElseGet(() -> register(id, defense, enchantability, equipSound, repairIngredient, toughness, knockbackResistance));
    }

    public static void initialize()
    {
        // Dummy static initializer
    }
}
