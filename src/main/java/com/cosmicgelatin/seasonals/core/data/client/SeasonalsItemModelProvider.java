package com.cosmicgelatin.seasonals.core.data.client;

import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsBlocks;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

import static com.cosmicgelatin.seasonals.core.data.SeasonalsDatagenUtil.*;

public class SeasonalsItemModelProvider extends ItemModelProvider {

    public SeasonalsItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Seasonals.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicBlockItem(SeasonalsBlocks.PUMPKIN_ICE_CREAM_BLOCK);
        basicBlockItem(SeasonalsBlocks.SWEET_BERRY_ICE_CREAM_BLOCK);
        basicItem(SeasonalsItems.ROASTED_PUMPKIN);
        basicItem(SeasonalsItems.PUMPKIN_FEAST);
        basicItem(SeasonalsItems.PUMPKIN_ICE_CREAM);
        basicItem(SeasonalsItems.PUMPKIN_MILKSHAKE);
        basicItem(SeasonalsItems.PUMPKIN_CAKE);
        basicItem(SeasonalsItems.SWEET_BERRY_ICE_CREAM);
        basicItem(SeasonalsItems.SWEET_BERRY_MILKSHAKE);
        basicItem(SeasonalsItems.SWEET_BERRY_CAKE);
        basicItem(SeasonalsItems.CHOCOLATE_PUMPKIN_MUFFIN);
        basicItem(SeasonalsItems.SWEET_BERRY_VANILLA_YOGURT);
    }

    private void basicItem(Supplier<? extends Item> item) {
        basicItem(item.get());
    }

    private void basicBlockItem(Supplier<? extends Block> blockForItem) {
        withExistingParent(name(blockForItem.get()), modBlockLocation(name(blockForItem.get())));
    }
}
