package nautilus.game.arcade.game.games.oldmineware.random;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import mineplex.core.updater.UpdateType;
import mineplex.core.updater.event.UpdateEvent;
import nautilus.game.arcade.game.games.oldmineware.OldMineWare;
import nautilus.game.arcade.game.games.oldmineware.order.Order;

public class StandWater extends Order 
{
	public StandWater(OldMineWare host) 
	{
		super(host, "Go for a swim");
	}

	@Override
	public void Initialize() 
	{
		
	}

	@Override
	public void Uninitialize()
	{
		
	}

	@Override
	public void FailItems(Player player) 
	{
		
	}
	
	@EventHandler
	public void Update(UpdateEvent event)
	{
		if (event.getType() != UpdateType.FAST)
			return;
		
		for (Player player : Host.GetPlayers(true))
			if (player.getLocation().getBlock().isLiquid())
				SetCompleted(player);
	}
}
