package com.cosmicgelatin.seasonals.core.other;

import com.cosmicgelatin.seasonals.core.registry.SeasonalsBlocks;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import com.teamabnormals.blueprint.core.util.DataUtil;

public class SeasonalsCompat {

    public static void registerCompostables() {
        DataUtil.registerCompostable(SeasonalsItems.PUMPKIN_PUREE.get(), 0.65F);
        DataUtil.registerCompostable(SeasonalsItems.CHOCOLATE_PUMPKIN_MUFFIN.get(), 0.3F);
        DataUtil.registerCompostable(SeasonalsBlocks.PUMPKIN_CAKE.get(), 1.0F);
        DataUtil.registerCompostable(SeasonalsBlocks.SWEET_BERRY_CAKE.get(), 1.0F);
    }
}
