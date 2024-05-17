package com.gatoartstudio.glooffmod.client.model;

import com.gatoartstudio.glooffmod.entity.GlooEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class ParedGlooModel<T extends GlooEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "ParedGlooModel"), "main");
	private final ModelPart bb_main;

	public ParedGlooModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition SuperiorDerecho_r1 = bb_main.addOrReplaceChild("SuperiorDerecho_r1", CubeListBuilder.create().texOffs(0, 36).addBox(-7.0F, -16.0F, -1.0F, 17.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, -13.0F, -5.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition InferiorIzquierdo_r1 = bb_main.addOrReplaceChild("InferiorIzquierdo_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, -16.0F, -1.0F, 25.0F, 16.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(38, 36).addBox(-7.0F, -29.0F, -1.0F, 17.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 0.0F, -5.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition InferiorDerecho_r1 = bb_main.addOrReplaceChild("InferiorDerecho_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-15.0F, -16.0F, -1.0F, 25.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, -8.0F, 0.0F, 0.3491F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(GlooEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}