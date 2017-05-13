package me.superblaubeere27.ncpbanaddition;

import fr.neatmonster.nocheatplus.checks.CheckType;
import fr.neatmonster.nocheatplus.hooks.NCPHookManager;
import me.superblaubeere27.ncpbanaddition.hooks.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by david on 06.05.17.
 */
public class NCPBanAddition extends JavaPlugin {
    public static final String prefix = "§cNBA: " + ChatColor.WHITE;
    public static final String version = "1.0 SNAPSHOT";
    public static NCPBanAddition instance;
    public BanSystem banSystem;

    @Override
    public void onEnable() {
        instance = this;
        banSystem = new BanSystem();
        Bukkit.getConsoleSender().sendMessage(prefix + "Registering hooks...");
        registerHooks();
        Bukkit.getConsoleSender().sendMessage(prefix + "NCPBanAddition was enabled.");
    }

    private void registerHooks() {
        NCPHookManager.addHook(CheckType.FIGHT_ANGLE, new AngleHook());
        NCPHookManager.addHook(CheckType.FIGHT_REACH, new ReachHook());
        NCPHookManager.addHook(CheckType.FIGHT_SPEED, new FightSpeedHook());
        NCPHookManager.addHook(CheckType.BLOCKPLACE_FASTPLACE, new FastPlaceHook());
        NCPHookManager.addHook(CheckType.INVENTORY_FASTCONSUME, new FastUseHook());
    }
}
