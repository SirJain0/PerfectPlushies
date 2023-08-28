package io.github.sirjain0.perfectplushies.platform;

import io.github.sirjain0.perfectplushies.platform.services.IPlatformHelper;
import io.github.sirjain0.perfectplushies.registration.RegistryObject;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import software.bernie.geckolib.animatable.GeoItem;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ForgePlatformHelper<T extends Mob> implements IPlatformHelper<T>{

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

    @Override
    public SpawnEggItem createSpawnEggItem(RegistryObject<EntityType<T>> entityTypeRegistryObject, int primaryColor, int secondaryColor) {
        return new ForgeSpawnEggItem(entityTypeRegistryObject, primaryColor,secondaryColor, new SpawnEggItem.Properties());
    }


}