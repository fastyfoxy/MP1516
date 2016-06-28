package nautilus.game.arcade.kit.perks;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;

import mineplex.core.common.util.C;
import mineplex.core.common.util.F;
import mineplex.core.common.util.UtilAction;
import mineplex.core.common.util.UtilBlock;
import mineplex.core.common.util.UtilEnt;
import mineplex.core.common.util.UtilInv;
import mineplex.core.common.util.UtilParticle;
import mineplex.core.common.util.UtilPlayer;
import mineplex.core.common.util.UtilServer;
import mineplex.core.common.util.UtilParticle.ParticleType;
import mineplex.core.common.util.UtilParticle.ViewDist;
import mineplex.core.itemstack.ItemStackFactory;
import mineplex.core.projectile.IThrown;
import mineplex.core.projectile.ProjectileUser;
import mineplex.core.recharge.Recharge;
import mineplex.core.updater.UpdateType;
import mineplex.minecraft.game.core.damage.CustomDamageEvent;
import nautilus.game.arcade.kit.Perk;
import nautilus.game.arcade.kit.SmashPerk;

public class PerkCreeperSulphurBomb extends SmashPerk implements IThrown
{
	public PerkCreeperSulphurBomb() 
	{
		super("Sulphur Bomb", new String[] 
				{
				C.cYellow + "Right-Click" + C.cGray + " with Axe to use " + C.cGreen + "Sulphur Bomb"
				});
	}


	@EventHandler
	public void ShootWeb(PlayerInteractEvent event)
	{
		if (event.isCancelled())
			return;

		if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK)
			return;

		if (UtilBlock.usable(event.getClickedBlock()))
			return;

		if (event.getPlayer().getItemInHand() == null)
			return;

		if (!event.getPlayer().getItemInHand().getType().toString().contains("_AXE"))
			return;

		Player player = event.getPlayer();

		if (isSuperActive(player))
			return;
		
		if (!Kit.HasKit(player))
			return;

		if (!Recharge.Instance.use(player, GetName(), 3000, true, true))
			return;

		event.setCancelled(true);

		UtilInv.Update(player);

		org.bukkit.entity.Item ent = player.getWorld().dropItem(player.getEyeLocation(), ItemStackFactory.Instance.CreateStack(Material.COAL, (byte)0));

		UtilAction.velocity(ent, player.getLocation().getDirection(), 1, false, 0, 0.2, 10, false);	

		Manager.GetProjectile().AddThrow(ent, player, this, -1, true, true, true, 
				null, 1f, 1f, 
				null, 1, UpdateType.SLOW, 
				0.5f);

		//Inform
		UtilPlayer.message(player, F.main("Game", "You used " + F.skill(GetName()) + "."));

		//Effect
		player.getWorld().playSound(player.getLocation(), Sound.CREEPER_DEATH, 2f, 1.5f);
	}

	@Override
	public void Collide(LivingEntity target, Block block, ProjectileUser data) 
	{
		Explode(data);

		if (target == null)
			return;

		//Damage Event
		Manager.GetDamage().NewDamageEvent(target, data.GetThrower(), null, 
				DamageCause.PROJECTILE, 7, true, true, false,
				UtilEnt.getName(data.GetThrower()), GetName());
	}

	@Override
	public void Idle(ProjectileUser data) 
	{
		Explode(data);
	}

	@Override
	public void Expire(ProjectileUser data) 
	{
		Explode(data);
	}

	public void Explode(ProjectileUser data)
	{
		UtilParticle.PlayParticle(ParticleType.LARGE_EXPLODE, data.GetThrown().getLocation(), 0, 0, 0, 0, 1,
				ViewDist.MAX, UtilServer.getPlayers());
		data.GetThrown().getWorld().playSound(data.GetThrown().getLocation(), Sound.EXPLODE, 1f, 1.5f);
		data.GetThrown().remove();
	}

	@EventHandler
	public void Knockback(CustomDamageEvent event)
	{
		if (event.GetReason() == null || !event.GetReason().contains(GetName()))
			return;

		event.AddKnockback(GetName(), 1.5);
	}
}
