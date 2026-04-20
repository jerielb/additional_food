package com.jerielb.additional_food.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodComponents {
	// Meals -> same as GOLDEN_CARROT
	public static final FoodProperties CHICKEN_JOY = new FoodProperties.Builder().nutrition(6).saturationModifier(1.2F).build();
	public static final FoodProperties JOLLY_SPAGHETTI = new FoodProperties.Builder().nutrition(6).saturationModifier(1.2F).build();
	public static final FoodProperties PALABOK = new FoodProperties.Builder().nutrition(6).saturationModifier(1.2F).build();
	public static final FoodProperties BURGER_STEAK = new FoodProperties.Builder().nutrition(6).saturationModifier(1.2F).build();
	
	// Burgers -> same as COOKED_BEEF/COOKED_PORKCHOP
	public static final FoodProperties YUM_BURGER = new FoodProperties.Builder().nutrition(8).saturationModifier(0.8F).build();
	public static final FoodProperties CHAMP_BURGER = new FoodProperties.Builder().nutrition(8).saturationModifier(0.8F).build();
	public static final FoodProperties JOLLY_HOTDOG = new FoodProperties.Builder().nutrition(8).saturationModifier(0.8F).build();
	
	// Sides -> same as BAKED_POTATO
	public static final FoodProperties FRIES = new FoodProperties.Builder().nutrition(5).saturationModifier(0.6F).build();
	public static final FoodProperties CHICKEN_NUGGETS = new FoodProperties.Builder().nutrition(5).saturationModifier(0.6F).build();
	
	// Deserts -> same as PUMPKIN_PIE
	public static final FoodProperties PEACH_MANGO_PIE = new FoodProperties.Builder().nutrition(8).saturationModifier(0.3F).build();
	
	// Street Food -> same as CHORUS_FRUIT (without effects)
	public static final FoodProperties FISH_BALL = new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build();
}
