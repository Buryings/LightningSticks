package me.buryings.lightningsticks.events;

import me.buryings.lightningsticks.LightningSticks;
import me.buryings.lightningsticks.util.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;

public class StrikeLightningEvent implements Listener {

    public StrikeLightningEvent() {
        Bukkit.getPluginManager().registerEvents(this, LightningSticks.getInstance());
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getItemInHand();
        if (item != ItemManager.getLightningStick())
            return;

        Action action = event.getAction();
        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            Location location = player.getLocation();
            location.getWorld().strikeLightning(player.getTargetBlock((HashSet<Byte>) null, 600).getLocation());
        }
    }
}
