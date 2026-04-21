package com.jerielb.additional_food;

import com.jerielb.additional_food.block.ModBlocks;
//import com.jerielb.additional_food.entity.ModEntities;
//import com.jerielb.additional_food.entity.custom.JollibeeEntity;
import com.jerielb.additional_food.item.ModItemGroups;
import com.jerielb.additional_food.item.ModItems;
import com.jerielb.additional_food.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdditionalFood implements ModInitializer {
	public static final String MOD_ID = "additional_food";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModVillagers.registerVillagers();
//		FabricDefaultAttributeRegistry.register(ModEntities.JOLLIBEE, JollibeeEntity.createAttributes());
	}
}