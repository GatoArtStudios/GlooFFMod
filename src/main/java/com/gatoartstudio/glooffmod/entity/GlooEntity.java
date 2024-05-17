package com.gatoartstudio.glooffmod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;

public class GlooEntity extends Mob {

    protected GlooEntity(EntityType<? extends Mob> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        // No goals needed for a static wall entity
    }
}
