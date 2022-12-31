package com.cosmicgelatin.seasonals.core.registry;

import com.cosmicgelatin.seasonals.common.potion.FallFlavorEffect;
import com.cosmicgelatin.seasonals.core.Seasonals;
import com.teamabnormals.blueprint.common.effect.BlueprintMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeasonalsEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Seasonals.MODID);

    public static final RegistryObject<MobEffect> FALL_FLAVOR = EFFECTS.register("fall_flavor", FallFlavorEffect::new);
    public static final RegistryObject<MobEffect> THORN_RESISTANCE = EFFECTS.register("thorn_resistance", () -> new BlueprintMobEffect(MobEffectCategory.BENEFICIAL, 14172504));
}
