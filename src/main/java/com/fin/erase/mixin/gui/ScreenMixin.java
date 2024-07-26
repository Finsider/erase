package com.fin.erase.mixin.gui;

import com.fin.erase.Main;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public class ScreenMixin {
    @Inject(at = @At("HEAD"), method = "renderBackground",cancellable = true)
    private void deleteGuiBackground(DrawContext context, CallbackInfo ci){
        if(Main.settings.guiSettings.deleteGuiBackground) ci.cancel();
    }
}
