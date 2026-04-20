package com.jerielb.additional_food.item;

import com.jerielb.additional_food.AdditionalFood;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {
	// Jollibee Meals
	public static final Item CHICKEN_JOY = registerItem(
			"chicken_joy",
			Item::new,
			new Item.Properties().food(ModFoodComponents.CHICKEN_JOY)
	);
	public static final Item JOLLY_SPAGHETTI = registerItem(
			"jolly_spaghetti",
			Item::new, 
			new Item.Properties().food(ModFoodComponents.JOLLY_SPAGHETTI)
	);
	public static final Item PALABOK = registerItem(
			"palabok",
			Item::new, 
			new Item.Properties().food(ModFoodComponents.PALABOK)
	);
	public static final Item BURGER_STEAK = registerItem(
			"burger_steak",
			Item::new, 
			new Item.Properties().food(ModFoodComponents.BURGER_STEAK)
	);
	
	// Jollibee Burgers
	public static final Item YUM_BURGER = registerItem(
			"yum_burger",
			Item::new, 
			new Item.Properties().food(ModFoodComponents.YUM_BURGER)
	);
	public static final Item CHAMP_BURGER = registerItem(
			"champ_burger",
			Item::new, 
			new Item.Properties().food(ModFoodComponents.CHAMP_BURGER)
	);
	public static final Item JOLLY_HOTDOG = registerItem(
			"jolly_hotdog",
			Item::new, 
			new Item.Properties().food(ModFoodComponents.JOLLY_HOTDOG)
	);
	
	// Jollibee Sides
	public static final Item FRIES = registerItem(
			"fries",
			Item::new, 
			new Item.Properties().food(ModFoodComponents.FRIES)
	);
	public static final Item CHICKEN_NUGGETS = registerItem(
			"chicken_nuggets",
			Item::new, 
			new Item.Properties().food(ModFoodComponents.CHICKEN_NUGGETS)
	);
	
	// Jollibee Deserts
	public static final Item PEACH_MANGO_PIE = registerItem(
			"peach_mango_pie",
			Item::new, 
			new Item.Properties().food(ModFoodComponents.PEACH_MANGO_PIE)
		);
	
	// Street Food
	public static final Item FISH_BALL = registerItem(
			"fish_ball",
			Item::new, 
			new Item.Properties().food(ModFoodComponents.FISH_BALL)
	);
	
	// helper method
	public static <T extends Item> T registerItem(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
		// Create the item key.
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(AdditionalFood.MOD_ID, name));
		
		// Create the item instance.
		T item = itemFactory.apply(settings.setId(itemKey));
		
		// Register the item.
		Registry.register(BuiltInRegistries.ITEM, itemKey, item);
		
		return item;
	}
	
	// gets called by the Main class onInitialize() method
	public static void registerModItems() {
		AdditionalFood.LOGGER.info("Registering Mod Items for " + AdditionalFood.MOD_ID);
	}
}