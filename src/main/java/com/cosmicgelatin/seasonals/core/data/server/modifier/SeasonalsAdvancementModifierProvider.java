package com.cosmicgelatin.seasonals.core.data.server.modifier;

import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsMobEffects;
import com.teamabnormals.blueprint.common.advancement.modification.AdvancementModifierProvider;
import com.teamabnormals.blueprint.common.advancement.modification.modifiers.CriteriaModifier;
import com.teamabnormals.blueprint.common.advancement.modification.modifiers.EffectsChangedModifier;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.MobEffectsPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;

public class SeasonalsAdvancementModifierProvider extends AdvancementModifierProvider {

    public SeasonalsAdvancementModifierProvider(DataGenerator dataGenerator) {
        super(dataGenerator, Seasonals.MODID);
    }

    @Override
    protected void registerEntries() {
        CriteriaModifier.Builder constructBalancedDiet = CriteriaModifier.builder(this.modId);
        Collection<RegistryObject<Item>> items = SeasonalsItems.HELPER.getDeferredRegister().getEntries();

        items.forEach((item) -> {
            if (item.get().isEdible()) {
                constructBalancedDiet.addCriterion(ForgeRegistries.ITEMS.getKey(item.get()).getPath(), ConsumeItemTrigger.TriggerInstance.usedItem(item.get()));
            }
        });

        this.entry("husbandry/balanced_diet").selects("husbandry/balanced_diet").addModifier(constructBalancedDiet.requirements(RequirementsStrategy.AND).build());
        this.entry("nether/all_effects").selects("nether/all_effects").addModifier(new EffectsChangedModifier("all_effects", false, MobEffectsPredicate.effects().and(SeasonalsMobEffects.STUFFED.get()).and(SeasonalsMobEffects.THORN_RESISTANCE.get()).and(SeasonalsMobEffects.ROOTED.get())));
    }
}
