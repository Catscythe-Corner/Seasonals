package com.cosmicgelatin.seasonals.common.potion;

import com.teamabnormals.blueprint.common.effect.BlueprintMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.UUID;

public class Rooted extends BlueprintMobEffect {

    public Rooted() {
        super(MobEffectCategory.BENEFICIAL, 7625270);
        this.addAttributeModifier(Attributes.ARMOR, "b07d028e-18a1-4fcb-8d02-1aff32170f3b", 0.0, AttributeModifier.Operation.ADDITION);
        this.addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, "97af858d-fc4e-4086-8cb5-8a5128809a63", 1.0, AttributeModifier.Operation.ADDITION);
    }

    @Override
    public double getAttributeModifierValue(int amplifier, AttributeModifier modifier) {
        return modifier.getId().equals(UUID.fromString("b07d028e-18a1-4fcb-8d02-1aff32170f3b")) ? 2.0D + amplifier : 2.0D;
    }

}
