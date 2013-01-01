package com.github.fjederhaek.moreweapons;

import java.util.Arrays;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EnderchestRestrictions {

    @EventHandler
    public void onClickEnderChest(InventoryClickEvent evt) {
    }
    Material[] allowedInChest = {
        Material.BLAZE_ROD,
        Material.IRON_SWORD,
        Material.FIREBALL,
        Material.SNOW_BALL, 
        Material.WOOD_SWORD, 
        Material.GOLD_SWORD, 
        Material.DIAMOND_SWORD, 
        Material.INK_SACK, // all dye colors are stored here
        Material.EGG, 
        Material.POTION, 
        Material.FIREBALL, 
        Material.SNOW_BALL, 
        Material.POTION, 
        Material.SNOW_BALL, 
        Material.AIR
    };
    //this class prevents people from putting not allowed stuff into the ender chest

    @EventHandler
    public void onInteractEnderChest(InventoryClickEvent evt) {
        Inventory inv = evt.getInventory();

        if (inv.getType() == InventoryType.ENDER_CHEST) {
            if (evt.getRawSlot() < inv.getSize()) {
                ItemStack holding = evt.getCursor();

                //whats allowed in the whole chest
                if (!Arrays.asList(allowedInChest).contains(holding.getType())) {
                    int slot = evt.getSlot();

                    evt.setCancelled(true);
                    evt.setCursor(holding);
                    inv.setItem(slot, inv.getItem(slot));
                }
            } else if (evt.isShiftClick()) {
                ItemStack clicked = evt.getCurrentItem();
                if (!Arrays.asList(allowedInChest).contains(clicked.getType())) {
                    int slot = evt.getSlot();

                    evt.setCancelled(true);
                    inv.setItem(slot, inv.getItem(slot));
                }
            }
        }
    }
}
