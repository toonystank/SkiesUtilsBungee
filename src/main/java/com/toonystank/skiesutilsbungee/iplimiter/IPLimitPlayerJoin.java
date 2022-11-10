package com.toonystank.skiesutilsbungee.iplimiter;

import com.toonystank.skiesutilsbungee.Configs.MainConfig;
import com.toonystank.skiesutilsbungee.SkiesUtilsBungee;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class IPLimitPlayerJoin implements Listener {

    private final SkiesUtilsBungee plugin;
    private final MainConfig mainConfig;
    private final IPLimit ipLimit;

    public IPLimitPlayerJoin(SkiesUtilsBungee plugin, MainConfig mainConfig, IPLimit ipLimit) {
        this.plugin = plugin;
        this.mainConfig = mainConfig;
        this.ipLimit = ipLimit;
    }

    @EventHandler
    public void onPlayerJoin(PostLoginEvent event) {
        if (!mainConfig.isIpLimitEnabled()) return;
        String uuid = event.getPlayer().getUniqueId().toString();
        for (IPLimitCache cache : ipLimit.getUserIPLimitCacheList()) {
            if (cache.getUuid().toString().equals(uuid)) {

                if (cache.getData().getAltCount(uuid) >= mainConfig.getIpLimit()) {
                    plugin.getLogger().info("just a message so there is no warning");
                    return;
                }

            }
        }
    }

}
