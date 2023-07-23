package maroonshaded.gildedarmor;

import com.redlimerl.detailab.DetailArmorBar;
import com.redlimerl.detailab.api.DetailArmorBarAPI;
import com.redlimerl.detailab.api.render.ArmorBarRenderManager;
import com.redlimerl.detailab.api.render.TextureOffset;
import maroonshaded.gildedarmor.init.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class GildedArmorClient implements ClientModInitializer
{
    private static final Identifier ARMOR_BAR_TEXTURE = GildedArmor.identifier("textures/armor_bar.png");

    @Override
    public void onInitializeClient()
    {
        TextureOffset outline = new TextureOffset(9, 0);
        TextureOffset outlineHalf = new TextureOffset(0, 0);

        DetailArmorBarAPI.customArmorBarBuilder()
                .armor(
                        (ArmorItem) ModItems.GILDED_NETHERITE_HELMET,
                        (ArmorItem) ModItems.GILDED_NETHERITE_CHESTPLATE,
                        (ArmorItem) ModItems.GILDED_NETHERITE_LEGGINGS,
                        (ArmorItem) ModItems.GILDED_NETHERITE_BOOTS)
                .render(stack ->
                        {
                            boolean useVanillaTextures = DetailArmorBar.getConfig().getOptions().toggleVanillaTexture;
                            int y = useVanillaTextures ? 18 : 9;

                            return new ArmorBarRenderManager(ARMOR_BAR_TEXTURE, 32, 32,
                                    new TextureOffset(9, y),
                                    new TextureOffset(0, y),
                                    outline, outlineHalf);
                        }
                )
                .register();
    }
}
