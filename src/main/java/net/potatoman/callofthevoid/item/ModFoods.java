package net.potatoman.callofthevoid.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties Raw_Void_Hopper_Leg = new FoodProperties.Builder().alwaysEat().nutrition(4).meat()
            .saturationMod(1.8F).effect(() -> new MobEffectInstance(MobEffects.POISON, 100), 0.5f).build();

}
