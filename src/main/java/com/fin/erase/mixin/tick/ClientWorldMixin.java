package com.fin.erase.mixin.tick;

import com.fin.erase.Main;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public class ClientWorldMixin {
    @Inject(at = @At("HEAD"), method = "doRandomBlockDisplayTicks", cancellable = true)
    private void deleteRandomBlockDisplayTicks(int centerX, int centerY, int centerZ, CallbackInfo ci) {
        if (Main.settings.tickSettings.deleteRandomBlockDisplayTick) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "tickEntities", cancellable = true)
    private void deleteEntitiesTick(CallbackInfo ci) {
        if (Main.settings.tickSettings.deleteEntityTicks) ci.cancel();
    }
}
