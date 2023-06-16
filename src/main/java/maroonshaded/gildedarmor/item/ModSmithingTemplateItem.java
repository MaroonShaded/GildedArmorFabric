package maroonshaded.gildedarmor.item;

import maroonshaded.gildedarmor.GildedArmor;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class ModSmithingTemplateItem extends SmithingTemplateItem
{
    private static final Text GILDING_UPGRADE = Text.translatable(Util.createTranslationKey("upgrade", GildedArmor.identifier("gilding_upgrade"))).formatted(TITLE_FORMATTING);
    private static final Text GILDING_UPGRADE_APPLIES_TO = Text.translatable(Util.createTranslationKey("item", GildedArmor.identifier("smithing_template.gilding_upgrade.applies_to"))).formatted(DESCRIPTION_FORMATTING);
    private static final Text GILDING_UPGRADE_INGREDIENTS = Text.translatable(Util.createTranslationKey("item", GildedArmor.identifier("smithing_template.gilding_upgrade.ingredients"))).formatted(DESCRIPTION_FORMATTING);
    private static final Text GILDING_UPGRADE_BASE_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", GildedArmor.identifier("smithing_template.gilding_upgrade.base_slot_description")));
    private static final Text GILDING_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Text.translatable(Util.createTranslationKey("item", GildedArmor.identifier("smithing_template.gilding_upgrade.additions_slot_description")));

    public ModSmithingTemplateItem(Text pAppliesTo, Text pIngredients, Text pUpgradeDescription, Text pBaseSlotDescription, Text pAdditionsSlotDescription, List<Identifier> pBaseSlotEmptyIcons, List<Identifier> pAdditionalSlotEmptyIcons)
    {
        super(pAppliesTo, pIngredients, pUpgradeDescription, pBaseSlotDescription, pAdditionsSlotDescription, pBaseSlotEmptyIcons, pAdditionalSlotEmptyIcons);
    }

    public static SmithingTemplateItem createGildingUpgradeTemplate()
    {
        return new SmithingTemplateItem(GILDING_UPGRADE_APPLIES_TO, GILDING_UPGRADE_INGREDIENTS, GILDING_UPGRADE, GILDING_UPGRADE_BASE_SLOT_DESCRIPTION, GILDING_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, getArmorTrimEmptyBaseSlotTextures(), getNetheriteUpgradeEmptyAdditionsSlotTextures());
    }
}
