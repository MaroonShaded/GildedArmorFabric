package maroonshaded.gildedarmor.item;

import maroonshaded.gildedarmor.GildedArmor;
import net.minecraft.item.Item;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class ModSmithingTemplateItem extends SmithingTemplateItem
{
    private static final Text GILDING_UPGRADE_APPLIES_TO_TEXT = Text.translatable(Util.createTranslationKey("item", GildedArmor.identifier("smithing_template.gilding_upgrade.applies_to"))).formatted(DESCRIPTION_FORMATTING);
    private static final Text GILDING_UPGRADE_INGREDIENTS_TEXT = Text.translatable(Util.createTranslationKey("item", GildedArmor.identifier("smithing_template.gilding_upgrade.ingredients"))).formatted(DESCRIPTION_FORMATTING);
    private static final Text GILDING_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", GildedArmor.identifier("smithing_template.gilding_upgrade.base_slot_description")));
    private static final Text GILDING_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", GildedArmor.identifier("smithing_template.gilding_upgrade.additions_slot_description")));

    private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = Identifier.ofVanilla("container/slot/helmet");
    private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = Identifier.ofVanilla("container/slot/chestplate");
    private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = Identifier.ofVanilla("container/slot/leggings");
    private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = Identifier.ofVanilla("container/slot/boots");
    private static final Identifier EMPTY_SLOT_INGOT_TEXTURE = Identifier.ofVanilla("container/slot/ingot");

    public ModSmithingTemplateItem(Text pAppliesTo, Text pIngredients, Text pBaseSlotDescription, Text pAdditionsSlotDescription, List<Identifier> pBaseSlotEmptyIcons, List<Identifier> pAdditionalSlotEmptyIcons, Item.Settings settings)
    {
        super(pAppliesTo, pIngredients, pBaseSlotDescription, pAdditionsSlotDescription, pBaseSlotEmptyIcons, pAdditionalSlotEmptyIcons, settings);
    }

    public static ModSmithingTemplateItem createGildingUpgrade(Item.Settings settings)
    {
        return new ModSmithingTemplateItem(GILDING_UPGRADE_APPLIES_TO_TEXT, GILDING_UPGRADE_INGREDIENTS_TEXT, GILDING_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, GILDING_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT, getGildingUpgradeEmptyBaseSlotTextures(), getGildingUpgradeEmptyAdditionsSlotTextures(), settings);
    }

    public static List<Identifier> getGildingUpgradeEmptyBaseSlotTextures()
    {
        return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE);
    }

    public static List<Identifier> getGildingUpgradeEmptyAdditionsSlotTextures()
    {
        return List.of(EMPTY_SLOT_INGOT_TEXTURE);
    }
}
