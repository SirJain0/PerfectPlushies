package sirjain;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import sirjain.blocks.util.PlushieBlockRegistries;

public class PerfectPlushiesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(PlushieBlockRegistries.FROG_PLUSHIE, RenderLayer.getCutout());
    }
}
