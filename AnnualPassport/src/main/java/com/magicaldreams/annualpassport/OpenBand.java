package com.magicaldreams.annualpassport;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class OpenBand implements Listener {
    private static Main main;

    public OpenBand(Main main) {
        // TODO Auto-generated constructor stub

        this.main = main;
    }


    ItemStack JoinMB;
    ItemMeta JoinMBMeta;
    @EventHandler
    public void MBJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();

        JoinMB = new ItemStack(Material.PAPER);

        JoinMBMeta = JoinMB.getItemMeta();
        JoinMBMeta.setDisplayName(ChatColor.BLUE + player.getName() + "'s Annual Passport");

        JoinMB.setItemMeta(JoinMBMeta);

        player.getInventory().setItem(0, JoinMB);


    }




    @SuppressWarnings({ "deprecation", "unlikely-arg-type" })
    @EventHandler
    public static void PlayerMB(PlayerInteractEvent e){
        Action action = e.getAction();
        Player player = (Player) e.getPlayer();
        Player p = e.getPlayer();
        Action item = e.getAction();

        if(p.getItemInHand().getType() == Material.PAPER) {
        	if(action.equals(Action.PHYSICAL)) {
	        	return;
	        }

            ((Player) player).playSound(((OfflinePlayer) player).getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 2.0F, 1.0F);

            Main.applyMagicBandUI((Player) player);

        }
    }


    @SuppressWarnings("deprecation")
    @EventHandler
    public void MBonClick(InventoryClickEvent e) throws IOException, URISyntaxException {

        Player player = (Player) e.getWhoClicked();


        if( e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Annual Passport")) {

            if(e.getCurrentItem() != null) {
                e.setCancelled(true);
                switch (e.getCurrentItem().getType()) {

                    case PLAYER_HEAD:
                   main.applyPlayerUI((Player) player);

                        

                        break;
                    case BARRIER:
                        player.sendMessage(ChatColor.YELLOW
                                + "Click this link to Report/Issue: https://docs.google.com/forms/d/e/1FAIpQLSf-7fXP9KbaQ6FcpzPaqBA7eeqtBIr1mc0cfxFtQmHMBNp_dg/viewform");
                        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "-------------------- " + player.getName() + " has to report something --------------------");
                        player.sendMessage(ChatColor.RED + "The staff has been notified of your issue!(Shows up in console log)");
                        player.closeInventory();

                        break;
                    case NETHER_STAR:
                        main.applyParksUI((Player) player);

                        break;
                    case MINECART:
                    				
                    	
                    	break;
                    case FIREWORK_ROCKET:
                    	 main.applyShowTimesUI((Player) player);


                        break;
                    default:
                        return;

                }
            }

        }


    }
    
    @SuppressWarnings("deprecation")
    @EventHandler
    public void PlayerClick(InventoryClickEvent e) throws IOException, URISyntaxException {

        Player player = (Player) e.getWhoClicked();


        if( e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Player Settings")) {

            if(e.getCurrentItem() != null) {
                e.setCancelled(true);
                switch (e.getCurrentItem().getType()) {
                
                case PAPER:
                    Main.applyMagicBandUI((Player) player);
                    
                    break;
                case JUKEBOX:

                    
                    break;
                case BOOK:
                    player.sendMessage(ChatColor.YELLOW
                            + "Click this link to Report/Issue: https://docs.google.com/forms/d/e/1FAIpQLSf-7fXP9KbaQ6FcpzPaqBA7eeqtBIr1mc0cfxFtQmHMBNp_dg/viewform");
                    Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "-------------------- " + player.getName() + " has to report something --------------------");
                    player.sendMessage(ChatColor.RED + "The staff has been notified of your issue!(Shows up in console log)");
                    player.closeInventory();
                    
                    break;
                case CHEST:
                	
                	player.setResourcePack("https://github.com/chums122/Resource-Pack/raw/master/Archives/Development/md314alpha.zip");
                	
                    break;
                case SCUTE:
                	
                    break;
                case ACACIA_SIGN:
                	
                    break;
                case SUNFLOWER:
                	Main.applytimeUI((Player) player);
                 
                break;
            default:
                return;
                }
            }
        }
                }
    
    @EventHandler
    public void timeclick(InventoryClickEvent e) {
    	
    	Player player = (Player) e.getWhoClicked();
    	
    	if( e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Time")) {
            if(e.getCurrentItem() != null) {
                e.setCancelled(true);
                switch (e.getCurrentItem().getType()) {
    		case YELLOW_DYE:
    			player.setPlayerTime(1000, false);
            break;
    		case ORANGE_DYE:
    			player.setPlayerTime(7000, false);
            break;
    		case LAPIS_LAZULI:
    			player.setPlayerTime(14000, false);
            break;
    		case PAPER:
    			Main.applyPlayerUI((Player) player);
            break;
        default:
            return;
    	}
            }
    	}
    }
    
    	
    
    @EventHandler
    public void STonClick(InventoryClickEvent e) {
    	
    	Player player = (Player) e.getWhoClicked();
    	
    	if( e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Show Times")) {

            if(e.getCurrentItem() != null) {
                e.setCancelled(true);
                switch (e.getCurrentItem().getType()) {
                
                case PAPER: 
                    Main.applyMagicBandUI((Player) player);
                
                
                break;
            default:
                return;
                }
            	}
                }
    	
    }

    @EventHandler
    public void ParksonClick(InventoryClickEvent e) {



        Player player = (Player) e.getWhoClicked();


        if( e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Parks")) {

            if(e.getCurrentItem() != null) {
                e.setCancelled(true);
                switch (e.getCurrentItem().getType()) {
                    case PAPER:
                        Main.applyMagicBandUI((Player) player);

                        break;
                    case TROPICAL_FISH:
                        player.performCommand("join swsa");
                        player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: SWSA");
                        player.closeInventory();

                        break;
                    case DIAMOND_HOE:
                        player.performCommand("join dlr");
                        player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: DLR");
                        player.closeInventory();

                        break;
                    case DIAMOND_PICKAXE:
                        player.performCommand("join creative");
                        player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: Creative");
                        player.closeInventory();

                        break;
                    case POTATO:
                        player.performCommand("join tdr");
                        player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: TDR");
                        player.closeInventory();

                        break;
                    case ENCHANTED_BOOK:
                        player.performCommand("join hub");
                        player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: HUB");
                        player.closeInventory();

                        break;
                    case GOLDEN_PICKAXE:
                        player.performCommand("join custom");
                        player.sendMessage(ChatColor.YELLOW + "Attempting to send you to: Custom");
                        player.closeInventory();

                        break;
                    default:
                        return;
                }
            }

        }

    }
      
    
    @EventHandler
    public void AttractionsDLRClick(InventoryClickEvent e) {



        Player player = (Player) e.getWhoClicked();


        if( e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Attractions: NULL")) {

            if(e.getCurrentItem() != null) {
                e.setCancelled(true);
                switch (e.getCurrentItem().getType()) {
                case PAPER:
                    Main.applyMagicBandUI((Player) player);
                	
                    break;
                default:
                    return;
                }
            }
        }
    }
                



}