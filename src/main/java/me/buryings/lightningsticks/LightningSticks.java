package me.buryings.lightningsticks;

import dev.negativekb.baseplugin.BasePluginAPI;
import dev.negativekb.baseplugin.util.FileUtils;
import me.buryings.lightningsticks.commands.CommandLightningSticks;
import me.buryings.lightningsticks.events.StrikeLightningEvent;
import me.buryings.lightningsticks.util.Log;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class LightningSticks extends JavaPlugin {

    private static LightningSticks instance;

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;
        BasePluginAPI.setPlugin(this);

        loadFile("messages.yml");

        Log.STARTUP.sendLog("Loading commands");
        registerCommands();
        registerListeners();
        Log.STARTUP.sendLog("Lightning Sticks has started!");
    }

    @Override
    public void onDisable() {
        super.onDisable();
        Log.STOPPING.sendLog("Lightning Sticks is shutting down");
    }

    public static LightningSticks getInstance() {
        return instance;
    }

    private void registerCommands() {
        new CommandLightningSticks();
    }
    private void registerListeners() {
        new StrikeLightningEvent();;
    }

    public void loadFile(String name) {
        File file = new File(getDataFolder(), name);
        FileConfiguration fileConfig = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()) {
            FileUtils.loadResource(this, name);
        }

        try {
            fileConfig.load(file);
        } catch (Exception e3) {
            e3.printStackTrace();
        }

        for (String priceString : fileConfig.getKeys(false)) {
            fileConfig.set(priceString, fileConfig.getString(priceString));
        }
    }
}
