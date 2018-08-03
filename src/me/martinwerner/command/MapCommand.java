package me.martinwerner.command;

import me.martinwerner.Monsterz;
import me.martinwerner.util.TextColor;
import me.martinwerner.util.TextUtil;

public class MapCommand extends Command {

	public MapCommand() {
		super("map", false);
	}

	public boolean execute(String args[]) {
		TextUtil.displayTextLine("\n" + TextColor.CYAN + Monsterz.getMap().getMapDisplay() + "\n");
		
		return true;
	}
	
	
}
