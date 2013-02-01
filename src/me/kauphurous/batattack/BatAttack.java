package me.kauphurous.batattack;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class BatAttack extends JavaPlugin 
{
	Logger log = Logger.getLogger("Minecraft");
	
	@Override
	public void onEnable()
	{
		info("Welcome");
		new BaScheduler(this);
		
		//creater listener
		getServer().getPluginManager().registerEvents(new BaListener(this), this);
	}
	
	@Override 
	public void onDisable()
	{
		info("Good Bye");
	}
	
	public void info(String message)
	{
		log.info("[BatAttack] " + message);
	}
}
