package is.sly.dungeonmodpack.mixins;

import is.sly.dungeonmodpack.utils.ClientConnectionUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.GuiConnecting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiConnecting.class)
public class MixinGuiConnecting {

    @Inject(method = "connect", at = @At("HEAD"), cancellable = true)
    public void onProcessHandshake(final String ip, final int port, CallbackInfo ci) {
        if (ip.contains("shotbow.net")) {
            Minecraft mc = Minecraft.getMinecraft();
            if (!ClientConnectionUtils.isOnVPN() || !ClientConnectionUtils.limitedAccountPolicyUsers.contains(mc.getSession().getUsername())) {
                ci.cancel();
            }
        }
    }

}