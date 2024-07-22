package com.fin.erase.mixin;

import com.fin.erase.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameOverlayRenderer.class)
public class ingameoverlay {

    @Inject(at = @At("HEAD"), method = "renderFireOverlay", cancellable = true)
    private static void deleteFireOverlay(MinecraftClient client, MatrixStack matrices, CallbackInfo ci) {
        if(Main.settings.inGameHudSettings.deleteFireOverlay) ci.cancel();
    }
}
