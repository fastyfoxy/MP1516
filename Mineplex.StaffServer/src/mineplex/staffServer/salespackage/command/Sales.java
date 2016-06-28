package mineplex.staffServer.salespackage.command;

import org.bukkit.entity.Player;

import mineplex.core.command.MultiCommandBase;
import mineplex.core.common.Rank;
import mineplex.staffServer.salespackage.SalesPackageManager;

public class Sales extends MultiCommandBase<SalesPackageManager>
{
	public Sales(SalesPackageManager plugin)
	{
		super(plugin, Rank.MODERATOR, "sales");
		
		AddCommand(new RankCommand(plugin));
		AddCommand(new CoinCommand(plugin));
		AddCommand(new ItemCommand(plugin));
		AddCommand(new GemHunterCommand(plugin));
		AddCommand(new UltraCommand(plugin));
		AddCommand(new HeroCommand(plugin));
		AddCommand(new LifetimeUltraCommand(plugin));
		AddCommand(new LifetimeHeroCommand(plugin));
		AddCommand(new LifetimeLegendCommand(plugin));
		AddCommand(new KitsCommand(plugin));
	}

	@Override
	protected void Help(Player caller, String[] args)
	{
		Plugin.help(caller);
	}
}
