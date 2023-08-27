package io.github.sirjain0.perfectplushies;

import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import io.github.sirjain0.perfectplushies.config.CommonConfig;
import io.github.sirjain0.perfectplushies.entity.spawning.WanderingPlushieTraderSpawner;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.config.ModConfig;

public class PerfectPlushies implements ModInitializer {

    @Override
    public void onInitialize() {
        CommonClass.init();
        PlushiesLootTableModifier.modifyLootTables();
        ForgeConfigRegistry.INSTANCE.register(Constants.MODID, ModConfig.Type.COMMON, CommonConfig.CONFIG_SPEC);
//        ServerLifecycleEvents.SERVER_STARTED.register(server -> server.getLevel(Level.OVERWORLD).customSpawners.add(new WanderingPlushieTraderSpawner(server.getWorldData().overworldData())));
    }
}

