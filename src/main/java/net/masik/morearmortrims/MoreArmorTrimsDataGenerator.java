package net.masik.morearmortrims;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.masik.morearmortrims.datagen.ModItemTagProvider;
import net.masik.morearmortrims.datagen.ModModelProvider;
import net.masik.morearmortrims.datagen.ModRecipeProvider;

public class MoreArmorTrimsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);

	}
}
