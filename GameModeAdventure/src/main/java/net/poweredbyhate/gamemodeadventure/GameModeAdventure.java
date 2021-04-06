package net.poweredbyhate.gamemodeadventure;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class GameModeAdventure extends JavaPlugin implements Listener {

    String[] aliases = {"gma", "gamemodea", "gmadventure", "adventure", "adventuremode"};

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        String command = event.getMessage().toLowerCase().replace("/", "");
        Player p = event.getPlayer();
        if (Arrays.asList(aliases).contains(command) && p.hasPermission("gamemode.adventure")) {
            if (p.getGameMode() != GameMode.ADVENTURE) {
                p.setGameMode(GameMode.ADVENTURE);
            } else {
                p.sendMessage("You are already in adventure mode!");
            }
        }
    }

}
