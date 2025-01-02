// BetMenu.java
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

public class BetMenu implements Listener {

    public static void openMenu(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "Bet Menu");
        ItemStack confirmBet = new ItemStack(Material.EMERALD);
        ItemMeta confirmMeta = confirmBet.getItemMeta();
        if (confirmMeta != null) {
            confirmMeta.setDisplayName("Confirm Bet");
            confirmBet.setItemMeta(confirmMeta);
        }
        gui.setItem(13, confirmBet);

        player.openInventory(gui);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("Bet Menu")) {
            event.setCancelled(true);

            Player player = (Player) event.getWhoClicked();
            int slot = event.getRawSlot();

            if (slot == 13) {
                player.sendMessage("Bet confirmed!");
                player.closeInventory();
            }
        }
    }
}