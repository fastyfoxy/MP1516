package nautilus.game.arcade.game.games.survivalgames;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mineplex.core.common.util.C;
import mineplex.core.common.util.F;
import mineplex.core.common.util.NautHashMap;
import mineplex.core.common.util.UtilPlayer;
import mineplex.core.common.util.UtilTime;
import mineplex.core.common.util.UtilTime.TimeUnit;
import mineplex.core.recharge.Recharge;
import mineplex.core.updater.UpdateType;
import mineplex.core.updater.event.UpdateEvent;
import nautilus.game.arcade.ArcadeManager;
import nautilus.game.arcade.GameType;
import nautilus.game.arcade.events.GameStateChangeEvent;
import nautilus.game.arcade.game.GameTeam;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TeamSurvivalGames extends SurvivalGames
{

	public boolean ForceTeamSize = true;
	public int PlayersPerTeam = 2;
	public int TeamCount = 0;
	
	private NautHashMap<Player, Player> _teamReqs = new NautHashMap<Player, Player>();

	public TeamSurvivalGames(ArcadeManager manager) 
	{
		super(manager, GameType.SurvivalGamesTeams,
						new String[]
								{
				"Search for chests to find loot",
				"Slaughter your opponents",
				"Stay away from the Deep Freeze!",
				"Last team alive wins!"
								});
		
		this.PlayersPerTeam = 2;
		this.FillTeamsInOrderToCount = 2;
		
		this.SpawnNearAllies = true;
		this.SpawnNearEnemies = true;
		
		this.DamageTeamSelf = false;
		
	}
	
	@EventHandler
	public void CustomTeamGeneration(GameStateChangeEvent event) 
	{	
		if (event.GetState() != GameState.Recruit)
			return;
		
		ArrayList<Location> spawns = this.GetTeamList().get(0).GetSpawns();
		this.GetTeamList().clear();
		
		TeamColors color = TeamColors.DARK_AQUA;
		
		if(!this.ForceTeamSize) 
		{
			for(int i = 1; i <= this.TeamCount; i++)
			{
				color = getNextColor(color);
				GameTeam team = new GameTeam(this, String.valueOf(i), color.getColor(), spawns);
				team.SetVisible(true);
				GetTeamList().add(team);
			}
		}
		else 
		{
			for(int i = 1; i <= Manager.GetPlayerFull() / this.PlayersPerTeam; i++)
			{
				//Got Spawns
				color = getNextColor(color);
				int e = 0;
				for(GameTeam teams : GetTeamList())
				{
					if(teams.GetColor() == color.getColor())
					{
						e++;
						if(getColorName(color.getColor()).length <= e)
						{
							e = 0;
						}
					}
				}
				GameTeam team = new GameTeam(this, getColorName(color.getColor())[e], color.getColor(), spawns, true);
				team.SetVisible(true);
				GetTeamList().add(team);	
			}
		}
	}
	
	private enum TeamColors
	{
	
		YELLOW(ChatColor.YELLOW, new String[]{"Banana", "Sunshine", "Custard", "Sponge", "Star", "Giraffe", "Lego", "Light"}),
		GREEN(ChatColor.GREEN, new String[]{"Creepers", "Alien", "Seaweed", "Emerald", "Grinch", "Shrub", "Snake", "Leaf"}),
		AQUA(ChatColor.AQUA, new String[]{"Diamond", "Ice", "Pool", "Kraken", "Aquatic", "Ocean"}),
		RED(ChatColor.RED, new String[]{"Heart", "Tomato", "Ruby", "Jam", "Rose", "Apple", "TNT"}),
		GOLD(ChatColor.GOLD, new String[]{"Mango", "Foxes", "Sunset", "Nuggets", "Lion", "Desert", "Gapple"}),
		LIGHT_PURPLE(ChatColor.LIGHT_PURPLE, new String[]{"Dream", "Cupcake", "Cake", "Candy", "Unicorn"}),
		DARK_BLUE(ChatColor.DARK_BLUE, new String[]{"Squid", "Lapis", "Sharks", "Galaxy", "Empoleon"}),
		DARK_RED(ChatColor.DARK_RED, new String[]{"Rose", "Apple", "Twizzler", "Rocket", "Blood"}),
		WHITE(ChatColor.WHITE, new String[]{"Ghosts", "Spookies", "Popcorn", "Seagull", "Rice", "Snowman", "Artic"}),
		BLUE(ChatColor.BLUE, new String[]{"Sky", "Whale", "Lake", "Birds", "Bluebird", "Piplup"}),
		DARK_GREEN(ChatColor.DARK_GREEN, new String[]{"Forest", "Zombies", "Cactus", "Slime", "Toxic", "Poison"}),
		DARK_PURPLE(ChatColor.DARK_PURPLE, new String[]{"Amethyst", "Slugs", "Grape", "Witch", "Magic", "Zula"}),
		DARK_AQUA(ChatColor.DARK_AQUA, new String[]{"Snorlax", "Aquatic", "Clam", "Fish"});
		
		private ChatColor color;
		private String[] names;
		
		private TeamColors(ChatColor color, String[] names)
		{
			this.color = color;
			this.names = names;
		}
		
		public ChatColor getColor()
		{
			return color;
		}
		
		public String[] getNames()
		{
			return names;
		}
		
	}
	
	private String[] getColorName(ChatColor color)
	{
		for(TeamColors colors : TeamColors.values())
		{
			if(colors.getColor() == color)
			{
				return colors.getNames();
			}
		}
		return null;
	}
	
	private TeamColors getNextColor(TeamColors color) 
	{
		for(TeamColors colors : TeamColors.values()) {
			if(colors.ordinal() == color.ordinal() + 1)
			{	
				return colors;
			}
		}
		return TeamColors.YELLOW;
	}
	
	@Override
	@EventHandler
	public void ScoreboardUpdate(UpdateEvent event)
	{
		if (event.getType() != UpdateType.FAST)
			return;

		if (GetTeamList().isEmpty())
			return;

		Scoreboard.Reset();

		Scoreboard.WriteBlank();

		Scoreboard.Write(C.cGreen + C.Bold + "Time");
		Scoreboard.Write(UtilTime.convertString(this.getSecondsSinceStart() * 1000, 0, TimeUnit.FIT));

		Scoreboard.WriteBlank();
		Scoreboard.Write(C.cYellow + C.Bold + "Teams");
		
		ArrayList<GameTeam> alive = new ArrayList<GameTeam>();
		for (GameTeam team : GetTeamList())
		{
			if (team.IsTeamAlive())
				alive.add(team);
		}

		if (GetPlayers(true).size() <= 7)
		{
			for (GameTeam team : GetTeamList())
			{
				for (Player player : team.GetPlayers(true))
				{
					Scoreboard.Write(team.GetColor() + player.getName());
				}
			}
		}
		else if (alive.size() <= 7)
		{
			for (GameTeam team : alive)
			{
				Scoreboard.Write(C.cWhite + team.GetPlayers(true).size() + " " + team.GetColor() + team.GetName());
			}
		}
		else
		{
			Scoreboard.Write(C.cWhite + alive.size() + " Alive");
		}

		Scoreboard.WriteBlank();

		if (this.getChestRefillTime() > 0 && this.getDeathMatchTime() > 60)
		{
			Scoreboard.Write(C.cGold + C.Bold + "Chest Refill");
			Scoreboard.Write(UtilTime.convertString(this.getChestRefillTime() * 1000, 0, TimeUnit.FIT));
		}
		else if (this.getDeathMatchTime() > 0)
		{
			Scoreboard.Write(C.cRed + C.Bold + "Deathmatch");
			Scoreboard.Write(UtilTime.convertString(
					Math.min(this.getDeathMatchTime(), this.isDeathMatchTeleported() ? 10 : this.getDeathMatchTime()) * 1000, 0, TimeUnit.FIT));
		}
		else
		{
			Scoreboard.Write(C.cRed + C.Bold + "Game End");
			Scoreboard.Write(UtilTime.convertString(Math.max(0, this.getGameEndTime()) * 1000, 0, TimeUnit.FIT));
		}

		Scoreboard.Draw();
	}

	@Override
	public void EndCheck()
	{
		if (!IsLive())
			return;

		ArrayList<GameTeam> teamsAlive = new ArrayList<GameTeam>();

		for (GameTeam team : this.GetTeamList())
			if (team.GetPlayers(true).size() > 0)
				teamsAlive.add(team);

		if (teamsAlive.size() <= 1)
		{
			//Announce
			if (teamsAlive.size() > 0)
				AnnounceEnd(teamsAlive.get(0));

			for (GameTeam team : GetTeamList())
			{
				if (WinnerTeam != null && team.equals(WinnerTeam))
				{
					for (Player player : team.GetPlayers(false))
						AddGems(player, 10, "Winning Team", false, false);
				}

				for (Player player : team.GetPlayers(false))
					if (player.isOnline())
						AddGems(player, 10, "Participation", false, false);
			}

			//End
			SetState(GameState.End);
		}
	}

	@Override
	public List<Player> getWinners()
	{
		if (WinnerTeam == null)
			return null;

		return WinnerTeam.GetPlayers(false);
	}

	@Override
	public List<Player> getLosers()
	{
		if (WinnerTeam == null)
			return null;

		List<Player> players = new ArrayList<>();

		for (GameTeam team : GetTeamList())
		{
			if (team != WinnerTeam)
				players.addAll(team.GetPlayers(false));
		}

		return players;
	}

	@Override
	public boolean CanJoinTeam(GameTeam team)
	{
		return team.GetSize() < PlayersPerTeam;
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void teamSelectInteract(PlayerInteractEntityEvent event)
	{
		if (GetState() != GameState.Recruit)
			return;
		
		if (event.getRightClicked() == null)
			return;
		
		if (!(event.getRightClicked() instanceof Player))
			return;

		Player player = event.getPlayer();

		//Observer
		if (Manager.IsObserver(player))
		{
			UtilPlayer.message(player, F.main("Game", "Spectators cannot partake in games."));
			return;
		}

		selectTeamMate(player, (Player)event.getRightClicked());
	}
	
	@EventHandler
	public void teamSelectCommand(PlayerCommandPreprocessEvent event)
	{
		if (GetState() != GameState.Recruit)
			return;
				
		if (!event.getMessage().toLowerCase().startsWith("/team "))
			return;
		
		event.setCancelled(true);
		
		Player target = UtilPlayer.searchOnline(event.getPlayer(), event.getMessage().split(" ")[1], true);
		if (target == null)
			return;
		
		//Observer
		if (Manager.IsObserver(event.getPlayer()))
		{
			UtilPlayer.message(event.getPlayer(), F.main("Game", "Spectators cannot partake in games."));
			return;
		}
		
		if (event.getPlayer().equals(target))
			return;
		
		selectTeamMate(event.getPlayer(), target);
	}

	public void selectTeamMate(Player player, Player ally)
	{
		//Accept Invite
		if (_teamReqs.containsKey(ally) && _teamReqs.get(ally).equals(player))
		{
			//Remove Prefs
			_teamReqs.remove(player);
			_teamReqs.remove(ally);
			
			//Inform
			UtilPlayer.message(player, F.main("Game", "You accepted " + ally.getName() + "'s Team Request!"));
			UtilPlayer.message(ally, F.main("Game", player.getName() + " accepted your Team Request!"));
			
			//Leave Old Teams
			if (GetTeam(player) != null)
				GetTeam(player).DisbandTeam();
			
			if (GetTeam(ally) != null)
				GetTeam(ally).DisbandTeam();
				
			//Get Team
			GameTeam team = getEmptyTeam();
			if (team == null)
				return;
			
			//Join Team
			SetPlayerTeam(player, team, true);
			SetPlayerTeam(ally, team, true);			
		}
		//Send Invite
		else
		{
			//Already on Team with Target
			if (GetTeam(player) != null)
				if (GetTeam(player).HasPlayer(ally))
					return;
				
			//Inform Player
			UtilPlayer.message(player, F.main("Game", "You sent a Team Request to " + ally.getName() + "!"));
			
			//Inform Target
			if (Recharge.Instance.use(player, "Team Req " + ally.getName(), 2000, false, false))
			{
				UtilPlayer.message(ally, F.main("Game", player.getName() + " sent you a Team Request!"));
				UtilPlayer.message(ally, F.main("Game", "Type " + F.elem("/team " + player.getName()) + " to accept!"));
			}
			
			//Add Pref
			_teamReqs.put(player, ally);
		}
	}
	
	@EventHandler
	public void teamQuit(PlayerQuitEvent event)
	{
		if (GetState() != GameState.Recruit)
			return;
		
		Player player = event.getPlayer();
		
		if (GetTeam(player) != null)
			GetTeam(player).DisbandTeam();
		
		Iterator<Player> teamIter = _teamReqs.keySet().iterator();
		while (teamIter.hasNext())
		{
			Player sender = teamIter.next();
			if (sender.equals(player) || _teamReqs.get(sender).equals(player))
				teamIter.remove();
		}
	}
	
	public GameTeam getEmptyTeam()
	{
		for (GameTeam team : GetTeamList())
		{
			if (team.GetPlayers(false).isEmpty())
				return team;
		}
		
		return null;
	}
	
	@Override
	public String GetMode()
	{
		return "Team Mode";
	}
}
