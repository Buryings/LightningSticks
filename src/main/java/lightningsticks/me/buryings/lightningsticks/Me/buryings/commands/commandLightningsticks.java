package lightningsticks.me.buryings.lightningsticks.Me.buryings.commands;

import lightningsticks.me.buryings.lightningsticks.Me.buryings.annotations.Permission;
import lightningsticks.me.buryings.lightningsticks.Me.buryings.annotations.PlayerOnly;
import lightningsticks.me.buryings.lightningsticks.Me.buryings.utils.itemBuilder;
import lightningsticks.me.buryings.lightningsticks.Me.buryings.utils.MSG;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Permission("lightningsticks.use")
@PlayerOnly
public class commandLightningsticks implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSorry! You must be a player to use this command!"));
        } else {

            // lsgive <player/all>
            if (args.length > 1) {
                new MSG("%player%, Incorrect Usage! Use: /lsgive <player|all>").replace("%player", player.getName()).send(player);
            }
            if (args.length == 0) {
                if (args[0].equalsIgnoreCase(player.getName())) {
                    for (Player target : Bukkit.getPlayerExact()) {
                        player.getInventory().addItem(new itemBuilder(Material.STICK).setname(ChatColor.YELLOW + "Lightningstick").build());
                        new MSG("&aYou have given " + player.getName() + " &alightningstick!");
                    }
                    if (args[0].equalsIgnoreCase("all")) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.getInventory().addItem(new itemBuilder(Material.STICK).setname(ChatColor.YELLOW + "Lightningstick").build());
                    }
                }
            }
        }
            return true;
        }
        return false;
    }
}
