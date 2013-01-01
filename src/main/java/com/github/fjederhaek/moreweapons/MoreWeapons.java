package com.github.fjederhaek.moreweapons;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
// You don't need to import from the same package

public class MoreWeapons extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getPluginManager().registerEvents(new WeaponEvents(), this);
        loadConfiguration();
    }

    public void loadConfiguration() {
        saveDefaultConfig(); // Copy default config from jar if one doesn't
                             // exist in the plugin's folder
        // no no no do not use capital letters in config! It doesn't work!
        messagePrefix = getConfig().getString("messages.prefix");
        prefixColor = ChatColor.getByChar(getConfig().getString("messages.colors.prefix"));
        messageColor = ChatColor.getByChar(getConfig().getString("messages.colors.message"));
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
        Killstreaks.killcount.clear();
        Killstreaks.killstreaks.clear();
    }
    
    private static String messagePrefix;
    private static ChatColor prefixColor;
    private static ChatColor messageColor;

    public static void message(CommandSender sender, String message) {

        if (sender instanceof Player) {
            sender.sendMessage(prefixColor + messagePrefix + " " + messageColor + message);
        } else {
            sender.sendMessage(messagePrefix + " " + message);
        }
    }
}
