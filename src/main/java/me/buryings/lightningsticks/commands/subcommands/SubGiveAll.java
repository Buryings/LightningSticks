package me.buryings.lightningsticks.commands.subcommands;

import dev.negativekb.baseplugin.ui.commands.ISubCommand;
import me.buryings.lightningsticks.Messages;
import me.buryings.lightningsticks.util.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class SubGiveAll extends ISubCommand {
    public SubGiveAll() {
        super("giveall");

        setPermission("lightningsticks.admin");
    }

    @Override
    public void runCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {
            Messages.GIVEALL_ARGUMENTS.send(sender); // requires an amount
            return;
        }

        String a = args[0]; // amount

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
            Bukkit.getOnlinePlayers().forEach(player -> player.getInventory().addItem(ItemManager.getLightningStick()));
        }

        Messages.GIVEALL_SENDER.replace("%amount%", amount).replace("%s%", (amount == 1 ? "" : "s"))
                .send(sender);

        Bukkit.getOnlinePlayers().forEach(player ->
                Messages.GIVEALL_RECEIVER.replace("%player%", (sender instanceof Player ? sender.getName() : "Console"))
                .replace("%amount%", amount).replace("%s%", (amount == 1 ? "" : "s"))
                .send(player)
        );
    }
}
