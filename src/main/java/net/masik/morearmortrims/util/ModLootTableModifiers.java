package net.masik.morearmortrims.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.masik.morearmortrims.MoreArmorTrims;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {

    /*private static final Identifier FISHING_LOOT_TABLE_ID = new Identifier("minecraft", "gameplay/fishing/treasure");
    private static final Identifier EVOKER_LOOT_TABLE_ID = new Identifier("minecraft", "gameplay/fishing/treasure");
    private static final Identifier RAVAGER_LOOT_TABLE_ID = new Identifier("minecraft", "gameplay/fishing/treasure");*/

    private static Identifier buildInjectionRoute(Identifier id) {
        return new Identifier(MoreArmorTrims.MOD_ID, "injections/" + id.getNamespace() + "/" + id.getPath());
    }

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, manager, id, supplier, setter) -> {
            LootTable table = manager.getLootTable(buildInjectionRoute(id));
            if (table != LootTable.EMPTY) {
                LootPool[] pools = table.pools;

                if (pools != null)
                    supplyPools(supplier, pools);
            }

        });
    }

    private static void supplyPools(LootTable.Builder supplier, LootPool[] pools) {
        for (LootPool pool: pools) {
            supplier.pool(pool);
        }
    }

    /*public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(FISHING_LOOT_TABLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(WeatherCheckLootCondition.create().thundering(true))
                        .conditionally(RandomChanceLootCondition.builder(0.6f))
                        .with(ItemEntry.builder(ModItems.STORM_ARMOR_TRIM_SMITHING_TEMPLATE));
                tableBuilder.pool(poolBuilder.build());
            }
            if(EVOKER_LOOT_TABLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(KilledByPlayerLootCondition.builder().build())
                        .with(ItemEntry.builder(ModItems.STORM_ARMOR_TRIM_SMITHING_TEMPLATE));
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }*/

}
