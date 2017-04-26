package net.corzdev.tutorialplugin;

import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

import net.corzdev.tutorialplugin.commands.TutorialPluginExecuter;




@Plugin(id = "tutorialplugin", name = "Tutorial Plugin", version = "0.0.1", authors = {"Corz"}, description = "My Sponge tutorial plugin.")

public class TutorialPlugin 
{

	@Inject
	private Logger logger;
	
	
	public Logger getLogger() 
	{
		return logger;
	}
	
	
	
	@Listener
	public void onInitialize(GameInitializationEvent event)
	{
	
		this.getLogger().info("Loading...");
		
		CommandSpec tutorialCommandSpec = CommandSpec.builder()
				.description(Text.of("Says different things based on the source."))
				.executor(new TutorialPluginExecuter())
				.build();
		
		Sponge.getCommandManager().register(this, tutorialCommandSpec, Lists.newArrayList("tutorial", "tut", "Tutorial"));
		
		this.getLogger().info("Enabled");
		
	}
	
	
	
	
}
