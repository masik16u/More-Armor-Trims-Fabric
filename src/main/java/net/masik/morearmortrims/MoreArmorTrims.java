package net.masik.morearmortrims;

import net.fabricmc.api.ModInitializer;

import net.masik.morearmortrims.item.ModItems;
import net.masik.morearmortrims.util.ModLootTableModifiers;
import net.masik.morearmortrims.util.TrimHelper;
import net.minecraft.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreArmorTrims implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("more_armor_trims");
	public static final String MOD_ID = "more_armor_trims";

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

		ModLootTableModifiers.modifyLootTables();

	}
}