package me.buryings.lightningsticks.commands;

import me.buryings.lightningsticks.Messages;
import me.buryings.lightningsticks.annotations.Permission;
import me.buryings.lightningsticks.annotations.PlayerOnly;
import me.buryings.lightningsticks.utils.CommandCore;
import me.buryings.lightningsticks.utils.MSG;
import me.buryings.lightningsticks.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Permission("lightningsticks.use")
@PlayerOnly
public class LightningsticksGive extends CommandCore {

    public LightningsticksGive() {
        super("lsgive");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        // /lsgive <player|all>
        Player player = (Player) sender;
        // Checks if the amount of args does not equal 1. If it doesnt, it will send a usage error.
        if (args.length != 1) {
            new MSG("&cIncorrect usage! Use: /lsgive <player|all>").send(player);
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
                    return;
                }
            }
            // If the first arg != all or a player
            new MSG("&cIncorrect usage! Use: /lsgive <player|all>").send(player);
        }
    }

    private void giveStick(Player p) {
        p.getInventory().addItem(new ItemBuilder(Material.STICK).setname(ChatColor.YELLOW + "Lightning Stick").build());
        p.updateInventory();
        new MSG(Messages.LS_TARGET).send(p);
    }
}

//    @Override
//    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//
//        Player player = (Player) sender;
//
//        if (!(sender instanceof Player)) {
//            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSorry! You must be a player to use this command!"));
//        } else {
//
//            // lsgive <player/all>
//            if (args.length >= 1) {
//                new MSG("%player%, Incorrect Usage! Use: /lsgive <player|all>").replace("%player", player.getName()).send(player);
//            }
//            if (args.length == 0) {
//                if (args[0].equalsIgnoreCase(player.getName())) {
//                    for (Player target : Bukkit.getOnlinePlayers()) {
//                        player.getInventory().addItem(new itemBuilder(Material.STICK).setname(ChatColor.YELLOW + "Lightningstick").build());
//                        new MSG("&aYou have given " + player.getName() + " &alightningstick!");
//                    }
//                    if (args[0].equalsIgnoreCase("all")) {
//                    for (Player all : Bukkit.getOnlinePlayers()) {
//                        all.getInventory().addItem(new itemBuilder(Material.STICK).setname(ChatColor.YELLOW + "Lightningstick").build());
//                    }
//                }
//            }
//        }
//            return true;
//        }
//        return true;
//    }
