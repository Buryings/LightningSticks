package lightningsticks.me.buryings.lightningsticks.Me.buryings.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class itemBuilder {

    ItemStack itemStack;
    ItemMeta itemMeta;
    SkullMeta skullMeta;

    //Constructor
    public itemBuilder(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public itemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = this.itemStack.getItemMeta();
    }

    //Basics
    public itemBuilder setMaterial(Material material) {
        itemStack.setType(material);
        return this;
    }
    @SuppressWarnings("deprecation")
    public itemBuilder setSubid(byte subid) {
        itemStack.getData().setData(subid);
        return this;
    }
    public itemBuilder setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }
    public itemBuilder setname(String name) {
        this.itemMeta.setDisplayName(name);
        return this;
    }
    public itemBuilder setDurability(short durability) {
        itemStack.setDurability(durability);
        return this;
    }

    //ENCHANTMENTS

    public itemBuilder setEnchantments(Map<Enchantment, Integer> enchantments) {
        enchantments.forEach((enchantment, level) -> this.itemStack.addEnchantment(enchantment, level));
        return this;
    }
    public itemBuilder addEnchantments(Enchantment enchantment, Integer level) {
        this.itemStack.addEnchantment(enchantment, level);
        return this;
    }
    public itemBuilder clearEnchantments() {
        this.itemStack.getEnchantments().keySet().forEach(enchantment -> this.itemStack.removeEnchantment(enchantment));
        return this;
    }
    public itemBuilder removeEnchantments(Enchantment enchantment) {
        this.itemStack.removeEnchantment(enchantment);
        return this;
    }

    //LORES

    public itemBuilder setLore(List<String> lore) {
        itemMeta.setLore(lore);
        return this;
    }
    public itemBuilder addLore(String lore) {
        List<String> loreList = itemMeta.getLore();
        loreList.add(lore);
        itemMeta.setLore(loreList);
        return this;
    }

    public itemBuilder clearLore() {
        itemMeta.setLore(new ArrayList<>());
        return this;
    }
    public itemBuilder removeLore(String lore) {
        itemMeta.getLore().remove(lore);
        return this;
    }

    //SKULL
    public itemBuilder setSkullOwner(String owner) {
        itemStack.setItemMeta(itemMeta);
        skullMeta = (SkullMeta) itemStack.getItemMeta();
        skullMeta.setOwner(owner);
        return this;
    }

    //BUILD

    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @SuppressWarnings("deprecation")
    public ItemStack buildSkull() {
        itemStack.setItemMeta(skullMeta);
        itemStack.getData().setData((byte) 3);
        return itemStack;
    }
}