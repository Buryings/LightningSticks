package lightningsticks.me.buryings.lightningsticks.me.buryings.nms;

import org.bukkit.entity.Player;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;

public class ActionBar {
    private PacketPlayOutChat packet;

    /**
     * @param text - The text that will get sent to the player's screen
     */
    public ActionBar(String text) {
        PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + text + "\"}"), (byte) 2);
        this.packet = packet;
    }

    /**
     * @param p - Sends the actionbar to the player's screen
     */
    public void send(Player p) {
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
    }
}
