package com.cosmicgelatin.seasonals.core.data.client;

import com.cosmicgelatin.seasonals.common.item.SeasonalsFlavoredCandleCake;
import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsBlocks;
import com.teamabnormals.neapolitan.common.block.FlavoredCandleCakeBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.cosmicgelatin.seasonals.core.data.SeasonalsDatagenUtil.*;

public class SeasonalsBlockStateProvider extends BlockStateProvider {

    public SeasonalsBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Seasonals.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        basicBlock(SeasonalsBlocks.PUMPKIN_ICE_CREAM_BLOCK);
        basicBlock(SeasonalsBlocks.SWEET_BERRY_ICE_CREAM_BLOCK);
        basicBlock(SeasonalsBlocks.BEETROOT_ICE_CREAM_BLOCK);
        modCakeBlock(SeasonalsBlocks.PUMPKIN_CAKE);
        modCakeBlock(SeasonalsBlocks.SWEET_BERRY_CAKE);
        modCakeBlock(SeasonalsBlocks.BEETROOT_CAKE);

        SeasonalsFlavoredCandleCake.getCandleCakes().forEach((block -> this.candleCake((FlavoredCandleCakeBlock) block)));
    }

    private void basicBlock(Supplier<? extends Block> block) {
        simpleBlock(block.get());
    }

    private void modCakeBlock(Supplier<? extends Block> block) {
        getVariantBuilder(block.get()).forAllStates(blockState -> {
            int bites = blockState.getValue(BlockStateProperties.BITES);
            String slices = "";

            for (int i = 0; i < bites; i++) {
                slices = "_slice" + bites;
            }

            String suffix = bites > 0 ? slices : "";
            String parentName = bites > 0 ? "cake" + slices : "cake";

            ModelFile modelFile = models().withExistingParent(name(block.get()) + suffix, vanillaBlockLocation(parentName))
                    .texture("particle", modBlockLocation(name(block.get()) + "_side"))
                    .texture("bottom", modBlockLocation(name(block.get()) + "_bottom"))
                    .texture("top", modBlockLocation(name(block.get()) + "_top"))
                    .texture("side", modBlockLocation(name(block.get()) + "_side"))
                    .texture("inside", modBlockLocation(name(block.get()) + "_inner"));
            return ConfiguredModel.builder().modelFile(modelFile).build();

        });
    }

    public void candleCake(FlavoredCandleCakeBlock block) {
        Block candle = block.getCandle();
        Block cake = block.getCake();

        ModelFile candleCake = models().withExistingParent(name(block), "block/template_cake_with_candle")
                .texture("candle", blockTexture(candle))
                .texture("bottom", modBlockLocation(name(cake) + "_bottom"))
                .texture("side", modBlockLocation(name(cake) + "_side"))
                .texture("top", modBlockLocation(name(cake) + "_top"))
                .texture("particle", modBlockLocation(name(cake) + "_side"));

        ModelFile candleCakeLit = models().withExistingParent(name(block) + "_lit", "block/template_cake_with_candle")
                .texture("candle", vanillaBlockLocation(name(candle) + "_lit"))
                .texture("bottom", modBlockLocation(name(cake) + "_bottom"))
                .texture("side", modBlockLocation(name(cake) + "_side"))
                .texture("top", modBlockLocation(name(cake) + "_top"))
                .texture("particle", modBlockLocation(name(cake) + "_side"));

        this.candleCakeBlock(block, (state -> state.getValue(BlockStateProperties.LIT) ? candleCakeLit : candleCake));
    }

    public void candleCakeBlock(Block block, Function<BlockState, ModelFile> modelFunc) {
        this.getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(modelFunc.apply(state)).build());
    }
}
