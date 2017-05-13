package me.superblaubeere27.ncpbanaddition;

import fr.neatmonster.nocheatplus.checks.CheckType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Created by david on 06.05.17.
 */
public class BanSystem {
    private HashMap<Player, Integer> vl = new HashMap<>();

    public int getVL(Player player) {
        tryInit(player);
        return vl.get(player);
    }

    public void add(Player player, CheckType check) {
        tryInit(player);
        vl.put(player, vl.get(player) + 1);
        Bukkit.getConsoleSender().sendMessage(NCPBanAddition.prefix + "[" + ChatColor.YELLOW + player.getName() + ChatColor.WHITE + "] failed " + check + " (" + getVL(player) + " VL)");
        checkBan(player);
    }

    private void checkBan(Player player) {
        if (getVL(player) > Config.MAX_VL) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), String.format(Config.BAN_COMMAND, player.getName()));
        }
    }

    private void tryInit(Player player) {
        if (!vl.containsKey(player)) {
            vl.put(player, 0);
        }
    }
}
