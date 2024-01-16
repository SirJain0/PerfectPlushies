package io.github.sirjain0.perfectplushies.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.sirjain0.perfectplushies.Constants;
import io.github.sirjain0.perfectplushies.block.entity.PlayerPlushieBlockEntity;
import io.github.sirjain0.perfectplushies.block.entity.TestPlushieBlockEntity;
import io.github.sirjain0.perfectplushies.client.model.PlayerPlushieModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class TestPlushieRenderer extends GeoBlockRenderer<TestPlushieBlockEntity> {
    public TestPlushieRenderer() {
        super(new DefaultedBlockGeoModel<>(new ResourceLocation(Constants.MODID,"dumbo_blob_plushie")));
    }

    @Override
    public void renderRecursively(PoseStack poseStack, TestPlushieBlockEntity animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        int redx = animatable.getRed1();
        int greenx = animatable.getGreen1();
        int bluex = animatable.getBlue1();
        if(bone.getName().contains("color2")){
            redx = animatable.getRed2();
            greenx = animatable.getGreen2();
            bluex = animatable.getBlue2();
        }
        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, redx/255f, greenx/255f, bluex/255f, alpha);
    }
}
