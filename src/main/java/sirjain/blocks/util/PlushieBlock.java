package sirjain.blocks.util;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public class PlushieBlock extends Block {
	private static final VoxelShape OUTLINE_SHAPE = Block.createCuboidShape(3, 0, 3, 13, 10, 13);

	public PlushieBlock() {
		super(FabricBlockSettings.of(Material.WOOL)
			.nonOpaque()
			.sounds(BlockSoundGroup.WOOL)
			.strength(0.5f, 0.5f)
			.luminance((state) -> 3)
		);
	}

	// Defines hitbox for all plushies
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return OUTLINE_SHAPE;
	}

	// Handles plushie's chat message and displays particles on right click
	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (!world.isClient) {
			Random randomNum = world.random;

			if (randomNum.nextInt(2) == 1) {
				MinecraftServer server = world.getServer();
				if (server == null) return ActionResult.PASS;

				List<ServerPlayerEntity> serverList = server.getPlayerManager().getPlayerList();

				for (ServerPlayerEntity serverPlayer : serverList) {
					serverPlayer.sendMessage(Text.literal("[Plushie]").formatted(Formatting.GRAY).append("Hehe!"));
				}
			}
		}

		if (world.isClient) {
			world.addParticle(
				ParticleTypes.HEART,
				pos.getX() + (world.random.nextInt(2)),
				pos.getY(),
				pos.getZ() + (world.random.nextInt(2)),
				0, 0, 0
			);
		}

		return ActionResult.SUCCESS;
	}
}