package com.cosmicgelatin.seasonals.core.registry;

import com.cosmicgelatin.seasonals.common.item.SeasonalsFlavoredCandleCake;
import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.other.SeasonalsCauldronInteractions;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.neapolitan.common.block.FlavoredCakeBlock;
import com.teamabnormals.neapolitan.common.block.MilkshakeCauldronBlock;
import com.teamabnormals.neapolitan.core.other.NeapolitanCauldronInteractions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = Seasonals.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SeasonalsBlocks {
    public static final BlockSubRegistryHelper HELPER = Seasonals.REGISTRY_HELPER.getBlockSubHelper();

    //PUMPKIN
    public static final RegistryObject<Block> PUMPKIN_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("pumpkin_milkshake_cauldron", () -> new MilkshakeCauldronBlock(SeasonalsCauldronInteractions.PUMPKIN_MILKSHAKE.map()));
    public static final RegistryObject<Block> PUMPKIN_ICE_CREAM_BLOCK = HELPER.createBlock("pumpkin_ice_cream_block", () -> new Block(Properties.PUMPKIN_ICE_CREAM_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> PUMPKIN_CAKE = HELPER.createBlock("pumpkin_cake", () -> new FlavoredCakeBlock(SeasonalsItems.Foods.PUMPKIN_CAKE, Properties.PUMPKIN_CAKE), new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD));
    public static final RegistryObject<Block> PUMPKIN_CANDLE_CAKE = createCandleCakeBlock("pumpkin", false, DyeColor.WHITE, Properties.PUMPKIN_CAKE);
    public static final RegistryObject<Block> WHITE_PUMPKIN_CANDLE_CAKE = createCandleCakeBlock("pumpkin", true, DyeColor.WHITE, Properties.PUMPKIN_CAKE);
    public static final RegistryObject<Block> ORANGE_PUMPKIN_CANDLE_CAKE = createCandleCakeBlock("pumpkin", true, DyeColor.ORANGE, Properties.PUMPKIN_CAKE);
    public static final RegistryObject<Block> MAGENTA_PUMPKIN_CANDLE_CAKE = createCandleCakeBlock("pumpkin", true, DyeColor.MAGENTA, Properties.PUMPKIN_CAKE);
    public static final RegistryObject<Block> LIGHT_BLUE_PUMPKIN_CANDLE_CAKE = createCandleCakeBlock("pumpkin", true, DyeColor.LIGHT_BLUE, Properties.PUMPKIN_CAKE);
    public static final RegistryObject<Block> YELLOW_PUMPKIN_CANDLE_CAKE = createCandleCakeBlock("pumpkin", true, DyeColor.YELLOW, Properties.PUMPKIN_CAKE);
    public static final RegistryObject<Block> LIME_PUMPKIN_CANDLE_CAKE = createCandleCakeBlock("pumpkin", true, DyeColor.LIME, Properties.PUMPKIN_CAKE);
    public static final RegistryObject<Block> PINK_PUMPKIN_CANDLE_CAKE = createCandleCakeBlock("pumpkin", true, DyeColor.PINK, Properties.PUMPKIN_CAKE);
    public static final RegistryObject<Block> GRAY_PUMPKIN_CANDLE_CAKE = createCandleCakeBlock("pumpkin", true, DyeColor.GRAY, Properties.PUMPKIN_CAKE);
    public static final RegistryObject<Block> LIGHT_GRAY_PUMPKIN_CANDLE_CAKE = createCandleCakeBlock("pumpkin", true, DyeColor.LIGHT_GRAY, Properties.PUMPKIN_CAKE);
    public static final RegistryObject<Block> CYAN_PUMPKIN_CANDLE_CAKE = createCandleCakeBlock("pumpkin", true, DyeColor.CYAN, Properties.PUMPKIN_CAKE);
    public static final RegistryObject<Block> PURPLE_PUMPKIN_CANDLE_CAKE = createCandleCakeBlock("pumpkin", true, DyeColor.PURPLE, Properties.PUMPKIN_CAKE);
    public static final RegistryObject<Block> BLUE_PUMPKIN_CANDLE_CAKE = createCandleCakeBlock("pumpkin", true, DyeColor.BLUE, Properties.PUMPKIN_CAKE);
    public static final RegistryObject<Block> BROWN_PUMPKIN_CANDLE_CAKE = createCandleCakeBlock("pumpkin", true, DyeColor.BROWN, Properties.PUMPKIN_CAKE);
    public static final RegistryObject<Block> GREEN_PUMPKIN_CANDLE_CAKE = createCandleCakeBlock("pumpkin", true, DyeColor.GREEN, Properties.PUMPKIN_CAKE);
    public static final RegistryObject<Block> RED_PUMPKIN_CANDLE_CAKE = createCandleCakeBlock("pumpkin", true, DyeColor.RED, Properties.PUMPKIN_CAKE);
    public static final RegistryObject<Block> BLACK_PUMPKIN_CANDLE_CAKE = createCandleCakeBlock("pumpkin", true, DyeColor.BLACK, Properties.PUMPKIN_CAKE);

    //SWEET BERRY
    public static final RegistryObject<Block> SWEET_BERRY_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("sweet_berry_milkshake_cauldron", () -> new MilkshakeCauldronBlock(SeasonalsCauldronInteractions.SWEET_BERRY_MILKSHAKE.map()));
    public static final RegistryObject<Block> SWEET_BERRY_ICE_CREAM_BLOCK = HELPER.createBlock("sweet_berry_ice_cream_block", () -> new Block(Properties.SWEET_BERRY_ICE_CREAM_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SWEET_BERRY_CAKE = HELPER.createBlock("sweet_berry_cake", () -> new FlavoredCakeBlock(SeasonalsItems.Foods.SWEET_BERRY_CAKE, Properties.SWEET_BERRY_CAKE), new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD));
    public static final RegistryObject<Block> SWEET_BERRY_CANDLE_CAKE = createCandleCakeBlock("sweet_berry", false, DyeColor.WHITE, Properties.SWEET_BERRY_CAKE);
    public static final RegistryObject<Block> WHITE_SWEET_BERRY_CANDLE_CAKE = createCandleCakeBlock("sweet_berry", true, DyeColor.WHITE, Properties.SWEET_BERRY_CAKE);
    public static final RegistryObject<Block> ORANGE_SWEET_BERRY_CANDLE_CAKE = createCandleCakeBlock("sweet_berry", true, DyeColor.ORANGE, Properties.SWEET_BERRY_CAKE);
    public static final RegistryObject<Block> MAGENTA_SWEET_BERRY_CANDLE_CAKE = createCandleCakeBlock("sweet_berry", true, DyeColor.MAGENTA, Properties.SWEET_BERRY_CAKE);
    public static final RegistryObject<Block> LIGHT_BLUE_SWEET_BERRY_CANDLE_CAKE = createCandleCakeBlock("sweet_berry", true, DyeColor.LIGHT_BLUE, Properties.SWEET_BERRY_CAKE);
    public static final RegistryObject<Block> YELLOW_SWEET_BERRY_CANDLE_CAKE = createCandleCakeBlock("sweet_berry", true, DyeColor.YELLOW, Properties.SWEET_BERRY_CAKE);
    public static final RegistryObject<Block> LIME_SWEET_BERRY_CANDLE_CAKE = createCandleCakeBlock("sweet_berry", true, DyeColor.LIME, Properties.SWEET_BERRY_CAKE);
    public static final RegistryObject<Block> PINK_SWEET_BERRY_CANDLE_CAKE = createCandleCakeBlock("sweet_berry", true, DyeColor.PINK, Properties.SWEET_BERRY_CAKE);
    public static final RegistryObject<Block> GRAY_SWEET_BERRY_CANDLE_CAKE = createCandleCakeBlock("sweet_berry", true, DyeColor.GRAY, Properties.SWEET_BERRY_CAKE);
    public static final RegistryObject<Block> LIGHT_GRAY_SWEET_BERRY_CANDLE_CAKE = createCandleCakeBlock("sweet_berry", true, DyeColor.LIGHT_GRAY, Properties.SWEET_BERRY_CAKE);
    public static final RegistryObject<Block> CYAN_SWEET_BERRY_CANDLE_CAKE = createCandleCakeBlock("sweet_berry", true, DyeColor.CYAN, Properties.SWEET_BERRY_CAKE);
    public static final RegistryObject<Block> PURPLE_SWEET_BERRY_CANDLE_CAKE = createCandleCakeBlock("sweet_berry", true, DyeColor.PURPLE, Properties.SWEET_BERRY_CAKE);
    public static final RegistryObject<Block> BLUE_SWEET_BERRY_CANDLE_CAKE = createCandleCakeBlock("sweet_berry", true, DyeColor.BLUE, Properties.SWEET_BERRY_CAKE);
    public static final RegistryObject<Block> BROWN_SWEET_BERRY_CANDLE_CAKE = createCandleCakeBlock("sweet_berry", true, DyeColor.BROWN, Properties.SWEET_BERRY_CAKE);
    public static final RegistryObject<Block> GREEN_SWEET_BERRY_CANDLE_CAKE = createCandleCakeBlock("sweet_berry", true, DyeColor.GREEN, Properties.SWEET_BERRY_CAKE);
    public static final RegistryObject<Block> RED_SWEET_BERRY_CANDLE_CAKE = createCandleCakeBlock("sweet_berry", true, DyeColor.RED, Properties.SWEET_BERRY_CAKE);
    public static final RegistryObject<Block> BLACK_SWEET_BERRY_CANDLE_CAKE = createCandleCakeBlock("sweet_berry", true, DyeColor.BLACK, Properties.SWEET_BERRY_CAKE);

    //BEETROOT
    public static final RegistryObject<Block> BEETROOT_MILKSHAKE_CAULDRON = HELPER.createBlockNoItem("beetroot_milkshake_cauldron", () -> new MilkshakeCauldronBlock(SeasonalsCauldronInteractions.BEETROOT_MILKSHAKE.map()));
    public static final RegistryObject<Block> BEETROOT_ICE_CREAM_BLOCK = HELPER.createBlock("beetroot_ice_cream_block", () -> new Block(Properties.BEETROOT_ICE_CREAM_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BEETROOT_CAKE = HELPER.createBlock("beetroot_cake", () -> new FlavoredCakeBlock(SeasonalsItems.Foods.BEETROOT_CAKE, Properties.BEETROOT_CAKE), new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_FOOD));
    public static final RegistryObject<Block> BEETROOT_CANDLE_CAKE = createCandleCakeBlock("beetroot", false, DyeColor.WHITE, Properties.BEETROOT_CAKE);
    public static final RegistryObject<Block> WHITE_BEETROOT_CANDLE_CAKE = createCandleCakeBlock("beetroot", true, DyeColor.WHITE, Properties.BEETROOT_CAKE);
    public static final RegistryObject<Block> ORANGE_BEETROOT_CANDLE_CAKE = createCandleCakeBlock("beetroot", true, DyeColor.ORANGE, Properties.BEETROOT_CAKE);
    public static final RegistryObject<Block> MAGENTA_BEETROOT_CANDLE_CAKE = createCandleCakeBlock("beetroot", true, DyeColor.MAGENTA, Properties.BEETROOT_CAKE);
    public static final RegistryObject<Block> LIGHT_BLUE_BEETROOT_CANDLE_CAKE = createCandleCakeBlock("beetroot", true, DyeColor.LIGHT_BLUE, Properties.BEETROOT_CAKE);
    public static final RegistryObject<Block> YELLOW_BEETROOT_CANDLE_CAKE = createCandleCakeBlock("beetroot", true, DyeColor.YELLOW, Properties.BEETROOT_CAKE);
    public static final RegistryObject<Block> LIME_BEETROOT_CANDLE_CAKE = createCandleCakeBlock("beetroot", true, DyeColor.LIME, Properties.BEETROOT_CAKE);
    public static final RegistryObject<Block> PINK_BEETROOT_CANDLE_CAKE = createCandleCakeBlock("beetroot", true, DyeColor.PINK, Properties.BEETROOT_CAKE);
    public static final RegistryObject<Block> GRAY_BEETROOT_CANDLE_CAKE = createCandleCakeBlock("beetroot", true, DyeColor.GRAY, Properties.BEETROOT_CAKE);
    public static final RegistryObject<Block> LIGHT_GRAY_BEETROOT_CANDLE_CAKE = createCandleCakeBlock("beetroot", true, DyeColor.LIGHT_GRAY, Properties.BEETROOT_CAKE);
    public static final RegistryObject<Block> CYAN_BEETROOT_CANDLE_CAKE = createCandleCakeBlock("beetroot", true, DyeColor.CYAN, Properties.BEETROOT_CAKE);
    public static final RegistryObject<Block> PURPLE_BEETROOT_CANDLE_CAKE = createCandleCakeBlock("beetroot", true, DyeColor.PURPLE, Properties.BEETROOT_CAKE);
    public static final RegistryObject<Block> BLUE_BEETROOT_CANDLE_CAKE = createCandleCakeBlock("beetroot", true, DyeColor.BLUE, Properties.BEETROOT_CAKE);
    public static final RegistryObject<Block> BROWN_BEETROOT_CANDLE_CAKE = createCandleCakeBlock("beetroot", true, DyeColor.BROWN, Properties.BEETROOT_CAKE);
    public static final RegistryObject<Block> GREEN_BEETROOT_CANDLE_CAKE = createCandleCakeBlock("beetroot", true, DyeColor.GREEN, Properties.BEETROOT_CAKE);
    public static final RegistryObject<Block> RED_BEETROOT_CANDLE_CAKE = createCandleCakeBlock("beetroot", true, DyeColor.RED, Properties.BEETROOT_CAKE);
    public static final RegistryObject<Block> BLACK_BEETROOT_CANDLE_CAKE = createCandleCakeBlock("beetroot", true, DyeColor.BLACK, Properties.BEETROOT_CAKE);

    public static RegistryObject<Block> createCandleCakeBlock(String flavor, boolean isColored, DyeColor color, BlockBehaviour.Properties properties) {
        String regName = isColored ? color + "_" + flavor + "_candle_cake" : flavor + "_candle_cake";
        String candleName = isColored ? color + "_candle" : "candle";
        return HELPER.createBlockNoItem(regName, () -> new SeasonalsFlavoredCandleCake(() -> getBlock(Seasonals.MODID, flavor + "_cake"), getBlock("minecraft", candleName), properties));
    }

    public static Block getBlock(String modId, String id) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(modId, id));
    }

    static class Properties {
        public static final Block.Properties PUMPKIN_ICE_CREAM_BLOCK = Block.Properties.of(Material.SNOW, MaterialColor.TERRACOTTA_YELLOW).requiresCorrectToolForDrops().strength(0.2F).sound(SoundType.SNOW);
        public static final Block.Properties PUMPKIN_CAKE = Block.Properties.of(Material.CAKE, MaterialColor.TERRACOTTA_ORANGE).strength(0.5F).sound(SoundType.WOOL);

        public static final Block.Properties SWEET_BERRY_ICE_CREAM_BLOCK = Block.Properties.of(Material.SNOW, MaterialColor.COLOR_MAGENTA).requiresCorrectToolForDrops().strength(0.2F).sound(SoundType.SNOW);
        public static final Block.Properties SWEET_BERRY_CAKE = Block.Properties.of(Material.CAKE, MaterialColor.TERRACOTTA_RED).strength(0.5F).sound(SoundType.WOOL);

        public static final Block.Properties BEETROOT_ICE_CREAM_BLOCK = Block.Properties.of(Material.SNOW, MaterialColor.COLOR_RED).requiresCorrectToolForDrops().strength(0.2F).sound(SoundType.SNOW);
        public static final Block.Properties BEETROOT_CAKE = Block.Properties.of(Material.CAKE, MaterialColor.COLOR_RED).strength(0.5F).sound(SoundType.WOOL);

    }
}
