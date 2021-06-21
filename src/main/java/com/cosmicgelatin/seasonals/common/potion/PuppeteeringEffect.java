package com.cosmicgelatin.seasonals.common.potion;

import com.cosmicgelatin.seasonals.core.other.SeasonalsEvents;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.math.vector.Vector3d;

import java.util.Random;

public class PuppeteeringEffect extends Effect {

    public PuppeteeringEffect() {
        super(EffectType.BENEFICIAL, 12605408);
    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)entity;
            if (SeasonalsEvents.puppetBound.containsKey(player.getUniqueID())) {
                Integer puppetId = SeasonalsEvents.puppetBound.get(player.getUniqueID());
                LivingEntity puppet = (LivingEntity)(player.getEntityWorld().getEntityByID(puppetId));
                if (puppet == null || puppet.getShouldBeDead() || puppet.getDistance(player) > 8.0 + amplifier
                        || player.getActivePotionEffect(SeasonalsEffects.PUPPETEERING.get()).getDuration() <= 5
                        || (puppet.getHealth() >= player.getHealth() && !player.isCreative()) || player.isSneaking()
                        || (puppet instanceof PlayerEntity && ((PlayerEntity)puppet).isCreative())) {
                    SeasonalsEvents.puppetBound.remove(player.getUniqueID());
                }
                else {
                    Vector3d pos = puppet.getPositionVec();
                    Random rand = player.getEntityWorld().getRandom();
                    if (player.getEntityWorld().getGameTime()%2==0) {player.getEntityWorld().addParticle
                            (ParticleTypes.ENCHANT, pos.getX() + rand.nextDouble(), pos.getY() + rand.nextDouble() + 0.25d, pos.getZ() + rand.nextDouble(),
                                    ((double)rand.nextFloat() - 0.5D) * 0.5D, ((double)rand.nextFloat() - 0.125D) * 0.5D, ((double)rand.nextFloat() - 0.5D) * 0.5D); }
                    puppet.fallDistance=0.0F;
                    Vector3d betweenVector = (pos.subtract(player.getPositionVec().add(player.getLookVec().mul(puppet.getDistance(player), puppet.getDistance(player), puppet.getDistance(player))))).mul(-1.0d, -1.0d, -1.0d);
                    betweenVector = betweenVector.length() > 1.0 ? betweenVector.normalize(): betweenVector;
                    puppet.setMotion(betweenVector);
                }
            }
        }
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }
}