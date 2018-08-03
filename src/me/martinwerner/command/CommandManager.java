package me.martinwerner.command;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
	
	private static Map<String, Command> commands = new HashMap<String, Command>();
	
	public static void registerCommand(Command command) {
		commands.put(command.getCommand().toLowerCase(), command);
	}
	
	public static Command getCommandByName(String command) {
		return commands.get(command.toLowerCase());
	}
	
}
