package is.sly.dungeonmodpack.mixins;

import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(EntityRenderer.class)
public class MixinBlockOutline {
    @ModifyVariable(method = "isDrawBlockOutline", print = true, ordinal = 0,
            at = @At(value = "STORE", ordinal = 2))
    private boolean flag(boolean flag) {
        return true;
    }
}
