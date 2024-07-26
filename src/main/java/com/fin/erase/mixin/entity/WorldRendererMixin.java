package com.fin.erase.mixin.entity;

import com.fin.erase.Main;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {
    @Inject(at = @At("HEAD"), method = "renderEntity", cancellable = true)
    private void deleteEntity(Entity entity, double cameraX, double cameraY, double cameraZ, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, CallbackInfo ci) {
        if(Main.settings.entitySettings.deleteEntity) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "drawEntityOutlinesFramebuffer", cancellable = true)
    private void drawEntityOutlinesFramebuffer(CallbackInfo ci) {
        if (Main.settings.entitySettings.deleteEntity) ci.cancel();
    }
}
