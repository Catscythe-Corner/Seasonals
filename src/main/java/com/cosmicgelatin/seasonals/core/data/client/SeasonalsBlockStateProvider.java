package com.cosmicgelatin.seasonals.core.data.client;

import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

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
}
