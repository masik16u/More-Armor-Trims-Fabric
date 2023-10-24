package net.masik.morearmortrims.item;

import net.masik.morearmortrims.MoreArmorTrims;
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

    private static SmithingTemplateItem registerItem(String name) {
        Identifier id = new Identifier(MoreArmorTrims.MOD_ID, name);
        return Registry.register(Registries.ITEM, id, SmithingTemplateItem.of(id));
    }

    public static void registerModItems() {
        MoreArmorTrims.LOGGER.info("Registering items for mod" + MoreArmorTrims.MOD_ID);
    }
}
