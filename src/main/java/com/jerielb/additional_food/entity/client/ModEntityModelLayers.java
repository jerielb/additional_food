package com.jerielb.additional_food.entity.client;

import com.jerielb.additional_food.AdditionalFood;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class ModEntityModelLayers {
	public static final ModelLayerLocation JOLLIBEE = createMain("jollibee");
	
	private static ModelLayerLocation createMain(String name) {
		return new ModelLayerLocation(Identifier.fromNamespaceAndPath(AdditionalFood.MOD_ID, name), "main");
	}
	
	public static void registerModelLayers() {
		ModelLayerRegistry.registerModelLayer(ModEntityModelLayers.JOLLIBEE, JollibeeEntityModel::getTexturedModelData);
	}
}
