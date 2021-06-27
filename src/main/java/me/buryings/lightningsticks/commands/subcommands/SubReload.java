package me.buryings.lightningsticks.commands.subcommands;

import dev.negativekb.baseplugin.ui.commands.ISubCommand;
import dev.negativekb.baseplugin.util.FileUtils;
import me.buryings.lightningsticks.LightningSticks;
import org.bukkit.command.CommandSender;

public class SubReload extends ISubCommand {
    public SubReload() {
        super("reload");

        setPermission("lightningsticks.admin");
    }

    @Override
    public void runCommand(CommandSender sender, String[] args) {
        FileUtils.loadResource(LightningSticks.getInstance(), "messages.yml");


    }
}
