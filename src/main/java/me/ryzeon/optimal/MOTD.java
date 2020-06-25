package me.ryzeon.optimal;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class MOTD extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Registering configuration...");
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage("§aEnable optimal motd by §d@Ryzeon_");
        Bukkit.getConsoleSender().sendMessage("§eYou can change motd in config.yml");
        Bukkit.getPluginManager().registerEvents(this, (Plugin)this);
    }
    private String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
    @Override
    public void onDisable() {
    }
    @EventHandler
    public void PingMotd(ServerListPingEvent e){
        e.setMaxPlayers(getConfig().getInt("players"));
        e.setMotd(color(getConfig().getString("motd.1")+"\n"+getConfig().getString("motd.2")));
    }
}
