/*
 * License header. Remove it, if you haven't select license.
 */
package ru.Sonicxd2.PubDefender;

import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 *
 * @author Yaroslav
 */

//Maybe, "CreateExample"?
public class CreatePrimer implements Listener {

    Random r = new Random();

    //Maybe, "createExample"?
    public void createPrimer(Player p) {
        Integer first = r.nextInt(100);
        Integer two = r.nextInt(50);
        String finalMessage = Messages.primer
                .replace("%num1%", first.toString())
                .replace("%num2%", two.toString());

        Results.popitok.put(p, 3);
        Integer znak = r.nextInt(3); // 0...2
        
        //Switch?
        if (znak == 1) {
            Results.results.put(p, first + two); //+
            p.sendMessage(finalMessage.replaceAll("%znak%", Messages.sum));
        } else if (znak == 2) {
            Results.results.put(p, first - two); //-
            p.sendMessage(finalMessage.replaceAll("%znak%", Messages.min));
        } else if (znak == 3) { 
            Results.results.put(p, first * two); //*
            p.sendMessage(finalMessage.replaceAll("%znak%", Messages.umn));
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        createPrimer(e.getPlayer());
    }

    @EventHandler
    public void onPrePressCommand(PlayerCommandPreprocessEvent e) {
        e.setCancelled(true);
    }
}
