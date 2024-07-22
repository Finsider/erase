package com.fin.erase.mixin;

import com.fin.erase.Main;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.BossBarHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BossBarHud.class)
public class bossbarhud {

    @Inject(at = @At("HEAD"), method = "render", cancellable = true)
    private void bossbar(DrawContext context, CallbackInfo ci) {
        if (Main.settings.inGameHudSettings.deleteBossBars) ci.cancel();
    }
}
