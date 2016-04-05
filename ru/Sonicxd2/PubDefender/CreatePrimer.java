/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class CreatePrimer implements Listener{
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        CreatePrimer(e.getPlayer());
    }
    
    public void CreatePrimer(Player p){
        Random r=new Random();
        String finalMessage=Messages.primer;
        Integer first=r.nextInt(100);
        finalMessage.replaceAll("%num1%", first.toString());
        
        Integer two=r.nextInt(50);
        finalMessage.replaceAll("%num2%", two.toString());
        Main.getInstance().results.popitok.put(p, 3);
        Integer znak=r.nextInt(3);
        if(znak==1){
            Main.getInstance().results.results.put(p, first+two); //+
            p.sendMessage(finalMessage.replaceAll("%znak%", Messages.sum));
            return;
        }
        
        if(znak==2){
            Main.getInstance().results.results.put(p, first-two); //-
            p.sendMessage(finalMessage.replaceAll("%znak%", Messages.min));
            return;
        }
        
        if(znak==3){
            Main.getInstance().results.results.put(p, first*two); //*
            p.sendMessage(finalMessage.replaceAll("%znak%", Messages.umn));
            return;
        }
    }
    
    @EventHandler
    public void onPrePressCommand(PlayerCommandPreprocessEvent e){
        e.setCancelled(true);
    }
}
