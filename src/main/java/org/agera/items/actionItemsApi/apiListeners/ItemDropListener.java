package org.agera.items.actionItemsApi.apiListeners;


import org.agera.items.Items;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;


public class ItemDropListener implements Listener {
    public static ArrayList<Item> ExplosionTnt = new ArrayList<>();
    private final Items plugin;

    public ItemDropListener(Items plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDrop(PlayerDropItemEvent event) {
        if (event.getItemDrop().getItemStack().getItemMeta().hasDisplayName()) {
            if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Граната")) {
                ExplosionTnt.add(event.getItemDrop());
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        if (!ExplosionTnt.isEmpty()) {

                            for (Item _item : ExplosionTnt) {
                                if (_item.isOnGround()) {
                                    _item.getWorld().createExplosion(_item.getLocation(), 2);
                                    event.getItemDrop().remove();
                                    ExplosionTnt.clear();
                                    event.setCancelled(true);
                                }
                            }
                        }


                    }
                }.runTaskTimer(plugin, 2, 1);

            }
        }

    }


}

