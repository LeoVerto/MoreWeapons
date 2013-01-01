package com.github.fjederhaek.moreweapons;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Ammo {

    public static boolean canShoot(PlayerInteractEvent evt, int required) {
        Player player = evt.getPlayer();
        ItemStack Arrows = new ItemStack(Material.ARROW);
        PlayerInventory inventory = player.getInventory();
        if (inventory.contains(Arrows) && Arrows.getAmount() * required <= 1 && (evt.getAction().equals(Action.RIGHT_CLICK_AIR) || evt.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            int amount = Arrows.getAmount();
            Arrows.setAmount(amount - 1 * required);
            if (amount == 12) {
                MoreWeapons.message(player, "Low ammo!");
            }
            return true;
        } else {
            MoreWeapons.message(player, "Out of ammo!");
            return false;
        }
    }

    public static boolean canShootHeavy(PlayerInteractEvent evt, int required) {
        Player player = evt.getPlayer();
        ItemStack Arrows = new ItemStack(Material.FIREBALL);
        PlayerInventory inventory = player.getInventory();
        if (inventory.contains(Arrows) && Arrows.getAmount() * required <= 1 && (evt.getAction().equals(Action.RIGHT_CLICK_AIR) || evt.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            int amount = Arrows.getAmount();
            Arrows.setAmount(amount - 1 * required);
            if (amount == 2) {
                MoreWeapons.message(player, "Low ammo!");
            }
            return true;
        } else {
            MoreWeapons.message(player, "Out of ammo!");
            return false;
        }
    }
}
