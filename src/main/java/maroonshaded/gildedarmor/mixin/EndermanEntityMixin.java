package maroonshaded.gildedarmor.mixin;

import maroonshaded.gildedarmor.item.GildedEnderiteHelmetItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EndermanEntity.class)
public class EndermanEntityMixin
{
    @Inject(at = @At("HEAD"), cancellable = true, method = "isPlayerStaring")
    private void isPlayerStaring(PlayerEntity player, CallbackInfoReturnable<Boolean> info)
    {
        if (player.getEquippedStack(EquipmentSlot.HEAD).getItem() instanceof GildedEnderiteHelmetItem)
            info.setReturnValue(false);
    }
}
