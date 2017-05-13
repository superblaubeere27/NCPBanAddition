package me.superblaubeere27.ncpbanaddition.hooks;

import fr.neatmonster.nocheatplus.checks.CheckType;
import fr.neatmonster.nocheatplus.checks.access.IViolationInfo;
import fr.neatmonster.nocheatplus.hooks.NCPHook;
import me.superblaubeere27.ncpbanaddition.NCPBanAddition;
import org.bukkit.entity.Player;

/**
 * Created by david on 06.05.17.
 */
public class FastUseHook implements NCPHook {
    @Override
    public String getHookName() {
        return "NBAFastUseHook";
    }

    @Override
    public String getHookVersion() {
        return NCPBanAddition.version;
    }

    @Override
    public boolean onCheckFailure(CheckType checkType, Player player, IViolationInfo iViolationInfo) {
        if (iViolationInfo.willCancel() && iViolationInfo.getAddedVl() > 0.5) {
            NCPBanAddition.instance.banSystem.add(player, checkType);
        }
        return false;
    }
}
