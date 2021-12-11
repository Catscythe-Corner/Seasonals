package com.cosmicgelatin.seasonals.core.registry;

import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import com.cosmicgelatin.seasonals.core.Seasonals;
import com.minecraftabnormals.neapolitan.common.block.FlavoredCakeBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Seasonals.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SeasonalsBlocks {
    public static final BlockSubRegistryHelper HELPER = Seasonals.REGISTRY_HELPER.getBlockSubHelper();

    public static final RegistryObject<Block> PUMPKIN_ICE_CREAM_BLOCK = HELPER.createBlock("pumpkin_ice_cream_block", () -> new Block(Properties.PUMPKIN_ICE_CREAM_BLOCK), ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> PUMPKIN_CAKE = HELPER.createBlockNoItem("pumpkin_cake", () -> new FlavoredCakeBlock(SeasonalsItems.Foods.PUMPKIN_CAKE, null, Properties.PUMPKIN_CAKE));

    public static final RegistryObject<Block> SWEET_BERRY_ICE_CREAM_BLOCK = HELPER.createBlock("sweet_berry_ice_cream_block", () -> new Block(Properties.SWEET_BERRY_ICE_CREAM_BLOCK), ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SWEET_BERRY_CAKE = HELPER.createBlockNoItem("sweet_berry_cake", () -> new FlavoredCakeBlock(SeasonalsItems.Foods.SWEET_BERRY_CAKE, null, Properties.SWEET_BERRY_CAKE));


    static class Properties {
        public static final AbstractBlock.Properties PUMPKIN_ICE_CREAM_BLOCK = AbstractBlock.Properties.of(Material.SNOW, MaterialColor.TERRACOTTA_YELLOW).harvestTool(ToolType.SHOVEL).strength(0.2F).sound(SoundType.SNOW);
        public static final AbstractBlock.Properties PUMPKIN_CAKE = AbstractBlock.Properties.of(Material.CAKE, MaterialColor.TERRACOTTA_ORANGE).strength(0.5F).sound(SoundType.WOOL);

        public static final AbstractBlock.Properties SWEET_BERRY_ICE_CREAM_BLOCK = AbstractBlock.Properties.of(Material.SNOW, MaterialColor.COLOR_MAGENTA).harvestTool(ToolType.SHOVEL).strength(0.2F).sound(SoundType.SNOW);
        public static final AbstractBlock.Properties SWEET_BERRY_CAKE = AbstractBlock.Properties.of(Material.CAKE, MaterialColor.TERRACOTTA_RED).strength(0.5F).sound(SoundType.WOOL);

    }
}
