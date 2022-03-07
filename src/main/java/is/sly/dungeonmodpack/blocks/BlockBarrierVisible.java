package is.sly.dungeonmodpack.blocks;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.BlockBarrier;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;

@MethodsReturnNonnullByDefault
public class BlockBarrierVisible extends BlockBarrier {

    public BlockBarrierVisible() {
        super();
        this.setBlockUnbreakable();
        this.setResistance(6000001.0F);
        this.disableStats();
        this.translucent = true;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}
