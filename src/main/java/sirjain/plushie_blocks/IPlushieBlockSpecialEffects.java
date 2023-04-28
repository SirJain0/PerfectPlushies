package sirjain.plushie_blocks;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.particle.ParticleType;

public interface IPlushieBlockSpecialEffects {
	ParticleType getParticle();
	StatusEffectInstance getStatusEffect();
}