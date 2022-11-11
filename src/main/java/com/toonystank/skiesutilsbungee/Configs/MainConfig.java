package com.toonystank.skiesutilsbungee.Configs;

import com.toonystank.skiesutilsbungee.SkiesUtilsBungee;
import com.toonystank.skiesutilsbungee.utils.ConfigManager;

public class MainConfig extends ConfigManager {

    private SkiesUtilsBungee plugin;

    public MainConfig(SkiesUtilsBungee plugin) throws Exception {
        super(plugin, "config.yml", false, true);
    }




    public String getPrefix() {
        return this.getString("message.prefix");
    }
    public String getNoPermission() {
        return this.getString("message.no_permission");
    }
    public String getReloadMessage() {
        return this.getString("message.reload");
    }

    public String getIPLimitByPassPermission() {
        return this.getString("ip-limit.bypass-permission");
    }
    public int getIPLimit() {
        return this.getInt("player-limit");
    }
    public boolean isIpLimitDisabled() {
        return !this.getBoolean("ip-limit.enabled");
    }
    public String getIPLimitKickMessage() {
        return this.getString("ip-limit.message.kick");
    }
    public String getIPLimitRemoveAltMessage() {
        return this.getString("ip-limit.message.remove_alt");
    }
    public String getIPLimitMainAccountMessage() {
        return this.getString("ip-limit.message.main_account");
    }
    public String getIPLimitAltAccountMessage() {return this.getString("ip-limit.message.alt_account");}
    public String getIPLimitNoAltAccountMessage() {
        return this.getString("ip-limit.message.no_alt_account");
    }

}
