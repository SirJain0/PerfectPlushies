package io.github.sirjain0.perfectplushies.block;

import com.nyfaria.perfectplushieapi.block.PlayerPlushieBlock;
import io.github.sirjain0.perfectplushies.block.entity.PPPlayerPlushieBE;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class PPPlayerPlushieBlock extends PlayerPlushieBlock implements EntityBlock {

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new PPPlayerPlushieBE(blockPos, blockState);
    }
}