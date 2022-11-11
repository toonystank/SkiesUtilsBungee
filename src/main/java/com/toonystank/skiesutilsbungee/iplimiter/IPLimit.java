package com.toonystank.skiesutilsbungee.iplimiter;

import com.toonystank.skiesutilsbungee.Configs.MainConfig;
import com.toonystank.skiesutilsbungee.SkiesUtilsBungee;
import lombok.Data;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Data
public class IPLimit {

    private SkiesUtilsBungee plugin;
    private MainConfig mainConfig;
    private IPLimitData userIPLimitData;
    private Map<String,IPLimitCache> cache = new HashMap<>();

    public IPLimit(SkiesUtilsBungee plugin) throws IOException {
        this.plugin = plugin;
        userIPLimitData = new IPLimitData(plugin, "data.yml");
        plugin.getProxy().getScheduler().schedule(plugin,this::process,1, TimeUnit.SECONDS);
    }

    private void process() {
        for (String uuid: userIPLimitData.getPlayers()) {
            cache.put(uuid, new IPLimitCache(userIPLimitData, uuid, userIPLimitData.getIp(uuid), userIPLimitData.getName(uuid)));
        }
        registerEvents();
    }

    private void registerEvents() {
        plugin.getProxy().getPluginManager().registerListener(plugin, new IPLimitPlayerJoin(plugin, mainConfig, this));
    }

    public IPLimitReturnType canAllow(ProxiedPlayer player) {
        return canAllow(player.getUniqueId().toString(), player.getPendingConnection().getSocketAddress().toString(), player.getName());
    }
    public IPLimitReturnType canAllow(String uuid, String ip, String name) {
        if (mainConfig.isIpLimitDisabled()) return IPLimitReturnType.SUCCESS;
        IPLimitCache cache = this.cache.get(uuid);
        if (cache.getIp().equals(ip)) {
            if (cache.isMain() || cache.getAlts().contains(uuid)) {
                return IPLimitReturnType.SUCCESS;
            }
            if (cache.getAlts().size() >= mainConfig.getIPLimit()) {
                return IPLimitReturnType.MAX_ALTS;
            }
            cache.addAlt(uuid);
            return IPLimitReturnType.ALT;
        } else {
            this.cache.put(uuid,new IPLimitCache(userIPLimitData, uuid, ip, name));
            return IPLimitReturnType.SUCCESS;
        }
    }
    public @Nullable String getOwnerUUID(String altUUID) {
        for (String uuid: cache.keySet()) {
            if (cache.get(uuid).getAlts().contains(altUUID)) return uuid;
        }
        return null;
    }
}
