package com.cosmicgelatin.seasonals.common.potion;

import com.cosmicgelatin.seasonals.core.other.SeasonalsEvents;
import com.cosmicgelatin.seasonals.core.registry.SeasonalsEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class PuppeteeringEffect extends MobEffect {

    public PuppeteeringEffect() {
        super(MobEffectCategory.BENEFICIAL, 12605408);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
            if (SeasonalsEvents.puppetBound.containsKey(player.getUUID())) {
                Integer puppetId = SeasonalsEvents.puppetBound.get(player.getUUID());
                LivingEntity puppet = (LivingEntity)(player.getCommandSenderWorld().getEntity(puppetId));
                if (puppet == null || puppet.isDeadOrDying() || puppet.distanceTo(player) > 8.0 + amplifier
                        || player.getEffect(SeasonalsEffects.PUPPETEERING.get()).getDuration() <= 5
                        || (puppet.getHealth() >= player.getHealth() && !player.isCreative()) || player.isShiftKeyDown()
                        || (puppet instanceof Player && ((Player)puppet).isCreative())) {
                    SeasonalsEvents.puppetBound.remove(player.getUUID());
                }
                else {
                    Vec3 pos = puppet.position();
                    Random rand = player.getCommandSenderWorld().getRandom();
                    if (player.getCommandSenderWorld().getGameTime() % 2 == 0) {
                        player.getCommandSenderWorld().addParticle(ParticleTypes.ENCHANT, pos.x() + rand.nextDouble(), pos.y() + rand.nextDouble() + 0.25d, pos.z() + rand.nextDouble(),
                                    ((double)rand.nextFloat() - 0.5D) * 0.5D, ((double)rand.nextFloat() - 0.125D) * 0.5D, ((double)rand.nextFloat() - 0.5D) * 0.5D);
                    }
                    puppet.fallDistance=0.0F;
                    Vec3 betweenVector = (pos.subtract(player.position().add(player.getLookAngle().multiply(puppet.distanceTo(player), puppet.distanceTo(player), puppet.distanceTo(player))))).multiply(-1.0d, -1.0d, -1.0d);
                    betweenVector = betweenVector.length() > 1.0 ? betweenVector.normalize(): betweenVector;
                    puppet.setDeltaMovement(betweenVector);
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}