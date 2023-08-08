package io.github.sirjain0.perfectplushies.client.renderer;

import io.github.sirjain0.perfectplushies.block.entity.PlayerPlushieBlockEntity;
import io.github.sirjain0.perfectplushies.client.model.PlayerPlushieModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class PlushieRenderer extends GeoBlockRenderer<PlayerPlushieBlockEntity> {
    public PlushieRenderer() {
        super(new PlayerPlushieModel());
    }
}
