/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.Sonicxd2.PubDefender;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import java.io.File;
import org.bukkit.Achievement;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

/**
 *
 * @author Yaroslav
 */
public class Main extends JavaPlugin implements PluginMessageListener{
    public static Main instance;
    String server="Lobby-1";
    public static Main getInstance(){
        return instance;
    }
    
    @Override
    public void onLoad() {
        instance=this;
    }
    
    public Results results=null;
    @Override
    public void onEnable() {
        playersInDef=0; allPlayers=0; //К статистике, инициализация.
        if(new File(getDataFolder(),"config.yml").exists()); else saveDefaultConfig(); // Если конфига нет.
        if(getConfig().getString("Server")==null){
            System.out.println(ChatColor.RED+"Конфиг не инициализирован.");
            System.out.println(ChatColor.RED+"Защиты нет");
            return;
        }
        server=getConfig().getString("Server");
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
        results=new Results();
        Bukkit.getPluginManager().registerEvents(results, this);
        Bukkit.getPluginManager().registerEvents(new CreatePrimer(), this);
        getCommand("stats").setExecutor(new StatsCommand());
    }
    
    public void Send(Player p){
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("ConnectOther");
        out.writeUTF(p.getName());
        out.writeUTF(server);
        
    }

    @Override
    public void onPluginMessageReceived(String string, Player player, byte[] bytes) {
      
    }
    
    //Статистика ниже.
    Integer allPlayers;
    Integer playersInDef;
    //Версия и все что с ней связано
    Integer version=1;
    //TODO:Сделать проверку на обновление
}
