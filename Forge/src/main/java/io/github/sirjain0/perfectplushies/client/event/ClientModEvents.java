package io.github.sirjain0.perfectplushies.client.event;

import io.github.sirjain0.perfectplushies.client.renderer.PlushieRenderer;
import io.github.sirjain0.perfectplushies.client.renderer.WanderingPlushieTraderRenderer;
import io.github.sirjain0.perfectplushies.init.BlockInit;
import io.github.sirjain0.perfectplushies.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void onRenderers(EntityRenderersEvent.RegisterRenderers event) {
     event.registerBlockEntityRenderer(BlockInit.PLAYER_PLUSHIE_BLOCK_ENTITY.get(), (context)->new PlushieRenderer());
     event.registerEntityRenderer(EntityInit.WANDERING_PLUSHIH_TRADER.get(), WanderingPlushieTraderRenderer::new);
    }
}
