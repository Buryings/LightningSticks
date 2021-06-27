package me.buryings.lightningsticks.commands.subcommands;

import dev.negativekb.baseplugin.ui.commands.ISubCommand;
import me.buryings.lightningsticks.Messages;
import me.buryings.lightningsticks.util.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SubGive extends ISubCommand {
    public SubGive() {
        super("give");

        setPermission("lightningsticks.admin");
    }

    @Override
    public void runCommand(CommandSender sender, String[] args) {
        if (args.length < 2) {
            Messages.GIVE_ARGUMENTS.send(sender); // requires a player and an amount
            return;
        }

        String p = args[0]; // player
        String a = args[1]; // amount

        Player player = Bukkit.getPlayer(p);
        if (player == null) {
            Messages.INVALID_PLAYER.replace("%player%", p).send(sender);
            return;
        }

        int amount;
        try {
            amount = Integer.parseInt(a);

            if (amount < 1) {
                Messages.USE_NUMBER.send(sender);
                return;
            }
        } catch (Exception e) {
            Messages.USE_NUMBER.send(sender);
            return;
        }

        for (int i = 0; i < amount; i++) {
            player.getInventory().addItem(ItemManager.getLightningStick());
        }

        Messages.GIVE_SENDER.replace("%amount%", amount).replace("%player%", player.getName()).replace("%s%", (amount == 1 ? "" : "s"))
                .send(sender);

        Messages.GIVE_RECEIVER.replace("%player%", (sender instanceof Player ? sender.getName() : "Console"))
                .replace("%amount%", amount).replace("%s%", (amount == 1 ? "" : "s"))
                .send(player);


    }
}
