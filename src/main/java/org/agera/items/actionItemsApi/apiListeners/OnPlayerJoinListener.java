package org.agera.items.actionItemsApi.apiListeners;

import org.agera.items.actionItemsApi.sql.SqlConnector;
import org.agera.items.actionItemsApi.sql.StatsTableEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class OnPlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoinListener(PlayerJoinEvent event) {
        SqlConnector sqlMethods = new SqlConnector();
        List<StatsTableEntity> tableEntities = sqlMethods.getDataFromTable();
        boolean isequals = false;
        for (StatsTableEntity statsTable : tableEntities) {
            if (statsTable.getPlayerDisplayName().equals(event.getPlayer().getDisplayName())) {
                isequals = true;
            }
        }
        if (!isequals) {
            StatsTableEntity newPlayerStats = new StatsTableEntity(event.getPlayer().getDisplayName(), event.getPlayer().getUniqueId().toString(), 0, 0, 0, 0);
            sqlMethods.setDataToTable(newPlayerStats);
        }


        sqlMethods.closeConnection();
    }
}
