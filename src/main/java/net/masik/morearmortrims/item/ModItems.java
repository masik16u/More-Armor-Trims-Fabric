package net.masik.morearmortrims.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.masik.morearmortrims.MoreArmorTrims;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems {

    public static final SmithingTemplateItem STORM_ARMOR_TRIM_SMITHING_TEMPLATE = registerSmithingTemplateItem("storm_armor_trim_smithing_template", settings -> SmithingTemplateItem.of(settings.rarity(Rarity.EPIC)));
    public static final SmithingTemplateItem RAM_ARMOR_TRIM_SMITHING_TEMPLATE = registerSmithingTemplateItem("ram_armor_trim_smithing_template", settings -> SmithingTemplateItem.of(settings.rarity(Rarity.RARE)));
    public static final SmithingTemplateItem MYTH_ARMOR_TRIM_SMITHING_TEMPLATE = registerSmithingTemplateItem("myth_armor_trim_smithing_template", settings -> SmithingTemplateItem.of(settings.rarity(Rarity.RARE)));
    public static final SmithingTemplateItem GREED_ARMOR_TRIM_SMITHING_TEMPLATE = registerSmithingTemplateItem("greed_armor_trim_smithing_template", settings -> SmithingTemplateItem.of(settings.rarity(Rarity.UNCOMMON)));
    public static final SmithingTemplateItem BEAST_ARMOR_TRIM_SMITHING_TEMPLATE = registerSmithingTemplateItem("beast_armor_trim_smithing_template", settings -> SmithingTemplateItem.of(settings.rarity(Rarity.UNCOMMON)));
    public static final SmithingTemplateItem FEVER_ARMOR_TRIM_SMITHING_TEMPLATE = registerSmithingTemplateItem("fever_armor_trim_smithing_template", settings -> SmithingTemplateItem.of(settings.rarity(Rarity.UNCOMMON)));
    public static final SmithingTemplateItem WRAITH_ARMOR_TRIM_SMITHING_TEMPLATE = registerSmithingTemplateItem("wraith_armor_trim_smithing_template", settings -> SmithingTemplateItem.of(settings.rarity(Rarity.EPIC)));
    public static final SmithingTemplateItem NIHILITY_ARMOR_TRIM_SMITHING_TEMPLATE = registerSmithingTemplateItem("nihility_armor_trim_smithing_template", settings -> SmithingTemplateItem.of(settings.rarity(Rarity.RARE)));
    public static final SmithingTemplateItem HORIZON_ARMOR_TRIM_SMITHING_TEMPLATE = registerSmithingTemplateItem("horizon_armor_trim_smithing_template", settings -> SmithingTemplateItem.of(settings.rarity(Rarity.UNCOMMON)));
    public static final SmithingTemplateItem ORIGIN_ARMOR_TRIM_SMITHING_TEMPLATE = registerSmithingTemplateItem("origin_armor_trim_smithing_template", settings -> SmithingTemplateItem.of(settings.rarity(Rarity.RARE)));
    public static final SmithingTemplateItem TWILIGHT_ARMOR_TRIM_SMITHING_TEMPLATE = registerSmithingTemplateItem("twilight_armor_trim_smithing_template", settings -> SmithingTemplateItem.of(settings.rarity(Rarity.RARE)));
    public static final SmithingTemplateItem PARASITE_ARMOR_TRIM_SMITHING_TEMPLATE = registerSmithingTemplateItem("parasite_armor_trim_smithing_template", settings -> SmithingTemplateItem.of(settings.rarity(Rarity.RARE)));
    public static final SmithingTemplateItem WITNESS_ARMOR_TRIM_SMITHING_TEMPLATE = registerSmithingTemplateItem("witness_armor_trim_smithing_template", settings -> SmithingTemplateItem.of(settings.rarity(Rarity.RARE)));

    private static SmithingTemplateItem registerSmithingTemplateItem(String name, Function<Item.Settings, SmithingTemplateItem> function) {
        Identifier id = Identifier.of(MoreArmorTrims.MOD_ID, name);
        return Registry.register(Registries.ITEM, id,
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM,
                        Identifier.of(MoreArmorTrims.MOD_ID, name)))));
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsTabGroup);
    }


    private static void addItemsToIngredientsTabGroup(FabricItemGroupEntries entries) {

        entries.addAfter(Items.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE, STORM_ARMOR_TRIM_SMITHING_TEMPLATE);
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
        entries.addAfter(PARASITE_ARMOR_TRIM_SMITHING_TEMPLATE, WITNESS_ARMOR_TRIM_SMITHING_TEMPLATE);

    }

}
