package com.gatoartstudio.glooffmod.client.renderer;

import com.gatoartstudio.glooffmod.Glooffmod;
import com.gatoartstudio.glooffmod.client.model.ParedGlooModel;
import com.gatoartstudio.glooffmod.entity.GlooEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ParedGlooRenderer extends MobRenderer<GlooEntity, ParedGlooModel<GlooEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Glooffmod.MODID, "textures/entity/textureGloo.png");

    public ParedGlooRenderer(EntityRendererProvider.Context context) {
        super(context, new ParedGlooModel<>(context.bakeLayer(ParedGlooModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(GlooEntity entity) {
        return TEXTURE;
    }
}
