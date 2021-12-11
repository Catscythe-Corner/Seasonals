package com.cosmicgelatin.seasonals.common.potion;

import com.cosmicgelatin.seasonals.core.registry.SeasonalsEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class FallFlavorEffect extends Effect {

    public FallFlavorEffect() {
        super(EffectType.BENEFICIAL, 11683328);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level.isClientSide) {
            int duration = entity.getEffect(SeasonalsEffects.FALL_FLAVOR.get()).getDuration();
            if ((duration - 20) % (300 / ((amplifier % 32) + 1))  == 0) {
                if (entity instanceof PlayerEntity && ((PlayerEntity) entity).getFoodData().getFoodLevel() < 20) {
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
