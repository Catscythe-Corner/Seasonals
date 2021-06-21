package com.cosmicgelatin.seasonals.core.other;

import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.SeasonalsConfig;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsEffects;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import com.minecraftabnormals.abnormals_core.core.util.TradeUtil;
import com.minecraftabnormals.atmospheric.core.other.AtmosphericDamageSources;
import com.minecraftabnormals.autumnity.core.registry.AutumnityItems;
import com.minecraftabnormals.berry_good.core.registry.BGItems;
import com.minecraftabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = Seasonals.MODID)
public class SeasonalsEvents {
    public static final HashMap<UUID, Integer> puppetBound = new HashMap<>();
    
    @SubscribeEvent
    public static void onEntityAttacked(LivingAttackEvent event) {
        LivingEntity entityLiving = event.getEntityLiving();
        DamageSource source = event.getSource();

        if (source.getTrueSource() instanceof PlayerEntity && ((PlayerEntity)source.getTrueSource()).getActivePotionEffect(SeasonalsEffects.PUPPETEERING.get()) != null && !puppetBound.containsValue(entityLiving.getEntityId())) {
            puppetBound.put(source.getTrueSource().getUniqueID(), entityLiving.getEntityId());
        }

        if (entityLiving.getActivePotionEffect(SeasonalsEffects.THORN_RESISTANCE.get()) != null)
            if (source == DamageSource.CACTUS || source == DamageSource.SWEET_BERRY_BUSH || ((source instanceof EntityDamageSource) && ((EntityDamageSource)source).getIsThornsDamage()) || isAtmosphericDamage(source)) {
                event.setCanceled(true);
            }
    }

    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        VillagerProfession type = event.getType();

        if (type == VillagerProfession.FARMER) {
            TradeUtil.addVillagerTrades(event, TradeUtil.APPRENTICE,
                    new TradeUtil.AbnormalsTrade(SeasonalsItems.ROASTED_PUMPKIN.get(), 8, 1, 16, 2));
            TradeUtil.addVillagerTrades(event, TradeUtil.JOURNEYMAN,
                    new TradeUtil.AbnormalsTrade(1, SeasonalsItems.CHOCOLATE_PUMPKIN_MUFFIN.get(), 8, 12, 10));
            TradeUtil.addVillagerTrades(event, TradeUtil.EXPERT,
                    new TradeUtil.AbnormalsTrade(3, SeasonalsItems.PUMPKIN_CAKE.get(), 1, 12, 15));
            TradeUtil.addVillagerTrades(event, TradeUtil.EXPERT,
                    new TradeUtil.AbnormalsTrade(3, SeasonalsItems.SWEET_BERRY_CAKE.get(), 1, 12, 15));
        }
    }

    @SubscribeEvent
    public static void onFoodEaten(LivingEntityUseItemEvent.Finish event) {
        if (event.getItem().getItem() == Items.SWEET_BERRIES)
        {event.getEntityLiving().addPotionEffect(new EffectInstance(SeasonalsEffects.THORN_RESISTANCE.get(), 240));}
        else if (SeasonalsConfig.COMMON.outsideEffects.get()) {
            if (event.getItem().getItem() == Items.PUMPKIN_PIE) {
                event.getEntityLiving().addPotionEffect(new EffectInstance(SeasonalsEffects.PUPPETEERING.get(), 400));
            }
            else {
                if (event.getItem().getItem() == NeapolitanItems.ADZUKI_CURRY.get()) {event.getEntityLiving().addPotionEffect(new EffectInstance(SeasonalsEffects.PUPPETEERING.get(), 300));}
                if (Seasonals.BERRY_GOOD) {
                    if (event.getItem().getItem() == BGItems.SWEET_BERRY_MINCE.get()) {
                        event.getEntityLiving().addPotionEffect(new EffectInstance(SeasonalsEffects.THORN_RESISTANCE.get(), 360));
                    }
                    else if (event.getItem().getItem() == BGItems.SWEET_BERRY_MEATBALLS.get()) {event.getEntityLiving().addPotionEffect(new EffectInstance(SeasonalsEffects.THORN_RESISTANCE.get(), 600));}
                }
                if (Seasonals.AUTUMNITY) {
                    if (event.getItem().getItem() == AutumnityItems.PUMPKIN_BREAD.get()) {event.getEntityLiving().addPotionEffect(new EffectInstance(SeasonalsEffects.PUPPETEERING.get(), 500));}
                }
            }
        }
    }

    @SubscribeEvent
    public static void effectCured(PotionEvent.PotionRemoveEvent event) {
        LivingEntity entityLiving = event.getEntityLiving();
        if (puppetBound.containsKey(entityLiving.getUniqueID())) {puppetBound.remove(entityLiving.getUniqueID());}
    }

    private static boolean isAtmosphericDamage(DamageSource source) {
        return (Seasonals.ATMOSPHERIC && (source == AtmosphericDamageSources.ALOE_LEAVES || source == AtmosphericDamageSources.BARREL_CACTUS || source == AtmosphericDamageSources.YUCCA_BRANCH || source == AtmosphericDamageSources.YUCCA_FLOWER || source == AtmosphericDamageSources.YUCCA_LEAVES || source == AtmosphericDamageSources.YUCCA_SAPLING));
    }
}