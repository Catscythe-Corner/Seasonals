package com.cosmicgelatin.seasonals.common.potion;

import com.cosmicgelatin.seasonals.core.registry.SeasonalsEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;

public class FallFlavorEffect extends MobEffect {

    public FallFlavorEffect() {
        super(MobEffectCategory.BENEFICIAL, 11683328);
    }
//TODO No clue what this is?
    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level.isClientSide) {
            int duration = entity.getEffect(SeasonalsEffects.FALL_FLAVOR.get()).getDuration();
            if ((duration - 20) % (300 / ((amplifier % 32) + 1))  == 0) {
                if (entity instanceof Player && ((Player) entity).getFoodData().getFoodLevel() < 20) {
                    entity.eat(entity.getCommandSenderWorld(), new Item(new Item.Properties().food(Foods.DRIED_KELP)).getDefaultInstance());
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
