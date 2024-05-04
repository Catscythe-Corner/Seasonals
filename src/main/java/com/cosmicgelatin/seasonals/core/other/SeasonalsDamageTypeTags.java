package com.cosmicgelatin.seasonals.core.other;

import com.cosmicgelatin.seasonals.core.Seasonals;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraftforge.registries.ForgeRegistries;

public class SeasonalsDamageTypeTags {
    public static final TagKey<DamageType> AFFECTED_BY_THORN_RESISTANCE = TagKey.create(Registries.DAMAGE_TYPE, Seasonals.modPrefix("affected_by_thorn_resistance"));
}
