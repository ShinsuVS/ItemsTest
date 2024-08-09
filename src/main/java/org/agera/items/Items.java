package org.agera.items;


import org.agera.items.utils.ApiLoader;
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
