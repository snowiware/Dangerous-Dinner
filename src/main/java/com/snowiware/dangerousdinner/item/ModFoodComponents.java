package com.snowiware.dangerousdinner.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ModFoodComponents {
    public static final FoodProperties RAW_SPIDER_CHOP = new FoodProperties.Builder().nutrition(3).saturationMod(.2f).meat().effect(new MobEffectInstance(MobEffects.HUNGER, 400, 0),0.1f).build();
    public static final FoodProperties COOKED_SPIDER_CHOP = new FoodProperties.Builder().nutrition(6).saturationMod(0.65f).meat().build();
    public static final FoodProperties RAW_ZOMBIE_BEEF = new FoodProperties.Builder().nutrition(4).saturationMod(.2f).meat().effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0),0.4f).build();
    public static final FoodProperties COOKED_ZOMBIE_BEEF = new FoodProperties.Builder().nutrition(8).saturationMod(0.8f).meat().build();
    public static final FoodProperties RAW_GUARDIAN_FILET = new FoodProperties.Builder().nutrition(5).saturationMod(.4f).meat().build();
    public static final FoodProperties COOKED_GUARDIAN_FILET = new FoodProperties.Builder().nutrition(7).saturationMod(0.6f).meat().build();
    public static final FoodProperties RAW_ELDER_GUARDIAN_FILET = new FoodProperties.Builder().nutrition(7).saturationMod(.6f).effect(new MobEffectInstance(MobEffects.POISON, 300, 0),0.1f).meat().build();
    public static final FoodProperties COOKED_ELDER_GUARDIAN_FILET = new FoodProperties.Builder().nutrition(10).saturationMod(0.85f).meat().build();
    public static final FoodProperties RAW_SHULKER_OYSTER = new FoodProperties.Builder().nutrition(5).saturationMod(.25f).fast().meat().build();
    public static final FoodProperties COOKED_SHULKER_OYSTER = new FoodProperties.Builder().nutrition(5).saturationMod(0.3f).effect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0),1.0f).fast().meat().build();
    public static final FoodProperties SLIME_JELLY = new FoodProperties.Builder().nutrition(7).saturationMod(0.5f).alwaysEat().build();
    public static final FoodProperties MAGMA_JELLY = new FoodProperties.Builder().nutrition(7).saturationMod(0.5f).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0),1.0f).alwaysEat().build();
    public static final FoodProperties BLOOKIE = new FoodProperties.Builder().nutrition(3).saturationMod(0.2f).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 160, 0), 1.0f).build();
    public static final FoodProperties RAW_ILLAGER_DRUMSTICK = new FoodProperties.Builder().nutrition(4).saturationMod(.25f).meat().effect(new MobEffectInstance(MobEffects.BAD_OMEN, 12000, 0),0.1f).build();
    public static final FoodProperties COOKED_ILLAGER_DRUMSTICK = new FoodProperties.Builder().nutrition(8).saturationMod(0.8f).meat().build();
    public static final FoodProperties RAW_RAVAGER_BRISKET = new FoodProperties.Builder().nutrition(7).saturationMod(.7f).meat().build();
    public static final FoodProperties COOKED_RAVAGER_BRISKET = new FoodProperties.Builder().nutrition(10).saturationMod(0.85f).meat().build();
    public static final FoodProperties GHASTLY_TAKOYAKI = new FoodProperties.Builder().nutrition(3).saturationMod(0.3f).fast().meat().build();
    public static final FoodProperties RAW_HUSK_BEEF = new FoodProperties.Builder().nutrition(3).saturationMod(.2f).meat().effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0),0.6f).build();
    public static final FoodProperties COOKED_HUSK_BEEF = new FoodProperties.Builder().nutrition(7).saturationMod(0.63f).meat().build();
    public static final FoodProperties RAW_DROWNED_BEEF = new FoodProperties.Builder().nutrition(5).saturationMod(.32f).meat().effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0),0.2f).build();
    public static final FoodProperties COOKED_DROWNED_BEEF = new FoodProperties.Builder().nutrition(8).saturationMod(0.72f).effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0),1.0f).meat().build();
}
