package com.toonystank.skiesutilsbungee.Configs;

import com.toonystank.skiesutilsbungee.SkiesUtilsBungee;
import com.toonystank.skiesutilsbungee.utils.ConfigManager;

public class MainConfig extends ConfigManager {

    private SkiesUtilsBungee plugin;

    public MainConfig(SkiesUtilsBungee plugin) throws Exception {
        super(plugin, "config.yml", false, true);
    }

    public int getLimit() {
        return this.getInt("player-limit");
    }
    public String getByPassPermission() {
        return this.getString("bypass-permission");
    }
    public boolean isIpLimitEnabled() {
        return this.getBoolean("ip-limit.enabled");
    }
    public int getIpLimit() {
        return this.getInt("ip-limit.limit");
    }
    public String getPrefix() {
        return this.getString("message.prefix");
    }
    public String getNoPermission() {
        return this.getString("message.no_permission");
    }
    public String getKickMessage() {
        return this.getString("message.kick");
    }
    public String getReloadMessage() {
        return this.getString("message.reload");
    }
    public String getRemoveAltMessage() {
        return this.getString("message.remove_alt");
    }
    public String getMainAccountMessage() {
        return this.getString("message.main_account");
    }
    public String getAltAccountMessage() {
        return this.getString("message.alt_account");
    }
    public String getNoAltAccountMessage() {
        return this.getString("message.no_alt_account");
    }
}
