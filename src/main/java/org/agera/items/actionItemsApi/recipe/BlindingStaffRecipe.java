package org.agera.items.actionItemsApi.recipe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class BlindingStaffRecipe {
    public static void registerBlindingStaffRecipe() {

        ItemStack itemForBlindingStaff = new ItemStack(Material.BLAZE_ROD);
        ItemMeta _itemForBlindingStaffMeta = itemForBlindingStaff.getItemMeta();

        _itemForBlindingStaffMeta.setDisplayName(ChatColor.GOLD + "Ослепляющий посох");
        _itemForBlindingStaffMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        _itemForBlindingStaffMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        itemForBlindingStaff.setItemMeta(_itemForBlindingStaffMeta);

        ShapelessRecipe recipeForTNT = new ShapelessRecipe(itemForBlindingStaff);
        recipeForTNT.addIngredient(4, Material.BLAZE_ROD);
        Bukkit.addRecipe(recipeForTNT);

    }

}
