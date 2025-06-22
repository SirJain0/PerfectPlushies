package io.github.sirjain0.perfectplushies;

import com.nyfaria.perfectplushieapi.client.renderer.ColoredPlushieRenderer;
import com.nyfaria.perfectplushieapi.registration.RegistryObject;
import io.github.sirjain0.perfectplushies.init.BlockInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class PerfectPlushiesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerCutout(BlockInit.FROG_PLUSHIE);
        registerCutout(BlockInit.GOOSE_PLUSHIE);
        registerCutout(BlockInit.HEDGEHOG_PLUSHIE);

        BlockEntityRenderers.register(BlockInit.PP_COLOR_BLOCK_ENTITY.get(), (context) -> new ColoredPlushieRenderer(new ResourceLocation(Constants.MODID,"dumbo_blob_plushie")));

    }

    private static void registerCutout(RegistryObject<Block> block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block.get(), RenderType.cutout());
    }
}
