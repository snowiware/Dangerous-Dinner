package com.snowiware.dangerousdinner.block;

import com.snowiware.dangerousdinner.DangerousDinner;
import com.snowiware.dangerousdinner.block.food.DynamiteCake;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {
    public static final Block DYNAMITE_CAKE = registerBlock("dynamite_cake",
            new DynamiteCake(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN)
                    .forceSolidOn()
                    .strength(0.5f)
                    .sound(SoundType.WOOL)
                    .noOcclusion()),
            1);

    public static Block EGG_RETRO = null;

    public static void registerModBlocks(boolean eggs) {
        DangerousDinner.LOGGER.info("Registering blocks for " + DangerousDinner.MOD_ID + ".");

        // if easter eggs are enabled:
        if (eggs) {
            EGG_RETRO = new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.RED).sound(SoundType.AMETHYST).strength(4.0f));
            registerBlock("retro_block", EGG_RETRO);
        }
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block, 64);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(DangerousDinner.MOD_ID, name), block);
    }
    private static Block registerBlock(String name, Block block, int maxStack) {
        registerBlockItem(name, block, maxStack);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(DangerousDinner.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, int maxStack) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(DangerousDinner.MOD_ID, name),
                new BlockItem(block, new Item.Properties().stacksTo(maxStack)));
    }
}
