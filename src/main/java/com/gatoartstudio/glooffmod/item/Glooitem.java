package com.gatoartstudio.glooffmod.item;

import com.gatoartstudio.glooffmod.Glooffmod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

public class Glooitem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Glooffmod.MODID);

    // Define tu pestaña creativa personalizada
    public static final CreativeModeTab GLOO_TAB = new CreativeModeTab("glooffmod") {
        @Override
        public ItemStack makeIcon() {
            // Devuelve el ícono de la pestaña creativa
            return new ItemStack(GLOO.get());
        }
    };

    public static final RegistryObject<Item> GLOO = ITEMS.register("gloo",
            () -> new Item(new Item.Properties().tab(GLOO_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
