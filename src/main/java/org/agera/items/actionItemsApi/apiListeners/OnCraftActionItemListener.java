package org.agera.items.actionItemsApi.apiListeners;

import org.agera.items.actionItemsApi.sql.SqlConnector;
import org.agera.items.actionItemsApi.sql.StatsTableEntity;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class OnCraftActionItemListener implements Listener {
    @EventHandler
    public void onCraftActionItem(CraftItemEvent event) {
        if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Ослепляющий посох") || event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Гримуар огня") || event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Граната")) {
            Player p = (Player) event.getWhoClicked();
            SqlConnector sqlConnector = new SqlConnector();
            StatsTableEntity statsTableEntity = sqlConnector.selectDataFromTable(p.getDisplayName());
            sqlConnector.updateDataFromTable(p.getDisplayName(), "craftedActionItem", statsTableEntity.getCraftedActionItem() + 1);

        }


    }
}
