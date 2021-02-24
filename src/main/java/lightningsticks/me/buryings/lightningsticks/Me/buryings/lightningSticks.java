package lightningsticks.me.buryings.lightningsticks.Me.buryings;

import lightningsticks.me.buryings.lightningsticks.me.buryings.commands.commandLightningsticks;
import org.bukkit.plugin.java.JavaPlugin;

public final class lightningSticks extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("LightningSticks enabled");

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("LightningSticks disabled");
    }

    private void registerCommands() {

        new commandLightningsticks();
    }
}
