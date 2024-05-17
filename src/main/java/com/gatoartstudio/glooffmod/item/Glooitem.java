package com.gatoartstudio.glooffmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class Glooitem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Glooffmod.MODID);

    public static final RegistryObject<Item> GLOO = ITEMS.register("gloo", Gloo::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
