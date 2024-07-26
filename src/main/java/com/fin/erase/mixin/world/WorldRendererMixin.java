package com.fin.erase.mixin.world;

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
    @Inject(at = @At("HEAD"), method = "renderLayer", cancellable = true)
    private void deleteRenderLayer(RenderLayer renderLayer, MatrixStack matrices, double cameraX, double cameraY, double cameraZ, Matrix4f positionMatrix, CallbackInfo ci) {
        if (Main.settings.worldSettings.deleteWorld) ci.cancel();
    }
}
