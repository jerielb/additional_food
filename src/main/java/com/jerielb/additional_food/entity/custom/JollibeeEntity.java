package com.jerielb.additional_food.entity.custom;

import com.jerielb.additional_food.entity.ModEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class JollibeeEntity extends PathfinderMob {
	public JollibeeEntity(Level world) {
		this(ModEntityTypes.JOLLIBEE, world);
	}
	
	public JollibeeEntity(EntityType<? extends JollibeeEntity> entityType, Level world) {
		super(entityType, world);
	}
	
	public static AttributeSupplier.Builder createCubeAttributes() {
		return PathfinderMob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 18)
				.add(Attributes.MOVEMENT_SPEED, 0.35);
	}
}
