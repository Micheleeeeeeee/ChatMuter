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

        if (!sender.hasPermission("chatmuter.toggle")) { // Command Executor doesn't have the correct permissions to execute /mutechat
            sender.sendMessage(ChatColor.RED + "You do not have the required permissions to execute this command.");
            return true;
        }

        if (ChatMuterListener.isChatMuted()) {
            Bukkit.getOnlinePlayers().forEach(p -> p.sendMessage(ChatColor.GREEN + "Chat has been unmuted by " + sender.getName()));
            ChatMuterListener.setChatMuted(false);
        } else {
            Bukkit.getOnlinePlayers().forEach(p -> p.sendMessage(ChatColor.RED + "Chat has been muted by " + sender.getName()));
            ChatMuterListener.setChatMuted(true);
        }

        return false;
    }
}
