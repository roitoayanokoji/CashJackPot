package com.github.roitoayanokoji.cashJackPot;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

public final class CashJackPot extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("OnEnable");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("OnDisable");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (label.equalsIgnoreCase("cjp")){
            if (sender instanceof Player){
                Player player  = (Player) sender;
                MenuGUI(player);
                return true;
            }
        }
        return false;
    }

    private void MenuGUI(Player player){
        Inventory gui = Bukkit.createInventory(null,54,"CJP-Menu");
        ItemStack fillerItem = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta fillerMeta = fillerItem.getItemMeta();
        if (fillerMeta != null) {
            fillerMeta.setDisplayName(" ");
            fillerItem.setItemMeta(fillerMeta);
        }

        for (int i = 0; i < gui.getSize(); i++) {
            gui.setItem(i, fillerItem);
        }

        //History Item
        ItemStack HistoryItem = new ItemStack(Material.BOOKSHELF);
        ItemMeta HistoryMeta = HistoryItem.getItemMeta();
        if (HistoryMeta != null){
            HistoryMeta.setDisplayName("History");
            HistoryItem.setItemMeta(HistoryMeta);
        }
        gui.setItem(20,HistoryItem);

        //Bet Item
        ItemStack BetItem = new ItemStack(Material.ENDER_EYE);
        ItemMeta BetMeta = BetItem.getItemMeta();
        if (BetMeta != null){
            BetMeta.setDisplayName("BET");
            BetItem.setItemMeta(BetMeta);
        }
        gui.setItem(24,BetItem);

        //Close Item
        ItemStack CloseItem = new ItemStack(Material.BARRIER);
        ItemMeta CloseMeta = CloseItem.getItemMeta();
        if (CloseMeta != null){
            CloseMeta.setDisplayName("Close");
            CloseItem.setItemMeta(CloseMeta);
        }
        gui.setItem(43,CloseItem);

        player.openInventory(gui);
    }

    @EventHandler
    public void  onInventoryClick(InventoryClickEvent event){
        if (event.getView().getTitle().equals("CJP-Menu")){
            event.setCancelled(true);

            Player player = (Player) event.getWhoClicked();
            int slot = event.getRawSlot();

            if (slot == 20){
                player.openInventory();
                player.sendMessage("Bet　Menu");
            }
            if (slot == 24){
                player.openInventory();
                player.sendMessage("History Menu");
            }
            if (slot == 43){
                player.closeInventory();
                player.sendMessage("Close GUI");
            }
        }
    }
}
