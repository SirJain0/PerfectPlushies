package io.github.sirjain0.perfectplushies.event;

import io.github.sirjain0.perfectplushies.entity.spawning.WanderingPlushieTraderSpawner;
import io.github.sirjain0.perfectplushies.init.EntityInit;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonForgeEvents {
//
//
//    @SubscribeEvent
//    public static void onServerStated(ServerStartedEvent event) {
//        event.getServer().getLevel(Level.OVERWORLD).customSpawners.add(new WanderingPlushieTraderSpawner(event.getServer().getWorldData().overworldData()));
//    }
}
