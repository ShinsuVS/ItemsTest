package org.agera.items.utils;

import org.agera.items.actionItemsApi.apiListeners.*;
import org.agera.items.actionItemsApi.recipe.BlindingStaffRecipe;
import org.agera.items.actionItemsApi.recipe.ExplousinTNTRecipe;
import org.agera.items.actionItemsApi.recipe.GrimoireOfFireRecipe;
import org.agera.items.actionItemsApi.sql.SqlConnector;
import org.agera.items.Items;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ApiLoader {

    private Plugin plugin;
    public ApiLoader(Plugin plugin){
        this.plugin = plugin;
    }
    public void loadApi(){

            loadListeners();
            loadRecipe();
            SqlConnector mySql = new SqlConnector();
            mySql.testConnection();

    }

    public void loadListeners(){
        try {
            PluginManager pm = Bukkit.getServer().getPluginManager();
            pm.registerEvents(new ItemDropListener((Items) plugin), plugin);
            pm.registerEvents(new OnPlayerInteractEvent(), plugin);
            pm.registerEvents(new OnPlayerItemHeldEvent((Items) plugin), plugin);
            pm.registerEvents(new OnPlayerJoinListener(), plugin);
            pm.registerEvents(new OnCraftActionItemListener(), plugin);
            pm.registerEvents(new OnPickupActionItemListener(), plugin);
            pm.registerEvents(new OnDropActionItemListener(), plugin);
            pm.registerEvents(new OnBurningActionItemListener((Items) plugin), plugin);
            CodeUtils.logToConsole("All recipe load listeners! ");
        }catch (Exception e){
            CodeUtils.logToConsole("Error loading listeners :  " + e.getMessage());
        }

    }
    public static void loadRecipe() {

        try {
            BlindingStaffRecipe.registerBlindingStaffRecipe();
            ExplousinTNTRecipe.registerTNTRecipe();
            GrimoireOfFireRecipe.registerGrimoireOfFireRecipe();
            CodeUtils.logToConsole("All recipe load correct! ");

        } catch (Exception e) {
            CodeUtils.logToConsole("Error loading recipes :  " + e.getMessage());
        }


    }


}
