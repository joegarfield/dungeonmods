package is.sly.dungeonmodpack.mixins;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBarrier;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.ParametersAreNonnullByDefault;

@Mixin(BlockBarrier.class)
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class MixinBlockBarrier extends Block {

    public MixinBlockBarrier(Material materialIn) {
        super(materialIn);
    }

    @Inject(method = "getRenderType", at = @At("HEAD"), cancellable = true)
    public void getRenderType(IBlockState state, CallbackInfoReturnable<EnumBlockRenderType> cir) {
        cir.setReturnValue(EnumBlockRenderType.MODEL);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }


    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }


}
