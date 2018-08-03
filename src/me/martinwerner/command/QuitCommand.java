package me.martinwerner.command;

import me.martinwerner.util.TextUtil;

public class QuitCommand extends Command {

	public QuitCommand() {
		super("quit", true);
	}

	public boolean execute(String args[]) {
		TextUtil.displayTextLine("Goodbye! Thanks for stopping by.");
		
		System.exit(0);
		
		return true;
	}
	
}
