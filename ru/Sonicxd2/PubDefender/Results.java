/*
 * Заголовок лицензии. Удали его, если ты не выбрал лицензию.
 */
package ru.Sonicxd2.PubDefender;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 *
 * @author Yaroslav
 */
public class Results implements Listener {

    public static HashMap<Player, Integer> results = new HashMap<>();
    public static HashMap<Player, Integer> popitok = new HashMap<>();

    public static ArrayList<String> PlayersWhoGoToDef = new ArrayList<>(); //Список игроков, которые уже прошли проверку

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (results.get(e.getPlayer()).toString().contains(e.getMessage())) {
            e.getPlayer().sendMessage(Messages.prefix + Messages.messageSuccess);
            Main.getInstance().playersInDef++;
            Main.getInstance().send(e.getPlayer());
            PlayersWhoGoToDef.add(e.getPlayer().getName());
            return;
        }
        if (popitok.get(e.getPlayer()) == 0) {
            popitok.remove(e.getPlayer());
            e.getPlayer().kickPlayer(Messages.prefix + Messages.kickMessage);
            return;
        }
        e.getPlayer().sendMessage(Messages.prefix + Messages.messageError.replace("%number%", popitok.get(e.getPlayer()).toString()));
        popitok.put(e.getPlayer(), popitok.get(e.getPlayer()) - 1);
    }

    //Убирает плохие вещи))

    @EventHandler
    public void onDisconnect(PlayerQuitEvent e) {
        results.remove(e.getPlayer());
        popitok.remove(e.getPlayer());
        Main.instance.allPlayers++;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (PlayersWhoGoToDef.contains(e.getPlayer().getName())) {
            Main.instance.send(e.getPlayer());
        }
    }
}
