package com.magistuarmory.misc;

import com.magistuarmory.item.ModItems;
import dev.architectury.registry.level.entity.trade.SimpleTrade;
import dev.architectury.registry.level.entity.trade.TradeRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ModMerchOffers
{
	public static VillagerTrades.ItemListing[] SHEPHERD_TRADES;
	public static VillagerTrades.ItemListing[] WANDERING_TRADER_TRADES;
	
	private static <T extends Item> ItemStack safeStack(RegistrySupplier<T> supplier)
	{
		if (supplier == null) return ItemStack.EMPTY;
		try {
			T item = supplier.get();
			return item == null ? ItemStack.EMPTY : new ItemStack(item);
		} catch (Throwable t) {
			return ItemStack.EMPTY;
		}
	}

	private static <T extends Item> void addTrade(List<VillagerTrades.ItemListing> collector, RegistrySupplier<T> supplier, int emeraldCost, int maxUses, int xp, int priceMultiplier)
	{
		ItemStack stack = safeStack(supplier);
		if (!stack.isEmpty()) {
			collector.add(new SimpleTrade(new ItemCost(Items.EMERALD, emeraldCost), Optional.empty(), stack, maxUses, xp, priceMultiplier));
		}
	}

	public static void setup()
	{
		List<VillagerTrades.ItemListing> shepherdTrades = new ArrayList<>();
		addTrade(shepherdTrades, ModItems.APOSTOLIC_CROSS_PATTERN, 1, 7, 0, 1);
		addTrade(shepherdTrades, ModItems.BOWL_PATTERN, 1, 7, 0, 1);
		addTrade(shepherdTrades, ModItems.BULL_PATTERN, 1, 7, 0, 1);
		addTrade(shepherdTrades, ModItems.CHESS_PATTERN, 1, 7, 0, 1);
		addTrade(shepherdTrades, ModItems.CRUSADER_CROSS_PATTERN, 1, 7, 0, 1);
		addTrade(shepherdTrades, ModItems.DRAGON_PATTERN, 1, 7, 0, 1);
		addTrade(shepherdTrades, ModItems.EAGLE_PATTERN, 1, 7, 0, 1);
		addTrade(shepherdTrades, ModItems.HORSE_PATTERN, 1, 7, 0, 1);
		addTrade(shepherdTrades, ModItems.LILY_PATTERN, 1, 7, 0, 1);
		addTrade(shepherdTrades, ModItems.LION1_PATTERN, 1, 7, 0, 1);
		addTrade(shepherdTrades, ModItems.LION2_PATTERN, 1, 7, 0, 1);
		addTrade(shepherdTrades, ModItems.ORTHODOX_CROSS_PATTERN, 1, 7, 0, 1);
		addTrade(shepherdTrades, ModItems.SNAKE_PATTERN, 1, 7, 0, 1);
		addTrade(shepherdTrades, ModItems.SUN_PATTERN, 1, 7, 0, 1);
		addTrade(shepherdTrades, ModItems.SWORDS_PATTERN, 1, 7, 0, 1);
		addTrade(shepherdTrades, ModItems.TOWER_PATTERN, 1, 7, 0, 1);
		addTrade(shepherdTrades, ModItems.TREE_PATTERN, 1, 7, 0, 1);
		addTrade(shepherdTrades, ModItems.TWOHEADED_EAGLE_PATTERN, 1, 7, 0, 1);
		SHEPHERD_TRADES = shepherdTrades.toArray(new VillagerTrades.ItemListing[0]);

		List<VillagerTrades.ItemListing> wanderingTrades = new ArrayList<>();
		addTrade(wanderingTrades, ModItems.GAZELLE_HORNS_DECORATION, 1, 5, 0, 1);
		addTrade(wanderingTrades, ModItems.DUCK_DECORATION, 1, 5, 0, 1);
		addTrade(wanderingTrades, ModItems.HORSE_DECORATION, 1, 5, 0, 1);
		addTrade(wanderingTrades, ModItems.CROWN_DECORATION, 10, 1, 0, 1);
		addTrade(wanderingTrades, ModItems.UNICORN_DECORATION, 1, 5, 0, 1);
		addTrade(wanderingTrades, ModItems.BULLHORNS_DECORATION, 1, 5, 0, 1);
		addTrade(wanderingTrades, ModItems.DRAGON_DECORATION, 1, 5, 0, 1);
		addTrade(wanderingTrades, ModItems.MINICROWN_DECORATION, 8, 1, 0, 1);
		addTrade(wanderingTrades, ModItems.ANTLERS_DECORATION, 1, 5, 0, 1);
		addTrade(wanderingTrades, ModItems.BEAR_DECORATION, 1, 5, 0, 1);
		addTrade(wanderingTrades, ModItems.LILY_DECORATION, 1, 5, 0, 1);
		addTrade(wanderingTrades, ModItems.LION_DECORATION, 1, 5, 0, 1);
		addTrade(wanderingTrades, ModItems.DEMON_HORNS_DECORATION, 1, 5, 0, 1);
		addTrade(wanderingTrades, ModItems.GRIFFIN_DECORATION, 1, 5, 0, 1);
		WANDERING_TRADER_TRADES = wanderingTrades.toArray(new VillagerTrades.ItemListing[0]);

		TradeRegistry.registerVillagerTrade(VillagerProfession.SHEPHERD, 1, ModMerchOffers.SHEPHERD_TRADES);
		TradeRegistry.registerTradeForWanderingTrader(false, ModMerchOffers.WANDERING_TRADER_TRADES);
	}
}
