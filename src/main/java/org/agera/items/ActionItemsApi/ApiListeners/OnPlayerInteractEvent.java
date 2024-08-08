package org.agera.items.ActionItemsApi.ApiListeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static org.agera.items.Utils.CodeUtils.logToConsole;

public class OnPlayerInteractEvent implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent event) {
        try {
            if (event.getPlayer().getItemInHand().getItemMeta().hasDisplayName() && event.getPlayer().getItemInHand().getItemMeta().hasDisplayName()) {
                if (event.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Ослепляющий посох")) {
                    LivingEntity entity = (LivingEntity) event.getRightClicked();
                    entity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 20));

                }
            }
        } catch (NullPointerException exception) {
            logToConsole("Your hand empty");
        }


        event.setCancelled(true);
    }

}
