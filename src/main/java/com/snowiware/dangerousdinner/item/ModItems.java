package com.snowiware.dangerousdinner.item;

import com.snowiware.dangerousdinner.DangerousDinner;
import com.snowiware.dangerousdinner.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;

public class ModItems {
    // register items
    public static final Item BARE_SHULKER_OYSTER = register(new Item(new FabricItemSettings()),"shulker_oyster_shell");
    // foods
    public static final Item RAW_SPIDER_CHOP = register(new Item(new FabricItemSettings().food(ModFoodComponents.RAW_SPIDER_CHOP)),"raw_spider");
    public static final Item COOKED_SPIDER_CHOP = register(new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_SPIDER_CHOP)),"cooked_spider");
    public static final Item RAW_ZOMBIE_BEEF = register(new Item(new FabricItemSettings().food(ModFoodComponents.RAW_ZOMBIE_BEEF)),"raw_zombie");
    public static final Item COOKED_ZOMBIE_BEEF = register(new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_ZOMBIE_BEEF)),"cooked_zombie");
    public static final Item RAW_GUARDIAN_FILET = register(new Item(new FabricItemSettings().food(ModFoodComponents.RAW_GUARDIAN_FILET)),"raw_guardian");
    public static final Item COOKED_GUARDIAN_FILET = register(new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_GUARDIAN_FILET)),"cooked_guardian");
    public static final Item RAW_ELDER_GUARDIAN_FILET = register(new Item(new FabricItemSettings().food(ModFoodComponents.RAW_ELDER_GUARDIAN_FILET).rarity(Rarity.UNCOMMON)),"raw_elder_guardian");
    public static final Item COOKED_ELDER_GUARDIAN_FILET = register(new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_ELDER_GUARDIAN_FILET).rarity(Rarity.UNCOMMON)),"cooked_elder_guardian");
    public static final Item RAW_SHULKER_OYSTER = register(new ContainerFoodItem(new FabricItemSettings().food(ModFoodComponents.RAW_SHULKER_OYSTER), () -> BARE_SHULKER_OYSTER),"raw_shulker");
    public static final Item COOKED_SHULKER_OYSTER = register(new ContainerFoodItem(new FabricItemSettings().food(ModFoodComponents.COOKED_SHULKER_OYSTER), () -> BARE_SHULKER_OYSTER),"cooked_shulker");
    public static final Item SLIME_JELLY = register(new JellyFoodItem(new FabricItemSettings().food(ModFoodComponents.SLIME_JELLY).stacksTo(16)),"slime_jelly");
    public static final Item MAGMA_JELLY = register(new JellyFoodItem(new FabricItemSettings().food(ModFoodComponents.MAGMA_JELLY).stacksTo(16)),"magma_jelly");


    // add to group (food creative tab)
    public static void addModdedItemsToFood(FabricItemGroupEntries entries) {
        entries.addAfter(Items.SHULKER_SHELL,BARE_SHULKER_OYSTER);

        entries.addAfter(Items.CAKE, ModBlocks.DYNAMITE_CAKE);

        entries.addAfter(Items.SPIDER_EYE,COOKED_SHULKER_OYSTER);
        entries.addAfter(Items.SPIDER_EYE,RAW_SHULKER_OYSTER);
        entries.addAfter(Items.SPIDER_EYE,COOKED_ELDER_GUARDIAN_FILET);
        entries.addAfter(Items.SPIDER_EYE,RAW_ELDER_GUARDIAN_FILET);
        entries.addAfter(Items.SPIDER_EYE,COOKED_GUARDIAN_FILET);
        entries.addAfter(Items.SPIDER_EYE,RAW_GUARDIAN_FILET);
        entries.addAfter(Items.SPIDER_EYE,COOKED_SPIDER_CHOP);
        entries.addAfter(Items.SPIDER_EYE,RAW_SPIDER_CHOP);
        entries.addAfter(Items.SPIDER_EYE,COOKED_ZOMBIE_BEEF);
        entries.addAfter(Items.SPIDER_EYE,RAW_ZOMBIE_BEEF);

        entries.addAfter(Items.HONEY_BOTTLE,MAGMA_JELLY);
        entries.addAfter(Items.HONEY_BOTTLE,SLIME_JELLY);
    }

    public static void registerModItems() {
        DangerousDinner.LOGGER.info("Registering items for " + DangerousDinner.MOD_ID + ".");
    }

    public static Item register(Item item, String id) {
        ResourceLocation itemID = new ResourceLocation(DangerousDinner.MOD_ID, id);
        return Registry.register(BuiltInRegistries.ITEM, itemID, item);
    }
}