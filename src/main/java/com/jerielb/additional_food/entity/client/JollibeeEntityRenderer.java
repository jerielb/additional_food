package com.jerielb.additional_food.entity.client;

import com.jerielb.additional_food.AdditionalFood;
import com.jerielb.additional_food.entity.custom.JollibeeEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class JollibeeEntityRenderer extends MobRenderer<JollibeeEntity, JollibeeEntityRenderState, JollibeeEntityModel> {
	private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(AdditionalFood.MOD_ID, "textures/entity/jollibee.png");
	
	public JollibeeEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new JollibeeEntityModel(context.bakeLayer(ModEntityModelLayers.JOLLIBEE)), 0.375f); // 0.375 shadow radius
	}
	
	@Override
	public JollibeeEntityRenderState createRenderState() {
		return new JollibeeEntityRenderState();
	}
	
	@Override
	public Identifier getTextureLocation(JollibeeEntityRenderState state) {
		return TEXTURE;
	}
}
