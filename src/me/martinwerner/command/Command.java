package me.martinwerner.command;

public abstract class Command {

	private final boolean endsTurn;
	private final String command;
	
	public Command(String command, boolean endsTurn) {
		this.command = command;
		this.endsTurn = true;
	}
	
	public String getCommand() {
		return this.command;
	}
	
	public boolean willEndTurn() {
		return this.endsTurn;
	}

	public abstract boolean execute(String args[]);
	
}
