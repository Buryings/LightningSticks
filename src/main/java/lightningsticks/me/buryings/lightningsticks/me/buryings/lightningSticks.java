package lightningsticks.me.buryings.lightningsticks.me.buryings;

import lightningsticks.me.buryings.lightningsticks.me.buryings.commands.lsgive;
import org.bukkit.plugin.java.JavaPlugin;
import static lightningsticks.me.buryings.lightningsticks.me.buryings.utils.CoreUtils.log;

public final class lightningSticks extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        log("Loading commands");
        registerCommands();
        log("Lightning Sticks has started");
    }

    @Override
    public void onDisable() {
        super.onDisable();
        log("Lightning Sticks is shutting down");
    }

    private void registerCommands() {
        new lsgive();
    }
}
