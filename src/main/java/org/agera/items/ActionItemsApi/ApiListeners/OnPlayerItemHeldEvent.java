package org.agera.items.ActionItemsApi.ApiListeners;

import org.agera.items.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;


public class OnPlayerItemHeldEvent implements Listener {
    private final Items plugin;
    HashMap<UUID, Integer> runnedBook = new HashMap<>();


    public OnPlayerItemHeldEvent(Items plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerItemHeldEvent(PlayerItemHeldEvent event) {
        try {

            if (event.getPlayer().getInventory().getItem(event.getNewSlot()).getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Гримуар огня")) {
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        event.getPlayer().getWorld().playEffect(event.getPlayer().getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
                        runnedBook.put(event.getPlayer().getUniqueId(), this.getTaskId());
                    }
                }.runTaskTimer(plugin, 0, 1);

            } else {
                if (runnedBook.containsKey(event.getPlayer().getUniqueId())) {
                    Bukkit.getScheduler().cancelTask(runnedBook.get(event.getPlayer().getUniqueId()));
                }

            }


        } catch (Exception e) {
            if (runnedBook.containsKey(event.getPlayer().getUniqueId())) {
                Bukkit.getScheduler().cancelTask(runnedBook.get(event.getPlayer().getUniqueId()));
            }
        }


    }

}
