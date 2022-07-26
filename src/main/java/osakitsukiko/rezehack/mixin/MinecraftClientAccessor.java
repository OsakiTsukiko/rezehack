package osakitsukiko.rezehack.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Session;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MinecraftClient.class)
public interface MinecraftClientAccessor {

    @Accessor("currentFps")
    static int getFps() {
        return 0;
    }

    @Mutable
    @Accessor("session")
    void setSession(Session session);
}
