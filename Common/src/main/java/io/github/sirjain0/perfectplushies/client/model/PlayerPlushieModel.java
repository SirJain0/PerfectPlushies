package io.github.sirjain0.perfectplushies.client.model;

import io.github.sirjain0.perfectplushies.Constants;
import io.github.sirjain0.perfectplushies.block.entity.PlayerPlushieBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

import java.util.HashMap;
import java.util.Map;

public class PlayerPlushieModel extends GeoModel<PlayerPlushieBlockEntity> {

    public final ResourceLocation modDevDoll = new ResourceLocation(Constants.MODID, "geo/player_plushie.geo.json");
    public final Map<ResourceLocation, ResourceLocation> textures = new HashMap<>();
    public final ResourceLocation noAnimations = new ResourceLocation(Constants.MODID, "animations/none.animation.json");


    public PlayerPlushieModel() {
    }

    @Override
    public ResourceLocation getModelResource(PlayerPlushieBlockEntity animatable) {
        return modDevDoll;
    }

    @Override
    public ResourceLocation getTextureResource(PlayerPlushieBlockEntity animatable) {
        return textures.computeIfAbsent(BuiltInRegistries.BLOCK.getKey(animatable.getBlockState().getBlock()), blockRL -> new ResourceLocation(Constants.MODID, "textures/block/" + blockRL.getPath() + ".png"));
    }

    @Override
    public ResourceLocation getAnimationResource(PlayerPlushieBlockEntity animatable) {
        return noAnimations;
    }
}
