package com.cosmicgelatin.seasonals.core.data.server.loot;

import com.cosmicgelatin.seasonals.common.item.SeasonalsFlavoredCandleCake;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsBlocks;
import com.teamabnormals.neapolitan.common.block.FlavoredCandleCakeBlock;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class SeasonalsBlockLoot extends BlockLootSubProvider {
    private static final Set<Item> EXPLOSION_RESISTANT = Set.of();

    protected SeasonalsBlockLoot() {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return SeasonalsBlocks.HELPER.getDeferredRegister().getEntries().stream().map(RegistryObject::get)::iterator;
    }

    @Override
    protected void generate() {
        add(SeasonalsBlocks.PUMPKIN_CAKE.get(), noDrop());
        add(SeasonalsBlocks.SWEET_BERRY_CAKE.get(), noDrop());
        add(SeasonalsBlocks.BEETROOT_CAKE.get(), noDrop());
        dropSelf(SeasonalsBlocks.PUMPKIN_ICE_CREAM_BLOCK.get());
        dropSelf(SeasonalsBlocks.SWEET_BERRY_ICE_CREAM_BLOCK.get());
        dropSelf(SeasonalsBlocks.BEETROOT_ICE_CREAM_BLOCK.get());
        this.dropOther(SeasonalsBlocks.PUMPKIN_MILKSHAKE_CAULDRON.get(), Blocks.CAULDRON);
        this.dropOther(SeasonalsBlocks.SWEET_BERRY_MILKSHAKE_CAULDRON.get(), Blocks.CAULDRON);
        this.dropOther(SeasonalsBlocks.BEETROOT_MILKSHAKE_CAULDRON.get(), Blocks.CAULDRON);

        SeasonalsFlavoredCandleCake.getCandleCakes().forEach((block -> this.add(block, createCandleCakeDrops(((FlavoredCandleCakeBlock) block).getCandle()))));

    }
}
