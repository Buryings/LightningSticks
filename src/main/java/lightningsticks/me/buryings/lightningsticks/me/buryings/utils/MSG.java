package lightningsticks.me.buryings.lightningsticks.me.buryings.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MSG {

    String message;
    List<String> messageList;

    public MSG(String s) {
        this.message = s;
    }

    public MSG(List<String> s) {
        this.messageList = s;
    }


    public MSG replace(Object o1, Object o2) {
        if (o2 instanceof Integer || o2 instanceof Double || o2 instanceof Long) {
            DecimalFormat df = new DecimalFormat("###,###,###,###,###,###,###,###.##");
            o2 = df.format(o2);
        }
        if (this.message == null) {
            List<String> newMSG = new ArrayList<>();
            for (String msg : messageList) {
                msg = msg.replaceAll(String.valueOf(o1), String.valueOf(o2));
                newMSG.add(msg);
            }

            this.messageList = newMSG;
            return this;
        }
        String newMSG = this.message;

        newMSG = newMSG.replaceAll(String.valueOf(o1), String.valueOf(o2));

        this.message = newMSG;
        return this;
    }

    public Object getString() {
        if (this.message == null) {
            return messageList;
        }

        return this.message;
    }

    public void send(CommandSender sender) {
        if (this.message == null) {
            for (String msg : messageList) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }
            return;
        }
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.message));
    }
}
