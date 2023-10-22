package com.jozho.proxygate;

import com.jozho.proxygate.commands.Whitelist;
import com.jozho.proxygate.listener.ConnectionListener;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.File;

public final class ProxyGate extends Plugin implements Listener {

    public DataManager whitelist;

    @Override
    public void onEnable() {
        whitelist = new DataManager(new File(getDataFolder(), "data.yml"));
        whitelist.loadData(); // Load the whitelist data
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Whitelist(this));
        ProxyServer.getInstance().getPluginManager().registerListener(this, new ConnectionListener(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
