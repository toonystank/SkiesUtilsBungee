package com.toonystank.skiesutilsbungee.iplimiter;

import lombok.Data;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class IPLimitCache {

    private final IPLimitData data;

    private ProxiedPlayer player;
    private UUID uuid;
    private String ip;
    private List<String> alts = new ArrayList<>();
    private boolean isMain = false;

    public IPLimitCache(IPLimitData data, ProxiedPlayer player) {
        this.data = data;
        this.player = player;
        this.uuid = player.getUniqueId();
        this.ip = player.getPendingConnection().getSocketAddress().toString();
        process();
    }
    public IPLimitCache(IPLimitData data, String uuid, String ip) {
        this.data = data;
        this.uuid = UUID.fromString(uuid);
        this.ip = ip;
        process();
    }

    private void process() {
        if (data.isAlt(String.valueOf(uuid)).getBoolean()) return;
        if (data.isPlayerInConfig(String.valueOf(uuid))) {
            isMain = true;
            this.alts = data.getAlts(player);
            return;
        }
        data.addPlayer(String.valueOf(uuid), ip);
    }

    public IPLimitReturnType addAlt(ProxiedPlayer player) {
        return addAlt(player.getUniqueId().toString());
    }
    public IPLimitReturnType addAlt(String altUUID) {
        if (data.isAlt(altUUID).getBoolean()) return IPLimitReturnType.ERROR;
        alts.add(altUUID);
        data.addAlt(String.valueOf(this.uuid), altUUID);
        return IPLimitReturnType.SUCCESS;
    }

}
