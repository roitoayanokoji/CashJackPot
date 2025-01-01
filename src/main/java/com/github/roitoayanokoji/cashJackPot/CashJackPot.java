package com.github.roitoayanokoji.cashJackPot;

import org.bukkit.plugin.java.JavaPlugin;

public final class CashJackPot extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("OnEnable");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("OnDisable");
    }
}
