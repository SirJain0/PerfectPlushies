package io.github.sirjain0.perfectplushies;

import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import io.github.sirjain0.perfectplushies.config.CommonConfig;
import io.github.sirjain0.perfectplushies.init.EntityInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraftforge.fml.config.ModConfig;

public class PerfectPlushies implements ModInitializer {

    @Override
    public void onInitialize() {
        CommonClass.init();
        ForgeConfigRegistry.INSTANCE.register(Constants.MODID, ModConfig.Type.COMMON, CommonConfig.CONFIG_SPEC);
        EntityInit.attributeSuppliers.forEach(
                p -> FabricDefaultAttributeRegistry.register(p.entityTypeSupplier().get(), p.factory().get().build())
        );
    }
}

