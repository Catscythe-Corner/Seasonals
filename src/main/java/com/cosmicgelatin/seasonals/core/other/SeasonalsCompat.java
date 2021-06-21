package com.cosmicgelatin.seasonals.core.other;

import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import com.minecraftabnormals.abnormals_core.core.util.DataUtil;

public class SeasonalsCompat {

    public static void registerCompostables() {
        DataUtil.registerCompostable(SeasonalsItems.ROASTED_PUMPKIN.get(), 0.65F);
        DataUtil.registerCompostable(SeasonalsItems.CHOCOLATE_PUMPKIN_MUFFIN.get(), 0.3F);
        DataUtil.registerCompostable(SeasonalsItems.PUMPKIN_CAKE.get(), 1.0F);
        DataUtil.registerCompostable(SeasonalsItems.SWEET_BERRY_CAKE.get(), 1.0F);
    }
}
