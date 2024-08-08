package org.agera.items.ActionItemsApi.Recipe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class GrimoireOfFireRecipe {
    public static void registerGrimoireOfFireRecipe() {

        ItemStack itemForGrimoireOfFire = new ItemStack(Material.BOOK);
        ItemMeta _itemForGrimoireOfFireMeta = itemForGrimoireOfFire.getItemMeta();

        _itemForGrimoireOfFireMeta.setDisplayName(ChatColor.DARK_RED + "Гримуар огня");
        _itemForGrimoireOfFireMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        _itemForGrimoireOfFireMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        itemForGrimoireOfFire.setItemMeta(_itemForGrimoireOfFireMeta);

        ShapelessRecipe recipeForTNT = new ShapelessRecipe(itemForGrimoireOfFire);
        recipeForTNT.addIngredient(4, Material.BOOK);
        Bukkit.addRecipe(recipeForTNT);

    }
}
