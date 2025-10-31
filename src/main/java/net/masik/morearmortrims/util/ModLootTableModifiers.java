package net.masik.morearmortrims.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.masik.morearmortrims.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.*;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.*;
import net.minecraft.predicate.entity.*;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeKeys;

import java.util.*;

public class ModLootTableModifiers {

    public static void modifyLootTables() {

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {

            if (key == RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("blocks/spawner"))) {

                LootPool.Builder lootPool = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.NIHILITY_ARMOR_TRIM_SMITHING_TEMPLATE))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.createDimension(World.OVERWORLD)));

                tableBuilder.pool(lootPool);

            }

            if (key == RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("chests/abandoned_mineshaft"))) {

                LootPool.Builder lootPool = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.GREED_ARMOR_TRIM_SMITHING_TEMPLATE))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .conditionally(AnyOfLootCondition.builder(
                                LocationCheckLootCondition.builder(LocationPredicate.Builder.createBiome(registries.getWrapperOrThrow(RegistryKeys.BIOME).getOrThrow(BiomeKeys.BADLANDS))),
                                LocationCheckLootCondition.builder(LocationPredicate.Builder.createBiome(registries.getWrapperOrThrow(RegistryKeys.BIOME).getOrThrow(BiomeKeys.ERODED_BADLANDS))),
                                LocationCheckLootCondition.builder(LocationPredicate.Builder.createBiome(registries.getWrapperOrThrow(RegistryKeys.BIOME).getOrThrow(BiomeKeys.WOODED_BADLANDS)))
                        ));

                tableBuilder.pool(lootPool);

            }

            if (key == RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("chests/igloo_chest"))) {

                LootPool.Builder lootPool = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.BEAST_ARMOR_TRIM_SMITHING_TEMPLATE))
                        .conditionally(RandomChanceLootCondition.builder(0.5f));

                tableBuilder.pool(lootPool);

            }

            if (key == RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("chests/ruined_portal"))) {

                LootPool.Builder lootPool = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.FEVER_ARMOR_TRIM_SMITHING_TEMPLATE))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.createDimension(World.NETHER)));

                tableBuilder.pool(lootPool);

            }

            if (key == RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("entities/evoker"))) {

                LootPool.Builder lootPool = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.RAM_ARMOR_TRIM_SMITHING_TEMPLATE))
                        .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS,
                                EntityPredicate.Builder.create().vehicle(EntityPredicate.Builder.create().type(EntityType.RAVAGER))))
                        .conditionally(KilledByPlayerLootCondition.builder());

                tableBuilder.pool(lootPool);

            }

            if (key == RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("entities/ravager"))) {

                LootPool.Builder lootPool = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.RAM_ARMOR_TRIM_SMITHING_TEMPLATE))
                        .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS,
                                EntityPredicate.Builder.create().passenger(EntityPredicate.Builder.create().type(EntityType.EVOKER))))
                        .conditionally(KilledByPlayerLootCondition.builder());

                tableBuilder.pool(lootPool);

            }

            if (key == RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("entities/wither"))) {

                LootPool.Builder lootPool = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.WRAITH_ARMOR_TRIM_SMITHING_TEMPLATE))
                        .conditionally(KilledByPlayerLootCondition.builder())
                        .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder
                                .createBiome(registries.getWrapperOrThrow(RegistryKeys.BIOME).getOrThrow(BiomeKeys.SOUL_SAND_VALLEY))));

                tableBuilder.pool(lootPool);

            }

            if (key == RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("entities/endermite"))) {

                LootPool.Builder lootPool = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.PARASITE_ARMOR_TRIM_SMITHING_TEMPLATE))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .conditionally(DamageSourcePropertiesLootCondition.builder(DamageSourcePredicate.Builder.create().sourceEntity(EntityPredicate.Builder.create().type(EntityType.ENDERMAN))));

                tableBuilder.pool(lootPool);

            }

        });

        LootTableEvents.REPLACE.register((key, original, source, registries) -> {

            if (key == RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("archaeology/ocean_ruin_cold"))) {

                LootPool.Builder lootPool = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.HORIZON_ARMOR_TRIM_SMITHING_TEMPLATE));

                return mergePools(original, lootPool.build());

            }

            if (key == RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("gameplay/fishing/treasure"))) {

                LootPool.Builder lootPool = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.STORM_ARMOR_TRIM_SMITHING_TEMPLATE)
                                .weight(3)
                                .conditionally(WeatherCheckLootCondition.create().thundering(true)));

                return mergePools(original, lootPool.build());

            }

            if (key == RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("gameplay/sniffer_digging"))) {

                LootPool.Builder lootPool = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.ORIGIN_ARMOR_TRIM_SMITHING_TEMPLATE)
                                .conditionally(AnyOfLootCondition.builder(
                                        LocationCheckLootCondition.builder(LocationPredicate.Builder.createBiome(registries.getWrapperOrThrow(RegistryKeys.BIOME).getOrThrow(BiomeKeys.OLD_GROWTH_PINE_TAIGA))),
                                        LocationCheckLootCondition.builder(LocationPredicate.Builder.createBiome(registries.getWrapperOrThrow(RegistryKeys.BIOME).getOrThrow(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA)))
                                )));

                return mergePools(original, lootPool.build());

            }

            if (key == RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("gameplay/cat_morning_gift"))) {

                LootPool.Builder lootPool = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.TWILIGHT_ARMOR_TRIM_SMITHING_TEMPLATE)
                                .weight(8));

                return mergePools(original, lootPool.build());

            }

            return null;

        });

    }

    private static LootTable mergePools(LootTable original, LootPool lootPool) {

        LootPool pool = LootPool.builder().with(original.pools.get(0).entries).with(lootPool.entries).build();

        return LootTable.builder().pools(List.of(pool)).build();

    }

}
