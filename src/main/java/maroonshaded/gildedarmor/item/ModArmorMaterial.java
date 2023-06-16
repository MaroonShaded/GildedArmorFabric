package maroonshaded.gildedarmor.item;

import com.google.common.base.Suppliers;
import maroonshaded.gildedarmor.GildedArmor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmorMaterial implements StringIdentifiable, ArmorMaterial
{
    GILDED_NETHERITE("gilded_netherite", 37, Util.make(new EnumMap<>(ArmorItem.Type.class), map ->
    {
        map.put(ArmorItem.Type.BOOTS, 3);
        map.put(ArmorItem.Type.LEGGINGS, 6);
        map.put(ArmorItem.Type.CHESTPLATE, 8);
        map.put(ArmorItem.Type.HELMET, 3);
    }), 17, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
            () -> Ingredient.ofItems(Items.NETHERITE_INGOT), true),
    GILDED_ENDERITE("gilded_enderite", 8, Util.make(new EnumMap<>(ArmorItem.Type.class), map ->
    {
        map.put(ArmorItem.Type.BOOTS, 4);
        map.put(ArmorItem.Type.LEGGINGS, 7);
        map.put(ArmorItem.Type.CHESTPLATE, 9);
        map.put(ArmorItem.Type.HELMET, 4);
    }), 17, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F,
            () -> Ingredient.fromTag(GildedArmor.ENDERITE_INGOT), true);

    private static final EnumMap<ArmorItem.Type, Integer> BASE_DURABILITY = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 13);
        map.put(ArmorItem.Type.LEGGINGS, 15);
        map.put(ArmorItem.Type.CHESTPLATE, 16);
        map.put(ArmorItem.Type.HELMET, 11);
    });
    private static final EnumMap<ArmorItem.Type, Integer> ENDERITE_BASE_DURABILITY = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 128);
        map.put(ArmorItem.Type.LEGGINGS, 144);
        map.put(ArmorItem.Type.CHESTPLATE, 160);
        map.put(ArmorItem.Type.HELMET, 112);
    });
    private final String name;
    private final int durabilityMultiplier;
    private final boolean useEnderiteDurability;
    private final EnumMap<ArmorItem.Type, Integer> protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredientSupplier;

    ModArmorMaterial(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier, boolean useEnderiteDurability)
    {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.useEnderiteDurability = useEnderiteDurability;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = Suppliers.memoize(repairIngredientSupplier::get);
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        EnumMap<ArmorItem.Type, Integer> baseDurabilityMap = useEnderiteDurability ? ENDERITE_BASE_DURABILITY : BASE_DURABILITY;
        return baseDurabilityMap.get(type) * durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts.get(type);
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

    /**
     * {@return the unique string representation of the enum, used for serialization}
     */
    @Override
    public String asString() {
        return getName();
    }


}
