package com.jozho.proxygate.listener;

import com.jozho.proxygate.MessagePreset;
import com.jozho.proxygate.ProxyGate;
import net.md_5.bungee.api.connection.PendingConnection;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ConnectionListener implements Listener {

    private final ProxyGate plugin;

    public ConnectionListener(ProxyGate plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPreLogin(PreLoginEvent event) {
        PendingConnection connection = event.getConnection();
        String playerName = connection.getName();
        if (plugin.whitelist.isWhitelisted(playerName)) return;
        event.setCancelReason(MessagePreset.NOT_AUTHORIZE.getMessage());
        event.setCancelled(true);
    }

}
