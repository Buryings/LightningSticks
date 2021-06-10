package me.buryings.lightningsticks;

import me.buryings.lightningsticks.commands.LightningsticksGive;
import me.buryings.lightningsticks.commands.LightningsticksRemove;
import me.buryings.lightningsticks.events.StrikeLightningEvent;
import me.buryings.lightningsticks.utils.PluginUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LightningSticks extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        PluginUtils.log("Loading commands");
        registerCommands();
        registerListeners();
        PluginUtils.log("Lightning Sticks has started");
    }

    @Override
    public void onDisable() {
        super.onDisable();
        PluginUtils.log("Lightning Sticks is shutting down");
    }

    private void registerCommands() {
        new LightningsticksGive();
        new LightningsticksRemove();
    }
    private void registerListeners() {

        Bukkit.getPluginManager().registerEvents(new StrikeLightningEvent(), this);
    }
}
