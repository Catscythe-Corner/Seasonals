package com.cosmicgelatin.seasonals.mixins;

import com.cosmicgelatin.seasonals.core.registry.SeasonalsMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Shadow public abstract boolean hasEffect(MobEffect pEffect);

    public LivingEntityMixin(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }



    @Inject(method = "getJumpPower()F", at =  @At("HEAD"), cancellable = true)
    private void seasonals_getJumpPower(CallbackInfoReturnable<Float> cir) {
        if (this.hasEffect(SeasonalsMobEffects.ROOTED.get())) {
            //this.markHurt();
            cir.setReturnValue(0.0F);
        }
    }
}
