package com.cosmicgelatin.seasonals.core.data;

import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.SeasonalsConfig;
import com.google.common.collect.Maps;
import com.teamabnormals.blueprint.core.api.conditions.ConfigValueCondition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Copied from the Original SMDatagenUtil in SullysMod, taken with permission
 * @author Uraneptus
 *
 */
public class SeasonalsDatagenUtil {
    public static final String LAYER0 = "layer0";
    public static final String GENERATED = "item/generated";
    public static final String HANDHELD = "item/handheld";
    public static final String PUMPKIN = "pumpkin/";
    public static final String SWEET_BERRY = "sweet_berry/";

    public static String name(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    public static String name(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }

    public static ResourceLocation modBlockLocation(String path) {
        return Seasonals.modPrefix(ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    public static ResourceLocation modItemLocation(String path) {
        return Seasonals.modPrefix(ModelProvider.ITEM_FOLDER + "/" + path);
    }

    public static ResourceLocation vanillaBlockLocation(String path) {
        return new ResourceLocation(ModelProvider.BLOCK_FOLDER + "/" + path);
    }

    public static ResourceLocation vanillaItemLocation(String path) {
        return new ResourceLocation(ModelProvider.ITEM_FOLDER + "/" + path);
    }

    public static ConfigValueCondition outsideRecipeConfig() {
        return configCondition(SeasonalsConfig.COMMON.outsideRecipes, "outside_recipes", false);
    }

    private static ConfigValueCondition configCondition(ForgeConfigSpec.ConfigValue<?> value, String key, boolean inverted) {
        return new ConfigValueCondition(Seasonals.modPrefix("config"), value, key, Maps.newHashMap(), inverted);
    }

}
