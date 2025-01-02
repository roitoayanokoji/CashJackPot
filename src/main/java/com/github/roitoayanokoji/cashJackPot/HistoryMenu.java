// HistoryMenu.java
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

public class HistoryMenu implements Listener {

    public static void openMenu(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "History Menu");

        ItemStack historyItem = new ItemStack(Material.PAPER);
        ItemMeta historyMeta = historyItem.getItemMeta();
        if (historyMeta != null) {
            historyMeta.setDisplayName("Previous Bets");
            historyItem.setItemMeta(historyMeta);
        }
        gui.setItem(13, historyItem);

        player.openInventory(gui);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("History Menu")) {
            event.setCancelled(true);

            Player player = (Player) event.getWhoClicked();
            int slot = event.getRawSlot();

            if (slot == 13) {
                player.sendMessage("Viewing previous bets...");
                player.closeInventory();
            }
        }
    }
}
