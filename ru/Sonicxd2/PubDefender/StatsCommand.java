/*
 * Заголовок лицензии. Удали его, если ты не выбрал лицензию.
 */
package ru.Sonicxd2.PubDefender;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Yaroslav
 */
public class StatsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if (cs instanceof Player) {
            cs.sendMessage(ChatColor.GREEN + "Статистика для консоли.");
            return true;
        }
        cs.sendMessage(Messages.prefix + " Defender версия - " + Main.getInstance().version);
        cs.sendMessage(Messages.prefix + " Статистика:");
        cs.sendMessage(Messages.prefix + " Всего игроков зашло: " + Main.getInstance().allPlayers.toString());
        cs.sendMessage(Messages.prefix + " Игроков не прошедших проверку: " + (Main.getInstance().allPlayers - Main.getInstance().playersInDef));
        cs.sendMessage(Messages.prefix + " Игроков прошедших проверку:" + Main.getInstance().playersInDef);
        return true;
    }

}
