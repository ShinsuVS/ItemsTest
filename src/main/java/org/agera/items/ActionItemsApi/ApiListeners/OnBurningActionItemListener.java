package org.agera.items.ActionItemsApi.ApiListeners;

import org.agera.items.ActionItemsApi.Sql.SqlConnector;
import org.agera.items.ActionItemsApi.Sql.StatsTableEntity;
import org.agera.items.Items;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.ArrayList;

public class OnBurningActionItemListener implements Listener {
    public static ArrayList<Item> items = new ArrayList<>();
    private final Items plugin;

    public OnBurningActionItemListener(Items plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBurningActionItem(PlayerDropItemEvent event) {
        if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Ослепляющий посох") || event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Гримуар огня") || event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Граната")) {
            items.add(event.getItemDrop());
            new BukkitRunnable() {
                @Override
                public void run() {
                    for (Item _item : items) {
                        if (_item.isDead()) {
                            SqlConnector sqlConnector = new SqlConnector();
                            StatsTableEntity statsTableEntity = sqlConnector.selectDataFromTable(event.getPlayer().getDisplayName());
                            sqlConnector.updateDataFromTable(event.getPlayer().getDisplayName(), "burningActionItem", statsTableEntity.getBurningActionItem() + 1);
                            items.remove(_item);
                            this.cancel();
                        }
                    }
                }
            }.runTaskTimer(plugin, 2, 1);
        }


    }
}
