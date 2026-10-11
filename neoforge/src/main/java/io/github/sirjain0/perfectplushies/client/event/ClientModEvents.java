package io.github.sirjain0.perfectplushies.client.event;

import com.nyfaria.perfectplushieapi.client.renderer.ColoredPlushieRenderer;
import io.github.sirjain0.perfectplushies.Constants;
import io.github.sirjain0.perfectplushies.init.BlockInit;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void onRenderers(EntityRenderersEvent.RegisterRenderers event) {
//        event.registerBlockEntityRenderer(BlockInit.PLAYER_PLUSHIE_BLOCK_ENTITY.get(), (context) -> new PlushieRenderer());
//        event.registerEntityRenderer(EntityInit.WANDERING_PLUSHIH_TRADER.get(), WanderingPlushieTraderRenderer::new);
        event.registerBlockEntityRenderer(BlockInit.PP_COLOR_BLOCK_ENTITY.get(), (context) -> new ColoredPlushieRenderer(ResourceLocation.fromNamespaceAndPath(Constants.MODID,"dumbo_blob_plushie")));
    }
}
