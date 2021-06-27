package me.buryings.lightningsticks.commands;

import dev.negativekb.baseplugin.ui.commands.ICommand;
import dev.negativekb.baseplugin.util.Message;
import me.buryings.lightningsticks.commands.subcommands.SubGive;
import me.buryings.lightningsticks.commands.subcommands.SubGiveAll;
import me.buryings.lightningsticks.commands.subcommands.SubReload;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandLightningSticks extends ICommand {
    public CommandLightningSticks() {
        super("lightningstick", Arrays.asList("ls", "lightningsticks"));

        addSubCommands(
                new SubGive(),
                new SubGiveAll(),
                new SubReload()
        );
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        List<String> msg = new ArrayList<>();
        msg.add(" ");
        msg.add("&b/lightningstick give <player> <amount> &7- Give Lightning Sticks to a player");
        msg.add("&b/lightningstick giveall <amount> &7- Give everyone Lightning Sticks");
        msg.add("&b/lightningstick reload &7- Reload configuration files");
        msg.add(" ");

        msg.forEach(s -> new Message(s).send(sender));
    }
}
