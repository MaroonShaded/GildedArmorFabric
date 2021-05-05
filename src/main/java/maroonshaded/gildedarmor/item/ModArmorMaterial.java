package maroonshaded.gildedarmor.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Lazy;
import net.minecraft.util.registry.Registry;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public enum ModArmorMaterial implements ArmorMaterial
{
    GILDED_NETHERITE(ArmorMaterials.NETHERITE),
    GILDED_ENDERITE("gilded_enderite", 8, new int[] { 4, 7, 9, 4 }, 17, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F, () ->
    {
        Optional<Item> item = Registry.ITEM.getOrEmpty(new Identifier("enderitemod", "enderite_ingot"));
        if (item.isPresent()) return Ingredient.ofItems(item.get());
        return Ingredient.ofItems();
    });

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final ToIntFunction<EquipmentSlot> durability;
    private final ToIntFunction<EquipmentSlot> protectionAmount;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    ModArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier)
    {
        this.name = name;
        this.durability = (slot) -> getBaseDurability()[slot.getEntitySlotId()] * durabilityMultiplier;
        this.protectionAmount = (slot) -> protectionAmounts[slot.getEntitySlotId()];
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy<>(repairIngredientSupplier);
    }

    ModArmorMaterial(ArmorMaterial reference)
    {
        this.name = "gilded_" + reference.getName();
        this.durability = reference::getDurability;
        this.protectionAmount = reference::getProtectionAmount;
        this.enchantability = reference.getEnchantability();
        this.equipSound = reference.getEquipSound();
        this.toughness = reference.getToughness();
        this.knockbackResistance = reference.getKnockbackResistance();
        this.repairIngredientSupplier = new Lazy<>(reference::getRepairIngredient);
    }

    public static int[] getBaseDurability()
    {
        return BASE_DURABILITY;
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
