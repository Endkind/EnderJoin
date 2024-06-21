package net.endkind.enderjoin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor {

    private final EnderJoin plugin;

    public CommandHandler(EnderJoin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.reloadPluginConfig();
        sender.sendMessage("§5EnderJoin§8 >>§f configuration reloaded successfully!");
        return true;
    }
}
