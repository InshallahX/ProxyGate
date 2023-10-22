package com.jozho.proxygate;

import net.md_5.bungee.api.ChatColor;

public enum MessagePreset {
    PLAYER_ADDED("&aAdded &e%s &ato the whitelist"),
    PLAYER_REMOVED("&cRemoved &7%s &cfrom the whitelist"),
    USAGE("&cUsage: /whitelist <add/remove> <player>"),
    CONSOLE_ONLY("&4Sorry, this command can only be used by the console."),
    CREATE_DATA("&9Data file (data.yml) has been created successfully."),
    NO_PERMISSION("&dYou do not have the required permission to execute this command."),
    NOT_AUTHORIZE("&cYou are not authorized to join this proxy.");
    private String message;
    MessagePreset(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return ChatColor.translateAlternateColorCodes('&', this.message);
    }
}
