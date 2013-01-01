package com.github.fjederhaek.moreweapons;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class LoadEnderChest {

    @EventHandler
    public static boolean PlayerSpawnInZone(PlayerInteractEvent evt, Material reward) {
        Player player = evt.getPlayer();
        player.openInventory(player.getEnderChest());
        ItemStack rewardItem = evt.getPlayer().getItemInHand();
        if (player.getInventory().getItem(1).getType().equals(reward)
                || player.getInventory().getItem(3).getType().equals(reward)
                || player.getInventory().getItem(2).getType().equals(reward)) {
            return true;
        }
        return false;
    }
}
