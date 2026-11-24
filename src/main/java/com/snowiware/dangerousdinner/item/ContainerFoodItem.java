package com.snowiware.dangerousdinner.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ContainerFoodItem extends Item {
    private final Supplier<? extends ItemLike> containerItem;

    public ContainerFoodItem(Properties properties, Supplier<? extends ItemLike> containerItem) {
        super(properties);
        this.containerItem = containerItem;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        ItemStack resultStack = super.finishUsingItem(stack, level, livingEntity);

        if (livingEntity instanceof Player player && !player.getAbilities().instabuild) {
            ItemStack bowlStack = new ItemStack(this.containerItem.get());
            if (resultStack.isEmpty()) {
                return bowlStack;
            }
            if (!player.getInventory().add(bowlStack)) {
                player.drop(bowlStack, false);
            }
        }
        return resultStack;
    }
}
