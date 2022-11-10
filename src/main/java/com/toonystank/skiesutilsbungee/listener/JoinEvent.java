package com.toonystank.skiesutilsbungee.listener;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.logging.Logger;

public class JoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PostLoginEvent event) {
        for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
            Logger.getLogger("SkiesUtilsBungee").info("Player " + event.getPlayer().getName() + " joined the server.");
            Logger.getLogger("SkiesUtilsBungee").info(player.getPendingConnection().getSocketAddress().toString());
        }
    }
}
