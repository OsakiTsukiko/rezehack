package osakitsukiko.rezehack.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import osakitsukiko.rezehack.RezeHack;

import java.io.IOException;
import java.io.InputStream;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {
    @Inject(method = "getWindowTitle", at = @At("HEAD"), cancellable = true)
    public void getWindowTitle(CallbackInfoReturnable<String> ci){
        ci.setReturnValue(RezeHack.clientVersionString);
    }

    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/Window;setIcon(Ljava/io/InputStream;Ljava/io/InputStream;)V"))
    public void setAlternativeWindowIcon(Window window, InputStream inputStream1, InputStream inputStream2) throws IOException {
        window.setIcon(
                RezeHack.class.getResourceAsStream("/assets/rezehack/128x128.png"),
                RezeHack.class.getResourceAsStream("/assets/rezehack/256x256.png")
        );
    }
}
