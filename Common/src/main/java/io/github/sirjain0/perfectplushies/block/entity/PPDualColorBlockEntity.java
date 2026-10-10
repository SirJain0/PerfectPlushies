package io.github.sirjain0.perfectplushies.block.entity;

import com.nyfaria.perfectplushieapi.block.entity.ColoredPlushieBlockEntity;
import io.github.sirjain0.perfectplushies.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;

public class PPDualColorBlockEntity extends ColoredPlushieBlockEntity {

    public PPDualColorBlockEntity(BlockPos pos, BlockState state) {
        super(BlockInit.PP_COLOR_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, this::animate)
                .triggerableAnim("click", RawAnimation.begin().thenPlay("click"))
        );
    }

    private PlayState animate(AnimationState<PPDualColorBlockEntity> ppDualColorBlockEntityAnimationState) {
        return PlayState.CONTINUE;
    }
}
