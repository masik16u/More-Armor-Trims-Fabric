package net.masik.morearmortrims.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.masik.morearmortrims.MoreArmorTrims;
import net.masik.morearmortrims.util.TrimHelper;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                for (int i = 0; i < TrimHelper.SMITHING_TEMPLATES.size(); i++) {

                    offerSmithingTemplateCopyingRecipe(TrimHelper.SMITHING_TEMPLATES.get(i), TrimHelper.TRIM_MATERIALS.get(i));

                }

                for (int i = 0; i < TrimHelper.SMITHING_TEMPLATES.size(); i++) {

                    Item item = TrimHelper.SMITHING_TEMPLATES.get(i);
                    offerSmithingTrimRecipe(item,
                            TrimHelper.TRIM_PATTERNS.get(i),
                            RegistryKey.of(RegistryKeys.RECIPE,
                                    Identifier.of(item.getTranslationKey().substring(22) + "_smithing_trim")));

                }

            }
        };
    }

    @Override
    public String getName() {
        return "MAT Recipes";
    }
}
