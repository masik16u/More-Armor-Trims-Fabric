package net.masik.morearmortrims.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.masik.morearmortrims.MoreArmorTrims;
import net.minecraft.util.Identifier;
import net.ramixin.mixson.inline.Mixson;
import net.ramixin.mixson.util.MixsonUtil;

public class TrimFixer {

    public static void register() {
        Mixson.registerEvent(
                100,
                MixsonUtil.getLocatorFromString("minecraft:atlases/armor_trims"),
                "more_armor_trims:fix_missing_trim_materials",
                context -> {
                    JsonObject rootJson = context.getFile().getAsJsonObject();
                    JsonArray sources = rootJson.getAsJsonArray("sources");

                    for (JsonElement element : sources) {
                        JsonObject source = element.getAsJsonObject();
                        String type = source.get("type").getAsString();

                        if (type.equals("paletted_permutations") || type.equals("minecraft:paletted_permutations")) {
                            JsonObject permutations = source.getAsJsonObject("permutations");

                            // Check every registered trim material
                            MoreArmorTrims.TRIM_MATERIALS.forEach(key -> {
                                Identifier id = key.getValue();
                                String path = id.getPath();

                                if (!permutations.has(path)) {
                                    // Use the vanilla "iron" palette as a safe fallback
                                    permutations.addProperty(path,
                                            "minecraft:trims/color_palettes/iron");
                                }

                                System.out.println("[TrimFixer] Palette for: " + path + ".");
                            });
                            break;
                        }
                    }
                },
                false
        );
    }
}
