package com.jerielb.additional_food.item;

import com.jerielb.additional_food.AdditionalFood;
//import com.jerielb.additional_food.block.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {
	// tab group for ITEMS
	public static final ResourceKey<CreativeModeTab> ADDITIONAL_FOOD_CREATIVE_TAB_KEY = ResourceKey.create(
			BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(AdditionalFood.MOD_ID, "additional_food")
	);
	public static final CreativeModeTab ADDITIONAL_FOOD_CREATIVE_TAB = FabricCreativeModeTab.builder()
			.icon(() -> new ItemStack(ModItems.FRIES))
			.title(Component.translatable("creativeTab.additional_food"))
			.displayItems((params, output) -> {
				// ### ITEMS ###
				// Meals
				output.accept(ModItems.CHICKEN_JOY);
				output.accept(ModItems.JOLLY_SPAGHETTI);
				output.accept(ModItems.PALABOK);
				output.accept(ModItems.BURGER_STEAK);
				
				// Burgers
				output.accept(ModItems.YUM_BURGER);
				output.accept(ModItems.CHAMP_BURGER);
				output.accept(ModItems.JOLLY_HOTDOG);
				
				// Sides
				output.accept(ModItems.FRIES);
				output.accept(ModItems.CHICKEN_NUGGETS);
				
				// Deserts
				output.accept(ModItems.PEACH_MANGO_PIE);
				
				// Street Food
				output.accept(ModItems.FISH_BALL);
				
				// ### BLOCKS ###
//				output.accept(ModBlocks.QUARTZ_BLOCK);
			})
			.build();
	
	// gets called by the Main class onInitialize() method
	public static void registerItemGroups() {
		AdditionalFood.LOGGER.info("Registering Item Groups for " + AdditionalFood.MOD_ID);
		
		// Register the group.
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ADDITIONAL_FOOD_CREATIVE_TAB_KEY, ADDITIONAL_FOOD_CREATIVE_TAB);
	}
}
