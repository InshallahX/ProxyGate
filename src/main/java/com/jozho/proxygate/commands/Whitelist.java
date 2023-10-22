package com.jozho.proxygate.commands;

import com.jozho.proxygate.MessagePreset;
import com.jozho.proxygate.ProxyGate;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.Map;

public class Whitelist extends Command {

    private final ProxyGate plugin;

    public Whitelist(ProxyGate plugin) {
        super("whitelist");
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
         if (!(sender instanceof ProxiedPlayer)){
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("add")) {
                    String name = args[1];
                    plugin.whitelist.addWhitelist(name);
                    sender.sendMessage(String.format(MessagePreset.PLAYER_ADDED.getMessage(), name));
                } else if (args[0].equalsIgnoreCase("remove")) {
                    String name = args[1];
                    plugin.whitelist.removeWhitelist(name);
                    sender.sendMessage(String.format(MessagePreset.PLAYER_REMOVED.getMessage(), name));
                } else {
                    sender.sendMessage(MessagePreset.USAGE.getMessage());
                }
            } else if (args.length == 1 && args[0].equalsIgnoreCase("list")) {
                sender.sendMessage("Whitelisted Players:");
                for (Map.Entry<String, Boolean> entry : plugin.whitelist.getWhitelistData().entrySet()) {
                    String playerName = entry.getKey();
                    boolean isWhitelisted = entry.getValue();
                    if (isWhitelisted) {
                        sender.sendMessage("- " + playerName);
                    }
                }
            } else { // no args
                sender.sendMessage(MessagePreset.USAGE.getMessage());
            }
        } else {
             sender.sendMessage(MessagePreset.CONSOLE_ONLY.getMessage());
         }
    }

}
