package com.cosmicgelatin.seasonals.common.item;

import com.teamabnormals.neapolitan.common.block.FlavoredCandleCakeBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SeasonalsFlavoredCandleCake extends FlavoredCandleCakeBlock {

    public SeasonalsFlavoredCandleCake(Supplier<Block> baseCake, Block candle, Properties properties) {
        super(baseCake, candle, properties);
    }

    public static Iterable<Block> getCandleCakes() {
        return ForgeRegistries.BLOCKS.getValues().stream().filter((block) -> {
            return ForgeRegistries.BLOCKS.getKey(block) != null && "seasonals".equals(ForgeRegistries.BLOCKS.getKey(block).getNamespace()) && block instanceof FlavoredCandleCakeBlock;
        }).collect(Collectors.toList());
    }
}
