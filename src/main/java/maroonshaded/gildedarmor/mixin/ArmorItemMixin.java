package maroonshaded.gildedarmor.mixin;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import maroonshaded.gildedarmor.item.ModArmorMaterial;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.EnumMap;
import java.util.UUID;

@Mixin(ArmorItem.class)
public abstract class ArmorItemMixin
{
	@Shadow @Final private static EnumMap<ArmorItem.Type, UUID> MODIFIERS;
	@Shadow @Final @Mutable private Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
	@Shadow @Final protected float knockbackResistance;

	@Inject(method = "<init>", at = @At(value = "RETURN"))
	private void constructor(ArmorMaterial material, ArmorItem.Type type, Item.Settings settings, CallbackInfo info)
	{
		if (material instanceof ModArmorMaterial)
		{
			ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
			builder.putAll(attributeModifiers);

			builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
					new EntityAttributeModifier(
							MODIFIERS.get(type),
							"Armor knockback resistance",
							knockbackResistance,
							EntityAttributeModifier.Operation.ADDITION));

			attributeModifiers = builder.build();
		}
	}
}
