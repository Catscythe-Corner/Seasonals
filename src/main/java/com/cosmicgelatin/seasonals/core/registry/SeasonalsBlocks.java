package com.cosmicgelatin.seasonals.core.registry;

import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.cosmicgelatin.seasonals.core.Seasonals;
import com.teamabnormals.neapolitan.common.block.FlavoredCakeBlock;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.common.Mod;
//Todo Datagen
@Mod.EventBusSubscriber(modid = Seasonals.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SeasonalsBlocks {
    public static final BlockSubRegistryHelper HELPER = Seasonals.REGISTRY_HELPER.getBlockSubHelper();

    public static final RegistryObject<Block> PUMPKIN_ICE_CREAM_BLOCK = HELPER.createBlock("pumpkin_ice_cream_block", () -> new Block(Properties.PUMPKIN_ICE_CREAM_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> PUMPKIN_CAKE = HELPER.createBlockNoItem("pumpkin_cake", () -> new FlavoredCakeBlock(SeasonalsItems.Foods.PUMPKIN_CAKE, Properties.PUMPKIN_CAKE));

    public static final RegistryObject<Block> SWEET_BERRY_ICE_CREAM_BLOCK = HELPER.createBlock("sweet_berry_ice_cream_block", () -> new Block(Properties.SWEET_BERRY_ICE_CREAM_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SWEET_BERRY_CAKE = HELPER.createBlockNoItem("sweet_berry_cake", () -> new FlavoredCakeBlock(SeasonalsItems.Foods.SWEET_BERRY_CAKE, Properties.SWEET_BERRY_CAKE));


    static class Properties {
        public static final Block.Properties PUMPKIN_ICE_CREAM_BLOCK = Block.Properties.of(Material.SNOW, MaterialColor.TERRACOTTA_YELLOW).requiresCorrectToolForDrops().strength(0.2F).sound(SoundType.SNOW);//Todo Requires Shovel
        public static final Block.Properties PUMPKIN_CAKE = Block.Properties.of(Material.CAKE, MaterialColor.TERRACOTTA_ORANGE).strength(0.5F).sound(SoundType.WOOL);

        public static final Block.Properties SWEET_BERRY_ICE_CREAM_BLOCK = Block.Properties.of(Material.SNOW, MaterialColor.COLOR_MAGENTA).requiresCorrectToolForDrops().strength(0.2F).sound(SoundType.SNOW);//Todo Requires Shovel
        public static final Block.Properties SWEET_BERRY_CAKE = Block.Properties.of(Material.CAKE, MaterialColor.TERRACOTTA_RED).strength(0.5F).sound(SoundType.WOOL);

    }
}
