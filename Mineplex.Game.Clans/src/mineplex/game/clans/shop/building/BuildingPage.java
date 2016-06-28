package mineplex.game.clans.shop.building;

import org.bukkit.Material;

import mineplex.core.account.CoreClientManager;
import mineplex.core.donation.DonationManager;
import mineplex.core.shop.page.ShopPageBase;
import mineplex.game.clans.clans.ClansManager;
import mineplex.game.clans.shop.PvpItem;
import mineplex.game.clans.shop.PvpShopButton;

public class BuildingPage extends ShopPageBase<ClansManager, BuildingShop>
{
	public BuildingPage(ClansManager plugin, BuildingShop shop, CoreClientManager clientManager, DonationManager donationManager, org.bukkit.entity.Player player)
	{
		super(plugin, shop, clientManager, donationManager, "Building Supplies", player);
		
		buildPage();
	}

	@Override
	protected void buildPage()
	{
		addPvpItem(1, new PvpItem(Material.STONE, (byte)0, 1, "Stone", 25, 64));
		addPvpItem(2, new PvpItem(Material.WOOD, (byte)0, 1, "Wood", 15, 64));
		addPvpItem(3, new PvpItem(Material.BRICK, (byte)0, 1, "Bricks", 30, 64));
		addPvpItem(4, new PvpItem(Material.SANDSTONE, (byte)0, 1, "Sandstone", 30, 64));
	}
	
	public void addPvpItem(int slot, PvpItem item)
	{
		addButton(slot, item, new PvpShopButton<BuildingPage>(this, item));
	}
}
