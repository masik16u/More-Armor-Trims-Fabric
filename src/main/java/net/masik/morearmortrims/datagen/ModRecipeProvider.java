package net.masik.morearmortrims.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.masik.morearmortrims.util.TrimHelper;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        for (int i = 0; i < TrimHelper.SMITHING_TEMPLATES.size(); i++) {

            offerSmithingTemplateCopyingRecipe(exporter, TrimHelper.SMITHING_TEMPLATES.get(i), TrimHelper.TRIM_MATERIALS.get(i));

        }

        for (Item item : TrimHelper.SMITHING_TEMPLATES) {

            offerSmithingTrimRecipe(exporter, item, Identifier.of(item.getTranslationKey().substring(22) + "_smithing_trim"));

        }

    }
}
