package lightningsticks.me.buryings;

import lightningsticks.me.buryings.commands.lsgive;
import lightningsticks.me.buryings.utils.CoreUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class LightningSticky extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        CoreUtils.log("Loading commands");
        registerCommands();
        CoreUtils.log("Lightning Sticks has started");
    }

    @Override
    public void onDisable() {
        super.onDisable();
        CoreUtils.log("Lightning Sticks is shutting down");
    }

    private void registerCommands() {
        new lsgive();
    }
}
