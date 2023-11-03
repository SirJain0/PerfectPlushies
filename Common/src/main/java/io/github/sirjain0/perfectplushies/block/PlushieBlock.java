package io.github.sirjain0.perfectplushies.block;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PlushieBlock extends HorizontalDirectionalBlock {
    private static final VoxelShape OUTLINE_SHAPE = Block.box(3, 0, 3, 13, 10, 13);

    // Constructor with pre-defined block settings
    public PlushieBlock() {
        super(BlockBehaviour.Properties.of()
                .noOcclusion()
                .sound(SoundType.WOOL)
                .strength(0.5f, 0.5f)
                .lightLevel((state) -> 3)
        );
    }

    // Defines hitbox for all plushies
    @Override
    public VoxelShape getShape(BlockState $$0, BlockGetter $$1, BlockPos $$2, CollisionContext $$3) {
        return OUTLINE_SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    // Handles facing direction

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return super.getStateForPlacement(ctx).setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    // Handles plushie's chat message and displays particles on right click
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        if (level.isClientSide) {
            RandomSource randomNum = level.random;

            if (randomNum.nextInt(2) == 1)
                player.sendSystemMessage(Component.literal("[" + getMessageSender() + "] ").withStyle(getMessageColor(), ChatFormatting.BOLD).append(getMessage()));

            level.addParticle(ParticleTypes.HEART, pos.getX() + (level.random.nextInt(2)), pos.getY(), pos.getZ() + (level.random.nextInt(2)), 0, 0, 0);
        }

        return InteractionResult.SUCCESS;
    }

    public String getMessageSender() {
        return "Plushie";
    }

    public ChatFormatting getMessageColor() {
        return ChatFormatting.GRAY;
    }

    public String getMessage() {
        return "Hehe!";
    }
}