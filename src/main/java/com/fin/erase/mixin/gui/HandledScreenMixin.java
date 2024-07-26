package com.fin.erase.mixin.gui;

import com.fin.erase.Main;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HandledScreen.class)
public class HandledScreenMixin {

    @Inject(at = @At("HEAD"), method = "render", cancellable = true)
    private void deleteGui(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if(Main.settings.guiSettings.deleteGui) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "drawForeground", cancellable = true)
    private void deleteGuiForeground(DrawContext context, int mouseX, int mouseY, CallbackInfo ci) {
        if(Main.settings.guiSettings.deleteGuiForeground) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "drawSlotHighlight", cancellable = true)
    private static void deleteSlotHover(DrawContext context, int x, int y, int z, CallbackInfo ci) {
        if(Main.settings.guiSettings.deleteSlotHover) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "drawMouseoverTooltip", cancellable = true)
    private void deleteGUITooltip(DrawContext context, int x, int y, CallbackInfo ci) {
        if (Main.settings.guiSettings.deleteInventoryTooltip) ci.cancel();
    }
}
