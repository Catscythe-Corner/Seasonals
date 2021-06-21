package com.cosmicgelatin.seasonals.core.registry;

import com.cosmicgelatin.seasonals.common.potion.PuppeteeringEffect;
import com.cosmicgelatin.seasonals.common.potion.ThornResistanceEffect;
import com.cosmicgelatin.seasonals.common.potion.FallFlavorEffect;
import com.cosmicgelatin.seasonals.core.Seasonals;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SeasonalsEffects {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, Seasonals.MODID);

    public static final RegistryObject<Effect> FALL_FLAVOR = EFFECTS.register("fall_flavor", () -> new FallFlavorEffect());
    public static final RegistryObject<Effect> THORN_RESISTANCE = EFFECTS.register("thorn_resistance", () -> new ThornResistanceEffect());
    public static final RegistryObject<Effect> PUPPETEERING = EFFECTS.register("puppeteering", () -> new PuppeteeringEffect());
}
