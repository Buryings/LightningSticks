package lightningsticks.me.buryings.lightningsticks.me.buryings.commands;

import lightningsticks.me.buryings.lightningsticks.me.buryings.annotations.Permission;
import lightningsticks.me.buryings.lightningsticks.me.buryings.annotations.PlayerOnly;
import lightningsticks.me.buryings.lightningsticks.me.buryings.utils.CommandCore;
import lightningsticks.me.buryings.lightningsticks.me.buryings.utils.itemBuilder;
import lightningsticks.me.buryings.lightningsticks.me.buryings.utils.MSG;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Permission("lightningsticks.use")
@PlayerOnly
public class lsgive extends CommandCore {

    public lsgive() {
        super("lsgive");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;
        // /lsgive <player|all>
        if(args.length > 1){
            new MSG("&cIncorrect usage! Use: /lsgive <player|all>").send(player);
        }
        if(args.length == 1){
            if(!args[0].equalsIgnoreCase("all")) {
                String target = args[0];
                if (!findPlayer(target)) {
                    new MSG("&cCannot find &e%target%").replace("%target%", target.toUpperCase()).send(player);
                    return;
                }
                Player t = Bukkit.getPlayer(target);
                t.getInventory().addItem(new itemBuilder(Material.STICK).setname(ChatColor.YELLOW + "Lightning Stick").build());
                t.updateInventory();
                new MSG("&aYou have given &e%target% &aa lightning stick").replace("%target%", t.getName().toUpperCase()).send(player);
                new MSG("&aYou were given a lightning stick").send(Bukkit.getPlayer(target));
                return;
            }
            if(args[0].equalsIgnoreCase("all")){
                for(Player online : Bukkit.getOnlinePlayers()){
                    online.getInventory().addItem(new itemBuilder(Material.STICK).setname(ChatColor.YELLOW + "Lightning Stick").build());
                    online.updateInventory();
                    new MSG("&aYou have given &eeveryone &aa lightning stick").send(player);
                    new MSG("&aYou were given a lightning stick").send(online);
                    return;
                }
            }
        }
        new MSG("&cIncorrect usage! Use: /lsgive <player|all>").send(player);
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
