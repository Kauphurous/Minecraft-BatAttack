package me.kauphurous.batattack;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;

public class BaScheduler
{
	public BaScheduler(BatAttack plugin)
	{
		plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void run()
			{
				for(World world : Bukkit.getServer().getWorlds())
				{
					for(Entity entity : world.getEntities())
					{
						if(entity instanceof Bat)
						{
							Bat bat = (Bat)entity;
							if(BaListener.BatToggle.get(bat) == null) continue;
							if(BaListener.BatToggle.get(bat) == true) bat.throwEgg();
						}
					}
				}
			}
		}, 1, 1);	
	}
}
