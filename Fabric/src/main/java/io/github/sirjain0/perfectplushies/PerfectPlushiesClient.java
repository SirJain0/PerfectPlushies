package io.github.sirjain0.perfectplushies;

import io.github.sirjain0.perfectplushies.client.renderer.PlushieRenderer;
import io.github.sirjain0.perfectplushies.client.renderer.WanderingPlushieTraderRenderer;
import io.github.sirjain0.perfectplushies.init.BlockInit;
import io.github.sirjain0.perfectplushies.init.EntityInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class PerfectPlushiesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.FROG_PLUSHIE.get(), RenderType.cutout());
        BlockEntityRenderers.register(BlockInit.PLAYER_PLUSHIE_BLOCK_ENTITY.get(), (context) -> new PlushieRenderer());
        EntityRendererRegistry.register(EntityInit.WANDERING_PLUSHIH_TRADER.get(), WanderingPlushieTraderRenderer::new);
    }
}
