package is.sly.dungeonmodpack.mixins;

import is.sly.dungeonmodpack.DungeonMods;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.block.model.IBakedModel;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(BlockModelShapes.class)
@MethodsReturnNonnullByDefault
public class MixinBlockModelShapes {

    @Final
    @Shadow
    private Map<IBlockState, IBakedModel> bakedModelStore;

    @Inject(method = "getModelForState", at = @At("HEAD"), cancellable = true)
    public void getModelForState(IBlockState state, CallbackInfoReturnable<IBakedModel> cir) {
        if (state.toString().equals("minecraft:barrier")) {
            cir.setReturnValue(bakedModelStore.get(DungeonMods.visibleBarrier.getDefaultState()));
        }
    }
}
