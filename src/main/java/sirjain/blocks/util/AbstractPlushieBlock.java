package sirjain.blocks.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

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
}
