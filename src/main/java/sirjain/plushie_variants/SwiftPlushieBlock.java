package sirjain.plushie_variants;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import sirjain.util.AbstractPlushieBlock;
import sirjain.util.IPlushieBlockSpecialEffects;

public class SwiftPlushieBlock extends AbstractPlushieBlock implements IPlushieBlockSpecialEffects {
	public SwiftPlushieBlock() {
		super(FabricBlockSettings.of(Material.WOOL)
			.nonOpaque()
			.sounds(BlockSoundGroup.WOOL)
			.strength(0.5f, 0.5f)
			.luminance((state) -> 3)
		);
	}

	@Override
	public ParticleType getParticle() {
		return ParticleTypes.HEART;
	}

	@Override
	public StatusEffectInstance getStatusEffect() {
		final StatusEffectInstance speedEffect = new StatusEffectInstance(StatusEffects.SPEED, 20 * 3, 1);
		return new StatusEffectInstance(speedEffect);
	}
}