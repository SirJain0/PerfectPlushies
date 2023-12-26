package io.github.sirjain0.perfectplushies.block;

import io.github.sirjain0.perfectplushies.block.entity.PlayerPlushieBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class PlayerPlushieBlock extends PlushieBlock implements EntityBlock {
    @Override
    public RenderShape getRenderShape(BlockState $$0) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new PlayerPlushieBlockEntity(blockPos, blockState);
    }

    @Override
    public String getMessageSender() {
        return "Player Plushie";
    }
}