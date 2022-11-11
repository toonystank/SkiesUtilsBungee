package com.toonystank.skiesutilsbungee;

import com.toonystank.skiesutilsbungee.iplimiter.IPLimit;
import com.toonystank.skiesutilsbungee.iplimiter.IPLimitCache;
import com.toonystank.skiesutilsbungee.listener.JoinEvent;
import com.toonystank.skiesutilsbungee.utils.ConfigManager;
import lombok.Getter;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.IOException;

public final class SkiesUtilsBungee extends Plugin {

    @Getter
    private ConfigManager mainConfig;
    @Getter
    private IPLimit ipLimit;

    @Override
    public void onEnable() {

        try {
            mainConfig = new ConfigManager(this, "config.yml", "config", false, false);
            ipLimit = new IPLimit(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
