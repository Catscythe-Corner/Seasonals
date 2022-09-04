package com.cosmicgelatin.seasonals.core;

import com.cosmicgelatin.seasonals.core.data.client.SeasonalsBlockStateProvider;
import com.cosmicgelatin.seasonals.core.data.client.SeasonalsItemModelProvider;
import com.cosmicgelatin.seasonals.core.data.client.SeasonalsLangProvider;
import com.cosmicgelatin.seasonals.core.data.server.SeasonalsLootTableProvider;
import com.cosmicgelatin.seasonals.core.data.server.modifier.SeasonalsAdvancementModifierProvider;
import com.cosmicgelatin.seasonals.core.data.server.tags.SeasonalsBlockTagsProvider;
import com.cosmicgelatin.seasonals.core.other.SeasonalsCompat;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsEffects;
import com.teamabnormals.blueprint.core.util.DataUtil;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Seasonals.MODID)
@Mod.EventBusSubscriber(modid = Seasonals.MODID)
public class Seasonals {
    public static final String MODID = "seasonals";

    public static ResourceLocation modPrefix(String path) {
        return new ResourceLocation(Seasonals.MODID, path);
    }
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

        modEventBus.addListener(this::setupCommon);
        modEventBus.addListener(this::gatherData);
    }

    private void setupCommon(final FMLCommonSetupEvent event) {
        event.enqueueWork(SeasonalsCompat::registerCompostables);
    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        if (event.includeClient()) {
            generator.addProvider(new SeasonalsBlockStateProvider(generator, fileHelper));
            generator.addProvider(new SeasonalsItemModelProvider(generator, fileHelper));
            generator.addProvider(new SeasonalsLangProvider(generator));
        }
        if (event.includeServer()) {
            generator.addProvider(new SeasonalsLootTableProvider(generator));
            generator.addProvider(new SeasonalsBlockTagsProvider(generator, fileHelper));
            generator.addProvider(new SeasonalsAdvancementModifierProvider(generator));
        }
    }
}