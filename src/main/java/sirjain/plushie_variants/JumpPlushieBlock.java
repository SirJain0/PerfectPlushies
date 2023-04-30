package sirjain.plushie_variants;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import sirjain.util.AbstractPlushieBlock;
import sirjain.util.IPlushieBlockSpecialEffects;

public class JumpPlushieBlock extends AbstractPlushieBlock implements IPlushieBlockSpecialEffects {
	public JumpPlushieBlock() {
		super(FabricBlockSettings.of(Material.WOOL)
			.nonOpaque()
			.sounds(BlockSoundGroup.WOOL)
			.strength(0.5f, 0.5f)
			.luminance((state) -> 3)
		);
	}

	@Override
	public StatusEffectInstance getStatusEffect() {
		final StatusEffectInstance speedEffect = new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20 * 3, 1);
		return new StatusEffectInstance(speedEffect);
	}
}