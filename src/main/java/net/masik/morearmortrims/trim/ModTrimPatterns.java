package net.masik.morearmortrims.trim;

import net.masik.morearmortrims.MoreArmorTrims;
import net.minecraft.item.equipment.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModTrimPatterns {

    public static final RegistryKey<ArmorTrimPattern> STORM = of("storm");
    public static final RegistryKey<ArmorTrimPattern> RAM = of("ram");
    public static final RegistryKey<ArmorTrimPattern> MYTH = of("myth");
    public static final RegistryKey<ArmorTrimPattern> GREED = of("greed");
    public static final RegistryKey<ArmorTrimPattern> BEAST = of("beast");
    public static final RegistryKey<ArmorTrimPattern> FEVER = of("fever");
    public static final RegistryKey<ArmorTrimPattern> WRAITH = of("wraith");
    public static final RegistryKey<ArmorTrimPattern> NIHILITY = of("nihility");
    public static final RegistryKey<ArmorTrimPattern> HORIZON = of("horizon");
    public static final RegistryKey<ArmorTrimPattern> ORIGIN = of("origin");
    public static final RegistryKey<ArmorTrimPattern> TWILIGHT = of("twilight");
    public static final RegistryKey<ArmorTrimPattern> PARASITE = of("parasite");
    public static final RegistryKey<ArmorTrimPattern> WITNESS = of("witness");

    public static void bootstrap(Registerable<ArmorTrimPattern> registry) {
        register(registry, STORM);
        register(registry, RAM);
        register(registry, MYTH);
        register(registry, GREED);
        register(registry, BEAST);
        register(registry, FEVER);
        register(registry, WRAITH);
        register(registry, NIHILITY);
        register(registry, HORIZON);
        register(registry, ORIGIN);
        register(registry, TWILIGHT);
        register(registry, PARASITE);
        register(registry, WITNESS);
    }

    private static void register(Registerable<ArmorTrimPattern> registry, RegistryKey<ArmorTrimPattern> key) {
        ArmorTrimPattern armorTrimPattern = new ArmorTrimPattern(key.getValue(),
                Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())), false);

        registry.register(key, armorTrimPattern);
    }

    private static RegistryKey<ArmorTrimPattern> of(String id) {
        return RegistryKey.of(RegistryKeys.TRIM_PATTERN, Identifier.of(MoreArmorTrims.MOD_ID, id));
    }

}
