package com.fin.erase.mixin.world;

import com.fin.erase.Main;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Inject(at = @At("HEAD"), method = "renderHand", cancellable = true)
    private void deleteHand(MatrixStack matrices, Camera camera, float tickDelta, CallbackInfo ci) {
        if(Main.settings.worldSettings.deleteHand) ci.cancel();
    }
}
