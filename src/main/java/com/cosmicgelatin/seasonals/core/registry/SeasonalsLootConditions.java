package com.cosmicgelatin.seasonals.core.registry;

import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.SeasonalsConfig;
import com.teamabnormals.blueprint.core.util.DataUtil;
import net.minecraft.core.Registry;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditions;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SeasonalsLootConditions {

public static final DeferredRegister<LootItemConditionType> LOOT_ITEM_CONDITION_TYPE = DeferredRegister.create(Registry.LOOT_ITEM_REGISTRY, Seasonals.MODID);

public static final RegistryObject<LootItemConditionType> CONFIG = LOOT_ITEM_CONDITION_TYPE.register("config", () -> DataUtil.registerConfigCondition(Seasonals.MODID, SeasonalsConfig.COMMON));

}
