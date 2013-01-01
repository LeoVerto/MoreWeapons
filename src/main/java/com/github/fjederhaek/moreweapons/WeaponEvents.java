package com.github.fjederhaek.moreweapons;

import java.util.Random;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class WeaponEvents implements Listener {
    // Shotgun

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteractShotgun(PlayerInteractEvent evt) {
        if (evt.getPlayer().getItemInHand().getTypeId() == Material.BLAZE_POWDER.getId()) {
            if (Ammo.canShoot(evt, 4)) {
                for (int i = 0; i < 10; i++) {
                    // spreadshot function;	gives you 1/11 numbers in between -0,5;0,5	[+-(0,5;0,4;0,3;0,2;0,1;0)]
                    Random rand = new Random();
                    double spreadShot = -0.5 + 1 / 5 * rand.nextInt(11);
                    //shoot
                }
            }
        }
    }

    // Grenade Launcher
    // Bazooka
    // Assault rifle
    // SMG
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerShootSmg(PlayerInteractEvent evt) {
        if (evt.getPlayer().getItemInHand().getTypeId() == Material.WOOD_SPADE.getId()) {
            if (Ammo.canShoot(evt, 1)) {
                evt.getPlayer().shootArrow();
            }
        }
    }

    // semi-auto rifle
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerShootRifle(PlayerInteractEvent evt) {
        if (evt.getPlayer().getItemInHand().getTypeId() == Material.STICK.getId()) {
            if (Ammo.canShoot(evt, 2)) {
                evt.getPlayer().shootArrow();
            }
        }
    }

    // Handgun
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerShootHandgun(PlayerInteractEvent evt) {
        byte color = DyeColor.SILVER.getData();
        if (evt.getPlayer().getItemInHand().getData() == Material.INK_SACK.getNewData(color)
                && (evt.getAction().equals(Action.RIGHT_CLICK_AIR)
                || evt.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            evt.getPlayer().shootArrow();
        }
    }
    // Flamethrower
    // Sniper rifle (modded bow)
}
