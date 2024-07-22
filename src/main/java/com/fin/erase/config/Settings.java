package com.fin.erase.config;


import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "erase")
public class Settings implements ConfigData {
    @ConfigEntry.Gui.CollapsibleObject
    public FogSkySettings fogSkySettings = new FogSkySettings();
    public static class FogSkySettings {
        @Comment("turn off sodium fog occlusion culling.")
        public boolean deleteFog = false;

        public boolean deleteSky = false;
        public boolean deleteSkyBackground = false;
        public boolean deleteWeather = false;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public InGameHudSettings inGameHudSettings = new InGameHudSettings();
    public static class InGameHudSettings {

        @Comment("Disabling this will disable everything else on this category.")
        public boolean deleteInGameHud = false;

        public boolean deleteScoreboard = false;
        public boolean deleteBossBars = false;
        public boolean deleteCrosshair = false;
        public boolean deleteHotbar = false;
        public boolean deleteExperienceBar = false;
        public boolean deleteHeart = false;

        @Comment("this includes heart, hunger, armor, drown.")
        public boolean deleteStatusBars = false;
        public boolean deleteHeldItemTooltips = false;
        public boolean disableTitle = false;
        public boolean disableSubtitle = false;
        public boolean disableActionBar = false;
        public boolean deleteMountHud = false;
        public boolean deleteStatusEffectOverlay = false;
        public boolean deleteFireOverlay = false;
        public boolean deleteToasts = false;

        @Comment("this includes spyglass, pumpkin, freeze, portal, nausea.")
        public boolean deleteOverlay = false;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public GuiSettings guiSettings = new GuiSettings();
    public static class GuiSettings {
        @Comment("disabling this will disable everything below except background.")
        public boolean deleteGui = false;

        @Comment("This will cause just.. just a tiny bit of rendering issue on menu screen :)")
        public boolean deleteGuiBackground = false;
        public boolean deleteGuiForeground = false;
        public boolean deleteSlotHover = false;
        public boolean deleteInventoryTooltip = false;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public WorldSettings worldSettings = new WorldSettings();
    public static class WorldSettings {
    public boolean deleteParticle = false;
    @Comment("(requires game restart if sodium is present), enabling this will broke world saving, so don't use it in singleplayer.")
    public boolean deleteLight = false;
    public boolean deleteHand = false;
    public boolean deleteWorld = false;
    public boolean deleteEntity = false;

    @Comment("(requires sodium), this deletes beacon beam, player heads, sign TEXT, chests.")
    public boolean deleteBlockEntities = false;
    }
}
