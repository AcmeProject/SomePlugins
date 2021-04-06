package net.poweredbyhate.nofall;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoFall extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent ev) {
        if (ev.getEntity().getType() == EntityType.PLAYER && ev.getCause() == EntityDamageEvent.DamageCause.FALL) {
            if (ev.getEntity().hasPermission("nofall.nofall")) {
                ev.setCancelled(true);
            }
        }
    }
}
