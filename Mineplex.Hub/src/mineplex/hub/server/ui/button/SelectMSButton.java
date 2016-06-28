package mineplex.hub.server.ui.button;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import mineplex.core.shop.item.IButton;
import mineplex.hub.server.ui.ServerGameMenu;

public class SelectMSButton implements IButton
{
	private ServerGameMenu _menu;

	public SelectMSButton(ServerGameMenu menu)
	{
		_menu = menu;
	}

	@Override
	public void onClick(Player player, ClickType clickType)
	{
		_menu.openMS(player);
	}
}
