package com.github.micheleeeeeee.chatmuter;

import com.github.micheleeeeeee.chatmuter.commands.chatmuter.ChatMuterCommand;
import com.github.micheleeeeeee.chatmuter.commands.chatmuter.ChatMuterListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatMuter extends JavaPlugin {

    /**
     * When the plugin is starting up, the plugin
     * registers both the /mutechat command and the corresponding listeners.
     */
    @Override
    public void onEnable() {
        getCommand("mutechat").setExecutor(new ChatMuterCommand());
        getServer().getPluginManager().registerEvents(new ChatMuterListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
