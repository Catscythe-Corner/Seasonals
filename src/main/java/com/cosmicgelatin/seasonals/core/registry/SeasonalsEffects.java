package com.cosmicgelatin.seasonals.core.registry;

import com.cosmicgelatin.seasonals.common.potion.PuppeteeringEffect;
import com.cosmicgelatin.seasonals.common.potion.ThornResistanceEffect;
import com.cosmicgelatin.seasonals.common.potion.FallFlavorEffect;
import com.cosmicgelatin.seasonals.core.Seasonals;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SeasonalsEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Seasonals.MODID);

    public static final RegistryObject<MobEffect> FALL_FLAVOR = EFFECTS.register("fall_flavor", () -> new FallFlavorEffect());
    public static final RegistryObject<MobEffect> THORN_RESISTANCE = EFFECTS.register("thorn_resistance", () -> new ThornResistanceEffect());
    public static final RegistryObject<MobEffect> PUPPETEERING = EFFECTS.register("puppeteering", PuppeteeringEffect::new);
}
