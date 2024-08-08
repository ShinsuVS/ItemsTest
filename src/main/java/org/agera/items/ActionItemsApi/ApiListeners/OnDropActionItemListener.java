package org.agera.items.ActionItemsApi.ApiListeners;

import org.agera.items.ActionItemsApi.Sql.SqlConnector;
import org.agera.items.ActionItemsApi.Sql.StatsTableEntity;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class OnDropActionItemListener implements Listener {
    @EventHandler
    public void onDropActioItem(PlayerDropItemEvent event) {
        if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Ослепляющий посох") || event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Гримуар огня") || event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Граната")) {
            SqlConnector sqlConnector = new SqlConnector();
            StatsTableEntity statsTableEntity = sqlConnector.selectDataFromTable(event.getPlayer().getDisplayName());
            sqlConnector.updateDataFromTable(event.getPlayer().getDisplayName(), "droppedActionItem", statsTableEntity.getDroppedActionItem() + 1);
        }
    }
}
