package com.cosmicgelatin.seasonals.core.data.server;

import com.cosmicgelatin.seasonals.core.registry.SeasonalsBlocks;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SeasonalsLootTableProvider extends LootTableProvider {
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> lootTables = ImmutableList.of(Pair.of(SeasonalsBlockLoot::new, LootContextParamSets.BLOCK));

    public SeasonalsLootTableProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return this.lootTables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
    }

    private static class SeasonalsBlockLoot extends BlockLoot {

        @Override
        protected void addTables() {
            add(SeasonalsBlocks.PUMPKIN_CAKE.get(), noDrop());
            add(SeasonalsBlocks.SWEET_BERRY_CAKE.get(), noDrop());
            dropSelf(SeasonalsBlocks.PUMPKIN_ICE_CREAM_BLOCK.get());
            dropSelf(SeasonalsBlocks.SWEET_BERRY_ICE_CREAM_BLOCK.get());

        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return SeasonalsBlocks.HELPER.getDeferredRegister().getEntries().stream().map(RegistryObject::get)::iterator;
        }

    }
}
