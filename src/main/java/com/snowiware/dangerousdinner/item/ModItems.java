package com.snowiware.dangerousdinner.item;

import com.snowiware.dangerousdinner.DangerousDinner;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModItems {
    // register items
    public static final Item RAW_SPIDER_CHOP = register(new Item(new FabricItemSettings().food(ModFoodComponents.RAW_SPIDER_CHOP)),"raw_spider");
    public static final Item COOKED_SPIDER_CHOP = register(new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_SPIDER_CHOP)),"cooked_spider");
    public static final Item RAW_ZOMBIE_BEEF = register(new Item(new FabricItemSettings().food(ModFoodComponents.RAW_ZOMBIE_BEEF)),"raw_zombie");
    public static final Item COOKED_ZOMBIE_BEEF = register(new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_ZOMBIE_BEEF)),"cooked_zombie");

    // add to group (food creative tab)
    public static void addModdedItemsToFood(FabricItemGroupEntries entries) {
        entries.addAfter(Items.SPIDER_EYE,COOKED_ZOMBIE_BEEF);
        entries.addAfter(Items.SPIDER_EYE,RAW_ZOMBIE_BEEF);
        entries.addAfter(Items.SPIDER_EYE,COOKED_SPIDER_CHOP);
        entries.addAfter(Items.SPIDER_EYE,RAW_SPIDER_CHOP);
    }

    public static void registerModItems() {
        DangerousDinner.LOGGER.info("Registering items for " + DangerousDinner.MOD_ID + ".");
    }

    public static Item register(Item item, String id) {
        ResourceLocation itemID = new ResourceLocation(DangerousDinner.MOD_ID, id);
        return Registry.register(BuiltInRegistries.ITEM, itemID, item);
    }
}