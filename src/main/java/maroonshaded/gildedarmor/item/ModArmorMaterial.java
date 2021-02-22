package maroonshaded.gildedarmor.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public enum ModArmorMaterial implements ArmorMaterial
{
    GILDED_NETHERITE(ArmorMaterials.NETHERITE);

    private final ArmorMaterial reference;

    ModArmorMaterial(ArmorMaterial reference)
    {
        this.reference = reference;
    }

    @Override
    public int getDurability(EquipmentSlot slot)
    {
        return reference.getDurability(slot);
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot)
    {
        return reference.getProtectionAmount(slot);
    }

    @Override
    public int getEnchantability()
    {
        return reference.getEnchantability();
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return reference.getEquipSound();
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return reference.getRepairIngredient();
    }

    @Override
    public String getName()
    {
        return "gilded_" + reference.getName();
    }

    @Override
    public float getToughness()
    {
        return reference.getToughness();
    }

    @Override
    public float getKnockbackResistance()
    {
        return reference.getKnockbackResistance();
    }
}
