package com.cosmicgelatin.seasonals.core.data;

import com.cosmicgelatin.seasonals.core.Seasonals;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ModelProvider;

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
        return block.getRegistryName().getPath();
    }

    public static String name(Item item) {
        return item.getRegistryName().getPath();
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

    public static ResourceLocation craftingPath(String name) {
        return Seasonals.modPrefix("crafting/" + name);
    }

    public static ResourceLocation smeltingPath(String name) {
        return Seasonals.modPrefix("smelting/" + name);
    }

    public static ResourceLocation blastingPath(String name) {
        return Seasonals.modPrefix("blasting/" + name);
    }

    public static ResourceLocation smokingPath(String name) {
        return Seasonals.modPrefix("smoking/" + name);
    }

    public static ResourceLocation campfire_cookingPath(String name) {
        return Seasonals.modPrefix("campfire_cooking/" + name);
    }

    public static ResourceLocation stonecuttingPath(String name) {
        return Seasonals.modPrefix("stonecutting/" + name);
    }

    public static ResourceLocation smithingPath(String name) {
        return Seasonals.modPrefix("smithing/" + name);
    }

    //Textures
}
