package com.cosmicgelatin.seasonals.core.other;

import com.cosmicgelatin.seasonals.core.Seasonals;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsBlocks;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsItems;
import com.teamabnormals.blueprint.core.api.BlueprintCauldronInteraction;
import com.teamabnormals.neapolitan.core.NeapolitanConfig;
import com.teamabnormals.neapolitan.core.other.NeapolitanCauldronInteractions;
import net.minecraft.core.cauldron.CauldronInteraction;

public class SeasonalsCauldronInteractions {
    public static BlueprintCauldronInteraction PUMPKIN_MILKSHAKE = BlueprintCauldronInteraction.register(Seasonals.modPrefix("pumpkin_milkshake"), CauldronInteraction.newInteractionMap());
    public static BlueprintCauldronInteraction SWEET_BERRY_MILKSHAKE = BlueprintCauldronInteraction.register(Seasonals.modPrefix("sweet_berry_milkshake"), CauldronInteraction.newInteractionMap());
    public static BlueprintCauldronInteraction BEETROOT_MILKSHAKE = BlueprintCauldronInteraction.register(Seasonals.modPrefix("beetroot_milkshake"), CauldronInteraction.newInteractionMap());

    public static void registerCauldronInteractions() {
        if (NeapolitanConfig.COMMON.milkshakeCauldrons.get()) {
            NeapolitanCauldronInteractions.addMilkshakeInteractions(SeasonalsItems.PUMPKIN_MILKSHAKE.get(), SeasonalsBlocks.PUMPKIN_MILKSHAKE_CAULDRON.get(), SeasonalsItems.PUMPKIN_ICE_CREAM.get(), PUMPKIN_MILKSHAKE.map());
            NeapolitanCauldronInteractions.addMilkshakeInteractions(SeasonalsItems.SWEET_BERRY_MILKSHAKE.get(), SeasonalsBlocks.SWEET_BERRY_MILKSHAKE_CAULDRON.get(), SeasonalsItems.SWEET_BERRY_ICE_CREAM.get(), SWEET_BERRY_MILKSHAKE.map());
            NeapolitanCauldronInteractions.addMilkshakeInteractions(SeasonalsItems.BEETROOT_MILKSHAKE.get(), SeasonalsBlocks.BEETROOT_MILKSHAKE_CAULDRON.get(), SeasonalsItems.BEETROOT_ICE_CREAM.get(), BEETROOT_MILKSHAKE.map());
        }
    }
}
