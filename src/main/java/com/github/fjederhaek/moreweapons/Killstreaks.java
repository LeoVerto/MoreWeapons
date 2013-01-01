package com.github.fjederhaek.moreweapons;

import java.util.HashMap;
import org.bukkit.entity.Player;

public class Killstreaks {

    public static HashMap<String, Integer> killcount = new HashMap<String, Integer>();
    public static HashMap<String, HashMap<String, Integer>> killstreaks = new HashMap<String, HashMap<String, Integer>>();

    public static void killcountUpdate(Player player) {
        if (killcount.get(player.getName()) == 3) {
            killstreaks.get(player.getName()).put("lightning strike", 1);
            player.sendMessage("Lightning strike unlocked!");
        }
    }

    public static void addKillcount(Player player, Integer value) {
        Integer pKillcount = killcount.get(player.getName()) + value;
        killcount.put(player.getName(), pKillcount);
        killcountUpdate(player);
    }

    public static void resetKillcount(Player player) {
        if (killcount.containsKey(player.getName())) {
            killcount.remove(player.getName());
        }
    }

    public static boolean useKillstreak(Player player, String killstreak) {
        if (killstreaks.containsKey(player.getName())) {
            Integer streakcount = killstreaks.get(player.getName()).get(killstreak);
            if (streakcount < 0) {
                killstreaks.get(player.getName()).put(killstreak, streakcount--);
                //Broadcast use of killstreak to all players
                //Server.broadcastMessage("[MW] " + player + " used " + killstreak + "!");
                return true;
            }
        }
        player.sendMessage("No " + killstreak + " available!");
        return false;
    }
}
