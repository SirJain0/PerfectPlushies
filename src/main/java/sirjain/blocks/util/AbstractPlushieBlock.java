package sirjain.blocks.util;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

abstract public class AbstractPlushieBlock extends Block {
	private static final VoxelShape OUTLINE_SHAPE = Block.createCuboidShape(3, 0, 3, 13, 10, 13);

	public AbstractPlushieBlock(Settings settings) {
		super(settings);
	}

	// Defines hitbox for all plushies
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return OUTLINE_SHAPE;
	}

	// Displays particles
	@Override
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
		world.addParticle(
			ParticleTypes.HEART,
			+ pos.getX() + (world.random.nextInt(2)),
			pos.getY(),
			+ pos.getZ() + (world.random.nextInt(2)),
			0, 0, 0
		);
	}

	// Sends chat message
	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (!world.isClient) {
			MinecraftServer server = world.getServer();
			List<ServerPlayerEntity> serverList = server.getPlayerManager().getPlayerList();

			for (ServerPlayerEntity serverPlayer : serverList) {
				serverPlayer.sendMessage(Text.literal("Hehe!"));
			}
		}

		return ActionResult.SUCCESS;
	}
}