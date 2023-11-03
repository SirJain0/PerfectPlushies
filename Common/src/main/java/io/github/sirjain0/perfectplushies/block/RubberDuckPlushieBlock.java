package io.github.sirjain0.perfectplushies.block;

import net.minecraft.ChatFormatting;

public class RubberDuckPlushieBlock extends PlushieBlock {
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
