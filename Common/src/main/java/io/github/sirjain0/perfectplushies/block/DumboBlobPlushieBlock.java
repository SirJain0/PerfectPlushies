package io.github.sirjain0.perfectplushies.block;

import com.mojang.serialization.MapCodec;
import com.nyfaria.perfectplushieapi.block.RandomDualColoredPlushieBlock;
import io.github.sirjain0.perfectplushies.block.entity.PPDualColorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import javax.annotation.*;

public class DumboBlobPlushieBlock extends RandomDualColoredPlushieBlock implements EntityBlock {
    public static final MapCodec<DumboBlobPlushieBlock> CODEC = simpleCodec(properties -> new DumboBlobPlushieBlock());

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public RenderShape getRenderShape(BlockState $$0) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult blockHitResult) {
        if(level.getBlockEntity(pos) instanceof PPDualColorBlockEntity ppdcbe) {
            ppdcbe.triggerAnim("base_controller","click");
        }
        return super.useWithoutItem(state, level, pos, player, blockHitResult);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new PPDualColorBlockEntity(blockPos, blockState);
    }


    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}