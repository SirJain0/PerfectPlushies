package io.github.sirjain0.perfectplushies;

import io.github.sirjain0.perfectplushies.client.renderer.PlushieRenderer;
import io.github.sirjain0.perfectplushies.init.BlockInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class PerfectPlushiesClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.FROG_PLUSHIE.get(), RenderType.cutout());
        BlockEntityRenderers.register(BlockInit.PLAYER_PLUSHIE_BLOCK_ENTITY.get(), (context)->new PlushieRenderer());
    }
}
