package io.github.sirjain0.perfectplushies.mixin;

import io.github.sirjain0.perfectplushies.client.renderer.PlayerPlushieBlockItemRenderer;
import io.github.sirjain0.perfectplushies.item.PlayerPlushieBlockItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Mixin(PlayerPlushieBlockItem.class)
public abstract class PlayerPlushieBlockItemMixin implements GeoItem {

}
