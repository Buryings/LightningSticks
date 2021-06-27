package me.buryings.lightningsticks;

import dev.negativekb.baseplugin.util.ConfigUtils;
import dev.negativekb.baseplugin.util.Message;
import org.bukkit.configuration.file.FileConfiguration;

public class Messages {

    private static final FileConfiguration config = new ConfigUtils("messages").getConfig();

    // General
    public static Message INVALID_PLAYER = new Message(config.getString("INVALID_PLAYER"));
    public static Message USE_NUMBER = new Message(config.getString("USE_NUMBER"));

    // Give
    public static Message GIVE_ARGUMENTS = new Message(config.getString("GIVE_ARGUMENTS"));
    public static Message GIVE_SENDER = new Message(config.getString("GIVE_SENDER"));
    public static Message GIVE_RECEIVER = new Message(config.getString("GIVE_RECEIVER"));

    // GiveAll
    public static Message GIVEALL_ARGUMENTS = new Message(config.getString("GIVEALL_ARGUMENTS"));
    public static Message GIVEALL_SENDER = new Message(config.getString("GIVEALL_SENDER"));
    public static Message GIVEALL_RECEIVER = new Message(config.getString("GIVEALL_RECEIVER"));

    // Reload
    public static Message RELOADED = new Message(config.getString("RELOADED"));
}
