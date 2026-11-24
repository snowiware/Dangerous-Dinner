package com.snowiware.dangerousdinner.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ModFoodComponents {
    public static final FoodProperties RAW_SPIDER_CHOP = new FoodProperties.Builder().nutrition(3).saturationMod(.2f).meat().effect(new MobEffectInstance(MobEffects.HUNGER, 400, 0),0.1f).build();
    public static final FoodProperties COOKED_SPIDER_CHOP = new FoodProperties.Builder().nutrition(6).saturationMod(0.7f).meat().build();
    public static final FoodProperties RAW_ZOMBIE_BEEF = new FoodProperties.Builder().nutrition(4).saturationMod(.2f).meat().effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0),0.4f).build();
    public static final FoodProperties COOKED_ZOMBIE_BEEF = new FoodProperties.Builder().nutrition(8).saturationMod(0.9f).meat().build();
}
