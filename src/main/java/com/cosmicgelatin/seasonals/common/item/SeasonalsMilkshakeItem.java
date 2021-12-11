package com.cosmicgelatin.seasonals.common.item;

import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import com.google.common.collect.ImmutableList;

import com.minecraftabnormals.neapolitan.common.item.DrinkItem;
import com.minecraftabnormals.neapolitan.core.registry.NeapolitanEffects;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collections;

public class SeasonalsMilkshakeItem extends DrinkItem {

    public SeasonalsMilkshakeItem(Properties builder) {
        super(builder);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entity) {
        this.handleEffects(entity);
        return super.finishUsingItem(stack, worldIn, entity);
    }

    @Override
    public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        if (entity.level.isClientSide) {
            return ActionResultType.PASS;
        } else {
            entity.level.playSound((PlayerEntity)null, entity.blockPosition(), SoundEvents.WANDERING_TRADER_DRINK_MILK, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            if (player instanceof ServerPlayerEntity) {
                ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)player;
                CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
                serverplayerentity.awardStat(Stats.ITEM_USED.get(this));
            }

            if (entity.getEffect((Effect) NeapolitanEffects.VANILLA_SCENT.get()) == null) {
                this.handleEffects(entity);
            }

            if (!player.abilities.instabuild) {
                stack.shrink(1);
                ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
                if (!player.inventory.add(itemstack)) {
                    player.drop(itemstack, false);
                }
            }

            return ActionResultType.SUCCESS;
        }
    }

    private void handleEffects(LivingEntity user) {
        ImmutableList<EffectInstance> effects = ImmutableList.copyOf(user.getActiveEffects());

        if (effects.size() > 1) {
            if (this == SeasonalsItems.PUMPKIN_MILKSHAKE.get()) {
                int durationSum = 0;
                int numEff = 0;

                for (EffectInstance e : effects) {
                    if (e.getEffect() != Effects.BAD_OMEN && e.getEffect() != Effects.HERO_OF_THE_VILLAGE) {
                        numEff++;
                        durationSum += e.getDuration();
                        user.removeEffect(e.getEffect());
                    }
                }

                for (EffectInstance e : effects) {
                    if (e.getEffect() != Effects.BAD_OMEN && e.getEffect() != Effects.HERO_OF_THE_VILLAGE) {
                        user.addEffect(new EffectInstance(e.getEffect(), durationSum / numEff, e.getAmplifier()));
                    }
                }
            }
            else if (this == SeasonalsItems.SWEET_BERRY_MILKSHAKE.get()) {
                ArrayList<Effect> effs = new ArrayList<Effect>();
                ArrayList<Integer> amps = new ArrayList<Integer>();
                ArrayList<Integer> dura = new ArrayList<Integer>();

                int numEff = 0;

                for (EffectInstance e : effects) {
                    if (e.getEffect() != Effects.BAD_OMEN && e.getEffect() != Effects.HERO_OF_THE_VILLAGE) {
                        numEff++;
                        effs.add(e.getEffect());
                        amps.add(e.getAmplifier());
                        dura.add(e.getDuration());
                        user.removeEffect(e.getEffect());
                    }
                }

                Collections.shuffle(effs);
                Collections.shuffle(amps);
                Collections.shuffle(dura);

                for (int i = 0; i < numEff; i++) {
                    user.addEffect(new EffectInstance(effs.get(i), dura.get(i), amps.get(i)));
                }
            }
        }
    }

    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }
}
