// MainMenu.java
package com.github.roitoayanokoji.cashJackPot;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MainMenu implements Listener {

    public static void openMenu(Player player) {
        Inventory gui = Bukkit.createInventory(null, 54, "CJP-Menu");
        ItemStack fillerItem = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta fillerMeta = fillerItem.getItemMeta();
        if (fillerMeta != null) {
            fillerMeta.setDisplayName(" ");
            fillerItem.setItemMeta(fillerMeta);
        }

        for (int i = 0; i < gui.getSize(); i++) {
            gui.setItem(i, fillerItem);
        }

        // History Item
        ItemStack historyItem = new ItemStack(Material.BOOKSHELF);
        ItemMeta historyMeta = historyItem.getItemMeta();
        if (historyMeta != null) {
            historyMeta.setDisplayName("History");
            historyItem.setItemMeta(historyMeta);
        }
        gui.setItem(24, historyItem);

        // Bet Item
        ItemStack betItem = new ItemStack(Material.ENDER_EYE);
        ItemMeta betMeta = betItem.getItemMeta();
        if (betMeta != null) {
            betMeta.setDisplayName("BET");
            betItem.setItemMeta(betMeta);
        }
        gui.setItem(20, betItem);

        // Close Item
        ItemStack closeItem = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = closeItem.getItemMeta();
        if (closeMeta != null) {
            closeMeta.setDisplayName("Close");
            closeItem.setItemMeta(closeMeta);
        }
        gui.setItem(43, closeItem);

        player.openInventory(gui);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("CJP-Menu")) {
            event.setCancelled(true);

            Player player = (Player) event.getWhoClicked();
            int slot = event.getRawSlot();

            if (slot == 20) {
                BetMenu.openMenu(player);
                player.sendMessage("Bet Menu...");
            } else if (slot == 24) {
                HistoryMenu.openMenu(player);
                player.sendMessage("History Menu...");
            } else if (slot == 43) {
                player.closeInventory();
                player.sendMessage("Close GUI...");
            }
        }
    }
}