package com.snowiware.dangerousdinner.block.food;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class DynamiteCake extends CakeBlock {
    public DynamiteCake(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            if (eat(level, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
            if (player.getItemInHand(hand).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }
        return eat(level, pos, state, player);
    }

    protected static InteractionResult eat(Level level, BlockPos pos, BlockState state, Player player) {
        ItemStack mainItem = player.getMainHandItem();
        if ((mainItem.is(Items.FLINT_AND_STEEL) || mainItem.is(Items.FIRE_CHARGE)) && (!level.isClientSide() && !player.isCreative())) {
            if (mainItem.is(Items.FLINT_AND_STEEL)) {
                mainItem.hurtAndBreak(1,player,(entity) -> {
                    entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
                });
            } else {
                mainItem.grow(-1);
            }
            level.explode(null,pos.getX(),pos.getY(),pos.getZ(),4.0f, Level.ExplosionInteraction.TNT);
            return InteractionResult.SUCCESS;
        }

        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        }
        player.awardStat(Stats.EAT_CAKE_SLICE);
        // Customize nutrition (hunger) and saturationModifier here
        player.getFoodData().eat(3, 0.2f);

        int bites = state.getValue(BITES);
        level.gameEvent(player, GameEvent.EAT, pos);
        if (bites < 6) {
            level.setBlock(pos, state.setValue(BITES, bites + 1), Block.UPDATE_ALL);
        } else {
            level.removeBlock(pos, false);
            level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
        }
        return InteractionResult.SUCCESS;
    }
}
