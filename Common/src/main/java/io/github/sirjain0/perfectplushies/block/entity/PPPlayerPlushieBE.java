package io.github.sirjain0.perfectplushies.block.entity;

import com.nyfaria.perfectplushieapi.block.entity.PlayerPlushieBlockEntity;
import io.github.sirjain0.perfectplushies.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class PPPlayerPlushieBE extends PlayerPlushieBlockEntity implements GeoBlockEntity {

    public PPPlayerPlushieBE(BlockPos pos, BlockState state) {
        super(BlockInit.PLAYER_PLUSHIE_BLOCK_ENTITY.get(), pos, state);
    }

}
