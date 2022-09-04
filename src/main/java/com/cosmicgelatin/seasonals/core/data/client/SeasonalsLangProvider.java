package com.cosmicgelatin.seasonals.core.data.client;

import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsBlocks;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsEffects;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class SeasonalsLangProvider extends LanguageProvider {
    public SeasonalsLangProvider(DataGenerator gen) {
        super(gen, Seasonals.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(SeasonalsBlocks.PUMPKIN_ICE_CREAM_BLOCK.get(), "Pumpkin Ice Cream Block");
        add(SeasonalsBlocks.PUMPKIN_CAKE.get(), "Pumpkin Cake");
        add(SeasonalsBlocks.SWEET_BERRY_ICE_CREAM_BLOCK.get(), "Sweet Berry Ice Cream Block");
        add(SeasonalsBlocks.SWEET_BERRY_CAKE.get(), "Sweet Berry Cake");

        add(SeasonalsItems.ROASTED_PUMPKIN.get(), "Roasted Pumpkin");
        add(SeasonalsItems.PUMPKIN_FEAST.get(), "Pumpkin Feast");
        add(SeasonalsItems.PUMPKIN_ICE_CREAM.get(), "Pumpkin Ice Cream");
        add(SeasonalsItems.PUMPKIN_MILKSHAKE.get(), "Pumpkin Milkshake");
        add(SeasonalsItems.SWEET_BERRY_ICE_CREAM.get(), "Sweet Berry Ice Cream");
        add(SeasonalsItems.SWEET_BERRY_MILKSHAKE.get(), "Sweet Berry Milkshake");
        add(SeasonalsItems.CHOCOLATE_PUMPKIN_MUFFIN.get(), "Chocolate Pumpkin Muffin");
        add(SeasonalsItems.SWEET_BERRY_VANILLA_YOGURT.get(), "Sweet Berry Vanilla Yogurt");

        add(SeasonalsEffects.FALL_FLAVOR.get(), "Fall Flavor");
        add(SeasonalsEffects.THORN_RESISTANCE.get(), "Thorn Resistance");
    }
}
