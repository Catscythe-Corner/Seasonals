package com.cosmicgelatin.seasonals.common.item;

import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import com.google.common.collect.ImmutableList;
import com.teamabnormals.neapolitan.common.item.DrinkItem;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import java.util.ArrayList;

public class SeasonalsMilkshakeItem extends DrinkItem {

    public SeasonalsMilkshakeItem(Properties builder) {
        super(builder);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entity) {
        this.handleEffects(entity);
        return super.finishUsingItem(stack, worldIn, entity);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if (entity.level.isClientSide) {
            return InteractionResult.PASS;
        } else {
            entity.level.playSound(null, entity.blockPosition(), SoundEvents.WANDERING_TRADER_DRINK_MILK, SoundSource.NEUTRAL, 1.0F, 1.0F);
            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
                serverPlayer.awardStat(Stats.ITEM_USED.get(this));
            }

            if (entity.getEffect(NeapolitanMobEffects.VANILLA_SCENT.get()) == null) {
                this.handleEffects(entity);
            }

            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
                ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
                if (!player.getInventory().add(itemstack)) {
                    player.drop(itemstack, false);
                }
            }

            return InteractionResult.SUCCESS;
        }
    }

    private void handleEffects(LivingEntity user) {
        ImmutableList<MobEffectInstance> userEffects = ImmutableList.copyOf(user.getActiveEffects());
        RandomSource randomSource = user.getRandom();

        if (userEffects.size() >= 1) {
            if (this == SeasonalsItems.PUMPKIN_MILKSHAKE.get()) {
                for (MobEffectInstance effect : userEffects) {
                    if (effect.getEffect() != MobEffects.BAD_OMEN && effect.getEffect() != MobEffects.HERO_OF_THE_VILLAGE) {
                        int newDuration = effect.getDuration() < 3600 ? randomSource.nextIntBetweenInclusive(600, 3600) : randomSource.nextIntBetweenInclusive(3600, 7200);
                        user.removeEffect(effect.getEffect());
                        user.addEffect(new MobEffectInstance(effect.getEffect(), newDuration, effect.getAmplifier()));
                    }
                }

            }
            else if (this == SeasonalsItems.SWEET_BERRY_MILKSHAKE.get()) {
                for (MobEffectInstance effect : userEffects) {
                    if (effect.getEffect() != MobEffects.BAD_OMEN && effect.getEffect() != MobEffects.HERO_OF_THE_VILLAGE) {
                        user.removeEffect(effect.getEffect());
                        user.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration(), randomSource.nextInt(3)));
                    }
                }
            }
        }
    }

    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }
}
