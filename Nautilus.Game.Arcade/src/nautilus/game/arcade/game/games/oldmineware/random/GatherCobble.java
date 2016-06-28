package nautilus.game.arcade.game.games.oldmineware.random;

import nautilus.game.arcade.game.games.oldmineware.OldMineWare;
import nautilus.game.arcade.game.games.oldmineware.order.OrderGather;

public class GatherCobble extends OrderGather
{
	public GatherCobble(OldMineWare host) 
	{
		super(host, "Pick up 10 Cobblestone", 4, -1, 10);
	}

	@Override
	public void Initialize() 
	{
		
	}

	@Override
	public void Uninitialize() 
	{
	
	}
}
