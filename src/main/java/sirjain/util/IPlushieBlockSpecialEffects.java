package sirjain.util;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.particle.ParticleType;

public interface IPlushieBlockSpecialEffects {
	ParticleType getParticle();
	StatusEffectInstance getStatusEffect();
}