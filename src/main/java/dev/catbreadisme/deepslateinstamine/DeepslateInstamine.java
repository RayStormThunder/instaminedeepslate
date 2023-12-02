package dev.catbreadisme.deepslateinstamine;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.potion.PotionEffectType;

public final class DeepslateInstamine extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent event){

        Material block = event.getBlock().getType();
        ItemStack item = event.getItemInHand();
        Player player = event.getPlayer();

        if (block == Material.DEEPSLATE
                && item.containsEnchantment(Enchantment.DIG_SPEED)
                && item.getEnchantmentLevel(Enchantment.DIG_SPEED) >= 5
                && player.hasPotionEffect(PotionEffectType.FAST_DIGGING)
                && player.getPotionEffect(PotionEffectType.FAST_DIGGING).getAmplifier() >= 1
                && item.getType() == Material.NETHERITE_PICKAXE){
            event.setInstaBreak(true);
        }
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll();
    }

}
