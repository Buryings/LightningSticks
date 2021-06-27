package me.buryings.lightningsticks.util;

import dev.negativekb.baseplugin.util.builder.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemManager {

    public static ItemStack getLightningStick() {
        return new ItemBuilder(Material.BLAZE_ROD)
                .setName("&6&lLIGHTNING STICK")
                .addLoreLine("&6Right-Click &7to zap someone!")
                .build();
    }
}
