package com.fin.erase.mixin;

import com.fin.erase.Main;
import net.minecraft.world.chunk.light.LightingProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LightingProvider.class)
public class lightingprovider {

    @Inject(at = @At("HEAD"), method = "doLightUpdates", cancellable = true)
    private void disableLightUpdates(CallbackInfoReturnable<Integer> cir) {
       if(Main.settings.worldSettings.deleteLight) cir.setReturnValue(0);
    }
}
