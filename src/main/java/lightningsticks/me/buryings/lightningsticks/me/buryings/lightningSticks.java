package lightningsticks.me.buryings.lightningsticks.me.buryings;

import lightningsticks.me.buryings.lightningsticks.me.buryings.commands.lsgive;
import org.bukkit.plugin.java.JavaPlugin;
import static lightningsticks.me.buryings.lightningsticks.me.buryings.utils.CoreUtils.log;

public final class lightningSticks extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        log("Starting plugin");
        registerCommands();
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
}
