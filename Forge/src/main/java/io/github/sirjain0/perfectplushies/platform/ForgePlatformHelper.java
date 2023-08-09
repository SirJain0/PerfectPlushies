package io.github.sirjain0.perfectplushies.platform;

import io.github.sirjain0.perfectplushies.platform.services.IPlatformHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import software.bernie.geckolib.animatable.GeoItem;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "Forge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }

    @Override
    public void registerFabricRenderer(Consumer<Object> consumer) {

    }

    @Override
    public Supplier<Object> getRenderProvider(GeoItem item) {
        return null;
    }
}