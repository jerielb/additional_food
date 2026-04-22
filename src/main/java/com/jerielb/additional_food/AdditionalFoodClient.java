package com.jerielb.additional_food;

import com.jerielb.additional_food.entity.ModEntityTypes;
import com.jerielb.additional_food.entity.client.JollibeeEntityRenderer;
import com.jerielb.additional_food.entity.client.ModEntityModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class AdditionalFoodClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModEntityModelLayers.registerModelLayers();
		EntityRenderers.register(ModEntityTypes.JOLLIBEE, JollibeeEntityRenderer::new);
	}
}
