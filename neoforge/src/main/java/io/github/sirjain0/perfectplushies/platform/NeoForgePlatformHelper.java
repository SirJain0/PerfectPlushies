package io.github.sirjain0.perfectplushies.platform;

import io.github.sirjain0.perfectplushies.platform.services.IPlatformHelper;
import net.minecraft.world.entity.Mob;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

public class NeoForgePlatformHelper<T extends Mob> implements IPlatformHelper<T>{

    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }
}
