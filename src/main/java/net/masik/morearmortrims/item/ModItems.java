package net.masik.morearmortrims.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.masik.morearmortrims.MoreArmorTrims;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final SmithingTemplateItem STORM_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("storm_armor_trim_smithing_template");
    public static final SmithingTemplateItem RAM_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("ram_armor_trim_smithing_template");
    public static final SmithingTemplateItem MYTH_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("myth_armor_trim_smithing_template");
    public static final SmithingTemplateItem GREED_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("greed_armor_trim_smithing_template");
    public static final SmithingTemplateItem BEAST_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("beast_armor_trim_smithing_template");
    public static final SmithingTemplateItem FEVER_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("fever_armor_trim_smithing_template");
    public static final SmithingTemplateItem WRAITH_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("wraith_armor_trim_smithing_template");
    public static final SmithingTemplateItem NIHILITY_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("nihility_armor_trim_smithing_template");
    public static final SmithingTemplateItem HORIZON_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("horizon_armor_trim_smithing_template");
    public static final SmithingTemplateItem ORIGIN_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("origin_armor_trim_smithing_template");
    public static final SmithingTemplateItem TWILIGHT_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("twilight_armor_trim_smithing_template");
    public static final SmithingTemplateItem PARASITE_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("parasite_armor_trim_smithing_template");

    private static SmithingTemplateItem registerItem(String name) {
        Identifier id = new Identifier(MoreArmorTrims.MOD_ID, name);
        return Registry.register(Registries.ITEM, id, SmithingTemplateItem.of(id));
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsTabGroup);
    }


    private static void addItemsToIngredientsTabGroup(FabricItemGroupEntries entries) {

        entries.addAfter(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE, STORM_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.addAfter(STORM_ARMOR_TRIM_SMITHING_TEMPLATE, RAM_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.addAfter(RAM_ARMOR_TRIM_SMITHING_TEMPLATE, MYTH_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.addAfter(MYTH_ARMOR_TRIM_SMITHING_TEMPLATE, GREED_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.addAfter(GREED_ARMOR_TRIM_SMITHING_TEMPLATE, BEAST_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.addAfter(BEAST_ARMOR_TRIM_SMITHING_TEMPLATE, FEVER_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.addAfter(FEVER_ARMOR_TRIM_SMITHING_TEMPLATE, WRAITH_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.addAfter(WRAITH_ARMOR_TRIM_SMITHING_TEMPLATE, NIHILITY_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.addAfter(NIHILITY_ARMOR_TRIM_SMITHING_TEMPLATE, HORIZON_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.addAfter(HORIZON_ARMOR_TRIM_SMITHING_TEMPLATE, ORIGIN_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.addAfter(ORIGIN_ARMOR_TRIM_SMITHING_TEMPLATE, TWILIGHT_ARMOR_TRIM_SMITHING_TEMPLATE);
        entries.addAfter(TWILIGHT_ARMOR_TRIM_SMITHING_TEMPLATE, PARASITE_ARMOR_TRIM_SMITHING_TEMPLATE);

    }
}
