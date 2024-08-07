package com.fin.erase.mixin.skyfog;

import com.fin.erase.Main;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {

    @Inject(at = @At("HEAD"), method = "renderSky(Lnet/minecraft/client/util/math/MatrixStack;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V", cancellable = true)
    private void deleteSky(MatrixStack matrices, Matrix4f projectionMatrix, float tickDelta, Camera camera, boolean thickFog, Runnable fogCallback, CallbackInfo ci) {
        if(Main.settings.fogSkySettings.deleteSky) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderLayer", cancellable = true)
    private void deleteRenderLayer(RenderLayer renderLayer, MatrixStack matrices, double cameraX, double cameraY, double cameraZ, Matrix4f positionMatrix, CallbackInfo ci) {
        if (Main.settings.worldSettings.deleteWorld) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderWeather", cancellable = true)
    private void deleteWeather(LightmapTextureManager manager, float tickDelta, double cameraX, double cameraY, double cameraZ, CallbackInfo ci) {
        if(Main.settings.fogSkySettings.deleteWeather) ci.cancel();
    }
}
