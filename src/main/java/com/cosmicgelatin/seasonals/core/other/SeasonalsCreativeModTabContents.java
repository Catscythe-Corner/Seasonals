package com.cosmicgelatin.seasonals.core.other;

import com.cosmicgelatin.seasonals.core.ModIntegration;
import com.cosmicgelatin.seasonals.core.Seasonals;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.crafting.Ingredient;

import static com.cosmicgelatin.seasonals.core.registry.SeasonalsBlocks.*;
import static com.cosmicgelatin.seasonals.core.registry.SeasonalsItems.*;

public class SeasonalsCreativeModTabContents {

    public static void buildSeasonalsCreativeTabContents() {
        CreativeModeTabContentsPopulator.mod(Seasonals.MODID)
                .tab(CreativeModeTabs.FOOD_AND_DRINKS)
                .addItems(
                        PUMPKIN_PUREE, PUMPKIN_MILKSHAKE, PUMPKIN_ICE_CREAM, PUMPKIN_CAKE,
                        CHOCOLATE_PUMPKIN_MUFFIN, PUMPKIN_ADZUKI_STEW, SWEET_BERRY_ICE_CREAM,
                        SWEET_BERRY_MILKSHAKE, GLAZED_SWEET_BERRIES, SWEET_BERRY_CAKE,
                        SWEET_BERRY_VANILLA_YOGURT, BEETROOT_MILKSHAKE, BEETROOT_ICE_CREAM, BEETROOT_CAKE,
                        ROASTED_BEETROOT, OXIDIZED_BEETROOT, RABBIT_ROAST, MIXED_BERRY_MUFFIN,
                        RED_VELVET_CUPCAKE, BANANA_SPLIT_SUNDAE
                )
                .tab(CreativeModeTabs.BUILDING_BLOCKS)
                .addItems(
                        PUMPKIN_ICE_CREAM_BLOCK, SWEET_BERRY_ICE_CREAM_BLOCK, BEETROOT_ICE_CREAM_BLOCK
                )
        ;
    }

    public static void buildFDCreativeTabContents() {
        CreativeModeTabContentsPopulator.mod(ModIntegration.FARMERSDELIGHT_ID)
                .tab(ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(ModIntegration.FARMERSDELIGHT_ID, ModIntegration.FARMERSDELIGHT_ID)))
                .addItems(
                        PUMPKIN_ICE_CREAM_BLOCK, SWEET_BERRY_ICE_CREAM_BLOCK, BEETROOT_ICE_CREAM_BLOCK
                )
        ;
    }
}
