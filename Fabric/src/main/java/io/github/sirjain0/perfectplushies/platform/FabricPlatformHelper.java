package io.github.sirjain0.perfectplushies.platform;

import io.github.sirjain0.perfectplushies.platform.services.IPlatformHelper;
import io.github.sirjain0.perfectplushies.registration.RegistryObject;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.SpawnEggItem;
import software.bernie.geckolib.animatable.GeoItem;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FabricPlatformHelper<T extends Mob> implements IPlatformHelper<T> {

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
    public SpawnEggItem createSpawnEggItem(RegistryObject<EntityType<T>> entityTypeRegistryObject, int primaryColor, int secondaryColor) {
        return new SpawnEggItem(entityTypeRegistryObject.get(), primaryColor, secondaryColor, new SpawnEggItem.Properties());
    }

    @Override
    public void registerFabricRenderer(Consumer<Object> consumer) {

    }
}
