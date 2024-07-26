package com.fin.erase.mixin.tick;

import com.fin.erase.Main;
import net.minecraft.client.sound.SoundManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SoundManager.class)
public class SoundManagerMixin {
    @Inject(at = @At("HEAD"), method = "tick", cancellable = true)
    private void deleteSoundTick(boolean paused, CallbackInfo ci) {
        if (Main.settings.tickSettings.deleteSoundTick) ci.cancel();
    }
}
