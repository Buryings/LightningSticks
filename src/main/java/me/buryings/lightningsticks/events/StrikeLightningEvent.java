package me.buryings.lightningsticks.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashSet;

public class StrikeLightningEvent implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem().getType() == Material.STICK) {
                if (e.getItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Lightning Stick")) {
                    e.getPlayer().getWorld().strikeLightning((e.getPlayer().getTargetBlock((HashSet<Byte>) null, 600).getLocation()));
                }
            }
        }
    }
}
