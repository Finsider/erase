package com.fin.erase.mixin.tick;

import com.fin.erase.Main;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(at = @At("HEAD"), method = "tick", cancellable = true)
    private void deleteTick(CallbackInfo ci) {
        if (Main.settings.tickSettings.deleteTicks) ci.cancel();
    }
}
