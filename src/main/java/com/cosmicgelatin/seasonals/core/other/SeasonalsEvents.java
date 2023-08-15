package com.cosmicgelatin.seasonals.core.other;

import com.cosmicgelatin.seasonals.core.ModIntegration;
import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.SeasonalsConfig;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsBlocks;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsMobEffects;
import com.teamabnormals.atmospheric.core.other.AtmosphericDamageSources;
import com.teamabnormals.autumnity.core.registry.AutumnityItems;
import com.teamabnormals.berry_good.core.registry.BGItems;
import com.teamabnormals.blueprint.core.util.TradeUtil;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Seasonals.MODID)
public class SeasonalsEvents {

    //This can be made data-driven in 1.19.4+
    @SubscribeEvent
    public static void onEntityAttacked(LivingAttackEvent event) {
        LivingEntity entityLiving = event.getEntity();
        DamageSource source = event.getSource();

        if (entityLiving.getEffect(SeasonalsMobEffects.THORN_RESISTANCE.get()) != null) {
            if (source == DamageSource.CACTUS || source == DamageSource.SWEET_BERRY_BUSH || ((source instanceof EntityDamageSource) && ((EntityDamageSource) source).isThorns()) || isAtmosphericDamage(source)) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();

        if (entity instanceof Player player) {
            if (!player.level.isClientSide) {
                if (player.hasEffect(SeasonalsMobEffects.STUFFED.get())) {
                    MobEffectInstance effect = player.getEffect(SeasonalsMobEffects.STUFFED.get());
                    FoodData foodData = player.getFoodData();
                    if (effect.getDuration() > 40) {
                        if (foodData.needsFood()) {
                            foodData.setFoodLevel(foodData.getFoodLevel() + 1);
                            foodData.setSaturation(foodData.getSaturationLevel() + 1);
                        }
                        foodData.setExhaustion(0);
                    } else {
                        if (foodData.getFoodLevel() > 1) {
                            foodData.setFoodLevel(foodData.getFoodLevel() - 1);
                            foodData.setSaturation(foodData.getSaturationLevel() - 1);
                        }
                    }
                }
            }
        }
    }


    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        VillagerProfession type = event.getType();

        if (type == VillagerProfession.FARMER) {
            TradeUtil.addVillagerTrades(event, TradeUtil.APPRENTICE,
                    new TradeUtil.BlueprintTrade(SeasonalsItems.PUMPKIN_PUREE.get(), 8, 1, 16, 2));
            TradeUtil.addVillagerTrades(event, TradeUtil.JOURNEYMAN,
                    new TradeUtil.BlueprintTrade(1, SeasonalsItems.CHOCOLATE_PUMPKIN_MUFFIN.get(), 8, 12, 10));
            TradeUtil.addVillagerTrades(event, TradeUtil.EXPERT,
                    new TradeUtil.BlueprintTrade(3, SeasonalsBlocks.PUMPKIN_CAKE.get().asItem(), 1, 12, 15));
            TradeUtil.addVillagerTrades(event, TradeUtil.EXPERT,
                    new TradeUtil.BlueprintTrade(3, SeasonalsBlocks.SWEET_BERRY_CAKE.get().asItem(), 1, 12, 15));
        }
    }

    @SubscribeEvent
    public static void onFoodEaten(LivingEntityUseItemEvent.Finish event) {
        Item useItem = event.getItem().getItem();
        LivingEntity entity = event.getEntity();

        if (useItem == Items.SWEET_BERRIES) {
            entity.addEffect(new MobEffectInstance(SeasonalsMobEffects.THORN_RESISTANCE.get(), 240));
        }
        else if (SeasonalsConfig.COMMON.outsideEffects.get()) {
            if (useItem == Items.PUMPKIN_PIE) {
                entity.addEffect(new MobEffectInstance(SeasonalsMobEffects.STUFFED.get(), 400));
            }
            else {
                if (useItem == NeapolitanItems.ADZUKI_CURRY.get()) {
                    entity.addEffect(new MobEffectInstance(SeasonalsMobEffects.STUFFED.get(), 300));
                }
                if (ModIntegration.isBerryGoodLoaded()) {
                    if (useItem == BGItems.SWEET_BERRY_MINCE.get()) {
                        entity.addEffect(new MobEffectInstance(SeasonalsMobEffects.THORN_RESISTANCE.get(), 360));
                    }
                    else if (useItem == BGItems.SWEET_BERRY_MEATBALLS.get()) {
                        entity.addEffect(new MobEffectInstance(SeasonalsMobEffects.THORN_RESISTANCE.get(), 600));
                    }
                }
                if (ModIntegration.isAutumnityLoaded()) {
                    if (useItem == AutumnityItems.PUMPKIN_BREAD.get()) {
                        entity.addEffect(new MobEffectInstance(SeasonalsMobEffects.STUFFED.get(), 500));
                    }
                }
            }
        }
    }

    private static boolean isAtmosphericDamage(DamageSource source) {
        return (ModIntegration.isAtmosphericLoaded() && (source == AtmosphericDamageSources.ALOE_LEAVES || source == AtmosphericDamageSources.BARREL_CACTUS || source == AtmosphericDamageSources.YUCCA_BRANCH || source == AtmosphericDamageSources.YUCCA_FLOWER || source == AtmosphericDamageSources.YUCCA_LEAVES || source == AtmosphericDamageSources.YUCCA_SAPLING));
    }
}