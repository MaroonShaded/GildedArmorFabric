package maroonshaded.gildedarmor.item;

import maroonshaded.gildedarmor.GildedArmor;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public enum ModArmorMaterial implements ArmorMaterial
{
    GILDED_NETHERITE(ArmorMaterials.NETHERITE);

    private final ArmorMaterial REFERENCE;

    ModArmorMaterial(ArmorMaterial reference)
    {
        REFERENCE = reference;
    }

    @Override
    public int getDurability(EquipmentSlot slot)
    {
        return REFERENCE.getDurability(slot);
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot)
    {
        return REFERENCE.getProtectionAmount(slot);
    }

    @Override
    public int getEnchantability()
    {
        return REFERENCE.getEnchantability();
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return REFERENCE.getEquipSound();
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return REFERENCE.getRepairIngredient();
    }

    @Override
    public String getName()
    {
        return "gilded_" + REFERENCE.getName();
    }

    @Override
    public float getToughness()
    {
        return REFERENCE.getToughness();
    }

    @Override
    public float getKnockbackResistance()
    {
        return REFERENCE.getKnockbackResistance();
    }
}
