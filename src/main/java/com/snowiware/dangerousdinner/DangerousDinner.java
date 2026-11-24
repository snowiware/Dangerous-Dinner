package com.snowiware.dangerousdinner;

import com.snowiware.dangerousdinner.block.ModBlocks;
import com.snowiware.dangerousdinner.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DangerousDinner implements ModInitializer {
	public static final String MOD_ID = "dangerous_dinner";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// get loot to modify
	private static final ResourceLocation SPIDER_LOOT = EntityType.SPIDER.getDefaultLootTable();
	private static final ResourceLocation CAVE_SPIDER_LOOT = EntityType.CAVE_SPIDER.getDefaultLootTable();
	private static final ResourceLocation ZOMBIE_LOOT = EntityType.ZOMBIE.getDefaultLootTable();
	private static final ResourceLocation ZOMBIE_VILLAGER_LOOT = EntityType.ZOMBIE_VILLAGER.getDefaultLootTable();
	private static final ResourceLocation ZOMBIE_HORSE_LOOT = EntityType.ZOMBIE_HORSE.getDefaultLootTable();
	private static final ResourceLocation GUARDIAN_LOOT = EntityType.GUARDIAN.getDefaultLootTable();
	private static final ResourceLocation ELDER_GUARDIAN_LOOT = EntityType.ELDER_GUARDIAN.getDefaultLootTable();


	@Override
	public void onInitialize() {
		// Register items
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(ModItems::addModdedItemsToFood);

		// Add to loot tables
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			// Spider meat
			if (source.isBuiltin() && SPIDER_LOOT.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.add(LootItem.lootTableItem(ModItems.RAW_SPIDER_CHOP)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 3.0f))));

				tableBuilder.pool(poolBuilder.build());
			}
			if (source.isBuiltin() && CAVE_SPIDER_LOOT.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.when(LootItemRandomChanceCondition.randomChance(0.75f))
						.add(LootItem.lootTableItem(ModItems.RAW_SPIDER_CHOP)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f))));

				tableBuilder.pool(poolBuilder.build());
			}
			// Zombie meat
			if (source.isBuiltin() && ZOMBIE_LOOT.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.when(LootItemRandomChanceCondition.randomChance(0.75f))
						.add(LootItem.lootTableItem(ModItems.RAW_ZOMBIE_BEEF)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f))));

				tableBuilder.pool(poolBuilder.build());
			}
			if (source.isBuiltin() && ZOMBIE_VILLAGER_LOOT.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.when(LootItemRandomChanceCondition.randomChance(0.5f))
						.add(LootItem.lootTableItem(ModItems.RAW_ZOMBIE_BEEF)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f))));

				tableBuilder.pool(poolBuilder.build());
			}
			if (source.isBuiltin() && ZOMBIE_HORSE_LOOT.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.add(LootItem.lootTableItem(ModItems.RAW_ZOMBIE_BEEF)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f))));

				tableBuilder.pool(poolBuilder.build());
			}
			// Guardian meat
			if (source.isBuiltin() && GUARDIAN_LOOT.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.add(LootItem.lootTableItem(ModItems.RAW_GUARDIAN_FILET)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f))));

				tableBuilder.pool(poolBuilder.build());
			}
			// Elder guardian meat
			if (source.isBuiltin() && ELDER_GUARDIAN_LOOT.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.add(LootItem.lootTableItem(ModItems.RAW_ELDER_GUARDIAN_FILET)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))));

				tableBuilder.pool(poolBuilder.build());
			}
		});

	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
}
