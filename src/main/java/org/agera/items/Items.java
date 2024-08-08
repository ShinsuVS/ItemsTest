package org.agera.items;


import org.agera.items.ActionItemsApi.ApiListeners.*;
import org.agera.items.ActionItemsApi.Recipe.RecipeLoader;
import org.agera.items.ActionItemsApi.ApiListeners.ItemDropListener;
import org.agera.items.ActionItemsApi.ApiListeners.OnPlayerInteractEvent;
import org.agera.items.ActionItemsApi.ApiListeners.OnPlayerItemHeldEvent;
import org.agera.items.Utils.ApiLoader;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public final class Items extends JavaPlugin {

    @Override
    public void onEnable() {
        ApiLoader loader = new ApiLoader(this);
        loader.loadApi();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
