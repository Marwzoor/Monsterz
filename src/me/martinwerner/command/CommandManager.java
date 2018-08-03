package me.martinwerner.command;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
	
	private static Map<String, Command> commands = new HashMap<String, Command>();
	
	public static void registerCommand(String name, Command command) {
		commands.put(name.toLowerCase(), command);
	}
	
	public static Command getCommandByName(String command) {
		return commands.get(command.toLowerCase());
	}
	
}
