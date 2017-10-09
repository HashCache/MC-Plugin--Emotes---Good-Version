package net.codexcraftmc.emotes;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class ChatListener implements Listener {
	
    Main plugin;
    
	public ChatListener(Main instance) {
    	plugin = instance;
    }
    
	String emotes = "Emotes.";
	String string = ".trigger";
	String replace = ".emote";
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent chat) {
		if (chat.getPlayer().hasPermission("emotes.use")) {
			int number = plugin.getConfig().getInt("Emotes.numberOf");
			int i = 1;
			while (number >= i) {				
				String stringBuilder = emotes + i + string;
				String stringBuilder2 = emotes + i + replace;
				String newMessage = chat.getMessage().replace(plugin.getConfig().getString(stringBuilder), plugin.getConfig().getString(stringBuilder2));
				chat.setMessage(newMessage);
				i++;
			}
		}
	}
}
