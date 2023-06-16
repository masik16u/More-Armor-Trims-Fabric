package net.masik.morearmortrims.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class ModItemGroup {

    public static void registerItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(ModItems.STORM_ARMOR_TRIM_SMITHING_TEMPLATE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(ModItems.RAM_ARMOR_TRIM_SMITHING_TEMPLATE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(ModItems.MYTH_ARMOR_TRIM_SMITHING_TEMPLATE));
    }

}
