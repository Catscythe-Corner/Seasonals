package com.cosmicgelatin.seasonals.core.registry;

import com.cosmicgelatin.seasonals.core.Seasonals;
import com.teamabnormals.blueprint.common.effect.BlueprintMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeasonalsMobEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Seasonals.MODID);

    public static final RegistryObject<MobEffect> STUFFED = EFFECTS.register("stuffed", () -> new BlueprintMobEffect(MobEffectCategory.BENEFICIAL, 11683328));
    public static final RegistryObject<MobEffect> THORN_RESISTANCE = EFFECTS.register("thorn_resistance", () -> new BlueprintMobEffect(MobEffectCategory.BENEFICIAL, 14172504));
    public static final RegistryObject<MobEffect> ROOTED = EFFECTS.register("rooted", () -> new BlueprintMobEffect(MobEffectCategory.BENEFICIAL, 7625270).addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, "97af858d-fc4e-4086-8cb5-8a5128809a63", 1.0, AttributeModifier.Operation.ADDITION).addAttributeModifier(Attributes.ARMOR, "b07d028e-18a1-4fcb-8d02-1aff32170f3b", 2.0, AttributeModifier.Operation.ADDITION));
}
