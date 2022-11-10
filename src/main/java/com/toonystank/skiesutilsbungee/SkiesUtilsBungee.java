package com.toonystank.skiesutilsbungee;

import com.toonystank.skiesutilsbungee.listener.JoinEvent;
import net.md_5.bungee.api.plugin.Plugin;

public final class SkiesUtilsBungee extends Plugin {

    @Override
    public void onEnable() {
        this.getProxy().getPluginManager().registerListener(this, new JoinEvent());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
