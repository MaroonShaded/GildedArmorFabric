package maroonshaded.gildedarmor;

import com.redlimerl.detailab.DetailArmorBar;
import com.redlimerl.detailab.api.DetailArmorBarAPI;
import com.redlimerl.detailab.api.render.ArmorBarRenderManager;
import com.redlimerl.detailab.api.render.TextureOffset;
import maroonshaded.gildedarmor.init.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class GildedArmorClient implements ClientModInitializer
{
    public static final String DETAILAB_MODID = "detailab";

    private static final Identifier ARMOR_BAR_TEXTURE = GildedArmor.identifier("textures/gui/armor_bar.png");

    @Override
    public void onInitializeClient()
    {
        if (FabricLoader.getInstance().isModLoaded(DETAILAB_MODID))
        {
            registerArmorBars();
        }
    }

    private static void registerArmorBars()
    {
        TextureOffset outline = new TextureOffset(9, 0);
        TextureOffset outlineHalf = new TextureOffset(0, 0);

        ArmorBarRenderManager renderManager = new ArmorBarRenderManager(ARMOR_BAR_TEXTURE, 32, 32,
                new TextureOffset(9, 9),
                new TextureOffset(0, 9),
                outline, outlineHalf);
        ArmorBarRenderManager vanillaRenderManager = new ArmorBarRenderManager(ARMOR_BAR_TEXTURE, 32, 32,
                new TextureOffset(9, 18),
                new TextureOffset(0, 18),
                outline, outlineHalf);

        DetailArmorBarAPI.customArmorBarBuilder()
                .armor(
                        (ArmorItem) ModItems.GILDED_NETHERITE_HELMET,
                        (ArmorItem) ModItems.GILDED_NETHERITE_CHESTPLATE,
                        (ArmorItem) ModItems.GILDED_NETHERITE_LEGGINGS,
                        (ArmorItem) ModItems.GILDED_NETHERITE_BOOTS)
                .render(stack -> DetailArmorBar.getConfig().getOptions().toggleVanillaTexture
                        ? vanillaRenderManager
                        : renderManager)
                .register();
    }
}
