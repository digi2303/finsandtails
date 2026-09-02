package blueportal.finsandstails.registry;

import blueportal.finsandstails.FinsAndTails;
import blueportal.finsandstails.common.crafting.CrunchingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class FTRecipes {
    public static RecipeType<CrunchingRecipe> CRUNCHING_TYPE;
    public static RecipeSerializer<CrunchingRecipe> CRUNCHING_SERIALIZER;

    public static void register() {
        CRUNCHING_TYPE = registerType("crunching");
        CRUNCHING_SERIALIZER = Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, FinsAndTails.id("crunching"), new CrunchingRecipe.Serializer());
    }

    private static <T extends Recipe<?>> RecipeType<T> registerType(String name) {
        return Registry.register(BuiltInRegistries.RECIPE_TYPE, FinsAndTails.id(name), new RecipeType<T>() {
            public String toString() {
                return FinsAndTails.MOD_ID + ":" + name;
            }
        });
    }
}
