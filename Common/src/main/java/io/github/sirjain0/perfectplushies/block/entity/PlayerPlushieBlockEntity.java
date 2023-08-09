package io.github.sirjain0.perfectplushies.block.entity;

import io.github.sirjain0.perfectplushies.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class PlayerPlushieBlockEntity extends BlockEntity implements GeoBlockEntity {
    private AnimatableInstanceCache animatableManager = GeckoLibUtil.createInstanceCache(this);
    public PlayerPlushieBlockEntity(BlockPos pos, BlockState state) {
        super(BlockInit.PLAYER_PLUSHIE_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animatableManager;
    }
}
