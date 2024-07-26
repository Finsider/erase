package com.fin.erase.mixin.hud;

import com.fin.erase.Main;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.JumpingMount;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    @Inject(at = @At("HEAD"), method = "render", cancellable = true)
    private void deleteInGameHud(DrawContext context, float tickDelta, CallbackInfo ci) {
        if(Main.settings.inGameHudSettings.deleteInGameHud) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "tick(Z)V", cancellable = true)
    private void deleteInGameHudTick(boolean paused, CallbackInfo ci) {
        if (Main.settings.inGameHudSettings.deleteInGameHud) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderHotbar", cancellable = true)
    private void deleteHotbar(float tickDelta, DrawContext context, CallbackInfo ci) {
        if(Main.settings.inGameHudSettings.deleteHotbar) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderExperienceBar", cancellable = true)
    private void deleteExpBar(DrawContext context, int x, CallbackInfo ci) {
        if(Main.settings.inGameHudSettings.deleteExperienceBar) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderHealthBar", cancellable = true)
    private void deleteHeart(DrawContext context, PlayerEntity player, int x, int y, int lines, int regeneratingHeartIndex, float maxHealth, int lastHealth, int health, int absorption, boolean blinking, CallbackInfo ci) {
        if(Main.settings.inGameHudSettings.deleteHeart) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderStatusBars", cancellable = true)
    private void deleteStatusBars(DrawContext context, CallbackInfo ci) {
        if(Main.settings.inGameHudSettings.deleteStatusBars) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderHeldItemTooltip", cancellable = true)
    private void deleteItemTooltips(DrawContext context, CallbackInfo ci) {
        if(Main.settings.inGameHudSettings.deleteHeldItemTooltips) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "setSubtitle", cancellable = true)
    private void disableSubtitle(Text subtitle, CallbackInfo ci) {
        if(Main.settings.inGameHudSettings.disableSubtitle) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "setTitle", cancellable = true)
    private void disableTitle(Text subtitle, CallbackInfo ci) {
        if(Main.settings.inGameHudSettings.disableTitle) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "setOverlayMessage", cancellable = true)
    private void disableActionBar(Text message, boolean tinted, CallbackInfo ci) {
        if(Main.settings.inGameHudSettings.disableActionBar) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderScoreboardSidebar", cancellable = true)
    private void deleteScoreboard(DrawContext context, ScoreboardObjective objective, CallbackInfo ci) {
        if(Main.settings.inGameHudSettings.deleteScoreboard) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderStatusEffectOverlay", cancellable = true)
    private void deleteStatusEffectOverlay(DrawContext context, CallbackInfo ci) {
        if(Main.settings.inGameHudSettings.deleteStatusEffectOverlay) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderMountHealth", cancellable = true)
    private void deleteMountHud(DrawContext context, CallbackInfo ci) {
        if(Main.settings.inGameHudSettings.deleteMountHud) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderMountJumpBar", cancellable = true)
    private void deleteMountHud(JumpingMount mount, DrawContext context, int x, CallbackInfo ci) {
        if(Main.settings.inGameHudSettings.deleteMountHud) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderOverlay", cancellable = true)
    private void deleteOverlay(DrawContext context, Identifier texture, float opacity, CallbackInfo ci) {
        if(Main.settings.inGameHudSettings.deleteOverlay) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderSpyglassOverlay", cancellable = true)
    private void deleteSpyglass(DrawContext context, float scale, CallbackInfo ci) {
        if(Main.settings.inGameHudSettings.deleteOverlay) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderPortalOverlay", cancellable = true)
    private void deletePortal(DrawContext context, float nauseaStrength, CallbackInfo ci) {
        if(Main.settings.inGameHudSettings.deleteOverlay) ci.cancel();
    }

    @Inject(at = @At("HEAD"), method = "renderCrosshair", cancellable = true)
    private void deleteCrosshair(DrawContext context, CallbackInfo ci) {
        if (Main.settings.inGameHudSettings.deleteCrosshair) ci.cancel();
    }
}
