package me.buryings.lightningsticks.commands;


import me.buryings.lightningsticks.Messages;
import me.buryings.lightningsticks.annotations.Permission;
import me.buryings.lightningsticks.annotations.PlayerOnly;
import me.buryings.lightningsticks.utils.CommandCore;
import me.buryings.lightningsticks.utils.MSG;
import me.buryings.lightningsticks.utils.itemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

@Permission("lightningsticks.remove")
@PlayerOnly
public class LightningsticksRemove extends CommandCore {

    public LightningsticksRemove() {
        super("lsremove");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        // /lsremove <player|all>
        Player player = (Player) sender;
        // Checks if the amount of args does not equal 1. If it doesnt, it will send a usage error.
        if (args.length != 1) {
            new MSG("&cIncorrect usage! Use: /lsremove <player|all>").send(player);
        }
        // Checks if the arg length == 1
        if (args.length == 1) {
            if (!args[0].equalsIgnoreCase("all")) {
                String target = args[0];
                // Checks if the user is not online.
                if (!findPlayer(target)) {
                    new MSG(Messages.INVALID_PLAYER).replace("%target%", target.toUpperCase()).send(player);
                    return;
                }
                Player t = Bukkit.getPlayer(target);
                // Removes the user's stick and sends a message to the command sender
                removeStick(t);
                new MSG(Messages.LS_REMOVED).replace("%target%", t.getName().toUpperCase()).send(player);
                return;
            }
            if (args[0].equalsIgnoreCase("all")) {
                for (Player online : Bukkit.getOnlinePlayers()) {
                    // Removes all people online's stick and sends a message to the command sender
                    removeStick(online);
                    new MSG(Messages.LS_REMOVED_EVERYONE).replace("%remove%", player.getName().toUpperCase()).send(player);
                    return;
                }
            }
            // If the first arg != all or a player
            new MSG("&cIncorrect usage! Use: /lsremove <player|all>").send(player);
        }


    }

    private void removeStick(Player player) {
        player.getInventory().addItem(new itemBuilder(Material.STICK).setname(ChatColor.YELLOW + "Lightning Stick").build());
        player.updateInventory();
        new MSG(Messages.LS_REMOVED).send(player);
    }

}

    /*  LS GIVING: if (args.length == 1) {
            if (!args[0].equalsIgnoreCase("all")) {
            String target = args[0];
            // Checks if the user is not online.
            if (!findPlayer(target)) {
            new MSG(Messages.INVALID_PLAYER).replace("%target%", target.toUpperCase()).send(player);
            return;
            }
            Player t = Bukkit.getPlayer(target);
            // Gives the user the stick and sends a message to the command sender
            giveStick(t);
            new MSG(Messages.LS_PLAYER).replace("%target%", t.getName().toUpperCase()).send(player);
            return;
            }
            if (args[0].equalsIgnoreCase("all")) {
            for (Player online : Bukkit.getOnlinePlayers()) {
            // Sends a stick to all people online and sends a message to the command sender
            giveStick(online);
            new MSG(Messages.LS_PLAYER_EVERYONE).send(player);
            return;*/