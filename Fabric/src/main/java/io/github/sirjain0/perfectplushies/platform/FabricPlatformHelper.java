package io.github.sirjain0.perfectplushies.platform;

import io.github.sirjain0.perfectplushies.client.renderer.PlayerPlushieBlockItemRenderer;
import io.github.sirjain0.perfectplushies.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public Supplier<Object> getRenderProvider(GeoItem item) {
        return GeoItem.makeRenderer(item);
    }

    @Override
    public void registerFabricRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private PlayerPlushieBlockItemRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null)
                    this.renderer = new PlayerPlushieBlockItemRenderer();

                return this.renderer;
            }
        });
    }
}
