package com.fin.erase.mixin.world;

import com.fin.erase.Main;
import net.minecraft.client.render.LightmapTextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightmapTextureManager.class)
public class LightmapTextureManagerMixin {

    @Inject(at = @At("HEAD"), method = "update", cancellable = true)
    private void disableLightMapUpdate(float delta, CallbackInfo ci) {
       if(Main.settings.worldSettings.deleteLight) ci.cancel();
    }
}
