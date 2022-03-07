package is.sly.dungeonmodpack.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraftforge.client.GuiIngameForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(GuiIngameForge.class)
public class MixinWitherRender extends GuiIngame {
    public MixinWitherRender(Minecraft mcIn) {
        super(mcIn);
    }

    @ModifyVariable(
            method = "renderHealth",
            print = true,
            remap = false,
            name = "MARGIN",
            at = @At(value = "STORE")
    )
    private int renderHealth(int x) {
        EntityPlayer player = (EntityPlayer) this.mc.getRenderViewEntity();
        if (player != null && player.isPotionActive(MobEffects.WITHER) && !player.isPotionActive(MobEffects.POISON)) {
            x = x - 72;
        }
        return x;
    }
}
