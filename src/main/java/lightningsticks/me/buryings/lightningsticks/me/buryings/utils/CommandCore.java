package lightningsticks.me.buryings.lightningsticks.me.buryings.utils;

import lightningsticks.me.buryings.lightningsticks.me.buryings.annotations.Disabled;
import lightningsticks.me.buryings.lightningsticks.me.buryings.annotations.Permission;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sun.misc.resources.Messages;

public abstract class CoreCommand implements CommandExecutor {
    public CoreCommand(String name) {
        Bukkit.getPluginCommand(name).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        /*
          @Disabled - Disables the command
         */
        if (this.getClass().isAnnotationPresent(Disabled.class)) {
            new MSG(Messages.COMMAND_DISABLED).send(sender);
            return true;
        }
//        /*
//           @Eric - Yes
//         */
//        if (this.getClass().isAnnotationPresent(Eric.class)) {
//            new MSG("yourmom").broadcast();
//            return true;
//        }
        /*
          @ConsoleOnly - Makes it so you can only use the command from Console
         * @PlayerOnly - Makes it so you can only use the command as an in-game player
         */
        if (this.getClass().isAnnotationPresent(ConsoleOnly.class) && sender instanceof Player ||
                this.getClass().isAnnotationPresent(PlayerOnly.class) && !(sender instanceof Player)) {
            new MSG(Messages.CANNOT_USE_THIS).send(sender);
            return true;
        }
        /*
          @Permission - If the sender has a certain permission. Typically given to players
         */
        if (this.getClass().isAnnotationPresent(Permission.class)) {
            String perm = this.getClass().getAnnotation(Permission.class).value();
            if (!sender.hasPermission(perm) || !sender.hasPermission("core.command.*")) {
                new MSG(Messages.NO_PERMISSION).send(sender);
                // Logs to console when a player does not have the permission (might make this toggleable in the config later)
                log("&4" + sender.getName() + " &4does not have the permission &c" + perm);
                return true;
            }
        }
        /*
          Executes the command
         */
        this.execute(sender, label, args);
        return true;
    }

    /**
     * @param s - String-name of the player we are trying to sfind
     * @return - Returns whether or not the player has been found
     */
    public boolean findPlayer(String s) {
        Player target = Bukkit.getPlayer(s);
        return target != null;
    }

    /**
     * @param player - Player
     * @return - Returns whether or not the player is in vanish
     */
    public boolean isVanished(Player player) {
        return VanishAPI.isInvisible(player);
    }

    /**
     * @param sender - Sender of the command. Usually a player
     * @param perm   - Permission node
     * @return - Returns whether or not the player has the permission provided in the "perm" String
     */
    public boolean hasPermission(CommandSender sender, String perm) {
        return sender.hasPermission(perm);
    }

    /**
     * @param sender - Sender of the command
     * @param label  - Label
     * @param args   - Arguments
     */
    public abstract void execute(CommandSender sender, String label, String[] args);

}
