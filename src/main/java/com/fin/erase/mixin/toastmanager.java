package com.fin.erase.mixin;

import com.fin.erase.Main;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.toast.ToastManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ToastManager.class)
public class toastmanager {

    @Inject(at = @At("HEAD"), method = "draw", cancellable = true)
    private void deleteToasts(DrawContext context, CallbackInfo ci) {
        if (Main.settings.inGameHudSettings.deleteToasts) ci.cancel();
    }
}
