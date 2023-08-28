package io.github.sirjain0.perfectplushies.mixin;

import io.github.sirjain0.perfectplushies.client.renderer.PlayerPlushieBlockItemRenderer;
import io.github.sirjain0.perfectplushies.item.NeededForML;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(Item.class)
public abstract class PlayerPlushieBlockItemMixin {


    @Inject(method = "initializeClient", at = @At("RETURN"), remap = false)
    public void doTheShit(Consumer<IClientItemExtensions> consumer, CallbackInfo ci) {
        if (!(((Object) this) instanceof NeededForML)) {
            return;
        }
        consumer.accept(new IClientItemExtensions() {
            private PlayerPlushieBlockItemRenderer renderer = null;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null)
                    this.renderer = new PlayerPlushieBlockItemRenderer();
                return renderer;
            }
        });
    }

}
