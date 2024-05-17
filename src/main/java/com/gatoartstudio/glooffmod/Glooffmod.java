package com.gatoartstudio.glooffmod;

import net.minecraftforge.fml.common.Mod;

@Mod(Glooffmod.MODID)
public class Glooffmod {

    public static final String MODID = "glooffmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Glooffmod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        Glooitem.register(eventBus);
    }
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            LOGGER.info("This line is printed by an example mod mixin");
        }
    }
}