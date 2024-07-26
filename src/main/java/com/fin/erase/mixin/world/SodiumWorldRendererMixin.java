package com.fin.erase.mixin.world;

import com.fin.erase.Main;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import me.jellysquid.mods.sodium.client.render.SodiumWorldRenderer;
import net.minecraft.client.render.BlockBreakingInfo;
import net.minecraft.client.render.BufferBuilderStorage;
import net.minecraft.client.render.Camera;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.SortedSet;

@Mixin(SodiumWorldRenderer.class)
public class SodiumWorldRendererMixin {
    @Inject(at = @At("HEAD"), method = "renderBlockEntities(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/BufferBuilderStorage;Lit/unimi/dsi/fastutil/longs/Long2ObjectMap;Lnet/minecraft/client/render/Camera;F)V",cancellable = true)
    private void deleteSodiumBlockEntitiesRender(MatrixStack matrices, BufferBuilderStorage bufferBuilders, Long2ObjectMap<SortedSet<BlockBreakingInfo>> blockBreakingProgressions, Camera camera, float tickDelta, CallbackInfo ci) {
        if(Main.settings.worldSettings.deleteBlockEntities) ci.cancel();
    }
}
