package io.github.sirjain0.perfectplushies.client.renderer;

import io.github.sirjain0.perfectplushies.client.model.PlayerPlushieBlockItemModel;
import io.github.sirjain0.perfectplushies.item.PlayerPlushieBlockItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class PlayerPlushieBlockItemRenderer extends GeoItemRenderer<PlayerPlushieBlockItem> {
    public PlayerPlushieBlockItemRenderer() {
        super(new PlayerPlushieBlockItemModel());
    }
}
