package mineplex.core.cosmetic;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import mineplex.core.MiniPlugin;
import mineplex.core.account.CoreClientManager;
import mineplex.core.common.util.C;
import mineplex.core.common.util.UtilGear;
import mineplex.core.common.util.UtilInv;
import mineplex.core.common.util.UtilServer;
import mineplex.core.cosmetic.ui.CosmeticShop;
import mineplex.core.donation.DonationManager;
import mineplex.core.gadget.GadgetManager;
import mineplex.core.inventory.InventoryManager;
import mineplex.core.itemstack.ItemStackFactory;
import mineplex.core.mount.MountManager;
import mineplex.core.pet.PetManager;
import mineplex.core.treasure.TreasureManager;

public class CosmeticManager extends MiniPlugin
{
	private InventoryManager _inventoryManager;
	private GadgetManager _gadgetManager;
	private MountManager _mountManager;
	private PetManager _petManager;
	private TreasureManager _treasureManager;
	
	private CosmeticShop _shop;
	
	private boolean _showInterface = true;
	private int _interfaceSlot = 4;

	public CosmeticManager(JavaPlugin plugin, CoreClientManager clientManager, DonationManager donationManager, InventoryManager inventoryManager, GadgetManager gadgetManager, MountManager mountManager, PetManager petManager, TreasureManager treasureManager)
	{
		super("Cosmetic Manager", plugin);
		
		_inventoryManager = inventoryManager;
		_gadgetManager = gadgetManager;
		_mountManager = mountManager;
		_petManager = petManager;
		_treasureManager = treasureManager;
		
		_shop = new CosmeticShop(this, clientManager, donationManager, _moduleName);
	}
	
	public void showInterface(boolean showInterface)
	{
		boolean changed = _showInterface == showInterface;
		
		_showInterface = showInterface;
		
		if (changed)
		{
			for (Player player : Bukkit.getOnlinePlayers())
			{
				if (_showInterface)
					player.getInventory().setItem(_interfaceSlot, ItemStackFactory.Instance.CreateStack(Material.CHEST, (byte)0, 1, ChatColor.RESET + C.cGreen + "Cosmetic Menu"));
				else
					player.getInventory().setItem(_interfaceSlot, null);
			}
		}
	}
	
	@EventHandler 
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		if (!_showInterface)
			return;
				
		giveInterfaceItem(event.getPlayer());
	}
	
	public void giveInterfaceItem(Player player)
	{
		if (!UtilGear.isMat(player.getInventory().getItem(_interfaceSlot), Material.CHEST))
		{
			player.getInventory().setItem(_interfaceSlot, ItemStackFactory.Instance.CreateStack(Material.CHEST, (byte)0, 1, ChatColor.RESET + C.cGreen + "Cosmetic Menu"));
			
			_gadgetManager.redisplayActiveItem(player);
			
			UtilInv.Update(player);
		}
	}
	
	@EventHandler
	public void orderThatChest(final PlayerDropItemEvent event)
	{
		if (!_showInterface)
			return;
		
		if (event.getItemDrop().getItemStack().getType() == Material.CHEST)
		{
			Bukkit.getScheduler().scheduleSyncDelayedTask(getPlugin(), new Runnable()
			{
				public void run()
				{
					if (event.getPlayer().isOnline())
					{
						event.getPlayer().getInventory().remove(Material.CHEST);
						event.getPlayer().getInventory().setItem(_interfaceSlot, ItemStackFactory.Instance.CreateStack(Material.CHEST, (byte)0, 1, ChatColor.RESET + C.cGreen + "Inventory Menu"));
						event.getPlayer().updateInventory();
					}
				}
			});
		}
	}
	
	@EventHandler
	public void openShop(PlayerInteractEvent event)
	{
		if (!_showInterface)
			return;
		
		if (event.hasItem() && event.getItem().getType() == Material.CHEST)
		{
			event.setCancelled(true);

			_shop.attemptShopOpen(event.getPlayer());
		}
	}

	public GadgetManager getGadgetManager()
	{
		return _gadgetManager;
	}
	
	public MountManager getMountManager()
	{
		return _mountManager;
	}
	
	public PetManager getPetManager()
	{
		return _petManager;
	}

	public InventoryManager getInventoryManager()
	{
		return _inventoryManager;
	}

	public void setInterfaceSlot(int i)
	{
		_interfaceSlot = i;
		
		_gadgetManager.setActiveItemSlot(i-1);
	}

	public void setActive(boolean showInterface)
	{
		_showInterface = showInterface;

		if (!showInterface)
		{
			for (Player player : UtilServer.getPlayers())
			{
				if (player.getOpenInventory().getTopInventory().getHolder() != player)
				{
					player.closeInventory();
				}
			}
		}
	}

	public void disableItemsForGame()
	{
		_gadgetManager.DisableAll();
		_mountManager.DisableAll();
		_petManager.DisableAll();
	}

	public void setHideParticles(boolean b)
	{
		_gadgetManager.setHideParticles(b);
	}

	public boolean isShowingInterface()
	{
		return _showInterface;
	}

	public TreasureManager getTreasureManager()
	{
		return _treasureManager;
	}
}
