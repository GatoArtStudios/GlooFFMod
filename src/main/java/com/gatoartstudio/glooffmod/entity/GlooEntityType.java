package com.gatoartstudio.glooffmod.entity;

import com.gatoartstudio.glooffmod.Glooffmod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;

public class GlooEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Glooffmod.MODID);

    public static final RegistryObject<EntityType<GlooEntity>> GLOO = ENTITY_TYPES.register("gloo", () ->
            EntityType.Builder.of(GlooEntity::new, MobCategory.MISC)
                    .sized(1.0f, 2.0f) // Adjust size as needed
                    .build("gloo")
    );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
