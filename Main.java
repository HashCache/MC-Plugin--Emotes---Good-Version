package net.codexcraftmc.emotes;

import java.io.File;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	private void createConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                getLogger().info("Config.yml not found, creating it!");
                saveDefaultConfig();
            } else {
                getLogger().info("Config.yml found, loading it!");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
	
    @Override
    public void onEnable() {
       this.getCommand("emotes").setExecutor(new CommandExec(this));
       
       createConfig();
       
       PluginManager pm = getServer().getPluginManager();
       pm.registerEvents(new ChatListener(this), this);
       
       getLogger().info("The emote plugin has been enabled!");
    }
   
    @Override
    public void onDisable() {
       getLogger().info("The emote plugin has been disabled!");
    }
}
