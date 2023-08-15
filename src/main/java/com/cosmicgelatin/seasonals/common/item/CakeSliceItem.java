package com.cosmicgelatin.seasonals.common.item;

import com.cosmicgelatin.seasonals.core.ModIntegration;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CakeSliceItem extends Item {
    private final MobEffect effect;
    private final int duartion;

    public CakeSliceItem(Properties pProperties, MobEffect effect, int duartion) {
        super(ModIntegration.isFDLoaded() ? pProperties.tab(CreativeModeTab.TAB_FOOD) : pProperties);
        this.effect = effect;
        this.duartion = duartion;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        if (!pLevel.isClientSide && this.effect != null) {
            pLivingEntity.addEffect(new MobEffectInstance(effect, duartion));
        }

        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }
}
