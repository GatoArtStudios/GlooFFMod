package com.gatoartstudio.glooffmod;

import com.gatoartstudio.glooffmod.client.model.ParedGlooModel;
import com.gatoartstudio.glooffmod.client.renderer.ParedGlooRenderer;
import com.gatoartstudio.glooffmod.entity.GlooEntityType;
import com.gatoartstudio.glooffmod.item.Glooitem;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;

@Mod(Glooffmod.MODID)
public class Glooffmod {

    public static final String MODID = "glooffmod";
    private static final Logger LOGGER = LogManager.getLogger();

    public Glooffmod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonsetup);
        modEventBus.addListener(ClientModEvents::onClientSetup);
        modEventBus.addListener(ClientModEvents::registerLayerDefinitions);

        Glooitem.register(modEventBus);
        GlooEntityType.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonsetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Configuracion del juego cargada");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(GlooEntityType.GLOO.get(), ParedGlooRenderer::new);
            LOGGER.info("Configuracion del cliente cargada");
        }

        @SubscribeEvent
        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(ParedGlooModel.LAYER_LOCATION, ParedGlooModel::createBodyLayer);
        }
    }
}