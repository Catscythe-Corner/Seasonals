package com.cosmicgelatin.seasonals.core.data.server.modifier;

import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import com.teamabnormals.blueprint.common.loot.modification.LootModifierProvider;
import com.teamabnormals.blueprint.common.loot.modification.modifiers.LootPoolEntriesModifier;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class SeasonalsLootModifierProvider extends LootModifierProvider {

    public SeasonalsLootModifierProvider(DataGenerator dataGenerator) {
        super(dataGenerator, Seasonals.MODID);
    }

    @Override
    protected void registerEntries() {
        addNoneReplacingModifier("add_oxidized_beetroot_to_underwater_ruins", createLootEntry(SeasonalsItems.OXIDIZED_BEETROOT, 1, 0, 1), BuiltInLootTables.UNDERWATER_RUIN_SMALL, BuiltInLootTables.UNDERWATER_RUIN_BIG);
        addNoneReplacingModifier("add_oxidized_beetroot_to_shipwreck_treasure", createLootEntry(SeasonalsItems.OXIDIZED_BEETROOT, 5, 0, 1), BuiltInLootTables.SHIPWRECK_TREASURE);

    }

    private static LootPoolEntryContainer createLootEntryWithCondition(Supplier<? extends ItemLike> item, int weight, int min, int max, LootItemCondition.Builder condition) {
        return LootItem.lootTableItem(item.get()).setWeight(weight).when(condition).apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max))).build();
    }

    private static LootPoolEntryContainer createLootEntry(Supplier<? extends ItemLike> item, int weight, int min, int max) {
        return LootItem.lootTableItem(item.get()).setWeight(weight).apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max))).build();
    }

    private void addNoneReplacingModifier(String name, LootPoolEntryContainer lootEntry, ResourceLocation... modifierLocations) {
        entry(name).selects(modifierLocations).addModifier(new LootPoolEntriesModifier(false, 0, Collections.singletonList(lootEntry)));
    }
}
