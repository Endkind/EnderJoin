package net.endkind.enderjoin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class EnderJoin extends JavaPlugin {

    private FileConfiguration config;
    private static EnderJoin instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Enabling EnderJoin");

        instance = this;

        loadConfig();

        getServer().getPluginManager().registerEvents(new PlayerListener(), this);

        if (getCommand("enderjoinreload") != null) {
            getCommand("enderjoinreload").setExecutor(new CommandHandler(this));
        } else {
            getLogger().severe("Command 'enderjoinreload' could not be found!");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Disabling EnderJoin");
    }

    private void loadConfig() {
        File configFile = new File(getDataFolder(), "config.yml");

        if (!configFile.exists()) {
            saveResource("config.yml", false);
        }

        config = getConfig();

        config.options().copyDefaults(true);
        saveConfig();
    }

    public void reloadPluginConfig() {
        reloadConfig();
        config = getConfig();
    }

    public static EnderJoin getInstance() {
        return instance;
    }
}
