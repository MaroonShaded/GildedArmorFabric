package maroonshaded.gildedarmor.item;

import com.google.common.base.Suppliers;
import maroonshaded.gildedarmor.GildedArmor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public enum ModArmorMaterial implements ArmorMaterial
{
    GILDED_NETHERITE("gilded_netherite", ArmorMaterials.NETHERITE),
    GILDED_ENDERITE("gilded_enderite", 8, new int[] { 4, 7, 9, 4 }, 17, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F,
            () -> Ingredient.fromTag(GildedArmor.ENDERITE_INGOT),
            true);

    private static final int[] BASE_DURABILITY = {13, 15, 16, 11};
    private static final int[] ENDERITE_BASE_DURABILITY = {128, 144, 160, 112};
    private final String name;
    private final ToIntFunction<EquipmentSlot> durability;
    private final ToIntFunction<EquipmentSlot> protectionAmount;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredientSupplier;

    ModArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier, boolean useEnderiteDurability)
    {
        this.name = name;
        durability = slot -> (useEnderiteDurability ? getEnderiteBaseDurability() : getBaseDurability())[slot.getEntitySlotId()] * durabilityMultiplier;
        protectionAmount = slot -> protectionAmounts[slot.getEntitySlotId()];
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = Suppliers.memoize(repairIngredientSupplier::get);
    }

    ModArmorMaterial(String name, ArmorMaterial reference)
    {
        this.name = name;
        durability = reference::getDurability;
        protectionAmount = reference::getProtectionAmount;
        enchantability = reference.getEnchantability();
        equipSound = reference.getEquipSound();
        toughness = reference.getToughness();
        knockbackResistance = reference.getKnockbackResistance();
        repairIngredientSupplier = reference::getRepairIngredient;
    }

    public static int[] getBaseDurability()
    {
        return BASE_DURABILITY;
    }

    public static int[] getEnderiteBaseDurability()
    {
        return ENDERITE_BASE_DURABILITY;
    }

    @Override
    public int getDurability(EquipmentSlot slot)
    {
        return durability.applyAsInt(slot);
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot)
    {
        return protectionAmount.applyAsInt(slot);
    }

    @Override
    public int getEnchantability()
    {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return repairIngredientSupplier.get();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public float getToughness()
    {
        return toughness;
    }

    @Override
    public float getKnockbackResistance()
    {
        return knockbackResistance;
    }
}
