package net.endkind.enderjoin;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        FileConfiguration config = EnderJoin.getInstance().getConfig();

        if (!config.getBoolean("join.enabled")) {
            event.setJoinMessage(null);
            return;
        }

        String playerName = event.getPlayer().getName();
        String joinMessage = ChatColor.translateAlternateColorCodes('&', config.getString("join.message")).replace("{player}", playerName);
        event.setJoinMessage(joinMessage);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        FileConfiguration config = EnderJoin.getInstance().getConfig();

        if (!config.getBoolean("leave.enabled")) {
            event.setQuitMessage(null);
            return;
        }

        String playerName = event.getPlayer().getName();
        String quitMessage = ChatColor.translateAlternateColorCodes('&', config.getString("leave.message")).replace("{player}", playerName);
        event.setQuitMessage(quitMessage);
    }
}
