package io.github.sirjain0.perfectplushies.item;

import io.github.sirjain0.perfectplushies.init.ItemInit;
import io.github.sirjain0.perfectplushies.platform.Services;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class PlayerPlushieBlockItem extends BlockItem implements GeoItem, NeededForML {

    private final AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);
    public PlayerPlushieBlockItem(Block block) {
        super(block, ItemInit.getItemProperties());
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animatableInstanceCache;
    }

    public Supplier<Object> getRenderProvider() {
        return Services.PLATFORM.getRenderProvider(this);
    }

    public void createRenderer(Consumer<Object> consumer) {
        Services.PLATFORM.registerFabricRenderer(consumer);
    }
}
