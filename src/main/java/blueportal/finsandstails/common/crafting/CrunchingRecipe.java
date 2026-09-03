package blueportal.finsandstails.common.crafting;

import blueportal.finsandstails.registry.FTRecipes;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.List;

public class CrunchingRecipe implements Recipe<CrunchingRecipeInput> {
    private final Ingredient base;
    private final Ingredient addition;
    private final ItemStack result;

    public CrunchingRecipe(Ingredient base, Ingredient addition, ItemStack result) {
        this.base = base;
        this.addition = addition;
        this.result = result;
    }

    public static final MapCodec<CrunchingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Ingredient.CODEC.fieldOf("base").forGetter(recipe -> recipe.base),
            Ingredient.CODEC.fieldOf("addition").forGetter(recipe -> recipe.addition),
            ItemStack.CODEC.fieldOf("result").forGetter(recipe -> recipe.result)
    ).apply(instance, CrunchingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, CrunchingRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, recipe -> recipe.base,
            Ingredient.CONTENTS_STREAM_CODEC, recipe -> recipe.addition,
            ItemStack.STREAM_CODEC, recipe -> recipe.result,
            CrunchingRecipe::new
    );

    @Override
    public boolean matches(CrunchingRecipeInput input, Level level) {
        return this.base.test(input.base()) && this.addition.test(input.addition());
    }

    @Override
    public ItemStack assemble(CrunchingRecipeInput input) {
        return this.result.copy();
    }

    public ItemStack getResult() {
        return this.result;
    }

    public Ingredient getBase() {
        return this.base;
    }

    public Ingredient getAddition() {
        return this.addition;
    }

    public boolean isAdditionIngredient(ItemStack stack) {
        return this.addition.test(stack);
    }

    @Override
    public boolean showNotification() {
        return true;
    }

    @Override
    public String group() {
        return "";
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(List.of(this.base, this.addition));
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    @Override
    public RecipeSerializer<? extends Recipe<CrunchingRecipeInput>> getSerializer() {
        return FTRecipes.CRUNCHING_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<CrunchingRecipeInput>> getType() {
        return FTRecipes.CRUNCHING_TYPE;
    }
}
