package com.toonystank.skiesutilsbungee.iplimiter;

import com.toonystank.skiesutilsbungee.SkiesUtilsBungee;
import lombok.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class IPLimit {

    private SkiesUtilsBungee plugin;
    private IPLimitData userIPLimitData;
    private List<IPLimitCache> userIPLimitCacheList = new ArrayList<>();

    public IPLimit(SkiesUtilsBungee plugin) throws IOException {
        this.plugin = plugin;
        userIPLimitData = new IPLimitData(plugin, "data.yml");
    }

    private void process() {
        for (String uuid: userIPLimitData.getPlayers()) {
            userIPLimitCacheList.add(new IPLimitCache(userIPLimitData, uuid, userIPLimitData.getIp(uuid)));
        }
    }
}
