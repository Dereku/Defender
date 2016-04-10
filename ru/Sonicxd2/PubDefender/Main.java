/*
 * Заголовок лицензии. Удали его, если ты не выбрал лицензию.
 */
package ru.Sonicxd2.PubDefender;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

/**
 *
 * @author Yaroslav
 */
public class Main extends JavaPlugin implements PluginMessageListener {

    public static Main instance;
    //Версия и все что с ней связано
    public final Integer version = 1;
    public Integer allPlayers = 0;
    public Integer playersInDef = 0;
    public Results results;
    
    private String server;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig(); // Если конфига нет. Add: А если есть, он не будет перезаписываться. 
        this.server = getConfig().getString("Server");
        if (this.server == null || this.server.equals("")) {
            this.getLogger().warning("Плагин не настроен.");
            this.getLogger().warning("Защиты отключена.");
            this.getPluginLoader().disablePlugin(this);
            return;
        }
        
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
        this.results = new Results();
        Bukkit.getPluginManager().registerEvents(results, this);
        Bukkit.getPluginManager().registerEvents(new CreatePrimer(), this);
        this.getCommand("stats").setExecutor(new StatsCommand());
    }

    public void send(Player p) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("ConnectOther");
        out.writeUTF(p.getName());
        out.writeUTF(server);

    }

    @Override
    public void onPluginMessageReceived(String string, Player player, byte[] bytes) {

    }
    
    //TODO:Сделать проверку на обновление
}
