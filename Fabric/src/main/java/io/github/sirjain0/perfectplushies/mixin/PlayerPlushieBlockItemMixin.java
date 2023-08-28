package io.github.sirjain0.perfectplushies.mixin;

import io.github.sirjain0.perfectplushies.item.PlayerPlushieBlockItem;
import org.spongepowered.asm.mixin.Mixin;
import software.bernie.geckolib.animatable.GeoItem;

@Mixin(PlayerPlushieBlockItem.class)
public abstract class PlayerPlushieBlockItemMixin implements GeoItem {

}
