package osakitsukiko.rezehack.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import osakitsukiko.rezehack.modules.Module;
import osakitsukiko.rezehack.modules.ModuleManager;

@Mixin(InGameHud.class)
public class MixinInGameHud {
    @Inject(at = @At(value = "RETURN"), method = "render", cancellable = true)
    public void render(MatrixStack matrixStack, float float_1, CallbackInfo info) {
        ModuleManager.modules.stream().filter(Module::isEnabled).forEach(module -> {module.onRender(matrixStack);});
    }
}
