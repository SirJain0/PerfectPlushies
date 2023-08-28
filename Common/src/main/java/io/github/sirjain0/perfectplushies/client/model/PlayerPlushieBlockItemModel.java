package io.github.sirjain0.perfectplushies.client.model;

import io.github.sirjain0.perfectplushies.Constants;
import io.github.sirjain0.perfectplushies.item.PlayerPlushieBlockItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

import java.util.HashMap;
import java.util.Map;

public class PlayerPlushieBlockItemModel extends GeoModel<PlayerPlushieBlockItem> {

    public final ResourceLocation modDevDoll = new ResourceLocation(Constants.MODID, "geo/player_plushie.geo.json");
    public final Map<ResourceLocation, ResourceLocation> textures = new HashMap<>();
    public final ResourceLocation noAnimations = new ResourceLocation(Constants.MODID, "animations/none.animation.json");


    @Override
    public ResourceLocation getModelResource(PlayerPlushieBlockItem animatable) {
        return modDevDoll;
    }

    @Override
    public ResourceLocation getTextureResource(PlayerPlushieBlockItem animatable) {
        return textures.computeIfAbsent(BuiltInRegistries.ITEM.getKey(animatable), blockRL -> new ResourceLocation(Constants.MODID, "textures/block/" + blockRL.getPath() + ".png"));
    }

    @Override
    public ResourceLocation getAnimationResource(PlayerPlushieBlockItem animatable) {
        return noAnimations;
    }
}
