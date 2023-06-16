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

    public static final List<Identifier> armorTrimEmptyBaseSlotTextures = List.of(
            new Identifier("item/empty_armor_slot_helmet"), new Identifier("item/empty_armor_slot_chestplate"),
            new Identifier("item/empty_armor_slot_leggings"), new Identifier("item/empty_armor_slot_boots"));
    public static final List<Identifier> armorTrimEmptyAdditionsSlotTextures = List.of(
            new Identifier("item/empty_slot_ingot"), new Identifier("item/empty_slot_redstone_dust"),
            new Identifier("item/empty_slot_quartz"), new Identifier("item/empty_slot_emerald"),
            new Identifier("item/empty_slot_diamond"), new Identifier("item/empty_slot_lapis_lazuli"),
            new Identifier("item/empty_slot_amethyst_shard"));
    public static final Text APPLIES_TO = Text.translatable("item.minecraft.smithing_template.armor_trim.applies_to").formatted(Formatting.BLUE);
    public static final Text INGREDIENTS = Text.translatable("item.minecraft.smithing_template.armor_trim.ingredients").formatted(Formatting.BLUE);
    public static final Text BASE_SLOT_DESC = Text.translatable("item.minecraft.smithing_template.armor_trim.base_slot_description");
    public static final Text ADDITIONS_SLOT_DESC = Text.translatable("item.minecraft.smithing_template.armor_trim.additions_slot_description");
    public static final Formatting DESC_FORMATTING = Formatting.GRAY;


    public static final SmithingTemplateItem STORM_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("storm_armor_trim_smithing_template",
            new SmithingTemplateItem(APPLIES_TO, INGREDIENTS, Text.translatable("trim_pattern.more_armor_trims.storm").formatted(DESC_FORMATTING),
                    BASE_SLOT_DESC, ADDITIONS_SLOT_DESC, armorTrimEmptyBaseSlotTextures, armorTrimEmptyAdditionsSlotTextures));

    public static final SmithingTemplateItem RAM_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("ram_armor_trim_smithing_template",
            new SmithingTemplateItem(APPLIES_TO, INGREDIENTS, Text.translatable("trim_pattern.more_armor_trims.ram").formatted(DESC_FORMATTING),
                    BASE_SLOT_DESC, ADDITIONS_SLOT_DESC, armorTrimEmptyBaseSlotTextures, armorTrimEmptyAdditionsSlotTextures));

    public static final SmithingTemplateItem MYTH_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("myth_armor_trim_smithing_template",
            new SmithingTemplateItem(APPLIES_TO, INGREDIENTS, Text.translatable("trim_pattern.more_armor_trims.myth").formatted(DESC_FORMATTING),
                    BASE_SLOT_DESC, ADDITIONS_SLOT_DESC, armorTrimEmptyBaseSlotTextures, armorTrimEmptyAdditionsSlotTextures));


    private static SmithingTemplateItem registerItem(String name, SmithingTemplateItem item) {
        return Registry.register(Registries.ITEM, new Identifier(MoreArmorTrims.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MoreArmorTrims.LOGGER.info("Registering items for mod" + MoreArmorTrims.MOD_ID);
    }

}
