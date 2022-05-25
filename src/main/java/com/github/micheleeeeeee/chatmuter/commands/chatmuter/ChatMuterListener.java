package com.github.micheleeeeeee.chatmuter.commands.chatmuter;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatMuterListener implements Listener {

    public static boolean chatMuted = false;

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (!isChatMuted()) return;

        if (!p.hasPermission("chatmuter.bypass")) {
            e.setCancelled(true);
            p.sendMessage(ChatColor.RED + "You cannot speak as the chat has been globally silenced.");
        }
    }

    public static boolean isChatMuted() {
        return chatMuted;
    }

    public static void setChatMuted(boolean chatMuted) {
        ChatMuterListener.chatMuted = chatMuted;
    }
}
