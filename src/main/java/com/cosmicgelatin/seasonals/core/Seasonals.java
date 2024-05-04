package com.cosmicgelatin.seasonals.core;

import com.cosmicgelatin.seasonals.core.data.client.SeasonalsBlockStateProvider;
import com.cosmicgelatin.seasonals.core.data.client.SeasonalsItemModelProvider;
import com.cosmicgelatin.seasonals.core.data.client.SeasonalsLangProvider;
import com.cosmicgelatin.seasonals.core.data.server.loot.SeasonalsLootTableProvider;
import com.cosmicgelatin.seasonals.core.data.server.SeasonalsRecipeProvider;
import com.cosmicgelatin.seasonals.core.data.server.modifier.SeasonalsAdvancementModifierProvider;
import com.cosmicgelatin.seasonals.core.data.server.modifier.SeasonalsLootModifierProvider;
import com.cosmicgelatin.seasonals.core.data.server.tags.SeasonalsBlockTagsProvider;
import com.cosmicgelatin.seasonals.core.data.server.tags.SeasonalsDamageTypeTagsProvider;
import com.cosmicgelatin.seasonals.core.data.server.tags.SeasonalsItemTagsProvider;
import com.cosmicgelatin.seasonals.core.other.SeasonalsCauldronInteractions;
import com.cosmicgelatin.seasonals.core.other.SeasonalsCompat;
import com.cosmicgelatin.seasonals.core.other.SeasonalsCreativeModTabContents;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsLootConditions;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsMobEffects;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.concurrent.CompletableFuture;

@Mod(Seasonals.MODID)
@Mod.EventBusSubscriber(modid = Seasonals.MODID)
public class Seasonals {
    public static final String MODID = "seasonals";
    public static ResourceLocation modPrefix(String path) {
        return new ResourceLocation(Seasonals.MODID, path);
    }
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);

    public Seasonals() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        REGISTRY_HELPER.register(modEventBus);

        SeasonalsMobEffects.EFFECTS.register(modEventBus);
        SeasonalsLootConditions.LOOT_ITEM_CONDITION_TYPE.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SeasonalsConfig.COMMON_SPEC);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> SeasonalsCreativeModTabContents::buildSeasonalsCreativeTabContents);
        if (ModIntegration.isFDLoaded()) {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> SeasonalsCreativeModTabContents::buildFDCreativeTabContents);
        }

        modEventBus.addListener(this::setupCommon);
        modEventBus.addListener(this::gatherData);
    }

    private void setupCommon(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
           SeasonalsCompat.registerCompostables();
           SeasonalsCauldronInteractions.registerCauldronInteractions();
        });
    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        boolean includeClient = event.includeClient();
        boolean includeServer = event.includeServer();
        DataGenerator generator = event.getGenerator();
        PackOutput output = event.getGenerator().getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(includeClient, new SeasonalsBlockStateProvider(output, fileHelper));
        generator.addProvider(includeClient, new SeasonalsItemModelProvider(output, fileHelper));
        generator.addProvider(includeClient, new SeasonalsLangProvider(output));

        generator.addProvider(includeServer, new SeasonalsLootTableProvider(output));
        SeasonalsBlockTagsProvider blockTagsProvider = new SeasonalsBlockTagsProvider(output, lookupProvider, fileHelper);
        generator.addProvider(includeServer, blockTagsProvider);
        generator.addProvider(includeServer, new SeasonalsItemTagsProvider(output, lookupProvider, blockTagsProvider.contentsGetter(), fileHelper));
        generator.addProvider(includeServer, new SeasonalsDamageTypeTagsProvider(output, lookupProvider, fileHelper));
        generator.addProvider(includeServer, new SeasonalsAdvancementModifierProvider(output, lookupProvider));
        generator.addProvider(includeServer, new SeasonalsLootModifierProvider(output, lookupProvider));
        generator.addProvider(includeServer, new SeasonalsRecipeProvider(output));

    }
}