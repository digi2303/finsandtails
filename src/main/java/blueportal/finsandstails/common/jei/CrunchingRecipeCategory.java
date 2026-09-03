package blueportal.finsandstails.common.jei;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.common.crafting.CrunchingRecipe;
import blueportal.finsandstails.registry.FTBlocks;
import blueportal.finsandstails.registry.FTRecipes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeHolderType;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.function.Supplier;

public class CrunchingRecipeCategory implements IRecipeCategory<RecipeHolder<CrunchingRecipe>> {
    public static final Supplier<IRecipeHolderType<CrunchingRecipe>> CRUNCHING = IRecipeHolderType.createDeferred(() -> FTRecipes.CRUNCHING_TYPE);

    private final IDrawable icon;

    public CrunchingRecipeCategory(IGuiHelper helper) {
        this.icon = helper.createDrawableItemStack(new ItemStack(FTBlocks.CRAB_CRUNCHER.asItem()));
    }

    @Override
    public IRecipeType<RecipeHolder<CrunchingRecipe>> getRecipeType() {
        return CRUNCHING.get();
    }

    @Override
    public Component getTitle() {
        return Component.translatable("category." + FinsAndTails.MOD_ID + ".crunching_recipe");
    }

    @Override
    public int getWidth() {
        return 125;
    }

    @Override
    public int getHeight() {
        return 18;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<CrunchingRecipe> holder, IFocusGroup focuses) {
        CrunchingRecipe recipe = holder.value();

        builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).add(recipe.getBase().display());
        builder.addSlot(RecipeIngredientRole.INPUT, 49, 0).add(recipe.getAddition().display());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 107, 0).add(recipe.getResult());
    }
}
