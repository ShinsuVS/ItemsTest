package org.agera.items.ActionItemsApi.Recipe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ExplousinTNTRecipe {

    public static void registerTNTRecipe() {

        ItemStack itemForTNT = new ItemStack(Material.TNT);
        ItemMeta _itemForTNTMeta = itemForTNT.getItemMeta();

        _itemForTNTMeta.setDisplayName(ChatColor.BLUE + "Граната");
        _itemForTNTMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        _itemForTNTMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        itemForTNT.setItemMeta(_itemForTNTMeta);

        ShapelessRecipe recipeForTNT = new ShapelessRecipe(itemForTNT);
        recipeForTNT.addIngredient(4, Material.TNT);
        Bukkit.addRecipe(recipeForTNT);

    }
}
