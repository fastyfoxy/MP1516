package nautilus.game.arcade.game.games.sheep.kits;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import mineplex.core.common.util.C;
import mineplex.core.itemstack.ItemStackFactory;
import nautilus.game.arcade.ArcadeManager;
import nautilus.game.arcade.kit.Kit;
import nautilus.game.arcade.kit.KitAvailability;
import nautilus.game.arcade.kit.Perk;
import nautilus.game.arcade.kit.perks.*;

public class KitBeserker extends Kit
{
	public KitBeserker(ArcadeManager manager)
	{
		super(manager, "Beserker", KitAvailability.Free, 

				new String[] 
						{
				"Agile warrior trained in the ways axe combat."
						}, 

						new Perk[] 
								{ 
				new PerkDoubleJump("Beserker Jump", 1.2, 1.2, true, 8000, true)
								}, 
								EntityType.ZOMBIE,
								new ItemStack(Material.IRON_AXE));
	}

	@Override
	public void GiveItems(Player player) 
	{
		player.getInventory().addItem(ItemStackFactory.Instance.CreateStack(Material.IRON_AXE));
		player.getInventory().addItem(ItemStackFactory.Instance.CreateStack(Material.SADDLE, (byte)0, 1, 
				C.cYellow + C.Bold + "Hold This" + C.cWhite + C.Bold + " - " + C.cGreen + C.Bold + "Grab/Hold Sheep"));
	}
	
	@Override
	public void SpawnCustom(LivingEntity ent) 
	{
		ent.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET));
		ent.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		ent.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
		ent.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
	}
}
