package net.masik.morearmortrims.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.masik.morearmortrims.MoreArmorTrims;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.util.Identifier;
import org.apache.http.pool.PoolEntry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ModLootTableModifiers {

    private static Identifier buildAddInjectionRoute(Identifier id) {

        return new Identifier(MoreArmorTrims.MOD_ID, "injections/modify/" + id.getNamespace() + "/" + id.getPath());

    }

    private static Identifier buildReplaceInjectionRoute(Identifier id) {

        return new Identifier(MoreArmorTrims.MOD_ID, "injections/replace/" + id.getNamespace() + "/" + id.getPath());

    }

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, manager, id, supplier, setter) -> {

            LootTable table = manager.getLootTable(buildAddInjectionRoute(id));
            if (table != LootTable.EMPTY) {

                LootPool[] pools = table.pools;

                if (pools != null)

                    supplyPools(supplier, pools);

            }

        });

        LootTableEvents.REPLACE.register(((resourceManager, lootManager, id, original, source) -> {

            LootTable table = lootManager.getLootTable(buildReplaceInjectionRoute(id));
            if (table != LootTable.EMPTY) {
                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
                Collections.addAll(entries, table.pools[0].entries);

                LootPool.Builder pool = LootPool.builder().with(entries);
                return LootTable.builder().pool(pool).build();
            }

            return null;

        }));
    }

    private static void supplyPools(LootTable.Builder supplier, LootPool[] pools) {
        for (LootPool pool: pools) {
            supplier.pool(pool);
        }
    }

}
