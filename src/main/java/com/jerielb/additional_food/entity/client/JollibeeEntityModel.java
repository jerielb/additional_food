package com.jerielb.additional_food.entity.client;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class JollibeeEntityModel extends EntityModel<JollibeeEntityRenderState> {
	private final ModelPart WAIST;
	private final ModelPart HEAD;
	private final ModelPart BODY;
	private final ModelPart RIGHT_ARM;
	private final ModelPart LEFT_ARM;
	private final ModelPart RIGHT_LEG;
	private final ModelPart LEFT_LEG;
	
	public JollibeeEntityModel(ModelPart root) {
		super(root);
		this.WAIST = root.getChild("WAIST");
		this.HEAD = this.WAIST.getChild("HEAD");
		this.BODY = this.WAIST.getChild("BODY");
		this.RIGHT_ARM = this.WAIST.getChild("RIGHT_ARM");
		this.LEFT_ARM = this.WAIST.getChild("LEFT_ARM");
		this.RIGHT_LEG = root.getChild("RIGHT_LEG");
		this.LEFT_LEG = root.getChild("LEFT_LEG");
	}
	
	public static LayerDefinition getTexturedModelData() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		
		PartDefinition WAIST = partdefinition.addOrReplaceChild("WAIST", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));
		
		PartDefinition HEAD = WAIST.addOrReplaceChild("HEAD", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, -0.0436F, 0.0F, 0.0F));
		
		PartDefinition BODY = WAIST.addOrReplaceChild("BODY", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, -12.0F, 0.0F));
		
		PartDefinition RIGHT_ARM = WAIST.addOrReplaceChild("RIGHT_ARM", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, 0.0F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(40, 32).addBox(-3.0F, 0.0F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-5.0F, -10.0F, 0.0F, -0.4363F, 0.0F, -1.0472F));
		
		PartDefinition LEFT_ARM = WAIST.addOrReplaceChild("LEFT_ARM", CubeListBuilder.create().texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(6.0F, -10.0F, -1.0F, -2.9849F, -0.5643F, 1.6066F));
		
		PartDefinition RIGHT_LEG = partdefinition.addOrReplaceChild("RIGHT_LEG", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 32).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-2.15F, 12.0F, 0.0F, 0.0865F, -0.0114F, 0.1304F));
		
		PartDefinition LEFT_LEG = partdefinition.addOrReplaceChild("LEFT_LEG", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, -0.0872F, -0.0019F, -0.0436F));
		
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
}
