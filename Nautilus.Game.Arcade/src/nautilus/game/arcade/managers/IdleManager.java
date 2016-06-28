package nautilus.game.arcade.managers;

import java.util.HashMap;
import java.util.Map;

import mineplex.core.common.Rank;
import mineplex.core.common.util.C;
import mineplex.core.common.util.UtilPlayer;
import mineplex.core.common.util.UtilServer;
import mineplex.core.common.util.UtilTime;
import mineplex.core.updater.UpdateType;
import mineplex.core.updater.event.UpdateEvent;
import nautilus.game.arcade.ArcadeManager;
import nautilus.game.arcade.game.Game.GameState;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class IdleManager implements Listener
{
	private final ArcadeManager _arcadeManager;
	private final Map<Player, Float> _yaw = new HashMap<>();
	private final Map<Player, Long> _idle = new HashMap<>();
	private final Map<Player, Integer> _beep = new HashMap<>();

	public IdleManager(ArcadeManager manager)
	{
		_arcadeManager = manager;

		Bukkit.getPluginManager().registerEvents(this, getArcadeManager().getPlugin());
	}
	
	@EventHandler
	public void ChatIdle(final AsyncPlayerChatEvent event)
	{
		if (!getArcadeManager().IsPlayerKickIdle())
			return;
		
		Bukkit.getServer().getScheduler().runTaskLater(getArcadeManager().getPlugin(), new Runnable()
		{
			@Override
			public void run()
			{
				_idle.put(event.getPlayer(), System.currentTimeMillis());
			}
		}, 1);
	}

	@EventHandler
	public void kickIdlePlayers(UpdateEvent event)
	{
		if (event.getType() != UpdateType.FAST)
			return;
		
		if (!getArcadeManager().IsPlayerKickIdle())
			return;
		
		if (getArcadeManager().GetGame() == null)
			return;

		for (Player player : UtilServer.getPlayers())
		{
			if (!_yaw.containsKey(player) || !_idle.containsKey(player))
			{
				_yaw.put(player, player.getLocation().getYaw());
				_idle.put(player, System.currentTimeMillis());
			}

			if (_yaw.get(player) == player.getLocation().getYaw())
			{		
				if (UtilTime.elapsed(_idle.get(player), getArcadeManager().GetGame().IsLive() ? 240000 : 120000))
				{
					if (getArcadeManager().GetGame().GetState() != GameState.Recruit && !getArcadeManager().GetGame().IsAlive(player))
						continue;
					
					if (getArcadeManager().GetClients().Get(player).GetRank().Has(Rank.MODERATOR))
						continue;
					
					//Start Beeps
					if (!_beep.containsKey(player))
					{
						_beep.put(player, 20);
					}
					//Countdown
					else
					{
						int count = _beep.get(player);
						
						if (count == 0)
						{
							player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 10f, 1f);
							getArcadeManager().GetPortal().sendPlayerToServer(player, "Lobby");
						}
						else
						{	
							float scale = (float) (0.8 + (((double)count/20d)*1.2));
							player.playSound(player.getLocation(), Sound.NOTE_PLING, scale, scale);
							
							if (count%2 == 0)
							{
								UtilPlayer.message(player, C.cGold + C.Bold + "You will be AFK removed in " + (count/2) + " seconds...");
							}
							
							count--;
							_beep.put(player, count);
						}
					}	
				}
					
				continue;
			}
				
			_yaw.put(player, player.getLocation().getYaw());
			_idle.put(player, System.currentTimeMillis());
			_beep.remove(player);
		}
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event)
	{
		_yaw.remove(event.getPlayer());
		_idle.remove(event.getPlayer());
		_beep.remove(event.getPlayer());
	}

	public ArcadeManager getArcadeManager()
	{
		return _arcadeManager;
	}
}
