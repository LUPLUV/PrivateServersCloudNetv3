package de.lupu.psm.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryManager {

    public Inventory getMainInventory(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*6, "§8➥ §6Privater Server");

        Item head = new Item(Material.PLAYER_HEAD);
        head.setSkullOwner(p.getName());
        head.setDisplayName("§8➨ §cPrivate Server Manager");

        Item start = new Item(Material.LIME_DYE);

        return inv;

    }

}
