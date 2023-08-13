package com.cosmicgelatin.seasonals.core;

import net.minecraftforge.fml.ModList;

public class ModIntegration {
    public static final String FARMERSDELIGHT_ID = "farmersdelight";
    public static final String BERRY_GOOD_ID = "berry_good";
    public static final String ATMOSPHERIC_ID = "atmospheric";
    public static final String AUTUMNITY_ID = "autumnity";
    public static boolean isFDLoaded() {
        return ModList.get().isLoaded(FARMERSDELIGHT_ID);
    }
    public static boolean isBerryGoodLoaded() {
        return ModList.get().isLoaded(BERRY_GOOD_ID);
    }
    public static boolean isAtmosphericLoaded() {
        return ModList.get().isLoaded(ATMOSPHERIC_ID);
    }
    public static boolean isAutumnityLoaded() {
        return ModList.get().isLoaded(AUTUMNITY_ID);
    }
}
