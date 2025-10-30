package net.masik.morearmortrims;

import net.fabricmc.api.ModInitializer;

import net.masik.morearmortrims.item.ModItems;
import net.masik.morearmortrims.util.ModLootTableModifiers;
import net.masik.morearmortrims.util.ModRegistries;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.registry.RegistryKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MoreArmorTrims implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("more_armor_trims");
	public static final String MOD_ID = "more_armor_trims";

	public static final List<RegistryKey<ArmorTrimMaterial>> TRIM_MATERIALS = new ArrayList<>();

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

		ModLootTableModifiers.modifyLootTables();
		ModRegistries.registerRegistries();

	}
}