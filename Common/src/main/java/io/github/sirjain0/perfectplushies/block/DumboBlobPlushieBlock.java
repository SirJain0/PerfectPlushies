package io.github.sirjain0.perfectplushies.block;

import com.nyfaria.perfectplushieapi.block.RandomDualColoredPlushieBlock;
import io.github.sirjain0.perfectplushies.block.entity.PPDualColorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animation.AnimationController;

public class DumboBlobPlushieBlock extends RandomDualColoredPlushieBlock implements EntityBlock {
    @Override
    public RenderShape getRenderShape(BlockState $$0) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        if(level.getBlockEntity(pos) instanceof PPDualColorBlockEntity ppdcbe) {
            ppdcbe.triggerAnim("base_controller","click");
        }
        return super.use(state, level, pos, player, hand, blockHitResult);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new PPDualColorBlockEntity(blockPos, blockState);
    }


}