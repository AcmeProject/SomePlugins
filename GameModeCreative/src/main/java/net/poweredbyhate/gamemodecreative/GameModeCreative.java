package net.poweredbyhate.gamemodecreative;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class GameModeCreative extends JavaPlugin implements Listener {

    String[] aliases = {"gmc", "gamemodec", "gmcreative", "creative", "creativemode"};

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        String command = event.getMessage().toLowerCase().replace("/", "");
        Player p = event.getPlayer();
        if (Arrays.asList(aliases).contains(command) && p.hasPermission("gamemode.creative")) {
            if (p.getGameMode() != GameMode.CREATIVE) {
                p.setGameMode(GameMode.CREATIVE);
            } else {
                p.sendMessage("You are already in creative mode!");
            }
        }
    }
}
