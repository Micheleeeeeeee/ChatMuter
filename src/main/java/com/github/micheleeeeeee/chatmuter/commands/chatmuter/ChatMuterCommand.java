package com.github.micheleeeeeee.chatmuter.commands.chatmuter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatMuterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd,
                             String label, String[] args) {
        if (!(sender instanceof Player)) { // If the command executor is CONSOLE
            if (ChatMuterListener.isChatMuted()) {
                Bukkit.getOnlinePlayers().forEach(p -> p.sendMessage(ChatColor.GREEN + "Chat has been unmuted by CONSOLE."));
                ChatMuterListener.setChatMuted(false);
            } else {
                Bukkit.getOnlinePlayers().forEach(p -> p.sendMessage(ChatColor.RED + "Chat has been muted by CONSOLE."));
                ChatMuterListener.setChatMuted(true);
            }
        }

        assert sender instanceof Player; // Since we know that the command executor isn't console, it's gotta be a player!
        Player p = (Player) sender;
        if (!p.hasPermission("chatmuter.toggle")) { // Player doesn't have the correct permissions to execute /mutechat
            p.sendMessage(ChatColor.RED + "You do not have the required permissions to execute this command.");
            return true;
        }

        if (ChatMuterListener.isChatMuted()) {
            Bukkit.getOnlinePlayers().forEach(pl -> p.sendMessage(ChatColor.GREEN + "Chat has been unmuted by " + p.getName()));
            ChatMuterListener.setChatMuted(false);
        } else {
            Bukkit.getOnlinePlayers().forEach(pl -> p.sendMessage(ChatColor.RED + "Chat has been muted by " + p.getName()));
            ChatMuterListener.setChatMuted(true);
        }

        return false;
    }
}
