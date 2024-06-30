package net.masik.morearmortrims.util;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableProvider;
import net.fabricmc.fabric.api.loot.v2.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.fabricmc.fabric.impl.biome.modification.BuiltInRegistryKeys;
import net.fabricmc.fabric.mixin.loot.LootTableAccessor;
import net.masik.morearmortrims.MoreArmorTrims;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.loottable.LootTableGenerator;
import net.minecraft.data.server.loottable.LootTableProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.LootDataType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableReporter;
import net.minecraft.loot.condition.*;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.operator.BoundedIntUnaryOperator;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryInfo;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.BiomeSources;
import net.minecraft.world.dimension.DimensionTypes;
import net.minecraft.world.gen.structure.Structure;
import net.minecraft.world.gen.structure.StructureKeys;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class ModLootTableModifiers {

    private static Identifier buildAddInjectionRoute(Identifier id) {

        return Identifier.of(MoreArmorTrims.MOD_ID, "injections/modify/" + id.getNamespace() + "/" + id.getPath());

    }

    private static Identifier buildReplaceInjectionRoute(Identifier id) {

        return Identifier.of(MoreArmorTrims.MOD_ID, "injections/replace/" + id.getNamespace() + "/" + id.getPath());

    }

    private static final RegistryWrapper.WrapperLookup vanillaRegistries = BuiltinRegistries.createWrapperLookup();

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((id, builder, source) -> {

//            LootPool lootPool = LootPool.builder()
//                    .with(ItemEntry.builder(Items.FLINT))
//                    .conditionally(KilledByPlayerLootCondition.builder())
//                    .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.createDimension(World.OVERWORLD)))
//                    .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.createBiome((RegistryEntry<Biome>) RegistryCodecs.entryList(BiomeKeys.BADLANDS.getRegistryRef()))))
//                    .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().vehicle(EntityPredicate.Builder.create().type(EntityType.RAVAGER))))
//                    .conditionally(WeatherCheckLootCondition.create().thundering(true))
//                    .build();

            if (id == RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("entities/evoker"))) {

                var biomeImpl = BuiltinRegistries.createWrapperLookup().getWrapperOrThrow(RegistryKeys.BIOME);
                var predicate = LocationPredicate.Builder.createBiome(biomeImpl.getOrThrow(BiomeKeys.BADLANDS));

                LootPool.Builder lootPool = LootPool.builder()
                        .with(ItemEntry.builder(Items.FLINT))
                        .conditionally(KilledByPlayerLootCondition.builder())
                        .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.createDimension(World.OVERWORLD)))
//                        .conditionally(LocationCheckLootCondition.builder(predicate))
                        .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().vehicle(EntityPredicate.Builder.create().type(EntityType.RAVAGER))))
                        .conditionally(WeatherCheckLootCondition.create().thundering(true))
                        .conditionally(TimeCheckLootCondition.create(BoundedIntUnaryOperator.create(1000, 2000)).period(24000))
//                        .conditionally(TableBonusLootCondition.builder(BuiltinRegistries.createWrapperLookup().getWrapperOrThrow(RegistryKeys.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)))
//                        .conditionally(SurvivesExplosionLootCondition.builder())
                        .conditionally(RandomChanceWithEnchantedBonusLootCondition.builder(BuiltinRegistries.createWrapperLookup(), 1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.5f));
//                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Items.DIAMOND_AXE)))
//                        .conditionally(BlockStatePropertyLootCondition.builder(Blocks.STONE_BUTTON));

                builder.pool(lootPool);

            }

            if (Blocks.CAULDRON.getLootTableKey() == id) {



                RegistryWrapper.Impl<Biome> registry = vanillaRegistries.getWrapperOrThrow(RegistryKeys.BIOME);
                RegistryEntry<Biome> entry = registry.getOrThrow(BiomeKeys.DESERT);

                RegistryWrapper.Impl<Structure> registry2 = vanillaRegistries.getWrapperOrThrow(RegistryKeys.STRUCTURE);
                RegistryEntry<Structure> entry2 = registry2.getOrThrow(StructureKeys.VILLAGE_DESERT);

                LootPool.Builder lootPool = LootPool.builder()
                        .with(ItemEntry.builder(Items.FLINT))
//                        .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.createStructure(entry2)))
                        .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.createBiome(BuiltInRegistryKeys.biomeRegistryWrapper().getOrThrow(BiomeKeys.DESERT))));
//                        .conditionally(LocationCheckLootCondition.builder(LocationPredicate.Builder.createDimension(World.OVERWORLD)));

                builder.pool(lootPool);

                MoreArmorTrims.LOGGER.info(lootPool.build().conditions.toString());

            }

//            if (Blocks.CAULDRON.getLootTableKey() == id) {
//
//                LootPool.Builder lootPool = LootPool.builder()
//                        .with(ItemEntry.builder(Items.FLINT));
//
//                builder.pool(lootPool);
//
//            }

//            LootTable table = manager.getLootTable(buildAddInjectionRoute(id.getRegistry()));
//            if (table != LootTable.EMPTY) {
//
//                LootPool[] pools = table.pools;
//
//                supplyPools(builder, pools);
//
//            }

        });

//        LootTableEvents.REPLACE.register((id, original, source) -> {
//
//            LootTable table = lootManager.getLootTable(buildReplaceInjectionRoute(id));
//            if (table != LootTable.EMPTY) {
//                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
//                Collections.addAll(entries, table.pools[0].entries);
//
//                LootPool.Builder pool = LootPool.builder().with(entries);
//                return LootTable.builder().pool(pool).build();
//            }
//
//            return null;
//
//        });
    }

	public static void modify(
			MutableRegistry<LootTable> registry,
			RegistryEntryLookup.RegistryLookup lookup,
			RegistryEntryInfo info
	) {
		BiConsumer<RegistryKey<LootTable>, Function<LootTable.Builder, LootTable>> modifier = (RegistryKey<LootTable> key, Function<LootTable.Builder, LootTable> consumer) -> {
			LootTable table = registry.get(key);
			if (table == null || table == LootTable.EMPTY) return;
			LootTable.Builder builder = FabricLootTableBuilder.copyOf(table);
			LootTable modified = consumer.apply(builder);
			registry.add(key, modified, info);
		};

		// Sample
		modifier.accept(Blocks.CHEST.getLootTableKey(), (builder) -> {
			return builder.build();
		});
	}
}
