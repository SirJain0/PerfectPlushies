package sirjain.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

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
}
