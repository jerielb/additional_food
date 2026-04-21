package com.jerielb.additional_food.villager;

import com.google.common.collect.ImmutableSet;
import com.jerielb.additional_food.AdditionalFood;
import com.jerielb.additional_food.block.ModBlocks;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PoiHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.level.block.Block;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class ModVillagers {
	public static PoiType JOLLIBEE_EMP_POI;
	public static VillagerProfession JOLLIBEE_EMP;

//	public static final RegistryKey<PointOfInterestType> STREET_FOOD_VENDOR_POI_KEY = registerPoiKey("street_food_vendor_poi");
//	public static final PointOfInterestType STREET_FOOD_VENDOR_EMP_POI = registerPOI("street_food_vendor_poi", Blocks.REINFORCED_DEEPSLATE);
//	public static final VillagerProfession STREET_FOOD_VENDOR = registerProfession("street_food_vendor", STREET_FOOD_VENDOR_POI_KEY);
	
	private static VillagerProfession registerProfession(String name, String poiName, Supplier<SoundEvent> soundEvent) {
		ResourceKey<PoiType> poiKey = ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, Identifier.fromNamespaceAndPath("additional_food", poiName));
		Predicate<Holder<PoiType>> heldWorkstation = (entry) -> {
			return entry.is(poiKey);
		};
		Predicate<Holder<PoiType>> acquirableWorkstation = (entry) -> {
			return entry.is(poiKey);
		};
		ResourceKey<VillagerProfession> profKey = ResourceKey.create(Registries.VILLAGER_PROFESSION, Identifier.fromNamespaceAndPath("additional_food", name));
		VillagerProfession profession = new VillagerProfession(Component.translatable("entity.additional_food.villager." + name), heldWorkstation, acquirableWorkstation, ImmutableSet.of(), ImmutableSet.of(), (SoundEvent)soundEvent.get(), buildTradeSets(name));
		return (VillagerProfession) Registry.register(BuiltInRegistries.VILLAGER_PROFESSION, profKey, profession);
	}

	private static PoiType registerPoi(String name, Block block) {
		return PoiHelper.register(Identifier.fromNamespaceAndPath(AdditionalFood.MOD_ID, name), 1, 1, new Block[]{block});
	}

	private static Int2ObjectMap<ResourceKey<TradeSet>> buildTradeSets(String professionName) {
		Int2ObjectOpenHashMap<ResourceKey<TradeSet>> map = new Int2ObjectOpenHashMap();
		
		for(int level = 1; level <= 5; ++level) {
			map.put(level, ResourceKey.create(Registries.TRADE_SET, Identifier.fromNamespaceAndPath("additional_food", professionName + "/level_" + level)));
		}
		
		return map;
	}

	public static void registerVillagers() {
		AdditionalFood.LOGGER.info("Registering Villagers for " + AdditionalFood.MOD_ID);
		
		JOLLIBEE_EMP_POI = registerPoi("jollibee_emp_poi", ModBlocks.QUARTZ_BLOCK);
		JOLLIBEE_EMP = registerProfession("jollibee_emp", "jollibee_emp_poi", () -> {
			return (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(Identifier.fromNamespaceAndPath("minecraft", "block.wool.hit"));
		});
				
		BuiltInRegistries.POINT_OF_INTEREST_TYPE.entrySet().forEach((entry) -> {
			if (((ResourceKey)entry.getKey()).identifier().getNamespace().equals("additional_food")) {
				AdditionalFood.LOGGER.info("POI: {} -> {}", ((ResourceKey)entry.getKey()).identifier(), entry.getValue());
			}
			
		});
		BuiltInRegistries.VILLAGER_PROFESSION.entrySet().forEach((entry) -> {
			if (((ResourceKey)entry.getKey()).identifier().getNamespace().equals("additional_food")) {
				AdditionalFood.LOGGER.info("Profession: {} -> {}", ((ResourceKey)entry.getKey()).identifier(), entry.getValue());
			}
			
		});
	}
}
