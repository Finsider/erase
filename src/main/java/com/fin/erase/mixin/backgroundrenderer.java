package com.fin.erase.mixin;

import com.fin.erase.Main;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BackgroundRenderer.class)
public class backgroundrenderer {

    @Inject(at = @At("HEAD"), method = "render", cancellable = true)
    private static void deleteSkyBackground(Camera camera, float tickDelta, ClientWorld world, int viewDistance, float skyDarkness, CallbackInfo ci) {
        if(Main.settings.fogSkySettings.deleteSkyBackground) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "applyFog", cancellable = true)
    private static void deleteFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
        if(Main.settings.fogSkySettings.deleteFog) ci.cancel();
    }
}
