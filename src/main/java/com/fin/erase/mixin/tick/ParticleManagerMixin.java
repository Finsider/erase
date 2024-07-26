package com.fin.erase.mixin.tick;

import com.fin.erase.Main;
import net.minecraft.client.particle.ParticleManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ParticleManager.class)
public class ParticleManagerMixin {

    @Inject(at = @At("HEAD"), method = "tick", cancellable = true)
    private void deleteParticleTick(CallbackInfo ci) {
        if(Main.settings.tickSettings.deleteParticleTick) ci.cancel();
    }
}
