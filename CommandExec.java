package net.codexcraftmc.emotes;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



import net.codexcraftmc.emotes.Main;

public class CommandExec implements CommandExecutor {
	
    Main plugin;
    
	public CommandExec(Main instance) {
    	plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	Player p = (Player) sender;
    	
    	if (cmd.getName().equalsIgnoreCase("emotes") && p.hasPermission("emotes.use") && args.length == 0) {    	
    	
    	int number = plugin.getConfig().getInt("Emotes.numberOf");
    	int i = 1;
    	
    	String emotes = "Emotes.";
    	String string = ".string";
    	String replace = ".replacewith";
    	
    	sender.sendMessage("List of Emotes:");
    	
		while (number >= i) {				
			String stringBuilder = emotes + i + string;
			String stringBuilder2 = emotes + i + replace;
			sender.sendMessage(plugin.getConfig().getString(stringBuilder) + " = " + plugin.getConfig().getString(stringBuilder2));
			i++;
        } 
		return true;


    } else if (cmd.getName().equalsIgnoreCase("emotes") && p.hasPermission("emotes.reload") && args[0].equalsIgnoreCase("reload")) {
    	plugin.reloadConfig();
    	sender.sendMessage("Reload Complete!");
    	return true;
    } else if (cmd.getName().equalsIgnoreCase("emotes") && p.hasPermission("emotes.use") && args.length > 0) {
    	sender.sendMessage("§4Incorrect usage!");
    	return true;
    } else {
    	sender.sendMessage("§4You do not have permission!");
    	return false;
    }
  }
}