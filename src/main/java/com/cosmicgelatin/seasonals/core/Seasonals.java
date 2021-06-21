package com.cosmicgelatin.seasonals.core;

import com.cosmicgelatin.seasonals.core.other.SeasonalsCompat;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsEffects;
import com.minecraftabnormals.abnormals_core.core.util.DataUtil;
import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Seasonals.MODID)
@Mod.EventBusSubscriber(modid = Seasonals.MODID)
public class Seasonals {
    public static final String MODID = "seasonals";
    public static boolean BERRY_GOOD;
    public static boolean ATMOSPHERIC;
    public static boolean AUTUMNITY;

    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);

    public Seasonals() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        BERRY_GOOD = ModList.get().isLoaded("berry_good");
        ATMOSPHERIC = ModList.get().isLoaded("atmospheric");
        AUTUMNITY = ModList.get().isLoaded("autumnity");

        REGISTRY_HELPER.register(modEventBus);

        SeasonalsEffects.EFFECTS.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SeasonalsConfig.COMMON_SPEC);
        DataUtil.registerConfigCondition(Seasonals.MODID, SeasonalsConfig.COMMON);

        modEventBus.addListener(this::setupCommon);
    }

    private void setupCommon(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SeasonalsCompat.registerCompostables();
        });
    }
}