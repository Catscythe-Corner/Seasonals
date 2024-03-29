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
        basicBlockItem(SeasonalsBlocks.BEETROOT_ICE_CREAM_BLOCK);
        generatedBlockItemWithItemTexture(SeasonalsBlocks.PUMPKIN_CAKE);
        generatedBlockItemWithItemTexture(SeasonalsBlocks.SWEET_BERRY_CAKE);
        generatedBlockItemWithItemTexture(SeasonalsBlocks.BEETROOT_CAKE);
        basicItem(SeasonalsItems.PUMPKIN_PUREE);
        basicItem(SeasonalsItems.RABBIT_ROAST);
        basicItem(SeasonalsItems.PUMPKIN_ICE_CREAM);
        basicItem(SeasonalsItems.PUMPKIN_MILKSHAKE);
        basicItem(SeasonalsItems.SWEET_BERRY_ICE_CREAM);
        basicItem(SeasonalsItems.SWEET_BERRY_MILKSHAKE);
        basicItem(SeasonalsItems.CHOCOLATE_PUMPKIN_MUFFIN);
        basicItem(SeasonalsItems.SWEET_BERRY_VANILLA_YOGURT);
        basicItem(SeasonalsItems.GLAZED_SWEET_BERRIES);
        basicItem(SeasonalsItems.MIXED_BERRY_MUFFIN);
        basicItem(SeasonalsItems.PUMPKIN_ADZUKI_STEW);
        basicItem(SeasonalsItems.BANANA_SPLIT_SUNDAE);
        basicItem(SeasonalsItems.BEETROOT_ICE_CREAM);
        basicItem(SeasonalsItems.BEETROOT_MILKSHAKE);
        basicItem(SeasonalsItems.ROASTED_BEETROOT);
        basicItem(SeasonalsItems.OXIDIZED_BEETROOT);
        basicItem(SeasonalsItems.RED_VELVET_CUPCAKE);
        basicItem(SeasonalsItems.PUMPKIN_CAKE_SLICE);
        basicItem(SeasonalsItems.SWEET_BERRY_CAKE_SLICE);
        basicItem(SeasonalsItems.BEETROOT_CAKE_SLICE);
    }

    private void basicItem(Supplier<? extends Item> item) {
        basicItem(item.get());
    }

    private void basicBlockItem(Supplier<? extends Block> blockForItem) {
        withExistingParent(name(blockForItem.get()), modBlockLocation(name(blockForItem.get())));
    }

    private void generatedBlockItemWithItemTexture(Supplier<? extends Block> block) {
        withExistingParent(name(block.get()), GENERATED).texture(LAYER0, modItemLocation(name(block.get())));
    }
}
