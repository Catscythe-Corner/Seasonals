package com.cosmicgelatin.seasonals.core;

import com.teamabnormals.blueprint.core.annotations.ConfigKey;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;
public class SeasonalsConfig {
    public static class Common {
        @ConfigKey("outside_effects")
        public final ForgeConfigSpec.ConfigValue<Boolean> outsideEffects;
        @ConfigKey("outside_recipes")
        public final ForgeConfigSpec.ConfigValue<Boolean> outsideRecipes;

        Common(ForgeConfigSpec.Builder builder) {
            this.outsideEffects = builder.comment("If items from other mods (Sweet Berry meatballs from Berry Good, pumpkin foods from Autumnity) give the effects from this mod; defaults to false").translation("seasonals.config.outside_effects").define("outsideEffects", false);
            this.outsideRecipes = builder.comment("If pumpkin foods from other mods (Autumnity) use Roasted Pumpkin instead of vanilla pumpkin; defaults to false").translation("seasonals.config.outside_recipes").define("outsideRecipes", false);
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}
