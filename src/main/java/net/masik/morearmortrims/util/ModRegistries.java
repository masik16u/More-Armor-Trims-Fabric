package net.masik.morearmortrims.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.masik.morearmortrims.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;

public class ModRegistries {

    public static void registerRegistries() {
        registerCustomWanderingTrades();
    }

    private static void registerCustomWanderingTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 15),
                    new ItemStack(ModItems.MYTH_ARMOR_TRIM_SMITHING_TEMPLATE, 1),
                    2, 0, 0));
        });
    }

}
