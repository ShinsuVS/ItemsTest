package org.agera.items.ActionItemsApi.ApiListeners;

import org.agera.items.ActionItemsApi.Sql.SqlConnector;
import org.agera.items.ActionItemsApi.Sql.StatsTableEntity;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class OnPickupActionItemListener implements Listener {
    @EventHandler
    public void onActionItemPickup(PlayerPickupItemEvent event) {
        if (event.getItem().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Ослепляющий посох") || event.getItem().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Гримуар огня")) {
            SqlConnector sqlConnector = new SqlConnector();
            StatsTableEntity statsTableEntity = sqlConnector.selectDataFromTable(event.getPlayer().getDisplayName());
            sqlConnector.updateDataFromTable(event.getPlayer().getDisplayName(), "collectedActionItem", statsTableEntity.getCollectedActionItem() + 1);
        }

    }
}
