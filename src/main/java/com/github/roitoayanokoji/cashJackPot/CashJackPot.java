package com.github.roitoayanokoji.cashJackPot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CashJackPot extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("CashJackPot has been enabled!");
        getServer().getPluginManager().registerEvents(new MainMenu(), this);
        getServer().getPluginManager().registerEvents(new BetMenu(), this);
        getServer().getPluginManager().registerEvents(new HistoryMenu(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("CashJackPot has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("cjp") && sender instanceof Player) {
            Player player = (Player) sender;
            MainMenu.openMenu(player);
            return true;
        }
        return false;
    }
}
