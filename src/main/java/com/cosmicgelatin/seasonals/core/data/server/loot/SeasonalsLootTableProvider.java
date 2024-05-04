package com.cosmicgelatin.seasonals.core.data.server.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.Collections;
import java.util.List;

public class SeasonalsLootTableProvider extends LootTableProvider {

    public SeasonalsLootTableProvider(PackOutput packOutput) {
        super(packOutput, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(SeasonalsBlockLoot::new, LootContextParamSets.BLOCK)
        ));
    }
}
