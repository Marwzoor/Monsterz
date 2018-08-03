package me.martinwerner.command;

import me.martinwerner.Monsterz;
import me.martinwerner.entity.Player;

public class StatsCommand extends Command {

	public StatsCommand() {
		super("stats", false);
	}

	public boolean execute(String args[]) {
		Player player = Monsterz.getPlayer();
		
		System.out.println("HP: " + player.getHealth());
		
		return true;
	}
	
}
