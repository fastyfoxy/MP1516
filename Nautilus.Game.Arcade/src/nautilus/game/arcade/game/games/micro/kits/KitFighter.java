package nautilus.game.arcade.game.games.micro.kits;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import mineplex.core.common.util.C;
import mineplex.core.itemstack.ItemStackFactory;
import nautilus.game.arcade.ArcadeManager;
import nautilus.game.arcade.kit.Kit;
import nautilus.game.arcade.kit.KitAvailability;
import nautilus.game.arcade.kit.Perk;
import nautilus.game.arcade.kit.perks.*;

public class KitFighter extends Kit
{
	public KitFighter(ArcadeManager manager)
	{
		super(manager, "Fighter", KitAvailability.Free, 

				new String[] 
						{
				"HE LIKES TO FIGHT!",
				" ",
				C.cGreen + "Wood Sword",
				C.cGreen + "5 Apples",
						}, 

						new Perk[] 
								{
				new PerkIronSkin(0.5)
								}, 
								EntityType.ZOMBIE,
								new ItemStack(Material.WOOD_SWORD));

	}

	@Override
	public void GiveItems(Player player) 
	{
		player.getInventory().addItem(ItemStackFactory.Instance.CreateStack(Material.WOOD_SWORD));
		player.getInventory().addItem(ItemStackFactory.Instance.CreateStack(Material.APPLE, 5));
	}
}
