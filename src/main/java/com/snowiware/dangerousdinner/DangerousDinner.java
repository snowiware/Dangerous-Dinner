package com.snowiware.dangerousdinner;

import com.snowiware.dangerousdinner.block.ModBlocks;
import com.snowiware.dangerousdinner.config.ConfigManager;
import com.snowiware.dangerousdinner.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTabs;
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

	/// spiders
	private static final ResourceLocation SPIDER_LOOT = EntityType.SPIDER.getDefaultLootTable();
	private static final ResourceLocation CAVE_SPIDER_LOOT = EntityType.CAVE_SPIDER.getDefaultLootTable();

	/// zombies
	private static final ResourceLocation ZOMBIE_LOOT = EntityType.ZOMBIE.getDefaultLootTable();
	private static final ResourceLocation ZOMBIE_VILLAGER_LOOT = EntityType.ZOMBIE_VILLAGER.getDefaultLootTable();
	private static final ResourceLocation ZOMBIE_HORSE_LOOT = EntityType.ZOMBIE_HORSE.getDefaultLootTable();
	// husk (has its own steak)
	private static final ResourceLocation HUSK_LOOT = EntityType.HUSK.getDefaultLootTable();
	// drowned (has its own steak)
	private static final ResourceLocation DROWNED_LOOT = EntityType.DROWNED.getDefaultLootTable();

	/// guardians
	private static final ResourceLocation GUARDIAN_LOOT = EntityType.GUARDIAN.getDefaultLootTable();
	// elder guardian
	private static final ResourceLocation ELDER_GUARDIAN_LOOT = EntityType.ELDER_GUARDIAN.getDefaultLootTable();

	/// shulker
	private static final ResourceLocation SHULKER_LOOT = EntityType.SHULKER.getDefaultLootTable();

	/// illagers
	private static final ResourceLocation PILLAGER_LOOT = EntityType.PILLAGER.getDefaultLootTable();
	private static final ResourceLocation EVOKER_LOOT = EntityType.EVOKER.getDefaultLootTable();
	private static final ResourceLocation VINDICATOR_LOOT = EntityType.VINDICATOR.getDefaultLootTable();
	private static final ResourceLocation ILLUSIONER_LOOT = EntityType.ILLUSIONER.getDefaultLootTable();
	// ravager (has its own food)
	private static final ResourceLocation RAVAGER_LOOT = EntityType.RAVAGER.getDefaultLootTable();

	/// ghast
	private static final ResourceLocation GHAST_LOOT = EntityType.GHAST.getDefaultLootTable();

	/// warden
	private static final ResourceLocation WARDEN_LOOT = EntityType.WARDEN.getDefaultLootTable();
	@Override
	public void onInitialize() {
		// Register items
		ModItems.registerModItems();
		ModBlocks.registerModBlocks(ConfigManager.load().enableEasterEggs);
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(ModItems::addModdedItemsToFood);

		// Oyster compost (fun fact. crushed oyster shells can be used in your real life compost for calcium)
		CompostingChanceRegistry.INSTANCE.add(ModItems.BARE_SHULKER_OYSTER,0.99f);

		// Add to loot tables
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			// Spider meat
			if (source.isBuiltin() && SPIDER_LOOT.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.when(LootItemRandomChanceCondition.randomChance(0.75f))
						.add(LootItem.lootTableItem(ModItems.RAW_SPIDER_CHOP)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 2.0f))));

				tableBuilder.pool(poolBuilder.build());
			}
			if (source.isBuiltin() && CAVE_SPIDER_LOOT.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.when(LootItemRandomChanceCondition.randomChance(0.5f))
						.add(LootItem.lootTableItem(ModItems.RAW_SPIDER_CHOP)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f))));

				tableBuilder.pool(poolBuilder.build());
			}
			// Zombie meat
			if (source.isBuiltin() && ZOMBIE_LOOT.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.when(LootItemRandomChanceCondition.randomChance(0.5f))
						.add(LootItem.lootTableItem(ModItems.RAW_ZOMBIE_BEEF)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f))));

				tableBuilder.pool(poolBuilder.build());
			}
			if (source.isBuiltin() && ZOMBIE_VILLAGER_LOOT.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.when(LootItemRandomChanceCondition.randomChance(0.35dxf))
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
			// husk
			if (source.isBuiltin() && HUSK_LOOT.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.when(LootItemRandomChanceCondition.randomChance(0.5f))
						.add(LootItem.lootTableItem(ModItems.RAW_HUSK_BEEF)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f))));

				tableBuilder.pool(poolBuilder.build());
			}
			// drowned
			if (source.isBuiltin() && DROWNED_LOOT.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.when(LootItemRandomChanceCondition.randomChance(0.5f))
						.add(LootItem.lootTableItem(ModItems.RAW_DROWNED_BEEF)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f))));

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
			// Shulker oyster
			if (source.isBuiltin() && SHULKER_LOOT.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.when(LootItemRandomChanceCondition.randomChance(0.5f))
						.add(LootItem.lootTableItem(ModItems.RAW_SHULKER_OYSTER)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 1.0f))));

				tableBuilder.pool(poolBuilder.build());
			}
			// Illager drumstick (same loot table, so they are stacked with OR)
			if (source.isBuiltin() && (PILLAGER_LOOT.equals(id) || EVOKER_LOOT.equals(id) || ILLUSIONER_LOOT.equals(id) || VINDICATOR_LOOT.equals(id))) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.when(LootItemRandomChanceCondition.randomChance(0.8f))
						.add(LootItem.lootTableItem(ModItems.RAW_ILLAGER_DRUMSTICK)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f))));

				tableBuilder.pool(poolBuilder.build());
			}
			// ravager
			if (source.isBuiltin() && RAVAGER_LOOT.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.add(LootItem.lootTableItem(ModItems.RAW_RAVAGER_BRISKET)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f))));
				LootPool.Builder poolBuilderExtra = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.when(LootItemRandomChanceCondition.randomChance(0.5f))
						.add(LootItem.lootTableItem(ModItems.RAW_RAVAGER_BRISKET)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f))));

				tableBuilder.pool(poolBuilder.build());
				tableBuilder.pool(poolBuilderExtra.build());
			}
			// ghast (they have 9 tentacles so up to 9 on a very rare drop)
			if (source.isBuiltin() && GHAST_LOOT.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.add(LootItem.lootTableItem(ModItems.GHAST_TENTACLE)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))));
				LootPool.Builder poolBuilderExtra = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.when(LootItemRandomChanceCondition.randomChance(0.5f))
						.add(LootItem.lootTableItem(ModItems.GHAST_TENTACLE)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))));
				LootPool.Builder poolBuilderRare = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.when(LootItemRandomChanceCondition.randomChance(0.05f))
						.add(LootItem.lootTableItem(ModItems.GHAST_TENTACLE)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))));


				tableBuilder.pool(poolBuilder.build());
				tableBuilder.pool(poolBuilderExtra.build());
				tableBuilder.pool(poolBuilderRare.build());
			}
			// warden
			if (source.isBuiltin() && WARDEN_LOOT.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.add(LootItem.lootTableItem(ModItems.RAW_WARDEN_RIBS)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))));
				LootPool.Builder poolBuilderExtra = LootPool.lootPool()
						.setRolls(ConstantValue.exactly(1))
						.when(LootItemRandomChanceCondition.randomChance(0.5f))
						.add(LootItem.lootTableItem(ModItems.RAW_WARDEN_RIBS)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f))));

				tableBuilder.pool(poolBuilder.build());
				tableBuilder.pool(poolBuilderExtra.build());
			}
		});

	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
}
