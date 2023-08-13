package com.cosmicgelatin.seasonals.core.data.client;

import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsBlocks;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsMobEffects;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class SeasonalsLangProvider extends LanguageProvider {
    public SeasonalsLangProvider(DataGenerator gen) {
        super(gen, Seasonals.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addBlock(SeasonalsBlocks.PUMPKIN_ICE_CREAM_BLOCK, "Pumpkin Ice Cream Block");
        addBlock(SeasonalsBlocks.PUMPKIN_CAKE, "Pumpkin Cake");
        addBlock(SeasonalsBlocks.SWEET_BERRY_ICE_CREAM_BLOCK, "Sweet Berry Ice Cream Block");
        addBlock(SeasonalsBlocks.SWEET_BERRY_CAKE, "Sweet Berry Cake");
        addBlock(SeasonalsBlocks.BEETROOT_ICE_CREAM_BLOCK, "Beetroot Ice Cream Block");
        addBlock(SeasonalsBlocks.BEETROOT_CAKE, "Beetroot Cake");

        addItem(SeasonalsItems.PUMPKIN_PUREE, "Pumpkin Puree");
        addItem(SeasonalsItems.RABBIT_ROAST, "Rabbit Roast");
        addItem(SeasonalsItems.PUMPKIN_ICE_CREAM, "Pumpkin Ice Cream");
        addItem(SeasonalsItems.PUMPKIN_MILKSHAKE, "Pumpkin Milkshake");
        addItem(SeasonalsItems.SWEET_BERRY_ICE_CREAM, "Sweet Berry Ice Cream");
        addItem(SeasonalsItems.SWEET_BERRY_MILKSHAKE, "Sweet Berry Milkshake");
        addItem(SeasonalsItems.CHOCOLATE_PUMPKIN_MUFFIN, "Chocolate Pumpkin Muffin");
        addItem(SeasonalsItems.SWEET_BERRY_VANILLA_YOGURT, "Sweet Berry Vanilla Yogurt");
        addItem(SeasonalsItems.GLAZED_SWEET_BERRIES, "Glazed Sweet Berries");
        addItem(SeasonalsItems.MIXED_BERRY_MUFFIN, "Mixed Berry Muffin");
        addItem(SeasonalsItems.PUMPKIN_ADZUKI_STEW, "Pumpkin Adzuki Stew");
        addItem(SeasonalsItems.BANANA_SPLIT_SUNDAE, "Banana Split Sundae");
        addItem(SeasonalsItems.BEETROOT_ICE_CREAM, "Beetroot Ice Cream");
        addItem(SeasonalsItems.BEETROOT_MILKSHAKE, "Beetroot Milkshake");
        addItem(SeasonalsItems.ROASTED_BEETROOT, "Roasted Beetroot");
        addItem(SeasonalsItems.OXIDIZED_BEETROOT, "Oxidized Beetroot");
        addItem(SeasonalsItems.RED_VELVET_CUPCAKE, "Red Velvet Cupcake");
        addItem(SeasonalsItems.PUMPKIN_CAKE_SLICE, "Pumpkin Cake Slice");
        addItem(SeasonalsItems.SWEET_BERRY_CAKE_SLICE, "Sweet Berry Cake Slice");
        addItem(SeasonalsItems.BEETROOT_CAKE_SLICE, "Beetroot Cake Slice");

        addEffect(SeasonalsMobEffects.STUFFED, "Stuffed");
        addEffect(SeasonalsMobEffects.THORN_RESISTANCE, "Thorn Resistance");
        addEffect(SeasonalsMobEffects.ROOTED, "Rooted");
    }
}
