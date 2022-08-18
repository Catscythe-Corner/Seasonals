package com.cosmicgelatin.seasonals.core.other;

import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.SeasonalsConfig;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsEffects;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import com.teamabnormals.berry_good.core.registry.BGItems;
import com.teamabnormals.blueprint.core.util.TradeUtil;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
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

        if (source.getDirectEntity() instanceof Player && ((Player)source.getDirectEntity()).getEffect(SeasonalsEffects.PUPPETEERING.get()) != null && !puppetBound.containsValue(entityLiving.getId())) {
            puppetBound.put(source.getDirectEntity().getUUID(), entityLiving.getId());
        }

        if (entityLiving.getEffect(SeasonalsEffects.THORN_RESISTANCE.get()) != null)
            //Todo This could be made into a tag
            if (source == DamageSource.CACTUS || source == DamageSource.SWEET_BERRY_BUSH || ((source instanceof EntityDamageSource) && ((EntityDamageSource)source).isThorns()) /*|| isAtmosphericDamage(source)*/) {
                event.setCanceled(true);
            }
    }

    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        VillagerProfession type = event.getType();

        if (type == VillagerProfession.FARMER) {
            TradeUtil.addVillagerTrades(event, TradeUtil.APPRENTICE,
                    new TradeUtil.BlueprintTrade(SeasonalsItems.ROASTED_PUMPKIN.get(), 8, 1, 16, 2));
            TradeUtil.addVillagerTrades(event, TradeUtil.JOURNEYMAN,
                    new TradeUtil.BlueprintTrade(1, SeasonalsItems.CHOCOLATE_PUMPKIN_MUFFIN.get(), 8, 12, 10));
            TradeUtil.addVillagerTrades(event, TradeUtil.EXPERT,
                    new TradeUtil.BlueprintTrade(3, SeasonalsItems.PUMPKIN_CAKE.get(), 1, 12, 15));
            TradeUtil.addVillagerTrades(event, TradeUtil.EXPERT,
                    new TradeUtil.BlueprintTrade(3, SeasonalsItems.SWEET_BERRY_CAKE.get(), 1, 12, 15));
        }
    }

    @SubscribeEvent
    public static void onFoodEaten(LivingEntityUseItemEvent.Finish event) {
        if (event.getItem().getItem() == Items.SWEET_BERRIES)
        {event.getEntityLiving().addEffect(new MobEffectInstance(SeasonalsEffects.THORN_RESISTANCE.get(), 240));}
        else if (SeasonalsConfig.COMMON.outsideEffects.get()) {
            if (event.getItem().getItem() == Items.PUMPKIN_PIE) {
                event.getEntityLiving().addEffect(new MobEffectInstance(SeasonalsEffects.PUPPETEERING.get(), 400));
            }
            else {
                if (event.getItem().getItem() == NeapolitanItems.ADZUKI_CURRY.get()) {event.getEntityLiving().addEffect(new MobEffectInstance(SeasonalsEffects.PUPPETEERING.get(), 300));}
                if (Seasonals.BERRY_GOOD) {
                    if (event.getItem().getItem() == BGItems.SWEET_BERRY_MINCE.get()) {
                        event.getEntityLiving().addEffect(new MobEffectInstance(SeasonalsEffects.THORN_RESISTANCE.get(), 360));
                    }
                    else if (event.getItem().getItem() == BGItems.SWEET_BERRY_MEATBALLS.get()) {event.getEntityLiving().addEffect(new MobEffectInstance(SeasonalsEffects.THORN_RESISTANCE.get(), 600));}
                }
                if (Seasonals.AUTUMNITY) {
                    //if (event.getItem().getItem() == AutumnityItems.PUMPKIN_BREAD.get()) {event.getEntityLiving().addEffect(new MobEffectInstance(SeasonalsEffects.PUPPETEERING.get(), 500));}
                }
            }
        }
    }

    @SubscribeEvent
    public static void effectCured(PotionEvent.PotionRemoveEvent event) {
        LivingEntity entityLiving = event.getEntityLiving();
        if (puppetBound.containsKey(entityLiving.getUUID())) {puppetBound.remove(entityLiving.getUUID());}
    }
/*
    private static boolean isAtmosphericDamage(DamageSource source) {
        return (Seasonals.ATMOSPHERIC && (source == AtmosphericDamageSources.ALOE_LEAVES || source == AtmosphericDamageSources.BARREL_CACTUS || source == AtmosphericDamageSources.YUCCA_BRANCH || source == AtmosphericDamageSources.YUCCA_FLOWER || source == AtmosphericDamageSources.YUCCA_LEAVES || source == AtmosphericDamageSources.YUCCA_SAPLING));
    }

 */
}