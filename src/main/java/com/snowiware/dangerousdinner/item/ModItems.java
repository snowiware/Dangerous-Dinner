package com.snowiware.dangerousdinner.item;

import com.snowiware.dangerousdinner.DangerousDinner;
import com.snowiware.dangerousdinner.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;

import java.util.Arrays;

public class ModItems {
    // register items
    public static final Item BARE_SHULKER_OYSTER = register(new Item(new FabricItemSettings()),"shulker_oyster_shell");
    public static final Item GHAST_TENTACLE = register(new Item(new FabricItemSettings()),"ghast_tentacle");
    // foods
    public static final Item RAW_SPIDER_CHOP = register(new Item(new FabricItemSettings().food(ModFoodComponents.RAW_SPIDER_CHOP)),"raw_spider");
    public static final Item COOKED_SPIDER_CHOP = register(new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_SPIDER_CHOP)),"cooked_spider");
    public static final Item RAW_ZOMBIE_BEEF = register(new Item(new FabricItemSettings().food(ModFoodComponents.RAW_ZOMBIE_BEEF)),"raw_zombie");
    public static final Item COOKED_ZOMBIE_BEEF = register(new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_ZOMBIE_BEEF)),"cooked_zombie");
    public static final Item RAW_GUARDIAN_FILET = register(new Item(new FabricItemSettings().food(ModFoodComponents.RAW_GUARDIAN_FILET)),"raw_guardian");
    public static final Item COOKED_GUARDIAN_FILET = register(new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_GUARDIAN_FILET)),"cooked_guardian");
    public static final Item RAW_ELDER_GUARDIAN_FILET = register(new Item(new FabricItemSettings().food(ModFoodComponents.RAW_ELDER_GUARDIAN_FILET).rarity(Rarity.UNCOMMON)),"raw_elder_guardian");
    public static final Item COOKED_ELDER_GUARDIAN_FILET = register(new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_ELDER_GUARDIAN_FILET).rarity(Rarity.UNCOMMON)),"cooked_elder_guardian");
    public static final Item RAW_SHULKER_OYSTER = register(new ContainerFoodItem(new FabricItemSettings().craftRemainder(BARE_SHULKER_OYSTER).food(ModFoodComponents.RAW_SHULKER_OYSTER), () -> BARE_SHULKER_OYSTER),"raw_shulker");
    public static final Item COOKED_SHULKER_OYSTER = register(new ContainerFoodItem(new FabricItemSettings().craftRemainder(BARE_SHULKER_OYSTER).food(ModFoodComponents.COOKED_SHULKER_OYSTER), () -> BARE_SHULKER_OYSTER),"cooked_shulker");
    public static final Item SLIME_JELLY = register(new JellyFoodItem(new FabricItemSettings().food(ModFoodComponents.SLIME_JELLY).stacksTo(16)),"slime_jelly");
    public static final Item MAGMA_JELLY = register(new JellyFoodItem(new FabricItemSettings().food(ModFoodComponents.MAGMA_JELLY).stacksTo(16)),"magma_jelly");
    public static final Item BLOOKIE = register(new Item(new FabricItemSettings().food(ModFoodComponents.BLOOKIE)),"blookie");
    public static final Item RAW_ILLAGER_DRUMSTICK = register(new Item(new FabricItemSettings().food(ModFoodComponents.RAW_ILLAGER_DRUMSTICK)),"raw_illager");
    public static final Item COOKED_ILLAGER_DRUMSTICK = register(new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_ILLAGER_DRUMSTICK)),"cooked_illager");
    public static final Item RAW_RAVAGER_BRISKET = register(new Item(new FabricItemSettings().food(ModFoodComponents.RAW_RAVAGER_BRISKET).rarity(Rarity.UNCOMMON)),"raw_ravager");
    public static final Item COOKED_RAVAGER_BRISKET = register(new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_RAVAGER_BRISKET).rarity(Rarity.UNCOMMON)),"cooked_ravager");
    public static final Item GHASTLY_TAKOYAKI = register(new Item(new FabricItemSettings().food(ModFoodComponents.GHASTLY_TAKOYAKI)),"ghast_takoyaki");
    public static final Item RAW_HUSK_BEEF = register(new Item(new FabricItemSettings().food(ModFoodComponents.RAW_HUSK_BEEF)),"raw_husk");
    public static final Item COOKED_HUSK_BEEF = register(new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_HUSK_BEEF)),"cooked_husk");
    public static final Item RAW_DROWNED_BEEF = register(new Item(new FabricItemSettings().food(ModFoodComponents.RAW_DROWNED_BEEF)),"raw_drowned");
    public static final Item COOKED_DROWNED_BEEF = register(new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_DROWNED_BEEF)),"cooked_drowned");
    public static final Item RAW_WARDEN_RIBS = register(new Item(new FabricItemSettings().food(ModFoodComponents.RAW_WARDEN_RIBS)),"raw_warden");
    public static final Item COOKED_WARDEN_RIBS = register(new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_WARDEN_RIBS)),"cooked_warden");
    public static final Item SHULKER_STEW = register(new BowlFoodItem(new FabricItemSettings().food(ModFoodComponents.SHULKER_STEW).stacksTo(1)),"shulker_stew");


    // add to group (ingredients creative tab)
    public static void addModdedItemsToIngredients(FabricItemGroupEntries entries) {
        // oyster shell is not really food. goes after shulker shell
        entries.addAfter(Items.SHULKER_SHELL,BARE_SHULKER_OYSTER);

        // ghast ingredient
        entries.addAfter(Items.GHAST_TEAR,GHAST_TENTACLE);
    }

    // add to group (food creative tab)
    public static void addModdedItemsToFood(FabricItemGroupEntries entries) {
        // cake item goes after regular cake
        entries.addAfter(Items.CAKE, ModBlocks.DYNAMITE_CAKE);

        entries.addAfter(Items.RABBIT_STEW, SHULKER_STEW);

        // Meats (all go after spider eye)
        for (Item item : Arrays.asList(
                GHASTLY_TAKOYAKI,
                COOKED_SHULKER_OYSTER,
                RAW_SHULKER_OYSTER,
                COOKED_WARDEN_RIBS,
                RAW_WARDEN_RIBS,
                COOKED_RAVAGER_BRISKET,
                RAW_RAVAGER_BRISKET,
                COOKED_ILLAGER_DRUMSTICK,
                RAW_ILLAGER_DRUMSTICK,
                COOKED_ELDER_GUARDIAN_FILET,
                RAW_ELDER_GUARDIAN_FILET,
                COOKED_GUARDIAN_FILET,
                RAW_GUARDIAN_FILET,
                COOKED_SPIDER_CHOP,
                RAW_SPIDER_CHOP,
                COOKED_DROWNED_BEEF,
                RAW_DROWNED_BEEF,
                COOKED_HUSK_BEEF,
                RAW_HUSK_BEEF,
                COOKED_ZOMBIE_BEEF,
                RAW_ZOMBIE_BEEF)) {
            entries.addAfter(Items.SPIDER_EYE, item);
        }

        // jelly items go after honey
        entries.addAfter(Items.HONEY_BOTTLE,MAGMA_JELLY);
        entries.addAfter(Items.HONEY_BOTTLE,SLIME_JELLY);

        // cookie item goes after regular cookie
        entries.addAfter(Items.COOKIE, BLOOKIE);
    }

    public static void registerModItems() {
        DangerousDinner.LOGGER.info("Registering items for " + DangerousDinner.MOD_ID + ".");
    }

    public static Item register(Item item, String id) {
        ResourceLocation itemID = new ResourceLocation(DangerousDinner.MOD_ID, id);
        return Registry.register(BuiltInRegistries.ITEM, itemID, item);
    }
}