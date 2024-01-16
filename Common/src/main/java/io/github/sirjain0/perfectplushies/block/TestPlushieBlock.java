package io.github.sirjain0.perfectplushies.block;

import io.github.sirjain0.perfectplushies.block.entity.PlayerPlushieBlockEntity;
import io.github.sirjain0.perfectplushies.block.entity.TestPlushieBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class TestPlushieBlock extends PlushieBlock implements EntityBlock {
    @Override
    public RenderShape getRenderShape(BlockState $$0) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new TestPlushieBlockEntity(blockPos, blockState);
    }

    @Override
    public void setPlacedBy(Level $$0, BlockPos $$1, BlockState $$2, @Nullable LivingEntity $$3, ItemStack $$4) {
        super.setPlacedBy($$0, $$1, $$2, $$3, $$4);
        if ($$0.getBlockEntity($$1) instanceof TestPlushieBlockEntity) {
            TestPlushieBlockEntity blockEntity = (TestPlushieBlockEntity) $$0.getBlockEntity($$1);
            if (blockEntity != null) {
                blockEntity.setRandomColor();
            }
        }
    }

    @Override
    public String getMessageSender() {
        return "Test Plushie";
    }
}