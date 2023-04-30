package sirjain.blocks.plushie_variants;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import sirjain.blocks.util.AbstractPlushieBlock;
import sirjain.blocks.util.IPlushieBlockSpecialEffects;

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
	public StatusEffectInstance getStatusEffect() {
		final StatusEffectInstance speedEffect = new StatusEffectInstance(StatusEffects.SPEED, 20 * 3, 1);
		return new StatusEffectInstance(speedEffect);
	}
}