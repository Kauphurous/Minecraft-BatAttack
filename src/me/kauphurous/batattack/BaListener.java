package me.kauphurous.batattack;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class BaListener implements Listener 
{
	static BatAttack plugin;
	static HashMap<Bat,Boolean> BatToggle = new HashMap<Bat,Boolean>();
	
	public BaListener(BatAttack instance)
	{
		plugin = instance;
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerMove(PlayerMoveEvent event)
	{
		Player player = event.getPlayer();
		Location playerLocation = player.getLocation();
		
		for(Entity entity : playerLocation.getWorld().getEntities())
		{
			if(entity instanceof Bat)
			{
				Bat bat = (Bat)entity;
				if(isInSphere(playerLocation, bat.getLocation()))
				{
					BatToggle.put(bat, true);
				}
				else
				{
					BatToggle.put(bat, false);
				}
			}
		}
	}
	
	public boolean isInSphere(Location center, Location location)
	{
		int sphereRadius = 30;
		if(center.distance(location) <= sphereRadius) return true;
		else return false;
	}
	
	
	
	
}

