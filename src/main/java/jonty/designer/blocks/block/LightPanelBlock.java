package jonty.designer.blocks.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class LightPanelBlock extends AbstractDirectionalBlock{
    public LightPanelBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return super.getCollisionShape(state, world, pos, context);
    }

    @Override2
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        switch(dir) {
            case NORTH:
                return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0625f);
            case SOUTH:
                return VoxelShapes.cuboid(0.0f, 0.0f, 0.0625f, 1.0f, 1.0f, 1.0f);
            case EAST:
                return VoxelShapes.cuboid(0.0625f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            case WEST:
                return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 0.0625f, 1.0f, 1.0f);
            case UP:
                return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 1-0.0625f, 1.0f);
            case DOWN:
                return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 0.0625f, 1.0f);
            default:
                return VoxelShapes.fullCube();
}
