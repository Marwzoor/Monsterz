package me.martinwerner.command;

import me.martinwerner.Monsterz;
import me.martinwerner.entity.Player;
import me.martinwerner.util.TextUtil;

public class StatsCommand extends Command {

	public StatsCommand() {
		super("stats", false);
	}

	public boolean execute(String args[]) {
		Player player = Monsterz.getPlayer();
		
		TextUtil.displayTextLine("HP: " + player.getHealth());
		
		return true;
	}
	
}
