package jonty.designer.blocks.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.Direction;

public class OneWayWindowBlock extends AbstractDirectionalBlock {
    public OneWayWindowBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        if (stateFrom.isOf(this)) {
            return true;
        } else {
            return super.isSideInvisible(state, stateFrom, direction);
        }
    }
}