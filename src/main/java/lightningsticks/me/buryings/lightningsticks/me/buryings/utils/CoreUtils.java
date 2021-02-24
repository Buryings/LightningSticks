package lightningsticks.me.buryings.lightningsticks.me.buryings.utils;

import lightningsticks.me.buryings.lightningsticks.me.buryings.nms.ActionBar;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CoreUtils {

    public static void log(String s) {
        System.out.println(ChatColor.translateAlternateColorCodes('&', "[Lightning Sticks] " + s));
    }

    public static String translateColorCodes(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static void sendTitle(Player p, String header, String footer) {
        p.sendTitle(translateColorCodes(header), translateColorCodes(footer));
    }

    public static void sendActionBar(Player p, String message) {
        ActionBar bar = new ActionBar(translateColorCodes(message));
        bar.send(p);
    }

    public static void playerEffect(Player p, Location l, Effect e) {
        p.playEffect(l, e, true);
    }

    public static void worldEffect(Location l, Effect e) {
        l.getWorld().playEffect(l, e, true);
    }

    public static void applyPotionEffect(Player p, PotionEffectType t, int d, int a) {
        if (p.hasPotionEffect(t)) {
            p.removePotionEffect(t);
        }
        p.addPotionEffect(new PotionEffect(t, 20 * d, a - 1));
    }

    public static void applyPotionEffect(LivingEntity e, PotionEffectType t, int d, int a) {
        if (e.hasPotionEffect(t)) {
            e.removePotionEffect(t);
        }
        e.addPotionEffect(new PotionEffect(t, 20 * d, a - 1));
    }
}
