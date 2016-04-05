/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.Sonicxd2.PubDefender;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.ChatColor;
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
public class Results implements Listener{
    public static HashMap<Player, Integer> results=new HashMap<Player, Integer>();
    public static HashMap<Player, Integer> popitok=new HashMap<Player, Integer>();
    
    public static ArrayList<String> PlayersWhoGoToDef=new ArrayList<String>(); //Список игроков, которые уже прошли проверку
    
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        if(results.get(e.getPlayer()).toString().contains(e.getMessage())){
            e.getPlayer().sendMessage(Messages.prefix+Messages.messageSuccess);
            Main.getInstance().playersInDef++;
            Main.getInstance().Send(e.getPlayer());
            PlayersWhoGoToDef.add(e.getPlayer().getName());
            return;
        }
        if(popitok.get(e.getPlayer())==0){
            popitok.remove(e.getPlayer());
            e.getPlayer().kickPlayer(Messages.prefix+Messages.kickMessage);
            return;
        }
        e.getPlayer().sendMessage(Messages.prefix+Messages.messageError.replaceAll("%number%", popitok.get(e.getPlayer()).toString()));
        popitok.put(e.getPlayer(), popitok.get(e.getPlayer())-1);
    }
    //Убирает плохие вещи))
    @EventHandler
    public void Disconnect(PlayerQuitEvent e){
        results.remove(e.getPlayer());
        popitok.remove(e.getPlayer());
        Main.instance.allPlayers++;
    }
    
    @EventHandler
    public void Join(PlayerJoinEvent e){
        if(PlayersWhoGoToDef.contains(e.getPlayer().getName())) Main.instance.Send(e.getPlayer());
    }
}
