package net.masik.morearmortrims;

import net.fabricmc.api.ModInitializer;
import net.masik.morearmortrims.item.ModItems;
import net.masik.morearmortrims.util.ModLootTableModifiers;
import net.masik.morearmortrims.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreArmorTrims implements ModInitializer {
	public static final String MOD_ID = "more_armor_trims";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("[Mythic Charms] Initializing...");

		ModItems.registerModItems();
		ModLootTableModifiers.modifyLootTables();
		ModRegistries.registerRegistries();
	}

}
