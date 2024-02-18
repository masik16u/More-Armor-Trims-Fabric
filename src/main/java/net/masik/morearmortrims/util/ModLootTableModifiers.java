package net.masik.morearmortrims.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.masik.morearmortrims.MoreArmorTrims;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModLootTableModifiers {

    private static Identifier buildInjectionRoute(Identifier id) {
        return new Identifier(MoreArmorTrims.MOD_ID, "injections/" + id.getNamespace() + "/" + id.getPath());
    }

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, manager, id, supplier, setter) -> {
            LootTable table = manager.getLootTable(buildInjectionRoute(id));
            if (table != LootTable.EMPTY) {
                List<LootPool> pools = table.pools;

                if (pools != null) {
                    supplyPools(supplier, pools);
                }
            }
        });
    }

    private static void supplyPools(LootTable.Builder supplier, List<LootPool> pools) {
        for (LootPool pool: pools) {
            supplier.pool(pool);
        }
    }
}