package nautilus.game.arcade.kit.perks;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import mineplex.core.common.util.C;
import mineplex.core.common.util.UtilBlock;
import mineplex.core.common.util.UtilMath;
import mineplex.core.updater.UpdateType;
import mineplex.core.updater.event.UpdateEvent;
import nautilus.game.arcade.kit.SmashPerk;

public class PerkZombieRot extends SmashPerk
{
	public PerkZombieRot()
	{
		super("Rot", new String[] 
				{
				C.cGray + "Leave a path that slows and prevents jumping.",
				});
	}

	@EventHandler 
	public void SnowAura(UpdateEvent event) 
	{
		if (event.getType() != UpdateType.TICK)
			return;

		for (Player player : Manager.GetGame().GetPlayers(true))
		{	
			if (!Kit.HasKit(player))
				continue;

			//Blocks
			HashMap<Block, Double> blocks = UtilBlock.getInRadius(player.getLocation(), 3);
			for (Block block : blocks.keySet())
			{			
				if (UtilBlock.solid(block.getRelative(BlockFace.UP)))
					continue;
				
				if (!UtilBlock.solid(block))
					continue;
				
				//Snow
				Manager.GetBlockRestore().Add(block, 159, (byte)12, 3000);
			}
		}
		
		for (Player player : Manager.GetGame().GetPlayers(true))
		{
			if (Kit.HasKit(player))
				continue;
			
			if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.STAINED_CLAY ||
				player.getLocation().getBlock().getRelative(BlockFace.DOWN).getData() != 12)
				continue;
			
			Manager.GetCondition().Factory().Slow(GetName(), player, null, 1.9, 1, false, false, false, false);
			Manager.GetCondition().Factory().Jump(GetName(), player, null, 1.9, 244, false, false, false);
		}
	}
}
