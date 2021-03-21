package me.buryings.lightningsticks;

import me.buryings.lightningsticks.commands.lsgive;
import me.buryings.lightningsticks.events.StrikeLightningEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import static me.buryings.lightningsticks.utils.CoreUtils.log;

public final class LightningSticks extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        log("Starting plugin");
        registerCommands();
        registerListeners();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        getServer().getConsoleSender().sendMessage("LightningSticks disabled");
        log("Stopping plugin");
    }

    private void registerCommands() {
        new lsgive();
    }
    private void registerListeners() {

        Bukkit.getPluginManager().registerEvents(new StrikeLightningEvent(), this);
    }
}
