package io.github.sirjain0.perfectplushies.block;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
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

import java.util.List;

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

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        if(!level.isClientSide){
            RandomSource randomNum = level.random;

            if (randomNum.nextInt(2) == 1) {
                MinecraftServer server = level.getServer();
                if (server == null) return InteractionResult.PASS;

                List<ServerPlayer> serverList = server.getPlayerList().getPlayers();

                for (ServerPlayer serverPlayer : serverList) {
                    serverPlayer.sendSystemMessage(Component.literal("[Plushie] ").withStyle(ChatFormatting.GRAY, ChatFormatting.BOLD).append("Hehe!"));
                }
            }
        } else {
            level.addParticle(ParticleTypes.HEART, pos.getX() + (level.random.nextInt(2)), pos.getY(), pos.getZ() + (level.random.nextInt(2)), 0, 0, 0);
        }
        return InteractionResult.SUCCESS;
    }
}