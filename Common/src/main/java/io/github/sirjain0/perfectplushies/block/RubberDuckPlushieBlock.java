package io.github.sirjain0.perfectplushies.block;

import com.mojang.serialization.MapCodec;
import com.nyfaria.perfectplushieapi.block.PlushieBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;

public class RubberDuckPlushieBlock extends PlushieBlock {
	public static final MapCodec<RubberDuckPlushieBlock> CODEC = simpleCodec(properties -> new RubberDuckPlushieBlock());

	@Override
	protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
		return CODEC;
	}

	@Override
	public ChatFormatting getMessageColor() {
		return ChatFormatting.YELLOW;
	}

	@Override
	public String getMessageSender() {
		return "Rubber Duck Plushie";
	}

	@Override
	public String getMessage() {
		return "Quack!";
	}
}
