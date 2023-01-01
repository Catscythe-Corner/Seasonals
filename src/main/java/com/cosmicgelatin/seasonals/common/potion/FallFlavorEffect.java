package com.cosmicgelatin.seasonals.common.potion;

import com.cosmicgelatin.seasonals.core.registry.SeasonalsEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;

public class FallFlavorEffect extends MobEffect {

    public FallFlavorEffect() {
        super(MobEffectCategory.BENEFICIAL, 11683328);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level.isClientSide) {
            if (entity instanceof Player player) {
                FoodData foodData = player.getFoodData();
                int duration = player.getEffect(SeasonalsEffects.FALL_FLAVOR.get()).getDuration();
                if (duration % (100 / ((amplifier % 32) + 1))  == 0) {
                    int preFood = foodData.getFoodLevel();
                    if (preFood < 20) {
                        foodData.setFoodLevel(preFood + 1);
                    }
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
