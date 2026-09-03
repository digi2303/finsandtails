package blueportal.finsandstails.common.jei;

import blueportal.finsandstails.FinsAndTails;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import net.minecraft.resources.Identifier;

@JeiPlugin
public class FinsJEIPlugin implements IModPlugin {
    private static final Identifier PLUGIN_ID = FinsAndTails.id("jei_plugin");

    @Override
    public Identifier getPluginUid() {
        return PLUGIN_ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper helper = registration.getJeiHelpers().getGuiHelper();

        registration.addRecipeCategories(new CrunchingRecipeCategory(helper));
    }
}
