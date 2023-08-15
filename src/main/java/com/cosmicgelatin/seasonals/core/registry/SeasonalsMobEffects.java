package com.cosmicgelatin.seasonals.core.registry;

import com.cosmicgelatin.seasonals.common.potion.Rooted;
import com.cosmicgelatin.seasonals.core.Seasonals;
import com.teamabnormals.blueprint.common.effect.BlueprintMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeasonalsMobEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Seasonals.MODID);

    public static final RegistryObject<MobEffect> STUFFED = EFFECTS.register("stuffed", () -> new BlueprintMobEffect(MobEffectCategory.BENEFICIAL, 11683328));
    public static final RegistryObject<MobEffect> THORN_RESISTANCE = EFFECTS.register("thorn_resistance", () -> new BlueprintMobEffect(MobEffectCategory.BENEFICIAL, 14172504));
    public static final RegistryObject<MobEffect> ROOTED = EFFECTS.register("rooted", Rooted::new);
}
